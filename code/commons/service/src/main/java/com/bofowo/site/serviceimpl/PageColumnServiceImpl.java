package com.bofowo.site.serviceimpl;

import com.bofowo.site.mapper.PageColumnMapper;
import com.bofowo.site.model.PageColumnModel;
import com.bofowo.site.query.PageColumnQuery;
import com.bofowo.site.service.PageColumnService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("pageColumnService")
public class PageColumnServiceImpl implements PageColumnService{
	@Autowired
	private PageColumnMapper pagecolumnMapper;
	
	public List<PageColumnModel> fetchPage(PageColumnQuery query){
		return pagecolumnMapper.fetchPageList(query);
	}
	public int fetchPageCount(PageColumnQuery query){
		return pagecolumnMapper.fetchPageCount(query);
	}
	public PageColumnModel getById(long id){
		return pagecolumnMapper.getById(id);
	}
	public void del(long id){
		pagecolumnMapper.del(id);
	}
	public long insert(PageColumnModel pagecolumn){
		return pagecolumnMapper.insert(pagecolumn);
	}
	public long update(PageColumnModel pagecolumn){
		return pagecolumnMapper.update(pagecolumn);
	}
	@Override
	public List<PageColumnModel> getByPageId(int pageId) {
		
		return pagecolumnMapper.getByPageId(pageId);
	}
} 
