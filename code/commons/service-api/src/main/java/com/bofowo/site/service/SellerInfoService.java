package com.bofowo.site.service;

import com.bofowo.site.model.SellerInfoModel;
import com.bofowo.site.query.SellerInfoQuery;

import java.util.List;


public interface SellerInfoService{
	public List<SellerInfoModel> fetchPage(SellerInfoQuery query);
	public int fetchPageCount(SellerInfoQuery query);
	public SellerInfoModel getById(long id);
	public void del(long id);
	public long insert(SellerInfoModel sellerinfo);
	public long update(SellerInfoModel sellerinfo);
	public SellerInfoModel getBySellerId(String currentUserName);
} 
