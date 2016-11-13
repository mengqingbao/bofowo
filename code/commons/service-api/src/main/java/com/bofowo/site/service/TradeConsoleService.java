package com.bofowo.site.service;

import com.bofowo.site.model.TradeConsoleModel;
import com.bofowo.site.query.TradeConsoleQuery;

import java.util.List;


public interface TradeConsoleService{
	public List<TradeConsoleModel> fetchPage(TradeConsoleQuery query);
	public int fetchPageCount(TradeConsoleQuery query);
	public TradeConsoleModel getById(long id);
	public void del(long id);
	public long insert(TradeConsoleModel tradeconsole);
	public long update(TradeConsoleModel tradeconsole);
} 
