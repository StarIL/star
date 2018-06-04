package com.xhhxd.retail.validator.bs;

import org.apache.commons.lang3.StringUtils;
import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;
import com.xhhxd.retail.bean.request.LoginRequest;

public class LoginRequestValidator extends ValidatorHandler<LoginRequest> implements Validator<LoginRequest>{
	
	@Override
	public boolean validate(ValidatorContext context, LoginRequest request) {
		if (StringUtils.isBlank(request.getUserName())) {
			context.addErrorMsg("用户名不能为空");
			return false;
		}
		if (StringUtils.isBlank(request.getPassword())) {
			context.addErrorMsg("密码不能为空");
			return false;
		}
		return true;
	}
}
