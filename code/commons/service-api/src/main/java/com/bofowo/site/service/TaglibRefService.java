package com.bofowo.site.service;

import com.bofowo.site.model.TaglibRefModel;
import com.bofowo.site.query.TaglibRefQuery;

import java.util.List;


public interface TaglibRefService{
	public List<TaglibRefModel> fetchPage(TaglibRefQuery query);
	public int fetchPageCount(TaglibRefQuery query);
	public TaglibRefModel getById(long id);
	public void del(long id);
	public long insert(TaglibRefModel taglibref);
	public long update(TaglibRefModel taglibref);
} 
