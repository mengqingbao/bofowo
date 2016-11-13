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

import com.bofowo.site.model.TradeModel;
import com.bofowo.site.provider.TradeProvider;
import com.bofowo.site.query.TradeQuery;

import java.util.List;

public interface TradeMapper{
																																																																																																																																																																						
	public String columns="ID,TITLE,TOTAL,REAL_PAY,STATUS,PIC,NUM,NOTE,PRODUCT_ID,SHOP_PRACE,SELLER_ID,BUYER_ID,SHOP_NAME,PAY_WAY,CREATED_TIME,MODIFY_TIME";
																																																																																																																																																																						
	public String property="#{id},#{title},#{total},#{realPay},#{status},#{pic},#{num},#{note},#{productId},#{shopPrace},#{sellerId},#{buyerId},#{shopName},#{payWay},#{createdTime},#{modifyTime}";
																																																																																																																																																																											
	public String update="TITLE=#{title},TOTAL=#{total},REAL_PAY=#{realPay},STATUS=#{status},PIC=#{pic},NUM=#{num},NOTE=#{note},PRODUCT_ID=#{productId},SHOP_PRACE=#{shopPrace},SELLER_ID=#{sellerId},BUYER_ID=#{buyerId},SHOP_NAME=#{shopName},PAY_WAY=#{payWay},CREATED_TIME=#{createdTime},MODIFY_TIME=#{modifyTime}";
	
	@SelectProvider(type=TradeProvider.class,method="getSearchSql")
	@ResultMap(value="com.bofowo.site.mapper.TradeMapper.TradeModelMap")
	public List<TradeModel> fetchPageList(TradeQuery query);

	@SelectProvider(type=TradeProvider.class,method="getSearchSqlCount")
	public int fetchPageCount(TradeQuery query);
	
	@Select("select * from T_TRADE where ID=#{id}")
	@ResultMap(value="com.bofowo.site.mapper.TradeMapper.TradeModelMap")
	public TradeModel getById(long id);
	
	@Delete("delete from T_TRADE where ID=#{id}")
	public void del(long id);
	
	@SelectKey(before=true,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="select nextval('globalVal') as ID")
	@Insert("insert into T_TRADE ("+columns+") values ("+property+")")
	public long insert(TradeModel trade);

	@Update("update T_TRADE set "+update+" where ID=#{id}")
	public long update(TradeModel tradeModel); 
}