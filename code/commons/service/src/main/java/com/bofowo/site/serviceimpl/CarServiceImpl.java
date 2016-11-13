package com.bofowo.site.serviceimpl;

import com.bofowo.site.mapper.CarMapper;
import com.bofowo.site.model.CarModel;
import com.bofowo.site.query.CarQuery;
import com.bofowo.site.service.CarService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("carService")
public class CarServiceImpl implements CarService{
	@Autowired
	private CarMapper carMapper;
	
	public List<CarModel> fetchPage(CarQuery query){
		return carMapper.fetchPageList(query);
	}
	public int fetchPageCount(CarQuery query){
		return carMapper.fetchPageCount(query);
	}
	public CarModel getById(long id){
		return carMapper.getById(id);
	}
	public void del(long id){
		carMapper.del(id);
	}
	public long insert(CarModel car){
		return carMapper.insert(car);
	}
	public long update(CarModel car){
		return carMapper.update(car);
	}
} 
