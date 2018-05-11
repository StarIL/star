package com.shiwulian.wechat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shiwulian.wechat.bean.Response;
import com.shiwulian.wechat.bean.sys.PaymentTerm;
import com.shiwulian.wechat.service.sys.PaymentTermService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="结算方式相关接口")
@Controller
@RequestMapping(value = "/paymentTerm")
public class PaymentTermController {
	@Autowired
	private PaymentTermService paymentTermService;

	@RequestMapping(value = "/queryList")
	@ApiOperation(value = "结算方式列表", httpMethod = "GET",produces = "application/json")
	public @ResponseBody Response<Object> queryList() {
		List<PaymentTerm> paymentTerms = paymentTermService.selectList();
		return new Response<>(Boolean.TRUE, paymentTerms);
	}
}
