package com.bofowo.site.service;

import com.bofowo.site.model.PageModel;
import com.bofowo.site.query.PageQuery;

import java.util.List;


public interface PageService{
	public List<PageModel> fetchPage(PageQuery query);
	public int fetchPageCount(PageQuery query);
	public PageModel getById(long id);
	public void del(long id);
	public long insert(PageModel page);
	public long update(PageModel page);
} 
