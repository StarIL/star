package com.shiwulian.wechat.bean.request;

import java.util.Date;

import com.shiwulian.wechat.bean.RequestBase;

public class CustomerAccountBillRequest extends RequestBase {
	private String customerId;//客户id
    private Date createTimeBegin;//资金流水创建日期 开始
    private Date createTimeEnd;//资金流水创建日期 结束
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public Date getCreateTimeBegin() {
		return createTimeBegin;
	}
	public void setCreateTimeBegin(Date createTimeBegin) {
		this.createTimeBegin = createTimeBegin;
	}
	public Date getCreateTimeEnd() {
		return createTimeEnd;
	}
	public void setCreateTimeEnd(Date createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}
}
