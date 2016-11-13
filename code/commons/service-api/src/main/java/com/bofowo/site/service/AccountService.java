package com.bofowo.site.service;

import com.bofowo.site.model.AccountModel;
import com.bofowo.site.query.AccountQuery;

import java.util.List;


public interface AccountService{
	public List<AccountModel> fetchPage(AccountQuery query);
	public int fetchPageCount(AccountQuery query);
	public AccountModel getById(long id);
	public void del(long id);
	public long insert(AccountModel account);
	public long update(AccountModel account);
	public AccountModel getByUsername(String currentUserName);
} 
