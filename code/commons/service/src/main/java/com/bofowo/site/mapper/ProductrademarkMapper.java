package com.bofowo.site.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

import com.bofowo.site.model.ProductrademarkModel;
import com.bofowo.site.provider.ProductrademarkProvider;
import com.bofowo.site.query.ProductrademarkQuery;

import java.util.List;

public interface ProductrademarkMapper{
																																																																																																																				
	public String columns="ID,NAME,DESC_,LOGO_IMG,MODIFY_DATE,CREATOR,SHOP_ID,SELLER_ID,T_PRODUCT_TRADEMAR,CREATED_DATE,STATUS";
																																																																																																																				
	public String property="#{id},#{name},#{desc},#{logoImg},#{modifyDate},#{creator},#{shopId},#{sellerId},#{tProductTrademar},#{createdDate},#{status}";
																																																																																																																				
	public String update="NAME=#{name},DESC_=#{desc},LOGO_IMG=#{logoImg},MODIFY_DATE=#{modifyDate},CREATOR=#{creator},SHOP_ID=#{shopId},SELLER_ID=#{sellerId},T_PRODUCT_TRADEMAR=#{tProductTrademar},CREATED_DATE=#{createdDate},STATUS=#{status}";
	
	@SelectProvider(type=ProductrademarkProvider.class,method="getSearchSql")
	@ResultMap(value="com.bofowo.site.mapper.ProductrademarkMapper.ProductrademarkModelMap")
	public List<ProductrademarkModel> fetchPageList(ProductrademarkQuery query);

	@SelectProvider(type=ProductrademarkProvider.class,method="getSearchSqlCount")
	public int fetchPageCount(ProductrademarkQuery query);
	
	@Select("select * from T_PRODUCT_TRADEMARK where ID=#{id}")
	@ResultMap(value="com.bofowo.site.mapper.ProductrademarkMapper.ProductrademarkModelMap")
	public ProductrademarkModel getById(long id);
	
	@Delete("delete from T_PRODUCT_TRADEMARK where ID=#{id}")
	public void del(long id);
	
	@SelectKey(before=true,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="select nextval('globalVal') as ID")
	@Insert("insert into T_PRODUCT_TRADEMARK ("+columns+") values ("+property+")")
	public long insert(ProductrademarkModel productrademark);

	@Update("update T_PRODUCT_TRADEMARK set "+update+" where ID=#{id}")
	public long update(ProductrademarkModel productrademarkModel); 
}