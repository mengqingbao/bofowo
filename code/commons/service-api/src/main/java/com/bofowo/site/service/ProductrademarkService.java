package com.bofowo.site.service;

import com.bofowo.site.model.ProductrademarkModel;
import com.bofowo.site.query.ProductrademarkQuery;

import java.util.List;


public interface ProductrademarkService{
	public List<ProductrademarkModel> fetchPage(ProductrademarkQuery query);
	public int fetchPageCount(ProductrademarkQuery query);
	public ProductrademarkModel getById(long id);
	public void del(long id);
	public long insert(ProductrademarkModel productrademark);
	public long update(ProductrademarkModel productrademark);
} 
