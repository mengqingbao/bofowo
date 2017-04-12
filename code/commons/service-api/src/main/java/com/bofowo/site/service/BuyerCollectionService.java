package com.bofowo.site.service;

import com.bofowo.site.model.BuyerCollectionModel;
import com.bofowo.site.query.BuyerCollectionQuery;

import java.util.List;


public interface BuyerCollectionService{
	public List<BuyerCollectionModel> fetchPage(BuyerCollectionQuery query);
	public int fetchPageCount(BuyerCollectionQuery query);
	public BuyerCollectionModel getById(long id);
	public void del(long id);
	public long insert(BuyerCollectionModel buyercollection);
	public long update(BuyerCollectionModel buyercollection);
	public BuyerCollectionModel getByProductId(Integer id,String buyerId);
	public BuyerCollectionModel getByShopId(Integer id,String buyerId);
} 
