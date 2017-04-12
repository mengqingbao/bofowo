package com.bofowo.site.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import com.bofowo.site.model.MyShowModel;
import com.bofowo.site.query.MyShowQuery;
import com.bofowo.site.provider.MyShowProvider;
import org.apache.ibatis.mapping.StatementType;
import java.util.List;

public interface MyShowMapper{
																																				
	public String columns="ID,NAME,PASSWORD";
																																				
	public String property="#{id},#{name},#{password}";
																												
	public String update="NAME=#{name},PASSWORD=#{password}";
	
	@SelectProvider(type=MyShowProvider.class,method="getSearchSql")
	@ResultMap(value="com.bofowo.site.mapper.MyShowMapper.MyShowModelMap")
	public List<MyShowModel> fetchPageList(MyShowQuery query);

	@SelectProvider(type=MyShowProvider.class,method="getSearchSqlCount")
	public int fetchPageCount(MyShowQuery query);
	
	@Select("select * from T_MY_SHOW where ID=#{id}")
	@ResultMap(value="com.bofowo.site.mapper.MyShowMapper.MyShowModelMap")
	public MyShowModel getById(long id);
	
	@Delete("delete from T_MY_SHOW where ID=#{id}")
	public void del(long id);
	
	@SelectKey(before=true,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="select nextval('globalVal') as ID")
	@Insert("insert into T_MY_SHOW ("+columns+") values ("+property+")")
	public long insert(MyShowModel myshow);

	@Update("update T_MY_SHOW set "+update+" where ID=#{id}")
	public long update(MyShowModel myshowModel); 
}