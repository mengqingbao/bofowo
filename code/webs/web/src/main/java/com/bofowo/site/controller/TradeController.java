/**
 * Project Name:lymall-management
 * File Name:ProductController.java
 * Package Name:com.bofowo.site.controller
 * Date:2016年2月25日下午8:50:17
 * Copyright (c) 2016,Shanghai bofowo Technology co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bofowo.biz.util.TradeProcessorUtil;
import com.bofowo.core.handler.HandlerChain;
import com.bofowo.core.trade.support.factory.TradeHandlerFactory;
import com.bofowo.site.biz.model.TradeCountItem;
import com.bofowo.site.model.BuyerAddressModel;
import com.bofowo.site.model.CarModel;
import com.bofowo.site.model.CustomerServiceModel;
import com.bofowo.site.model.OrderModel;
import com.bofowo.site.model.ProductModel;
import com.bofowo.site.model.ShopModel;
import com.bofowo.site.model.TradeModel;
import com.bofowo.site.service.BuyerAddressService;
import com.bofowo.site.service.CarService;
import com.bofowo.site.service.CategoryService;
import com.bofowo.site.service.CustomerServiceService;
import com.bofowo.site.service.OrderService;
import com.bofowo.site.service.ProducimageService;
import com.bofowo.site.service.ProductService;
import com.bofowo.site.service.ShopService;
import com.bofowo.site.service.TradeService;
import com.bofowo.util.TradeConstant;

import common.security.login.CurrentUserUtil;
import common.util.BeanUtils;
import common.util.LayoutType;
import common.util.StringUtil;
import common.web.BaseController;

/**
 * ClassName:ProductController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年2月25日 下午8:50:17 <br/>
 * @author   mqb
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Controller
public class TradeController extends BaseController {
	@Resource
	private ProductService productService;
	@Resource
	private ProducimageService producimageService;
	@Resource
	private CategoryService categoryService;
	@Resource
	private TradeService tradeService;
	@Resource
	private OrderService orderService;
	@Resource
	private CarService carService;
	@Resource
	private TradeHandlerFactory tradeHandlerFactory;
	@Resource
	private BuyerAddressService buyerAddressService;
	@Resource
	private CustomerServiceService customerServiceService;
	@Resource
	private ShopService shopService;
	@RequestMapping("order-cancel")
	public String backOrder(ModelMap model,Integer orderId,String status){
		OrderModel order=orderService.getById(orderId);
		order.setStatus(status);
		orderService.update(order);
		model.put("status", true);
		return "common/json";
	}
	@RequestMapping(value="processTradeAction")
	public String processTradeAction(ModelMap model,String tradeId,Integer orderId,String status,String actionType){
		Map<String,String> data=new HashMap<String,String>();
		data.put("tradeIds", tradeId);
		data.put("status", status);
		data.put("orderId", String.valueOf(orderId));
		data.put("currentUserId", CurrentUserUtil.getCurrentUserName());
		data.put("actionType",actionType);
		HandlerChain chains=tradeHandlerFactory.getHandlerChain("");
		chains.doExecute(data, chains);
		data.get("");
		model.put("json", JSONObject.fromObject(data).toString());
		return "common/json";
	}
	
	/**
	 * 
	 * 结算购物车，分单处理 提交订单，保存数据库落地。
	 * @author mqb
	 * @param ids
	 * @param model
	 * @return
	 * @since JDK 1.7
	 */
	@RequestMapping("trade_add_batch")
	public String addBatch(String submitItemIds,ModelMap model){
		submitItemIds=submitItemIds.substring(0, submitItemIds.lastIndexOf(",")).replace(",", "\",\"");
		submitItemIds="\""+submitItemIds+"\"";
		//查询所有提交的购物车内容
		String username=CurrentUserUtil.getCurrentUserName();
		Map<String, TradeCountItem> map=tradeService.submitTrade(submitItemIds, username);
		model.put("items", map);
		this.setLayout(LayoutType.PAY);
		List<BuyerAddressModel> buyerAddress=buyerAddressService.getBuyerAddress(username);
		model.put("addrs", buyerAddress);
		return "buyer/trade_pay_batch";
	}
	
	@RequestMapping("member-pay")
	public String pay(String tradeIds){
		String[] tids=tradeIds.split(",");
		String username=CurrentUserUtil.getCurrentUserName();
		for(String tidstr:tids){
			if(!StringUtil.isEmpty(tidstr)){
				Integer tid=Integer.valueOf(tidstr);
				tradeService.pay(tid, TradeConstant.PAYED,username);
			}
			
		}
		
		return "redirect:/member-pay-result.htm?tradeIds="+tradeIds;
	}
	
	@RequestMapping("member-pay-result")
	public String payResult(String tradeIds){
		this.setLayout(LayoutType.UAM);
		return "buyer/pay_waiting_result";
	}
	/**
	 * 支付宝回调接口，订单确认
	 */
	@RequestMapping("alipay-call-back")
	public String payBackCallUrl(String ids,String flage,ModelMap model){
		Map<String,String> result=new HashMap<String,String>();
		result.put("code", "1001");
		result.put("message", "success");
		model.put("json", JSONObject.fromObject(result).toString());
		return "success";
	}
	
	
	//保存邮寄地址同时向第三方支付发出订单信息 
	//购物车提交的支付订单。
	//我的订单提交，选择支付内容。
	@RequestMapping("save-payway-address")
	public String savePaywayAndAddress(String tradeIds,Integer receiverAddrId,String payWay){
			String[] idstrs=tradeIds.split(",");
			for(String idstr:idstrs){
				if(StringUtil.isEmpty(idstr)){
					continue;
				}
				Integer id=Integer.valueOf(idstr);
				TradeModel tradeModel=tradeService.getById(id);
				BuyerAddressModel bam=buyerAddressService.getById(receiverAddrId);
				tradeModel.setReceiverName(bam.getRealName());
				tradeModel.setPayWay(payWay);
				tradeModel.setReceiverProvince(bam.getProvince());
				tradeModel.setReceiverCity(bam.getCity());
				tradeModel.setReceiverArea(bam.getArea());
				tradeModel.setReceiverAddr(bam.getAddress());
				tradeModel.setReceiverPostid(bam.getPostCode());
				tradeModel.setReceiverTele(bam.getTele());
				tradeService.update(tradeModel);
			}
		return "redirect:/pay.htm?tradeIds="+tradeIds;
	}
	
	
	/**
	 * 立即购买产品，单独购买。
	 * @author mqb
	 * @param goodsId
	 * @param quantity
	 * @param title
	 * @param spec
	 * @param model
	 * @return
	 * @since JDK 1.7
	 */
	@RequestMapping("trade_add")
	public String add(String submitItemIds,ModelMap model){
		submitItemIds=submitItemIds.substring(0, submitItemIds.lastIndexOf(",")).replace(",", "\",\"");
		submitItemIds="\""+submitItemIds+"\"";
		//查询所有提交的购物车内容
		String username=CurrentUserUtil.getCurrentUserName();
		Map<String, TradeCountItem> map=tradeService.submitTrade(submitItemIds, username);
		model.put("items", map);
		this.setLayout(LayoutType.CAR);
		List<BuyerAddressModel> buyerAddress=buyerAddressService.getBuyerAddress(username);
		model.put("addrs", buyerAddress);
		return "buyer/trade_pay_batch";
	}
	
	@RequestMapping("member_buy_now")
	public String buyNow(String goodsId,ModelMap model,Integer quantity,String spec){
		String username=CurrentUserUtil.getCurrentUserName();
		ProductModel pm=productService.getById(Long.valueOf(goodsId));
		model.put("item", pm);
		model.put("spec", spec);
		this.setLayout(LayoutType.CAR);
		List<BuyerAddressModel> buyerAddress=buyerAddressService.getBuyerAddress(username);
		model.put("addrs", buyerAddress);
		return "buyer/trade_pay_review";
	}
	
	//确认订单action
	@RequestMapping("member_create_trade_immediately")
	public String buyNowAddTrade(String goodsId,ModelMap model,Integer quantity,String spec,Integer receiverAddrId,String payWay){
		String username=CurrentUserUtil.getCurrentUserName();
		BuyerAddressModel buyerAddress=buyerAddressService.getById(receiverAddrId);
		ProductModel pm=productService.getById(Long.valueOf(goodsId));
		ShopModel shop=shopService.getByUsername(pm.getSellerId());
		TradeModel trade=new TradeModel();
		trade.setBuyerId(username);
		trade.setNum(quantity);
		//tm.setShopName(pm.getShopId());
		trade.setCreatedTime(new Date());
		trade.setBuyerId(username);
		trade.setSellerId(pm.getSellerId());
		//order.setBuyerId(CurrentUserUtil.getCurrentUserName());
		trade.setStatus(TradeConstant.WAITING_PAY);
		trade.setTitle(pm.getName());
		trade.setShopName(shop.getName());
		//设置收件人
		trade.setReceiverProvince(buyerAddress.getProvince());
		trade.setReceiverCity(buyerAddress.getCity());
		trade.setReceiverArea(buyerAddress.getArea());
		trade.setReceiverAddr(buyerAddress.getAddress());
		trade.setReceiverPostid(buyerAddress.getPostCode());
		trade.setReceiverTele(buyerAddress.getTele());
		//设置收件人 end
		trade.setPic(pm.getImages());
		trade.setPayWay(payWay);
		trade.setCreatedTime(new Date());
		trade.setStatus("0");
		trade.setTotal(pm.getShopPrice()*quantity);
		trade.setRealPay(pm.getShopPrice()*quantity);
		tradeService.insert(trade);
		Integer tradeId=trade.getId();
		String orderIds="";
		//跟新添加order信息
			OrderModel order=new OrderModel();
			order.setTid(trade.getId());
			order.setPayWay(payWay);
			order.setTitle(pm.getName());
			order.setCreatedTime(new Date());
			order.setSellerId(pm.getSellerId());
			order.setBuyerId(username);
			order.setPic(pm.getImages());
			order.setPrice(pm.getShopPrice());
			order.setProperties(spec);
			order.setNum(quantity);
			order.setItemId(pm.getId());
			order.setStatus("0");
			orderService.insert(order);
			
			trade.setOrderIds(String.valueOf(order.getId()));
			tradeService.update(trade);
		//------------插入交易数据结束------------
			
			model.put("tradeId", trade.getId());
			model.put("spec", spec);
			this.setLayout(LayoutType.PAY);
			
			return "redirect:/member-pay.htm?tradeIds="+trade.getId();
	}
	
		//从购物车中结算单个商品
		@RequestMapping("member_create_trade_immediately_from_car")
		public String buyNowAddTradeFromCar(String goodsId,ModelMap model,Integer quantity,String spec,Integer receiverAddrId,String payWay){
			String username=CurrentUserUtil.getCurrentUserName();
			BuyerAddressModel buyerAddress=buyerAddressService.getById(receiverAddrId);
			ProductModel pm=productService.getById(Long.valueOf(goodsId));
			ShopModel shop=shopService.getByUsername(pm.getSellerId());
			TradeModel trade=new TradeModel();
			trade.setBuyerId(username);
			trade.setNum(quantity);
			//tm.setShopName(pm.getShopId());
			trade.setCreatedTime(new Date());
			trade.setBuyerId(username);
			trade.setSellerId(pm.getSellerId());
			//order.setBuyerId(CurrentUserUtil.getCurrentUserName());
			trade.setStatus(TradeConstant.WAITING_PAY);
			trade.setTitle(pm.getName());
			trade.setShopName(shop.getName());
			//设置收件人
			trade.setReceiverProvince(buyerAddress.getProvince());
			trade.setReceiverCity(buyerAddress.getCity());
			trade.setReceiverArea(buyerAddress.getArea());
			trade.setReceiverAddr(buyerAddress.getAddress());
			trade.setReceiverPostid(buyerAddress.getPostCode());
			trade.setReceiverTele(buyerAddress.getTele());
			//设置收件人 end
			trade.setPic(pm.getImages());
			trade.setPayWay(payWay);
			trade.setCreatedTime(new Date());
			trade.setStatus("0");
			trade.setTotal(pm.getShopPrice()*quantity);
			trade.setRealPay(pm.getShopPrice()*quantity);
			tradeService.insert(trade);
			Integer tradeId=trade.getId();
			String orderIds="";
			//跟新添加order信息
				OrderModel order=new OrderModel();
				order.setTid(trade.getId());
				order.setPayWay(payWay);
				order.setTitle(pm.getName());
				order.setCreatedTime(new Date());
				order.setSellerId(pm.getSellerId());
				order.setBuyerId(username);
				order.setPic(pm.getImages());
				order.setPrice(pm.getShopPrice());
				order.setProperties(spec);
				order.setNum(quantity);
				order.setItemId(pm.getId());
				order.setStatus("0");
				orderService.insert(order);
				
				trade.setOrderIds(String.valueOf(order.getId()));
				tradeService.update(trade);
			//------------插入交易数据结束------------
				
				model.put("tradeId", trade.getId());
				model.put("spec", spec);
				this.setLayout(LayoutType.PAY);
				
				//删除购物车内容
				//CarModel car=carService.getByItemId(Integer.valueOf(goodsId), username);
				carService.deleteByIdAndUsername(Integer.valueOf(goodsId), username);
				return "redirect:/member-pay.htm?tradeIds="+trade.getId();
		}
	
	/**
	 * 立即购买相应事件
	 * @author mqb
	 */
	@RequestMapping("member_checkout_immediately")
	public String checkoutImmediately(String goodsId,ModelMap model,Integer quantity,String spec){
		
		//查询所有提交的购物车内容
		String username=CurrentUserUtil.getCurrentUserName();
		ProductModel pm=productService.getById(Long.valueOf(goodsId));
		model.put("item", pm);
		ShopModel shopModel=shopService.getById(pm.getShopId());
		model.put("shop", shopModel);
		this.setLayout(LayoutType.PAY);
		List<BuyerAddressModel> buyerAddress=buyerAddressService.getBuyerAddress(username);
		model.put("addrs", buyerAddress);
		model.put("quantity", quantity);
		model.put("goodsId", goodsId);
		model.put("spec", spec);
		model.put("total", pm.getShopPrice()*quantity);
		return "buyer/buyer_checkout_immediately";
	}
	
	@RequestMapping("member_checkout_immediately_from_car")
	public String checkoutImmediatelyFromCar(String goodsId,ModelMap model,Integer quantity,String spec){
		
		//查询所有提交的购物车内容
		String username=CurrentUserUtil.getCurrentUserName();
		ProductModel pm=productService.getById(Long.valueOf(goodsId));
		model.put("item", pm);
		ShopModel shopModel=shopService.getById(pm.getShopId());
		model.put("shop", shopModel);
		this.setLayout(LayoutType.PAY);
		List<BuyerAddressModel> buyerAddress=buyerAddressService.getBuyerAddress(username);
		model.put("addrs", buyerAddress);
		model.put("quantity", quantity);
		model.put("goodsId", goodsId);
		model.put("spec", spec);
		model.put("total", pm.getShopPrice()*quantity);
		return "buyer/buyer_checkout_immediately_from_car";
	}
	
	/**
	 * orderid 更新 订单信息。 只在我的订单提交支付请求是调用。
	 * @author mqb
	 * @param Ids
	 * @return
	 * @since JDK 1.7
	 */
	@RequestMapping("count-update-trade-by-orderids")
	public String countAndUploadTradeByOrderIds(String orderIds,ModelMap model){
		String ids=orderIds.substring(0, orderIds.lastIndexOf(","));
		String username=CurrentUserUtil.getCurrentUserName();
		List<OrderModel> orders=orderService.getOrderByOrderIds(ids,username);
		Map<Integer,List<OrderModel>> orderMap=TradeProcessorUtil.divideOrder(orders);
		List<Integer> tradeId=tradeService.updateTradeStatus(orderMap,orderIds);
		model.put("items", orders);
		String idstrs="";
		for(Integer id:tradeId){
			if(idstrs==""||"".equals(idstrs)){
				idstrs=String.valueOf(id);
			}else{
				idstrs+=","+id;
			}
		}
		return "redirect:/pay.htm?tradeIds="+idstrs;
	}
	@RequestMapping("trade_add_pay")
	public String tradde_add_pay(Integer goodsId,Integer quantity,ModelMap model){
		if(quantity<1||goodsId<0){
			return this.redirectRefer(request);
		}
		ProductModel pm=productService.getById(goodsId);
		TradeModel trade=new TradeModel();
		OrderModel order=new OrderModel();
		trade.setProductId(goodsId);
		order.setItemId(goodsId);
		//trade.setBuyerId(CurrentUserUtil.getCurrentUserName());
		//order.setBuyerId(CurrentUserUtil.getCurrentUserName());
		trade.setStatus(TradeConstant.WAITING_PAY);
		trade.setTitle(pm.getName());
		order.setPrice(pm.getShopPrice());
		order.setNum(quantity);
		trade.setRealPay(pm.getShopPrice()*quantity);
		trade.setPic(pm.getImages());
		trade.setPayWay("taobao");
		trade.setCreatedTime(new Date());
		tradeService.insert(trade);
		order.setTid(trade.getId());
		orderService.insert(order);
		if("taobao".equals(trade.getPayWay())){
			return "redirect:alipay.htm?tid="+trade.getId();
		}else if("weixin".equals(trade.getPayWay())){
			return "redirect:weixin_pay.htm?tid="+trade.getId();
		}
		return this.redirectRefer(request);
	}
	
	@RequestMapping("customer-service")
	public String customerService(String tradeId,ModelMap model){
		this.setLayout(LayoutType.BUYER);
		Integer id=Integer.valueOf(tradeId);
		TradeModel trade=tradeService.getById(id);
		model.put("trade", trade);
		List<OrderModel> orders=orderService.getOrderByTid(id);
		model.put("orders", orders);
		return "buyer/customer_service";
	}
	
	@RequestMapping("customer-service-submit")
	public String customerServiceSubmit(String tradeId,ModelMap model,String orderIds,String type,String question){
		this.setLayout(LayoutType.BUYER);
		String username=CurrentUserUtil.getCurrentUserName();
		Integer id=Integer.valueOf(tradeId);
		TradeModel trade=tradeService.getById(id);
		model.put("trade", trade);
		List<OrderModel> orders=orderService.getOrderByOrderIds(orderIds, username);
		model.put("orders", orders);
		String[] orderStrIds=orderIds.split(",");
		if(orderStrIds.length!=orders.size()){
			
		}
		for(OrderModel order:orders){
			order.setStatus("8");
			orderService.update(order);
			CustomerServiceModel cs=new CustomerServiceModel();
			cs.setName(order.getTitle());
			cs.setCreatedTime(new Date());
			cs.setItemId(order.getItemId());
			cs.setPic(order.getPic());
			cs.setPrice(String.valueOf(order.getPrice()));
			cs.setSellerId(order.getSellerId());
			cs.setBuyerId(username);
			cs.setType(type);
			cs.setTradeId(order.getTid());
			cs.setOrderId(order.getId());
			cs.setQuestion(question);
			customerServiceService.insert(cs);
		}
		return "redirect:/consumer-myitem.htm";
	}
	
	@RequestMapping(value="sendExpress")
	public String sendExpress(ModelMap model,String tradeId,Integer orderId,String status,String actionType){
		Map<String,String> data=new HashMap<String,String>();
		data.put("tradeIds", tradeId);
		data.put("status", TradeConstant.WAITING_SELLER_SEND);
		data.put("currentUserId", CurrentUserUtil.getCurrentUserName());
		data.put("actionType","expressAction");
		HandlerChain chains=tradeHandlerFactory.getHandlerChain("");
		chains.doExecute(data, chains);
		data.get("");
		model.put("json", JSONObject.fromObject(data).toString());
		return this.redirectRefer(request);
	}
}

