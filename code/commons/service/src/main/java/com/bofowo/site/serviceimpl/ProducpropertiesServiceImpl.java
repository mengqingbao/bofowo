package com.bofowo.site.serviceimpl;

import com.bofowo.site.mapper.ProducpropertiesMapper;
import com.bofowo.site.model.ProducpropertiesModel;
import com.bofowo.site.query.ProducpropertiesQuery;
import com.bofowo.site.service.ProducpropertiesService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("producpropertiesService")
public class ProducpropertiesServiceImpl implements ProducpropertiesService{
	@Autowired
	private ProducpropertiesMapper producpropertiesMapper;
	
	public List<ProducpropertiesModel> fetchPage(ProducpropertiesQuery query){
		return producpropertiesMapper.fetchPageList(query);
	}
	public int fetchPageCount(ProducpropertiesQuery query){
		return producpropertiesMapper.fetchPageCount(query);
	}
	public ProducpropertiesModel getById(long id){
		return producpropertiesMapper.getById(id);
	}
	public void del(long id){
		producpropertiesMapper.del(id);
	}
	public long insert(ProducpropertiesModel producproperties){
		return producpropertiesMapper.insert(producproperties);
	}
	public long update(ProducpropertiesModel producproperties){
		return producpropertiesMapper.update(producproperties);
	}
	@Override
	public List<ProducpropertiesModel> getByCateId(ProducpropertiesQuery query) {
		
		return producpropertiesMapper.fetchPageList(query);
	}
} 
