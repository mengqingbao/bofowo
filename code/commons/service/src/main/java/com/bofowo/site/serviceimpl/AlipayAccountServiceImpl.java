package com.bofowo.site.serviceimpl;

import com.bofowo.site.mapper.AlipayAccountMapper;
import com.bofowo.site.model.AlipayAccountModel;
import com.bofowo.site.query.AlipayAccountQuery;
import com.bofowo.site.service.AlipayAccountService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("alipayAccountService")
public class AlipayAccountServiceImpl implements AlipayAccountService{
	@Autowired
	private AlipayAccountMapper alipayaccountMapper;
	
	public List<AlipayAccountModel> fetchPage(AlipayAccountQuery query){
		return alipayaccountMapper.fetchPageList(query);
	}
	public int fetchPageCount(AlipayAccountQuery query){
		return alipayaccountMapper.fetchPageCount(query);
	}
	public AlipayAccountModel getById(long id){
		return alipayaccountMapper.getById(id);
	}
	public void del(long id){
		alipayaccountMapper.del(id);
	}
	public long insert(AlipayAccountModel alipayaccount){
		return alipayaccountMapper.insert(alipayaccount);
	}
	public long update(AlipayAccountModel alipayaccount){
		return alipayaccountMapper.update(alipayaccount);
	}
	@Override
	public AlipayAccountModel getBySellerId(String sellerId) {
		
		return alipayaccountMapper.getBySellerId(sellerId);
	}
	
} 
