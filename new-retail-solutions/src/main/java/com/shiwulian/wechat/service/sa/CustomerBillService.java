package com.shiwulian.wechat.service.sa;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.StringUtil;
import com.shiwulian.wechat.bean.Response;
import com.shiwulian.wechat.bean.od.OrderSettlement;
import com.shiwulian.wechat.bean.request.CustomerBillRequest;
import com.shiwulian.wechat.bean.sa.CustomerBill;
import com.shiwulian.wechat.bean.sa.CustomerBillDetail;
import com.shiwulian.wechat.mapper.od.OrderSettlementMapper;
import com.shiwulian.wechat.mapper.sa.CustomerBillMapper;
import com.shiwulian.wechat.util.SysConfig;

/**
 * 应收账单service
 * @author ZhangSuYun 
 * @date 2018-01-11
 */
@Service
public class CustomerBillService {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerBillService.class);

	@Autowired
	private CustomerBillMapper customerBillMapper;
	
	@Autowired
	private OrderSettlementMapper orderSettlementMapper;

	/***
	 * 查询当前客户所有的应收账单列表
	 * @param customerId 当前客户id
	 * @return 应收账单列表
	 */
	public List<CustomerBill> queryList(CustomerBillRequest request, String customerId) throws Exception {
		try {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("customerId", customerId);
			map.put("status", (request.getStatus() == 1 || request.getStatus() == 2) ? request.getStatus().toString() : null);
			map.put("isExpected", request.getIsExpected() ? "1" : null);
			return this.customerBillMapper.selectCustomerBillList(map);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	/**
	 * 查询应收账单详情
	 * @param customerBillId 账单id
	 * @return 应收账单对应的结算明细信息
	 */
	public Response<Object> queryBillDetail(String customerBillId) throws Exception {
		Response<Object> response = new Response<>(false);
		CustomerBillDetail datail = null;
		//最后的结果列表
		List<CustomerBillDetail> result = new ArrayList<CustomerBillDetail>();
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("incomeBillId", customerBillId);
			map.put("isInner", 0);//非内部结算
			List<OrderSettlement> orderSettlementList = this.orderSettlementMapper.selectByMapParam(map);
			if (null != orderSettlementList && !orderSettlementList.isEmpty()) {
				Map<String, List<OrderSettlement>> orderSettlementByOrderIdMap = orderSettlementList.stream().collect(Collectors.groupingBy(OrderSettlement::getOrderCode));
				if (null != orderSettlementByOrderIdMap && !orderSettlementByOrderIdMap.isEmpty()) {
					for (Entry<String,List<OrderSettlement>> mapOrderSettlement : orderSettlementByOrderIdMap.entrySet()) {
						if (null != mapOrderSettlement && StringUtil.isNotEmpty(mapOrderSettlement.getKey())) {
							List<OrderSettlement> list = mapOrderSettlement.getValue();
							if (null != list && !list.isEmpty()) {
								datail = new CustomerBillDetail();
								//订单code
								datail.setOrderCode(mapOrderSettlement.getKey());
								BigDecimal totalAmount = new BigDecimal("0.00");
								if (list.stream().anyMatch(q->q.getIncomeAmountCny() != null)) {
									totalAmount = list.stream().filter(q->q.getIncomeAmountCny() != null).map(OrderSettlement::getIncomeAmountCny).reduce((q,p)->q.add(p)).get();
								}
								//订单总金额
								datail.setTotalAmount(totalAmount);
								//各费用按费用id分组
								Map<String, List<OrderSettlement>> expenseGroupList = list.stream().collect(Collectors.groupingBy(OrderSettlement::getExpenseTypeName));
								if (null != expenseGroupList && !expenseGroupList.isEmpty()) {
									List<OrderSettlement> expenseFinalList = new ArrayList<OrderSettlement>();
									OrderSettlement item = null;
									for (Entry<String,List<OrderSettlement>> mapExpense :expenseGroupList.entrySet()) {
										if (null != mapExpense) {
											List<OrderSettlement> expenseList = mapExpense.getValue();
											if (null != expenseList && !expenseList.isEmpty()) {
												BigDecimal expenseCollectAmount = new BigDecimal("0.00");//代付的费用
												BigDecimal expenseNoCollectAmount = new BigDecimal("0.00");//非代付的费用
												
												//将应收本币金额值为空的设置为0.00
												if (expenseList.stream().anyMatch(q->q.getIncomeAmountCny() == null)) {
													expenseList.forEach(q->{
														if (q.getIncomeAmountCny() == null) {
															q.setIncomeAmountCny(new BigDecimal("0.00"));
														}
													});
												}
												
												//代付的费用
												if (expenseList.stream().anyMatch(q->q.getIsCollect())) {
													expenseCollectAmount = expenseList.stream()
															.filter(q->q.getIncomeAmountCny() != null && mapExpense.getKey().equals(q.getExpenseTypeName()) && q.getIsCollect())
															.map(OrderSettlement::getIncomeAmountCny).reduce((q,p)->q.add(p)).get();
												}
												//非代付的费用
												if (!expenseList.stream().allMatch(q->q.getIsCollect())) {
													expenseNoCollectAmount = expenseList.stream()
															.filter(q->q.getIncomeAmountCny() != null && mapExpense.getKey().equals(q.getExpenseTypeName()) && !q.getIsCollect())
															.map(OrderSettlement::getIncomeAmountCny).reduce((q,p)->q.add(p)).get();
												}
												if (null != expenseCollectAmount && expenseCollectAmount.compareTo(BigDecimal.ZERO) != 0) {
													item = new OrderSettlement();
													//费用id
													item.setExpenseTypeId(expenseList.get(0).getExpenseTypeId());
													//费用名称
													item.setExpenseTypeName(mapExpense.getKey());
													item.setIsCollect(true);//代付
													item.setIncomeAmountCny(expenseCollectAmount);//费用本币金额
													expenseFinalList.add(item);
												}
												if (null != expenseNoCollectAmount && expenseNoCollectAmount.compareTo(BigDecimal.ZERO) != 0) {
													item = new OrderSettlement();
													//费用id
													item.setExpenseTypeId(expenseList.get(0).getExpenseTypeId());
													//费用名称
													item.setExpenseTypeName(mapExpense.getKey());
													item.setIsCollect(false);//非代付
													item.setIncomeAmountCny(expenseNoCollectAmount);//费用本币金额
													expenseFinalList.add(item);
												}
											}
										}
									}
									//费用升序排列
									if (null != expenseFinalList && !expenseFinalList.isEmpty()) {
										expenseFinalList = expenseFinalList.stream().sorted(Comparator.comparing(OrderSettlement::getExpenseTypeId)).collect(Collectors.toList());
									}
									datail.setExpenseList(expenseFinalList);
								}
							}
							result.add(datail);
						}
					}
				}
			}
			if (result != null && !result.isEmpty()) {
				result = result.stream().sorted(Comparator.comparing(CustomerBillDetail::getOrderCode).reversed()).collect(Collectors.toList());
			}
			response.setSuccess(true);
			response.setMsg("获取账单明细成功");
			response.setData(result);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return response;
	}
	
	/**
	 * 确认账单
	 * @author:ZhangSuYun
	 * @date:2018年01月11日
	 */
	@Transactional(rollbackFor = Exception.class)
	public Response<Object> confirmBill(String customerBillId, String userName) throws Exception {
		boolean success = false;
		Response<Object> resp = new Response<Object>(false);
		try {
			CustomerBill record = this.customerBillMapper.selectByPrimaryKey(customerBillId);
			if (record == null) {
				resp.setSuccess(false);
				resp.setMsg("该账单不存在");
				throw new Exception("该账单不存在");
			}
			
			if (record.getStatus() != null && record.getStatus().equals(SysConfig.CustomerBillStatus.NOT_CONFIRM.getValue())) {
				record.setStatus(SysConfig.CustomerBillStatus.CONFIRM.getValue());//确认	
				record.setConfirmTime(new Date());
				record.setConfirmOperator(userName);
				record.setUptTime(new Date());
				record.setUptOperator(userName);
				success = this.customerBillMapper.updateByPrimaryKeySelective(record) > 0;
				if (!success) {
					resp.setSuccess(false);
					resp.setMsg("确认账单失败");
					throw new Exception("确认账单失败");
				}
				//更新账单对应的结算明细表中账单的状态为“确认”
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("incomeBillId",customerBillId);
				map.put("isInner", 0);//非内部结算
				List<OrderSettlement> list = this.orderSettlementMapper.selectByMapParam(map);
				if (list != null && !list.isEmpty()) {
					map.put("incomeStatus",SysConfig.CustomerBillStatus.CONFIRM.getValue());//确认
					success = this.orderSettlementMapper.updateSettlementByMap(map) > 0;
					if (!success) {
						resp.setSuccess(false);
						resp.setMsg("确认账单失败,原因是：更新费用对应的结算明细失败");
						throw new Exception("确认账单失败,原因是：更新费用对应的结算明细失败");
					}
				}
			}
			resp.setSuccess(true);
			resp.setMsg("确认账单成功");
		} catch (Exception e) {
			resp.setSuccess(false);
			throw new Exception(e);
		}
		return resp;
	}
	
	
    /**  
     * 计算两个日期之间相差的天数  
     * @param smallDate 较小的时间 
     * @param bigDate  较大的时间 
     * @return 相差天数 
     * @throws ParseException  
     */    
    public int daysBetween(Date smallDate,Date bigDate) {
    	try {
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
            smallDate = sdf.parse(sdf.format(smallDate));  
            bigDate = sdf.parse(sdf.format(bigDate));  
            Calendar cal = Calendar.getInstance();    
            cal.setTime(smallDate);    
            long time1 = cal.getTimeInMillis();                 
            cal.setTime(bigDate);    
            long time2 = cal.getTimeInMillis();         
            long between_days=(time2-time1)/(1000*3600*24);  
            return Integer.parseInt(String.valueOf(between_days)); 
    	} catch (ParseException e) {
    		logger.error("计算两个日期之间相差的天数失败：{}",e);
    	}
    	return 0;
    }
	
}

