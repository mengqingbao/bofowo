package com.bofowo.site.serviceimpl;

import com.bofowo.site.mapper.TradeConsoleMapper;
import com.bofowo.site.model.TradeConsoleModel;
import com.bofowo.site.query.TradeConsoleQuery;
import com.bofowo.site.service.TradeConsoleService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("tradeConsoleService")
public class TradeConsoleServiceImpl implements TradeConsoleService{
	@Autowired
	private TradeConsoleMapper tradeconsoleMapper;
	
	public List<TradeConsoleModel> fetchPage(TradeConsoleQuery query){
		return tradeconsoleMapper.fetchPageList(query);
	}
	public int fetchPageCount(TradeConsoleQuery query){
		return tradeconsoleMapper.fetchPageCount(query);
	}
	public TradeConsoleModel getById(long id){
		return tradeconsoleMapper.getById(id);
	}
	public void del(long id){
		tradeconsoleMapper.del(id);
	}
	public long insert(TradeConsoleModel tradeconsole){
		return tradeconsoleMapper.insert(tradeconsole);
	}
	public long update(TradeConsoleModel tradeconsole){
		return tradeconsoleMapper.update(tradeconsole);
	}
} 
