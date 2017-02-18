package com.bofowo.site.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.druid.support.json.JSONUtils;
import com.bofowo.site.service.ProducimageService;
import com.bofowo.util.DateUtil;

import common.security.login.CurrentUserUtil;
import common.util.LayoutType;
import common.web.BaseController;


@Controller
public class FileController extends BaseController{

	@Autowired
	private ProducimageService producimageService;
	
	@Value("#{settings['upload.lyun.path']}")
	private String path;

	@RequestMapping("photo/upload")
	public String ajaxuploadify(ModelMap model,@RequestParam("logoImgFile") CommonsMultipartFile file,Integer pid){
		Map<String,String> result=new HashMap<String,String>();
		this.setLayout(LayoutType.EMPTY);
		String createFileName=null;
	            if(!file.isEmpty()){  
	                int pre = (int) System.currentTimeMillis();  
	                try {  
	                	String fileName=file.getOriginalFilename();
	                	String prefix=fileName.substring(fileName.lastIndexOf(".")+1);
	                	String newFileName=new Date().getTime() +"."+prefix;
	                	createFileName="scroll/"+ DateUtil.forMat(new Date())+"/" + newFileName;
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
	     
	     model.put("json", JSONObject.fromObject(result).toString());
		return "common/json";
	}
	
}