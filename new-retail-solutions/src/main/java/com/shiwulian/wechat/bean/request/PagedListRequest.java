package com.shiwulian.wechat.bean.request;

import java.util.List;
import com.shiwulian.wechat.bean.RequestBase;

public class PagedListRequest extends RequestBase {

	private String customerId;

	private Integer status;

	private String orderNo;

	private String customsNo;

	private String billNo;

	private String productName;

	private String startArrivalTime;

	private String endArrivalTime;

	private List<Integer> serviceStatus;

	private List<String> ids;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getCustomsNo() {
		return customsNo;
	}

	public void setCustomsNo(String customsNo) {
		this.customsNo = customsNo;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getStartArrivalTime() {
		return startArrivalTime;
	}

	public void setStartArrivalTime(String startArrivalTime) {
		this.startArrivalTime = startArrivalTime;
	}

	public String getEndArrivalTime() {
		return endArrivalTime;
	}

	public void setEndArrivalTime(String endArrivalTime) {
		this.endArrivalTime = endArrivalTime;
	}

	public List<Integer> getServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(List<Integer> serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}
}
