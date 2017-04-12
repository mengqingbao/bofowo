package com.bofowo.site.service;

import com.bofowo.site.model.ProducstockModel;
import com.bofowo.site.query.ProducstockQuery;

import java.util.List;


public interface ProducstockService{
	public List<ProducstockModel> fetchPage(ProducstockQuery query);
	public int fetchPageCount(ProducstockQuery query);
	public ProducstockModel getById(long id);
	public void del(long id);
	public long insert(ProducstockModel producstock);
	public long update(ProducstockModel producstock);
	public List<ProducstockModel> getListByItemId(Integer itemId);
	public void delByItemId(int id);
} 
