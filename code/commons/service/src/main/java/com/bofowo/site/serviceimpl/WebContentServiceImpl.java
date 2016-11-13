package com.bofowo.site.serviceimpl;

import com.bofowo.site.mapper.WebContentMapper;
import com.bofowo.site.model.WebContentModel;
import com.bofowo.site.query.WebContentQuery;
import com.bofowo.site.service.WebContentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("webContentService")
public class WebContentServiceImpl implements WebContentService{
	@Autowired
	private WebContentMapper webcontentMapper;
	
	public List<WebContentModel> fetchPage(WebContentQuery query){
		return webcontentMapper.fetchPageList(query);
	}
	public int fetchPageCount(WebContentQuery query){
		return webcontentMapper.fetchPageCount(query);
	}
	public WebContentModel getById(long id){
		return webcontentMapper.getById(id);
	}
	public void del(long id){
		webcontentMapper.del(id);
	}
	public long insert(WebContentModel webcontent){
		return webcontentMapper.insert(webcontent);
	}
	public long update(WebContentModel webcontent){
		return webcontentMapper.update(webcontent);
	}
} 
