package com.shiwulian.wechat.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shiwulian.wechat.bean.Response;
import com.shiwulian.wechat.bean.bs.Customer;
import com.shiwulian.wechat.context.UserAuthContext;
import com.shiwulian.wechat.service.bs.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="我的企业相关接口")
@Controller
@RequestMapping("/myCustomer")
public class MyCustomerController {
	
	private static final Logger logger = LoggerFactory.getLogger(MyCustomerController.class);
	
	@Autowired
	CustomerService customerService;
	
	/**
	 * 查询我的企业信息
	 * @return
	 */
	@RequestMapping(value = "/query")
	@ApiOperation(value = "查询我的企业", httpMethod = "GET",produces = "application/json")
	public @ResponseBody Response<Object> queryMyCustomer() {
		Response<Object> response = null;
		try {
			response = customerService.selectMyCustomerByUid(UserAuthContext.getLocal().getId());
		} catch (Exception e) {
			logger.error("myCustomer/query Exception:", e);
		}
		return response;
	}
	/**
	 * 更新我的企业信息
	 * @param customer
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	@ApiOperation(value = "保存我的企业", httpMethod = "POST",produces = "application/json")
	public  Response<Object> saveMyCustomer(@RequestBody Customer customer) {
		Response<Object> response = null;
		try {
			response = customerService.saveMyCustomer(customer);
		} catch (Exception e) {
			logger.error("myCustomer/save Exception:", e);
		}
		return response;
	}
	
}
