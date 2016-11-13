package com.bofowo.site.serviceimpl;

import com.bofowo.site.mapper.ProducstockMapper;
import com.bofowo.site.model.ProducstockModel;
import com.bofowo.site.query.ProducstockQuery;
import com.bofowo.site.service.ProducstockService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("producstockService")
public class ProducstockServiceImpl implements ProducstockService{
	@Autowired
	private ProducstockMapper producstockMapper;
	
	public List<ProducstockModel> fetchPage(ProducstockQuery query){
		return producstockMapper.fetchPageList(query);
	}
	public int fetchPageCount(ProducstockQuery query){
		return producstockMapper.fetchPageCount(query);
	}
	public ProducstockModel getById(long id){
		return producstockMapper.getById(id);
	}
	public void del(long id){
		producstockMapper.del(id);
	}
	public long insert(ProducstockModel producstock){
		return producstockMapper.insert(producstock);
	}
	public long update(ProducstockModel producstock){
		return producstockMapper.update(producstock);
	}
} 
