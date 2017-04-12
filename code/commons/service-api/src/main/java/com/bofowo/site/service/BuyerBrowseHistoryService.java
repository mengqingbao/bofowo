package com.bofowo.site.service;

import com.bofowo.site.model.BuyerBrowseHistoryModel;
import com.bofowo.site.query.BuyerBrowseHistoryQuery;

import java.util.List;


public interface BuyerBrowseHistoryService{
	
	public long insert(BuyerBrowseHistoryModel buyerbrowsehistory);
	public long update(BuyerBrowseHistoryModel buyerbrowsehistory);
	public void countVisitTimes(BuyerBrowseHistoryModel buyerbrowsehistory);
} 
