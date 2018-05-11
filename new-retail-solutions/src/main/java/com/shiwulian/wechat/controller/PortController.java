package com.shiwulian.wechat.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shiwulian.wechat.bean.Response;
import com.shiwulian.wechat.bean.response.SelectResponse;
import com.shiwulian.wechat.bean.sys.Port;
import com.shiwulian.wechat.service.sys.PortService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="港口相关接口")
@Controller
@RequestMapping("/port")
public class PortController {
	@Autowired
	private PortService portService;
	
	/**
	 * 查询港口所在市
	 */
	@RequestMapping(value = "/querySelect")
	@ApiOperation(value = "查询港口所在市", httpMethod = "GET",produces = "application/json")
	@ResponseBody
	public Response<List<SelectResponse>> querySelect() {
		Response<List<SelectResponse>> response = new Response<>(false);
		response.setData(portService.selectList());
		response.setSuccess(true);
		return response;
	}

	@RequestMapping(value = "/queryList")
	@ApiOperation(value = "查询港口", httpMethod = "GET",produces = "application/json")
	@ResponseBody
	public Response<Object> list() {
		Response<Object> response = new Response<>(false);
		List<Port> ports = portService.selectByMap();
		response.setData(ports);
		response.setSuccess(ports != null && ports.size() > 0);
		return response;
	}	
	
}
