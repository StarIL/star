package com.xhhxd.retail.util;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import com.alibaba.fastjson.JSONObject;

public class ShiroUtil {

	public final static String UNAUTHORIZED = "/unauthorized";

	public final static String DEFAULT_SHIRO_CACHE = "shiro_cache:auth_";

	public static Session getSession() {
		return SecurityUtils.getSubject().getSession();
	}

	public static Subject getSubject() {
		return SecurityUtils.getSubject();
	}

	public static void setSessionAttribute(Object key, Object value) {
		getSession().setAttribute(key, value);
	}

	public static Object getSessionAttribute(Object key) {
		return getSession().getAttribute(key);
	}

	public static boolean isLogin() {
		return SecurityUtils.getSubject().isAuthenticated();
	}

	public static void logout() {
		SecurityUtils.getSubject().logout();
	}

	public static void login(String userName, String pwd, Boolean rememberMe) {
		UsernamePasswordToken token = new UsernamePasswordToken(userName, pwd, rememberMe);
		SecurityUtils.getSubject().login(token);
	}

	public static String getKaptcha(String key) {
		Object kaptcha = getSessionAttribute(key);
		if (kaptcha != null) {
			getSession().removeAttribute(key);
			return kaptcha.toString();
		}
		return null;
	}

	public static String jumpUrl(HttpServletRequest request,boolean needAjax) throws UnsupportedEncodingException {
		String url = request.getRequestURI();
		if (isAjax(request)){
			String referer = request.getHeader("referer");
			url = StringUtils.isNotBlank(referer) && needAjax ? referer: request.getContextPath() + "/";
		}		
		String queryString = request.getQueryString();
		if (StringUtils.isNotBlank(queryString)) {
			url = url + "?" + queryString;
		}
		return url;
	}

	public static boolean isAjax(HttpServletRequest request) {
		return "XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"));
	}

	public static void outPut(ServletResponse response, Map<String, Object> resultMap) {
		PrintWriter out = null;
		try {
			response.setCharacterEncoding("UTF-8");
			out = response.getWriter();
			out.println(JSONObject.toJSONString(resultMap));
		} catch (Exception e) {

		} finally {
			if (null != out) {
				out.flush();
				out.close();
			}
		}
	}
}
