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

import com.bofowo.site.model.ProducimageModel;
import com.bofowo.site.provider.ProducimageProvider;
import com.bofowo.site.query.ProducimageQuery;

import java.util.List;
import java.util.Map;

public interface ProducimageMapper{
																																																																												
	public String columns="ID,ITEM_ID,PATH,STATUS,SELLER_ID,CREATED_DATE,SHOP_ID";
																																																																												
	public String property="#{id},#{itemId},#{path},#{status},#{sellerId},#{createdDate},#{shopId}";
																																																																								
	public String update="ITEM_ID=#{itemId},PATH=#{path},STATUS=#{status},SELLER_ID=#{sellerId},CREATED_DATE=#{createdDate},SHOP_ID=#{shopId}";
	
	@SelectProvider(type=ProducimageProvider.class,method="getSearchSql")
	@ResultMap(value="com.bofowo.site.mapper.ProducimageMapper.ProducimageModelMap")
	public List<ProducimageModel> fetchPageList(ProducimageQuery query);

	@SelectProvider(type=ProducimageProvider.class,method="getSearchSql")
	public int fetchPageCount(ProducimageQuery query);
	
	@Select("select * from T_PRODUCT_IMAGE where ID=#{id}")
	@ResultMap(value="com.bofowo.site.mapper.ProducimageMapper.ProducimageModelMap")
	public ProducimageModel getById(long id);
	
	@Delete("delete from T_PRODUCT_IMAGE where ID=#{id}")
	public void del(long id);
	
	@SelectKey(before=true,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="select nextval('globalVal') as ID")
	@Insert("insert into T_PRODUCT_IMAGE ("+columns+") values ("+property+")")
	public long insert(ProducimageModel producimage);

	@Update("update T_PRODUCT_IMAGE set "+update+" where ID=#{id}")
	public long update(ProducimageModel producimageModel);

	@Select("select * from T_PRODUCT_IMAGE where SELLER_ID=#{sellerId} and ITEM_ID=#{itemId}")
	@ResultMap(value="com.bofowo.site.mapper.ProducimageMapper.ProducimageModelMap")
	public List<ProducimageModel> getSellerUnRefImage(Map condition);

	@Update("update T_PRODUCT_IMAGE set ITEM_ID=#{itemId} where ID=#{id}")
	public void updateStatus(Map condition); 
	
	
	@Select("select * from T_PRODUCT_IMAGE where ITEM_ID=#{itemId}")
	@ResultMap(value="com.bofowo.site.mapper.ProducimageMapper.ProducimageModelMap")
	public List<ProducimageModel> getImagesByPid(Map condition);
}