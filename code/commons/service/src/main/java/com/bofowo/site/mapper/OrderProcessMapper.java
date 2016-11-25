package com.bofowo.site.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import com.bofowo.site.model.OrderProcessModel;
import com.bofowo.site.query.OrderProcessQuery;
import com.bofowo.site.provider.OrderProcessProvider;
import org.apache.ibatis.mapping.StatementType;
import java.util.List;

public interface OrderProcessMapper{
																																																																												
	public String columns="ID,TID,OID,DESC,STATUS,CREATED_TIME,STATUS_ID";
																																																																												
	public String property="#{id},#{tid},#{oid},#{desc},#{status},#{createdTime},#{statusId}";
																																																																								
	public String update="TID=#{tid},OID=#{oid},DESC=#{desc},STATUS=#{status},CREATED_TIME=#{createdTime},STATUS_ID=#{statusId}";
	
	@SelectProvider(type=OrderProcessProvider.class,method="getSearchSql")
	@ResultMap(value="com.bofowo.site.mapper.OrderProcessMapper.OrderProcessModelMap")
	public List<OrderProcessModel> fetchPageList(OrderProcessQuery query);

	@SelectProvider(type=OrderProcessProvider.class,method="getSearchSqlCount")
	public int fetchPageCount(OrderProcessQuery query);
	
	@Select("select * from T_ORDER_PROCESS where ID=#{id}")
	@ResultMap(value="com.bofowo.site.mapper.OrderProcessMapper.OrderProcessModelMap")
	public OrderProcessModel getById(long id);
	
	@Delete("delete from T_ORDER_PROCESS where ID=#{id}")
	public void del(long id);
	
	@SelectKey(before=true,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="select nextval('globalVal') as ID")
	@Insert("insert into T_ORDER_PROCESS ("+columns+") values ("+property+")")
	public long insert(OrderProcessModel orderprocess);

	@Update("update T_ORDER_PROCESS set "+update+" where ID=#{id}")
	public long update(OrderProcessModel orderprocessModel); 
}