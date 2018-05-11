package com.shiwulian.wechat.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shiwulian.wechat.bean.Response;
import com.shiwulian.wechat.bean.sys.TradeTerm;
import com.shiwulian.wechat.mapper.sys.TradeTermService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="贸易条款相关接口")
@Controller
@RequestMapping(value = "/tradeTerm")
public class TradeTermController {
	@Autowired
	private TradeTermService tradeTermService;

	@ApiOperation(value = "贸易条款列表", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/queryList")
	public @ResponseBody Response<Object> queryList() {
		List<TradeTerm> tradeTerms = tradeTermService.selectList();
		return new Response<>(Boolean.TRUE, tradeTerms);
	}
}
