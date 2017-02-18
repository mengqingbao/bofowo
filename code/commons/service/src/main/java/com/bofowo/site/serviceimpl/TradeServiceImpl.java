package com.bofowo.site.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bofowo.biz.util.TradeCountModel;
import com.bofowo.biz.util.TradeProcessorUtil;
import com.bofowo.site.biz.model.CarCountItem;
import com.bofowo.site.biz.model.TradeCountItem;
import com.bofowo.site.mapper.OrderMapper;
import com.bofowo.site.mapper.TradeMapper;
import com.bofowo.site.model.CarModel;
import com.bofowo.site.model.OrderModel;
import com.bofowo.site.model.TradeModel;
import com.bofowo.site.query.TradeQuery;
import com.bofowo.site.service.CarService;
import com.bofowo.site.service.OrderService;
import com.bofowo.site.service.TradeService;
import com.bofowo.site.util.CarDivideUtil;
import com.bofowo.util.TradeConstant;
import common.util.BeanUtils;


@Component("tradeService")
public class TradeServiceImpl implements TradeService{
	@Autowired
	private TradeMapper tradeMapper;
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private CarService carService;
	
	@Autowired
	private OrderService orderService;
	
	public List<TradeModel> fetchPage(TradeQuery query){
		return tradeMapper.fetchPageList(query);
	}
	public int fetchPageCount(TradeQuery query){
		return tradeMapper.fetchPageCount(query);
	}
	public TradeModel getById(long id){
		return tradeMapper.getById(id);
	}
	public void del(long id){
		tradeMapper.del(id);
	}
	public long insert(TradeModel trade){
		return tradeMapper.insert(trade);
	}
	public long update(TradeModel trade){
		return tradeMapper.update(trade);
	}
	@Override
	public void pay(Integer tid,String status,String username) {
		
		TradeModel trade=this.getById(tid);
		if(trade!=null){
		trade.setStatus(status);
		this.update(trade);
		Map<String,String> condition=new HashMap<String,String>();
		condition.put("username",username);
		condition.put("ids", trade.getOrderIds());
		List<OrderModel> orders=orderMapper.getOrderByOrderIds(condition);
		for(OrderModel order:orders){
			order.setStatus(status);
			orderMapper.update(order);
		}
		}
		
	}
	@Override
	public Map<String, TradeCountItem> submitTrade(String ids,String username) {
		List<CarModel> itemsInCar=carService.getItemsByIds(ids,username);
		Map<String, CarCountItem> maps=CarDivideUtil.toDivide(itemsInCar);
		Map<String, TradeCountItem> result=new HashMap<String,TradeCountItem>();
		//循环处理划分好的交易，根据买家的不同产生不同的交易 此处需要关联买家的默认收货地址。和卖家的发货地址
		for(Map.Entry<String, CarCountItem> map:maps.entrySet()){
				String sellerId=map.getKey();
				TradeCountItem tci=new TradeCountItem();
				CarCountItem carCountItem=map.getValue();
				TradeModel trade=new TradeModel();
				trade.setBuyerId(username);
				trade.setSellerId(sellerId);
				//order.setBuyerId(CurrentUserUtil.getCurrentUserName());
				trade.setStatus(TradeConstant.WAITING_PAY);
				trade.setTitle(carCountItem.getItems().get(0).getTitle());
				
				trade.setPic(carCountItem.getItems().get(0).getPic());
				trade.setPayWay("taobao");
				trade.setCreatedTime(new Date());
				trade.setStatus("0");
				trade.setTotal(carCountItem.getTotalPrice());
				trade.setRealPay(carCountItem.getTotalPrice());
				this.insert(trade);
				tci.setTradeModel(trade);
				Integer tradeId=trade.getId();
				String orderIds="";
				for(CarModel carModel:carCountItem.getItems()){
					OrderModel order=new OrderModel();
					order.setTid(trade.getId());
					order.setPayWay("taobao");
					order.setTitle(carModel.getTitle());
					order.setCreatedTime(new Date());
					order.setSellerId(carModel.getSellerId());
					order.setBuyerId(username);
					order.setPic(carModel.getPic());
					order.setPrice(carModel.getPrice());
					order.setProperties(carModel.getProperties());
					order.setNum(carModel.getNum());
					order.setItemId(carModel.getItemId());
					order.setStatus("0");
					orderService.insert(order);
					tci.addOrder(order);
					if("".equals(orderIds)){
						orderIds=String.valueOf(order.getId());
					}else{
						orderIds+=","+String.valueOf(order.getId());
					}
					//删除购物车
					carService.del(carModel.getId());
				}
				trade.setOrderIds(orderIds);
				this.update(trade);
				result.put(sellerId, tci);
			}
		return result;
	}
	
	//重新统计交易金表和标题
	@Override
	public List<Integer> updateTradeStatus(
			Map<Integer, List<OrderModel>> orderMap,String orderIds) {
		List<Integer> result=new ArrayList<Integer>();
		for(Map.Entry<Integer,List<OrderModel>> map:orderMap.entrySet()){
			Integer id=map.getKey();
			List<OrderModel> list=map.getValue();
			List<OrderModel> orders=orderService.getOrderByTid(id);
			if(list.size()!=orders.size()){
				TradeModel trade=this.getById(id);
				updateTrade(list,trade,result,orderIds);
			}else{
				result.add(id);
			}
		}
		return result;
	}
	
	//内部调用
	private void updateTrade(List<OrderModel> orders,TradeModel tradeModel,List<Integer> result,String orderIds){
		TradeCountModel tradeCount= TradeProcessorUtil.countTrade(orders);
		BeanUtils.copyProperties(tradeCount, tradeModel);
		tradeModel.setOrderIds(orderIds);
		this.update(tradeModel);
		result.add(tradeModel.getId());
	}
} 
