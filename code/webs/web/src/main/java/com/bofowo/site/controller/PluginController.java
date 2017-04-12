package com.bofowo.site.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.baidu.ueditor.ActionEnter;
import com.bofowo.site.model.ProducimageModel;
import com.bofowo.site.service.ProducimageService;
import com.bofowo.util.DateUtil;

import common.security.login.CurrentUserUtil;
import common.util.LayoutType;
import common.util.StringUtil;
import common.web.BaseController;

@Controller
public class PluginController extends BaseController{

	@Value("#{settings['upload.lyun.path']}")
	private String path;
	
	@Autowired
	private ProducimageService producimageService;
	
	@RequestMapping("uedit")
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
	
	@RequestMapping("ajax-uploadify")
	public String ajaxuploadify(ModelMap model,@RequestParam("file") CommonsMultipartFile[] files){
		
		this.setLayout(LayoutType.EMPTY);
		model.put("json", "SUCCESS");
		 for(int i = 0;i<files.length;i++){  
	            System.out.println("fileName---------->" + files[i].getOriginalFilename());  
	          
	            if(!files[i].isEmpty()){  
	                int pre = (int) System.currentTimeMillis();  
	                try {  
	                	String extname=files[i].getOriginalFilename();
	                	String[] extnames=extname.split(".");
	                	if(extnames.length>1){
	                		extname=extnames[1];
	                	}
	                    //拿到输出流，同时重命名上传的文件  
	                    FileOutputStream os = new FileOutputStream(path+"/itemImages/"+CurrentUserUtil.getCurrentUserName()+"/"+ DateUtil.forMat(new Date())+"/" + new Date().getTime() +"."+extname);  
	                    //拿到上传文件的输入流  
	                    FileInputStream in = (FileInputStream) files[i].getInputStream();  
	                      
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
	                    System.out.println("上传出错");  
	                }  
	        }  
	        }  
		return "common/json";
	}
	
	
	@RequestMapping(value="item-image-{id}")
	public void  itemImage(ModelMap model,HttpServletResponse response,@PathVariable("id") Integer id){	
		String fileName=request.getSession().getServletContext().getRealPath("/")+"/images/noimage.jpg";
		
		if(id==null||id==0){
			fileName=request.getSession().getServletContext().getRealPath("/")+"/images/noimage.jpg";
		}
		ProducimageModel pim=producimageService.getById(id);
		if(pim==null){
			fileName=request.getSession().getServletContext().getRealPath("/")+"/images/noimage.jpg";
		}else{
			
			fileName=pim.getPath();
		}
			
	        File file = new File(fileName);
	        if(!file.exists()){
	        	file=new File(request.getSession().getServletContext().getRealPath("/")+"/images/noimage.jpg");
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
