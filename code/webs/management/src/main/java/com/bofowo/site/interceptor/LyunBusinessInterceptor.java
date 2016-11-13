package com.bofowo.site.interceptor;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LyunBusinessInterceptor implements HandlerInterceptor {


	public List<LyunAspectj> lyunAspectjList;
	
	
	public List<LyunAspectj> getLyunAspectjList() {
		return lyunAspectjList;
	}

	public void setLyunAspectjList(List<LyunAspectj> lyunAspectjList) {
		this.lyunAspectjList = lyunAspectjList;
	}

	
	private List<String>   ignoreURL;
	public List<String> getIgnoreURL() {
		return ignoreURL;
	}

	public void setIgnoreURL(List<String> ignoreURL) {
		this.ignoreURL = ignoreURL;
	}
	
	
	
	
	

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
	
		String requestUrl=request.getRequestURI().substring(1);
		if(ignoreURL.contains(requestUrl)){
			return true;
		}
		
		
		for(LyunAspectj  a: lyunAspectjList){
			if(a.getUrlList()!=null&&a.getUrlList().contains(requestUrl)){
				//调用拦截切面
			    if(!a.preHandle(request, response, handler)){
			    	
			    	return false;
			    };
			}
			
		}
		
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		String requestUrl=request.getRequestURI().substring(1);
		if(ignoreURL.contains(requestUrl)){
			return ;
		}
		for(LyunAspectj  a: lyunAspectjList){
			if(a.getUrlList()!=null&&a.getUrlList().contains(requestUrl)){
				//调用拦截切面
			   a.postHandle(request, response, handler, modelAndView);
			}
			
		}

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		String requestUrl=request.getRequestURI().substring(1);
		if(ignoreURL.contains(requestUrl)){
			return ;
		}
		for(LyunAspectj  a: lyunAspectjList){
			if(a.getUrlList()!=null&&a.getUrlList().contains(requestUrl)){
				//调用拦截切面
			   a.afterCompletion(request, response, handler, ex);
			}
			
		}

	}

	
	
	
	
	

}
