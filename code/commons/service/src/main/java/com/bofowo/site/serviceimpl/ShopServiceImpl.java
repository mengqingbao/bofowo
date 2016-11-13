package com.bofowo.site.serviceimpl;

import com.bofowo.site.mapper.ShopMapper;
import com.bofowo.site.model.ShopModel;
import com.bofowo.site.query.ShopQuery;
import com.bofowo.site.service.ShopService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("shopService")
public class ShopServiceImpl implements ShopService{
	@Autowired
	private ShopMapper shopMapper;
	
	public List<ShopModel> fetchPage(ShopQuery query){
		return shopMapper.fetchPageList(query);
	}
	public int fetchPageCount(ShopQuery query){
		return shopMapper.fetchPageCount(query);
	}
	public ShopModel getById(long id){
		return shopMapper.getById(id);
	}
	public void del(long id){
		shopMapper.del(id);
	}
	public long insert(ShopModel shop){
		return shopMapper.insert(shop);
	}
	public long update(ShopModel shop){
		return shopMapper.update(shop);
	}
	@Override
	public ShopModel getByUsername(String currentUserName) {
		
		return shopMapper.getByUsername(currentUserName);
	}
} 
