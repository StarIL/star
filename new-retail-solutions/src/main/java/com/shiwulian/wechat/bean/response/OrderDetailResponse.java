package com.shiwulian.wechat.bean.response;

import java.util.List;
import com.shiwulian.wechat.bean.bs.Warehouse;
import com.shiwulian.wechat.bean.lg.Destination;
import com.shiwulian.wechat.bean.od.Order;
import com.shiwulian.wechat.bean.od.OrderDelivery;
import com.shiwulian.wechat.bean.od.OrderExecutiveInfo;
import com.shiwulian.wechat.bean.od.OrderFinancial;
import com.shiwulian.wechat.bean.od.OrderStorage;
import com.shiwulian.wechat.bean.od.OrderTodolist;
import com.shiwulian.wechat.bean.od.OrderTrade;

public class OrderDetailResponse {

	private Order order;

	private List<OrderTodolist> todos;

	private OrderFinancial financial;

	private OrderStorage storage;

	private OrderDelivery delivery;

	private Destination destination;

	private Warehouse warehouse;

	private OrderTrade trade;

	private OrderExecutiveInfo info;

	private String factoryName;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<OrderTodolist> getTodos() {
		return todos;
	}

	public void setTodos(List<OrderTodolist> todos) {
		this.todos = todos;
	}

	public OrderFinancial getFinancial() {
		return financial;
	}

	public void setFinancial(OrderFinancial financial) {
		this.financial = financial;
	}

	public OrderStorage getStorage() {
		return storage;
	}

	public void setStorage(OrderStorage storage) {
		this.storage = storage;
	}

	public OrderDelivery getDelivery() {
		return delivery;
	}

	public void setDelivery(OrderDelivery delivery) {
		this.delivery = delivery;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public OrderTrade getTrade() {
		return trade;
	}

	public void setTrade(OrderTrade trade) {
		this.trade = trade;
	}

	public OrderExecutiveInfo getInfo() {
		return info;
	}

	public void setInfo(OrderExecutiveInfo info) {
		this.info = info;
	}

	public String getFactoryName() {
		return factoryName;
	}

	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}
}
