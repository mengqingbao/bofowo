package com.bofowo.ajax.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

public class LyunAjaxAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
	 public void onAuthenticationSuccess(
	            HttpServletRequest request,
	            HttpServletResponse response,
	            Authentication auth
	    )throws IOException, ServletException {
		        response.setContentType("text/html");
		 
	            response.getWriter().print("SUCCESS");  
	            response.getWriter().flush();
	       
	    }
}
