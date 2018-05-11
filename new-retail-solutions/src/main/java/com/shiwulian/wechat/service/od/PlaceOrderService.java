package com.shiwulian.wechat.service.od;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.javatuples.Triplet;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.shiwulian.wechat.bean.bs.Customer;
import com.shiwulian.wechat.bean.bs.User;
import com.shiwulian.wechat.bean.od.Order;
import com.shiwulian.wechat.bean.od.OrderDelivery;
import com.shiwulian.wechat.bean.od.OrderDocument;
import com.shiwulian.wechat.bean.od.OrderExecutionplan;
import com.shiwulian.wechat.bean.od.OrderExecutiveInfo;
import com.shiwulian.wechat.bean.od.OrderFinancial;
import com.shiwulian.wechat.bean.od.OrderStorage;
import com.shiwulian.wechat.bean.od.OrderTrade;
import com.shiwulian.wechat.bean.request.CreateOrderRequest;
import com.shiwulian.wechat.bean.response.WorkTypeResponse;
import com.shiwulian.wechat.bean.sys.BillType;
import com.shiwulian.wechat.mapper.bs.CustomerMapper;
import com.shiwulian.wechat.mapper.bs.UserMapper;
import com.shiwulian.wechat.mapper.od.OrderDeliveryMapper;
import com.shiwulian.wechat.mapper.od.OrderDocumentMapper;
import com.shiwulian.wechat.mapper.od.OrderExecutionplanMapper;
import com.shiwulian.wechat.mapper.od.OrderExecutiveInfoMapper;
import com.shiwulian.wechat.mapper.od.OrderFinancialMapper;
import com.shiwulian.wechat.mapper.od.OrderMapper;
import com.shiwulian.wechat.mapper.od.OrderStorageMapper;
import com.shiwulian.wechat.mapper.od.OrderTradeMapper;
import com.shiwulian.wechat.mapper.sys.BillTypeMapper;
import com.shiwulian.wechat.mapper.sys.WorkTypeMapper;
import com.shiwulian.wechat.util.ObjectId;
import com.shiwulian.wechat.util.SysConfig;
import com.shiwulian.wechat.util.SysConfig.OrderStatus;
import com.shiwulian.wechat.util.SysConfig.ServiceStatus;

/**
 * 微信下单
 */
@Service
public class PlaceOrderService {
	
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private OrderTradeMapper orderTradeMapper;
	@Autowired
	private OrderDeliveryMapper orderDeliveryMapper;
	@Autowired
	private OrderStorageMapper orderStorageMapper;
	@Autowired
	private OrderFinancialMapper orderFinancialMapper;
	@Autowired
	private OrderExecutiveInfoMapper orderExecutiveInfoMapper;
	@Autowired
	private OrderExecutionplanMapper orderExecutionplanMapper;
	@Autowired
	private OrderDocumentMapper orderDocumentMapper;
	@Autowired
	private BillTypeMapper billTypeMapper;
	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private WorkTypeMapper workTypeMapper;
	
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public Triplet<Boolean, Object,String> create(CreateOrderRequest request, User user,String orderNo) {
		BigDecimal zero = new BigDecimal(0);
		Order record = new Order();
		BeanUtils.copyProperties(request, record);
		record.setId(new ObjectId().toString());
		record.setOrderCode(orderNo);
		record.setHaveAgent(Boolean.TRUE);
		record.setHaveFinance(request.getCargoMortgageFinancingAgent() || request.getPayImportTaxAgent());
		record.setHaveLogistical(request.getDeliveryAgent() || request.getWarehouseAgent() || request.getWarehouseDeliveryAgent());
		if(request.getWarehouseDeliveryAgent()){
			record.setDeliveryAgent(Boolean.TRUE);
			record.setWarehouseAgent(Boolean.TRUE);
		}
		Customer customer = customerMapper.selectByPrimaryKey(user.getCustomerId());
		record.setCustomerId(customer.getId());
		record.setServiceOperator(customer.getServiceOperator());
		if(StringUtils.isNotBlank(customer.getServiceOperator())){//冗余
			User serviceOperator = userMapper.selectByUserName(customer.getServiceOperator());
			record.setServiceOperatorName(serviceOperator!=null?serviceOperator.getRealName():"");	
		}
		record.setPartnerId(customer.getPartnerId());
		record.setUserId(user.getId());
		record.setContactName(user.getRealName());
		record.setContactEmail(user.getEmail());
		record.setContactMobilePhone(user.getMobile());
		record.setServicesCate(request.getServicesCate());
		record.setOrderAmount(zero);
		record.setCreateDate(new Date());
		record.setIsAgent(false);
		record.setLoadingPortName("");
		record.setServiceStatus(OrderStatus.PLACEORDER.getValue());
		record.setServiceStatusSelf(ServiceStatus.PLACEORDER.getValue());
		record.setCreateOperator(user.getUserName());
		record.setCreateTime(new Date());
		orderMapper.insertSelective(record);

		OrderTrade trade = new OrderTrade();
		BeanUtils.copyProperties(request, trade);
		trade.setId(new ObjectId().toString());
		trade.setOrderId(record.getId());
		trade.setTransportType(request.getServicesCate() == 1 ? 1 : 2);//海运空运
		trade.setSellerCompanyId(customer.getId());//默认自己为买�
		trade.setBuyerType(1);//买方类型为本�
		trade.setOrderAmount(zero);
		trade.setCreateOperator(user.getUserName());
		trade.setCreateTime(new Date());
		trade.setIsDel(Boolean.FALSE);
		orderTradeMapper.insertSelective(trade);

		OrderDelivery delivery = new OrderDelivery();
		BeanUtils.copyProperties(request, delivery);
		delivery.setOrderId(record.getId());
		delivery.setCreateOperator(user.getUserName());
		delivery.setCreateTime(new Date());
		delivery.setIsDel(Boolean.FALSE);
		orderDeliveryMapper.insertSelective(delivery);

		OrderStorage storage = new OrderStorage();
		BeanUtils.copyProperties(request, storage);
		storage.setOrderId(record.getId());
		storage.setCreateOperator(user.getUserName());
		storage.setCreateTime(new Date());
		storage.setIsDel(Boolean.FALSE);
		orderStorageMapper.insertSelective(storage);
		
		OrderFinancial financial = new OrderFinancial();
		BeanUtils.copyProperties(request, financial);
		financial.setFinancingType(request.getPayImportTaxAgent() ? 1:request.getCargoMortgageFinancingAgent() ? 2:0);
		financial.setOrderId(record.getId());
		financial.setStatus(1);
		financial.setCreateOperator(user.getUserName());
		financial.setCreateTime(new Date());
		orderFinancialMapper.insertSelective(financial);
		
		OrderExecutiveInfo info = new OrderExecutiveInfo();
		BeanUtils.copyProperties(request, info);
		info.setOrderId(record.getId());
		info.setCreateOperator(user.getUserName());
		info.setCreateTime(new Date());
		info.setCreateOperator(user.getUserName());
		info.setCreateTime(new Date());
		orderExecutiveInfoMapper.insertSelective(info);
		orderExecutionplanMapper.deleteByOrderId(record.getId());//未审核的数据,更改基本信息可能频繁,物理删除
		createPlansByOrder(record,trade,user.getUserName());//重新保存执行信息
		createDocument(user.getUserName(), record, trade);//重新保存单据文件信息
		return Triplet.with(Boolean.TRUE, record,"下单成功! ");
	}

	/**
	 * 创建执行信息
	 * @param order 进口代理 仓储 物流 垫税 货押
	 * @param trade getTransportType 运输方式
	 * @param actorName
	 */
	private void createPlansByOrder(Order order, OrderTrade trade,String actorName) {
		//执行信息更新
		List<Integer> ids = SysConfig.ServiceType.getServerTypeIdsByAgent(order.getImportAgent(), order.getWarehouseAgent(),
				order.getDeliveryAgent(), order.getCargoMortgageFinancingAgent(), order.getPayImportTaxAgent());
		List<WorkTypeResponse> workTypeList = workTypeMapper.selectByServerIds(ids);
		Boolean isSea = trade.getTransportType() == 1;//1、海�
		Boolean isAir = trade.getTransportType() == 2;//2、空�
		//空运海运必选项�
		workTypeList.stream().filter(q->{return q.getIsAir()==isAir || q.getIsSea() == isSea;}).forEach(q->{
			OrderExecutionplan plan = new OrderExecutionplan();
			plan.setId(new ObjectId().toString());
			plan.setOrderId(order.getId());
			if(isAir) plan.setStatus(q.getIsAirInnerState());
			if(isSea) plan.setStatus(q.getIsSeaInnerState());
			plan.setServerId(q.getServerId());
			plan.setWorkId(q.getId());
			plan.setSort(q.getSort());
			plan.setCreateOperator(actorName);
			plan.setCreateTime(new Date());
			orderExecutionplanMapper.insertSelective(plan);
		});
	}
	private void createDocument(String actorName, Order order, OrderTrade trade) {
		BillType record = new BillType();
		if(trade.getTransportType() == 1){//海运
			if(order.getImportAgent() == 1){//贸易代理
				record.setIsSeaAgent(true);
			}else{//进口�
				record.setIsSeaEclare(true);
			}
		}else{
			if(order.getImportAgent() == 1){//贸易代理
				record.setIsAirAgent(true);
			}else{//进口�
				record.setIsAirEclare(true);
			}
		}
		record.setValid(true);
		List<BillType> billList = billTypeMapper.selectByBillType(record);//必选的文件类型
		Map<String,Object> map = new HashMap<>();
		map.put("orderId",order.getId());
		map.put("actorName", actorName);
		map.put("uptTime", new Date());
		orderDocumentMapper.isDelDocumentByUnUpload(map);
		for (int i = 0; i < billList.size(); i++) {
			BillType bill = billList.get(i);
			OrderDocument document = new OrderDocument();
			document.setId(new ObjectId().toString());
			document.setBillId(bill.getId());//关联系统单据id
			document.setOrderId(order.getId());//关联订单
			document.setCreateOperator(actorName);
			document.setCreateTime(new Date());
			orderDocumentMapper.insertSelective(document);
		}
	}
}