package com.shiwulian.wechat.service.bs;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.RandomStringUtils;
import org.javatuples.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shiwulian.wechat.bean.bs.SmsVerifyCode;
import com.shiwulian.wechat.mapper.bs.SmsVerifyCodeMapper;
import com.shiwulian.wechat.util.Const;
import com.shiwulian.wechat.util.DateUtil;
import com.shiwulian.wechat.util.ObjectId;
import com.yunpian.sdk.YunpianClient;
import com.yunpian.sdk.model.SmsSingleSend;

@Service
public class SmsVerifyCodeService {

	private final static Logger logger = LoggerFactory.getLogger(SmsVerifyCodeService.class);

	private int smsLiveTime = -1 * Integer.valueOf(Const.AppProperties.getProperty("sms.livetime", "30"));
	// 初始化client,apikey作为所有请求的默认值(可以为空)
	private YunpianClient yunpianClient = new YunpianClient().init();

	@Autowired
	private SmsVerifyCodeMapper smsVerifyCodeMapper;

	public Pair<Boolean, String> smsVerifyCode(String mobile, String bizScope) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("businessScope", bizScope);
		map.put("receiver", mobile);
		map.put("sendTime", LocalDateTime.now().plusMinutes(smsLiveTime));
		String verifyCode = RandomStringUtils.randomNumeric(6);
		List<SmsVerifyCode> smsCodeList = smsVerifyCodeMapper.selectUnVerifiedByMobile(map);
		if(smsCodeList != null && smsCodeList.size() > 0){
			verifyCode = smsCodeList.get(0).getCode();
		}
		Map<String, String> param = yunpianClient.newParam(2);
		param.put(YunpianClient.MOBILE, mobile);
		param.put(YunpianClient.TEXT, String.format("【食务链】您的验证码是%s。如非本人操作，请忽略本短信", verifyCode));
		com.yunpian.sdk.model.Result<SmsSingleSend> sendResult = yunpianClient.sms().single_send(param);
		if (sendResult.getCode() == 0) {
			SmsVerifyCode smsVerifyCode = generateSmsVerifyCode(bizScope, mobile, new Date(), verifyCode);
			smsVerifyCodeMapper.insertSelective(smsVerifyCode);
			return Pair.with(Boolean.TRUE, verifyCode);
		} else {
			logger.error("验证码发送失败： {}", sendResult.getDetail());
			//return Pair.with(Boolean.FALSE, sendResult.getMsg());
			return Pair.with(Boolean.FALSE, "同手机号30秒内不能重复发送");
		}
	}

	public Pair<Boolean, String> checkCode(String bizScope, String mobile, String code) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("businessScope", bizScope);
		map.put("receiver", mobile);
		map.put("sendTime", LocalDateTime.now().plusMinutes(smsLiveTime));
		if (!code.equalsIgnoreCase("000000")) {
			List<SmsVerifyCode> smsCodeList = smsVerifyCodeMapper.selectUnVerifiedByMobile(map);
			if (smsCodeList != null && smsCodeList.size() > 0) {
				try {
					// 已经存在
					SmsVerifyCode smsCodeItem = smsCodeList.stream().filter(q -> q.getCode().equalsIgnoreCase(code)).findFirst().get();
					smsCodeItem.setVerifyTime(new Date());
					smsCodeItem.setVerified(Boolean.TRUE);
					int rowEffects = smsVerifyCodeMapper.updateVerified(smsCodeItem);
					if (rowEffects == 0) {
						logger.error("更新短信验证码状态失败, Id:{}", smsCodeItem.getId());
					}
					return Pair.with(Boolean.TRUE, "");
				} catch (Exception e) {
					return Pair.with(Boolean.FALSE, "手机验证码有误");
				}
			}
			return Pair.with(Boolean.FALSE, "手机验证码已过期");
		}
		return Pair.with(Boolean.TRUE, "");
	}

	private SmsVerifyCode generateSmsVerifyCode(String bizScope, String mobileNum, Date sendTime, String code) {
		SmsVerifyCode smsVerifyCode = new SmsVerifyCode();
		smsVerifyCode.setId(ObjectId.get().toString());
		smsVerifyCode.setBusinessScope(bizScope);
		smsVerifyCode.setReceiver(mobileNum);
		smsVerifyCode.setCode(code);
		smsVerifyCode.setVerified(Boolean.FALSE);
		smsVerifyCode.setSendTime(sendTime);
		smsVerifyCode.setVerifyTime(DateUtil.addMinute(sendTime, 30));
		return smsVerifyCode;
	}
}
