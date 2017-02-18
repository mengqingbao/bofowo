package com.bofowo.site.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import com.bofowo.site.model.ProductaglibModel;
import com.bofowo.site.query.ProductaglibQuery;
import com.bofowo.site.provider.ProductaglibProvider;
import org.apache.ibatis.mapping.StatementType;
import java.util.List;

public interface ProductaglibMapper{
																																																																																																										
	public String columns="ID,PRODUCT_ID,TAGLIB,ABLE_DATA,TAGLIB_ID,TYPE_,ORDER_,STATUS,SELLER_ID,SHOP_ID";
																																																																																																										
	public String property="#{id},#{productId},#{taglib},#{ableData},#{taglibId},#{type},#{order},#{status},#{sellerId},#{shopId}";
																																																																																																									
	public String update="PRODUCT_ID=#{productId},TAGLIB=#{taglib},ABLE_DATA=#{ableData},TAGLIB_ID=#{taglibId},TYPE_=#{type},ORDER_=#{order},STATUS=#{status},SELLER_ID=#{sellerId},SHOP_ID=#{shopId}";
	
	@SelectProvider(type=ProductaglibProvider.class,method="getSearchSql")
	@ResultMap(value="com.bofowo.site.mapper.ProductaglibMapper.ProductaglibModelMap")
	public List<ProductaglibModel> fetchPageList(ProductaglibQuery query);

	@SelectProvider(type=ProductaglibProvider.class,method="getSearchSqlCount")
	public int fetchPageCount(ProductaglibQuery query);
	
	@Select("select * from T_PRODUCT_TAGLIB where ID=#{id}")
	@ResultMap(value="com.bofowo.site.mapper.ProductaglibMapper.ProductaglibModelMap")
	public ProductaglibModel getById(long id);
	
	@Delete("delete from T_PRODUCT_TAGLIB where ID=#{id}")
	public void del(long id);
	
	@SelectKey(before=true,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="select nextval('globalVal') as ID")
	@Insert("insert into T_PRODUCT_TAGLIB ("+columns+") values ("+property+")")
	public long insert(ProductaglibModel productaglib);

	@Update("update T_PRODUCT_TAGLIB set "+update+" where ID=#{id}")
	public long update(ProductaglibModel productaglibModel); 
}