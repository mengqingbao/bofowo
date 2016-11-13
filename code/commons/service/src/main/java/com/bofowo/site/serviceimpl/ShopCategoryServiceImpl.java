package com.bofowo.site.serviceimpl;

import com.bofowo.site.mapper.ShopCategoryMapper;
import com.bofowo.site.model.ShopCategoryModel;
import com.bofowo.site.query.ShopCategoryQuery;
import com.bofowo.site.service.ShopCategoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("shopCategoryService")
public class ShopCategoryServiceImpl implements ShopCategoryService{
	@Autowired
	private ShopCategoryMapper shopcategoryMapper;
	
	public List<ShopCategoryModel> fetchPage(ShopCategoryQuery query){
		return shopcategoryMapper.fetchPageList(query);
	}
	public int fetchPageCount(ShopCategoryQuery query){
		return shopcategoryMapper.fetchPageCount(query);
	}
	public ShopCategoryModel getById(long id){
		return shopcategoryMapper.getById(id);
	}
	public void del(long id){
		shopcategoryMapper.del(id);
	}
	public long insert(ShopCategoryModel shopcategory){
		return shopcategoryMapper.insert(shopcategory);
	}
	public long update(ShopCategoryModel shopcategory){
		return shopcategoryMapper.update(shopcategory);
	}
	@Override
	public List<ShopCategoryModel> getListByShopId(int id) {
		return shopcategoryMapper.getListByShopId(id);
	}
	@Override
	public List<ShopCategoryModel> getCatesBySellerId(String sellerId) {
		return shopcategoryMapper.getCatesBySellerId(sellerId);
	}
} 
