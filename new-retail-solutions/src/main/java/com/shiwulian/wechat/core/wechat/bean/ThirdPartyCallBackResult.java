package com.shiwulian.wechat.core.wechat.bean;

import com.shiwulian.wechat.bean.Response;


public class ThirdPartyCallBackResult extends Response<ThirdPartyCallBackResult> {

	private String openId;

	public String oauthId;

	private Boolean isNeedRedirectBindPage;

	private String userId;

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getOauthId() {
		return oauthId;
	}

	public void setOauthId(String oauthId) {
		this.oauthId = oauthId;
	}

	public Boolean getIsNeedRedirectBindPage() {
		return isNeedRedirectBindPage;
	}

	public void setIsNeedRedirectBindPage(Boolean isNeedRedirectBindPage) {
		this.isNeedRedirectBindPage = isNeedRedirectBindPage;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}