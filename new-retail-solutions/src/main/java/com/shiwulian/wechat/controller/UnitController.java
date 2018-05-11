package com.shiwulian.wechat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shiwulian.wechat.bean.Response;
import com.shiwulian.wechat.bean.sys.Unit;
import com.shiwulian.wechat.service.sys.UnitService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="单位相关接口")
@Controller
@RequestMapping(value = "/unit")
public class UnitController {
	@Autowired
	private UnitService unitService;

	@RequestMapping(value = "/queryList")
	@ApiOperation(value = "单位列表", httpMethod = "GET", produces = "application/json")
	public @ResponseBody Response<Object> queryList() {
		List<Unit> units = unitService.selectList();
		return new Response<>(Boolean.TRUE, units);
	}
}
