package com.bofowo.site.mapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.bofowo.site.model.CategoryModel;
import com.bofowo.site.provider.CategoryProvider;
import com.bofowo.site.query.CategoryQuery;

public interface CategoryMapper{
																																																																																																
	public String columns="ID,PID,NAME,STATUS,CREATED_DATE,CREATOR,IS_DELETE,TYPE_,DESC_";
																																																																																																
	public String property="#{id},#{pid},#{name},#{status},#{createdDate},#{creator},#{isDelete},#{type},#{desc}";
																																																																																														
	public String update="PID=#{pid},NAME=#{name},STATUS=#{status},CREATED_DATE=#{createdDate},CREATOR=#{creator},IS_DELETE=#{isDelete},TYPE_=#{type},DESC_=#{desc}";
	
	@SelectProvider(type=CategoryProvider.class,method="getSearchSql")
	@ResultMap(value="com.bofowo.site.mapper.CategoryMapper.CategoryModelMap")
	public List<CategoryModel> fetchPageList(CategoryQuery query);
	
	@SelectProvider(type=CategoryProvider.class,method="getSearchSqlCount")
	public int fetchPageCount(CategoryQuery query);
	
	@Select("select * from T_CATEGORY where ID=#{id}")
	@ResultMap(value="com.bofowo.site.mapper.CategoryMapper.CategoryModelMap")
	public CategoryModel getById(long id);
	
	@Delete("delete from T_CATEGORY where ID=#{id}")
	public void del(long id);
	
	@Insert("insert into T_CATEGORY ("+columns+") values ("+property+")")
	public long insert(CategoryModel category);

	@Update("update T_CATEGORY set "+update+" where ID=#{id}")
	public long update(CategoryModel categoryModel);

	@Select("select * from T_CATEGORY where PID=#{pid} and TYPE_=#{type}")
	@ResultMap(value="com.bofowo.site.mapper.CategoryMapper.CategoryModelMap")
	public List<CategoryModel> getAllByParendid(Map condition); 
}