package com.shiwulian.wechat.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shiwulian.wechat.bean.Response;
import com.shiwulian.wechat.bean.bs.Warehouse;
import com.shiwulian.wechat.bean.response.WarehouseResponse;
import com.shiwulian.wechat.service.bs.WarehouseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="仓库相关接口")
@Controller
@RequestMapping(value = "warehouse")
public class WarehouseController {
	@Autowired
	private WarehouseService warehouseService;

	@ResponseBody
	@RequestMapping(value = "/queryList")
	@ApiOperation(value = "获取所有仓库", httpMethod = "GET",produces = "application/json")
	public Response<Object> list() {
		Response<Object> obj = new Response<Object>(false);
		List<WarehouseResponse> result = warehouseService.selectResponse();
		obj.setSuccess(result != null && result.size() > 0);			
		obj.setData(result);
		return obj;
	}
	
	/***
	 * 获取所有仓库
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/queryAllList")
	@ApiOperation(value = "获取所有仓库(+冗余)", httpMethod = "GET",produces = "application/json")
	public Response<Object> queryAllList() {
		Response<Object> obj = new Response<Object>(false);
		List<Warehouse> result = warehouseService.selectAll();
		obj.setSuccess(result != null && result.size() > 0);			
		obj.setData(result);
		return obj;
	}
}
