package com.bofowo.site.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bofowo.site.mapper.CarMapper;
import com.bofowo.site.model.CarModel;
import com.bofowo.site.query.CarQuery;
import com.bofowo.site.service.CarService;


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
	@Override
	public List<CarModel> getItemsByIds(String ids, String username) {
		Map<String,String> condition=new HashMap<String,String>();
		condition.put("username", username);
		condition.put("ids", ids);
		return carMapper.getItemsByIds(condition);
	}
	@Override
	public CarModel getByItemId(Integer id, String username) {
		Map<String,String> condition=new HashMap<String,String>();
		condition.put("username", username);
		condition.put("id", String.valueOf(id));
		return carMapper.getByItemId(condition);
	}
	@Override
	public void deleteByIdAndUsername(Integer id, String username) {
		Map<String,String> condition=new HashMap<String,String>();
		condition.put("username", username);
		condition.put("id", String.valueOf(id));
		carMapper.deleteByIdAndUsername(condition);
	}
} 
