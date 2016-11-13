package com.bofowo.site.serviceimpl;

import com.bofowo.site.mapper.MyCouponMapper;
import com.bofowo.site.model.MyCouponModel;
import com.bofowo.site.query.MyCouponQuery;
import com.bofowo.site.service.MyCouponService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("myCouponService")
public class MyCouponServiceImpl implements MyCouponService{
	@Autowired
	private MyCouponMapper mycouponMapper;
	
	public List<MyCouponModel> fetchPage(MyCouponQuery query){
		return mycouponMapper.fetchPageList(query);
	}
	public int fetchPageCount(MyCouponQuery query){
		return mycouponMapper.fetchPageCount(query);
	}
	public MyCouponModel getById(long id){
		return mycouponMapper.getById(id);
	}
	public void del(long id){
		mycouponMapper.del(id);
	}
	public long insert(MyCouponModel mycoupon){
		return mycouponMapper.insert(mycoupon);
	}
	public long update(MyCouponModel mycoupon){
		return mycouponMapper.update(mycoupon);
	}
} 
