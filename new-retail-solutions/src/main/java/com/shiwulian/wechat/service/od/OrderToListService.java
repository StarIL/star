package com.shiwulian.wechat.service.od;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiwulian.wechat.bean.od.OrderTodolist;
import com.shiwulian.wechat.mapper.od.OrderTodolistMapper;

@Service
public class OrderToListService {

	@Autowired
	private OrderTodolistMapper orderTodoListMapper;

	public List<OrderTodolist> selectList(String orderIds) {
		List<String> orderIdArr = Arrays.asList(orderIds.split(","));
		return orderTodoListMapper.selectList(orderIdArr);
	}
}
