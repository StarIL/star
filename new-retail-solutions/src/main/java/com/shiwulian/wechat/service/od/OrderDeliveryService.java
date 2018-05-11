package com.shiwulian.wechat.service.od;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shiwulian.wechat.bean.od.OrderDelivery;
import com.shiwulian.wechat.mapper.od.OrderDeliveryMapper;

@Service
public class OrderDeliveryService {
	@Autowired
	private OrderDeliveryMapper orderDeliveryMapper;

	public OrderDelivery selectByPrimaryKey(String orderId) {
		return orderDeliveryMapper.selectByPrimaryKey(orderId);
	}
}
