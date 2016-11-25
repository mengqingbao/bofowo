package com.bofowo.site.service;

import com.bofowo.site.model.OrderProcessModel;
import com.bofowo.site.query.OrderProcessQuery;
import java.util.List;


public interface OrderProcessService{
	public List<OrderProcessModel> fetchPage(OrderProcessQuery query);
	public int fetchPageCount(OrderProcessQuery query);
	public OrderProcessModel getById(long id);
	public void del(long id);
	public long insert(OrderProcessModel orderprocess);
	public long update(OrderProcessModel orderprocess);
} 
