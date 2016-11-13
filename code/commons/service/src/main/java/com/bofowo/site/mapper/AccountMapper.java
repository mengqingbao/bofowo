package com.bofowo.site.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.bofowo.site.model.AccountModel;
import com.bofowo.site.provider.AccountProvider;
import com.bofowo.site.query.AccountQuery;

import org.apache.ibatis.mapping.StatementType;

import java.util.List;

public interface AccountMapper{
																																																																																																																														
	public String columns="ID,USERNAME,PASSWORD,POINT,IS_SELLER,STATUS,LEVEL,AVATAR,SCORE,WX_USERNAME,ALIPAY_USERNAME,JD_USERNAME";
																																																																																																																														
	public String property="#{id},#{username},#{password},#{point},#{isSeller},#{status},#{level},#{avatar},#{score},#{wxUsername},#{alipayUsername},#{jdUsername}";
																																																																																																																															
	public String update="USERNAME=#{username},PASSWORD=#{password},POINT=#{point},IS_SELLER=#{isSeller},STATUS=#{status},LEVEL=#{level},AVATAR=#{avatar},SCORE=#{score},WX_USERNAME=#{wxUsername},ALIPAY_USERNAME=#{alipayUsername},JD_USERNAME=#{jdUsername}";
	
	@SelectProvider(type=AccountProvider.class,method="getSearchSql")
	@ResultMap(value="com.bofowo.site.mapper.AccountMapper.AccountModelMap")
	public List<AccountModel> fetchPageList(AccountQuery query);

	@SelectProvider(type=AccountProvider.class,method="getSearchSqlCount")
	public int fetchPageCount(AccountQuery query);
	
	@Select("select * from T_ACCOUNT where ID=#{id}")
	@ResultMap(value="com.bofowo.site.mapper.AccountMapper.AccountModelMap")
	public AccountModel getById(long id);
	
	@Delete("delete from T_ACCOUNT where ID=#{id}")
	public void del(long id);
	
	@SelectKey(before=true,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="select nextval('globalVal') as ID")
	@Insert("insert into T_ACCOUNT ("+columns+") values ("+property+")")
	public long insert(AccountModel account);

	@Update("update T_ACCOUNT set "+update+" where ID=#{id}")
	public long update(AccountModel accountModel);

	@Select("select * from T_ACCOUNT where USERNAME=#{currentUserName}")
	@ResultMap(value="com.bofowo.site.mapper.AccountMapper.AccountModelMap")
	public AccountModel getByUsername(String currentUserName); 
}