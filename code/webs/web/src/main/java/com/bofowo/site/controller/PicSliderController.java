package com.bofowo.site.controller;

import com.bofowo.site.service.PicSliderService;

import common.security.login.CurrentUserUtil;
import common.util.LayoutType;
import common.web.BaseController;

import org.springframework.ui.ModelMap;

import com.bofowo.site.query.PicSliderQuery;
import com.bofowo.site.model.PicSliderModel;
import com.bofowo.util.FileUploadUtil;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Controller
public class PicSliderController extends BaseController {

	@Autowired
	private PicSliderService picsliderService;

	@Value("#{settings['upload.lyun.path']}")
	private String path;

	@RequestMapping("/provider-picslider-add")
	public String addpicslider(ModelMap model) {
		this.setLayout(LayoutType.SELLER);
		return "shop/picslider/add";
	}

	@RequestMapping("/provider-picslider-edit")
	public String editpicslider(ModelMap model, long id) {
		this.setLayout(LayoutType.SELLER);
		PicSliderModel picslider = picsliderService.getById(id);
		model.put("picslider", picslider);
		return "shop/picslider/edit";
	}

	@RequestMapping("provider-picslider-insert")
	public String insert_picslider(PicSliderModel picslider, ModelMap model,
			@RequestParam("photoFile") CommonsMultipartFile photoFile) {
		String filename="";
		try {
			filename = FileUploadUtil.saveFile(photoFile, path);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		picslider.setPic(filename);
		picslider.setSellerId(CurrentUserUtil.getCurrentUserName());
		picslider.setShopId(String.valueOf(CurrentUserUtil.getShopId()));
		this.setLayout(LayoutType.SELLER);
		
		picsliderService.insert(picslider);
		return "redirect:/provider-shop-picslider.htm";
	}

	@RequestMapping("provider-shop-picslider")
	public String page_picslider(PicSliderQuery query, ModelMap model) {
		this.setLayout(LayoutType.SELLER);
		query.setPageSize(10);
		query.setSellerId(CurrentUserUtil.getCurrentUserName());
		query.setTotalItem(picsliderService.fetchPageCount(query));
		List<PicSliderModel> items = picsliderService.fetchPage(query);

		model.put("pageInfo", query);
		model.put("items", items);
		return "shop/picslider/page";
	}

	@RequestMapping("/provider-picslider-detail")
	public String detail_picslider(ModelMap model, long id) {
		this.setLayout(LayoutType.SELLER);
		PicSliderModel picslider = picsliderService.getById(id);
		model.put("picslider", picslider);
		return "shop/picslider/detail";
	}

	@RequestMapping("provider-picslider-del")
	public String del_picslider(ModelMap model, long id) {
		picsliderService.del(id);
		return "redirect:/provider-shop-picslider.htm";
	}

	@RequestMapping("provider-picslider-update")
	public String update_picslider(PicSliderModel picslider, ModelMap model) {
		picsliderService.update(picslider);
		return "redirect:/provider-shop-picslider.htm";
	}
	@RequestMapping("cprovider-picslider-setstatu")
	public String cproviderPicsliderSetstatu(Integer id,String status,ModelMap model){
		this.setLayout(LayoutType.EMPTY);
		PicSliderModel picslider = picsliderService.getById(id);
		picslider.setStatus(status);
		picsliderService.update(picslider);
		model.put("json", "success");
		return "common/json";
		
	}
}