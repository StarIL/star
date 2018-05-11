package com.shiwulian.wechat.service.od;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.shiwulian.wechat.bean.od.Order;
import com.shiwulian.wechat.bean.od.OrderDelivery;
import com.shiwulian.wechat.bean.od.OrderStorage;
import com.shiwulian.wechat.bean.od.OrderTodolist;
import com.shiwulian.wechat.bean.od.OrderTradeItem;
import com.shiwulian.wechat.bean.request.PagedListRequest;
import com.shiwulian.wechat.bean.response.OrderDetailResponse;
import com.shiwulian.wechat.bean.response.OrderInfoResponse;
import com.shiwulian.wechat.bean.response.OrderStatusResponse;
import com.shiwulian.wechat.bean.response.OrderWorkResponse;
import com.shiwulian.wechat.bean.response.PagedListResponse;
import com.shiwulian.wechat.mapper.bs.WarehouseMapper;
import com.shiwulian.wechat.mapper.lg.DestinationMapper;
import com.shiwulian.wechat.mapper.od.OrderDeliveryMapper;
import com.shiwulian.wechat.mapper.od.OrderExecutionplanMapper;
import com.shiwulian.wechat.mapper.od.OrderExecutiveInfoMapper;
import com.shiwulian.wechat.mapper.od.OrderFinancialMapper;
import com.shiwulian.wechat.mapper.od.OrderMapper;
import com.shiwulian.wechat.mapper.od.OrderSettlementMapper;
import com.shiwulian.wechat.mapper.od.OrderStorageMapper;
import com.shiwulian.wechat.mapper.od.OrderTodolistMapper;
import com.shiwulian.wechat.mapper.od.OrderTradeItemMapper;
import com.shiwulian.wechat.mapper.od.OrderTradeMapper;
import com.shiwulian.wechat.util.SysConfig.OrderStatus;

@Service
public class OrderService {

	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private OrderTradeMapper orderTradeMapper;
	@Autowired
	private OrderTradeItemMapper orderTradeItemMapper;
	@Autowired
	private OrderFinancialMapper orderFinancialMapper;
	@Autowired
	private OrderDeliveryMapper orderDeliveryMapper;
	@Autowired
	private OrderTodolistMapper orderTodolistMapper;
	@Autowired
	private OrderExecutiveInfoMapper orderExecutiveInfoMapper;
	@Autowired
	private OrderExecutionplanMapper orderExecutionplanMapper;
	@Autowired
	private OrderStorageMapper orderStorageMapper;
	@Autowired
	private OrderSettlementMapper orderSettlementMapper;
	@Autowired
	private WarehouseMapper warehouseMapper;
	@Autowired
	private DestinationMapper destinationMapper;
	
	public List<String> selectProducts(String customerId){
		List<String> ids = orderMapper.selectByCid(customerId);
		if(ids == null || ids.size() <= 0) return null;
		
		return orderTradeItemMapper.selectByOrderIds(ids);
	}

	public List<PagedListResponse> pagedList(PagedListRequest request) {
		if(StringUtils.isNotBlank(request.getProductName())){
			List<OrderTradeItem> items = orderTradeItemMapper.selectByName(request.getProductName());
			List<String> orderIds = new ArrayList<>();
			if(items != null && items.size() > 0){
				List<String> tradeIds = items.stream().map(OrderTradeItem::getTradeId).distinct().collect(Collectors.toList());
				orderIds = orderTradeMapper.selectByIds(tradeIds);
			}
			request.setIds(orderIds);
		}
		PageHelper.startPage(request.getCurrentPage(), request.getPageSize(), "id desc");
		List<PagedListResponse> orders = orderMapper.pagedList(request);
		if(orders != null && orders.size() > 0){
			List<String> orderIds = orders.stream().map(PagedListResponse::getId).collect(Collectors.toList());
			List<OrderTodolist> todos = orderTodolistMapper.selectList(orderIds);
			for (PagedListResponse order : orders) {
				if(todos.parallelStream().anyMatch(q->q.getOrderId().equals(order.getId()))){
					List<OrderTodolist> result = todos.parallelStream().filter(q->q.getOrderId().equals(order.getId())).collect(Collectors.toList());
					order.setTodos(result);
				}
			}
		}
		return orders;
	}
	
	public OrderDetailResponse detail(String customerId,String id,boolean executiveInfo){
		OrderDetailResponse response = new OrderDetailResponse();
		Order order = orderMapper.selectByPrimaryKey(id);
		if(order != null && executiveInfo){
			List<String> ids = Arrays.asList(order.getId());
			response.setTodos(orderTodolistMapper.selectList(ids));
			if(order.getCargoMortgageFinancingAgent() || order.getPayImportTaxAgent()){
				response.setFinancial(orderFinancialMapper.selectByPrimaryKey(order.getId()));
			}
			if(order.getDeliveryAgent() || order.getWarehouseAgent()){
				OrderDelivery delivery = orderDeliveryMapper.selectByPrimaryKey(order.getId());
				response.setDestination(delivery!=null ? destinationMapper.selectByPrimaryKey(delivery.getDestinationId()):null);
				response.setDelivery(delivery);
				
				OrderStorage storage = orderStorageMapper.selectByPrimaryKey(order.getId());	
				response.setWarehouse(storage != null ? warehouseMapper.selectByPrimaryKey(storage.getWarehouseId()):null);
				response.setStorage(storage);
			}
			response.setTrade(orderTradeMapper.selectByOrderId(order.getId()));
		}
		response.setInfo(orderExecutiveInfoMapper.selectByPrimaryKey(order.getId()));
		response.setOrder(order);
		return response;
	}

	public Order selectByPrimaryKey(String id) {
		return orderMapper.selectByPrimaryKey(id);
	}

	public OrderInfoResponse queryOrderInfo(String customerId) {
		OrderInfoResponse response = new OrderInfoResponse();
		OrderStatusResponse orderStatus = new OrderStatusResponse();
		List<Integer> ss = orderMapper.selectServiceStatus(customerId);
		ss.forEach(q->{
			if(q == OrderStatus.PLACEORDER.getValue()){
				orderStatus.setPlaceorder(orderStatus.getPlaceorder()+1);
			}else if(q == OrderStatus.ACCEPANCE.getValue()){
				orderStatus.setAccepance(orderStatus.getAccepance()+1);
			}else if(q == OrderStatus.TRANSPORT_F.getValue()){
				orderStatus.setTransport_f(orderStatus.getTransport_f()+1);
			}else if(q == OrderStatus.CLEARANCE.getValue()){
				orderStatus.setClearance(orderStatus.getClearance()+1);
			}
		});
		response.setOrderStatus(orderStatus);//订单状态
		OrderWorkResponse work = orderExecutionplanMapper.selectByCustomerId(customerId);
		response.setWork(work);//最新进展
		 List<OrderTodolist> todo = orderTodolistMapper.selectByCustomerId(customerId);
		response.setTodo(todo);
		BigDecimal inCome =  orderSettlementMapper.selectInComeByCustomerId(customerId);
		response.setIncomeAmountCny(inCome);
		return response;
	}
}