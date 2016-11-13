package com.bofowo.site.controller;
import com.bofowo.site.model.CarModel;
import com.bofowo.site.query.CarQuery;
import com.bofowo.site.service.CarService;

import common.web.BaseController;

import org.springframework.ui.ModelMap;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class CarController extends BaseController{

	@Autowired
	private CarService carService;

	@RequestMapping("/car-add")
	public String addcar(ModelMap model){
		return "car/add";
	}
	
	@RequestMapping("/car-edit")
	public String editcar(ModelMap model,long id){
		CarModel car = carService.getById(id);
		model.put("car",car);
		return "car/edit";
	}
	
	@RequestMapping("car-insert")
	public String insert_car(CarModel car,ModelMap model){
		carService.insert(car);
		return "redirect:/car-page.htm";
	}
	
	@RequestMapping("car-page")
	public String page_car(CarQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(carService.fetchPageCount(query));
		List<CarModel> items=carService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "car/page";
	}
	
	@RequestMapping("/car-detail")
	public String detail_car(ModelMap model,long id){
		CarModel car = carService.getById(id);
		model.put("car",car);
		return "car/detail";
	}
	
	@RequestMapping("car-del")
	public String del_car(ModelMap model,long id){
		carService.del(id);
		return "redirect:/car-page.htm";
	}
	
	@RequestMapping("car-update")
	public String update_car(CarModel car,ModelMap model){
		carService.update(car);
		return "redirect:/car-detail.htm";
	}
}