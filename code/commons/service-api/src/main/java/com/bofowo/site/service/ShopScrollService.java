package com.bofowo.site.service;

import com.bofowo.site.model.ShopScrollModel;
import com.bofowo.site.query.ShopScrollQuery;
import java.util.List;


public interface ShopScrollService{
	public List<ShopScrollModel> fetchPage(ShopScrollQuery query);
	public int fetchPageCount(ShopScrollQuery query);
	public ShopScrollModel getById(long id);
	public void del(long id);
	public long insert(ShopScrollModel shopscroll);
	public long update(ShopScrollModel shopscroll);
	public List<ShopScrollModel> getScrollByshopId(int shopId);
} 
