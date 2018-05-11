package com.shiwulian.wechat.mapper.od;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.shiwulian.wechat.bean.od.OrderSettlement;
import com.shiwulian.wechat.bean.response.OrderInComeResponse;

public interface OrderSettlementMapper {
	/**
	 * 通用map查询方法
	 * 
	 * @param map
	 *            需要传递的条件map
	 * @return list of OrderSettlement
	 * 
	 * @author wuhongxiang 2017-10-10
	 */
	List<OrderSettlement> selectByMapParam(Map<String, Object> map);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table od_order_settlement
     *
     * @mbg.generated Wed Jan 03 13:27:41 CST 2018
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table od_order_settlement
     *
     * @mbg.generated Wed Jan 03 13:27:41 CST 2018
     */
    int insert(OrderSettlement record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table od_order_settlement
     *
     * @mbg.generated Wed Jan 03 13:27:41 CST 2018
     */
    int insertSelective(OrderSettlement record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table od_order_settlement
     *
     * @mbg.generated Wed Jan 03 13:27:41 CST 2018
     */
    OrderSettlement selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table od_order_settlement
     *
     * @mbg.generated Wed Jan 03 13:27:41 CST 2018
     */
    int updateByPrimaryKeySelective(OrderSettlement record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table od_order_settlement
     *
     * @mbg.generated Wed Jan 03 13:27:41 CST 2018
     */
    int updateByPrimaryKey(OrderSettlement record);
    
    List<OrderSettlement> selectList(String orderIds);
    
    List<OrderSettlement> selectByOrderIds(List<String> orderIds);
    
    List<OrderInComeResponse> selectInCome(String orderId);
    
	/***
	 * 条件更新状态（账单和付款申请状态）
	 * @param map map.put("incomeBillId","");map.put("paymentApplyid","");
	 * @return 更新记录条数
	 */
	int updateSettlementByMap(Map<String, Object> map);
	
	BigDecimal selectInComeByCustomerId(String customerId);
}