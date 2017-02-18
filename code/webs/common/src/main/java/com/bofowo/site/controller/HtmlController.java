package com.bofowo.site.controller;
import com.bofowo.site.model.CategoryModel;
import com.bofowo.site.model.ProducpropertiesModel;
import com.bofowo.site.query.CategoryQuery;
import com.bofowo.site.query.ProducpropertiesQuery;
import com.bofowo.site.service.CategoryService;
import com.bofowo.site.service.ProducpropertiesService;

import common.util.BeanUtils;
import common.util.LayoutType;
import common.web.BaseController;
import net.sf.json.JSONArray;

import org.springframework.ui.ModelMap;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class HtmlController extends BaseController{

	@Autowired
	private ProducpropertiesService producpropertiesService;

	@RequestMapping("/get-html-by-categoryid")
	public String addcategory(ModelMap model,ProducpropertiesQuery query){
		query.setTotalItem(10);
		query.setPageSize(10);
		List<ProducpropertiesModel> ppms=producpropertiesService.fetchPage(query);
		model.put("items", ppms);
		return "common/prop";
	}
	
	
}