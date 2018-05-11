package com.shiwulian.wechat.core.wechat;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.shiwulian.wechat.core.wechat.bean.OAuth2Result;
import com.shiwulian.wechat.core.wechat.bean.Oath2AccessTokenResult;
import com.shiwulian.wechat.core.wechat.bean.Oath2UserInfoResult;
import com.shiwulian.wechat.util.HttpClientUtil;

public class OAuth2Manager {
	
	private String appId;

	private String appSecret;

	/**
	 * wechat获取用户信息
	 * @param accessToken
	 * @return
	 * @throws IOException
	 */
	public Oath2UserInfoResult oath2Userinfo(String accessToken) throws IOException {
		return HttpClientUtil.doGet(String.format("https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN", accessToken, this.appId), Oath2UserInfoResult.class);
	}

	/**
	 * wechat获取accessToken
	 * 
	 * @return
	 * @throws IOException
	 */
	public Oath2AccessTokenResult oath2AccessToken(String code) throws IOException {
		Oath2AccessTokenResult accessToken = HttpClientUtil.doGet(String.format("https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code",this.appId,this.appSecret,code),Oath2AccessTokenResult.class);
		return accessToken;
	}
	/**
	 * 检验授权凭证（access_token）是否有效
	 * @param code
	 * @return
	 * @throws IOException
	 */
	public OAuth2Result snsAuthAccessToken(String accessToken) throws IOException {
		return HttpClientUtil.doGet(String.format("https://api.weixin.qq.com/sns/auth?access_token=%s&openid=%s",accessToken,this.appId),OAuth2Result.class);
	}

	/**
	 * 获取验证地址
	 * 
	 * @param redirectUrl
	 * @param state
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String authorizeUrl(String redirectUrl,String state,String scope) throws UnsupportedEncodingException {
		redirectUrl = URLEncoder.encode(redirectUrl, "UTF-8");
		return String.format("https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=%s#wechat_redirect",this.appId, redirectUrl,scope, state);
	}

	/**
	 * 刷新access_token（如果需要）
	 * 
	 * @param refreshToken
	 * @return
	 * @throws IOException
	 */
	public Oath2AccessTokenResult refreshToken(String refreshToken) throws IOException {	
		return HttpClientUtil.doGet(String.format("https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=%s&grant_type=refresh_token&refresh_token=%s", this.appId, refreshToken), Oath2AccessTokenResult.class);
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
}
