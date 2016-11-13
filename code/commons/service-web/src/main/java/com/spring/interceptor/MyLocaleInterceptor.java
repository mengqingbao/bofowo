package com.spring.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MyLocaleInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		//set land
		Cookie[] cookies = request.getCookies();
		request.setAttribute("land", "en_us");
		if(cookies!=null){
			for(Cookie cookie:cookies){
				if("org.springframework.web.servlet.i18n.CookieLocaleResolver.LOCALE".equals(cookie.getName())){
					request.setAttribute("land", cookie.getValue());
					break;
				}
			}
		}
		return super.preHandle(request, response, handler);
	}

}
