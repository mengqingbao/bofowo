package com.bofowo.site.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;

import com.bofowo.content.BofowoContaint;
import com.bofowo.site.model.AccountModel;
import com.bofowo.site.model.BuyerBrowseHistoryModel;
import com.bofowo.site.model.CategoryModel;
import com.bofowo.site.model.CouponModel;
import com.bofowo.site.model.PageColumnModel;
import com.bofowo.site.model.ProducpropValModel;
import com.bofowo.site.model.ProducstockModel;
import com.bofowo.site.model.ProductModel;
import com.bofowo.site.model.ShopModel;
import com.bofowo.site.model.ShopScrollModel;
import com.bofowo.site.model.WebContentModel;
import com.bofowo.site.query.CouponQuery;
import com.bofowo.site.query.ProductQuery;
import com.bofowo.site.query.ShopQuery;
import com.bofowo.site.query.ShopScrollQuery;
import com.bofowo.site.query.WebContentQuery;
import com.bofowo.site.service.AccountService;
import com.bofowo.site.service.BuyerBrowseHistoryService;
import com.bofowo.site.service.CategoryService;
import com.bofowo.site.service.CouponService;
import com.bofowo.site.service.PageColumnService;
import com.bofowo.site.service.PageService;
import com.bofowo.site.service.ProducimageService;
import com.bofowo.site.service.ProducpropValService;
import com.bofowo.site.service.ProducstockService;
import com.bofowo.site.service.ProductService;
import com.bofowo.site.service.ShopScrollService;
import com.bofowo.site.service.ShopService;
import com.bofowo.site.service.WebContentService;
import common.security.login.CurrentUserUtil;
import common.util.StringUtil;
import common.web.BaseController;

/**
 * 前台首页
 * @author mqb
 * 2015-11-17
 */
@Controller
public class IndexController extends BaseController{
	@Resource
	private ProductService productService;
	@Resource
	private ShopService shopService;
	@Resource
	private ProducimageService producimageService;
	@Resource
	private CategoryService categoryService;
	@Resource
	private PageColumnService pageColumnService;
	@Resource
	private PageService pageService;
	@Resource
	private AccountService accountService;
	@Resource
	public ShopScrollService shopScrollService;
	 @Autowired  
	private LocaleResolver localeResolver;
	 @Resource
	 private ProducpropValService producpropValService; 
	 @Resource
	 private ProducstockService producstockService;
	 @Resource
	 private CouponService couponService;
	 @Resource
	 private WebContentService webContentService;
	 @Resource
	 private BuyerBrowseHistoryService buyerBrowseHistoryService;
	 
	@RequestMapping("/artist-web")
	public String artist_web(ModelMap model,boolean error){
		return "search/artist_web";
	}
	
	
	@RequestMapping("/index")
	public String home(ModelMap model,boolean error){
		List<CategoryModel> cms=categoryService.getAllByParendid(0, "2");
		model.put("cates", cms);
		
		//新入住店铺列表
		ShopQuery squery=new ShopQuery();
		squery.setTotalItem(8);
		squery.setPageSize(8);
		
		List<ShopModel> shops=shopService.fetchPage(squery);
		model.put("shops",shops);
		//推荐店铺列表
		ShopQuery recomdquery=new ShopQuery();
		recomdquery.setTotalItem(8);
		recomdquery.setPageSize(8);
		
		List<ShopModel> recomdshops=shopService.fetchPage(recomdquery);
		model.put("recomdshops",recomdshops);
		
		//推荐单盘
		ProductQuery productQuery=new ProductQuery();
		productQuery.setTotalItem(6);
		productQuery.setPageSize(6);
		productQuery.setTaglib("recommend");
		List<ProductModel> recommendItem=productService.fetchPage(productQuery);
		model.put("recommendItems", recommendItem);
		//抢购
		productQuery.setTaglib("hot");
		List<ProductModel> hotItems=productService.fetchPage(productQuery);
		model.put("hotItems", hotItems);
		//优惠信息
		CouponQuery couponQuery=new CouponQuery();
		couponQuery.setTotalItem(14);
		couponQuery.setPageSize(14);
		List<CouponModel> couponModels=couponService.fetchPage(couponQuery);
		model.put("coupons", couponModels);
		
		//首页新闻内容
		WebContentQuery wcQuery=new WebContentQuery();
		wcQuery.setTotalItem(4);
		wcQuery.setPageSize(4);
		wcQuery.setTablibId(BofowoContaint.WebContent.INDEX_TAGLIB);
		List<WebContentModel> wcContents=webContentService.fetchPage(wcQuery);
		model.put("wcContents", wcContents);
		
		//首页栏位底部的信息
		List<PageColumnModel> columns=pageColumnService.getByPageId(2);
		model.put("columns", columns);
		
		ShopScrollQuery ssq=new ShopScrollQuery();
		ssq.setPageSize(7);
		ssq.setTotalItem(7);
		ssq.setPushIndex("yes");
		//滚动推片
		List<ShopScrollModel> ssms=shopScrollService.fetchPage(ssq);
		model.put("ssms", ssms);
		//首页栏位
//		PageQuery pageQuery=new PageQuery();
//		pageQuery.setType("nav");
//		List<PageModel> pages=pageService.fetchPage(pageQuery);
//		model.put("pages", pages);
		return "index";
	}
	
	@RequestMapping("/searchShop")
	public String searchShop(ModelMap model,ShopQuery query){
			
			query.setPageSize(18);
		    query.setTotalItem(shopService.fetchPageCount(query));
			model.put("pageInfo", query);
			List<ShopModel> items=shopService.fetchPage(query);
			model.put("items", items);
			return "searchShop";
	}
	
	@RequestMapping("/searchItem")
	public String searchItem(ModelMap model,ProductQuery query){
			query.setPageSize(18);
			query.setTotalItem(productService.fetchPageCount(query));
			model.put("pageInfo", query);
			List<ProductModel> items=productService.fetchPage(query);
			model.put("items", items);
			return "searchItem";
	}
	
	@RequestMapping("/items")
	public String items(ModelMap model,boolean error){
		return "searchItem";
	}
	
	@RequestMapping("/item-{id}-detail")
	public String detail(@PathVariable("id") Integer id,ModelMap model,boolean error){
		ProductModel productModel=productService.getById(id);
		model.put("item", productModel);
		List<String> images= new ArrayList<String>();
		if(!StringUtil.isEmpty(productModel.getImages())){
			String[] strs=productModel.getImages().split(";");
			images.addAll(Arrays.asList(strs));
		}
		model.put("images", images);
		//查询规格属性
		List<ProducpropValModel> pvms=producpropValService.getListByItemId(id);
		model.put("pvms", pvms);
		//规格
		List<ProducstockModel> pss=producstockService.getListByItemId(id);
		model.put("pss",pss);
		
		//查询店铺详情
		ShopModel shop=shopService.getById(productModel.getShopId());
		model.put("shop", shop);
		
		//所属分类
		CategoryModel catA=categoryService.getById(Long.valueOf(productModel.getCategoryAId()));
		model.put("catea", catA);
		CategoryModel catB=categoryService.getById(Long.valueOf(productModel.getCategoryBId()));
		model.put("cateb", catB);
		CategoryModel catC=categoryService.getById(Long.valueOf(productModel.getCategoryId()));
		model.put("catec", catC);
		//记录查看记录
		BuyerBrowseHistoryModel bvhm=new BuyerBrowseHistoryModel();
		bvhm.setPid(id);
		bvhm.setCreatedDate(new Date());
		bvhm.setLastVisitDate(new Date());
		bvhm.setTimes(1);
		bvhm.setBuyerId(CurrentUserUtil.getCurrentUserName());
		buyerBrowseHistoryService.countVisitTimes(bvhm);
		return "detail";
	}
	
	@RequestMapping("/baihuo")
	public String baihuo(ModelMap model,boolean error){
		return "baihuo";
	}
	
	@RequestMapping("/login")
	public String login(ModelMap model,boolean error,String redirect){
		model.put("redirect", redirect);
		return "login";
	}
	
	@RequestMapping("/register")
	public String register(ModelMap model,boolean error){
		model.put("error", error);
		return "register";
	}
	
	@RequestMapping("/regAction")
	public String regAction(String username,String password){
		AccountModel account=accountService.getByUsername(username);
		if(account==null){
			account=new AccountModel();
			account.setUsername(username);
			Md5PasswordEncoder encoder=new Md5PasswordEncoder();
			account.setPassword(encoder.encodePassword(password, username));
			account.setStatus("1");
			
			accountService.insert(account);
			return "redirect:/login.htm";
		}
		
		return "redirect:/register.htm?error=true";
	}
	
	@RequestMapping("setLanguage")
	public String changeLanguage(HttpServletRequest request,String type,HttpServletResponse response){
		Locale locale = new Locale(type); 
		localeResolver.setLocale(request, response, locale);
		return "redirect:"+request.getHeader("referer");
	}
	
}
