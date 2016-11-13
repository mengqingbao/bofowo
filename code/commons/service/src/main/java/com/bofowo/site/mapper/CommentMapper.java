package com.bofowo.site.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.bofowo.site.model.CommentModel;
import com.bofowo.site.provider.CommentProvider;
import com.bofowo.site.query.CommentQuery;

import org.apache.ibatis.mapping.StatementType;

import java.util.List;

public interface CommentMapper{
																																																																																																																																																																																										
	public String columns="ID,BUYER_ID,ORDER_ID,SERVICE_RATE,ITEM_RATE,POST_RATE,COMMENT,CREATED_TIME,T_ORDER_COMMENT,MODIFIED_TIME,STATUS,SHOP_ID,SELLER_ID,EX_COMMENT,EX_SERVICE_RATE,EX_ITEM_RATE,EX_POST,TRADE_ID,ITEM_ID";
																																																																																																																																																																																										
	public String property="#{id},#{buyerId},#{orderId},#{serviceRate},#{itemRate},#{postRate},#{comment},#{createdTime},#{tOrderComment},#{modifiedTime},#{status},#{shopId},#{sellerId},#{exComment},#{exServiceRate},#{exItemRate},#{exPost},#{tradeId},#{itemId}";
																																																																																																																																																																																																	
	public String update="BUYER_ID=#{buyerId},ORDER_ID=#{orderId},SERVICE_RATE=#{serviceRate},ITEM_RATE=#{itemRate},POST_RATE=#{postRate},COMMENT=#{comment},CREATED_TIME=#{createdTime},T_ORDER_COMMENTcol=#{tOrderCommentcol},MODIFIED_TIME=#{modifiedTime},STATUS=#{status},SHOP_ID=#{shopId},SELLER_ID=#{sellerId},EX_COMMENT=#{exComment},EX_SERVICE_RATE=#{exServiceRate},EX_ITEM_RATE=#{exItemRate},EX_POST=#{exPost},TRADE_ID=#{tradeId}";
	
	@SelectProvider(type=CommentProvider.class,method="getSearchSql")
	@ResultMap(value="com.bofowo.site.mapper.CommentMapper.CommentModelMap")
	public List<CommentModel> fetchPageList(CommentQuery query);

	@SelectProvider(type=CommentProvider.class,method="getSearchSqlCount")
	public int fetchPageCount(CommentQuery query);
	
	@Select("select * from T_COMMENT where ID=#{id}")
	@ResultMap(value="com.bofowo.site.mapper.CommentMapper.CommentModelMap")
	public CommentModel getById(long id);
	
	@Delete("delete from T_COMMENT where ID=#{id}")
	public void del(long id);
	
	@SelectKey(before=true,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="select nextval('globalVal') as ID")
	@Insert("insert into T_COMMENT ("+columns+") values ("+property+")")
	public long insert(CommentModel comment);

	@Update("update T_COMMENT set "+update+" where ID=#{id}")
	public long update(CommentModel commentModel); 
}