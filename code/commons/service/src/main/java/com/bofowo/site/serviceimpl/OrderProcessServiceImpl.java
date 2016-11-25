package com.bofowo.site.serviceimpl;

import com.bofowo.site.model.OrderProcessModel;
import com.bofowo.site.mapper.OrderProcessMapper;
import com.bofowo.site.query.OrderProcessQuery;
import com.bofowo.site.service.OrderProcessService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("orderProcessService")
public class OrderProcessServiceImpl implements OrderProcessService{
	@Autowired
	private OrderProcessMapper orderprocessMapper;
	
	public List<OrderProcessModel> fetchPage(OrderProcessQuery query){
		return orderprocessMapper.fetchPageList(query);
	}
	public int fetchPageCount(OrderProcessQuery query){
		return orderprocessMapper.fetchPageCount(query);
	}
	public OrderProcessModel getById(long id){
		return orderprocessMapper.getById(id);
	}
	public void del(long id){
		orderprocessMapper.del(id);
	}
	public long insert(OrderProcessModel orderprocess){
		return orderprocessMapper.insert(orderprocess);
	}
	public long update(OrderProcessModel orderprocess){
		return orderprocessMapper.update(orderprocess);
	}
} 
