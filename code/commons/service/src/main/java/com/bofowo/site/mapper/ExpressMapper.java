package com.bofowo.site.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import com.bofowo.site.model.ExpressModel;
import com.bofowo.site.query.ExpressQuery;
import com.bofowo.site.provider.ExpressProvider;
import org.apache.ibatis.mapping.StatementType;
import java.util.List;

public interface ExpressMapper{
																																																																																																
	public String columns="ID,EXP_COMPANY,F_ID,TYPE,SELLER_ID,BUYER_ID,CONTENT,STATUS,MODIFIED_TIME";
																																																																																																
	public String property="#{id},#{expCompany},#{fId},#{type},#{sellerId},#{buyerId},#{content},#{status},#{modifiedTime}";
																																																																																														
	public String update="EXP_COMPANY=#{expCompany},F_ID=#{fId},TYPE=#{type},SELLER_ID=#{sellerId},BUYER_ID=#{buyerId},CONTENT=#{content},STATUS=#{status},MODIFIED_TIME=#{modifiedTime}";
	
	@SelectProvider(type=ExpressProvider.class,method="getSearchSql")
	@ResultMap(value="com.bofowo.site.mapper.ExpressMapper.ExpressModelMap")
	public List<ExpressModel> fetchPageList(ExpressQuery query);

	@SelectProvider(type=ExpressProvider.class,method="getSearchSqlCount")
	public int fetchPageCount(ExpressQuery query);
	
	@Select("select * from T_EXPRESS where ID=#{id}")
	@ResultMap(value="com.bofowo.site.mapper.ExpressMapper.ExpressModelMap")
	public ExpressModel getById(long id);
	
	@Delete("delete from T_EXPRESS where ID=#{id}")
	public void del(long id);
	
	@SelectKey(before=true,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="select nextval('globalVal') as ID")
	@Insert("insert into T_EXPRESS ("+columns+") values ("+property+")")
	public long insert(ExpressModel express);

	@Update("update T_EXPRESS set "+update+" where ID=#{id}")
	public long update(ExpressModel expressModel); 
}