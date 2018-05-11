package com.shiwulian.wechat.bean.response;

import java.math.BigDecimal;

import com.shiwulian.wechat.bean.bs.Customer;
import com.shiwulian.wechat.bean.bs.Partner;
import com.shiwulian.wechat.bean.bs.User;

/**
 * 我的桌面
 */
public class UserInfoResponse {
	private User user;
	private Customer customer;
	private User operator;
	private Partner partner;
	private BigDecimal capital;
	
	public Partner getPartner() {
		return partner;
	}
	public void setPartner(Partner partner) {
		this.partner = partner;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public User getOperator() {
		return operator;
	}
	public void setOperator(User operator) {
		this.operator = operator;
	}
	public BigDecimal getCapital() {
		return capital;
	}
	public void setCapital(BigDecimal capital) {
		this.capital = capital;
	}
	
}
