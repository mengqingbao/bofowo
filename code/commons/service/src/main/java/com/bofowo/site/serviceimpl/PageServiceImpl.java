package com.bofowo.site.serviceimpl;

import com.bofowo.site.mapper.PageMapper;
import com.bofowo.site.model.PageModel;
import com.bofowo.site.query.PageQuery;
import com.bofowo.site.service.PageService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("pageService")
public class PageServiceImpl implements PageService{
	@Autowired
	private PageMapper pageMapper;
	
	public List<PageModel> fetchPage(PageQuery query){
		return pageMapper.fetchPageList(query);
	}
	public int fetchPageCount(PageQuery query){
		return pageMapper.fetchPageCount(query);
	}
	public PageModel getById(long id){
		return pageMapper.getById(id);
	}
	public void del(long id){
		pageMapper.del(id);
	}
	public long insert(PageModel page){
		return pageMapper.insert(page);
	}
	public long update(PageModel page){
		return pageMapper.update(page);
	}
} 
