package com.bofowo.site.service;

import com.bofowo.site.model.PostemplateModel;
import com.bofowo.site.query.PostemplateQuery;

import java.util.List;


public interface PostemplateService{
	public List<PostemplateModel> fetchPage(PostemplateQuery query);
	public int fetchPageCount(PostemplateQuery query);
	public PostemplateModel getById(long id);
	public void del(long id);
	public long insert(PostemplateModel postemplate);
	public long update(PostemplateModel postemplate);
} 
