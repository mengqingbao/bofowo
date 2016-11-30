package com.bofowo.site.serviceimpl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bofowo.site.biz.model.CarCountItem;
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
	public void pay(Integer tid,String status) {
		
		TradeModel trade=this.getById(tid);
		if(trade!=null){
		trade.setStatus("1");
		this.update(trade);
		List<OrderModel> orders=orderMapper.getOrderByTradeId(tid);
		for(OrderModel order:orders){
			order.setStatus(status);
			orderMapper.update(order);
		}
		}
		
	}
	@Override
	public Map<String, CarCountItem> submitTrade(String ids,String username) {
		List<CarModel> itemsInCar=carService.getItemsByIds(ids,username);
		Map<String, CarCountItem> maps=CarDivideUtil.toDivide(itemsInCar);
		
		//循环处理划分好的交易，根据买家的不同产生不同的交易 此处需要关联买家的默认收货地址。和卖家的发货地址
		for(Map.Entry<String, CarCountItem> map:maps.entrySet()){
				String sellerId=map.getKey();
				
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
				Integer tradeId=trade.getId();
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
					//删除购物车
					carService.del(carModel.getId());
				}
			}
		return maps;
	}
} 
