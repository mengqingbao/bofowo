/**
 * Project Name:lymall-management
 * File Name:ShopController.java
 * Package Name:com.bofowo.site.controller
 * Date:2016年2月25日下午8:50:45
 * Copyright (c) 2016,Shanghai bofowo Technology co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import common.web.BaseController;

/**
 * ClassName:ShopController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年2月25日 下午8:50:45 <br/>
 * @author   mqb
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Controller
public class ShopController extends BaseController {
	@RequestMapping("shop-search")
	public String shopSearch(){
		return "biz/shop/shopSearch";
	}
	
	@RequestMapping("shop-category")
	public String shopCategory(){
		return "biz/shop/shopCategory";
	}
	@RequestMapping("shop-report-tool")
	public String shopReport(){
		return "biz/shop/shopReportTool";
	}
}

