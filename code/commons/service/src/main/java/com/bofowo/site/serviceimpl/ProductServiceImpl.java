package com.bofowo.site.serviceimpl;

import com.bofowo.site.mapper.ProductMapper;
import com.bofowo.site.model.ProductModel;
import com.bofowo.site.query.ProductQuery;
import com.bofowo.site.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("productService")
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductMapper productMapper;
	
	public List<ProductModel> fetchPage(ProductQuery query){
		return productMapper.fetchPageList(query);
	}
	public int fetchPageCount(ProductQuery query){
		return productMapper.fetchPageCount(query);
	}
	public ProductModel getById(long id){
		return productMapper.getById(id);
	}
	public void del(long id){
		productMapper.del(id);
	}
	public long insert(ProductModel product){
		return productMapper.insert(product);
	}
	public long update(ProductModel product){
		return productMapper.update(product);
	}
	@Override
	public List<ProductModel> getHotTop(ProductQuery query) {
		
		return productMapper.fetchPageList(query);
	}
	@Override
	public List<ProductModel> getNewsTop(ProductQuery query) {
		return productMapper.fetchPageList(query);
	}
} 
