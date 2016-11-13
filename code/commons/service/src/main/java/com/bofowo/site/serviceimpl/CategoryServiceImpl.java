package com.bofowo.site.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bofowo.site.mapper.CategoryMapper;
import com.bofowo.site.model.CategoryModel;
import com.bofowo.site.query.CategoryQuery;
import com.bofowo.site.service.CategoryService;


@Component("categoryService")
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryMapper categoryMapper;
	
	public List<CategoryModel> fetchPage(CategoryQuery query){
		return categoryMapper.fetchPageList(query);
	}
	public int fetchPageCount(CategoryQuery query){
		return categoryMapper.fetchPageCount(query);
	}
	public CategoryModel getById(long id){
		return categoryMapper.getById(id);
	}
	public void del(long id){
		categoryMapper.del(id);
	}
	public long insert(CategoryModel category){
		return categoryMapper.insert(category);
	}
	public long update(CategoryModel category){
		return categoryMapper.update(category);
	}
	@Override
	public List<CategoryModel> getAllByParendid(int pid,String type) {
		Map condition = new HashMap();
		condition.put("pid", pid);
		condition.put("type", type);
		return categoryMapper.getAllByParendid(condition);
	}
} 
