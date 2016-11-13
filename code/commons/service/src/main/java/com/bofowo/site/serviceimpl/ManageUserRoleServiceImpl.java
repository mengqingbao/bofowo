package com.bofowo.site.serviceimpl;

import com.bofowo.site.mapper.ManageUserRoleMapper;
import com.bofowo.site.model.ManageUserRoleModel;
import com.bofowo.site.query.ManageUserRoleQuery;
import com.bofowo.site.service.ManageUserRoleService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("manageUserRoleService")
public class ManageUserRoleServiceImpl implements ManageUserRoleService{
	@Autowired
	private ManageUserRoleMapper manageuserroleMapper;
	
	public List<ManageUserRoleModel> fetchPage(ManageUserRoleQuery query){
		return manageuserroleMapper.fetchPageList(query);
	}
	public int fetchPageCount(ManageUserRoleQuery query){
		return manageuserroleMapper.fetchPageCount(query);
	}
	public ManageUserRoleModel getById(long id){
		return manageuserroleMapper.getById(id);
	}
	public void del(long id){
		manageuserroleMapper.del(id);
	}
	public long insert(ManageUserRoleModel manageuserrole){
		return manageuserroleMapper.insert(manageuserrole);
	}
	public long update(ManageUserRoleModel manageuserrole){
		return manageuserroleMapper.update(manageuserrole);
	}
} 
