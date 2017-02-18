package com.bofowo.site.service;

import com.bofowo.site.model.ProducchannelModel;
import com.bofowo.site.query.ProducchannelQuery;
import java.util.List;


public interface ProducchannelService{
	public List<ProducchannelModel> fetchPage(ProducchannelQuery query);
	public int fetchPageCount(ProducchannelQuery query);
	public ProducchannelModel getById(long id);
	public void del(long id);
	public long insert(ProducchannelModel producchannel);
	public long update(ProducchannelModel producchannel);
} 
