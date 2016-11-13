package com.bofowo.site.service;

import com.bofowo.site.model.TypeModel;
import com.bofowo.site.query.TypeQuery;

import java.util.List;


public interface TypeService{
	public List<TypeModel> fetchPage(TypeQuery query);
	public int fetchPageCount(TypeQuery query);
	public TypeModel getById(long id);
	public void del(long id);
	public long insert(TypeModel type);
	public long update(TypeModel type);
} 
