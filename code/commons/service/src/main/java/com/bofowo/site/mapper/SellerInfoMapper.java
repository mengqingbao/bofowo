package com.bofowo.site.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import com.bofowo.site.model.SellerInfoModel;
import com.bofowo.site.query.SellerInfoQuery;
import com.bofowo.site.provider.SellerInfoProvider;
import org.apache.ibatis.mapping.StatementType;
import java.util.List;

public interface SellerInfoMapper{
																																																																																																																																																		
	public String columns="ID,NAME,ID_CARD,ID_CARD_PIC,DEPOSIT,TYPE_,STATUS,CREATED_DATE,CREATOR,USER_ID,SHOPER_NAME,COMPANY_CERT,PROXY_CERT,FIST_PROXY_CERT";
																																																																																																																																																		
	public String property="#{id},#{name},#{idCard},#{idCardPic},#{deposit},#{type},#{status},#{createdDate},#{creator},#{userId},#{shoperName},#{companyCert},#{proxyCert},#{fistProxyCert}";
																																																																																																																																																					
	public String update="NAME=#{name},ID_CARD=#{idCard},ID_CARD_PIC=#{idCardPic},DEPOSIT=#{deposit},TYPE_=#{type},STATUS=#{status},CREATED_DATE=#{createdDate},CREATOR=#{creator},USER_ID=#{userId},SHOPER_NAME=#{shoperName},COMPANY_CERT=#{companyCert},PROXY_CERT=#{proxyCert},FIST_PROXY_CERT=#{fistProxyCert}";
	
	@SelectProvider(type=SellerInfoProvider.class,method="getSearchSql")
	@ResultMap(value="com.bofowo.site.mapper.SellerInfoMapper.SellerInfoModelMap")
	public List<SellerInfoModel> fetchPageList(SellerInfoQuery query);

	@SelectProvider(type=SellerInfoProvider.class,method="getSearchSqlCount")
	public int fetchPageCount(SellerInfoQuery query);
	
	@Select("select * from T_SELLER_INFO where ID=#{id}")
	@ResultMap(value="com.bofowo.site.mapper.SellerInfoMapper.SellerInfoModelMap")
	public SellerInfoModel getById(long id);
	
	@Delete("delete from T_SELLER_INFO where ID=#{id}")
	public void del(long id);
	
	@SelectKey(before=true,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="select nextval('globalVal') as ID")
	@Insert("insert into T_SELLER_INFO ("+columns+") values ("+property+")")
	public long insert(SellerInfoModel sellerinfo);

	@Update("update T_SELLER_INFO set "+update+" where ID=#{id}")
	public long update(SellerInfoModel sellerinfoModel); 
	
	@Select("select * from T_SELLER_INFO where USER_ID=#{currentUserName}")
	@ResultMap(value="com.bofowo.site.mapper.SellerInfoMapper.SellerInfoModelMap")
	public SellerInfoModel getBySellerId(String currentUserName); 
}