package com.shiwulian.wechat.service.od;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shiwulian.wechat.bean.od.OrderStorage;
import com.shiwulian.wechat.mapper.od.OrderStorageMapper;

@Service
public class OrderStorageService {
	@Autowired
	private OrderStorageMapper orderStorageMapper;

	public OrderStorage selectByPrimaryKey(String orderId) {
		return orderStorageMapper.selectByPrimaryKey(orderId);
	}
}
