package com.bofowo.site.serviceimpl;

import com.bofowo.site.model.ProducpropValModel;
import com.bofowo.site.mapper.ProducpropValMapper;
import com.bofowo.site.query.ProducpropValQuery;
import com.bofowo.site.service.ProducpropValService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("producpropValService")
public class ProducpropValServiceImpl implements ProducpropValService{
	@Autowired
	private ProducpropValMapper producpropvalMapper;
	
	public List<ProducpropValModel> fetchPage(ProducpropValQuery query){
		return producpropvalMapper.fetchPageList(query);
	}
	public int fetchPageCount(ProducpropValQuery query){
		return producpropvalMapper.fetchPageCount(query);
	}
	public ProducpropValModel getById(long id){
		return producpropvalMapper.getById(id);
	}
	public void del(long id){
		producpropvalMapper.del(id);
	}
	public long insert(ProducpropValModel producpropval){
		return producpropvalMapper.insert(producpropval);
	}
	public long update(ProducpropValModel producpropval){
		return producpropvalMapper.update(producpropval);
	}
	@Override
	public List<ProducpropValModel> getListByItemId(Integer itemId) {
		return producpropvalMapper.getListByItemId(itemId);
	}
	@Override
	public void delByItemId(int id) {
		
		producpropvalMapper.delByItemId(id);
	}
} 
