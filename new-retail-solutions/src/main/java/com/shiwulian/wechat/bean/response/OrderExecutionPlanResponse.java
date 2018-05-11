package com.shiwulian.wechat.bean.response;

import java.util.Date;
import java.util.List;

public class OrderExecutionPlanResponse {

	private String orderId;

	private Integer serverId;

	private String serverName;
	
	private String actOperator;
	
	private Date completeTime;
	/**
	 * 服务项目对应的作业
	 */
	private List<OrderWorkResponse> works;

	private Boolean complate;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Date getCompleteTime() {
		return completeTime;
	}

	public void setCompleteTime(Date completeTime) {
		this.completeTime = completeTime;
	}

	public String getActOperator() {
		return actOperator;
	}

	public void setActOperator(String actOperator) {
		this.actOperator = actOperator;
	}

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

	public List<OrderWorkResponse> getWorks() {
		return works;
	}

	public void setWorks(List<OrderWorkResponse> works) {
		this.works = works;
	}

	public Boolean getComplate() {
		return complate;
	}

	public void setComplate(Boolean complate) {
		this.complate = complate;
	}
}
