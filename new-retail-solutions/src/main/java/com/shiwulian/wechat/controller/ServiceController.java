package com.shiwulian.wechat.controller;




import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 静态路由
 */
@Controller
@RequestMapping(value = "service")
public class ServiceController {
	@RequestMapping(value = "/agent", method = RequestMethod.GET)
	public String agent() {
		return "service/agent";
	}	
	
	@RequestMapping(value = "/finance", method = RequestMethod.GET)
	public String finance() {
		return "service/finance";
	}	
}