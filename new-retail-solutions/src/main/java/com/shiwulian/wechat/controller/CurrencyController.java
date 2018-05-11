package com.shiwulian.wechat.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shiwulian.wechat.bean.Response;
import com.shiwulian.wechat.bean.sys.Currency;
import com.shiwulian.wechat.mapper.sys.CurrencyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="币种相关接口")
@Controller
@RequestMapping(value = "/currency")
public class CurrencyController {

	@Autowired
	private CurrencyService currencyService;

	@RequestMapping(value = "/queryList",method = RequestMethod.GET)
	@ApiOperation(value = "查询币种", httpMethod = "GET",produces = "application/json")
	public @ResponseBody Response<Object> queryList() {
		List<Currency> currencys = currencyService.selectList();
		return new Response<>(Boolean.TRUE, currencys);
	}
}
 