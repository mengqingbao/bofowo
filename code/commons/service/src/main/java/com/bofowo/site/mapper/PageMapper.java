package com.bofowo.site.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.bofowo.site.model.PageModel;
import com.bofowo.site.provider.PageProvider;
import com.bofowo.site.query.PageQuery;

import org.apache.ibatis.mapping.StatementType;

import java.util.List;

public interface PageMapper{
																																																																																																										
	public String columns="ID,NAME,URL,TYPE_,STATUS,LAYOUT,THEME_ID,CONTENT,HEADER,FOOTER";
																																																																																																										
	public String property="#{id},#{name},#{url},#{type},#{status},#{layout},#{themeId},#{content},#{header},#{footer}";
																																																																																																									
	public String update="NAME=#{name},URL=#{url},TYPE_=#{type},STATUS=#{status},LAYOUT=#{layout},THEME_ID=#{themeId},CONTENT=#{content},HEADER=#{header},FOOTER=#{footer}";
	
	@SelectProvider(type=PageProvider.class,method="getSearchSql")
	@ResultMap(value="com.bofowo.site.mapper.PageMapper.PageModelMap")
	public List<PageModel> fetchPageList(PageQuery query);

	@SelectProvider(type=PageProvider.class,method="getSearchSqlCount")
	public int fetchPageCount(PageQuery query);
	
	@Select("select * from T_PAGE where ID=#{id}")
	@ResultMap(value="com.bofowo.site.mapper.PageMapper.PageModelMap")
	public PageModel getById(long id);
	
	@Delete("delete from T_PAGE where ID=#{id}")
	public void del(long id);
	
	@SelectKey(before=true,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="select nextval('globalVal') as ID")
	@Insert("insert into T_PAGE ("+columns+") values ("+property+")")
	public long insert(PageModel page);

	@Update("update T_PAGE set "+update+" where ID=#{id}")
	public long update(PageModel pageModel); 
}