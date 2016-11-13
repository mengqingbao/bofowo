package com.bofowo.site.service;

import com.bofowo.site.model.TaglibModel;
import com.bofowo.site.query.TaglibQuery;

import java.util.List;


public interface TaglibService{
	public List<TaglibModel> fetchPage(TaglibQuery query);
	public int fetchPageCount(TaglibQuery query);
	public TaglibModel getById(long id);
	public void del(long id);
	public long insert(TaglibModel taglib);
	public long update(TaglibModel taglib);
} 
