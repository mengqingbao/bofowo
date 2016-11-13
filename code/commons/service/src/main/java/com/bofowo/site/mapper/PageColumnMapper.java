package com.bofowo.site.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.bofowo.site.model.PageColumnModel;
import com.bofowo.site.provider.PageColumnProvider;
import com.bofowo.site.query.PageColumnQuery;

import org.apache.ibatis.mapping.StatementType;

import java.util.List;

public interface PageColumnMapper{
																																																																												
	public String columns="ID,PAGE_ID,CONTENT,STATUS,DATA_JSON,TYPE_,ORDER_";
																																																																												
	public String property="#{id},#{pageId},#{content},#{status},#{dataJson},#{type},#{order}";
																																																																								
	public String update="PAGE_ID=#{pageId},CONTENT=#{content},STATUS=#{status},DATA_JSON=#{dataJson},TYPE_=#{type},ORDER_=#{order}";
	
	@SelectProvider(type=PageColumnProvider.class,method="getSearchSql")
	@ResultMap(value="com.bofowo.site.mapper.PageColumnMapper.PageColumnModelMap")
	public List<PageColumnModel> fetchPageList(PageColumnQuery query);

	@SelectProvider(type=PageColumnProvider.class,method="getSearchSqlCount")
	public int fetchPageCount(PageColumnQuery query);
	
	@Select("select * from T_PAGE_COLUMN where ID=#{id}")
	@ResultMap(value="com.bofowo.site.mapper.PageColumnMapper.PageColumnModelMap")
	public PageColumnModel getById(long id);
	
	@Delete("delete from T_PAGE_COLUMN where ID=#{id}")
	public void del(long id);
	
	@SelectKey(before=true,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="select nextval('globalVal') as ID")
	@Insert("insert into T_PAGE_COLUMN ("+columns+") values ("+property+")")
	public long insert(PageColumnModel pagecolumn);

	@Update("update T_PAGE_COLUMN set "+update+" where ID=#{id}")
	public long update(PageColumnModel pagecolumnModel);

	@Select("select * from T_PAGE_COLUMN where PAGE_ID=#{pageId}")
	@ResultMap(value="com.bofowo.site.mapper.PageColumnMapper.PageColumnModelMap")
	public List<PageColumnModel> getByPageId(int pageId); 
}