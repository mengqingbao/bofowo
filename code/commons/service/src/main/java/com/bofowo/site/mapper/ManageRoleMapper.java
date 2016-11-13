package com.bofowo.site.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.bofowo.site.model.ManageRoleModel;
import com.bofowo.site.query.ManageRoleQuery;

import java.util.List;

public interface ManageRoleMapper{
																																																																		
	public String columns="ID,NAME,STATUS,DESC_,CREATE_DATE,CREATOR";
																																																																		
	public String property="#{id},#{name},#{status},#{desc},#{createDate},#{creator}";
																																																													
	public String update="NAME=#{name},STATUS=#{status},DESC_=#{desc},CREATE_DATE=#{createDate},CREATOR=#{creator}";
	
	@Select("select "+columns+" FROM t_manage_role limit #{startRow},#{endRow}")
	@ResultMap(value="com.bofowo.site.mapper.ManageRoleMapper.ManageRoleModelMap")
	public List<ManageRoleModel> fetchPageList(ManageRoleQuery query);
	
	@Select("select count(*) from t_manage_role")
	public int fetchPageCount(ManageRoleQuery query);
	
	@Select("select * from t_manage_role where ID=#{id}")
	public ManageRoleModel getById(long id);
	
	@Delete("delete from t_manage_role where ID=#{id}")
	public void del(long id);
	
	@Insert("insert into t_manage_role ("+columns+") values ("+property+")")
	public long insert(ManageRoleModel managerole);

	@Update("update t_manage_role set "+update+" where ID=#{id}")
	public long update(ManageRoleModel manageroleModel);

	@Select("select a.* FROM t_manage_role a left join t_manage_role_resource b  on a.ID=b.ROLE_ID where b.RESOURCE_ID=#{id}")
	@ResultMap(value="com.bofowo.site.mapper.ManageRoleMapper.ManageRoleModelMap")
	public List<ManageRoleModel> loadRoleByResId(int id);

	@Select("select * FROM t_manage_role")
	@ResultMap(value="com.bofowo.site.mapper.ManageRoleMapper.ManageRoleModelMap")
	public List<ManageRoleModel> getRoles();
	
	@Select("select a.* FROM t_manage_role a left join t_manage_user_role b  on a.ID=b.ROLE_ID where b.USER_NAME=#{username}")
	@ResultMap(value="com.bofowo.site.mapper.ManageRoleMapper.ManageRoleModelMap")
	public List<ManageRoleModel> loadGrantedUserById(String username); 
}