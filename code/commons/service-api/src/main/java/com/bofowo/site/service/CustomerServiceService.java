package com.bofowo.site.service;

import com.bofowo.site.model.CustomerServiceModel;
import com.bofowo.site.query.CustomerServiceQuery;

import java.util.List;


public interface CustomerServiceService{
	public List<CustomerServiceModel> fetchPage(CustomerServiceQuery query);
	public int fetchPageCount(CustomerServiceQuery query);
	public CustomerServiceModel getById(long id);
	public void del(long id);
	public long insert(CustomerServiceModel customerservice);
	public long update(CustomerServiceModel customerservice);
} 
