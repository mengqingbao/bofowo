package com.bofowo.site.service;

import com.bofowo.site.model.ProductModel;
import com.bofowo.site.query.ProductQuery;

import java.util.List;


public interface ProductService{
	public List<ProductModel> fetchPage(ProductQuery query);
	public int fetchPageCount(ProductQuery query);
	public ProductModel getById(long id);
	public void del(long id);
	public long insert(ProductModel product);
	public long update(ProductModel product);
	public List<ProductModel> getHotTop(ProductQuery query);
	public List<ProductModel> getNewsTop(ProductQuery query);
	public List<ProductModel> getBrowsedProductTop5(String currentUserName);
} 
