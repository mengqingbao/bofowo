package com.bofowo.site.serviceimpl;

import com.bofowo.site.model.PicSliderModel;
import com.bofowo.site.mapper.PicSliderMapper;
import com.bofowo.site.query.PicSliderQuery;
import com.bofowo.site.service.PicSliderService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("picSliderService")
public class PicSliderServiceImpl implements PicSliderService{
	@Autowired
	private PicSliderMapper picsliderMapper;
	
	public List<PicSliderModel> fetchPage(PicSliderQuery query){
		return picsliderMapper.fetchPageList(query);
	}
	public int fetchPageCount(PicSliderQuery query){
		return picsliderMapper.fetchPageCount(query);
	}
	public PicSliderModel getById(long id){
		return picsliderMapper.getById(id);
	}
	public void del(long id){
		picsliderMapper.del(id);
	}
	public long insert(PicSliderModel picslider){
		return picsliderMapper.insert(picslider);
	}
	public long update(PicSliderModel picslider){
		return picsliderMapper.update(picslider);
	}
	@Override
	public List<PicSliderModel> getByshopId(Integer id) {
		return picsliderMapper.getByshopId(id);
	}
} 
