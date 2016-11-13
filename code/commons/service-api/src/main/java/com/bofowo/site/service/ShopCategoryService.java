package com.bofowo.site.service;

import com.bofowo.site.model.ShopCategoryModel;
import com.bofowo.site.query.ShopCategoryQuery;

import java.util.List;


public interface ShopCategoryService{
	public List<ShopCategoryModel> fetchPage(ShopCategoryQuery query);
	public int fetchPageCount(ShopCategoryQuery query);
	public ShopCategoryModel getById(long id);
	public void del(long id);
	public long insert(ShopCategoryModel shopcategory);
	public long update(ShopCategoryModel shopcategory);
	public List<ShopCategoryModel> getListByShopId(int id);
	public List<ShopCategoryModel> getCatesBySellerId(String currentUserName);
} 
