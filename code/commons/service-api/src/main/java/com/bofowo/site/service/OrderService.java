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
	public List<OrderModel> getOrderByOrderIds(String ids,String username);
	public void updateOrderByTid(int id, String tRADE_CLOSE, String userName);
	public void updateStatusByids(String orderIds, String wAITING_SELLER_SEND,
			String userName);
} 
