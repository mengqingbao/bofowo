package com.bofowo.site.service;

import com.bofowo.site.model.ProducpropValModel;
import com.bofowo.site.query.ProducpropValQuery;

import java.util.List;


public interface ProducpropValService{
	public List<ProducpropValModel> fetchPage(ProducpropValQuery query);
	public int fetchPageCount(ProducpropValQuery query);
	public ProducpropValModel getById(long id);
	public void del(long id);
	public long insert(ProducpropValModel producpropval);
	public long update(ProducpropValModel producpropval);
	public List<ProducpropValModel> getListByItemId(Integer itemId);
	public void delByItemId(int id);
} 
