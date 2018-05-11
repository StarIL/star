package com.shiwulian.wechat.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shiwulian.wechat.bean.Response;
import com.shiwulian.wechat.bean.lg.Destination;
import com.shiwulian.wechat.service.lg.DestinationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="门点相关接口")
@Controller
@RequestMapping(value = "destination")
public class DestinationController {
	@Autowired
	private DestinationService destinationService;

	@ResponseBody
	@RequestMapping(value = "queryList")
	@ApiOperation(value = "查询门点列表", httpMethod = "GET",produces = "application/json")
	public Response<Object> list() {
		Response<Object> obj = new Response<Object>(false);
		List<Destination> request = destinationService.list();
		if (request != null) {
			obj.setData(request);
			obj.setSuccess(request.size() > 0);
		}
		return obj;
	}

	@ResponseBody
	@RequestMapping(value = "getById")
	@ApiOperation(value = "根据id查询门点", httpMethod = "GET",produces = "application/json")
	public Response<Object> getById(String id) {
		Response<Object> obj = new Response<Object>(false);
		Destination request = destinationService.selectByPrimaryKey(id);
		if (request != null) {
			obj.setData(request);
			obj.setSuccess(request != null);
		}
		return obj;
	}
}
