package com.bofowo.site.controller;
import com.bofowo.site.service.BuyerBrowseHistoryService;
import common.web.BaseController;
import org.springframework.ui.ModelMap;
import com.bofowo.site.query.BuyerBrowseHistoryQuery;
import com.bofowo.site.model.BuyerBrowseHistoryModel;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class BuyerBrowseHistoryController extends BaseController{

	@Autowired
	private BuyerBrowseHistoryService buyerbrowsehistoryService;

	@RequestMapping("/buyerbrowsehistory-add")
	public String addbuyerbrowsehistory(ModelMap model){
		return "buyerbrowsehistory/add";
	}

	
	@RequestMapping("buyerbrowsehistory-insert")
	public String insert_buyerbrowsehistory(BuyerBrowseHistoryModel buyerbrowsehistory,ModelMap model){
		buyerbrowsehistoryService.insert(buyerbrowsehistory);
		return "redirect:/buyerbrowsehistory-page.htm";
	}
	

	
	@RequestMapping("buyerbrowsehistory-update")
	public String update_buyerbrowsehistory(BuyerBrowseHistoryModel buyerbrowsehistory,ModelMap model){
		buyerbrowsehistoryService.update(buyerbrowsehistory);
		return "redirect:/buyerbrowsehistory-detail.htm";
	}
}