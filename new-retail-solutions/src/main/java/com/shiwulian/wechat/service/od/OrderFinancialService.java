package com.shiwulian.wechat.service.od;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shiwulian.wechat.bean.od.OrderFinancial;
import com.shiwulian.wechat.mapper.od.OrderFinancialMapper;

@Service
public class OrderFinancialService {
	@Autowired
	private OrderFinancialMapper orderFinancialMapper;

	public OrderFinancial selectByPrimaryKey(String orderId) {
		return orderFinancialMapper.selectByPrimaryKey(orderId);
	}
}
