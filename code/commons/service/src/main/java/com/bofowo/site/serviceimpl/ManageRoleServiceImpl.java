package com.bofowo.site.serviceimpl;

import com.bofowo.site.mapper.ManageRoleMapper;
import com.bofowo.site.model.ManageRoleModel;
import com.bofowo.site.query.ManageRoleQuery;
import com.bofowo.site.service.ManageRoleService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("manageRoleService")
public class ManageRoleServiceImpl implements ManageRoleService{
	@Autowired
	private ManageRoleMapper manageroleMapper;
	
	public List<ManageRoleModel> fetchPage(ManageRoleQuery query){
		return manageroleMapper.fetchPageList(query);
	}
	public int fetchPageCount(ManageRoleQuery query){
		return manageroleMapper.fetchPageCount(query);
	}
	public ManageRoleModel getById(long id){
		return manageroleMapper.getById(id);
	}
	public void del(long id){
		manageroleMapper.del(id);
	}
	public long insert(ManageRoleModel managerole){
		return manageroleMapper.insert(managerole);
	}
	public long update(ManageRoleModel managerole){
		return manageroleMapper.update(managerole);
	}
} 
