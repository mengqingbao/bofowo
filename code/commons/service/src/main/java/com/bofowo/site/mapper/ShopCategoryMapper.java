package com.bofowo.site.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.bofowo.site.model.ShopCategoryModel;
import com.bofowo.site.provider.ShopCategoryProvider;
import com.bofowo.site.query.ShopCategoryQuery;

import org.apache.ibatis.mapping.StatementType;

import java.util.List;

public interface ShopCategoryMapper{
																																																																																																																																																												
	public String columns="ID,NAME,IMAGE,DESC_,CREATOR,CREATED_TIME,CHECKER,CHECKED_TIME,MODIFIER,MODIFIED_TIME,STATUS,TYPE,CONTENT,SELLER_ID,SHOP_ID";
																																																																																																																																																												
	public String property="#{id},#{name},#{image},#{desc},#{creator},#{createdTime},#{checker},#{checkedTime},#{modifier},#{modifiedTime},#{status},#{type},#{content},#{sellerId},#{shopId}";
																																																																																																																																																																
	public String update="NAME=#{name},IMAGE=#{image},DESC_=#{desc},CREATOR=#{creator},CREATED_TIME=#{createdTime},CHECKER=#{checker},CHECKED_TIME=#{checkedTime},MODIFIER=#{modifier},MODIFIED_TIME=#{modifiedTime},STATUS=#{status},TYPE=#{type},CONTENT=#{content},SELLER_ID=#{sellerId},SHOP_ID=#{shopId}";
	
	@SelectProvider(type=ShopCategoryProvider.class,method="getSearchSql")
	@ResultMap(value="com.bofowo.site.mapper.ShopCategoryMapper.ShopCategoryModelMap")
	public List<ShopCategoryModel> fetchPageList(ShopCategoryQuery query);

	@SelectProvider(type=ShopCategoryProvider.class,method="getSearchSqlCount")
	public int fetchPageCount(ShopCategoryQuery query);
	
	@Select("select * from T_SHOP_CATEGORY where ID=#{id}")
	@ResultMap(value="com.bofowo.site.mapper.ShopCategoryMapper.ShopCategoryModelMap")
	public ShopCategoryModel getById(long id);
	
	@Delete("delete from T_SHOP_CATEGORY where ID=#{id}")
	public void del(long id);
	
	@SelectKey(before=true,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="select nextval('globalVal') as ID")
	@Insert("insert into T_SHOP_CATEGORY ("+columns+") values ("+property+")")
	public long insert(ShopCategoryModel shopcategory);

	@Update("update T_SHOP_CATEGORY set "+update+" where ID=#{id}")
	public long update(ShopCategoryModel shopcategoryModel);

	@Select("select * from T_SHOP_CATEGORY where SHOP_ID=#{id}")
	@ResultMap(value="com.bofowo.site.mapper.ShopCategoryMapper.ShopCategoryModelMap")
	public List<ShopCategoryModel> getListByShopId(int id);

	@Select("select * from T_SHOP_CATEGORY where SELLER_ID=#{sellerId}")
	@ResultMap(value="com.bofowo.site.mapper.ShopCategoryMapper.ShopCategoryModelMap")
	public List<ShopCategoryModel> getCatesBySellerId(String sellerId); 
}