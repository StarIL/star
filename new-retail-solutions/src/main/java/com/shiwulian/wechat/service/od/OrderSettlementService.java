package com.shiwulian.wechat.service.od;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shiwulian.wechat.bean.fn.ExpenseType;
import com.shiwulian.wechat.bean.od.OrderSettlement;
import com.shiwulian.wechat.bean.response.OrderInComeResponse;
import com.shiwulian.wechat.bean.response.OrderSettlementResponse;
import com.shiwulian.wechat.mapper.fn.ExpenseTypeMapper;
import com.shiwulian.wechat.mapper.od.OrderSettlementMapper;

@Service
public class OrderSettlementService {
	
	@Autowired
	private OrderSettlementMapper orderSettlementMapper;
	@Autowired
	private ExpenseTypeMapper expenseTypeMapper;

	public List<OrderSettlementResponse> selectList(String orderId){
		List<OrderSettlementResponse> result = new ArrayList<>();
		List<OrderSettlement> settlments = orderSettlementMapper.selectList(orderId);
		if(settlments != null && settlments.size() > 0){
			List<String> expenseTypeIds = settlments.stream().map(OrderSettlement::getExpenseTypeId).distinct().collect(Collectors.toList());
			List<ExpenseType> expenseTypes = expenseTypeMapper.selectByIds(expenseTypeIds);
			for (ExpenseType expenseType : expenseTypes) {
				OrderSettlementResponse response = new OrderSettlementResponse(expenseType.getServerTypeId());
				BigDecimal receivableTotal = BigDecimal.valueOf(0.00);
				BigDecimal receivableCnyTotal = BigDecimal.valueOf(0.00);
				if(settlments.stream().anyMatch(q->q.getExpenseTypeId().equals(expenseType.getId()))){
					List<OrderSettlement> settlmentDetails = settlments.stream().filter(q->q.getExpenseTypeId().equals(expenseType.getId())).collect(Collectors.toList());
					response.setSettlmentDetails(settlmentDetails);
					for (OrderSettlement orderSettlement : settlmentDetails) {
						receivableTotal = receivableTotal.add(orderSettlement.getIncomeAmount() != null ? orderSettlement.getIncomeAmount() :BigDecimal.valueOf(0.00));
						receivableCnyTotal = receivableCnyTotal.add(orderSettlement.getIncomeAmountCny() != null ? orderSettlement.getIncomeAmountCny() : BigDecimal.valueOf(0.00));
					}
					response.setReceivableTotal(receivableTotal);					
					response.setReceivableCnyTotal(receivableCnyTotal);
					result.add(response);
				}
			}
		}
		return result;
	}
	
	public Pair<BigDecimal,List<OrderInComeResponse>> selectInCome(String orderId){
		List<OrderInComeResponse> incomes = orderSettlementMapper.selectInCome(orderId);
		BigDecimal totalIncomeCny = BigDecimal.valueOf(0.00);
		if(incomes != null && incomes.size() > 0){
			List<String> expenseTypeIds = incomes.stream().map(OrderInComeResponse::getExpenseTypeId).collect(Collectors.toList());
			List<ExpenseType> expenseTypes = expenseTypeMapper.selectByIds(expenseTypeIds);	
			//Map<Integer, Long> groupingBy = expenseTypes.stream().collect(Collectors.groupingBy(ExpenseType::getServerTypeId,Collectors.counting()));			
			incomes.stream().forEach(income->{
				if(expenseTypes.stream().anyMatch(q->q.getId().equals(income.getExpenseTypeId()))){
					ExpenseType expenseType = expenseTypes.stream().filter(q->q.getId().equals(income.getExpenseTypeId())).findFirst().get();
					income.setServerTypeId(expenseType.getServerTypeId());
				}
			});
			totalIncomeCny = incomes.stream().map(OrderInComeResponse::getIncomeAmountCny).reduce((q,p)->q.add(p)).get();
		}		
		return Pair.with(totalIncomeCny, incomes);
	}	
}
