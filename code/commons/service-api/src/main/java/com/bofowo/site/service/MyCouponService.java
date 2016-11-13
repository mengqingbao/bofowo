package com.bofowo.site.service;

import com.bofowo.site.model.MyCouponModel;
import com.bofowo.site.query.MyCouponQuery;

import java.util.List;


public interface MyCouponService{
	public List<MyCouponModel> fetchPage(MyCouponQuery query);
	public int fetchPageCount(MyCouponQuery query);
	public MyCouponModel getById(long id);
	public void del(long id);
	public long insert(MyCouponModel mycoupon);
	public long update(MyCouponModel mycoupon);
} 
