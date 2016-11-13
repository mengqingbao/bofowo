package com.bofowo.site.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.bofowo.site.model.ManageRoleResouceModel;
import com.bofowo.site.query.ManageRoleResouceQuery;

import java.util.List;

public interface ManageRoleResouceMapper{
																										
	public String columns="ROLE_ID,RESOURCE_ID";
																										
	public String property="#{roleId},#{resourceId}";
																									
	public String update="ROLE_ID=#{roleId},RESOURCE_ID=#{resourceId}";
	
	@Select("select "+columns+" FROM t_manage_role_resouce limit #{startRow},#{endRow}")
	@ResultMap(value="com.bofowo.site.mapper.ManageRoleResouceMapper.ManageRoleResouceModelMap")
	public List<ManageRoleResouceModel> fetchPageList(ManageRoleResouceQuery query);
	
	@Select("select count(*) from t_manage_role_resouce")
	public int fetchPageCount(ManageRoleResouceQuery query);
	
	@Select("select * from t_manage_role_resouce where =#{id}")
	public ManageRoleResouceModel getById(long id);
	
	@Delete("delete from t_manage_role_resouce where =#{id}")
	public void del(long id);
	
	@Insert("insert into t_manage_role_resouce ("+columns+") values ("+property+")")
	public long insert(ManageRoleResouceModel manageroleresouce);

	@Update("update t_manage_role_resouce set "+update+" where =#{id}")
	public long update(ManageRoleResouceModel manageroleresouceModel); 
}