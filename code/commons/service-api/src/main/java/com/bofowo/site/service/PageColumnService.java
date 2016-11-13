package com.bofowo.site.service;

import com.bofowo.site.model.PageColumnModel;
import com.bofowo.site.query.PageColumnQuery;

import java.util.List;


public interface PageColumnService{
	public List<PageColumnModel> fetchPage(PageColumnQuery query);
	public int fetchPageCount(PageColumnQuery query);
	public PageColumnModel getById(long id);
	public void del(long id);
	public long insert(PageColumnModel pagecolumn);
	public long update(PageColumnModel pagecolumn);
	public List<PageColumnModel> getByPageId(int pageId);
} 
