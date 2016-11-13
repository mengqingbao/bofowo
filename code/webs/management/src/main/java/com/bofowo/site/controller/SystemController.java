/**
 * Project Name:lymall-management
 * File Name:SystemController.java
 * Package Name:com.bofowo.site.controller
 * Date:2016年2月25日下午8:52:13
 * Copyright (c) 2016,Shanghai bofowo Technology co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import common.web.BaseController;

/**
 * ClassName:SystemController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年2月25日 下午8:52:13 <br/>
 * @author   mqb
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Controller
public class SystemController extends BaseController {
	@RequestMapping("nav-manage")
	public String systemNav(){
		return "biz/system/nav";
	}
	
	@RequestMapping("cache-clean")
	public String cacheClean(){
		return "biz/system/cacheClean";
	}
	
	@RequestMapping("system-log")
	public String systemLog(){
		return "biz/system/systemLog";
	}
	
	@RequestMapping("system-error-define")
	public String systemErrorDefine(){
		return "biz/system/errorDefine";
	}
	
	@RequestMapping("404")
	public String addContent(){
		return "biz/system/error";
	}
}

