package com.bofowo.site.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.bofowo.site.model.BuyerAddressModel;
import com.bofowo.site.provider.BuyerAddressProvider;
import com.bofowo.site.query.BuyerAddressQuery;

import org.apache.ibatis.mapping.StatementType;

import java.util.List;
import java.util.Map;

public interface BuyerAddressMapper{
																																																																																																																														
	public String columns="ID,BUYER_ID,PROVINCE,CITY,AREA,ADDRESS,POST_CODE,REAL_NAME,MOBILE,TELE,IS_DEFAULT,IS_DELETE";
																																																																																																																														
	public String property="#{id},#{buyerId},#{province},#{city},#{area},#{address},#{postCode},#{realName},#{mobile},#{tele},#{isDefault},#{isDelete}";
																																																																																																																															
	public String update="BUYER_ID=#{buyerId},PROVINCE=#{province},CITY=#{city},AREA=#{area},ADDRESS=#{address},POST_CODE=#{postCode},REAL_NAME=#{realName},MOBILE=#{mobile},TELE=#{tele},IS_DEFAULT=#{isDefault},IS_DELETE=#{isDelete}";
	
	@SelectProvider(type=BuyerAddressProvider.class,method="getSearchSql")
	@ResultMap(value="com.bofowo.site.mapper.BuyerAddressMapper.BuyerAddressModelMap")
	public List<BuyerAddressModel> fetchPageList(BuyerAddressQuery query);

	@SelectProvider(type=BuyerAddressProvider.class,method="getSearchSqlCount")
	public int fetchPageCount(BuyerAddressQuery query);
	
	@Select("select * from T_BUYER_ADDRESS where ID=#{id}")
	@ResultMap(value="com.bofowo.site.mapper.BuyerAddressMapper.BuyerAddressModelMap")
	public BuyerAddressModel getById(long id);
	
	@Delete("delete from T_BUYER_ADDRESS where ID=#{id}")
	public void del(long id);
	
	@SelectKey(before=true,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="select nextval('globalVal') as ID")
	@Insert("insert into T_BUYER_ADDRESS ("+columns+") values ("+property+")")
	public long insert(BuyerAddressModel buyeraddress);

	@Update("update T_BUYER_ADDRESS set "+update+" where ID=#{id}")
	public long update(BuyerAddressModel buyeraddressModel);
	
	@Update("update T_BUYER_ADDRESS set IS_DEFAULT='0' where BUYER_ID=#{buyerId}")
	public void clearDefault(String buyerId);

	@Select("select * from T_BUYER_ADDRESS where BUYER_ID=#{username}")
	@ResultMap(value="com.bofowo.site.mapper.BuyerAddressMapper.BuyerAddressModelMap")
	public List<BuyerAddressModel> getBuyerAddress(String username); 
}