package com.bofowo.site.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.druid.support.json.JSONUtils;
import com.bofowo.site.model.ProducimageModel;
import com.bofowo.site.service.PicSliderService;
import com.bofowo.site.service.ProducimageService;
import com.bofowo.util.DateUtil;

import common.security.login.CurrentUserUtil;
import common.util.LayoutType;
import common.web.BaseController;


@Controller
public class FileController extends BaseController{

	@Autowired
	private ProducimageService producimageService;
	@Resource
	private PicSliderService picSliderService;
	
	@Value("#{settings['upload.lyun.path']}")
	private String path;

	@RequestMapping("photo/upload")
	public String ajaxuploadify(ModelMap model,@RequestParam("logoImgFile") CommonsMultipartFile file,Integer pid){
		Map result=new HashMap();
		this.setLayout(LayoutType.EMPTY);
		String createFileName=null;
	            if(!file.isEmpty()){  
	                int pre = (int) System.currentTimeMillis();  
	                try {  
	                	String fileName=file.getOriginalFilename();
	                	String prefix=fileName.substring(fileName.lastIndexOf(".")+1);
	                	String newFileName=new Date().getTime() +"."+prefix;
	                	createFileName=CurrentUserUtil.getCurrentUserName()+"/shop/"+ DateUtil.forMat(new Date())+"/" + newFileName;
	                	result.put("path", createFileName);
	                	createFileName=path+"/"+createFileName;
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
	     
	     model.put("json", JSONUtils.toJSONString(result));
		return "common/json";
	}
	@RequestMapping("common/upload/file")
	public String uploadFile(ModelMap model,@RequestParam("logoImgFile") CommonsMultipartFile file,Integer id,String type){
		Map result=new HashMap();
		this.setLayout(LayoutType.EMPTY);
		String createFileName=null;
	            if(!file.isEmpty()){  
	                int pre = (int) System.currentTimeMillis();  
	                try {  
	                	String fileName=file.getOriginalFilename();
	                	String prefix=fileName.substring(fileName.lastIndexOf(".")+1);
	                	String newFileName=new Date().getTime() +"."+prefix;
	                	createFileName=CurrentUserUtil.getCurrentUserName()+"/shop/"+ DateUtil.forMat(new Date())+"/" + newFileName;
	                	result.put("path", createFileName);
	                	createFileName=path+"/"+createFileName;
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
	     
	     model.put("json", JSONUtils.toJSONString(result));
		return "common/json";
	}
	
	@RequestMapping("common/del/file")
	public String del(String filePath,Integer id){
		Map result=new HashMap();
		this.setLayout(LayoutType.EMPTY);
		
	     
		return "common/json";
	}	
}