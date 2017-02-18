package com.bofowo.site.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bofowo.site.mapper.BuyerAddressMapper;
import com.bofowo.site.model.BuyerAddressModel;
import com.bofowo.site.query.BuyerAddressQuery;
import com.bofowo.site.service.BuyerAddressService;


@Component("buyerAddressService")
public class BuyerAddressServiceImpl implements BuyerAddressService{
	@Autowired
	private BuyerAddressMapper buyeraddressMapper;
	
	public List<BuyerAddressModel> fetchPage(BuyerAddressQuery query){
		return buyeraddressMapper.fetchPageList(query);
	}
	public int fetchPageCount(BuyerAddressQuery query){
		return buyeraddressMapper.fetchPageCount(query);
	}
	public BuyerAddressModel getById(long id){
		return buyeraddressMapper.getById(id);
	}
	public void del(long id){
		buyeraddressMapper.del(id);
	}
	public long insert(BuyerAddressModel buyeraddress){
		return buyeraddressMapper.insert(buyeraddress);
	}
	public long update(BuyerAddressModel buyeraddress){
		return buyeraddressMapper.update(buyeraddress);
	}
	@Override
	public void clearDefault(String bueryId) {
		Map condition=new HashMap();
		condition.put("buyerId",bueryId);
		//condition.put("id", "1");
		buyeraddressMapper.clearDefault(bueryId);
	}
	@Override
	public List<BuyerAddressModel> getBuyerAddress(String username) {
		
		return buyeraddressMapper.getBuyerAddress(username);
	}
} 
