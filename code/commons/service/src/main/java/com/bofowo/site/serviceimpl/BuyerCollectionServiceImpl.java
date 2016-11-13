package com.bofowo.site.serviceimpl;

import com.bofowo.site.mapper.BuyerCollectionMapper;
import com.bofowo.site.model.BuyerCollectionModel;
import com.bofowo.site.query.BuyerCollectionQuery;
import com.bofowo.site.service.BuyerCollectionService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("buyerCollectionService")
public class BuyerCollectionServiceImpl implements BuyerCollectionService{
	@Autowired
	private BuyerCollectionMapper buyercollectionMapper;
	
	public List<BuyerCollectionModel> fetchPage(BuyerCollectionQuery query){
		return buyercollectionMapper.fetchPageList(query);
	}
	public int fetchPageCount(BuyerCollectionQuery query){
		return buyercollectionMapper.fetchPageCount(query);
	}
	public BuyerCollectionModel getById(long id){
		return buyercollectionMapper.getById(id);
	}
	public void del(long id){
		buyercollectionMapper.del(id);
	}
	public long insert(BuyerCollectionModel buyercollection){
		return buyercollectionMapper.insert(buyercollection);
	}
	public long update(BuyerCollectionModel buyercollection){
		return buyercollectionMapper.update(buyercollection);
	}
	public BuyerCollectionModel getByProductId(Integer id) {
		
		return buyercollectionMapper.getByProductId(id);
	}
} 
