package com.shiwulian.wechat.bean.od;

/***
 * 
 * @ClassName:  OrderSettlementForExpense   
 * @Description:(结算明细+费用)对象
 * @author: 张苏云
 * @date:   2017年12月12日 下午2:55:03
 */
public class OrderSettlementForExpense extends OrderSettlement {
    
	private Integer category;//种类：1、货款；2、关税；3、费用

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}
	
}