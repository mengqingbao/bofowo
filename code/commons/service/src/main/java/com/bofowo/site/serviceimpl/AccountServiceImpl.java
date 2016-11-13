package com.bofowo.site.serviceimpl;

import com.bofowo.site.mapper.AccountMapper;
import com.bofowo.site.model.AccountModel;
import com.bofowo.site.query.AccountQuery;
import com.bofowo.site.service.AccountService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("accountService")
public class AccountServiceImpl implements AccountService{
	@Autowired
	private AccountMapper accountMapper;
	
	public List<AccountModel> fetchPage(AccountQuery query){
		return accountMapper.fetchPageList(query);
	}
	public int fetchPageCount(AccountQuery query){
		return accountMapper.fetchPageCount(query);
	}
	public AccountModel getById(long id){
		return accountMapper.getById(id);
	}
	public void del(long id){
		accountMapper.del(id);
	}
	public long insert(AccountModel account){
		return accountMapper.insert(account);
	}
	public long update(AccountModel account){
		return accountMapper.update(account);
	}
	@Override
	public AccountModel getByUsername(String currentUserName) {
		
		// TODO Auto-generated method stub
		return accountMapper.getByUsername(currentUserName);
	}
} 
