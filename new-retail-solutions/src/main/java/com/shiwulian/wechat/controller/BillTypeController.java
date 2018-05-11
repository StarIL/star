package com.shiwulian.wechat.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.shiwulian.wechat.bean.Response;
import com.shiwulian.wechat.bean.sys.BillType;
import com.shiwulian.wechat.service.sys.BillTypeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "系统文件类型")
@Controller
@RequestMapping(value = "/billType")
public class BillTypeController {

	@Autowired
	private BillTypeService billTypeService;

	@RequestMapping(value = "/queryList",method = RequestMethod.GET)
	@ApiOperation(value = "查询系统文件类型列表", httpMethod = "GET",produces = "application/json")
	public @ResponseBody Response<Object> queryList() {
		List<BillType> billTypes = billTypeService.selectList(null);
		return new Response<>(Boolean.TRUE, billTypes);
	}
}
