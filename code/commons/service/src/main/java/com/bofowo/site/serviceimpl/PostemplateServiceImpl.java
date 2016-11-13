package com.bofowo.site.serviceimpl;

import com.bofowo.site.mapper.PostemplateMapper;
import com.bofowo.site.model.PostemplateModel;
import com.bofowo.site.query.PostemplateQuery;
import com.bofowo.site.service.PostemplateService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("postemplateService")
public class PostemplateServiceImpl implements PostemplateService{
	@Autowired
	private PostemplateMapper postemplateMapper;
	
	public List<PostemplateModel> fetchPage(PostemplateQuery query){
		return postemplateMapper.fetchPageList(query);
	}
	public int fetchPageCount(PostemplateQuery query){
		return postemplateMapper.fetchPageCount(query);
	}
	public PostemplateModel getById(long id){
		return postemplateMapper.getById(id);
	}
	public void del(long id){
		postemplateMapper.del(id);
	}
	public long insert(PostemplateModel postemplate){
		return postemplateMapper.insert(postemplate);
	}
	public long update(PostemplateModel postemplate){
		return postemplateMapper.update(postemplate);
	}
} 
