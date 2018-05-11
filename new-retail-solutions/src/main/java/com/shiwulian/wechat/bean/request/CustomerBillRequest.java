package com.shiwulian.wechat.bean.request;

import com.shiwulian.wechat.bean.RequestBase;

/***
 * 应收账单请求对象
 * @author 张苏云
 * @date 2018-01-12
 */
public class CustomerBillRequest extends RequestBase {
    private Integer status;//账单状态1、待确认（=内部状态：待审）； 2、待付款（=内部状态：确认）；3、已付款（=内部状态：核销）
    private Boolean isExpected;//是否预期
    
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Boolean getIsExpected() {
		return isExpected;
	}
	public void setIsExpected(Boolean isExpected) {
		this.isExpected = isExpected;
	}
}
