package com.shiwulian.wechat.service.od;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shiwulian.wechat.bean.response.OrderWorkResponse;
import com.shiwulian.wechat.mapper.od.OrderExecutionplanMapper;

@Service
public class OrderExecutionplanService {
	@Autowired
	private OrderExecutionplanMapper orderExecutionplanMapper;
	
	public List<OrderWorkResponse> selectParam(String orderIds,Integer limit){
		Map<String,Object> map = new HashMap<>(2);
		map.put("orderIds", Arrays.asList(orderIds.split(",")));
		map.put("limit", limit);
		return orderExecutionplanMapper.selectParam(map);
	}
}
