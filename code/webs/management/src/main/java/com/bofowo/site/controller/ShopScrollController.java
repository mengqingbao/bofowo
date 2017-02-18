package com.bofowo.site.controller;
import com.bofowo.site.service.ShopScrollService;
import common.web.BaseController;
import org.springframework.ui.ModelMap;
import com.bofowo.site.query.ShopScrollQuery;
import com.bofowo.site.model.ShopScrollModel;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class ShopScrollController extends BaseController{

	@Autowired
	private ShopScrollService shopscrollService;

	@RequestMapping("/shopscroll-add")
	public String addshopscroll(ModelMap model){
		return "shopscroll/add";
	}
	
	@RequestMapping("/shopscroll-edit")
	public String editshopscroll(ModelMap model,long id){
		ShopScrollModel shopscroll = shopscrollService.getById(id);
		model.put("shopscroll",shopscroll);
		return "shopscroll/edit";
	}
	
	@RequestMapping("shopscroll-insert")
	public String insert_shopscroll(ShopScrollModel shopscroll,ModelMap model){
		shopscrollService.insert(shopscroll);
		return "redirect:/shopscroll-page.htm";
	}
	
	@RequestMapping("shopscroll-page")
	public String page_shopscroll(ShopScrollQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(shopscrollService.fetchPageCount(query));
		List<ShopScrollModel> items=shopscrollService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "shopscroll/page";
	}
	
	@RequestMapping("/shopscroll-detail")
	public String detail_shopscroll(ModelMap model,long id){
		ShopScrollModel shopscroll = shopscrollService.getById(id);
		model.put("shopscroll",shopscroll);
		return "shopscroll/detail";
	}
	
	@RequestMapping("shopscroll-del")
	public String del_shopscroll(ModelMap model,long id){
		shopscrollService.del(id);
		return "redirect:/shopscroll-page.htm";
	}
	
	@RequestMapping("shopscroll-update")
	public String update_shopscroll(ShopScrollModel shopscroll,ModelMap model){
		shopscrollService.update(shopscroll);
		return "redirect:/shopscroll-detail.htm";
	}
}