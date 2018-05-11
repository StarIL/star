package com.shiwulian.wechat.bean.response;

public class OrderStatusResponse {
	private Integer placeorder = 0;
	private Integer accepance = 0;
	private Integer transport_f = 0;
	private Integer clearance = 0;
	public Integer getPlaceorder() {
		return placeorder;
	}
	public void setPlaceorder(Integer placeorder) {
		this.placeorder = placeorder;
	}
	public Integer getAccepance() {
		return accepance;
	}
	public void setAccepance(Integer accepance) {
		this.accepance = accepance;
	}
	public Integer getTransport_f() {
		return transport_f;
	}
	public void setTransport_f(Integer transport_f) {
		this.transport_f = transport_f;
	}
	public Integer getClearance() {
		return clearance;
	}
	public void setClearance(Integer clearance) {
		this.clearance = clearance;
	}
	
}
