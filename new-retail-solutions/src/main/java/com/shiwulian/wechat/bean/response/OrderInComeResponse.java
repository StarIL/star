package com.shiwulian.wechat.bean.response;

import java.math.BigDecimal;

public class OrderInComeResponse {

	private String expenseTypeId;

	private Integer serverTypeId;

	private BigDecimal incomeAmountCny;

	public String getExpenseTypeId() {
		return expenseTypeId;
	}

	public void setExpenseTypeId(String expenseTypeId) {
		this.expenseTypeId = expenseTypeId;
	}

	public Integer getServerTypeId() {
		return serverTypeId;
	}

	public void setServerTypeId(Integer serverTypeId) {
		this.serverTypeId = serverTypeId;
	}

	public BigDecimal getIncomeAmountCny() {
		return incomeAmountCny;
	}

	public void setIncomeAmountCny(BigDecimal incomeAmountCny) {
		this.incomeAmountCny = incomeAmountCny;
	}
}
