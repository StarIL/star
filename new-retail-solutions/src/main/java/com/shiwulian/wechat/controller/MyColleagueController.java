package com.shiwulian.wechat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;

@Api(tags="我的同事")
@Controller
@RequestMapping(value = "/myColleague")
public class MyColleagueController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "myColleague/index";
	}
	@RequestMapping(value = "colleague", method = RequestMethod.GET)
	public String colleague() {
		return "myColleague/colleague";
	}
}
