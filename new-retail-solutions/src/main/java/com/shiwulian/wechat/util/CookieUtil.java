package com.shiwulian.wechat.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieUtil {

	private static final Logger logger = LoggerFactory.getLogger(CookieUtil.class);

	public static void setCookie(HttpServletResponse response, String name, String value) {
		try {
			Cookie cookie = new Cookie(name, value);
//			cookie.setMaxAge(24 * 60 * 60 * 60);
			cookie.setMaxAge(31536000);//1年(yr)=31536000秒(s)
			cookie.setPath("/");
			response.addCookie(cookie);
		} catch (Exception e) {
			logger.error("setCookie error {}", e);
		}
	}
	
	public static void setCookie(HttpServletResponse response, String name, String value, int minute) {
		try {
			Cookie cookie = new Cookie(name, value);
			if (minute > 0) cookie.setMaxAge(minute * 60 * 60);
			cookie.setPath("/");
			response.addCookie(cookie);
		} catch (Exception e) {
			logger.error("setCookie error {}", e);
		}
	}
	
	public static void setCookie(HttpServletResponse response, String name, String value, int minute,String domain) {
		try {
			Cookie cookie = new Cookie(name, value);
			if (minute > 0) cookie.setMaxAge(minute * 60);
			cookie.setPath("/");
			cookie.setDomain(domain);			
			response.addCookie(cookie);
		} catch (Exception e) {
			logger.error("setCookie error {}", e);
		}
	}
	
	public static void setCookie(HttpServletRequest request,HttpServletResponse response, String name, String newValue) {
		Cookie[] cookies = request.getCookies();
		if (null == cookies || cookies.length == 0) return;
		
		try {
			for(Cookie cookie : cookies){ 
				String cname = cookie.getName();
				if (!StringUtils.isBlank(cname) && cname.equals(name)) {
					cookie.setValue(newValue);
					cookie.setMaxAge(24 * 60 * 60 * 60);
					cookie.setPath("/");
					response.addCookie(cookie);
					break;
				}
			}
		} catch (Exception e) {
			logger.error("setCookie error {}", e);
		}
	}
	
	public static void setCookie(HttpServletRequest request,HttpServletResponse response, String name, String newValue,int minute) {
		Cookie[] cookies = request.getCookies();
		if (null == cookies || cookies.length == 0) return;
		
		try {
			for(Cookie cookie : cookies){ 
				String cname = cookie.getName();
				if (!StringUtils.isBlank(cname) && cname.equals(name)) {
					cookie.setValue(newValue);
					if (minute > 0) cookie.setMaxAge(minute * 60);
					cookie.setPath("/");
					response.addCookie(cookie);
					break;
				}
			}
		} catch (Exception e) {
			logger.error("addCookie error {}", e);
		}
	}
	
	public static void setCookie(HttpServletRequest request,HttpServletResponse response, String name, String newValue,int minute,String domain) {
		Cookie[] cookies = request.getCookies();
		if (null == cookies || cookies.length == 0) return;
		
		try {
			for(Cookie cookie : cookies){ 
				String cname = cookie.getName();
				if (!StringUtils.isBlank(cname) && cname.equals(name)) {
					cookie.setValue(newValue);
					if (minute > 0) cookie.setMaxAge(0);
					cookie.setPath("/");
					cookie.setDomain(domain);
					response.addCookie(cookie);
					break;
				}
			}
		} catch (Exception e) {
			logger.error("addCookie error {}", e);
		}
	}
	
	public static void clearCookie(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if (null == cookies || cookies.length == 0) return;
		
		try {
			for (Cookie cookie : cookies) {
				cookie.setValue(null);
				cookie.setMaxAge(0);
				cookie.setPath("/");
				response.addCookie(cookie);
			}
		} catch (Exception e) {
			logger.error("clearCookie error {}", e);
		}
	}
	
	public static void clearCookie(HttpServletRequest request, HttpServletResponse response, String name) {
		Cookie[] cookies = request.getCookies();
		if (null == cookies || cookies.length == 0) return;
		
		try {
			for (Cookie cookie : cookies) {
				String cname = cookie.getName();
				if (!StringUtils.isBlank(cname) && cname.equals(name)) {
					cookie.setValue(null);
					cookie.setMaxAge(0);
					cookie.setPath("/");
					response.addCookie(cookie);
				}
			}
		} catch (Exception e) {
			logger.error("clearCookie error {}", e);
		}
	}
	
	public static void clearCookie(HttpServletRequest request, HttpServletResponse response, String name, String domain) {
		Cookie[] cookies = request.getCookies();
		if (null == cookies || cookies.length == 0) return;
		
		try {
			for (Cookie cookie : cookies) {
				String cname = cookie.getName();
				if (!StringUtils.isBlank(cname) && cname.equals(name)) {
					cookie.setValue(null);
					cookie.setMaxAge(0);
					cookie.setPath("/");
					cookie.setDomain(domain);
					response.addCookie(cookie);
				}
			}
		} catch (Exception e) {
			logger.error("clearCookie error {}", e);
		}
	}

	public static String getCookie(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();
		if (cookies == null || cookies.length == 0) return null;

		try {
			for (Cookie cookie : cookies) {
				String cname = cookie.getName();
				if (!StringUtils.isBlank(cname) && cname.equals(name)) {
					return cookie.getValue();
				}
			}
		} catch (Exception e) {
			logger.error("clearCookie error {}", e);
		}
		return null;
	}
}
