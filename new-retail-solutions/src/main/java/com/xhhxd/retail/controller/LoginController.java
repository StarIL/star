package com.xhhxd.retail.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.javatuples.Triplet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.Result;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.xhhxd.retail.bean.Response;
import com.xhhxd.retail.bean.bs.BsUser;
import com.xhhxd.retail.bean.request.LoginRequest;
import com.xhhxd.retail.service.bs.UserService;
import com.xhhxd.retail.validator.bs.LoginRequestValidator;



@Controller
@RequestMapping
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String index() {
		return "login";
	}
	
	@RequestMapping(value = "loginsubmit", method = RequestMethod.POST)	
	public @ResponseBody Response<Map<String, String>> loginsubmit(LoginRequest request) {
		Response<Map<String, String>> response = new Response<>(false, new HashMap<String, String>());
		try {
			request.putUserTypes(2, 3);
			Result validator = FluentValidator.checkAll().on(request, new LoginRequestValidator()).doValidate().result(ResultCollectors.toSimple());
			if (validator.isSuccess()) {
				request.setPassword(DigestUtils.sha256Hex(request.getPassword()));
				Triplet<Boolean, String, BsUser> triplet = userService.login(request);
				if (triplet.getValue0()) {
					BsUser curr = triplet.getValue2();
					UsernamePasswordToken token = new UsernamePasswordToken(curr.getUsername(), curr.getPassword(), request.getIsRecordPwd());
					SecurityUtils.getSubject().login(token);
					response.setSuccess(Boolean.TRUE);
				} else {
					response.setMsg(triplet.getValue1());
				}
			} else {
				response.setMsg(validator.getErrors().get(0));
			}
		} catch (Exception e) {
			logger.error("loginsubmit error {}", e);
		}
		return response;
	}

}
