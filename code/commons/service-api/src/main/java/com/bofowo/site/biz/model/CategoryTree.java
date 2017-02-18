/**
 * Project Name:bfwmall-service-api
 * File Name:CategoryTree.java
 * Package Name:com.bofowo.site.biz.model
 * Date:2016年12月18日下午2:49:00
 * Copyright (c) 2016, BOFOWO Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.biz.model;

import java.util.List;

import com.bofowo.site.model.CategoryModel;

/**
 * ClassName:CategoryTree <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年12月18日 下午2:49:00 <br/>
 * @author   mqb
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class CategoryTree extends CategoryModel {

	private CategoryTree ParentCategoryModel;
	private CategoryTree currentCategoryModel;
	private CategoryTree childCategoryModel;
	public CategoryTree getParentCategoryModel() {
		return ParentCategoryModel;
	}
	public void setParentCategoryModel(CategoryTree parentCategoryModel) {
		ParentCategoryModel = parentCategoryModel;
	}
	public CategoryTree getCurrentCategoryModel() {
		return currentCategoryModel;
	}
	public void setCurrentCategoryModel(CategoryTree currentCategoryModel) {
		this.currentCategoryModel = currentCategoryModel;
	}
	public CategoryTree getChildCategoryModel() {
		return childCategoryModel;
	}
	public void setChildCategoryModel(CategoryTree childCategoryModel) {
		this.childCategoryModel = childCategoryModel;
	}
	
	
	
}

