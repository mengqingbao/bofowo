/**
 * Project Name:lymall-management
 * File Name:ProductController.java
 * Package Name:com.bofowo.site.controller
 * Date:2016年2月25日下午8:50:17
 * Copyright (c) 2016,Shanghai bofowo Technology co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import common.web.BaseController;

/**
 * ClassName:ProductController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年2月25日 下午8:50:17 <br/>
 * @author   mqb
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Controller
public class MgtProductController extends BaseController {

	@RequestMapping("product-search")
	public String productSearch(){
		return "biz/product/searchProduct";
	}
	
	@RequestMapping("product-category-search")
	public String categoryMange(){
		
		return "biz/product/categorySearch";
	}
	
	@RequestMapping("product-taglib-manage")
	public String taglibMange(){
		return "biz/product/taglibs";
	}
	
	@RequestMapping("add-product")
	public String createProduct(){
		return "biz/product/addProduct";
	}
	@RequestMapping("add-product-detail")
	public String createProductDetail(){
		return "biz/product/addProductDetail";
	}
	

}

