package com.bofowo.site.service;

import com.bofowo.site.model.CarModel;
import com.bofowo.site.query.CarQuery;

import java.util.List;


public interface CarService{
	public List<CarModel> fetchPage(CarQuery query);
	public int fetchPageCount(CarQuery query);
	public CarModel getById(long id);
	public void del(long id);
	public long insert(CarModel car);
	public long update(CarModel car);
} 
