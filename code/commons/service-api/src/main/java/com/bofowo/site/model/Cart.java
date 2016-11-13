package com.bofowo.site.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Cart{
	   
	  
	    
	    
	     //商品列表
	 	private List<GoodsElement> goods =new LinkedList<GoodsElement>();

	 	// 添加商品
	 	
	 	public List<GoodsElement> getGoods() {
			return goods;
		}

		public void addGoods(GoodsElement good){
	 		goods.add(good);
	 	}
	 	
	 	
	 	
	 	//删除商品
	 	
	 	//全部清空购物车
	 	
	 	
	 	
	
	 	

	
		
	 	
}