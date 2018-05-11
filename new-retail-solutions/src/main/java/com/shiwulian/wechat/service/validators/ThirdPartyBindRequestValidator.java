package com.shiwulian.wechat.service.validators;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.javatuples.Pair;

import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;
import com.shiwulian.wechat.bean.bs.User;
import com.shiwulian.wechat.bean.request.ThirdPartyBindRequest;
import com.shiwulian.wechat.service.bs.SmsVerifyCodeService;
import com.shiwulian.wechat.service.bs.UserService;
import com.shiwulian.wechat.util.Const;

public class ThirdPartyBindRequestValidator extends ValidatorHandler<ThirdPartyBindRequest> implements Validator<ThirdPartyBindRequest> {

	private SmsVerifyCodeService smsVerifyCodeService;
	
	private UserService userService;
	
	public ThirdPartyBindRequestValidator(SmsVerifyCodeService smsVerifyCodeService,UserService userService){
		this.userService =  userService;
		this.smsVerifyCodeService = smsVerifyCodeService;
	}
	
	@Override
	public boolean validate(ValidatorContext context, ThirdPartyBindRequest request) {
		if (StringUtils.isBlank(request.getMobile())) {
			context.addErrorMsg("手机号不能为空");
			return false;
		}
		if (StringUtils.isBlank(request.getPassword())) {
			context.addErrorMsg("密码不能为空");
			return false;
		}
		if (StringUtils.isBlank(request.getVerifyCode())) {
			context.addErrorMsg("验证码不能为空");
			return false;
		}
		User user = userService.selectByMobile(request.getMobile());
		String password = DigestUtils.sha256Hex(request.getPassword());
		if(user == null || user.getUserType() != 1 || !user.getPassword().equals(password)){
			context.addErrorMsg("手机号/密码错误 ");
			return false;
		}
		if(!user.getValid()){
			context.addErrorMsg("账号已禁用");
			return false;
		}
		Pair<Boolean, String> pair = smsVerifyCodeService.checkCode("WeChatLogin", request.getMobile(), request.getVerifyCode());
		if(!pair.getValue0()){
			context.addErrorMsg(pair.getValue1());
			return false;
		}		
		Const.validatorResultToken.put(context.getAttribute("validatorCallback", String.class), user.getId());
		return true;
	}
}
