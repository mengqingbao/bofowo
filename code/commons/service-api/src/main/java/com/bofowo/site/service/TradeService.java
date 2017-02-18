package com.bofowo.site.service;

import java.util.List;
import java.util.Map;

import com.bofowo.site.biz.model.TradeCountItem;
import com.bofowo.site.model.OrderModel;
import com.bofowo.site.model.TradeModel;
import com.bofowo.site.query.TradeQuery;


public interface TradeService{
	public List<TradeModel> fetchPage(TradeQuery query);
	public int fetchPageCount(TradeQuery query);
	public TradeModel getById(long id);
	public void del(long id);
	public long insert(TradeModel trade);
	public long update(TradeModel trade);
	/**
	 * 
	 * pay:(这里用一句话描述这个方法的作用). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author mqb
	 * @param tid
	 * @param status 0 等待支付 1：已支付 2：已发货 3：已签收。4：以评论
	 * @since JDK 1.7
	 */
	public void pay(Integer tid,String status,String username) ;
	
	public Map<String, TradeCountItem> submitTrade(String ids,String username);
	/**
	 * 更新交易订单信息。交易的子订单全选，则trade交易总价不变。
	 * <br>trade 子订单未全选，则更新订单的单价信息，和交易title。
	 * <br>返回tradeId 的数组。
	 * @author mqb
	 * @param orderMap
	 * @return
	 * @since JDK 1.7
	 */
	public List<Integer> updateTradeStatus(
			Map<Integer, List<OrderModel>> orderMap,String orderIds);
} 
