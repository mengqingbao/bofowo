package com.bofowo.site.service;

import com.bofowo.site.model.ManageResourceModel;
import com.bofowo.site.query.ManageResourceQuery;

import java.util.List;


public interface ManageResourceService{
	public List<ManageResourceModel> fetchPage(ManageResourceQuery query);
	public int fetchPageCount(ManageResourceQuery query);
	public ManageResourceModel getById(long id);
	public void del(long id);
	public long insert(ManageResourceModel manageresource);
	public long update(ManageResourceModel manageresource);
} 
