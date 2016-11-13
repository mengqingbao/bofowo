/**
 * Project Name:lymall-management
 * File Name:MemberController.java
 * Package Name:com.bofowo.site.controller
 * Date:2016年2月25日下午8:51:03
 * Copyright (c) 2016,Shanghai bofowo Technology co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import common.web.BaseController;

/**
 * ClassName:MemberController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年2月25日 下午8:51:03 <br/>
 * @author   mqb
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Controller
public class MemberController extends BaseController {
	@RequestMapping("member-search")
	public String memberSearch(){
		return "biz/member/search";
	}
	
	@RequestMapping("member-level")
	public String memberLevel(){
		return "biz/member/level";
	}
	
	@RequestMapping("member-right")
	public String memberRight(){
		return "biz/member/right";
	}
	
	@RequestMapping("member-report-tool")
	public String memberReport(){
		return "biz/member/report";
	}
}

