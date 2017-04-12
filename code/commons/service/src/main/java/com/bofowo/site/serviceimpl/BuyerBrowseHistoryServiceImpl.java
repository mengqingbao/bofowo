package com.bofowo.site.serviceimpl;

import com.bofowo.site.model.BuyerBrowseHistoryModel;
import com.bofowo.site.mapper.BuyerBrowseHistoryMapper;
import com.bofowo.site.query.BuyerBrowseHistoryQuery;
import com.bofowo.site.service.BuyerBrowseHistoryService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("buyerBrowseHistoryService")
public class BuyerBrowseHistoryServiceImpl implements BuyerBrowseHistoryService{
	@Autowired
	private BuyerBrowseHistoryMapper buyerbrowsehistoryMapper;
	
	
	public long insert(BuyerBrowseHistoryModel buyerbrowsehistory){
		return buyerbrowsehistoryMapper.insert(buyerbrowsehistory);
	}
	public long update(BuyerBrowseHistoryModel buyerbrowsehistory){
		return buyerbrowsehistoryMapper.update(buyerbrowsehistory);
	}
	
	public void countVisitTimes(BuyerBrowseHistoryModel bvhm) {
		Map<String,String> condition=new HashMap<String,String>();
		condition.put("pid", String.valueOf(bvhm.getPid()));
		condition.put("buyerId", bvhm.getBuyerId());
		BuyerBrowseHistoryModel sotredBvhm=buyerbrowsehistoryMapper.getById(condition);
		if(sotredBvhm==null){
			buyerbrowsehistoryMapper.insert(bvhm);
		}else{
			sotredBvhm.setLastVisitDate(new Date());
			sotredBvhm.setTimes(sotredBvhm.getTimes()+1);
			buyerbrowsehistoryMapper.update(sotredBvhm);
		}
		
	}
} 
