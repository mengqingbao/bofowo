package com.bofowo.site.service;

import com.bofowo.site.model.ShopModel;
import com.bofowo.site.query.ShopQuery;

import java.util.List;


public interface ShopService{
	public List<ShopModel> fetchPage(ShopQuery query);
	public int fetchPageCount(ShopQuery query);
	public ShopModel getById(long id);
	public void del(long id);
	public long insert(ShopModel shop);
	public long update(ShopModel shop);
	public ShopModel getByUsername(String currentUserName);
} 
