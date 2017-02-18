package com.bofowo.site.serviceimpl;

import com.bofowo.site.model.ProductaglibModel;
import com.bofowo.site.mapper.ProductaglibMapper;
import com.bofowo.site.query.ProductaglibQuery;
import com.bofowo.site.service.ProductaglibService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("productaglibService")
public class ProductaglibServiceImpl implements ProductaglibService{
	@Autowired
	private ProductaglibMapper productaglibMapper;
	
	public List<ProductaglibModel> fetchPage(ProductaglibQuery query){
		return productaglibMapper.fetchPageList(query);
	}
	public int fetchPageCount(ProductaglibQuery query){
		return productaglibMapper.fetchPageCount(query);
	}
	public ProductaglibModel getById(long id){
		return productaglibMapper.getById(id);
	}
	public void del(long id){
		productaglibMapper.del(id);
	}
	public long insert(ProductaglibModel productaglib){
		return productaglibMapper.insert(productaglib);
	}
	public long update(ProductaglibModel productaglib){
		return productaglibMapper.update(productaglib);
	}
} 
