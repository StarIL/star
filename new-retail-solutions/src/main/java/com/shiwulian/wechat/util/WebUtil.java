package com.shiwulian.wechat.util;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.RedirectView;

public class WebUtil {
	
	/**
	 * url跳转
	 * @param request
	 * @param response
	 * @param url
	 * @throws IOException
	 */
	public static void sendRedirect(HttpServletRequest request, HttpServletResponse response, String url) throws IOException {
		response.sendRedirect(request.getContextPath() + url);
	}
	/**
	 * POST参数的跳转
	 * @param request
	 * @param response
	 * @param url
	 * @param map
	 * @throws Exception
	 */
	public static void sendRedirect(HttpServletRequest request, HttpServletResponse response, String url,Map<String, String> map) throws Exception {
		 RedirectView view = new RedirectView(url);
		 view.render(map, request, response);
	}

	public static Boolean isAjax(HttpServletRequest request, HttpServletResponse response) {
		return "XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"));
	}
}
