package com.bofowo.site.serviceimpl;

import com.bofowo.site.mapper.CustomerServiceMapper;
import com.bofowo.site.model.CustomerServiceModel;
import com.bofowo.site.query.CustomerServiceQuery;
import com.bofowo.site.service.CustomerServiceService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("customerServiceService")
public class CustomerServiceServiceImpl implements CustomerServiceService{
	@Autowired
	private CustomerServiceMapper customerserviceMapper;
	
	public List<CustomerServiceModel> fetchPage(CustomerServiceQuery query){
		return customerserviceMapper.fetchPageList(query);
	}
	public int fetchPageCount(CustomerServiceQuery query){
		return customerserviceMapper.fetchPageCount(query);
	}
	public CustomerServiceModel getById(long id){
		return customerserviceMapper.getById(id);
	}
	public void del(long id){
		customerserviceMapper.del(id);
	}
	public long insert(CustomerServiceModel customerservice){
		return customerserviceMapper.insert(customerservice);
	}
	public long update(CustomerServiceModel customerservice){
		return customerserviceMapper.update(customerservice);
	}
} 
