package com.bofowo.site.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import com.bofowo.site.model.CustomerServiceModel;
import com.bofowo.site.query.CustomerServiceQuery;
import com.bofowo.site.provider.CustomerServiceProvider;
import org.apache.ibatis.mapping.StatementType;
import java.util.List;

public interface CustomerServiceMapper{
																																																																																																																																																																																																																																												
	public String columns="ID,BUYER_ID,SELLER_ID,TRADE_ID,ORDER_ID,NAME,PIC,PRICE,QUESTION,REPLAY,RESULT,SERVICER,TYPE,ITEM_ID,CREATED_TIME,REPLAY_TIME,END_TIME,SHOP_ID,SHOP_NAME,REPALY_RATE,STATUS,EXPRESS_CODE,EXPRESS_CONTENT";
																																																																																																																																																																																																																																												
	public String property="#{id},#{buyerId},#{sellerId},#{tradeId},#{orderId},#{name},#{pic},#{price},#{question},#{replay},#{result},#{servicer},#{type},#{itemId},#{createdTime},#{replayTime},#{endTime},#{shopId},#{shopName},#{repalyRate},#{status},#{expressCode},#{expressContent}";
																																																																																																																																																																																																																																																								
	public String update="BUYER_ID=#{buyerId},SELLER_ID=#{sellerId},TRADE_ID=#{tradeId},ORDER_ID=#{orderId},NAME=#{name},PIC=#{pic},PRICE=#{price},QUESTION=#{question},REPLAY=#{replay},RESULT=#{result},SERVICER=#{servicer},TYPE=#{type},ITEM_ID=#{itemId},CREATED_TIME=#{createdTime},REPLAY_TIME=#{replayTime},END_TIME=#{endTime},SHOP_ID=#{shopId},SHOP_NAME=#{shopName},REPALY_RATE=#{repalyRate},STATUS=#{status},EXPRESS_CODE=#{expressCode},EXPRESS_CONTENT=#{expressContent}";
	
	@SelectProvider(type=CustomerServiceProvider.class,method="getSearchSql")
	@ResultMap(value="com.bofowo.site.mapper.CustomerServiceMapper.CustomerServiceModelMap")
	public List<CustomerServiceModel> fetchPageList(CustomerServiceQuery query);

	@SelectProvider(type=CustomerServiceProvider.class,method="getSearchSqlCount")
	public int fetchPageCount(CustomerServiceQuery query);
	
	@Select("select * from T_CUSTOMER_SERVICE where ID=#{id}")
	@ResultMap(value="com.bofowo.site.mapper.CustomerServiceMapper.CustomerServiceModelMap")
	public CustomerServiceModel getById(long id);
	
	@Delete("delete from T_CUSTOMER_SERVICE where ID=#{id}")
	public void del(long id);
	
	@SelectKey(before=true,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="select nextval('globalVal') as ID")
	@Insert("insert into T_CUSTOMER_SERVICE ("+columns+") values ("+property+")")
	public long insert(CustomerServiceModel customerservice);

	@Update("update T_CUSTOMER_SERVICE set "+update+" where ID=#{id}")
	public long update(CustomerServiceModel customerserviceModel); 
}