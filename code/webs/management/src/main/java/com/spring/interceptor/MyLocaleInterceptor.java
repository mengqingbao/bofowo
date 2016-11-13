package com.spring.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import common.util.StringUtil;

public class MyLocaleInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		return super.preHandle(request, response, handler);
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			String domain = cookie.getDomain();
			if (!StringUtil.isEmpty(domain)) {
				String[] str = domain.split(".");
				if (str.length > 2) {
					Cookie delcookie = new Cookie(cookie.getName(), null);
					delcookie.setMaxAge(0);
					delcookie.setPath(cookie.getPath());
					response.addCookie(delcookie);
				}

			}
		}
		super.afterCompletion(request, response, handler, ex);
	}
	
	

}
