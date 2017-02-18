package com.bofowo.site.service;

import com.bofowo.site.model.ExpressModel;
import com.bofowo.site.query.ExpressQuery;
import java.util.List;


public interface ExpressService{
	public List<ExpressModel> fetchPage(ExpressQuery query);
	public int fetchPageCount(ExpressQuery query);
	public ExpressModel getById(long id);
	public void del(long id);
	public long insert(ExpressModel express);
	public long update(ExpressModel express);
} 
