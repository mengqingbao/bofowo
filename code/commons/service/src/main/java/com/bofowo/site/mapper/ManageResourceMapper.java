package com.bofowo.site.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.bofowo.site.model.ManageResourceModel;
import com.bofowo.site.query.ManageResourceQuery;

import java.util.List;
import java.util.Map;

public interface ManageResourceMapper{
																																																																												
	public String columns="ID,NAME,CONTENT,TYPE_,STATUS,CREATE_DATE,CREATOR,PARENT_ID";
																																																																												
	public String property="#{id},#{name},#{content},#{type},#{status},#{createDate},#{creator}";
																																																																								
	public String update="NAME=#{name},CONTENT=#{content},TYPE_=#{type},STATUS=#{status},CREATE_DATE=#{createDate},CREATOR=#{creator}";
	
	@Select("select "+columns+" FROM t_manage_resource limit #{startRow},#{endRow}")
	@ResultMap(value="com.bofowo.site.mapper.ManageResourceMapper.ManageResourceModelMap")
	public List<ManageResourceModel> fetchPageList(ManageResourceQuery query);
	
	@Select("select count(*) from t_manage_resource")
	public int fetchPageCount(ManageResourceQuery query);
	
	@Select("select * from t_manage_resource where ID=#{id}")
	public ManageResourceModel getById(long id);
	
	@Delete("delete from t_manage_resource where ID=#{id}")
	public void del(long id);
	
	@Insert("insert into t_manage_resource ("+columns+") values ("+property+")")
	public long insert(ManageResourceModel manageresource);

	@Update("update t_manage_resource set "+update+" where ID=#{id}")
	public long update(ManageResourceModel manageresourceModel);

	@Select("select "+columns+" FROM t_manage_resource where TYPE_=#{type}")
	@ResultMap(value="com.bofowo.site.mapper.ManageResourceMapper.ManageResourceModelMap")
	public List<ManageResourceModel> loadByType(String type);

	@Select("select "+columns+" FROM t_manage_resource a left join t_manage_role_resource b on a.id=b.resource_id left join t_manage_user_role c on b.role_id=c.role_id where c.user_name=#{currentUserName} and a.TYPE_=#{type}")
	@ResultMap(value="com.bofowo.site.mapper.ManageResourceMapper.ManageResourceModelMap")
	public List<ManageResourceModel> getByMenus(Map condition); 
}