package com.bofowo.site.service;

import com.bofowo.site.model.SeqModel;
import com.bofowo.site.query.SeqQuery;

import java.util.List;


public interface SeqService{
	public List<SeqModel> fetchPage(SeqQuery query);
	public int fetchPageCount(SeqQuery query);
	public SeqModel getById(long id);
	public void del(long id);
	public long insert(SeqModel seq);
	public long update(SeqModel seq);
} 
