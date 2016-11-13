package com.bofowo.site.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bofowo.site.mapper.ProducimageMapper;
import com.bofowo.site.model.ProducimageModel;
import com.bofowo.site.query.ProducimageQuery;
import com.bofowo.site.service.ProducimageService;

import common.util.StringUtil;


@Component("producimageService")
public class ProducimageServiceImpl implements ProducimageService{
	@Autowired
	private ProducimageMapper producimageMapper;
	
	public List<ProducimageModel> fetchPage(ProducimageQuery query){
		return producimageMapper.fetchPageList(query);
	}
	public int fetchPageCount(ProducimageQuery query){
		return producimageMapper.fetchPageCount(query);
	}
	public ProducimageModel getById(long id){
		return producimageMapper.getById(id);
	}
	public void del(long id){
		producimageMapper.del(id);
	}
	public long insert(ProducimageModel producimage){
		return producimageMapper.insert(producimage);
	}
	public long update(ProducimageModel producimage){
		return producimageMapper.update(producimage);
	}
	@Override
	public List<ProducimageModel> getSellerUnRefImage(String sellerId) {
		Map condition=new HashMap();
		condition.put("sellerId", sellerId);
		condition.put("itemId", 0);
		return producimageMapper.getSellerUnRefImage(condition);
	}
	@Override
	public void updateStatus(String images,int itemId) {
		if(StringUtil.isEmpty(images)){
			return;
		}
		String[] imagesId=images.split(";");
		for(String id:imagesId){
			Map condition=new HashMap();
			condition.put("itemId", itemId);
			condition.put("id", id);
			producimageMapper.updateStatus(condition);
		}
	}
	@Override
	public List<ProducimageModel> fetchImagesByPid(int id) {
		Map condition=new HashMap();
		condition.put("itemId", id);
		return producimageMapper.getImagesByPid(condition);
	}
} 
