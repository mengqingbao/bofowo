package com.bofowo.site.serviceimpl;

import com.bofowo.site.mapper.TypeMapper;
import com.bofowo.site.model.TypeModel;
import com.bofowo.site.query.TypeQuery;
import com.bofowo.site.service.TypeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("typeService")
public class TypeServiceImpl implements TypeService{
	@Autowired
	private TypeMapper typeMapper;
	
	public List<TypeModel> fetchPage(TypeQuery query){
		return typeMapper.fetchPageList(query);
	}
	public int fetchPageCount(TypeQuery query){
		return typeMapper.fetchPageCount(query);
	}
	public TypeModel getById(long id){
		return typeMapper.getById(id);
	}
	public void del(long id){
		typeMapper.del(id);
	}
	public long insert(TypeModel type){
		return typeMapper.insert(type);
	}
	public long update(TypeModel type){
		return typeMapper.update(type);
	}
} 
