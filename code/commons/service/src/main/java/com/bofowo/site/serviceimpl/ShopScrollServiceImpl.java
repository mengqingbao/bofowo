package com.bofowo.site.serviceimpl;

import com.bofowo.site.model.ShopScrollModel;
import com.bofowo.site.mapper.ShopScrollMapper;
import com.bofowo.site.query.ShopScrollQuery;
import com.bofowo.site.service.ShopScrollService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("shopScrollService")
public class ShopScrollServiceImpl implements ShopScrollService{
	@Autowired
	private ShopScrollMapper shopscrollMapper;
	
	public List<ShopScrollModel> fetchPage(ShopScrollQuery query){
		return shopscrollMapper.fetchPageList(query);
	}
	public int fetchPageCount(ShopScrollQuery query){
		return shopscrollMapper.fetchPageCount(query);
	}
	public ShopScrollModel getById(long id){
		return shopscrollMapper.getById(id);
	}
	public void del(long id){
		shopscrollMapper.del(id);
	}
	public long insert(ShopScrollModel shopscroll){
		return shopscrollMapper.insert(shopscroll);
	}
	public long update(ShopScrollModel shopscroll){
		return shopscrollMapper.update(shopscroll);
	}
	@Override
	public List<ShopScrollModel> getScrollByshopId(int shopId) {
		
		return shopscrollMapper.getScrollByshopId(shopId);
	}
} 
