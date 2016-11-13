package com.bofowo.site.service;

import com.bofowo.site.model.ProducpropertiesModel;
import com.bofowo.site.query.ProducpropertiesQuery;

import java.util.List;


public interface ProducpropertiesService{
	public List<ProducpropertiesModel> fetchPage(ProducpropertiesQuery query);
	public int fetchPageCount(ProducpropertiesQuery query);
	public ProducpropertiesModel getById(long id);
	public void del(long id);
	public long insert(ProducpropertiesModel producproperties);
	public long update(ProducpropertiesModel producproperties);
} 
