package com.bofowo.site.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.bofowo.site.model.MyCouponModel;
import com.bofowo.site.provider.MyCouponProvider;
import com.bofowo.site.query.MyCouponQuery;

import org.apache.ibatis.mapping.StatementType;

import java.util.List;

public interface MyCouponMapper{
																																																																																																										
	public String columns="ID,NAME,COUPON_ID,CONTENT,BUYER_ID,SELLER_ID,CREATED_TIME,TYPE,START_DATE,END_DATE";
																																																																																																										
	public String property="#{id},#{name},#{couponId},#{content},#{buyerId},#{sellerId},#{createdTime},#{type},#{startDate},#{endDate}";
																																																																																																									
	public String update="NAME=#{name},COUPON_ID=#{couponId},CONTENT=#{content},BUYER_ID=#{buyerId},SELLER_ID=#{sellerId},CREATED_TIME=#{createdTime},TYPE=#{type},START_DATE=#{startDate},END_DATE=#{endDate}";
	
	@SelectProvider(type=MyCouponProvider.class,method="getSearchSql")
	@ResultMap(value="com.bofowo.site.mapper.MyCouponMapper.MyCouponModelMap")
	public List<MyCouponModel> fetchPageList(MyCouponQuery query);

	@SelectProvider(type=MyCouponProvider.class,method="getSearchSqlCount")
	public int fetchPageCount(MyCouponQuery query);
	
	@Select("select * from T_MY_COUPON where ID=#{id}")
	@ResultMap(value="com.bofowo.site.mapper.MyCouponMapper.MyCouponModelMap")
	public MyCouponModel getById(long id);
	
	@Delete("delete from T_MY_COUPON where ID=#{id}")
	public void del(long id);
	
	@SelectKey(before=true,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="select nextval('globalVal') as ID")
	@Insert("insert into T_MY_COUPON ("+columns+") values ("+property+")")
	public long insert(MyCouponModel mycoupon);

	@Update("update T_MY_COUPON set "+update+" where ID=#{id}")
	public long update(MyCouponModel mycouponModel); 
}