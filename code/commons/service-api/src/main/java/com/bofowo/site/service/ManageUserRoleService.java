package com.bofowo.site.service;

import com.bofowo.site.model.ManageUserRoleModel;
import com.bofowo.site.query.ManageUserRoleQuery;

import java.util.List;


public interface ManageUserRoleService{
	public List<ManageUserRoleModel> fetchPage(ManageUserRoleQuery query);
	public int fetchPageCount(ManageUserRoleQuery query);
	public ManageUserRoleModel getById(long id);
	public void del(long id);
	public long insert(ManageUserRoleModel manageuserrole);
	public long update(ManageUserRoleModel manageuserrole);
} 
