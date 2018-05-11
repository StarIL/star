package com.shiwulian.wechat.service.validators;

import org.apache.commons.lang3.StringUtils;
import org.javatuples.Pair;

import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;
import com.shiwulian.wechat.bean.bs.User;
import com.shiwulian.wechat.bean.request.UserRegisterRequest;
import com.shiwulian.wechat.service.bs.SmsVerifyCodeService;
import com.shiwulian.wechat.service.bs.UserService;
import com.shiwulian.wechat.util.RegExpUtil;

public class UserRegisterRequestValidator extends ValidatorHandler<UserRegisterRequest> implements Validator<UserRegisterRequest> {
	private UserService userService;
	
	private SmsVerifyCodeService smsVerifyCodeService;
	
	public UserRegisterRequestValidator(UserService userService,SmsVerifyCodeService smsVerifyCodeService){
		this.userService = userService;
		this.smsVerifyCodeService = smsVerifyCodeService;
	}
	
	@Override
	public boolean validate(ValidatorContext context, UserRegisterRequest request) {
		if (StringUtils.isBlank(request.getUserName())) {
			context.addErrorMsg("用户名不能为空");
			return false;
		}
		if (StringUtils.isEmpty(request.getUserName()) || !RegExpUtil.isUserName(request.getUserName())) {
			context.addErrorMsg("用户名为6-16位字母数字");
			return false;
		}
		User user = userService.selectByUserName(request.getUserName());
		if(user != null){
			context.addErrorMsg("用户名已存在");
			return false;
		}
		if (StringUtils.isEmpty(request.getMobile()) || !RegExpUtil.isMobile(request.getMobile())) {
			context.addErrorMsg("手机号为11位数字");
			return false;
		}
		user = userService.selectByMobile(request.getMobile());
		if(user != null){
			context.addErrorMsg("手机号已存在");
			return false;
		}
		if (StringUtils.isBlank(request.getPassword()) || StringUtils.isBlank(request.getConfirmPassword())) {
			context.addErrorMsg("密码不能为空");
			return false;
		}
		if(!RegExpUtil.match("^[a-zA-Z0-9]{6,18}$", request.getPassword())){
			context.addErrorMsg("密码为6-18位字母与数字组合");
			return false;
		}
		if (!request.getPassword().equals(request.getConfirmPassword())){
			context.addErrorMsg("两次密码输入不匹配");
			return false;
		}
		if (StringUtils.isBlank(request.getVerifyCode())) {
			context.addErrorMsg("验证码不能为空");
			return false;
		}
		Pair<Boolean, String> pair = smsVerifyCodeService.checkCode("WeChatRegister", request.getMobile(), request.getVerifyCode());
		if(!pair.getValue0()){
			context.addErrorMsg(pair.getValue1());
			return false;
		}
		return true;
	}
}