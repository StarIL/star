package com.shiwulian.wechat.bean.response;

import java.math.BigDecimal;
import java.util.List;

import com.shiwulian.wechat.bean.od.OrderTodolist;

public class OrderInfoResponse {
	private BigDecimal incomeAmountCny;
	
	private OrderStatusResponse orderStatus;
	
	private OrderWorkResponse work;
	
	private  List<OrderTodolist> todo;

	public BigDecimal getIncomeAmountCny() {
		return incomeAmountCny;
	}

	public void setIncomeAmountCny(BigDecimal incomeAmountCny) {
		this.incomeAmountCny = incomeAmountCny;
	}

	public OrderStatusResponse getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatusResponse orderStatus) {
		this.orderStatus = orderStatus;
	}

	public OrderWorkResponse getWork() {
		return work;
	}

	public void setWork(OrderWorkResponse work) {
		this.work = work;
	}

	public List<OrderTodolist> getTodo() {
		return todo;
	}

	public void setTodo( List<OrderTodolist> todo) {
		this.todo = todo;
	}
	
}
