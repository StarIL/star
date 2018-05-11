package com.shiwulian.wechat.util;

import javax.servlet.http.HttpServletRequest;

public class StringUtil {
	
	public static boolean isAjax(HttpServletRequest request){
		return "XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"));
	}
}
