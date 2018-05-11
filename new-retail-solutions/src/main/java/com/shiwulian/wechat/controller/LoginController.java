package com.shiwulian.wechat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.Result;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.shiwulian.wechat.bean.Response;
import com.shiwulian.wechat.bean.bs.User;
import com.shiwulian.wechat.bean.request.CustomerResgisterRequest;
import com.shiwulian.wechat.bean.request.ThirdPartyBindRequest;
import com.shiwulian.wechat.bean.request.UserRegisterRequest;
import com.shiwulian.wechat.core.cache.RedisManager;
import com.shiwulian.wechat.core.wechat.OAuth2Scope;
import com.shiwulian.wechat.service.bs.CustomerService;
import com.shiwulian.wechat.service.bs.SmsVerifyCodeService;
import com.shiwulian.wechat.service.bs.UserService;
import com.shiwulian.wechat.service.validators.ThirdPartyBindRequestValidator;
import com.shiwulian.wechat.service.validators.UserRegisterRequestValidator;
import com.shiwulian.wechat.util.Const;
import com.shiwulian.wechat.util.CookieUtil;
import com.shiwulian.wechat.util.DESUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="登录相关接口")
@Controller
@RequestMapping
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserService userService;
	@Autowired
	private SmsVerifyCodeService smsVerifyCodeService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private RedisManager redisManager;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String index() {
		return "login";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		return "user/register";
	}
	
	@RequestMapping(value = "/regCorp", method = RequestMethod.GET)
	public ModelAndView regCorp(String t) {
		ModelAndView mv = new ModelAndView("user/regCorp");
		mv.addObject("t", t);
		return mv;
	}
	
	@RequestMapping(value = "/retrievePwd", method = RequestMethod.GET)
	public String retrieve() {
		return "user/retrievePwd";
	}
	
	/**
	 * 帐号绑定
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/bind", method = RequestMethod.POST)
	@ApiOperation(value = "帐号绑定", httpMethod = "POST",produces = "application/json")
	public @ResponseBody Response<Object> thirdPartyBind(@RequestBody ThirdPartyBindRequest request,HttpServletRequest httpRequest , HttpServletResponse httpResponse) {
		Response<Object> response = new Response<>(false);
		try {
			String uuid = httpRequest.getSession().getId();
			Result validator = FluentValidator.checkAll().putAttribute2Context("validatorCallback", uuid).on(request, new ThirdPartyBindRequestValidator(smsVerifyCodeService,userService)).doValidate().result(ResultCollectors.toSimple());
			if(validator.isSuccess()){
				String uid = Const.validatorResultToken.get(uuid);
				if(StringUtils.isNotBlank(uid)){
					userIdSetCookie(httpResponse, uid);
					response.setSuccess(true);
				}
			}else{
				response.setMsg(validator.getErrors().get(0));
			}			
		} catch (Exception e) {
			logger.error("thirdPartyBind error {}", e);
		}
		return response;
	}
	/**
	 * userid 存 cookie
	 */
	private void userIdSetCookie(HttpServletResponse httpResponse, String id) {
		byte[] result = DESUtil.encrypt(id.getBytes(),OAuth2Scope.account_id_des_Key);
		String accId = DESUtil.bytesToHex(result);
		CookieUtil.setCookie(httpResponse, OAuth2Scope.wechat_account_id, accId);
	}	
	
	/**
	 * 校验手机号验证码(修改手机WeChatUptMobile/修改邮箱WeChatUptEmail/修改密码WeChatUptPwd/注册企业WeChatReComp)
	 * @param request 注册参数
	 * @param bizScope 验证码标码(修改手机WeChatUptMobileOld/修改邮箱WeChatUptEmail/修改密码WeChatUptPwd/注册企业WeChatReComp)
	 */
	@RequestMapping(value = "verifyMobile", method = RequestMethod.POST)
	@ApiOperation(value = "校验手机验证", httpMethod = "POST",produces = "application/json")
	public @ResponseBody Response<Object> verifyMobile(String mobile,String verifyCode,String bizScope) {
		Response<Object> response= new Response<>(false); 
		try {
			if(StringUtils.isBlank(mobile) || StringUtils.isBlank(verifyCode)){
				response.setMsg("验证码不能为空！");
				return response;
			}
			Pair<Boolean, String> pair = smsVerifyCodeService.checkCode(bizScope, mobile, verifyCode);
			response.setSuccess(pair.getValue0());
			response.setMsg(pair.getValue1());
		} catch (Exception e) {
			response.setMsg("出现异常:"+e.getMessage());
			e.printStackTrace();
			logger.error("login error {}",e);
		}		
		return response;
	}

	
	/**
	 * 发送验证码
	 * @param bizScope 验证码标识[WeChatLogin登录 / WeChatRegister注册 / ]
	 * @param mobile 手机码
	 * @author liXin
	 */
	@RequestMapping(value = "/smsSend")
	@ApiOperation(value = "发送验证码", httpMethod = "POST",produces = "application/json",tags = {"",""})	
	public @ResponseBody Response<Object> smsSend(@RequestParam(required = true,defaultValue="WeChatLogin") String bizScope,String mobile) {
		Response<Object> response = new Response<Object>(true);
		try { 
			Pair<Boolean, String> pair = smsVerifyCodeService.smsVerifyCode(mobile, bizScope);
			response.setSuccess(pair.getValue0());
			response.setMsg(pair.getValue1());
		} catch (Exception e) {
			logger.error("user login mobile send verify code error {}", e);
			response.setSuccess(Boolean.FALSE);
			response.setMsg(e.getMessage());
		}
		return response;
	}
	/**
	 * 找回密码 
	 * 2:校验手机号验证码
	 * bizScope:WeChatRetrievePwd
	 */
	@RequestMapping(value = "uptPwdVerify", method = RequestMethod.POST)
	@ApiOperation(value = "找回密码 - 校验手机验证", httpMethod = "POST",produces = "application/json")
	public @ResponseBody Response<Object> uptPwdVerify(String mobile,String verifyCode) {
		Response<Object> response= new Response<>(false); 
		try {
			if(StringUtils.isBlank(mobile) || StringUtils.isBlank(verifyCode)){
				response.setMsg("验证码不能为空！");
				return response;
			}
			Pair<Boolean, String> pair = smsVerifyCodeService.checkCode("WeChatRetrievePwd", mobile, verifyCode);
			if(pair.getValue0()){
				String UUID = java.util.UUID.randomUUID().toString();
				Const.ResetPasswordUserToken.put(UUID, mobile);
				response.setData(UUID);
			}
			response.setSuccess(pair.getValue0());
			response.setMsg(pair.getValue1());
		} catch (Exception e) {
			response.setMsg("出现异常:"+e.getMessage());
			e.printStackTrace();
			logger.error("login error {}",e);
		}		
		return response;
	}
	/**
	 * 找回密码 
	 * 3:修改密码
	 * @param password 新密码
	 * @param token 2步返回的data
	 */
	@RequestMapping(value = "uptPwd", method = RequestMethod.POST)
	@ApiOperation(value = "修改密码", httpMethod = "POST",produces = "application/json")
	@ResponseBody
	public Response<Object> uptPwd(String password,String token) {
		Response<Object> response= new Response<>(false); 
		try {
			String mobile = Const.ResetPasswordUserToken.get(token).toString();
			Triplet<Boolean, User, String> triplet = userService.uptPwd(mobile, password);
			if(triplet.getValue0()){
				redisManager.del("shiro_cache:auth_" + triplet.getValue1().getUserName());
			}
			response.setSuccess(triplet.getValue0());
			response.setMsg(triplet.getValue2());
		} catch (Exception e) {
			response.setMsg("出现异常:"+e.getMessage());
			e.printStackTrace();
			logger.error("login error {}",e);
		}		
		return response;
	}
	/**
	 * 注册
	 * 1:注册账号 
	 * @param request 注册参数
	 * @param bizScope 验证码标识[ default = WeChatRegister ]
	 */
	@RequestMapping(value = "registerSubmit", method = RequestMethod.POST)
	@ApiOperation(value = "注册并绑定", httpMethod = "POST",produces = "application/json")
	@ResponseBody
	public Response<Object> register(@RequestBody UserRegisterRequest request,HttpServletRequest httpRequest , HttpServletResponse httpResponse) {
		Response<Object> response= new Response<>(false); 
		try {
			Result validator = FluentValidator.checkAll().on(request, new UserRegisterRequestValidator(userService,smsVerifyCodeService)).doValidate().result(ResultCollectors.toSimple());
			if(validator.isSuccess()){
				Triplet<Boolean, User,String> triplet = userService.register(request,1);
				if(triplet.getValue0()){
					User user = triplet.getValue1();
					String token = java.util.UUID.randomUUID().toString();
					Const.RegCompanyUserToken.put(token, user);
					response.setData(token);
				}
				response.setSuccess(triplet.getValue0());	
			}else{
				response.setMsg(validator.getErrors().get(0));
			}
		} catch (Exception e) {
			response.setMsg("注册失败，请稍后重试");
			logger.error("registerSubmit error {}",e);
		}		
		return response;
	}
	/**
	 * 注册
	 * 2 注册企业
	 */
	@RequestMapping(value = "registerComp", method = RequestMethod.POST)
	@ApiOperation(value = "注册企业", httpMethod = "POST",produces = "application/json")
	@ResponseBody
	public Response<Object> registerComp(String token,String compName, HttpServletRequest httpRequest , HttpServletResponse httpResponse) {
		Response<Object> response= new Response<>(false);		
		try {
			User user =  Const.RegCompanyUserToken.get(token);
			if(customerService.selectByName(compName) != null){
				response.setMsg("企业名称已存在");
				return response;
			};
			if(user!=null){
				CustomerResgisterRequest request = new CustomerResgisterRequest();
				request.setUid(user.getId());
				request.setCustomerName(compName);
				customerService.insertCustomer(request, user.getUserName());
				response.setSuccess(true);
				response.setMsg("注册企业成功");
			}else{
				response.setMsg("非法注册! ");
			}
		} catch (Exception e) {
			response.setMsg("出现异常:"+e.getMessage());
			e.printStackTrace();
			logger.error("login error {}",e);
		}		
		return response;
	}
}
