package com.shiwulian.wechat.bean.response;

import java.math.BigDecimal;
import java.util.List;

import com.shiwulian.wechat.bean.od.OrderSettlement;

public class OrderSettlementResponse {
	private Integer serverId;
	/**
	 * 应收本币金额
	 */
	private BigDecimal receivableTotal = BigDecimal.valueOf(0.00);
	/**
	 * 应收人民币金额
	 */
	private BigDecimal receivableCnyTotal = BigDecimal.valueOf(0.00);
	/**
	 * 应付本币金额
	 */
	private BigDecimal payableTotal = BigDecimal.valueOf(0.00);
	/**
	 * 应付人民币金额
	 */
	private BigDecimal payableCnyTotal = BigDecimal.valueOf(0.00);

	private List<OrderSettlement> settlmentDetails;

	public OrderSettlementResponse(Integer serverId) {
		this.serverId = serverId;
	}

	public Integer getServerId() {
		return serverId;
	}

	public void setServerId(Integer serverId) {
		this.serverId = serverId;
	}

	public BigDecimal getReceivableTotal() {
		return receivableTotal;
	}

	public void setReceivableTotal(BigDecimal receivableTotal) {
		this.receivableTotal = receivableTotal;
	}

	public BigDecimal getReceivableCnyTotal() {
		return receivableCnyTotal;
	}

	public void setReceivableCnyTotal(BigDecimal receivableCnyTotal) {
		this.receivableCnyTotal = receivableCnyTotal;
	}

	public BigDecimal getPayableTotal() {
		return payableTotal;
	}

	public void setPayableTotal(BigDecimal payableTotal) {
		this.payableTotal = payableTotal;
	}

	public BigDecimal getPayableCnyTotal() {
		return payableCnyTotal;
	}

	public void setPayableCnyTotal(BigDecimal payableCnyTotal) {
		this.payableCnyTotal = payableCnyTotal;
	}

	public List<OrderSettlement> getSettlmentDetails() {
		return settlmentDetails;
	}

	public void setSettlmentDetails(List<OrderSettlement> settlmentDetails) {
		this.settlmentDetails = settlmentDetails;
	}
}
