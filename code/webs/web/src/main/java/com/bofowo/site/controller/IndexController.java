package com.bofowo.site.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bofowo.site.model.AccountModel;
import com.bofowo.site.model.CategoryModel;
import com.bofowo.site.model.PageColumnModel;
import com.bofowo.site.model.ProductModel;
import com.bofowo.site.model.ShopModel;
import com.bofowo.site.query.ProductQuery;
import com.bofowo.site.query.ShopQuery;
import com.bofowo.site.service.AccountService;
import com.bofowo.site.service.CategoryService;
import com.bofowo.site.service.PageColumnService;
import com.bofowo.site.service.ProducimageService;
import com.bofowo.site.service.ProductService;
import com.bofowo.site.service.ShopService;

import common.MD5Util;
import common.util.StringUtil;

/**
 * 前台首页
 * @author mqb
 * 2015-11-17
 */
@Controller
public class IndexController {
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
	private AccountService accountService;

	@RequestMapping("/artist-web")
	public String artist_web(ModelMap model,boolean error){
		return "search/artist_web";
	}
	
	
	@RequestMapping("/index")
	public String home(ModelMap model,boolean error){
		List<CategoryModel> cms=categoryService.getAllByParendid(0, "2");
		model.put("cates", cms);
		List<PageColumnModel> columns=pageColumnService.getByPageId(1);
		model.put("columns", columns);
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
		return "detail";
	}
	
	@RequestMapping("/baihuo")
	public String baihuo(ModelMap model,boolean error){
		return "baihuo";
	}
	
	@RequestMapping("/login")
	public String login(ModelMap model,boolean error){
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
	
}
