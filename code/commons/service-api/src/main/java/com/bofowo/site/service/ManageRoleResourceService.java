package com.bofowo.site.service;

import com.bofowo.site.model.ManageRoleResourceModel;
import com.bofowo.site.query.ManageRoleResourceQuery;

import java.util.List;


public interface ManageRoleResourceService{
	public List<ManageRoleResourceModel> fetchPage(ManageRoleResourceQuery query);
	public int fetchPageCount(ManageRoleResourceQuery query);
	public ManageRoleResourceModel getById(long id);
	public void del(long id);
	public long insert(ManageRoleResourceModel manageroleresource);
	public long update(ManageRoleResourceModel manageroleresource);
} 
