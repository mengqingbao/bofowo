package com.bofowo.site.service;

import com.bofowo.site.model.CouponModel;
import com.bofowo.site.query.CouponQuery;

import java.util.List;


public interface CouponService{
	public List<CouponModel> fetchPage(CouponQuery query);
	public int fetchPageCount(CouponQuery query);
	public CouponModel getById(long id);
	public void del(long id);
	public long insert(CouponModel coupon);
	public long update(CouponModel coupon);
} 
