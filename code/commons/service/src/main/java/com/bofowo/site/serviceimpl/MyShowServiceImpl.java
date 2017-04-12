package com.bofowo.site.serviceimpl;

import com.bofowo.site.model.MyShowModel;
import com.bofowo.site.mapper.MyShowMapper;
import com.bofowo.site.query.MyShowQuery;
import com.bofowo.site.service.MyShowService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("myShowService")
public class MyShowServiceImpl implements MyShowService{
	@Autowired
	private MyShowMapper myshowMapper;
	
	public List<MyShowModel> fetchPage(MyShowQuery query){
		return myshowMapper.fetchPageList(query);
	}
	public int fetchPageCount(MyShowQuery query){
		return myshowMapper.fetchPageCount(query);
	}
	public MyShowModel getById(long id){
		return myshowMapper.getById(id);
	}
	public void del(long id){
		myshowMapper.del(id);
	}
	public long insert(MyShowModel myshow){
		return myshowMapper.insert(myshow);
	}
	public long update(MyShowModel myshow){
		return myshowMapper.update(myshow);
	}
} 
