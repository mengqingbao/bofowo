package com.bofowo.site.serviceimpl;

import com.bofowo.site.model.ExpressModel;
import com.bofowo.site.mapper.ExpressMapper;
import com.bofowo.site.query.ExpressQuery;
import com.bofowo.site.service.ExpressService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("expressService")
public class ExpressServiceImpl implements ExpressService{
	@Autowired
	private ExpressMapper expressMapper;
	
	public List<ExpressModel> fetchPage(ExpressQuery query){
		return expressMapper.fetchPageList(query);
	}
	public int fetchPageCount(ExpressQuery query){
		return expressMapper.fetchPageCount(query);
	}
	public ExpressModel getById(long id){
		return expressMapper.getById(id);
	}
	public void del(long id){
		expressMapper.del(id);
	}
	public long insert(ExpressModel express){
		return expressMapper.insert(express);
	}
	public long update(ExpressModel express){
		return expressMapper.update(express);
	}
} 
