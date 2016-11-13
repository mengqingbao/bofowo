package com.bofowo.site.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.bofowo.site.model.TypeModel;
import com.bofowo.site.query.TypeQuery;

import java.util.List;

public interface TypeMapper{
																																																																		
	public String columns="ID,NAME,ORDER_,DESC_,STATUS,IS_DELETE";
																																																																		
	public String property="#{id},#{name},#{order},#{desc},#{status},#{isDelete}";
																																																													
	public String update="NAME=#{name},ORDER_=#{order},DESC_=#{desc},STATUS=#{status},IS_DELETE=#{isDelete}";
	
	@Select("select "+columns+" FROM t_type limit #{startRow},#{endRow}")
	@ResultMap(value="com.bofowo.site.mapper.TypeMapper.TypeModelMap")
	public List<TypeModel> fetchPageList(TypeQuery query);
	
	@Select("select count(*) from t_type")
	public int fetchPageCount(TypeQuery query);
	
	@Select("select * from t_type where ID=#{id}")
	public TypeModel getById(long id);
	
	@Delete("delete from t_type where ID=#{id}")
	public void del(long id);
	
	@Insert("insert into t_type ("+columns+") values ("+property+")")
	public long insert(TypeModel type);

	@Update("update t_type set "+update+" where ID=#{id}")
	public long update(TypeModel typeModel); 
}