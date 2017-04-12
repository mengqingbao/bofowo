package com.bofowo.site.serviceimpl;

import com.bofowo.site.model.SellerInfoModel;
import com.bofowo.site.mapper.SellerInfoMapper;
import com.bofowo.site.query.SellerInfoQuery;
import com.bofowo.site.service.SellerInfoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("sellerInfoService")
public class SellerInfoServiceImpl implements SellerInfoService{
	@Autowired
	private SellerInfoMapper sellerinfoMapper;
	
	public List<SellerInfoModel> fetchPage(SellerInfoQuery query){
		return sellerinfoMapper.fetchPageList(query);
	}
	public int fetchPageCount(SellerInfoQuery query){
		return sellerinfoMapper.fetchPageCount(query);
	}
	public SellerInfoModel getById(long id){
		return sellerinfoMapper.getById(id);
	}
	public void del(long id){
		sellerinfoMapper.del(id);
	}
	public long insert(SellerInfoModel sellerinfo){
		return sellerinfoMapper.insert(sellerinfo);
	}
	public long update(SellerInfoModel sellerinfo){
		return sellerinfoMapper.update(sellerinfo);
	}
	@Override
	public SellerInfoModel getBySellerId(String currentUserName) {
		return sellerinfoMapper.getBySellerId(currentUserName);
	}
} 
