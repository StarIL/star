package com.shiwulian.wechat.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.shiwulian.wechat.bean.Response;
import com.shiwulian.wechat.bean.bs.User;
import com.shiwulian.wechat.bean.request.CustomerRequest;
import com.shiwulian.wechat.bean.request.CustomerResgisterRequest;
import com.shiwulian.wechat.bean.request.UserUpdateReuqest;
import com.shiwulian.wechat.bean.response.UserInfoResponse;
import com.shiwulian.wechat.context.UserAuthContext;
import com.shiwulian.wechat.core.annotation.Authorize;
import com.shiwulian.wechat.service.bs.CustomerService;
import com.shiwulian.wechat.service.bs.SmsVerifyCodeService;
import com.shiwulian.wechat.service.bs.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="用户相关接口")
@Controller
@RequestMapping(value = "/myAccount")
public class MyAccountController {
	private static final Logger logger = LoggerFactory.getLogger(MyAccountController.class);

	@Autowired
	private UserService userService;
	@Autowired
	private SmsVerifyCodeService smsVerifyCodeService;
	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "myAccount/index";
	}	
	
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String info() {
		return "myAccount/info";
	}
	
	@RequestMapping(value = "/enterprise", method = RequestMethod.GET)
	public String enterprise() {
		return "myAccount/enterprise";
	}
	
	@RequestMapping(value = "/logoutCorp", method = RequestMethod.GET)
	public String confirmsignout() {
		return "myAccount/logoutCorp";
	}
	
	@RequestMapping(value = "/modifyPwd", method = RequestMethod.GET)
	public String passworld() {
		return "myAccount/modifyPwd";
	}
	
	@RequestMapping(value = "/modifyPhone", method = RequestMethod.GET)
	public String modifyiphone() {
		return "myAccount/modifyPhone";
	}
	
	@RequestMapping(value = "/modifyMail", method = RequestMethod.GET)
	public String mail() {
		return "myAccount/modifyMail";
	}
	
	@RequestMapping(value = "/exclusive", method = RequestMethod.GET)
	public String exclusive() {
		return "myAccount/exclusive";
	} 
	@RequestMapping(value = "/myenterprise", method = RequestMethod.GET)
	public String myenterprise() {
		return "myAccount/myenterprise";
	} 
	
	@RequestMapping(value = "/capital", method = RequestMethod.GET)
	public String capital() {
		return "myAccount/capital";
	} 
	/**
	 * 注册企业
	 * @param request 注册参数
	 * @param bizScope 验证码标识[ default = WeChatRegister ]
	 */
	@RequestMapping(value = "registerComp", method = RequestMethod.POST)
	@ApiOperation(value = "注册企业", httpMethod = "POST",produces = "application/json")
	@ResponseBody
	public Response<Object> registerComp(String compName, HttpServletRequest httpRequest , HttpServletResponse httpResponse) {
		Response<Object> response= new Response<>(false);		try {
			String id = UserAuthContext.getLocal().getId();
			if(customerService.selectByName(compName) != null){
				response.setMsg("企业名称已存在");
				return response;
			};
			User user = userService.selectByPrimaryKey(id);
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
	/**
	 * 修改手机 并校验验证码
	 * @param request 注册参数
	 * @param bizScope 验证码标码WeChatUptMobile
	 */
	@RequestMapping(value = "uptMobile", method = RequestMethod.POST)
	@ApiOperation(value = "修改手机校验验证", httpMethod = "POST",produces = "application/json")
	@ResponseBody
	public Response<Object> uptMobile( String oldMobile,String mobile, String verifyCode,@RequestParam(defaultValue="WeChatUptMobile") String bizScope) {
		Response<Object> response= new Response<>(false); 
		try {
			if(StringUtils.isBlank(oldMobile)|| StringUtils.isBlank(mobile) || StringUtils.isBlank(verifyCode)){
				response.setMsg("验证码不能为空！");
				return response;
			}
			Pair<Boolean, String> pair = smsVerifyCodeService.checkCode(bizScope, mobile, verifyCode);
			if(!pair.getValue0()){
				//验证码效验不通过(取pair提示)
				response.setMsg(pair.getValue1());
				return response;
			}else{
				//通过效验
				Triplet<Boolean, Object, String> triplet = userService.uptMobile(oldMobile, mobile);
				response.setSuccess(triplet.getValue0());
				response.setData(triplet.getValue1());
				response.setMsg(triplet.getValue2());
			}
		} catch (Exception e) {
			response.setMsg("出现异常:"+e.getMessage());
			e.printStackTrace();
			logger.error("login error {}",e);
		}		
		return response;
	}
	/**
	 * 修改邮箱
	 * @param email 新邮箱
	 * @param mobile 手机号
	 */
	@RequestMapping(value = "uptEmail", method = RequestMethod.POST)
	@ApiOperation(value = "修改邮箱", httpMethod = "POST",produces = "application/json")
	@ResponseBody
	public Response<Object> uptEmail(String email,String mobile) {
		Response<Object> response= new Response<>(false); 
		try {
			if(StringUtils.isBlank(email)){
				response.setMsg("邮箱不能为空");
				return response;
			}
			Triplet<Boolean, Object, String> triplet = userService.uptEmail(mobile, email);
			response.setSuccess(triplet.getValue0());
			response.setData(triplet.getValue1());
			response.setMsg(triplet.getValue2());
		} catch (Exception e) {
			response.setMsg("出现异常:"+e.getMessage());
			e.printStackTrace();
			logger.error("login error {}",e);
		}		
		return response;
	}
	/**
	 * 退出企业
	 * @param mobile 手机号
	 * @param verifyCode 验证证(不填不验证)
	 * @param bizScope [default : WeChatExitComp ]
	 * @return
	 */
	@RequestMapping(value = "exitOfComp", method = RequestMethod.POST)
	@ApiOperation(value = "退出企业", httpMethod = "POST",produces = "application/json")
	public @ResponseBody Response<Object> exitOfComp(String mobile,String verifyCode,@RequestParam(defaultValue="WeChatExitComp")String bizScope
			, HttpServletRequest httpRequest , HttpServletResponse httpResponse) {
		Response<Object> response= new Response<>(false); 
		try {
			if(StringUtils.isNotBlank(verifyCode)){
				Pair<Boolean, String> pair = smsVerifyCodeService.checkCode(bizScope, mobile, verifyCode);
				if(!pair.getValue0()){
					//验证码效验不通过(取pair提示)
					response.setMsg(pair.getValue1());
					return response;
				}
			}
			User user = userService.selectByMobile(mobile);
			if(user != null){
				Triplet<Boolean, Object, String> triplet = customerService.exitOfComp(mobile,user);
				response.setSuccess(triplet.getValue0());
				response.setData(triplet.getValue1());
				response.setMsg(triplet.getValue2());
			}else{
				response.setData(mobile);
				response.setMsg("该手机没有关联用户");
			}
		} catch (Exception e) {
			response.setMsg("出现异常:"+e.getMessage());
			e.printStackTrace();
			logger.error("login error {}",e);
		}		
		return response;
	}
	@RequestMapping(value = "queryInfo")
	@ApiOperation(value = "我的桌面", httpMethod = "GET",produces = "application/json")
	public @ResponseBody Response<Object> queryInfo(HttpServletRequest httpRequest , HttpServletResponse httpResponse) {
		Response<Object> response= new Response<>(false); 
		try {
			User user = UserAuthContext.getLocal();
			UserInfoResponse info = userService.queryInfo(user);
			response.setData(info);
			response.setSuccess(true);
		} catch (Exception e) {
			response.setMsg("出现异常:"+e.getMessage());
			e.printStackTrace();
			logger.error("login error {}",e);
		}		
		return response;
	}
	@Authorize //需要公司拦截
	@RequestMapping(value = "queryOperator")
	@ApiOperation(value = "我的客服", httpMethod = "GET",produces = "application/json")
	public @ResponseBody Response<Object> queryOperator(HttpServletRequest httpRequest , HttpServletResponse httpResponse) {
		Response<Object> response= new Response<>(false); 
		try {
			User user = UserAuthContext.getLocal();
			UserInfoResponse info = userService.queryOperator(user);
			response.setData(info);
			response.setSuccess(true);
		} catch (Exception e) {
			response.setMsg("出现异常:"+e.getMessage());
			e.printStackTrace();
			logger.error("login error {}",e);
		}		
		return response;
	}
	
	@RequestMapping(value = "colleagues")
	@ApiOperation(value = "我的同事", httpMethod = "GET",produces = "application/json")
	public @ResponseBody Response<Object> colleagues(HttpServletRequest httpRequest , HttpServletResponse httpResponse) {
		Response<Object> response= new Response<>(false); 
		try {
			String id = UserAuthContext.getLocal().getId();
			List<User> info = userService.colleagues(id);
			response.setData(info);
			response.setSuccess(true);
		} catch (Exception e) {
			response.setMsg("出现异常:"+e.getMessage());
			logger.error("login error {}",e);
		}		
		return response;
	}
	@RequestMapping(value = "newColleague",method= RequestMethod.POST)
	@ApiOperation(value = "加入同事", httpMethod = "POST",produces = "application/json")
	public @ResponseBody Response<Object> newColleague(String mobile,
			HttpServletRequest httpRequest , HttpServletResponse httpResponse) {
		Response<Object> response= new Response<>(false); 
		try {
			String id = UserAuthContext.getLocal().getId();
			Triplet<Boolean, Object, String> triplet = userService.newColleague(id,mobile);
			response.setSuccess(triplet.getValue0());
			response.setData(triplet.getValue1());
			response.setMsg(triplet.getValue2());
		} catch (Exception e) {
			response.setMsg("出现异常:"+e.getMessage());
			logger.error("login error {}",e);
		}		
		return response;
	}
	@RequestMapping(value = "uptUser",method= RequestMethod.POST)
	@ApiOperation(value = "个人资料-5处修改", httpMethod = "POST",produces = "application/json")
	public @ResponseBody Response<Object> uptUser(UserUpdateReuqest request,
			HttpServletRequest httpRequest , HttpServletResponse httpResponse) {
		Response<Object> response= new Response<>(false); 
		try {
			String id = UserAuthContext.getLocal().getId();
			Triplet<Boolean, Object, String> triplet = userService.uptUser(id,request);
			response.setSuccess(triplet.getValue0());
			response.setData(triplet.getValue1());
			response.setMsg(triplet.getValue2());
		} catch (Exception e) {
			response.setMsg("出现异常:"+e.getMessage());
			logger.error("login error {}",e);
		}		
		return response;
	}
	@RequestMapping(value = "uptCustomer",method= RequestMethod.POST)
	@ApiOperation(value = "企业资料-5处修改", httpMethod = "POST",produces = "application/json")
	public @ResponseBody Response<Object> uptCustomer(CustomerRequest request,
			HttpServletRequest httpRequest , HttpServletResponse httpResponse) {
		Response<Object> response= new Response<>(false); 
		try {
			//TODO V1.7 企业资料-5处修改
			//String id = UserAuthContext.getLocal().getId();
			Triplet<Boolean, Object, String> triplet = customerService.updateByRequest(request);
			response.setSuccess(triplet.getValue0());
			response.setData(triplet.getValue1());
			response.setMsg(triplet.getValue2());
		} catch (Exception e) {
			response.setMsg("出现异常:"+e.getMessage());
			logger.error("login error {}",e);
		}		
		return response;
	}
}
