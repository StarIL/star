package com.shiwulian.wechat.bean.sa;

import java.math.BigDecimal;
import java.util.List;
import com.shiwulian.wechat.bean.od.OrderSettlement;

/***
 * 应收账单明细实体类
 * @author ZhangSuYun
 * @date 2018-01-12
 */
public class CustomerBillDetail {
    private String orderCode;//订单编号
    private BigDecimal totalAmount;//订单总金额
    private List<OrderSettlement> expenseList;//费用列表
    
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	public List<OrderSettlement> getExpenseList() {
		return expenseList;
	}
	public void setExpenseList(List<OrderSettlement> expenseList) {
		this.expenseList = expenseList;
	}
}