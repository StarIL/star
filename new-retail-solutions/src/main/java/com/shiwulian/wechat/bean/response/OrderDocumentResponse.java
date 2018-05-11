package com.shiwulian.wechat.bean.response;

import com.shiwulian.wechat.bean.od.OrderDocument;

public class OrderDocumentResponse extends OrderDocument{
	private String billName;

	public String getBillName() {
		return billName;
	}

	public void setBillName(String billName) {
		this.billName = billName;
	}
	
}
