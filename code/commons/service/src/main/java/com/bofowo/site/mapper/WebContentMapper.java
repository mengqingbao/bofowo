package com.bofowo.site.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

import com.bofowo.site.model.WebContentModel;
import com.bofowo.site.query.WebContentQuery;

import java.util.List;

public interface WebContentMapper{
																																																																																																																																																																																																				
	public String columns="ID,TITLE,AUTHOR,FROM_,CREATE_DATE,MODIFY_DATE,CREATOR,MODIFIER,CONTENT_A,CONTENT_B,CONTENT_C,CATEGORY_ID,STATUS,IS_DELETE,DESC_,TAG_LIB_ID,SEO_TITTLE,SEO_KEY,SEO_DESC,PIC";
																																																																																																																																																																																																				
	public String property="#{id},#{title},#{author},#{from},#{createDate},#{modifyDate},#{creator},#{modifier},#{contentA},#{contentB},#{contentC},#{categoryId},#{status},#{isDelete},#{desc},#{tagLibId},#{seoTittle},#{seoKey},#{seoDesc},#{pic}";
																																																																																																																																																																																																												
	public String update="TITLE=#{title},AUTHOR=#{author},FROM_=#{from},CREATE_DATE=#{createDate},MODIFY_DATE=#{modifyDate},CREATOR=#{creator},MODIFIER=#{modifier},CONTENT_A=#{contentA},CONTENT_B=#{contentB},CONTENT_C=#{contentC},CATEGORY_ID=#{categoryId},STATUS=#{status},IS_DELETE=#{isDelete},DESC_=#{desc},TAG_LIB_ID=#{tagLibId},SEO_TITTLE=#{seoTittle},SEO_KEY=#{seoKey},SEO_DESC=#{seoDesc},PIC=#{pic}";
	
	@Select("select "+columns+" FROM T_WEB_CONTENT limit #{startRow},#{endRow}")
	@ResultMap(value="com.bofowo.site.mapper.WebContentMapper.WebContentModelMap")
	public List<WebContentModel> fetchPageList(WebContentQuery query);
	
	@Select("select count(*) from T_WEB_CONTENT")
	public int fetchPageCount(WebContentQuery query);
	
	@Select("select "+columns+" from T_WEB_CONTENT where ID=#{id}")
	@ResultMap(value="com.bofowo.site.mapper.WebContentMapper.WebContentModelMap")
	public WebContentModel getById(long id);
	
	@Delete("delete from T_WEB_CONTENT where ID=#{id}")
	public void del(long id);
	
	@SelectKey(before=true,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="select nextval('webContent') as ID")
	@Insert("insert into T_WEB_CONTENT ("+columns+") values ("+property+")")
	public long insert(WebContentModel webcontent);

	@Update("update T_WEB_CONTENT set "+update+" where ID=#{id}")
	public long update(WebContentModel webcontentModel); 
}