package com.bofowo.site.controller;
import com.bofowo.site.service.ProductaglibService;
import common.web.BaseController;
import org.springframework.ui.ModelMap;
import com.bofowo.site.query.ProductaglibQuery;
import com.bofowo.site.model.ProductaglibModel;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class ProductaglibController extends BaseController{

	@Autowired
	private ProductaglibService productaglibService;

	@RequestMapping("/productaglib-add")
	public String addproductaglib(ModelMap model){
		return "productaglib/add";
	}
	
	@RequestMapping("/productaglib-edit")
	public String editproductaglib(ModelMap model,long id){
		ProductaglibModel productaglib = productaglibService.getById(id);
		model.put("productaglib",productaglib);
		return "productaglib/edit";
	}
	
	@RequestMapping("productaglib-insert")
	public String insert_productaglib(ProductaglibModel productaglib,ModelMap model){
		productaglibService.insert(productaglib);
		return "redirect:/productaglib-page.htm";
	}
	
	@RequestMapping("productaglib-page")
	public String page_productaglib(ProductaglibQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(productaglibService.fetchPageCount(query));
		List<ProductaglibModel> items=productaglibService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "productaglib/page";
	}
	
	@RequestMapping("/productaglib-detail")
	public String detail_productaglib(ModelMap model,long id){
		ProductaglibModel productaglib = productaglibService.getById(id);
		model.put("productaglib",productaglib);
		return "productaglib/detail";
	}
	
	@RequestMapping("productaglib-del")
	public String del_productaglib(ModelMap model,long id){
		productaglibService.del(id);
		return "redirect:/productaglib-page.htm";
	}
	
	@RequestMapping("productaglib-update")
	public String update_productaglib(ProductaglibModel productaglib,ModelMap model){
		productaglibService.update(productaglib);
		return "redirect:/productaglib-detail.htm";
	}
}