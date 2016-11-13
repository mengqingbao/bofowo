package com.bofowo.site.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.bofowo.site.model.SeqModel;
import com.bofowo.site.provider.SeqProvider;
import com.bofowo.site.query.SeqQuery;

import java.util.List;

public interface SeqMapper{
																																				
	public String columns="ID,NAME,VAL_";
																																				
	public String property="#{id},#{name},#{val}";
																												
	public String update="NAME=#{name},VAL_=#{val}";
	
	@SelectProvider(type=SeqProvider.class,method="getSearchSql")
	@ResultMap(value="com.bofowo.site.mapper.SeqMapper.SeqModelMap")
	public List<SeqModel> fetchPageList(SeqQuery query);

	@SelectProvider(type=SeqProvider.class,method="getSearchSql")
	public int fetchPageCount(SeqQuery query);
	
	@Select("select * from T_SEQ where ID=#{id}")
	@ResultMap(value="com.bofowo.site.mapper.SeqMapper.SeqModelMap")
	public SeqModel getById(long id);
	
	@Delete("delete from T_SEQ where ID=#{id}")
	public void del(long id);
	
	@Insert("insert into T_SEQ ("+columns+") values ("+property+")")
	public long insert(SeqModel seq);

	@Update("update T_SEQ set "+update+" where ID=#{id}")
	public long update(SeqModel seqModel); 
}