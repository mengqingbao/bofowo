package com.bofowo.site.serviceimpl;

import com.bofowo.site.mapper.ManageRoleResouceMapper;
import com.bofowo.site.model.ManageRoleResouceModel;
import com.bofowo.site.query.ManageRoleResouceQuery;
import com.bofowo.site.service.ManageRoleResouceService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("manageRoleResouceService")
public class ManageRoleResouceServiceImpl implements ManageRoleResouceService{
	@Autowired
	private ManageRoleResouceMapper manageroleresouceMapper;
	
	public List<ManageRoleResouceModel> fetchPage(ManageRoleResouceQuery query){
		return manageroleresouceMapper.fetchPageList(query);
	}
	public int fetchPageCount(ManageRoleResouceQuery query){
		return manageroleresouceMapper.fetchPageCount(query);
	}
	public ManageRoleResouceModel getById(long id){
		return manageroleresouceMapper.getById(id);
	}
	public void del(long id){
		manageroleresouceMapper.del(id);
	}
	public long insert(ManageRoleResouceModel manageroleresouce){
		return manageroleresouceMapper.insert(manageroleresouce);
	}
	public long update(ManageRoleResouceModel manageroleresouce){
		return manageroleresouceMapper.update(manageroleresouce);
	}
} 
