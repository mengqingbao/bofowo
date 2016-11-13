package com.bofowo.site.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

import com.bofowo.site.model.AlipayAccountModel;
import com.bofowo.site.provider.AlipayAccountProvider;
import com.bofowo.site.query.AlipayAccountQuery;

public interface AlipayAccountMapper{
																																																																		
	public String columns="ID,SELLER_ID,ALI_PAY_ACCOUNT,CREATE_TIME,MODIFY_TIME,STATUS";
																																																																		
	public String property="#{id},#{sellerId},#{aliPayAccount},#{createTime},#{modifyTime},#{status}";
																																																													
	public String update="SELLER_ID=#{sellerId},ALI_PAY_ACCOUNT=#{aliPayAccount},CREATE_TIME=#{createTime},MODIFY_TIME=#{modifyTime},STATUS=#{status}";
	
	@SelectProvider(type=AlipayAccountProvider.class,method="getSearchSql")
	@ResultMap(value="com.bofowo.site.mapper.AlipayAccountMapper.AlipayAccountModelMap")
	public List<AlipayAccountModel> fetchPageList(AlipayAccountQuery query);

	@SelectProvider(type=AlipayAccountProvider.class,method="getSearchSqlCount")
	public int fetchPageCount(AlipayAccountQuery query);
	
	@Select("select * from T_ALIPAY_ACCOUNT where ID=#{id}")
	@ResultMap(value="com.bofowo.site.mapper.AlipayAccountMapper.AlipayAccountModelMap")
	public AlipayAccountModel getById(long id);
	
	@Delete("delete from T_ALIPAY_ACCOUNT where ID=#{id}")
	public void del(long id);
	
	@SelectKey(before=true,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="select nextval('globalVal') as ID")
	@Insert("insert into T_ALIPAY_ACCOUNT ("+columns+") values ("+property+")")
	public long insert(AlipayAccountModel alipayaccount);

	@Update("update T_ALIPAY_ACCOUNT set "+update+" where ID=#{id}")
	public long update(AlipayAccountModel alipayaccountModel);

	
	@Select("select * from T_ALIPAY_ACCOUNT where SELLER_ID=#{sellerId}")
	@ResultMap(value="com.bofowo.site.mapper.AlipayAccountMapper.AlipayAccountModelMap")
	public AlipayAccountModel getBySellerId(String sellerId); 
}