package com.shiwulian.wechat.bean.response;

import com.shiwulian.wechat.bean.sys.WorkType;

public class WorkTypeResponse extends WorkType{
	private Integer serverId;
	private String serverName;
	public Integer getServerId() {
		return serverId;
	}
	public void setServerId(Integer serverId) {
		this.serverId = serverId;
	}
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
}
