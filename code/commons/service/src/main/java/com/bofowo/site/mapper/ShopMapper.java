package com.bofowo.site.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.bofowo.site.model.ShopModel;
import com.bofowo.site.provider.ShopProvider;
import com.bofowo.site.query.ShopQuery;

import org.apache.ibatis.mapping.StatementType;

import java.util.List;

public interface ShopMapper{
																																																																																																																																																																																																																																																																																																																																																										
	public String columns="ID,NAME,DESC_,LOGO_IMG,CREATOR,URL,OWNER,CREATED_TIME,SERVICE_SCORE_TOTAL,DRAW_SCORE_TOTAL,POST_SCORE_TOTAL,COMMENT_TIMES,LEVEL_,NOTICE,HEADER,LAYOUT,LAYOUT_COLUMN_TOTAL,FOOTER,ORDER_,STATUS,BODY,SHOP_ID,SELLER_ID,TYPE_,ADDRESS,TELE,QQ,WANGWANG,SEO_KEY,SEO_CONTENT,PROVINCE,CITY,AREA,CATEGORY_ID";
																																																																																																																																																																																																																																																																																																																																																										
	public String property="#{id},#{name},#{desc},#{logoImg},#{creator},#{url},#{owner},#{createdTime},#{serviceScoreTotal},#{drawScoreTotal},#{postScoreTotal},#{commentTimes},#{level},#{notice},#{header},#{layout},#{layoutColumnTotal},#{footer},#{order},#{status},#{body},#{shopId},#{sellerId},#{type},#{address},#{tele},#{qq},#{wangwang},#{seoKey},#{seoContent},#{province},#{city},#{area},#{categoryId}";
																																																																																																																																																																																																																																																																																																																																																																																	
	public String update="NAME=#{name},DESC_=#{desc},LOGO_IMG=#{logoImg},CREATOR=#{creator},URL=#{url},OWNER=#{owner},CREATED_TIME=#{createdTime},SERVICE_SCORE_TOTAL=#{serviceScoreTotal},DRAW_SCORE_TOTAL=#{drawScoreTotal},POST_SCORE_TOTAL=#{postScoreTotal},COMMENT_TIMES=#{commentTimes},LEVEL_=#{level},NOTICE=#{notice},HEADER=#{header},LAYOUT=#{layout},LAYOUT_COLUMN_TOTAL=#{layoutColumnTotal},FOOTER=#{footer},ORDER_=#{order},STATUS=#{status},BODY=#{body},SHOP_ID=#{shopId},SELLER_ID=#{sellerId},TYPE_=#{type},ADDRESS=#{address},TELE=#{tele},QQ=#{qq},WANGWANG=#{wangwang},SEO_KEY=#{seoKey},SEO_CONTENT=#{seoContent},PROVINCE=#{province},CITY=#{city},AREA=#{area},CATEGORY_ID=#{categoryId}";
	
	@SelectProvider(type=ShopProvider.class,method="getSearchSql")
	@ResultMap(value="com.bofowo.site.mapper.ShopMapper.ShopModelMap")
	public List<ShopModel> fetchPageList(ShopQuery query);

	@SelectProvider(type=ShopProvider.class,method="getSearchSqlCount")
	public int fetchPageCount(ShopQuery query);
	
	@Select("select * from T_SHOP where ID=#{id}")
	@ResultMap(value="com.bofowo.site.mapper.ShopMapper.ShopModelMap")
	public ShopModel getById(long id);
	
	@Delete("delete from T_SHOP where ID=#{id}")
	public void del(long id);
	
	@SelectKey(before=true,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="select nextval('globalVal') as ID")
	@Insert("insert into T_SHOP ("+columns+") values ("+property+")")
	public long insert(ShopModel shop);

	@Update("update T_SHOP set "+update+" where ID=#{id}")
	public long update(ShopModel shopModel); 
	
	@Select("select * from T_SHOP where OWNER=#{currentUserName}")
	@ResultMap(value="com.bofowo.site.mapper.ShopMapper.ShopModelMap")
	public ShopModel getByUsername(String currentUserName); 
}