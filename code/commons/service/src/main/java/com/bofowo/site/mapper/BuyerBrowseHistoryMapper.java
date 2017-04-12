package com.bofowo.site.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.bofowo.site.model.BuyerBrowseHistoryModel;
import com.bofowo.site.query.BuyerBrowseHistoryQuery;
import com.bofowo.site.provider.BuyerBrowseHistoryProvider;

import org.apache.ibatis.mapping.StatementType;

import java.util.List;
import java.util.Map;

public interface BuyerBrowseHistoryMapper{
																																																								
	public String columns="PID,CREATED_DATE,BUYER_ID,TIMES,LAST_VISIT_DATE";
																																																								
	public String property="#{pid},#{createdDate},#{buyerId},#{times},#{lastVisitDate}";
																																																										
	public String update="PID=#{pid},CREATED_DATE=#{createdDate},BUYER_ID=#{buyerId},TIMES=#{times},LAST_VISIT_DATE=#{lastVisitDate}";
	
	@Insert("insert into T_BUYER_BROWSE_HISTORY ("+columns+") values ("+property+")")
	public long insert(BuyerBrowseHistoryModel buyerbrowsehistory);

	@Update("update T_BUYER_BROWSE_HISTORY set "+update+" where PID=#{pid} and BUYER_ID=#{buyerId}")
	public long update(BuyerBrowseHistoryModel buyerbrowsehistoryModel);
	
	@Select("select * from T_BUYER_BROWSE_HISTORY where PID=#{pid} and BUYER_ID=#{buyerId}")
	@ResultMap(value="com.bofowo.site.mapper.BuyerBrowseHistoryMapper.BuyerBrowseHistoryModelMap")
	public BuyerBrowseHistoryModel getById(Map<String, String> condition); 
}