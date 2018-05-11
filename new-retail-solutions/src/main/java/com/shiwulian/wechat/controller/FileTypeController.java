package com.shiwulian.wechat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shiwulian.wechat.bean.Response;
import com.shiwulian.wechat.bean.sys.FileType;
import com.shiwulian.wechat.service.sys.FileTypeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="附件类型相关接口")
@Controller
@RequestMapping(value = "/fileType")
public class FileTypeController {

	@Autowired
	private FileTypeService fileTypeService;

	@RequestMapping(value = "/queryList")
	@ApiOperation(value = "附件类型列表", httpMethod = "GET",produces = "application/json")
	public @ResponseBody Response<Object> queryList() {
		List<FileType> fileTypes = fileTypeService.selectList(null);
		return new Response<>(Boolean.TRUE, fileTypes);
	}
}