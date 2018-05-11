package com.shiwulian.wechat.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.shiwulian.wechat.bean.Response;
import com.shiwulian.wechat.bean.sys.ServerType;
import com.shiwulian.wechat.service.sys.ServerTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "服务项目相关")
@Controller
@RequestMapping(value = "/serverType")
public class ServerTypeController {

	@Autowired
	private ServerTypeService serverTypeService;

	@RequestMapping(value = "/queryList",method = RequestMethod.GET)
	@ApiOperation(value = "服务项目", httpMethod = "GET", produces = "application/json")
	public @ResponseBody Response<Object> queryList() {
		List<ServerType> serverTypes = serverTypeService.selectList(null);
		return new Response<>(Boolean.TRUE, serverTypes);
	}
}
