package com.bofowo.site.serviceimpl;

import com.bofowo.site.mapper.SeqMapper;
import com.bofowo.site.model.SeqModel;
import com.bofowo.site.query.SeqQuery;
import com.bofowo.site.service.SeqService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("seqService")
public class SeqServiceImpl implements SeqService{
	@Autowired
	private SeqMapper seqMapper;
	
	public List<SeqModel> fetchPage(SeqQuery query){
		return seqMapper.fetchPageList(query);
	}
	public int fetchPageCount(SeqQuery query){
		return seqMapper.fetchPageCount(query);
	}
	public SeqModel getById(long id){
		return seqMapper.getById(id);
	}
	public void del(long id){
		seqMapper.del(id);
	}
	public long insert(SeqModel seq){
		return seqMapper.insert(seq);
	}
	public long update(SeqModel seq){
		return seqMapper.update(seq);
	}
} 
