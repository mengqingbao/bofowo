package com.bofowo.site.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.bofowo.site.model.TaglibModel;
import com.bofowo.site.provider.TaglibProvider;
import com.bofowo.site.query.TaglibQuery;

import org.apache.ibatis.mapping.StatementType;

import java.util.List;

public interface TaglibMapper{
																																																																																																										
	public String columns="ID,NAME,TYPE,STATUS,IS_DELETE,CREATED_DATE,MODIFIED_DATE,DESC_,SELLER_ID,SHOP_ID";
																																																																																																										
	public String property="#{id},#{name},#{type},#{status},#{isDelete},#{createdDate},#{modifiedDate},#{desc},#{sellerId},#{shopId}";
																																																																																																									
	public String update="NAME=#{name},TYPE=#{type},STATUS=#{status},IS_DELETE=#{isDelete},CREATED_DATE=#{createdDate},MODIFIED_DATE=#{modifiedDate},DESC_=#{desc},SELLER_ID=#{sellerId},SHOP_ID=#{shopId}";
	
	@SelectProvider(type=TaglibProvider.class,method="getSearchSql")
	@ResultMap(value="com.bofowo.site.mapper.TaglibMapper.TaglibModelMap")
	public List<TaglibModel> fetchPageList(TaglibQuery query);

	@SelectProvider(type=TaglibProvider.class,method="getSearchSqlCount")
	public int fetchPageCount(TaglibQuery query);
	
	@Select("select * from T_TAGLIB where ID=#{id}")
	@ResultMap(value="com.bofowo.site.mapper.TaglibMapper.TaglibModelMap")
	public TaglibModel getById(long id);
	
	@Delete("delete from T_TAGLIB where ID=#{id}")
	public void del(long id);
	
	@SelectKey(before=true,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="select nextval('globalVal') as ID")
	@Insert("insert into T_TAGLIB ("+columns+") values ("+property+")")
	public long insert(TaglibModel taglib);

	@Update("update T_TAGLIB set "+update+" where ID=#{id}")
	public long update(TaglibModel taglibModel); 
}