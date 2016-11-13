package com.bofowo.site.serviceimpl;

import com.bofowo.site.mapper.DatabaseMapper;
import com.bofowo.site.model.DatabaseModel;
import com.bofowo.site.query.DatabaseQuery;
import com.bofowo.site.service.DatabaseService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("databaseService")
public class DatabaseServiceImpl implements DatabaseService{
	@Autowired
	private DatabaseMapper databaseMapper;
	
	public List<DatabaseModel> fetchPage(DatabaseQuery query){
		return databaseMapper.fetchPageList(query);
	}
	public int fetchPageCount(DatabaseQuery query){
		return databaseMapper.fetchPageCount(query);
	}
	public DatabaseModel getById(long id){
		return databaseMapper.getById(id);
	}
	public void del(long id){
		databaseMapper.del(id);
	}
	public long insert(DatabaseModel database){
		return databaseMapper.insert(database);
	}
	public long update(DatabaseModel database){
		return databaseMapper.update(database);
	}
} 
