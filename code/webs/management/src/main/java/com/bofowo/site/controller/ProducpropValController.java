package com.bofowo.site.controller;
import com.bofowo.site.service.ProducpropValService;
import common.web.BaseController;
import org.springframework.ui.ModelMap;
import com.bofowo.site.query.ProducpropValQuery;
import com.bofowo.site.model.ProducpropValModel;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class ProducpropValController extends BaseController{

	@Autowired
	private ProducpropValService producpropvalService;

	@RequestMapping("/producpropval-add")
	public String addproducpropval(ModelMap model){
		return "producpropval/add";
	}
	
	@RequestMapping("/producpropval-edit")
	public String editproducpropval(ModelMap model,long id){
		ProducpropValModel producpropval = producpropvalService.getById(id);
		model.put("producpropval",producpropval);
		return "producpropval/edit";
	}
	
	@RequestMapping("producpropval-insert")
	public String insert_producpropval(ProducpropValModel producpropval,ModelMap model){
		producpropvalService.insert(producpropval);
		return "redirect:/producpropval-page.htm";
	}
	
	@RequestMapping("producpropval-page")
	public String page_producpropval(ProducpropValQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(producpropvalService.fetchPageCount(query));
		List<ProducpropValModel> items=producpropvalService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "producpropval/page";
	}
	
	@RequestMapping("/producpropval-detail")
	public String detail_producpropval(ModelMap model,long id){
		ProducpropValModel producpropval = producpropvalService.getById(id);
		model.put("producpropval",producpropval);
		return "producpropval/detail";
	}
	
	@RequestMapping("producpropval-del")
	public String del_producpropval(ModelMap model,long id){
		producpropvalService.del(id);
		return "redirect:/producpropval-page.htm";
	}
	
	@RequestMapping("producpropval-update")
	public String update_producpropval(ProducpropValModel producpropval,ModelMap model){
		producpropvalService.update(producpropval);
		return "redirect:/producpropval-detail.htm";
	}
}