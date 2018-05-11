package com.shiwulian.wechat.interceptor;

import java.io.IOException;
import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.shiwulian.wechat.bean.Response;
import com.shiwulian.wechat.bean.bs.CustomerUser;
import com.shiwulian.wechat.bean.bs.User;
import com.shiwulian.wechat.context.UserAuthContext;
import com.shiwulian.wechat.core.annotation.Authorize;
import com.shiwulian.wechat.core.wechat.OAuth2Scope;
import com.shiwulian.wechat.service.bs.CustomerUserService;
import com.shiwulian.wechat.service.bs.UserService;
import com.shiwulian.wechat.util.CookieUtil;
import com.shiwulian.wechat.util.DESUtil;
import com.shiwulian.wechat.util.JsonUtil;
import com.shiwulian.wechat.util.StringUtil;

public class UserAuthInterceptor extends HandlerInterceptorAdapter {
	private final static Logger logger = LoggerFactory.getLogger(UserAuthInterceptor.class);
	@Autowired
	private UserService userService;
	@Autowired
	private CustomerUserService customerUserService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		try {
			String des_id = CookieUtil.getCookie(request, OAuth2Scope.wechat_account_id);
			if (StringUtils.isBlank(des_id)) {
				invalidAuthUserAdapter(request, response, "未登录");
				return false;
			}

			byte[] decryResult = DESUtil.decrypt(DESUtil.hexToBytes(des_id), OAuth2Scope.account_id_des_Key);
			String id = new String(decryResult);
			if (StringUtils.isBlank(id)) {
				invalidAuthUserAdapter(request, response, "未登录");
				return false;
			}

			User user = userService.selectByPrimaryKey(id);
			if (user == null || user.getUserType() == 2) {
				invalidAuthUserAdapter(request, response, "用户信息缺失");
				return false;
			}

			HandlerMethod handlerMethod = (HandlerMethod) handler;
			Method method = handlerMethod.getMethod();
			Authorize authorize = method.getAnnotation(Authorize.class);
			if (authorize != null) {
				CustomerUser cusUser = customerUserService.selectByUid(user.getId());
				if (cusUser != null) {
					user.setCustomerId(cusUser.getCustomerId());
				} else { //跳转注册企业页面
					response.sendRedirect(request.getContextPath() + "/regCorp");
					return false;
				}
			}
			UserAuthContext.setLocal(user);
			return true;
		} catch (Exception e) {
			logger.error("preHandle error {}", e);
			invalidAuthUserAdapter(request, response, "用户信息缺失");
			return false;
		}
	}

	private void invalidAuthUserAdapter(HttpServletRequest request, HttpServletResponse response, String message)
			throws IOException {
		if (StringUtil.isAjax(request)) {// AJAX请求
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(JsonUtil.toJSON(new Response<>(false, message)));
		} else {// 登录跳转
			response.sendRedirect(request.getContextPath() + "/login");
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		UserAuthContext.removeLocal();
	}
}
