package com.bofowo.site.service;

import com.bofowo.site.model.OrderModel;
import com.bofowo.site.query.OrderQuery;

import java.util.List;


public interface OrderService{
	public List<OrderModel> fetchPage(OrderQuery query);
	public int fetchPageCount(OrderQuery query);
	public OrderModel getById(long id);
	public void del(long id);
	public long insert(OrderModel order);
	public long update(OrderModel order);
	public List<OrderModel> getOrderByTid(long id);
} 
