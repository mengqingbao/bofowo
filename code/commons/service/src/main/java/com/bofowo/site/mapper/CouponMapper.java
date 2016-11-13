package com.bofowo.site.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.bofowo.site.model.CouponModel;
import com.bofowo.site.provider.CouponProvider;
import com.bofowo.site.query.CouponQuery;

import org.apache.ibatis.mapping.StatementType;

import java.util.List;

public interface CouponMapper{
																																																																																																																																																												
	public String columns="ID,NAME,DESC_,CREATED_TIME,BEGIN_TIME,END_TIME,STATUS,SHOP_ID,SELLER_ID,TYPE,CONTENT,CATEGORY_IDS,PIC,MODIFY_TIME,MODIFIER";
																																																																																																																																																												
	public String property="#{id},#{name},#{desc},#{createdTime},#{beginTime},#{endTime},#{status},#{shopId},#{sellerId},#{type},#{content},#{categoryIds},#{pic},#{modifyTime},#{modifier}";
																																																																																																																																																																
	public String update="NAME=#{name},DESC_=#{desc},CREATED_TIME=#{createdTime},BEGIN_TIME=#{beginTime},END_TIME=#{endTime},STATUS=#{status},SHOP_ID=#{shopId},SELLER_ID=#{sellerId},TYPE=#{type},CONTENT=#{content},CATEGORY_IDS=#{categoryIds},PIC=#{pic},MODIFY_TIME=#{modifyTime},MODIFIER=#{modifier}";
	
	@SelectProvider(type=CouponProvider.class,method="getSearchSql")
	@ResultMap(value="com.bofowo.site.mapper.CouponMapper.CouponModelMap")
	public List<CouponModel> fetchPageList(CouponQuery query);

	@SelectProvider(type=CouponProvider.class,method="getSearchSqlCount")
	public int fetchPageCount(CouponQuery query);
	
	@Select("select * from T_COUPON where ID=#{id}")
	@ResultMap(value="com.bofowo.site.mapper.CouponMapper.CouponModelMap")
	public CouponModel getById(long id);
	
	@Delete("delete from T_COUPON where ID=#{id}")
	public void del(long id);
	
	@SelectKey(before=true,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="select nextval('globalVal') as ID")
	@Insert("insert into T_COUPON ("+columns+") values ("+property+")")
	public long insert(CouponModel coupon);

	@Update("update T_COUPON set "+update+" where ID=#{id}")
	public long update(CouponModel couponModel); 
}