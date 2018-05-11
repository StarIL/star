package com.shiwulian.wechat.bean.request;

public class SaveDocumentRequest {

	private String orderId;

	private Integer billId;

	private String billFileUrl;

	private String billFileName;

	private String billNo;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Integer getBillId() {
		return billId;
	}

	public void setBillId(Integer billId) {
		this.billId = billId;
	}

	public String getBillFileUrl() {
		return billFileUrl;
	}

	public void setBillFileUrl(String billFileUrl) {
		this.billFileUrl = billFileUrl;
	}

	public String getBillFileName() {
		return billFileName;
	}

	public void setBillFileName(String billFileName) {
		this.billFileName = billFileName;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
}
