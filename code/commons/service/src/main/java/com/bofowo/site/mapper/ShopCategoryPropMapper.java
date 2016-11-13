package com.bofowo.site.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.bofowo.site.model.ShopCategoryPropModel;
import com.bofowo.site.provider.ShopCategoryPropProvider;
import com.bofowo.site.query.ShopCategoryPropQuery;

import org.apache.ibatis.mapping.StatementType;

import java.util.List;

public interface ShopCategoryPropMapper{
																																																																																																
	public String columns="ID,CATEGORY_ID,NAME,SELLER_ID,SHOP_ID,TYPE,INPUT_TYPE,INPUT_OPTION,STATUS";
																																																																																																
	public String property="#{id},#{categoryId},#{name},#{sellerId},#{shopId},#{type},#{inputType},#{inputOption},#{status}";
																																																																																														
	public String update="CATEGORY_ID=#{categoryId},NAME=#{name},SELLER_ID=#{sellerId},SHOP_ID=#{shopId},TYPE=#{type},INPUT_TYPE=#{inputType},INPUT_OPTION=#{inputOption},STATUS=#{status}";
	
	@SelectProvider(type=ShopCategoryPropProvider.class,method="getSearchSql")
	@ResultMap(value="com.bofowo.site.mapper.ShopCategoryPropMapper.ShopCategoryPropModelMap")
	public List<ShopCategoryPropModel> fetchPageList(ShopCategoryPropQuery query);

	@SelectProvider(type=ShopCategoryPropProvider.class,method="getSearchSqlCount")
	public int fetchPageCount(ShopCategoryPropQuery query);
	
	@Select("select * from T_SHOP_CATEGORY_PROP where ID=#{id}")
	@ResultMap(value="com.bofowo.site.mapper.ShopCategoryPropMapper.ShopCategoryPropModelMap")
	public ShopCategoryPropModel getById(long id);
	
	@Delete("delete from T_SHOP_CATEGORY_PROP where ID=#{id}")
	public void del(long id);
	
	@SelectKey(before=true,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="select nextval('globalVal') as ID")
	@Insert("insert into T_SHOP_CATEGORY_PROP ("+columns+") values ("+property+")")
	public long insert(ShopCategoryPropModel shopcategoryprop);

	@Update("update T_SHOP_CATEGORY_PROP set "+update+" where ID=#{id}")
	public long update(ShopCategoryPropModel shopcategorypropModel); 
}