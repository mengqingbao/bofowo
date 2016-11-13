package com.bofowo.site.service;

import com.bofowo.site.model.AlipayAccountModel;
import com.bofowo.site.query.AlipayAccountQuery;

import java.util.List;


public interface AlipayAccountService{
	public List<AlipayAccountModel> fetchPage(AlipayAccountQuery query);
	public int fetchPageCount(AlipayAccountQuery query);
	public AlipayAccountModel getById(long id);
	public void del(long id);
	public long insert(AlipayAccountModel alipayaccount);
	public long update(AlipayAccountModel alipayaccount);
	public AlipayAccountModel getBySellerId(String sellerId);
} 
