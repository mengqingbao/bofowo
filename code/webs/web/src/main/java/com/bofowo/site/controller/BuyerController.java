/**
 * Project Name:lymall-web
 * File Name:BuyerController.java
 * Package Name:com.bofowo.site.controller
 * Date:2016年3月5日下午11:48:01
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

import com.bofowo.site.biz.model.CarCountItem;
import com.bofowo.site.model.AccountModel;
import com.bofowo.site.model.BuyerAddressModel;
import com.bofowo.site.model.BuyerCollectionModel;
import com.bofowo.site.model.CarModel;
import com.bofowo.site.model.MyCouponModel;
import com.bofowo.site.model.OrderModel;
import com.bofowo.site.model.ProductModel;
import com.bofowo.site.model.TradeModel;
import com.bofowo.site.query.BuyerAddressQuery;
import com.bofowo.site.query.BuyerCollectionQuery;
import com.bofowo.site.query.CarQuery;
import com.bofowo.site.query.MyCouponQuery;
import com.bofowo.site.query.TradeQuery;
import com.bofowo.site.service.AccountService;
import com.bofowo.site.service.BuyerAddressService;
import com.bofowo.site.service.BuyerCollectionService;
import com.bofowo.site.service.CarService;
import com.bofowo.site.service.MyCouponService;
import com.bofowo.site.service.OrderService;
import com.bofowo.site.service.ProductService;
import com.bofowo.site.service.TradeService;
import com.bofowo.site.util.CarDivideUtil;

import common.MD5Util;
import common.security.login.CurrentUserUtil;
import common.util.LayoutType;
import common.util.StringUtil;
import common.web.BaseController;

/**
 * ClassName:BuyerController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年3月5日 下午11:48:01 <br/>
 * @author   mqb
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Controller
public class BuyerController extends BaseController{
	
	@Resource
	private TradeService traderService;
	@Resource
	private OrderService orderService;
	@Resource
	private CarService carService;
	@Resource
	private ProductService productService;
	@Resource
	private BuyerCollectionService buyerCollectionService;
	@Resource
	private BuyerAddressService buyerAddressService;
	@Resource
	private AccountService accountService;
	@Resource
	private MyCouponService myCouponService;
	/**
	 * 
	 * index:我购买的产品，登陆后可以访问. <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author mqb
	 * @param query
	 * @param model
	 * @return
	 * @since JDK 1.7
	 */
	@RequestMapping("consumer-myitem")
	public String index(TradeQuery query,ModelMap model){
		this.setLayout(LayoutType.BUYER);
		query.setCurrentUserName(CurrentUserUtil.getCurrentUserName());
		query.setPageSize(10);
		query.setTotalItem(traderService.fetchPageCount(query));
		List<TradeModel> trades=traderService.fetchPage(query);
		Map<String,Object> map=new HashMap<String,Object>();
		for(TradeModel trade :trades){
			long tid=trade.getId();
			List<OrderModel> orders=orderService.getOrderByTid(trade.getId());
			trade.setOrders(orders);
		}
		model.put("pageInfo", query);
		model.put("items", trades);
		return "buyer/my_trades";
	}
	
	@RequestMapping("consumer-item-collect")
	public String consumerCollect(BuyerCollectionQuery query,ModelMap model){
		this.setLayout(LayoutType.BUYER);
		query.setBuyerId(CurrentUserUtil.getCurrentUserName());
		query.setPageSize(20);
		query.setTotalItem(buyerCollectionService.fetchPageCount(query));
		model.put("pageInfo", query);
		List<BuyerCollectionModel>  bcs=buyerCollectionService.fetchPage(query);
		model.put("items", bcs);
		return "buyer/item_collect";
	}
	
	@RequestMapping("consumer-item-collect-add")
	public String consumerCollectAdd(Integer id,ModelMap model){
		this.setLayout(LayoutType.EMPTY);
		BuyerCollectionModel bcm=buyerCollectionService.getByProductId(id);
		if(bcm==null){
			ProductModel pm=productService.getById(id);
			bcm=new BuyerCollectionModel();
			bcm.setBuyerId(CurrentUserUtil.getCurrentUserName());
			bcm.setSellerId(pm.getSellerId());
			bcm.setImage(StringUtil.getImageId(pm.getImages()));
			bcm.setTitle(pm.getName());
			bcm.setShopId(String.valueOf(pm.getShopId()));
			//bcm.setShopName(pm.getShopStatus());
			bcm.setIsDelete("0");
			bcm.setItemId(pm.getId());
			buyerCollectionService.insert(bcm);
			model.put("json", "{\"flage\":\"success\"}");
		}else{
			model.put("json", "{\"flage\":\"had\"}");
		}
		return "common/json";
	}
	
	@RequestMapping("consumer-shop-collect")
	public String consumerShopCollect(BuyerCollectionQuery query,ModelMap model){
		this.setLayout(LayoutType.BUYER);
		query.setBuyerId(CurrentUserUtil.getCurrentUserName());
		query.setPageSize(20);
		query.setTotalItem(buyerCollectionService.fetchPageCount(query));
		model.put("pageInfo", query);
		List<BuyerCollectionModel>  bcs=buyerCollectionService.fetchPage(query);
		model.put("items", bcs);
		return "buyer/shop_collect";
	}
	@RequestMapping("consumer-vip")
	public String consumerVip(ModelMap model){
		this.setLayout(LayoutType.BUYER);
		AccountModel account=accountService.getByUsername(CurrentUserUtil.getCurrentUserName());
		model.put("item",account);
		return "buyer/vip";
	}
	@RequestMapping("consumer-red-envelop")
	public String redEnvelop(MyCouponQuery query,ModelMap model,String type){
		this.setLayout(LayoutType.BUYER);
		query.setPageSize(20);
		query.setBuyerId(CurrentUserUtil.getCurrentUserName());
		query.setType(type);
		query.setTotalItem(myCouponService.fetchPageCount(query));
		List<MyCouponModel> items=myCouponService.fetchPage(query);
		model.put("pageInfo", query);
		model.put("items", items);
		model.put("type", type);
		return "buyer/red_envelop";
	}
	
	@RequestMapping("consumer-deliver-address")
	public String deliverAddress(BuyerAddressQuery query,ModelMap model){
		this.setLayout(LayoutType.BUYER);
		query.setPageSize(50);
		query.setTotalItem(50);
		query.setBuyerId(CurrentUserUtil.getCurrentUserName());
		List<BuyerAddressModel> addrs=buyerAddressService.fetchPage(query);
		model.put("items", addrs);
		return "buyer/deliver_address";
	}
	
	@RequestMapping("consumer-deliver-address-add")
	public String deliverAddressAdd(BuyerAddressModel bam,ModelMap model){
		bam.setBuyerId(CurrentUserUtil.getCurrentUserName());
		buyerAddressService.insert(bam);
		return "redirect:/consumer-deliver-address.htm";
	}
	
	@RequestMapping("consumer-deliver-address-del")
	public String deliverAddressdel(Integer id,ModelMap model){
		buyerAddressService.del(id);
		return "redirect:/consumer-deliver-address.htm";
	}
	
	@RequestMapping("consumer-deliver-address-edit")
	public String deliverAddressEdit(Integer id,ModelMap model){
		this.setLayout(LayoutType.BUYER);
	   BuyerAddressModel bam = buyerAddressService.getById(id);
	   model.put("item", bam);
		return "buyer/deliver_address_edit";
	}
	
	@RequestMapping("consumer-deliver-address-update")
	public String deliverAddressUpate(BuyerAddressModel bam,ModelMap model){
	   bam.setBuyerId(CurrentUserUtil.getCurrentUserName());
	   if("1".equals(bam.getIsDefault())){
		   buyerAddressService.clearDefault(CurrentUserUtil.getCurrentUserName());
	   }
		buyerAddressService.update(bam);
		
	   return "redirect:/consumer-deliver-address.htm";
	}
	
	
	@RequestMapping("purchaser-car")
	public String restPassword(ModelMap model,CarQuery query){
		this.setLayout(LayoutType.CAR);
		query.setTotalItem(50);
		query.setPageSize(50);
		query.setBuyerId(CurrentUserUtil.getCurrentUserName());
		List<CarModel> cars=carService.fetchPage(query);
		Map<String,CarCountItem> items = CarDivideUtil.toDivide(cars);
		model.put("items", items);
		return "buyer/car";
	}
	
	@RequestMapping("purchaser-car-add")
	public String purchaserCarAdd(ModelMap model,CarQuery query,Integer id){
		this.setLayout(LayoutType.EMPTY);
		query.setTotalItem(50);
		query.setPageSize(50);
		query.setBuyerId(CurrentUserUtil.getCurrentUserName());
		long count=carService.fetchPageCount(query);
		Map map=new HashMap();
		if(count>50){
			map.put("flage","full");
		}
		ProductModel pm=productService.getById(id);
		
		CarModel item=new CarModel();
		item.setBuyerId(CurrentUserUtil.getCurrentUserName());
		item.setCreatedTime(new Date());
		item.setNum(1);
		item.setItemId(pm.getId());
		item.setTitle(pm.getName());
		String imageStr=pm.getImages();
		if(!StringUtil.isEmpty(imageStr)){
		item.setPic(imageStr.substring(0, imageStr.indexOf(";")));
		}else{
		item.setPic("000");
		}
		item.setPrice(pm.getShopPrice());
		item.setSellerId(pm.getSellerId());
		map.put("flage", "success");
		model.put("json", JSONObject.fromObject(map).toString());
		carService.insert(item);
		return "common/json";
	}
	
	@RequestMapping("purchaser-car-del")
	public String purchaserCarDel(Integer id){
		carService.del(id);
		return "redirect:/purchaser-car.htm";
	}
	
	@RequestMapping("consumer-reset-password")
	public String consumerResetPassword(ModelMap model){
		this.setLayout(LayoutType.BUYER);
		
		return "buyer/reset_password";
	}
	
	@RequestMapping("consumer-reset-password-update")
	public String consumerResetPasswordUpdate(ModelMap model,String password,String newPassword){
		this.setLayout(LayoutType.EMPTY);
		AccountModel account=accountService.getByUsername(CurrentUserUtil.getCurrentUserName());
		account.setPassword(MD5Util.MD5(password));
		accountService.update(account);
		model.put("json", "{\"flage\":\"success\"}");
		return "redirect:/consumer-reset-password.htm";
	}
}

