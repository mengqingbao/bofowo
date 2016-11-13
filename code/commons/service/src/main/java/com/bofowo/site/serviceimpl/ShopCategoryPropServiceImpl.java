package com.bofowo.site.serviceimpl;

import com.bofowo.site.mapper.ShopCategoryPropMapper;
import com.bofowo.site.model.ShopCategoryPropModel;
import com.bofowo.site.query.ShopCategoryPropQuery;
import com.bofowo.site.service.ShopCategoryPropService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("shopCategoryPropService")
public class ShopCategoryPropServiceImpl implements ShopCategoryPropService{
	@Autowired
	private ShopCategoryPropMapper shopcategorypropMapper;
	
	public List<ShopCategoryPropModel> fetchPage(ShopCategoryPropQuery query){
		return shopcategorypropMapper.fetchPageList(query);
	}
	public int fetchPageCount(ShopCategoryPropQuery query){
		return shopcategorypropMapper.fetchPageCount(query);
	}
	public ShopCategoryPropModel getById(long id){
		return shopcategorypropMapper.getById(id);
	}
	public void del(long id){
		shopcategorypropMapper.del(id);
	}
	public long insert(ShopCategoryPropModel shopcategoryprop){
		return shopcategorypropMapper.insert(shopcategoryprop);
	}
	public long update(ShopCategoryPropModel shopcategoryprop){
		return shopcategorypropMapper.update(shopcategoryprop);
	}
} 
