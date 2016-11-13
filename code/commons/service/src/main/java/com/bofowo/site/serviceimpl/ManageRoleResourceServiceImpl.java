package com.bofowo.site.serviceimpl;

import com.bofowo.site.mapper.ManageRoleResourceMapper;
import com.bofowo.site.model.ManageRoleResourceModel;
import com.bofowo.site.query.ManageRoleResourceQuery;
import com.bofowo.site.service.ManageRoleResourceService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("manageRoleResourceService")
public class ManageRoleResourceServiceImpl implements ManageRoleResourceService{
	@Autowired
	private ManageRoleResourceMapper manageroleresourceMapper;
	
	public List<ManageRoleResourceModel> fetchPage(ManageRoleResourceQuery query){
		return manageroleresourceMapper.fetchPageList(query);
	}
	public int fetchPageCount(ManageRoleResourceQuery query){
		return manageroleresourceMapper.fetchPageCount(query);
	}
	public ManageRoleResourceModel getById(long id){
		return manageroleresourceMapper.getById(id);
	}
	public void del(long id){
		manageroleresourceMapper.del(id);
	}
	public long insert(ManageRoleResourceModel manageroleresource){
		return manageroleresourceMapper.insert(manageroleresource);
	}
	public long update(ManageRoleResourceModel manageroleresource){
		return manageroleresourceMapper.update(manageroleresource);
	}
} 
