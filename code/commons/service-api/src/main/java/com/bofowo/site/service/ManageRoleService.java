package com.bofowo.site.service;

import com.bofowo.site.model.ManageRoleModel;
import com.bofowo.site.query.ManageRoleQuery;

import java.util.List;


public interface ManageRoleService{
	public List<ManageRoleModel> fetchPage(ManageRoleQuery query);
	public int fetchPageCount(ManageRoleQuery query);
	public ManageRoleModel getById(long id);
	public void del(long id);
	public long insert(ManageRoleModel managerole);
	public long update(ManageRoleModel managerole);
} 
