package com.shiwulian.wechat.controller;

import java.math.BigDecimal;
import java.util.List;
import org.javatuples.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.shiwulian.wechat.bean.Response;
import com.shiwulian.wechat.bean.response.OrderInComeResponse;
import com.shiwulian.wechat.bean.response.OrderSettlementResponse;
import com.shiwulian.wechat.service.od.OrderSettlementService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="费用相关接口")
@Controller
@RequestMapping(value = "/mySettlement")
public class MySettlementController {
	private static final Logger logger = LoggerFactory.getLogger(MyOrderController.class);

	@Autowired
	private OrderSettlementService orderSettlementService;
	
	@RequestMapping(value = "/queryList",method = RequestMethod.GET)
	@ApiOperation(value = "查询订单费用", httpMethod = "GET",produces = "application/json")
	public @ResponseBody Response<Object> queryList(String orderId) {
		Response<Object> response = new Response<>(false);
		try {
			List<OrderSettlementResponse> settlements = orderSettlementService.selectList(orderId);
			response.setSuccess(settlements != null && settlements.size() > 0);
			response.setData(settlements);
		} catch (Exception e) {
			logger.error("queryList error {}", e);
		}
		return response;
	}
	
	@RequestMapping(value = "/queryCny",method = RequestMethod.GET)
	@ApiOperation(value = "查询订单费用大类", httpMethod = "GET",produces = "application/json")
	public @ResponseBody Response<Object> queryCny(String orderId) {
		Response<Object> response = new Response<>(false);
		try {
			Pair<BigDecimal,List<OrderInComeResponse>> pair = orderSettlementService.selectInCome(orderId);
			response.setSuccess(pair.getValue1() != null && pair.getValue1().size() > 0);
			response.setData(pair);
		} catch (Exception e) {
			logger.error("queryCny error {}", e);
		}
		return response;
	}
}
