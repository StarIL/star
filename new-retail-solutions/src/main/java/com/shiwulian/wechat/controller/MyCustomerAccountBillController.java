package com.shiwulian.wechat.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shiwulian.wechat.bean.Response;
import com.shiwulian.wechat.bean.request.CustomerAccountBillRequest;
import com.shiwulian.wechat.service.fn.CustomerAccountBillService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="资金流水相关接口")
@Controller
@RequestMapping("/myCustomerAccountBill")
public class MyCustomerAccountBillController {
	
	private static final Logger logger = LoggerFactory.getLogger(MyCustomerAccountBillController.class);
	
	@Autowired
	CustomerAccountBillService customerAccountBillService;
	/**
	 * 查询我的企业信息
	 * @return
	 */
	@RequestMapping(value = "/query")
	@ApiOperation(value = "查询资金流水信息", httpMethod = "GET",produces = "application/json")
	public @ResponseBody Response<Object> queryMyCustomerAccountBill(@RequestBody CustomerAccountBillRequest accountBillRequest) {
		Response<Object> response = null;
		try {
			response = customerAccountBillService.queryMyAccountBill(accountBillRequest);
		} catch (Exception e) {
			logger.error("myCustomerAccountBill/query Exception:", e);
		}
		return response;
	}
	
	
}
