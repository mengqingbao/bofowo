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

import com.bofowo.site.model.OrderModel;
import com.bofowo.site.provider.OrderProvider;
import com.bofowo.site.query.OrderQuery;

import java.util.List;

public interface OrderMapper{
																																																																																																																																																																																										
	public String columns="ID,ITEM_ID,TITLE,PIC,NUM,PRICE,TOTAL,STATUS,REAL_PAY,PROPERTIES,SPEC,TID,NOTE,SELLER_ID,BUYER_ID,PAY_WAY,CREATED_TIME,MODIFY_TIME";
																																																																																																																																																																																										
	public String property="#{id},#{itemId},#{title},#{pic},#{num},#{price},#{total},#{status},#{realPay},#{properties},#{spec},#{tid},#{note},#{sellerId},#{buyerId},#{payWay},#{createdTime},#{modifyTime}";
																																																																																																																																																																																																	
	public String update="ITEM_ID=#{itemId},TITLE=#{title},PIC=#{pic},NUM=#{num},PRICE=#{price},TOTAL=#{total},STATUS=#{status},REAL_PAY=#{realPay},PROPERTIES=#{properties},SPEC=#{spec},TID=#{tid},NOTE=#{note},SELLER_ID=#{sellerId},BUYER_ID=#{buyerId},PAY_WAY=#{payWay},CREATED_TIME=#{createdTime},MODIFY_TIME=#{modifyTime}";
	
	@SelectProvider(type=OrderProvider.class,method="getSearchSql")
	@ResultMap(value="com.bofowo.site.mapper.OrderMapper.OrderModelMap")
	public List<OrderModel> fetchPageList(OrderQuery query);

	@SelectProvider(type=OrderProvider.class,method="getSearchSqlCount")
	public int fetchPageCount(OrderQuery query);
	
	@Select("select * from T_ORDER where ID=#{id}")
	@ResultMap(value="com.bofowo.site.mapper.OrderMapper.OrderModelMap")
	public OrderModel getById(long id);
	
	@Delete("delete from T_ORDER where ID=#{id}")
	public void del(long id);
	
	@SelectKey(before=true,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="select nextval('globalVal') as ID")
	@Insert("insert into T_ORDER ("+columns+") values ("+property+")")
	public long insert(OrderModel order);

	@Update("update T_ORDER set "+update+" where ID=#{id}")
	public long update(OrderModel orderModel);
	
	@Select("select * from T_ORDER where TID=#{tid}")
	@ResultMap(value="com.bofowo.site.mapper.OrderMapper.OrderModelMap")
	public List<OrderModel> getOrderByTradeId(long tid);

}