package com.bofowo.site.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baidu.ueditor.ActionEnter;

import common.security.login.CurrentUserUtil;
import common.util.LayoutType;
import common.util.StringUtil;
import common.web.BaseController;

@Controller
public class PluginController extends BaseController{

	@Value("#{settings['upload.lyun.path']}")
	private String path;
	
	@RequestMapping("ueditor")
	public String editorController(HttpServletRequest request,ModelMap model){
		this.setLayout(LayoutType.EMPTY);
		String exec = new ActionEnter(request,path).exec();
		model.put("json", exec);
		return "common/json";
	}
	
	@RequestMapping(value="image-{name}")
	public void  user_img(ModelMap model,HttpServletResponse response,@PathVariable("name") String name){	
		if(StringUtil.isEmpty(name)){
			return ;
		}
			name=name.replace("-", "/");
			int position=name.lastIndexOf("/");
			String temp=name.substring(position, name.length());
			name=name.replace(temp, temp.replace("/", "."));
		  String fileName=path+"/ueditor/image/"+CurrentUserUtil.getCurrentUserName()+"/"+name;
	        File file = new File(fileName);
	        //判断文件是否存在如果不存在就返回默认图标
	        if(!file.exists()) {
	            file = new File(request.getSession().getServletContext().getRealPath("/")
	                    + "/img/personalCenter/miss.jpg");
	        }
	        byte[] data = new byte[(int)file.length()];	
	        OutputStream stream=null;
	        FileInputStream inputStream =null;
	        
	        try {
	        	  inputStream = new FileInputStream(file);
	        	  int length = inputStream.read(data);
	        	  String str=file.getName().substring(file.getName().lastIndexOf(".")+1);
	        	  
	        	 response.setContentType("image/"+str);
	 	         stream = response.getOutputStream();
	 	         stream.write(data);
	 	         stream.flush();
	 	        
			} catch (IOException e) {
				// TODO Auto-generated catch block
				log.error(e.getMessage());
			}finally{
				 try {
					 
					 if(stream!=null)
					stream.close();
					 if(inputStream!=null)
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					log.error(e.getMessage());
				}
				
			}
	       
		
	}
	
}
