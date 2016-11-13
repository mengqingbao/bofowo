package com.bofowo.site.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.bofowo.site.model.PostemplateModel;
import com.bofowo.site.provider.PostemplateProvider;
import com.bofowo.site.query.PostemplateQuery;

import org.apache.ibatis.mapping.StatementType;

import java.util.List;

public interface PostemplateMapper{
																																																																																																
	public String columns="ID,SELLER_ID,TITTLE,FEE,FIRST_FEE,EX_WEIGHT,EX_WEIGHT_FEE,FREE_AREA,STATUS";
																																																																																																
	public String property="#{id},#{sellerId},#{tittle},#{fee},#{firstFee},#{exWeight},#{exWeightFee},#{freeArea},#{status}";
																																																																																														
	public String update="SELLER_ID=#{sellerId},TITTLE=#{tittle},FEE=#{fee},FIRST_FEE=#{firstFee},EX_WEIGHT=#{exWeight},EX_WEIGHT_FEE=#{exWeightFee},FREE_AREA=#{freeArea},STATUS=#{status}";
	
	@SelectProvider(type=PostemplateProvider.class,method="getSearchSql")
	@ResultMap(value="com.bofowo.site.mapper.PostemplateMapper.PostemplateModelMap")
	public List<PostemplateModel> fetchPageList(PostemplateQuery query);

	@SelectProvider(type=PostemplateProvider.class,method="getSearchSqlCount")
	public int fetchPageCount(PostemplateQuery query);
	
	@Select("select * from T_POST_TEMPLATE where ID=#{id}")
	@ResultMap(value="com.bofowo.site.mapper.PostemplateMapper.PostemplateModelMap")
	public PostemplateModel getById(long id);
	
	@Delete("delete from T_POST_TEMPLATE where ID=#{id}")
	public void del(long id);
	
	@SelectKey(before=true,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="select nextval('globalVal') as ID")
	@Insert("insert into T_POST_TEMPLATE ("+columns+") values ("+property+")")
	public long insert(PostemplateModel postemplate);

	@Update("update T_POST_TEMPLATE set "+update+" where ID=#{id}")
	public long update(PostemplateModel postemplateModel); 
}