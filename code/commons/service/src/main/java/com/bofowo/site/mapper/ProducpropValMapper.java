package com.bofowo.site.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.bofowo.site.model.ProducpropValModel;
import com.bofowo.site.query.ProducpropValQuery;
import com.bofowo.site.provider.ProducpropValProvider;

import org.apache.ibatis.mapping.StatementType;

import java.util.List;

public interface ProducpropValMapper{
																																																																		
	public String columns="ID,PRODUCT_ID,PROP_NAME,PROP_VAL,PROP_ID,PROP_KEY";
																																																																		
	public String property="#{id},#{productId},#{propName},#{propVal},#{propId},#{propKey}";
																																																													
	public String update="PRODUCT_ID=#{productId},PROP_NAME=#{propName},PROP_VAL=#{propVal},PROP_ID=#{propId},PROP_KEY=#{propKey}";
	
	@SelectProvider(type=ProducpropValProvider.class,method="getSearchSql")
	@ResultMap(value="com.bofowo.site.mapper.ProducpropValMapper.ProducpropValModelMap")
	public List<ProducpropValModel> fetchPageList(ProducpropValQuery query);

	@SelectProvider(type=ProducpropValProvider.class,method="getSearchSqlCount")
	public int fetchPageCount(ProducpropValQuery query);
	
	@Select("select * from T_PRODUCT_PROP_VAL where ID=#{id}")
	@ResultMap(value="com.bofowo.site.mapper.ProducpropValMapper.ProducpropValModelMap")
	public ProducpropValModel getById(long id);
	
	@Delete("delete from T_PRODUCT_PROP_VAL where ID=#{id}")
	public void del(long id);
	
	//@SelectKey(before=true,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="select nextval('globalVal') as ID")
	@Insert("insert into T_PRODUCT_PROP_VAL ("+columns+") values ("+property+")")
	public long insert(ProducpropValModel producpropval);

	@Update("update T_PRODUCT_PROP_VAL set "+update+" where ID=#{id}")
	public long update(ProducpropValModel producpropvalModel);

	@Select("select * from T_PRODUCT_PROP_VAL where PRODUCT_ID=#{itemId}")
	@ResultMap(value="com.bofowo.site.mapper.ProducpropValMapper.ProducpropValModelMap")
	public List<ProducpropValModel> getListByItemId(Integer itemId);

	@Delete("delete from T_PRODUCT_PROP_VAL where PRODUCT_ID=#{id}")
	public void delByItemId(int id); 
}