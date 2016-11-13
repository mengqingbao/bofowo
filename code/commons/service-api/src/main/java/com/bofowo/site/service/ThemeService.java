package com.bofowo.site.service;

import com.bofowo.site.model.ThemeModel;
import com.bofowo.site.query.ThemeQuery;

import java.util.List;


public interface ThemeService{
	public List<ThemeModel> fetchPage(ThemeQuery query);
	public int fetchPageCount(ThemeQuery query);
	public ThemeModel getById(long id);
	public void del(long id);
	public long insert(ThemeModel theme);
	public long update(ThemeModel theme);
} 
