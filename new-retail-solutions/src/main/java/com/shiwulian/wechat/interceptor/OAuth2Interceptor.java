package com.shiwulian.wechat.interceptor;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.shiwulian.wechat.core.wechat.OAuth2Scope;
import com.shiwulian.wechat.core.annotation.Oauth2;
import com.shiwulian.wechat.util.CookieUtil;

/**
 * 微信授权相关 -> 存档
 * @author yuXiaoBo
 */
public class OAuth2Interceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(OAuth2Interceptor.class);

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		try {
			String openId = CookieUtil.getCookie(request, OAuth2Scope.open_id);
			if (StringUtils.isNotBlank(openId)) return true;

			HandlerMethod handlerMethod = (HandlerMethod) handler;
			Method method = handlerMethod.getMethod();
			Oauth2 oauth2 = method.getAnnotation(Oauth2.class);
			if (oauth2 != null && oauth2.required()) {
				response.sendRedirect(request.getContextPath() + String.format(OAuth2Scope.oauth2_url, URLEncoder.encode(request.getRequestURI(), "UTF-8")));
				return false;
			}
		} catch (IOException e) {
			logger.error("preHandle error {}", e);
		} catch (Exception e) {
			logger.error("preHandle error {}", e);
		}
		return true;
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		CookieUtil.clearCookie(request, response);
	}
}
