package com.bofowo.site.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.bofowo.site.model.DatabaseModel;
import com.bofowo.site.provider.DatabaseProvider;
import com.bofowo.site.query.DatabaseQuery;

import org.apache.ibatis.mapping.StatementType;

import java.util.List;

public interface DatabaseMapper{
																																																																																																																																																																																																																																																						
	public String columns="ID,databaseName,driverClassName,url,username,password,druid.initialSize,initialSize,maxActive,maxIdle,minIdle,maxWait,removeAbandoned,removeAbandonedTimeout,timeBetweenEvictionRunsMillis,minEvictableIdleTimeMillis,validationQuery,testWhileIdle,testOnBorrow,testOnReturn,poolPreparedStatements,maxPoolPreparedStatementPerConnectionSize,filters,status";
																																																																																																																																																																																																																																																						
	public String property="#{id},#{databasename},#{driverclassname},#{url},#{username},#{password},#{druid.initialsize},#{initialsize},#{maxactive},#{maxidle},#{minidle},#{maxwait},#{removeabandoned},#{removeabandonedtimeout},#{timebetweenevictionrunsmillis},#{minevictableidletimemillis},#{validationquery},#{testwhileidle},#{testonborrow},#{testonreturn},#{poolpreparedstatements},#{maxpoolpreparedstatementperconnectionsize},#{filters},#{status}";
																																																																																																																																																																																																																																																																			
	public String update="databaseName=#{databasename},driverClassName=#{driverclassname},url=#{url},username=#{username},password=#{password},druid.initialSize=#{druid.initialsize},initialSize=#{initialsize},maxActive=#{maxactive},maxIdle=#{maxidle},minIdle=#{minidle},maxWait=#{maxwait},removeAbandoned=#{removeabandoned},removeAbandonedTimeout=#{removeabandonedtimeout},timeBetweenEvictionRunsMillis=#{timebetweenevictionrunsmillis},minEvictableIdleTimeMillis=#{minevictableidletimemillis},validationQuery=#{validationquery},testWhileIdle=#{testwhileidle},testOnBorrow=#{testonborrow},testOnReturn=#{testonreturn},poolPreparedStatements=#{poolpreparedstatements},maxPoolPreparedStatementPerConnectionSize=#{maxpoolpreparedstatementperconnectionsize},filters=#{filters},status=#{status}";
	
	@SelectProvider(type=DatabaseProvider.class,method="getSearchSql")
	@ResultMap(value="com.bofowo.site.mapper.DatabaseMapper.DatabaseModelMap")
	public List<DatabaseModel> fetchPageList(DatabaseQuery query);

	@SelectProvider(type=DatabaseProvider.class,method="getSearchSqlCount")
	public int fetchPageCount(DatabaseQuery query);
	
	@Select("select * from T_DATABASE_ where ID=#{id}")
	@ResultMap(value="com.bofowo.site.mapper.DatabaseMapper.DatabaseModelMap")
	public DatabaseModel getById(long id);
	
	@Delete("delete from T_DATABASE_ where ID=#{id}")
	public void del(long id);
	
	@SelectKey(before=true,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="select nextval('globalVal') as ID")
	@Insert("insert into T_DATABASE_ ("+columns+") values ("+property+")")
	public long insert(DatabaseModel database);

	@Update("update T_DATABASE_ set "+update+" where ID=#{id}")
	public long update(DatabaseModel databaseModel); 
}