package com.bofowo.site.service;

import com.bofowo.site.model.ShopCategoryPropModel;
import com.bofowo.site.query.ShopCategoryPropQuery;

import java.util.List;


public interface ShopCategoryPropService{
	public List<ShopCategoryPropModel> fetchPage(ShopCategoryPropQuery query);
	public int fetchPageCount(ShopCategoryPropQuery query);
	public ShopCategoryPropModel getById(long id);
	public void del(long id);
	public long insert(ShopCategoryPropModel shopcategoryprop);
	public long update(ShopCategoryPropModel shopcategoryprop);
	/**
	 * 根据店铺分类查询属性
	 * getByShopCateId:(这里用一句话描述这个方法的作用). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author mqb
	 * @param query
	 * @return
	 * @since JDK 1.7
	 */
	public List<ShopCategoryPropModel> getByShopCateId(ShopCategoryPropQuery query);
} 
