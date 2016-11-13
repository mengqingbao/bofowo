package com.bofowo.site.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.bofowo.site.model.TaglibRefModel;
import com.bofowo.site.query.TaglibRefQuery;

import java.util.List;

public interface TaglibRefMapper{
																																				
	public String columns="ID,TAG_ID,TYPE_";
																																				
	public String property="#{id},#{tagId},#{type}";
																																				
	public String update="ID=#{id},TAG_ID=#{tagId},TYPE_=#{type}";
	
	@Select("select "+columns+" FROM t_taglib_ref limit #{startRow},#{endRow}")
	@ResultMap(value="com.bofowo.site.mapper.TaglibRefMapper.TaglibRefModelMap")
	public List<TaglibRefModel> fetchPageList(TaglibRefQuery query);
	
	@Select("select count(*) from t_taglib_ref")
	public int fetchPageCount(TaglibRefQuery query);
	
	@Select("select * from t_taglib_ref where =#{id}")
	public TaglibRefModel getById(long id);
	
	@Delete("delete from t_taglib_ref where =#{id}")
	public void del(long id);
	
	@Insert("insert into t_taglib_ref ("+columns+") values ("+property+")")
	public long insert(TaglibRefModel taglibref);

	@Update("update t_taglib_ref set "+update+" where =#{id}")
	public long update(TaglibRefModel taglibrefModel); 
}