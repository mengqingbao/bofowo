package com.bofowo.site.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.bofowo.site.model.ProducstockModel;
import com.bofowo.site.provider.ProducstockProvider;
import com.bofowo.site.query.ProducstockQuery;

import org.apache.ibatis.mapping.StatementType;

import java.util.List;

public interface ProducstockMapper{
																																																																																																																																																		
	public String columns="ID,SHOP_ID,SELLER_ID,ITEM_ID,PROP_ID,PROP_NAME,PROP_VALUE,STOCK_NUM,LEFT_NUM,IMAGE,PRICE,SPEC_ID,SPEC_NAME,SPEC_VALUE";
																																																																																																																																																		
	public String property="#{id},#{shopId},#{sellerId},#{itemId},#{propId},#{propName},#{propValue},#{stockNum},#{leftNum},#{image},#{price},#{specId},#{specName},#{specValue}";
																																																																																																																																																					
	public String update="SHOP_ID=#{shopId},SELLER_ID=#{sellerId},ITEM_ID=#{itemId},PROP_ID=#{propId},PROP_NAME=#{propName},PROP_VALUE=#{propValue},STOCK_NUM=#{stockNum},LEFT_NUM=#{leftNum},IMAGE=#{image},PRICE=#{price},SPEC_ID=#{specId},SPEC_NAME=#{specName},SPEC_VALUE=#{specValue}";
	
	@SelectProvider(type=ProducstockProvider.class,method="getSearchSql")
	@ResultMap(value="com.bofowo.site.mapper.ProducstockMapper.ProducstockModelMap")
	public List<ProducstockModel> fetchPageList(ProducstockQuery query);

	@SelectProvider(type=ProducstockProvider.class,method="getSearchSqlCount")
	public int fetchPageCount(ProducstockQuery query);
	
	@Select("select * from T_PRODUCT_STOCK where ID=#{id}")
	@ResultMap(value="com.bofowo.site.mapper.ProducstockMapper.ProducstockModelMap")
	public ProducstockModel getById(long id);
	
	@Delete("delete from T_PRODUCT_STOCK where ID=#{id}")
	public void del(long id);
	
	@SelectKey(before=true,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="select nextval('globalVal') as ID")
	@Insert("insert into T_PRODUCT_STOCK ("+columns+") values ("+property+")")
	public long insert(ProducstockModel producstock);

	@Update("update T_PRODUCT_STOCK set "+update+" where ID=#{id}")
	public long update(ProducstockModel producstockModel); 
}