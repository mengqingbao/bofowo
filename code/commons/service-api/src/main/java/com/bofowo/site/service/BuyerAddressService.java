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
	/**
	 * 获得买家收货地址
	 * @author mqb
	 * @param username
	 * @return
	 * @since JDK 1.7
	 */
	public List<BuyerAddressModel> getBuyerAddress(String username);
} 
