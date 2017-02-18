package com.bofowo.site.controller;
import com.bofowo.site.model.ProducimageModel;
import com.bofowo.site.query.ProducimageQuery;
import com.bofowo.site.service.ProducimageService;
import com.bofowo.util.DateUtil;

import common.security.login.CurrentUserUtil;
import common.util.LayoutType;
import common.web.BaseController;

import org.springframework.ui.ModelMap;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;


@Controller
public class ProducimageController extends BaseController{

	@Autowired
	private ProducimageService producimageService;
	
	@Value("#{settings['upload.lyun.path']}")
	private String path;

	@RequestMapping("/producimage-add")
	public String addproducimage(ModelMap model){
		return "producimage/add";
	}
	
	@RequestMapping("/producimage-edit")
	public String editproducimage(ModelMap model,long id){
		ProducimageModel producimage = producimageService.getById(id);
		model.put("producimage",producimage);
		return "producimage/edit";
	}
	
	@RequestMapping("producimage-insert")
	public String insert_producimage(ProducimageModel producimage,ModelMap model){
		producimageService.insert(producimage);
		return "redirect:/producimage-page.htm";
	}
	
	@RequestMapping("producimage-upload-list")
	public String page_producimage(ProducimageQuery query,ModelMap model){
		query.setTotalItem(6);
		query.setPageSize(6);
		List<ProducimageModel> items=producimageService.fetchPage(query);
		if(items!=null&&items.size()>6){
			model.put("canUpload",false);
		}else{
			model.put("canUpload",true);
		}
		model.put("items",items);
		return "seller/item/producimage/page";
	}
	
	@RequestMapping("/producimage-detail")
	public String detail_producimage(ModelMap model,long id){
		ProducimageModel producimage = producimageService.getById(id);
		model.put("producimage",producimage);
		return "producimage/detail";
	}
	
	@RequestMapping("producimage-del")
	public String del_producimage(ModelMap model,long id){
		producimageService.del(id);
		return "redirect:/producimage-page.htm";
	}
	
	@RequestMapping("producimage-update")
	public String update_producimage(ProducimageModel producimage,ModelMap model){
		producimageService.update(producimage);
		return "redirect:/producimage-detail.htm";
	}
	
	@RequestMapping("product-iamge-upload")
	public String ajaxuploadify(ModelMap model,@RequestParam("itemImageFile") CommonsMultipartFile file,Integer pid){
		
		this.setLayout(LayoutType.EMPTY);
		String createFileName=null;
	            if(!file.isEmpty()){  
	                int pre = (int) System.currentTimeMillis();  
	                try {  
	                	String fileName=file.getOriginalFilename();
	                	String prefix=fileName.substring(fileName.lastIndexOf(".")+1);
	                	String newFileName=new Date().getTime() +"."+prefix;
	                	createFileName=path+"/itemImages/"+CurrentUserUtil.getCurrentUserName()+"/"+ DateUtil.forMat(new Date())+"/" + newFileName;
	                	File createdFile=new File(createFileName);
	                	if(!createdFile.exists()){
	                		File dir=new File(createdFile.getParent());
	                		if(!dir.exists())dir.mkdirs();
	                		createdFile.createNewFile();
	                	}
	                    //拿到输出流，同时重命名上传的文件  
	                    FileOutputStream os = new FileOutputStream(createFileName);  
	                    //拿到上传文件的输入流  
	                    FileInputStream in = (FileInputStream) file.getInputStream();  
	                      
	                    //以写字节的方式写文件  
	                    int b = 0;  
	                    while((b=in.read()) != -1){  
	                        os.write(b);  
	                    }  
	                    os.flush();  
	                    os.close();  
	                    in.close();  
	                    int finaltime = (int) System.currentTimeMillis();  
	                      
	                } catch (Exception e) {  
	                   log.error(e.getMessage());;  
	                }  
	        }  
	     ProducimageModel pim=new ProducimageModel();
	     pim.setPath(createFileName);
	     pim.setSellerId(CurrentUserUtil.getCurrentUserName());
	     pim.setStatus("1");
	     pim.setCreatedDate(new Date());
	     pim.setShopId(CurrentUserUtil.getShopId());
	     if(pid!=null){
			pim.setItemId(pid);	
			}
	     producimageService.insert(pim);
	     model.put("json", pim.getId());
		return "common/json";
	}
	@RequestMapping("deleteImage")
	public String deleteImage(Integer id,ModelMap model){
		this.setLayout(LayoutType.EMPTY);
		ProducimageModel pm=producimageService.getById(id);
		File file=new File(pm.getPath());
		if(file.exists()){
			file.delete();
		}
		producimageService.del(id);
		return "common/json";
	}
}