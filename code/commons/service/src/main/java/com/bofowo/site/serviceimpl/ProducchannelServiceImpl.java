package com.bofowo.site.serviceimpl;

import com.bofowo.site.model.ProducchannelModel;
import com.bofowo.site.mapper.ProducchannelMapper;
import com.bofowo.site.query.ProducchannelQuery;
import com.bofowo.site.service.ProducchannelService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("producchannelService")
public class ProducchannelServiceImpl implements ProducchannelService{
	@Autowired
	private ProducchannelMapper producchannelMapper;
	
	public List<ProducchannelModel> fetchPage(ProducchannelQuery query){
		return producchannelMapper.fetchPageList(query);
	}
	public int fetchPageCount(ProducchannelQuery query){
		return producchannelMapper.fetchPageCount(query);
	}
	public ProducchannelModel getById(long id){
		return producchannelMapper.getById(id);
	}
	public void del(long id){
		producchannelMapper.del(id);
	}
	public long insert(ProducchannelModel producchannel){
		return producchannelMapper.insert(producchannel);
	}
	public long update(ProducchannelModel producchannel){
		return producchannelMapper.update(producchannel);
	}
} 
