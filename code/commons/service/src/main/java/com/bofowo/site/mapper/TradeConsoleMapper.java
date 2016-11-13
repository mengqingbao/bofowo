package com.bofowo.site.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.bofowo.site.model.TradeConsoleModel;
import com.bofowo.site.provider.TradeConsoleProvider;
import com.bofowo.site.query.TradeConsoleQuery;

import org.apache.ibatis.mapping.StatementType;

import java.util.List;

public interface TradeConsoleMapper{
																																																																																						
	public String columns="ID,ASKER_ID,ANSWER_ID,TYPE_,CONTEN,CREATE_TIME,PID,STATUS";
																																																																																						
	public String property="#{id},#{askerId},#{answerId},#{type},#{conten},#{createTime},#{pid},#{status}";
																																																																																			
	public String update="ASKER_ID=#{askerId},ANSWER_ID=#{answerId},TYPE_=#{type},CONTEN=#{conten},CREATE_TIME=#{createTime},PID=#{pid},STATUS=#{status}";
	
	@SelectProvider(type=TradeConsoleProvider.class,method="getSearchSql")
	@ResultMap(value="com.bofowo.site.mapper.TradeConsoleMapper.TradeConsoleModelMap")
	public List<TradeConsoleModel> fetchPageList(TradeConsoleQuery query);

	@SelectProvider(type=TradeConsoleProvider.class,method="getSearchSqlCount")
	public int fetchPageCount(TradeConsoleQuery query);
	
	@Select("select * from T_TRADE_CONSOLE where ID=#{id}")
	@ResultMap(value="com.bofowo.site.mapper.TradeConsoleMapper.TradeConsoleModelMap")
	public TradeConsoleModel getById(long id);
	
	@Delete("delete from T_TRADE_CONSOLE where ID=#{id}")
	public void del(long id);
	
	@SelectKey(before=true,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="select nextval('globalVal') as ID")
	@Insert("insert into T_TRADE_CONSOLE ("+columns+") values ("+property+")")
	public long insert(TradeConsoleModel tradeconsole);

	@Update("update T_TRADE_CONSOLE set "+update+" where ID=#{id}")
	public long update(TradeConsoleModel tradeconsoleModel); 
}