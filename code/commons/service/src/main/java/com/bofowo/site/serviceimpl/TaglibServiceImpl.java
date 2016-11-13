package com.bofowo.site.serviceimpl;

import com.bofowo.site.mapper.TaglibMapper;
import com.bofowo.site.model.TaglibModel;
import com.bofowo.site.query.TaglibQuery;
import com.bofowo.site.service.TaglibService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("taglibService")
public class TaglibServiceImpl implements TaglibService{
	@Autowired
	private TaglibMapper taglibMapper;
	
	public List<TaglibModel> fetchPage(TaglibQuery query){
		return taglibMapper.fetchPageList(query);
	}
	public int fetchPageCount(TaglibQuery query){
		return taglibMapper.fetchPageCount(query);
	}
	public TaglibModel getById(long id){
		return taglibMapper.getById(id);
	}
	public void del(long id){
		taglibMapper.del(id);
	}
	public long insert(TaglibModel taglib){
		return taglibMapper.insert(taglib);
	}
	public long update(TaglibModel taglib){
		return taglibMapper.update(taglib);
	}
} 
