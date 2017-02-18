package com.bofowo.site.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import com.bofowo.site.model.ShopScrollModel;
import com.bofowo.site.query.ShopScrollQuery;
import com.bofowo.site.provider.ShopScrollProvider;
import org.apache.ibatis.mapping.StatementType;
import java.util.List;

public interface ShopScrollMapper{
																																																																																						
	public String columns="ID,URL,TITLE,DESC_,PIC,SELLER_ID,STATUS,SHOP_ID,PUSH_INDEX";
																																																																																						
	public String property="#{id},#{url},#{title},#{desc},#{pic},#{sellerId},#{status},#{shopId},#{pushIndex}";
																																																																																			
	public String update="URL=#{url},TITLE=#{title},DESC_=#{desc},PIC=#{pic},SELLER_ID=#{sellerId},STATUS=#{status},SHOP_ID=#{shopId},PUSH_INDEX=#{pushIndex}";
	
	@SelectProvider(type=ShopScrollProvider.class,method="getSearchSql")
	@ResultMap(value="com.bofowo.site.mapper.ShopScrollMapper.ShopScrollModelMap")
	public List<ShopScrollModel> fetchPageList(ShopScrollQuery query);

	@SelectProvider(type=ShopScrollProvider.class,method="getSearchSqlCount")
	public int fetchPageCount(ShopScrollQuery query);
	
	@Select("select * from T_SHOP_SCROLL where ID=#{id}")
	@ResultMap(value="com.bofowo.site.mapper.ShopScrollMapper.ShopScrollModelMap")
	public ShopScrollModel getById(long id);
	
	@Delete("delete from T_SHOP_SCROLL where ID=#{id}")
	public void del(long id);
	
	@SelectKey(before=true,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="select nextval('globalVal') as ID")
	@Insert("insert into T_SHOP_SCROLL ("+columns+") values ("+property+")")
	public long insert(ShopScrollModel shopscroll);

	@Update("update T_SHOP_SCROLL set "+update+" where ID=#{id}")
	public long update(ShopScrollModel shopscrollModel);
	@Select("select * from T_SHOP_SCROLL where SHOP_ID=#{shopId} and STATUS='1'")
	@ResultMap(value="com.bofowo.site.mapper.ShopScrollMapper.ShopScrollModelMap")
	public List<ShopScrollModel> getScrollByshopId(int shopId); 
}