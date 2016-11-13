package com.bofowo.site.serviceimpl;

import com.bofowo.site.mapper.TaglibRefMapper;
import com.bofowo.site.model.TaglibRefModel;
import com.bofowo.site.query.TaglibRefQuery;
import com.bofowo.site.service.TaglibRefService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("taglibRefService")
public class TaglibRefServiceImpl implements TaglibRefService{
	@Autowired
	private TaglibRefMapper taglibrefMapper;
	
	public List<TaglibRefModel> fetchPage(TaglibRefQuery query){
		return taglibrefMapper.fetchPageList(query);
	}
	public int fetchPageCount(TaglibRefQuery query){
		return taglibrefMapper.fetchPageCount(query);
	}
	public TaglibRefModel getById(long id){
		return taglibrefMapper.getById(id);
	}
	public void del(long id){
		taglibrefMapper.del(id);
	}
	public long insert(TaglibRefModel taglibref){
		return taglibrefMapper.insert(taglibref);
	}
	public long update(TaglibRefModel taglibref){
		return taglibrefMapper.update(taglibref);
	}
} 
