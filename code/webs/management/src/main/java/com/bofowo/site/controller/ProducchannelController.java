package com.bofowo.site.controller;
import com.bofowo.site.service.ProducchannelService;
import common.web.BaseController;
import org.springframework.ui.ModelMap;
import com.bofowo.site.query.ProducchannelQuery;
import com.bofowo.site.model.ProducchannelModel;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class ProducchannelController extends BaseController{

	@Autowired
	private ProducchannelService producchannelService;

	@RequestMapping("/producchannel-add")
	public String addproducchannel(ModelMap model){
		return "producchannel/add";
	}
	
	@RequestMapping("/producchannel-edit")
	public String editproducchannel(ModelMap model,long id){
		ProducchannelModel producchannel = producchannelService.getById(id);
		model.put("producchannel",producchannel);
		return "producchannel/edit";
	}
	
	@RequestMapping("producchannel-insert")
	public String insert_producchannel(ProducchannelModel producchannel,ModelMap model){
		producchannelService.insert(producchannel);
		return "redirect:/producchannel-page.htm";
	}
	
	@RequestMapping("producchannel-page")
	public String page_producchannel(ProducchannelQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(producchannelService.fetchPageCount(query));
		List<ProducchannelModel> items=producchannelService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "producchannel/page";
	}
	
	@RequestMapping("/producchannel-detail")
	public String detail_producchannel(ModelMap model,long id){
		ProducchannelModel producchannel = producchannelService.getById(id);
		model.put("producchannel",producchannel);
		return "producchannel/detail";
	}
	
	@RequestMapping("producchannel-del")
	public String del_producchannel(ModelMap model,long id){
		producchannelService.del(id);
		return "redirect:/producchannel-page.htm";
	}
	
	@RequestMapping("producchannel-update")
	public String update_producchannel(ProducchannelModel producchannel,ModelMap model){
		producchannelService.update(producchannel);
		return "redirect:/producchannel-detail.htm";
	}
}