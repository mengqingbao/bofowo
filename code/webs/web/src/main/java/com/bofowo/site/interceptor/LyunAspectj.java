package com.bofowo.site.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public abstract class LyunAspectj implements HandlerInterceptor{
	
	protected List<String>  urlList;

	public List<String> getUrlList() {
		return urlList;
	}

	public void setUrlList(List<String> urlList) {
		this.urlList = urlList;
	}
	
	/**
	 * 
	* @Title: showExceptionResult
	* @Description: TODO(处理结果)
	* @param @param request
	* @param @param response
	* @param @param handler
	* @param @param ex    设定文件
	* @return void    返回类型
	* @date 2015年9月14日
	* @author 陈勋
	* @throws
	 */
	public abstract void showExceptionResult(HttpServletRequest request,
			HttpServletResponse response, Object handler ,Exception ex);
	
	
}
