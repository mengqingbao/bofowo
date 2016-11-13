package com.bofowo.site.serviceimpl;

import com.bofowo.site.mapper.ManageResourceMapper;
import com.bofowo.site.model.ManageResourceModel;
import com.bofowo.site.query.ManageResourceQuery;
import com.bofowo.site.service.ManageResourceService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("manageResourceService")
public class ManageResourceServiceImpl implements ManageResourceService{
	@Autowired
	private ManageResourceMapper manageresourceMapper;
	
	public List<ManageResourceModel> fetchPage(ManageResourceQuery query){
		return manageresourceMapper.fetchPageList(query);
	}
	public int fetchPageCount(ManageResourceQuery query){
		return manageresourceMapper.fetchPageCount(query);
	}
	public ManageResourceModel getById(long id){
		return manageresourceMapper.getById(id);
	}
	public void del(long id){
		manageresourceMapper.del(id);
	}
	public long insert(ManageResourceModel manageresource){
		return manageresourceMapper.insert(manageresource);
	}
	public long update(ManageResourceModel manageresource){
		return manageresourceMapper.update(manageresource);
	}
} 
