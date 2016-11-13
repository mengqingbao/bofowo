package com.bofowo.site.service;

import com.bofowo.site.model.CategoryModel;
import com.bofowo.site.query.CategoryQuery;
import java.util.List;


public interface CategoryService{
	public List<CategoryModel> fetchPage(CategoryQuery query);
	public int fetchPageCount(CategoryQuery query);
	public CategoryModel getById(long id);
	public void del(long id);
	public long insert(CategoryModel category);
	public long update(CategoryModel category);
} 
