package com.bofowo.site.controller;
import com.bofowo.site.model.DatabaseModel;
import com.bofowo.site.query.DatabaseQuery;
import com.bofowo.site.service.DatabaseService;

import common.web.BaseController;

import org.springframework.ui.ModelMap;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class DatabaseController extends BaseController{

	@Autowired
	private DatabaseService databaseService;

	@RequestMapping("/database-add")
	public String adddatabase(ModelMap model){
		return "database/add";
	}
	
	@RequestMapping("/database-edit")
	public String editdatabase(ModelMap model,long id){
		DatabaseModel database = databaseService.getById(id);
		model.put("database",database);
		return "database/edit";
	}
	
	@RequestMapping("database-insert")
	public String insert_database(DatabaseModel database,ModelMap model){
		databaseService.insert(database);
		return "redirect:/database-page.htm";
	}
	
	@RequestMapping("database-page")
	public String page_database(DatabaseQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(databaseService.fetchPageCount(query));
		List<DatabaseModel> items=databaseService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "database/page";
	}
	
	@RequestMapping("/database-detail")
	public String detail_database(ModelMap model,long id){
		DatabaseModel database = databaseService.getById(id);
		model.put("database",database);
		return "database/detail";
	}
	
	@RequestMapping("database-del")
	public String del_database(ModelMap model,long id){
		databaseService.del(id);
		return "redirect:/database-page.htm";
	}
	
	@RequestMapping("database-update")
	public String update_database(DatabaseModel database,ModelMap model){
		databaseService.update(database);
		return "redirect:/database-detail.htm";
	}
}