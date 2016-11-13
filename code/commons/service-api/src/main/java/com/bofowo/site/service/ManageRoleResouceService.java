package com.bofowo.site.service;

import com.bofowo.site.model.ManageRoleResouceModel;
import com.bofowo.site.query.ManageRoleResouceQuery;

import java.util.List;


public interface ManageRoleResouceService{
	public List<ManageRoleResouceModel> fetchPage(ManageRoleResouceQuery query);
	public int fetchPageCount(ManageRoleResouceQuery query);
	public ManageRoleResouceModel getById(long id);
	public void del(long id);
	public long insert(ManageRoleResouceModel manageroleresouce);
	public long update(ManageRoleResouceModel manageroleresouce);
} 
