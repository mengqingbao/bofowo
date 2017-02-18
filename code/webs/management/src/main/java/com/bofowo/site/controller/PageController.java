package com.bofowo.site.controller;
import com.bofowo.site.model.PageModel;
import com.bofowo.site.model.ShopModel;
import com.bofowo.site.model.ShopScrollModel;
import com.bofowo.site.query.PageQuery;
import com.bofowo.site.query.ShopScrollQuery;
import com.bofowo.site.service.PageService;
import com.bofowo.site.service.PostemplateService;
import com.bofowo.site.service.ProducpropertiesService;
import com.bofowo.site.service.ProductService;
import com.bofowo.site.service.ProductrademarkService;
import com.bofowo.site.service.ShopCategoryPropService;
import com.bofowo.site.service.ShopCategoryService;
import com.bofowo.site.service.ShopScrollService;
import com.bofowo.site.service.ShopService;

import common.security.login.CurrentUserUtil;
import common.util.LayoutType;
import common.web.BaseController;

import org.springframework.ui.ModelMap;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class PageController extends BaseController{

	@Autowired
	private PageService pageService;
	@Resource
	private PostemplateService postemplateService;
	
	@Resource
	private ProductrademarkService productrademarkService;
	@Resource
	private ShopCategoryService shopCategoryService;
	@Resource
	private ProducpropertiesService producpropertiesService;
	@Resource
	private ShopCategoryPropService shopCategoryPropService;
	@Resource
	private ProductService productService;
	@Resource
	private ShopService shopService;
	@Resource
	private ShopScrollService shopScrollService;

	@RequestMapping("/page-add")
	public String addpage(ModelMap model){
		return "page/add";
	}
	
	@RequestMapping("/page-edit")
	public String editpage(ModelMap model,long id){
		PageModel page = pageService.getById(id);
		model.put("page",page);
		return "page/edit";
	}
	
	@RequestMapping("page-insert")
	public String insert_page(PageModel page,ModelMap model){
		pageService.insert(page);
		return "redirect:/page-page.htm";
	}
	
	@RequestMapping("page-page")
	public String page_page(PageQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(pageService.fetchPageCount(query));
		List<PageModel> items=pageService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "page/page";
	}
	
	@RequestMapping("/page-detail")
	public String detail_page(ModelMap model,long id){
		PageModel page = pageService.getById(id);
		model.put("page",page);
		return "page/detail";
	}
	
	@RequestMapping("page-del")
	public String del_page(ModelMap model,long id){
		pageService.del(id);
		return "redirect:/page-page.htm";
	}
	
	@RequestMapping("page-update")
	public String update_page(PageModel page,ModelMap model){
		pageService.update(page);
		return this.redirectRefer(request);
	}
	
	@RequestMapping("manage-index-scroll")
	public String shopSettingTurnPic(ModelMap model){
		
		
		ShopScrollQuery ssq=new ShopScrollQuery();
		//ssq.setCurrentUserName(CurrentUserUtil.getCurrentUserName());
		ssq.setPageSize(10);
		ssq.setTotalItem(shopScrollService.fetchPageCount(ssq));
		ssq.setStatus("1");
		List<ShopScrollModel> ssms=shopScrollService.fetchPage(ssq);
		model.put("scrolls", ssms);
		model.put("pageInfo", ssq);
		
		return "biz/index/shop_setting_turnpic";
	}
	
	@RequestMapping("shop-scroll-update")
	public String shopScrollUpdate(ModelMap model,Integer id,String url,String title,String logoImg,String status){
		
		ShopScrollModel scm=null;
		if(id==null){
			scm=new ShopScrollModel();
		
		}else{
			scm=shopScrollService.getById(id);
		}
		scm.setPic(logoImg);
		scm.setSellerId(CurrentUserUtil.getCurrentUserName());
		scm.setTitle(title);
		scm.setUrl(url);
		scm.setStatus(status);
		scm.setShopId(0);
		if(id==null){
			shopScrollService.insert(scm);
		}else{
			shopScrollService.update(scm);
		}
		
		return "redirect:/manage-index-scroll.htm";
	}
	
	@RequestMapping("shop-scroll-recommend")
	public String recommend(Integer id,String status,ModelMap model){
		this.setLayout(LayoutType.EMPTY);
		ShopScrollModel scm=shopScrollService.getById(id);
		scm.setPushIndex(status);
		shopScrollService.update(scm);
		return this.redirectRefer(request);
	}
}