package com.bofowo.site.service;

import com.bofowo.site.model.MyShowModel;
import com.bofowo.site.query.MyShowQuery;
import java.util.List;


public interface MyShowService{
	public List<MyShowModel> fetchPage(MyShowQuery query);
	public int fetchPageCount(MyShowQuery query);
	public MyShowModel getById(long id);
	public void del(long id);
	public long insert(MyShowModel myshow);
	public long update(MyShowModel myshow);
} 
