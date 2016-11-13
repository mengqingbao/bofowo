package com.bofowo.site.serviceimpl;

import com.bofowo.site.mapper.CouponMapper;
import com.bofowo.site.model.CouponModel;
import com.bofowo.site.query.CouponQuery;
import com.bofowo.site.service.CouponService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("couponService")
public class CouponServiceImpl implements CouponService{
	@Autowired
	private CouponMapper couponMapper;
	
	public List<CouponModel> fetchPage(CouponQuery query){
		return couponMapper.fetchPageList(query);
	}
	public int fetchPageCount(CouponQuery query){
		return couponMapper.fetchPageCount(query);
	}
	public CouponModel getById(long id){
		return couponMapper.getById(id);
	}
	public void del(long id){
		couponMapper.del(id);
	}
	public long insert(CouponModel coupon){
		return couponMapper.insert(coupon);
	}
	public long update(CouponModel coupon){
		return couponMapper.update(coupon);
	}
} 
