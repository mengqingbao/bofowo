package com.bofowo.site.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.bofowo.site.model.ManageRoleResourceModel;
import com.bofowo.site.query.ManageRoleResourceQuery;

import java.util.List;

public interface ManageRoleResourceMapper{
																										
	public String columns="ROLE_ID,RESOURCE_ID";
																										
	public String property="#{roleId},#{resourceId}";
																									
	public String update="ROLE_ID=#{roleId},RESOURCE_ID=#{resourceId}";
	
	@Select("select "+columns+" FROM t_manage_role_resource limit #{startRow},#{endRow}")
	@ResultMap(value="com.bofowo.site.mapper.ManageRoleResourceMapper.ManageRoleResourceModelMap")
	public List<ManageRoleResourceModel> fetchPageList(ManageRoleResourceQuery query);
	
	@Select("select count(*) from t_manage_role_resource")
	public int fetchPageCount(ManageRoleResourceQuery query);
	
	@Select("select * from t_manage_role_resource where =#{id}")
	@ResultMap(value="com.bofowo.site.mapper.ManageRoleResourceMapper.ManageRoleResourceModelMap")
	public ManageRoleResourceModel getById(long id);
	
	@Delete("delete from t_manage_role_resource where =#{id}")
	public void del(long id);
	
	@Insert("insert into t_manage_role_resource ("+columns+") values ("+property+")")
	public long insert(ManageRoleResourceModel manageroleresource);

	@Update("update t_manage_role_resource set "+update+" where =#{id}")
	public long update(ManageRoleResourceModel manageroleresourceModel); 
}