package com.bofowo.site.controller;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bofowo.site.model.CategoryModel;
import com.bofowo.site.model.ProducpropertiesModel;
import com.bofowo.site.query.CategoryQuery;
import com.bofowo.site.query.ProducpropertiesQuery;
import com.bofowo.site.service.CategoryService;
import com.bofowo.site.service.ProducpropertiesService;

import common.constant.WebConstant;
import common.security.login.CurrentUserUtil;
import common.util.BeanUtils;
import common.util.StringUtil;
import common.web.BaseController;


@Controller
public class ProducpropertiesController extends BaseController{

	@Autowired
	private ProducpropertiesService producpropertiesService;
	
	@Resource
	private CategoryService categoryService;

	@RequestMapping("/producproperties-add")
	public String addproducproperties(CategoryQuery tquery,ModelMap model,String type){
		tquery.setStatus("1");
		tquery.setPageSize(50);
		tquery.setTotalItem(50);
		tquery.setType(WebConstant.CATEGORY);
		List categories=categoryService.fetchPage(tquery);
		model.put("categories", categories);
		
		model.put("type", type);
		return "biz/producproperties/add";
	}
	
	@RequestMapping("/producproperties-edit")
	public String editproducproperties(CategoryQuery tquery,ModelMap model,long id,String type){
		tquery.setStatus("1");
		tquery.setPageSize(50);
		tquery.setTotalItem(50);
		tquery.setType(WebConstant.CATEGORY);
		List categories=categoryService.fetchPage(tquery);
		ProducpropertiesModel producproperties = producpropertiesService.getById(id);
		String vals=producproperties.getVal();
		String[] strs=vals.split(",");
		model.put("foo",producproperties);
		model.put("categories", categories);
		model.put("vstrs", strs);
		model.put("type", type);
		
		CategoryModel cate3=categoryService.getById(producproperties.getCategoryId());
		model.put("category3", cate3);
		if(cate3.getPid()>0){
			CategoryModel cate2=categoryService.getById(cate3.getPid());
			model.put("category2", cate2);
			if(cate2.getPid()>0){
				CategoryModel cate1=categoryService.getById(cate2.getPid());
				model.put("category1", cate1);
			}
		}
		
		return "biz/producproperties/edit";
	}
	
	@RequestMapping("producproperties-insert")
	public String insert_producproperties(ProducpropertiesModel producproperties,ModelMap model){
		producproperties.setCreator(CurrentUserUtil.getCurrentUserName());
		producproperties.setCreatedDate(new Date());
		String val=producproperties.getVal();
		if(!StringUtil.isEmpty(val)){
			producproperties.setVal(val.replaceFirst(",",""));
		}
		
		producpropertiesService.insert(producproperties);
		return "redirect:/product-properties-manage-"+producproperties.getType()+".htm";
	}
	
	@RequestMapping("producproperties-page")
	public String page_producproperties(ProducpropertiesQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(producpropertiesService.fetchPageCount(query));
		List<ProducpropertiesModel> items=producpropertiesService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "producproperties/page";
	}
	
	@RequestMapping("/producproperties-detail")
	public String detail_producproperties(ModelMap model,long id){
		ProducpropertiesModel producproperties = producpropertiesService.getById(id);
		model.put("producproperties",producproperties);
		return "producproperties/detail";
	}
	
	@RequestMapping("producproperties-del")
	public String del_producproperties(ModelMap model,long id,String type){
		producpropertiesService.del(id);
		return "redirect:/product-properties-manage-"+type+".htm";
	}
	
	@RequestMapping("producproperties-update")
	public String update_producproperties(ProducpropertiesModel producproperties,ModelMap model){
		ProducpropertiesModel oproducproperties = producpropertiesService.getById(producproperties.getId());
		
		String val=producproperties.getVal();
		if(!StringUtil.isEmpty(val)){
			producproperties.setVal(val.replaceFirst(",",""));
		}
		BeanUtils.copyProperties(producproperties, oproducproperties);
		producpropertiesService.update(oproducproperties);
		
		return "redirect:/product-properties-manage-"+producproperties.getType()+".htm";
	}
	
	@RequestMapping("product-properties-manage-{type}")
	public String propertiesMange(@PathVariable("type") String type,ModelMap model,ProducpropertiesQuery query){
		query.setType(type);
		query.setPageSize(15);
		query.setTotalItem(producpropertiesService.fetchPageCount(query));
		List<ProducpropertiesModel> list=producpropertiesService.fetchPage(query);
		model.put("pageInfo", query);
		model.put("list",list);
		return "biz/product/properties";
	}
}