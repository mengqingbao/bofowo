package com.bofowo.site.service;

import com.bofowo.site.model.ProductaglibModel;
import com.bofowo.site.query.ProductaglibQuery;
import java.util.List;


public interface ProductaglibService{
	public List<ProductaglibModel> fetchPage(ProductaglibQuery query);
	public int fetchPageCount(ProductaglibQuery query);
	public ProductaglibModel getById(long id);
	public void del(long id);
	public long insert(ProductaglibModel productaglib);
	public long update(ProductaglibModel productaglib);
} 
