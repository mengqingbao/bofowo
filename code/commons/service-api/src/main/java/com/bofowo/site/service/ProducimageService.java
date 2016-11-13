package com.bofowo.site.service;

import com.bofowo.site.model.ProducimageModel;
import com.bofowo.site.query.ProducimageQuery;

import java.util.List;


public interface ProducimageService{
	public List<ProducimageModel> fetchPage(ProducimageQuery query);
	public int fetchPageCount(ProducimageQuery query);
	public ProducimageModel getById(long id);
	public void del(long id);
	public long insert(ProducimageModel producimage);
	public long update(ProducimageModel producimage);
	public List<ProducimageModel> getSellerUnRefImage(String sellerId);
	public void updateStatus(String images,int itemId);
	public List<ProducimageModel> fetchImagesByPid(int id);
} 
