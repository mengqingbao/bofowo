package com.bofowo.site.service;

import com.bofowo.site.model.WebContentModel;
import com.bofowo.site.query.WebContentQuery;

import java.util.List;


public interface WebContentService{
	public List<WebContentModel> fetchPage(WebContentQuery query);
	public int fetchPageCount(WebContentQuery query);
	public WebContentModel getById(long id);
	public void del(long id);
	public long insert(WebContentModel webcontent);
	public long update(WebContentModel webcontent);
} 
