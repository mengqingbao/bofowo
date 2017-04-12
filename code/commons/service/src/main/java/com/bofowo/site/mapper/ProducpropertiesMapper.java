package com.bofowo.site.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

import com.bofowo.site.model.ProducpropertiesModel;
import com.bofowo.site.provider.CategoryProvider;
import com.bofowo.site.provider.ProductpropertiesProvider;
import com.bofowo.site.query.ProducpropertiesQuery;

import java.util.List;

public interface ProducpropertiesMapper{
																																																																																																										
	public String columns="ID,NAME,INPUT_TYPE,CATEGORY_ID,PROPERTIES_TYPE,TYPE,DESC_,VAL_,CREATOR,CREATED_DATE";
																																																																																																										
	public String property="#{id},#{name},#{inputType},#{categoryId},#{propertiesType},#{type},#{desc},#{val},#{creator},#{createdDate}";
																																																																																																									
	public String update="NAME=#{name},INPUT_TYPE=#{inputType},CATEGORY_ID=#{categoryId},PROPERTIES_TYPE=#{propertiesType},TYPE=#{type},DESC_=#{desc},VAL_=#{val},CREATOR=#{creator},CREATED_DATE=#{createdDate}";
	
	@SelectProvider(type=ProductpropertiesProvider.class,method="getSearchSql")
	@ResultMap(value="com.bofowo.site.mapper.ProducpropertiesMapper.ProducpropertiesModelMap")
	public List<ProducpropertiesModel> fetchPageList(ProducpropertiesQuery query);
	
	@SelectProvider(type=ProductpropertiesProvider.class,method="getSearchSqlCount")
	public int fetchPageCount(ProducpropertiesQuery query);
	
	@Select("select * from T_PRODUCT_PROPERTIES where ID=#{id}")
	@ResultMap(value="com.bofowo.site.mapper.ProducpropertiesMapper.ProducpropertiesModelMap")
	public ProducpropertiesModel getById(long id);
	
	@Delete("delete from T_PRODUCT_PROPERTIES where ID=#{id}")
	public void del(long id);
	
	//@SelectKey(before=true,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="select nextval('propertiesVal') as ID")
	@Insert("insert into T_PRODUCT_PROPERTIES ("+columns+") values ("+property+")")
	public long insert(ProducpropertiesModel producproperties);

	@Update("update T_PRODUCT_PROPERTIES set "+update+" where ID=#{id}")
	public long update(ProducpropertiesModel producpropertiesModel); 
}