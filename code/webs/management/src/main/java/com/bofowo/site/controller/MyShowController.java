package com.bofowo.site.controller;
import com.bofowo.site.service.MyShowService;
import common.web.BaseController;
import org.springframework.ui.ModelMap;
import com.bofowo.site.query.MyShowQuery;
import com.bofowo.site.model.MyShowModel;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class MyShowController extends BaseController{

	@Autowired
	private MyShowService myshowService;

	@RequestMapping("/myshow-add")
	public String addmyshow(ModelMap model){
		return "myshow/add";
	}
	
	@RequestMapping("/myshow-edit")
	public String editmyshow(ModelMap model,long id){
		MyShowModel myshow = myshowService.getById(id);
		model.put("myshow",myshow);
		return "myshow/edit";
	}
	
	@RequestMapping("myshow-insert")
	public String insert_myshow(MyShowModel myshow,ModelMap model){
		myshowService.insert(myshow);
		return "redirect:/myshow-page.htm";
	}
	
	@RequestMapping("myshow-page")
	public String page_myshow(MyShowQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(myshowService.fetchPageCount(query));
		List<MyShowModel> items=myshowService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "myshow/page";
	}
	
	@RequestMapping("/myshow-detail")
	public String detail_myshow(ModelMap model,long id){
		MyShowModel myshow = myshowService.getById(id);
		model.put("myshow",myshow);
		return "myshow/detail";
	}
	
	@RequestMapping("myshow-del")
	public String del_myshow(ModelMap model,long id){
		myshowService.del(id);
		return "redirect:/myshow-page.htm";
	}
	
	@RequestMapping("myshow-update")
	public String update_myshow(MyShowModel myshow,ModelMap model){
		myshowService.update(myshow);
		return "redirect:/myshow-detail.htm";
	}
}