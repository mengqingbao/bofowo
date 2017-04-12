package com.bofowo.site.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.bofowo.site.model.BuyerCollectionModel;
import com.bofowo.site.provider.BuyerCollectionProvider;
import com.bofowo.site.query.BuyerCollectionQuery;

import org.apache.ibatis.mapping.StatementType;

import java.util.List;
import java.util.Map;

public interface BuyerCollectionMapper{
																																																																																																																														
	public String columns="ID,ITEM_ID,TITLE,IMAGE,BUYER_ID,SELLER_ID,SHOP_ID,SHOP_NAME,TYPE_,CREATED_TIME,T_BUYER_COLLECTIONcol,IS_DELETE";
																																																																																																																														
	public String property="#{id},#{itemId},#{title},#{image},#{buyerId},#{sellerId},#{shopId},#{shopName},#{type},#{createdTime},#{tBuyerCollectioncol},#{isDelete}";
																																																																																																																															
	public String update="ITEM_ID=#{itemId},TITLE=#{title},IMAGE=#{image},BUYER_ID=#{buyerId},SELLER_ID=#{sellerId},SHOP_ID=#{shopId},SHOP_NAME=#{shopName},TYPE_=#{type},CREATED_TIME=#{createdTime},T_BUYER_COLLECTIONcol=#{tBuyerCollectioncol},IS_DELETE=#{isDelete}";
	
	@SelectProvider(type=BuyerCollectionProvider.class,method="getSearchSql")
	@ResultMap(value="com.bofowo.site.mapper.BuyerCollectionMapper.BuyerCollectionModelMap")
	public List<BuyerCollectionModel> fetchPageList(BuyerCollectionQuery query);

	@SelectProvider(type=BuyerCollectionProvider.class,method="getSearchSqlCount")
	public int fetchPageCount(BuyerCollectionQuery query);
	
	@Select("select * from T_BUYER_COLLECTION where ID=#{id}")
	@ResultMap(value="com.bofowo.site.mapper.BuyerCollectionMapper.BuyerCollectionModelMap")
	public BuyerCollectionModel getById(long id);
	
	@Delete("delete from T_BUYER_COLLECTION where ID=#{id}")
	public void del(long id);
	
	@SelectKey(before=true,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="select nextval('globalVal') as ID")
	@Insert("insert into T_BUYER_COLLECTION ("+columns+") values ("+property+")")
	public long insert(BuyerCollectionModel buyercollection);

	@Update("update T_BUYER_COLLECTION set "+update+" where ID=#{id}")
	public long update(BuyerCollectionModel buyercollectionModel);

	@Select("select * from T_BUYER_COLLECTION where ITEM_ID=#{id} and BUYER_ID='${buyerId}' and TYPE_='2'")
	@ResultMap(value="com.bofowo.site.mapper.BuyerCollectionMapper.BuyerCollectionModelMap")
	public BuyerCollectionModel getByProductId(Map condition);

	@Select("select * from T_BUYER_COLLECTION where SHOP_ID=#{id} and BUYER_ID='${buyerId}' and TYPE_='1'")
	@ResultMap(value="com.bofowo.site.mapper.BuyerCollectionMapper.BuyerCollectionModelMap")
	public BuyerCollectionModel getByShopId(Map condition); 
}