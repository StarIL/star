package com.shiwulian.wechat.bean.response;

import java.util.Date;
import java.util.List;
import com.shiwulian.wechat.bean.od.OrderTodolist;

public class PagedListResponse {

	private String id;

	private String orderCode;

	private Boolean haveAgent;

	private Boolean haveLogistical;

	private Boolean haveFinance;

	private Integer serviceStatus = Integer.valueOf(0);

	private String startCountryName;

	private String loadingPortName;

	private String dischargePortName;

	private String tradeGoodsRemark;

	private Date createTime;

	private Date expectedArrivalTime;

	private Date actualArrivalTime;

	private List<OrderTodolist> todos;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public Boolean getHaveAgent() {
		return haveAgent;
	}

	public void setHaveAgent(Boolean haveAgent) {
		this.haveAgent = haveAgent;
	}

	public Boolean getHaveLogistical() {
		return haveLogistical;
	}

	public void setHaveLogistical(Boolean haveLogistical) {
		this.haveLogistical = haveLogistical;
	}

	public Boolean getHaveFinance() {
		return haveFinance;
	}

	public void setHaveFinance(Boolean haveFinance) {
		this.haveFinance = haveFinance;
	}

	public Integer getServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(Integer serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

	public String getStartCountryName() {
		return startCountryName;
	}

	public void setStartCountryName(String startCountryName) {
		this.startCountryName = startCountryName;
	}

	public String getLoadingPortName() {
		return loadingPortName;
	}

	public void setLoadingPortName(String loadingPortName) {
		this.loadingPortName = loadingPortName;
	}

	public String getTradeGoodsRemark() {
		return tradeGoodsRemark;
	}

	public void setTradeGoodsRemark(String tradeGoodsRemark) {
		this.tradeGoodsRemark = tradeGoodsRemark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getExpectedArrivalTime() {
		return expectedArrivalTime;
	}

	public void setExpectedArrivalTime(Date expectedArrivalTime) {
		this.expectedArrivalTime = expectedArrivalTime;
	}

	public Date getActualArrivalTime() {
		return actualArrivalTime;
	}

	public void setActualArrivalTime(Date actualArrivalTime) {
		this.actualArrivalTime = actualArrivalTime;
	}

	public List<OrderTodolist> getTodos() {
		return todos;
	}

	public void setTodos(List<OrderTodolist> todos) {
		this.todos = todos;
	}

	public String getDischargePortName() {
		return dischargePortName;
	}

	public void setDischargePortName(String dischargePortName) {
		this.dischargePortName = dischargePortName;
	}
}
