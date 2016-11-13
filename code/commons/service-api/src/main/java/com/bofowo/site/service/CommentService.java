package com.bofowo.site.service;

import com.bofowo.site.model.CommentModel;
import com.bofowo.site.query.CommentQuery;

import java.util.List;


public interface CommentService{
	public List<CommentModel> fetchPage(CommentQuery query);
	public int fetchPageCount(CommentQuery query);
	public CommentModel getById(long id);
	public void del(long id);
	public long insert(CommentModel comment);
	public long update(CommentModel comment);
} 
