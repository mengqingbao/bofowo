package com.bofowo.site.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import com.bofowo.site.model.ProducchannelModel;
import com.bofowo.site.query.ProducchannelQuery;
import com.bofowo.site.provider.ProducchannelProvider;
import org.apache.ibatis.mapping.StatementType;
import java.util.List;

public interface ProducchannelMapper{
																																																								
	public String columns="ID,CHANNEL,PRODUCT_ID,SHOP_ID,SELLER_ID";
																																																								
	public String property="#{id},#{channel},#{productId},#{shopId},#{sellerId}";
																																																		
	public String update="CHANNEL=#{channel},PRODUCT_ID=#{productId},SHOP_ID=#{shopId},SELLER_ID=#{sellerId}";
	
	@SelectProvider(type=ProducchannelProvider.class,method="getSearchSql")
	@ResultMap(value="com.bofowo.site.mapper.ProducchannelMapper.ProducchannelModelMap")
	public List<ProducchannelModel> fetchPageList(ProducchannelQuery query);

	@SelectProvider(type=ProducchannelProvider.class,method="getSearchSqlCount")
	public int fetchPageCount(ProducchannelQuery query);
	
	@Select("select * from T_PRODUCT_CHANNEL where ID=#{id}")
	@ResultMap(value="com.bofowo.site.mapper.ProducchannelMapper.ProducchannelModelMap")
	public ProducchannelModel getById(long id);
	
	@Delete("delete from T_PRODUCT_CHANNEL where ID=#{id}")
	public void del(long id);
	
	@SelectKey(before=true,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="select nextval('globalVal') as ID")
	@Insert("insert into T_PRODUCT_CHANNEL ("+columns+") values ("+property+")")
	public long insert(ProducchannelModel producchannel);

	@Update("update T_PRODUCT_CHANNEL set "+update+" where ID=#{id}")
	public long update(ProducchannelModel producchannelModel); 
}