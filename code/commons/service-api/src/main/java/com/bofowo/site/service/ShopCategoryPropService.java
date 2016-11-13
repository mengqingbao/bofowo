package com.bofowo.site.service;

import com.bofowo.site.model.ShopCategoryPropModel;
import com.bofowo.site.query.ShopCategoryPropQuery;

import java.util.List;


public interface ShopCategoryPropService{
	public List<ShopCategoryPropModel> fetchPage(ShopCategoryPropQuery query);
	public int fetchPageCount(ShopCategoryPropQuery query);
	public ShopCategoryPropModel getById(long id);
	public void del(long id);
	public long insert(ShopCategoryPropModel shopcategoryprop);
	public long update(ShopCategoryPropModel shopcategoryprop);
} 
