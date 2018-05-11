package com.shiwulian.wechat.core.wechat;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.StringUtils;
import org.javatuples.Triplet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiwulian.wechat.bean.bs.User;
import com.shiwulian.wechat.bean.bs.UserOauth;
import com.shiwulian.wechat.core.wechat.bean.Oath2AccessTokenResult;
import com.shiwulian.wechat.core.wechat.bean.ThirdPartyCallBackResult;
import com.shiwulian.wechat.mapper.bs.UserMapper;
import com.shiwulian.wechat.mapper.bs.UserOauthMapper;
import com.shiwulian.wechat.util.DateUtil;
import com.shiwulian.wechat.util.ObjectId;

@Service
public class ThirdPartyWechatService {
	
	private static final Logger logger = LoggerFactory.getLogger(ThirdPartyWechatService.class);
	
	private static final Map<String, ThirdPartyCallBackResult> accessTokenCache = new ConcurrentHashMap<String, ThirdPartyCallBackResult>();
	
	@Autowired
	private UserMapper userMapper;	
	@Autowired
	private OAuth2Manager oAuth2Manager;
	@Autowired
	private UserOauthMapper userOauthMapper;
	
	public User selectByPrimaryKey(String id){
		return userMapper.selectByPrimaryKey(id);
	}
	
	public User selectByOpenid(String wechatOpenid){
		return userMapper.selectByOpenid(wechatOpenid);
	}
	
	public UserOauth selectOauthByPrimaryKey(String id){
		return userOauthMapper.selectByPrimaryKey(id);
	}
	/**
	 * 获取微信授权URL
	 * @param callbackUrl
	 * @param scope
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String authorizeUrl(String callbackUrl,String scope) throws UnsupportedEncodingException{
		String state = generateState();
		return oAuth2Manager.authorizeUrl(callbackUrl, state,scope);
	}
	
	public Triplet<Boolean,ThirdPartyCallBackResult,String> callBack(String code,String state,String sessionId){
		try {
			//state检测是否有效  -> todo
			if(accessTokenCache.containsKey(sessionId)){
				ThirdPartyCallBackResult thirdParty = accessTokenCache.get(sessionId);
				if(thirdParty != null && StringUtils.isNotBlank(thirdParty.getUserId())){
					UserOauth userOauth = userOauthMapper.selectByUid(thirdParty.getUserId());
					if(userOauth != null && userOauth.getExpireTime().before(new Date())){
						return Triplet.with(Boolean.TRUE, thirdParty, null);
					}
					return Triplet.with(Boolean.TRUE, thirdParty, null);
				}
			}
			Oath2AccessTokenResult accessToken = oAuth2Manager.oath2AccessToken(code);
			if(accessToken.getErrcode() != null && accessToken.getErrcode() == 40029){//不合法或已过期的code
				accessToken = oAuth2Manager.oath2AccessToken(code);
			}
			if(StringUtils.isNotBlank(accessToken.getOpenid())){
				ThirdPartyCallBackResult thirdParty = ThirdPartyHandler(accessToken);
				accessTokenCache.put(sessionId, thirdParty);
				return Triplet.with(Boolean.TRUE, thirdParty, null);
			}else{
				return Triplet.with(Boolean.FALSE, null, "授权请求失败，请重试");
			}
		} catch (IOException e) {
			logger.error("CallBack error {}",e);
		}
		return Triplet.with(Boolean.FALSE, null, null);
	}
	
	public ThirdPartyCallBackResult ThirdPartyHandler(Oath2AccessTokenResult accessToken){
	ThirdPartyCallBackResult thirdParty = new ThirdPartyCallBackResult();
		Map<String,Object> map = new HashMap<>();
		map.put("thirdParty", OAuth2Scope.third_party_wechat);
		map.put("openId", accessToken.getOpenid());
		UserOauth record = userOauthMapper.selectByOpenId(map);
		if(record == null){
			record = new UserOauth(accessToken.getOpenid(),accessToken.getAccess_token(),accessToken.getRefresh_token(),accessToken.getExpires_in());
			record.setId(new ObjectId().toString());
			record.setThirdParty(OAuth2Scope.third_party_wechat);
			record.setCreateTime(new Date());
			record.setExpireTime(DateUtil.addSeconds(new Date(),accessToken.getExpires_in()));
			record.setValid(Boolean.TRUE);
			int rowEffects = userOauthMapper.insertSelective(record);
			thirdParty.setSuccess(rowEffects > 0);
			thirdParty.setOauthId(record.getId());
			thirdParty.setIsNeedRedirectBindPage(Boolean.TRUE);
		}else{
			if(StringUtils.isBlank(record.getUserId())){
				thirdParty.setOauthId(record.getId());
				thirdParty.setIsNeedRedirectBindPage(Boolean.TRUE);
			}else{
				thirdParty.setUserId(record.getUserId());
				thirdParty.setIsNeedRedirectBindPage(Boolean.FALSE);
			}
		}
		thirdParty.setOpenId(record.getOpenId());
		return thirdParty;
	}
	
	public Boolean checkState(String state){
		//检测state有效性  -> todo
		return true;
	}
	
	public String generateState(){
		long nowTimeString = System.currentTimeMillis();
		return String.valueOf(nowTimeString);
	}
}
