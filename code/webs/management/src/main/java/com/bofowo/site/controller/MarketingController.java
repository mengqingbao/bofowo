/**
 * Project Name:lymall-management
 * File Name:MarketingController.java
 * Package Name:com.bofowo.site.controller
 * Date:2016年2月25日下午8:51:30
 * Copyright (c) 2016,Shanghai bofowo Technology co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import common.web.BaseController;

/**
 * ClassName:MarketingController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年2月25日 下午8:51:30 <br/>
 * @author   mqb
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Controller
public class MarketingController extends BaseController {
	
	@RequestMapping("marketing-manage")
	public String marketingManage(){
		return "biz/marketing/manage";
	}
	
	@RequestMapping("marketing-point")
	public String marketingPoint(){
		return "biz/marketing/point";
	}
	
	@RequestMapping("marketing-point-review")
	public String marketingPointReview(){
		return "biz/marketing/point-review";
	}
	
	@RequestMapping("marketing-3part-manage")
	public String marketing3partPoint(){
		return "biz/marketing/part3Manage";
	}
}

