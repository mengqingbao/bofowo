package com.bofowo.site.controller;
import com.bofowo.site.service.PicSliderService;
import common.web.BaseController;
import org.springframework.ui.ModelMap;
import com.bofowo.site.query.PicSliderQuery;
import com.bofowo.site.model.PicSliderModel;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class PicSliderController extends BaseController{

	@Autowired
	private PicSliderService picsliderService;

	@RequestMapping("/picslider-add")
	public String addpicslider(ModelMap model){
		return "picslider/add";
	}
	
	@RequestMapping("/picslider-edit")
	public String editpicslider(ModelMap model,long id){
		PicSliderModel picslider = picsliderService.getById(id);
		model.put("picslider",picslider);
		return "picslider/edit";
	}
	
	@RequestMapping("picslider-insert")
	public String insert_picslider(PicSliderModel picslider,ModelMap model){
		picsliderService.insert(picslider);
		return "redirect:/picslider-page.htm";
	}
	
	@RequestMapping("picslider-page")
	public String page_picslider(PicSliderQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(picsliderService.fetchPageCount(query));
		List<PicSliderModel> items=picsliderService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "picslider/page";
	}
	
	@RequestMapping("/picslider-detail")
	public String detail_picslider(ModelMap model,long id){
		PicSliderModel picslider = picsliderService.getById(id);
		model.put("picslider",picslider);
		return "picslider/detail";
	}
	
	@RequestMapping("picslider-del")
	public String del_picslider(ModelMap model,long id){
		picsliderService.del(id);
		return "redirect:/picslider-page.htm";
	}
	
	@RequestMapping("picslider-update")
	public String update_picslider(PicSliderModel picslider,ModelMap model){
		picsliderService.update(picslider);
		return "redirect:/picslider-detail.htm";
	}
}