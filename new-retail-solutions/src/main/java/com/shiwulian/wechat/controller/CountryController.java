package com.shiwulian.wechat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shiwulian.wechat.bean.Response;
import com.shiwulian.wechat.bean.sys.Country;
import com.shiwulian.wechat.service.sys.CountryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="国家相关接口")
@Controller
@RequestMapping(value = "country")
public class CountryController {
	@Autowired
	private CountryService countryService;
	

	@RequestMapping(value = "/queryList",method = RequestMethod.GET)
	@ApiOperation(value = "关键词查询国家列表", httpMethod = "GET",produces = "application/json")
	@ResponseBody
	public Response<Object> querySelect(Boolean isChina,String countryName){
		Response<Object> resp = new Response<Object>(false);
		List<Country> countryList = countryService.queryByKeyWord(isChina, countryName);
		resp.setData(countryList);
		if(countryList!=null)
			resp.setSuccess(countryList.size()>0);
		return resp;
	}
}
