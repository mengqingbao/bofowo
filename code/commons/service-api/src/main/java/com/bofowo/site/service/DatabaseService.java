package com.bofowo.site.service;

import com.bofowo.site.model.DatabaseModel;
import com.bofowo.site.query.DatabaseQuery;

import java.util.List;


public interface DatabaseService{
	public List<DatabaseModel> fetchPage(DatabaseQuery query);
	public int fetchPageCount(DatabaseQuery query);
	public DatabaseModel getById(long id);
	public void del(long id);
	public long insert(DatabaseModel database);
	public long update(DatabaseModel database);
} 
