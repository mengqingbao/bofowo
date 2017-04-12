package com.bofowo.site.controller;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bofowo.site.model.AccountModel;
import com.bofowo.site.model.SellerInfoModel;
import com.bofowo.site.model.ShopModel;
import com.bofowo.site.query.SellerInfoQuery;
import com.bofowo.site.service.AccountService;
import com.bofowo.site.service.SellerInfoService;
import com.bofowo.site.service.ShopService;

import common.security.login.CurrentUserUtil;
import common.web.BaseController;


@Controller
public class SellerInfoController extends BaseController{

	@Autowired
	private SellerInfoService sellerinfoService;
	
	@Resource
	private ShopService shopService;
	@Resource
	private AccountService accountService;

	@RequestMapping("/sellerinfo-add")
	public String addsellerinfo(ModelMap model){
		return "sellerinfo/add";
	}
	
	@RequestMapping("/sellerinfo-edit")
	public String editsellerinfo(ModelMap model,long id){
		SellerInfoModel sellerinfo = sellerinfoService.getById(id);
		model.put("sellerinfo",sellerinfo);
		return "biz/sellerinfo/edit";
	}
	
	@RequestMapping("sellerinfo-insert")
	public String insert_sellerinfo(SellerInfoModel sellerinfo,ModelMap model){
		sellerinfoService.insert(sellerinfo);
		return "redirect:/sellerinfo-page.htm";
	}
	
	@RequestMapping("sellerinfo-page")
	public String page_sellerinfo(SellerInfoQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(sellerinfoService.fetchPageCount(query));
		List<SellerInfoModel> items=sellerinfoService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "biz/sellerinfo/page";
	}
	
	@RequestMapping("/sellerinfo-detail")
	public String detail_sellerinfo(ModelMap model,long id){
		SellerInfoModel sellerinfo = sellerinfoService.getById(id);
		model.put("sellerinfo",sellerinfo);
		return "biz/sellerinfo/detail";
	}
	
	@RequestMapping("sellerinfo-del")
	public String del_sellerinfo(ModelMap model,long id){
		sellerinfoService.del(id);
		return "redirect:/sellerinfo-page.htm";
	}
	
	@RequestMapping("sellerinfo-update")
	public String update_sellerinfo(SellerInfoModel sellerinfo,ModelMap model){
		sellerinfoService.update(sellerinfo);
		return "redirect:/sellerinfo-detail.htm";
	}
	
	@RequestMapping("sellerinfo_pass")
	public String sellerinfo_pass(Integer id,String status){
		
		SellerInfoModel sim=sellerinfoService.getById(id);
		
		String userId=sim.getUserId();
		sim.setStatus(status);
		sellerinfoService.update(sim);
		ShopModel shop=shopService.getByUsername(userId);
		if(shop==null){
			shop=new ShopModel();
			shop.setCreatedTime(new Date());
			shop.setSellerId(userId);
			shop.setName(sim.getName());
			shop.setStatus("0");
			shopService.insert(shop);
		}
		AccountModel am=accountService.getByUsername(userId);
		am.setIsSeller("1");
		accountService.update(am);
		return "redirect:/sellerinfo-page.htm";
	}
}