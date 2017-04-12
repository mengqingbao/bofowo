package com.bofowo.site.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.bofowo.site.model.PicSliderModel;
import com.bofowo.site.query.PicSliderQuery;
import com.bofowo.site.provider.PicSliderProvider;

import org.apache.ibatis.mapping.StatementType;

import java.util.List;

public interface PicSliderMapper{
																																																																																						
	public String columns="ID,TITLE,PIC,SELLER_ID,SHOP_ID,URL,DESC_,STATUS";
																																																																																						
	public String property="#{id},#{title},#{pic},#{sellerId},#{shopId},#{url},#{desc},#{status}";
																																																																																			
	public String update="TITLE=#{title},PIC=#{pic},SELLER_ID=#{sellerId},SHOP_ID=#{shopId},URL=#{url},DESC_=#{desc},STATUS=#{status}";
	
	@SelectProvider(type=PicSliderProvider.class,method="getSearchSql")
	@ResultMap(value="com.bofowo.site.mapper.PicSliderMapper.PicSliderModelMap")
	public List<PicSliderModel> fetchPageList(PicSliderQuery query);

	@SelectProvider(type=PicSliderProvider.class,method="getSearchSqlCount")
	public int fetchPageCount(PicSliderQuery query);
	
	@Select("select * from T_PIC_SLIDER where ID=#{id}")
	@ResultMap(value="com.bofowo.site.mapper.PicSliderMapper.PicSliderModelMap")
	public PicSliderModel getById(long id);
	
	@Delete("delete from T_PIC_SLIDER where ID=#{id}")
	public void del(long id);
	
	@SelectKey(before=true,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="select nextval('globalVal') as ID")
	@Insert("insert into T_PIC_SLIDER ("+columns+") values ("+property+")")
	public long insert(PicSliderModel picslider);

	@Update("update T_PIC_SLIDER set "+update+" where ID=#{id}")
	public long update(PicSliderModel picsliderModel);
	
	@Select("select * from T_PIC_SLIDER where SHOP_ID=#{id} and STATUS='1'")
	@ResultMap(value="com.bofowo.site.mapper.PicSliderMapper.PicSliderModelMap")
	public List<PicSliderModel> getByshopId(Integer id); 
}