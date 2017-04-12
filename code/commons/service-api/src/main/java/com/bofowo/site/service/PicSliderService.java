package com.bofowo.site.service;

import com.bofowo.site.model.PicSliderModel;
import com.bofowo.site.query.PicSliderQuery;

import java.util.List;


public interface PicSliderService{
	public List<PicSliderModel> fetchPage(PicSliderQuery query);
	public int fetchPageCount(PicSliderQuery query);
	public PicSliderModel getById(long id);
	public void del(long id);
	public long insert(PicSliderModel picslider);
	public long update(PicSliderModel picslider);
	public List<PicSliderModel> getByshopId(Integer id);
} 
