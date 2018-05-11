package com.shiwulian.wechat.service.od;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiwulian.wechat.bean.od.OrderExecutiveInfo;
import com.shiwulian.wechat.mapper.od.OrderExecutiveInfoMapper;

@Service
public class OrderExecutiveInfoService {

	@Autowired
	private OrderExecutiveInfoMapper orderExecutiveInfoMapper;

	public OrderExecutiveInfo selectByPrimaryKey(String orderId) {
		return orderExecutiveInfoMapper.selectByPrimaryKey(orderId);
	}
}