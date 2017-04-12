package com.bofowo.site.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.bofowo.site.model.CarModel;
import com.bofowo.site.provider.CarProvider;
import com.bofowo.site.query.CarQuery;

import org.apache.ibatis.mapping.StatementType;

import java.util.List;
import java.util.Map;

public interface CarMapper{
																																																																																																																																																												
	public String columns="ID,ITEM_ID,TITLE,PIC,NUM,PRICE,TOTAL,STATUS,PROPERTIES,SPEC,NOTE,SELLER_ID,BUYER_ID,CREATED_TIME,MODIFY_TIME";
																																																																																																																																																												
	public String property="#{id},#{itemId},#{title},#{pic},#{num},#{price},#{total},#{status},#{properties},#{spec},#{note},#{sellerId},#{buyerId},#{createdTime},#{modifyTime}";
																																																																																																																																																																
	public String update="ITEM_ID=#{itemId},TITLE=#{title},PIC=#{pic},NUM=#{num},PRICE=#{price},TOTAL=#{total},STATUS=#{status},PROPERTIES=#{properties},SPEC=#{spec},NOTE=#{note},SELLER_ID=#{sellerId},BUYER_ID=#{buyerId},CREATED_TIME=#{createdTime},MODIFY_TIME=#{modifyTime}";
	
	@SelectProvider(type=CarProvider.class,method="getSearchSql")
	@ResultMap(value="com.bofowo.site.mapper.CarMapper.CarModelMap")
	public List<CarModel> fetchPageList(CarQuery query);

	@SelectProvider(type=CarProvider.class,method="getSearchSqlCount")
	public int fetchPageCount(CarQuery query);
	
	@Select("select * from T_CAR where ID=#{id}")
	@ResultMap(value="com.bofowo.site.mapper.CarMapper.CarModelMap")
	public CarModel getById(long id);
	
	@Delete("delete from T_CAR where ID=#{id}")
	public void del(long id);
	
	@SelectKey(before=true,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="select nextval('globalVal') as ID")
	@Insert("insert into T_CAR ("+columns+") values ("+property+")")
	public long insert(CarModel car);

	@Update("update T_CAR set "+update+" where ID=#{id}")
	public long update(CarModel carModel);

	@Select("select * from T_CAR where BUYER_ID=#{username} and ID in (${ids})")
	@ResultMap(value="com.bofowo.site.mapper.CarMapper.CarModelMap")
	public List<CarModel> getItemsByIds(Map<String, String> condition);

	@Select("select * from T_CAR where BUYER_ID=#{username} and ITEM_ID=#{id}")
	@ResultMap(value="com.bofowo.site.mapper.CarMapper.CarModelMap")
	public CarModel getByItemId(Map<String, String> condition);

	@Delete("delete from T_CAR where ITEM_ID=#{id} and BUYER_ID=#{username}")
	public void deleteByIdAndUsername(Map<String, String> condition); 
}