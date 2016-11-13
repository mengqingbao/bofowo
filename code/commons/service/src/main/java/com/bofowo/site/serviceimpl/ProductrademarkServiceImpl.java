package com.bofowo.site.serviceimpl;

import com.bofowo.site.mapper.ProductrademarkMapper;
import com.bofowo.site.model.ProductrademarkModel;
import com.bofowo.site.query.ProductrademarkQuery;
import com.bofowo.site.service.ProductrademarkService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("productrademarkService")
public class ProductrademarkServiceImpl implements ProductrademarkService{
	@Autowired
	private ProductrademarkMapper productrademarkMapper;
	
	public List<ProductrademarkModel> fetchPage(ProductrademarkQuery query){
		return productrademarkMapper.fetchPageList(query);
	}
	public int fetchPageCount(ProductrademarkQuery query){
		return productrademarkMapper.fetchPageCount(query);
	}
	public ProductrademarkModel getById(long id){
		return productrademarkMapper.getById(id);
	}
	public void del(long id){
		productrademarkMapper.del(id);
	}
	public long insert(ProductrademarkModel productrademark){
		return productrademarkMapper.insert(productrademark);
	}
	public long update(ProductrademarkModel productrademark){
		return productrademarkMapper.update(productrademark);
	}
} 
