package com.bofowo.site.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bofowo.site.mapper.OrderMapper;
import com.bofowo.site.model.OrderModel;
import com.bofowo.site.query.OrderQuery;
import com.bofowo.site.service.OrderService;


@Component("orderService")
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderMapper orderMapper;
	
	public List<OrderModel> fetchPage(OrderQuery query){
		return orderMapper.fetchPageList(query);
	}
	public int fetchPageCount(OrderQuery query){
		return orderMapper.fetchPageCount(query);
	}
	public OrderModel getById(long id){
		return orderMapper.getById(id);
	}
	public void del(long id){
		orderMapper.del(id);
	}
	public long insert(OrderModel order){
		return orderMapper.insert(order);
	}
	public long update(OrderModel order){
		return orderMapper.update(order);
	}
	@Override
	public List<OrderModel> getOrderByTid(long id) {
		return orderMapper.getOrderByTradeId(id);
	}
} 
