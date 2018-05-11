package com.shiwulian.wechat.service.od;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiwulian.wechat.bean.od.OrderTradeItem;
import com.shiwulian.wechat.mapper.od.OrderTradeItemMapper;

@Service
public class OrderTradeItemService {
	@Autowired
	private OrderTradeItemMapper orderTradeItemMapper;
	
	public List<OrderTradeItem> selectList(String orderId){
		return orderTradeItemMapper.selectList(orderId);
	}
}
