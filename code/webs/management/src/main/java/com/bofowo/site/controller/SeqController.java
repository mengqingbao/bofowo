package com.bofowo.site.controller;
import com.bofowo.site.model.SeqModel;
import com.bofowo.site.query.SeqQuery;
import com.bofowo.site.service.SeqService;

import common.web.BaseController;

import org.springframework.ui.ModelMap;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class SeqController extends BaseController{

	@Autowired
	private SeqService seqService;

	@RequestMapping("/seq-add")
	public String addseq(ModelMap model){
		return "seq/add";
	}
	
	@RequestMapping("/seq-edit")
	public String editseq(ModelMap model,long id){
		SeqModel seq = seqService.getById(id);
		model.put("seq",seq);
		return "seq/edit";
	}
	
	@RequestMapping("seq-insert")
	public String insert_seq(SeqModel seq,ModelMap model){
		seqService.insert(seq);
		return "redirect:/seq-page.htm";
	}
	
	@RequestMapping("seq-page")
	public String page_seq(SeqQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(seqService.fetchPageCount(query));
		List<SeqModel> items=seqService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "seq/page";
	}
	
	@RequestMapping("/seq-detail")
	public String detail_seq(ModelMap model,long id){
		SeqModel seq = seqService.getById(id);
		model.put("seq",seq);
		return "seq/detail";
	}
	
	@RequestMapping("seq-del")
	public String del_seq(ModelMap model,long id){
		seqService.del(id);
		return "redirect:/seq-page.htm";
	}
	
	@RequestMapping("seq-update")
	public String update_seq(SeqModel seq,ModelMap model){
		seqService.update(seq);
		return "redirect:/seq-detail.htm";
	}
}