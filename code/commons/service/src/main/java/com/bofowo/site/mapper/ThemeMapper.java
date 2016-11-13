package com.bofowo.site.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.bofowo.site.model.ThemeModel;
import com.bofowo.site.provider.ThemeProvider;
import com.bofowo.site.query.ThemeQuery;

import org.apache.ibatis.mapping.StatementType;

import java.util.List;

public interface ThemeMapper{
																																																																																																																				
	public String columns="ID,NAME,CONTENT,STATUS,LEVEL,PRICE,SELLER_ID,AVATAR,DRAW,CREATE_TIME,MODIFY_TIME";
																																																																																																																				
	public String property="#{id},#{name},#{content},#{status},#{level},#{price},#{sellerId},#{avatar},#{draw},#{createTime},#{modifyTime}";
																																																																																																																				
	public String update="NAME=#{name},CONTENT=#{content},STATUS=#{status},LEVEL=#{level},PRICE=#{price},SELLER_ID=#{sellerId},AVATAR=#{avatar},DRAW=#{draw},CREATE_TIME=#{createTime},MODIFY_TIME=#{modifyTime}";
	
	@SelectProvider(type=ThemeProvider.class,method="getSearchSql")
	@ResultMap(value="com.bofowo.site.mapper.ThemeMapper.ThemeModelMap")
	public List<ThemeModel> fetchPageList(ThemeQuery query);

	@SelectProvider(type=ThemeProvider.class,method="getSearchSqlCount")
	public int fetchPageCount(ThemeQuery query);
	
	@Select("select * from T_THEME where ID=#{id}")
	@ResultMap(value="com.bofowo.site.mapper.ThemeMapper.ThemeModelMap")
	public ThemeModel getById(long id);
	
	@Delete("delete from T_THEME where ID=#{id}")
	public void del(long id);
	
	@SelectKey(before=true,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="select nextval('globalVal') as ID")
	@Insert("insert into T_THEME ("+columns+") values ("+property+")")
	public long insert(ThemeModel theme);

	@Update("update T_THEME set "+update+" where ID=#{id}")
	public long update(ThemeModel themeModel); 
}