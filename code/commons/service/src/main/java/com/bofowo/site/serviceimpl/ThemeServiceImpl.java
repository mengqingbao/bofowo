package com.bofowo.site.serviceimpl;

import com.bofowo.site.mapper.ThemeMapper;
import com.bofowo.site.model.ThemeModel;
import com.bofowo.site.query.ThemeQuery;
import com.bofowo.site.service.ThemeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("themeService")
public class ThemeServiceImpl implements ThemeService{
	@Autowired
	private ThemeMapper themeMapper;
	
	public List<ThemeModel> fetchPage(ThemeQuery query){
		return themeMapper.fetchPageList(query);
	}
	public int fetchPageCount(ThemeQuery query){
		return themeMapper.fetchPageCount(query);
	}
	public ThemeModel getById(long id){
		return themeMapper.getById(id);
	}
	public void del(long id){
		themeMapper.del(id);
	}
	public long insert(ThemeModel theme){
		return themeMapper.insert(theme);
	}
	public long update(ThemeModel theme){
		return themeMapper.update(theme);
	}
} 
