package com.shiwulian.wechat.service.od;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiwulian.wechat.bean.od.OrderTrade;
import com.shiwulian.wechat.mapper.od.OrderTradeMapper;

@Service
public class OrderTradeService {

	@Autowired
	private OrderTradeMapper orderTradeMapper;
	
	public OrderTrade selectByOrderId(String orderId){
		return orderTradeMapper.selectByOrderId(orderId);
	}
}
