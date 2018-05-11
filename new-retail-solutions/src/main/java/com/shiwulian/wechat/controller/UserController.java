//package com.shiwulian.wechat.controller;
//
//import java.io.IOException;
//import java.io.UnsupportedEncodingException;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.apache.commons.lang3.StringUtils;
//import org.javatuples.Pair;
//import org.javatuples.Triplet;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.view.RedirectView;
//
//import com.baidu.unbiz.fluentvalidator.FluentValidator;
//import com.baidu.unbiz.fluentvalidator.Result;
//import com.baidu.unbiz.fluentvalidator.ResultCollectors;
//import com.shiwulian.wechat.bean.Response;
//import com.shiwulian.wechat.bean.bs.User;
//import com.shiwulian.wechat.bean.request.CustomerResgisterRequest;
//import com.shiwulian.wechat.bean.request.ThirdPartyBindRequest;
//import com.shiwulian.wechat.bean.request.UserRegisterRequest;
//import com.shiwulian.wechat.bean.response.UserInfoResponse;
//import com.shiwulian.wechat.core.annotation.Oauth2;
//import com.shiwulian.wechat.core.wechat.OAuth2Scope;
//import com.shiwulian.wechat.core.wechat.ThirdPartyWechatService;
//import com.shiwulian.wechat.core.wechat.bean.ThirdPartyCallBackResult;
//import com.shiwulian.wechat.service.bs.CustomerService;
//import com.shiwulian.wechat.service.bs.SmsVerifyCodeService;
//import com.shiwulian.wechat.service.bs.UserService;
//import com.shiwulian.wechat.service.validators.ThirdPartyBindRequestValidator;
//import com.shiwulian.wechat.util.Constant;
//import com.shiwulian.wechat.util.CookieUtil;
//import com.shiwulian.wechat.util.JsonUtil;
//import com.shiwulian.wechat.util.WebUtil;
//
//import io.swagger.annotations.ApiOperation;
//
///**
// * 前微信授权 存档 代码 @author yuXiaoBo
// */
//@Controller
//@RequestMapping(value = "user")
//public class UserController {
//	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
//
//	@Autowired
//	private UserService userService;
//	@Autowired
//	private ThirdPartyWechatService thirdPartyWechatService;
//	@Autowired
//	private SmsVerifyCodeService smsVerifyCodeService;
//	@Autowired
//	private CustomerService customerService;
//
//	@Oauth2(required = true)
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String index() {
//		return "myAccount/index";
//	}
//	@RequestMapping(value = "/info", method = RequestMethod.GET)
//	public String info() {
//		return "myAccount/info";
//	}
//	/**
//	 * 
//	 * @param redirectUrl
//	 * @param request
//	 * @return
//	 */
//	@RequestMapping(value = "/oauth2",method = RequestMethod.GET)
//	public String oauth2(String redirectUrl,HttpServletRequest request) throws UnsupportedEncodingException {
//		String callbackUrl = String.format(OAuth2Scope.third_party_callback_url,redirectUrl);
//		String openId = CookieUtil.getCookie(request, OAuth2Scope.open_id);
//		if (StringUtils.isNotBlank(openId)) {
//			User user = thirdPartyWechatService.selectByOpenid(openId);
//			return  "redirect:" + (user != null ?  "myAccount/":String.format(OAuth2Scope.third_party_url,redirectUrl));
//		}
//		return "redirect:" + thirdPartyWechatService.authorizeUrl(callbackUrl, OAuth2Scope.snsapi_base);
//	}
//
//	/**
//	 * 授权成功回调
//	 * 
//	 * @param code
//	 * @param state
//	 * @param request
//	 * @param response
//	 */
//	@RequestMapping(value = "/callback",method = RequestMethod.GET)
//	public void callBack(String code, String state,String redirectUrl, HttpServletRequest request, HttpServletResponse response) throws IOException {		
//		HttpSession session = request.getSession();
//		Triplet<Boolean, ThirdPartyCallBackResult, String> triplet = thirdPartyWechatService.callBack(code,state,session.getId());
//		if (triplet.getValue0()) {
//			ThirdPartyCallBackResult thirdParty = triplet.getValue1();
//			if (thirdParty.getIsNeedRedirectBindPage()) { // 跳转到绑定页�
//				Constant.thirdPartyToken.put(OAuth2Scope.third_party_bind, thirdParty.getOauthId());
//				CookieUtil.setCookie(response, OAuth2Scope.open_id, thirdParty.getOpenId());
//				WebUtil.sendRedirect(request, response, "/myAccount/thirdParty?redirectUrl=" + redirectUrl);
//				return;
//			} else {// 使用第三方登录
//				User user = thirdPartyWechatService.selectByPrimaryKey(thirdParty.getUserId());
//				if (user != null && user.getUserType() == 1) {
//					session.setAttribute(OAuth2Scope.open_id, user.getWechatOpenid());
//					CookieUtil.setCookie(response, OAuth2Scope.open_id, user.getWechatOpenid());
//					WebUtil.sendRedirect(request, response, request.getServletPath());
//					return;
//				}else{ //账户不可用
//					
//				}
//			}
//		} else {
//			response.setContentType("application/json;charset=UTF-8");
//			response.getWriter().write(JsonUtil.toJSON(new Response<>(false,triplet.getValue2())));
//		}
//	}
//
//	/**
//	 * 帐号绑定
//	 * 
//	 * @param redirectUrl
//	 * @return
//	 */
//	@Oauth2(required = true)
//	@RequestMapping(value = "/thirdParty", method = RequestMethod.GET)
//	public ModelAndView thirdParty(String redirectUrl,HttpServletRequest request) {
//		ModelAndView mv = new ModelAndView("/myAccount/thirdParty");
//		String userOauthId = Constant.thirdPartyToken.get(OAuth2Scope.third_party_bind);
//		if(StringUtils.isNotBlank(userOauthId)){
//			mv.addObject("redirectUrl", redirectUrl);
//			return mv;
//		}else{
//			Constant.thirdPartyToken.remove(OAuth2Scope.third_party_bind);
//			RedirectView redirectView = new RedirectView(request.getContextPath() + "/login/");
//			mv = new ModelAndView(redirectView);			
//			return mv;
//		}
//	}
//	
//	/**
//	 * 帐号绑定
//	 * @param request
//	 * @return
//	 */
//	@Oauth2(required = true)
//	@RequestMapping(value = "/thirdPartyBind", method = RequestMethod.POST)
//	@ApiOperation(value = "帐号绑定", httpMethod = "POST",produces = "application/json")
//	public @ResponseBody Response<Object> thirdPartyBind(@RequestBody ThirdPartyBindRequest request) {
//		Response<Object> response = new Response<>(false);
//		try {
//			Result validator = FluentValidator.checkAll().on(request, new ThirdPartyBindRequestValidator()).doValidate().result(ResultCollectors.toSimple());
//			if(validator.isSuccess()){
//				String userOauthId = Constant.thirdPartyToken.get(OAuth2Scope.third_party_bind);
//				Triplet<Boolean,User, String> triplet = userService.login(request, userOauthId);
//				if(triplet.getValue0()){//优先判断用户名密码的错误
//					Pair<Boolean, String> pair = smsVerifyCodeService.checkCode("WeChatLogin", request.getMobile(), request.getVerifyCode());
//					if(!pair.getValue0()){
//						//验证码效验不通过(取pair提示)
//						response.setMsg(pair.getValue1());
//						return response;
//					}
//				}
//				response.setSuccess(triplet.getValue0());
//				response.setData(triplet.getValue1());
//				response.setMsg(triplet.getValue2());
//			}else{
//				response.setMsg(validator.getErrors().get(0));
//			}			
//		} catch (Exception e) {
//			logger.error("thirdPartyBind error {}", e);
//		}
//		return response;
//	}
//	/**
//	 * 发送验证码
//	 * @param bizScope 验证码标识[WeChatLogin登录 / WeChatRegister注册 / ]
//	 * @param mobile 手机�
//	 * @author liXin
//	 */
//	@RequestMapping(value = "/smsSend")
//	@ApiOperation(value = "发送验证码", httpMethod = "GET",produces = "application/json")
//	
//	public @ResponseBody Response<Object> smsSend(String bizScope,String mobile) {
//		Response<Object> response = new Response<Object>(true);
//		try { 
//			Pair<Boolean, String> pair = smsVerifyCodeService.smsVerifyCode(mobile, bizScope);
//			response.setSuccess(pair.getValue0());
//			response.setMsg(pair.getValue1());
//		} catch (Exception e) {
//			logger.error("user login mobile send verify code error {}", e);
//			response.setSuccess(Boolean.FALSE);
//			response.setMsg(e.getMessage());
//		}
//		return response;
//	}	
//	/**
//	 * 注册并绑定
//	 * @param request 注册参数
//	 * @param bizScope 验证码标识[ default = WeChatRegister ]
//	 */
//	@RequestMapping(value = "register", method = RequestMethod.POST)
//	@ApiOperation(value = "注册并绑定", httpMethod = "POST",produces = "application/json")
//	@ResponseBody
//	public Response<Object> register(UserRegisterRequest request,@RequestParam(defaultValue="WeChatRegister") String bizScope
//			, HttpServletRequest httpRequest , HttpServletResponse httpResponse) {
//		Response<Object> response= new Response<>(false); 
//		try {
//			String openid = CookieUtil.getCookie(httpRequest, OAuth2Scope.open_id);
//			Triplet<Boolean,Object, String> triplet = userService.register(request,openid,1);//1=客户
//			if(triplet.getValue0()){//优先判断用户名密码的错误
//				Pair<Boolean, String> pair = smsVerifyCodeService.checkCode(bizScope, request.getMobile(), request.getVerifyCode());
//				if(!pair.getValue0()){
//					//验证码效验不通过(取pair提示)
//					response.setMsg(pair.getValue1());
//					return response;
//				}
//			}
//			response.setSuccess(triplet.getValue0());
//			response.setMsg(triplet.getValue2());
//			response.setData(triplet.getValue1());
//		} catch (Exception e) {
//			response.setMsg("出现异常:"+e.getMessage());
//			e.printStackTrace();
//			logger.error("login error {}",e);
//		}		
//		return response;
//	}
//	/**
//	 * 注册企业
//	 * @param request 注册参数
//	 * @param bizScope 验证码标识[ default = WeChatRegister ]
//	 */
//	@RequestMapping(value = "registerComp", method = RequestMethod.POST)
//	@ApiOperation(value = "注册企业", httpMethod = "POST",produces = "application/json")
//	@ResponseBody
//	public Response<Object> registerComp(String compName, HttpServletRequest httpRequest , HttpServletResponse httpResponse) {
//		Response<Object> response= new Response<>(false); 
//		try {
//			String openid = CookieUtil.getCookie(httpRequest, OAuth2Scope.open_id);
//			if(customerService.selectByName(compName) != null){
//				response.setMsg("企业名称已存在");
//				return response;
//			};
//			User user = userService.selectByOpenid(openid);
//			if(user!=null){
//				CustomerResgisterRequest request = new CustomerResgisterRequest();
//				request.setUid(user.getId());
//				request.setCustomerName(compName);
//				customerService.insertCustomer(request, user.getUserName());
//				response.setMsg("注册企业成功");
//			}else{
//				response.setMsg("openid未关联用");
//			}
//		} catch (Exception e) {
//			response.setMsg("出现异常:"+e.getMessage());
//			e.printStackTrace();
//			logger.error("login error {}",e);
//		}		
//		return response;
//	}
//	/**
//	 * 校验手机号验证码(修改手机WeChatUptMobile/修改邮箱WeChatUptEmail/修改密码WeChatUptPwd/注册企业WeChatReComp)
//	 * @param request 注册参数
//	 * @param bizScope 验证码标�修改手机WeChatUptMobileOld/修改邮箱WeChatUptEmail/修改密码WeChatUptPwd/注册企业WeChatReComp)
//	 */
//	@RequestMapping(value = "verifyMobile", method = RequestMethod.POST)
//	@ApiOperation(value = "校验手机验证码", httpMethod = "POST",produces = "application/json")
//	public @ResponseBody Response<Object> verifyMobile(String mobile,String verifyCode,String bizScope) {
//		Response<Object> response= new Response<>(false); 
//		try {
//			if(StringUtils.isBlank(mobile) || StringUtils.isBlank(verifyCode)){
//				response.setMsg("验证码不能为空！");
//				return response;
//			}
//			Pair<Boolean, String> pair = smsVerifyCodeService.checkCode(bizScope, mobile, verifyCode);
//			response.setSuccess(pair.getValue0());
//			response.setMsg(pair.getValue1());
//		} catch (Exception e) {
//			response.setMsg("出现异常:"+e.getMessage());
//			e.printStackTrace();
//			logger.error("login error {}",e);
//		}		
//		return response;
//	}
//	/**
//	 * 修改手机 并校验验证码
//	 * @param request 注册参数
//	 * @param bizScope 验证码标�WeChatUptMobile
//	 */
//	@RequestMapping(value = "uptMobile", method = RequestMethod.POST)
//	@ApiOperation(value = "修改手机校验验证码", httpMethod = "POST",produces = "application/json")
//	@ResponseBody
//	public Response<Object> uptMobile(String oldMobile,String mobile,String verifyCode,String bizScope) {
//		Response<Object> response= new Response<>(false); 
//		try {
//			if(StringUtils.isBlank(oldMobile)|| StringUtils.isBlank(mobile) || StringUtils.isBlank(verifyCode)){
//				response.setMsg("验证码不能为空！");
//				return response;
//			}
//			Pair<Boolean, String> pair = smsVerifyCodeService.checkCode(bizScope, mobile, verifyCode);
//			if(!pair.getValue0()){
//				//验证码效验不通过(取pair提示)
//				response.setMsg(pair.getValue1());
//				return response;
//			}else{
//				//通过效验
//				Triplet<Boolean, Object, String> triplet = userService.uptMobile(oldMobile, mobile);
//				response.setSuccess(triplet.getValue0());
//				response.setData(triplet.getValue1());
//				response.setMsg(triplet.getValue2());
//			}
//		} catch (Exception e) {
//			response.setMsg("出现异常:"+e.getMessage());
//			e.printStackTrace();
//			logger.error("login error {}",e);
//		}		
//		return response;
//	}
//	/**
//	 * 修改邮箱
//	 * @param email 新邮�
//	 * @param mobile 手机�
//	 */
//	@RequestMapping(value = "uptEmail", method = RequestMethod.POST)
//	@ApiOperation(value = "修改邮箱", httpMethod = "POST",produces = "application/json")
//	@ResponseBody
//	public Response<Object> uptEmail(String email,String mobile) {
//		Response<Object> response= new Response<>(false); 
//		try {
//			if(StringUtils.isBlank(email)){
//				response.setMsg("邮箱不能为空");
//				return response;
//			}
//			Triplet<Boolean, Object, String> triplet = userService.uptEmail(mobile, email);
//			response.setSuccess(triplet.getValue0());
//			response.setData(triplet.getValue1());
//			response.setMsg(triplet.getValue2());
//		} catch (Exception e) {
//			response.setMsg("出现异常:"+e.getMessage());
//			e.printStackTrace();
//			logger.error("login error {}",e);
//		}		
//		return response;
//	}
//	/**
//	 * 修改密码
//	 * @param password 新密�
//	 * @param mobile 手机�
//	 */
//	@RequestMapping(value = "uptPwd", method = RequestMethod.POST)
//	@ApiOperation(value = "修改密码", httpMethod = "POST",produces = "application/json")
//	@ResponseBody
//	public Response<Object> uptPwd(String password,String mobile) {
//		Response<Object> response= new Response<>(false); 
//		try {
//			Triplet<Boolean, Object, String> triplet = userService.uptPwd(mobile, password);
//			response.setSuccess(triplet.getValue0());
//			response.setData(triplet.getValue1());
//			response.setMsg(triplet.getValue2());
//		} catch (Exception e) {
//			response.setMsg("出现异常:"+e.getMessage());
//			e.printStackTrace();
//			logger.error("login error {}",e);
//		}		
//		return response;
//	}
//	/**
//	 * 退出企�
//	 * @param mobile 手机�
//	 * @param verifyCode 验证�
//	 * @param bizScope [default : WeChatExitComp ]
//	 * @return
//	 */
//	@RequestMapping(value = "exitOfComp", method = RequestMethod.POST)
//	@ApiOperation(value = "退出企业", httpMethod = "POST",produces = "application/json")
//	public @ResponseBody Response<Object> exitOfComp(String mobile,String verifyCode,@RequestParam(defaultValue="WeChatExitComp")String bizScope
//			, HttpServletRequest httpRequest , HttpServletResponse httpResponse) {
//		Response<Object> response= new Response<>(false); 
//		try {
//			Pair<Boolean, String> pair = smsVerifyCodeService.checkCode(bizScope, mobile, verifyCode);
//			if(!pair.getValue0()){
//				//验证码效验不通过(取pair提示)
//				response.setMsg(pair.getValue1());
//				return response;
//			}else{
//				User user = userService.selectByMobile(mobile);
//				if(user != null){
//					Triplet<Boolean, Object, String> triplet = customerService.exitOfComp(mobile,user);
//					response.setSuccess(triplet.getValue0());
//					response.setData(triplet.getValue1());
//					response.setMsg(triplet.getValue2());
//				}else{
//					response.setData(mobile);
//					response.setMsg("该手机没有关联用� ");
//				}
//			}
//		} catch (Exception e) {
//			response.setMsg("出现异常:"+e.getMessage());
//			e.printStackTrace();
//			logger.error("login error {}",e);
//		}		
//		return response;
//	}
//	@RequestMapping(value = "queryInfo")
//	@ApiOperation(value = "我的桌面", httpMethod = "GET",produces = "application/json")
//	public @ResponseBody Response<Object> queryInfo(HttpServletRequest httpRequest , HttpServletResponse httpResponse) {
//		Response<Object> response= new Response<>(false); 
//		try {
//			String openid = CookieUtil.getCookie(httpRequest, OAuth2Scope.open_id);
//			UserInfoResponse info = userService.queryInfo(openid);
//			response.setData(info);
//			response.setSuccess(true);
//		} catch (Exception e) {
//			response.setMsg("出现异常:"+e.getMessage());
//			e.printStackTrace();
//			logger.error("login error {}",e);
//		}		
//		return response;
//	}
//}
