package com.bofowo.site.service;

import com.bofowo.site.model.BuyerAddressModel;
import com.bofowo.site.query.BuyerAddressQuery;

import java.util.List;


public interface BuyerAddressService{
	public List<BuyerAddressModel> fetchPage(BuyerAddressQuery query);
	public int fetchPageCount(BuyerAddressQuery query);
	public BuyerAddressModel getById(long id);
	public void del(long id);
	public long insert(BuyerAddressModel buyeraddress);
	public long update(BuyerAddressModel buyeraddress);
	void clearDefault(String bueryId);
} 
