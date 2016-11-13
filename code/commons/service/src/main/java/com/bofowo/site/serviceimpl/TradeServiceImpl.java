package com.bofowo.site.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bofowo.site.mapper.OrderMapper;
import com.bofowo.site.mapper.TradeMapper;
import com.bofowo.site.model.OrderModel;
import com.bofowo.site.model.TradeModel;
import com.bofowo.site.query.TradeQuery;
import com.bofowo.site.service.TradeService;


@Component("tradeService")
public class TradeServiceImpl implements TradeService{
	@Autowired
	private TradeMapper tradeMapper;
	@Autowired
	private OrderMapper orderMapper;
	
	public List<TradeModel> fetchPage(TradeQuery query){
		return tradeMapper.fetchPageList(query);
	}
	public int fetchPageCount(TradeQuery query){
		return tradeMapper.fetchPageCount(query);
	}
	public TradeModel getById(long id){
		return tradeMapper.getById(id);
	}
	public void del(long id){
		tradeMapper.del(id);
	}
	public long insert(TradeModel trade){
		return tradeMapper.insert(trade);
	}
	public long update(TradeModel trade){
		return tradeMapper.update(trade);
	}
	@Override
	public void pay(Integer tid,String status) {
		
		TradeModel trade=this.getById(tid);
		if(trade!=null){
		trade.setStatus("1");
		this.update(trade);
		List<OrderModel> orders=orderMapper.getOrderByTradeId(tid);
		for(OrderModel order:orders){
			order.setStatus(status);
			orderMapper.update(order);
		}
		}
		
	}
} 
