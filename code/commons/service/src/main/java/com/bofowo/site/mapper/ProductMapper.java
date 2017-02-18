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

import com.bofowo.site.model.ProductModel;
import com.bofowo.site.provider.ProductProvider;
import com.bofowo.site.query.ProductQuery;

import java.util.List;

public interface ProductMapper{
																																																																																																																																																																																																																																																																										
	public String columns="ID,NAME,TRADEMARK_ID,MARKET_PRICE,SHOP_PRICE,TYPE_,CODE,CONTENT,SHOP_CATEGORY_ID,SHOP_STATUS,STATUS,IS_RECOMMEND,SEO_KEY,SEO_CONTENT,SEO_TITLE,TIGLIB,PL_BENEFIT,ORDER_,CATEGORY_ID,SHOP_ID,SELLER_ID,CREATED_TIME,MODIFIED_TIME,MODIFIER,NUM,IMAGES,CATEGORY_A_ID,CATEGORY_B_ID,SOLD_NUM,PC_CHANNEL,M_CHANNEL,POST_ID";
																																																																																																																																																																																																																																																																										
	public String property="#{id},#{name},#{trademarkId},#{marketPrice},#{shopPrice},#{type},#{code},#{content},#{shopCategoryId},#{shopStatus},#{status},#{isRecommend},#{seoKey},#{seoContent},#{seoTitle},#{tiglib},#{plBenefit},#{order},#{categoryId},#{shopId},#{sellerId},#{createdTime},#{modifiedTime},#{modifier},#{num},#{images},#{categoryAId},#{categoryBId},#{soldNum},#{pcChannel},#{mChannel},#{postId}";
																																																																																																																																																																																																																																																																																									
	public String update="NAME=#{name},TRADEMARK_ID=#{trademarkId},MARKET_PRICE=#{marketPrice},SHOP_PRICE=#{shopPrice},TYPE_=#{type},CODE=#{code},CONTENT=#{content},SHOP_CATEGORY_ID=#{shopCategoryId},SHOP_STATUS=#{shopStatus},STATUS=#{status},IS_RECOMMEND=#{isRecommend},SEO_KEY=#{seoKey},SEO_CONTENT=#{seoContent},SEO_TITLE=#{seoTitle},TIGLIB=#{tiglib},PL_BENEFIT=#{plBenefit},ORDER_=#{order},CATEGORY_ID=#{categoryId},SHOP_ID=#{shopId},SELLER_ID=#{sellerId},CREATED_TIME=#{createdTime},MODIFIED_TIME=#{modifiedTime},MODIFIER=#{modifier},NUM=#{num},IMAGES=#{images},CATEGORY_A_ID=#{categoryAId},CATEGORY_B_ID=#{categoryBId},PC_CHANNEL=#{pcChannel},M_CHANNEL=#{mChannel},POST_ID=#{postId}";
	
	@SelectProvider(type=ProductProvider.class,method="getSearchSql")
	@ResultMap(value="com.bofowo.site.mapper.ProductMapper.ProductModelMap")
	public List<ProductModel> fetchPageList(ProductQuery query);

	@SelectProvider(type=ProductProvider.class,method="getSearchSqlCount")
	public int fetchPageCount(ProductQuery query);
	
	@Select("select * from T_PRODUCT where ID=#{id}")
	@ResultMap(value="com.bofowo.site.mapper.ProductMapper.ProductModelMap")
	public ProductModel getById(long id);
	
	@Delete("delete from T_PRODUCT where ID=#{id}")
	public void del(long id);
	
	@SelectKey(before=true,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="select nextval('globalVal') as ID")
	@Insert("insert into T_PRODUCT ("+columns+") values ("+property+")")
	public long insert(ProductModel product);

	@Update("update T_PRODUCT set "+update+" where ID=#{id}")
	public long update(ProductModel productModel);

}