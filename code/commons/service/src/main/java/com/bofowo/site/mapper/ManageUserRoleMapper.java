package com.bofowo.site.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.bofowo.site.model.ManageUserRoleModel;
import com.bofowo.site.query.ManageUserRoleQuery;

import java.util.List;

public interface ManageUserRoleMapper{
																										
	public String columns="USER_NAME,ROLE_ID";
																										
	public String property="#{userName},#{roleId}";
																									
	public String update="USER_NAME=#{userName},ROLE_ID=#{roleId}";
	
	@Select("select "+columns+" FROM t_manage_user_role limit #{startRow},#{endRow}")
	@ResultMap(value="com.bofowo.site.mapper.ManageUserRoleMapper.ManageUserRoleModelMap")
	public List<ManageUserRoleModel> fetchPageList(ManageUserRoleQuery query);
	
	@Select("select count(*) from t_manage_user_role")
	public int fetchPageCount(ManageUserRoleQuery query);
	
	@Select("select * from t_manage_user_role where =#{id}")
	@ResultMap(value="com.bofowo.site.mapper.ManageUserRoleMapper.ManageUserRoleModelMap")
	public ManageUserRoleModel getById(long id);
	
	@Delete("delete from t_manage_user_role where =#{id}")
	public void del(long id);
	
	@Insert("insert into t_manage_user_role ("+columns+") values ("+property+")")
	public long insert(ManageUserRoleModel manageuserrole);

	@Update("update t_manage_user_role set "+update+" where =#{id}")
	public long update(ManageUserRoleModel manageuserroleModel); 
}