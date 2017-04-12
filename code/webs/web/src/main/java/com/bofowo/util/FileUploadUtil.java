/**
 * Project Name:bfwmall-web
 * File Name:FileUploadUtil.java
 * Package Name:com.bofowo.util
 * Date:2017年3月5日下午10:16:21
 * Copyright (c) 2017, BOFOWO Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import common.security.login.CurrentUserUtil;

/**
 * ClassName:FileUploadUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年3月5日 下午10:16:21 <br/>
 * @author   mqb
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class FileUploadUtil {
	
	public static String saveFile(CommonsMultipartFile file,String path) throws Exception{
		String result="";
		
        if(!file.isEmpty()){  
            try {  
            	String fileName=file.getOriginalFilename();
            	String prefix=fileName.substring(fileName.lastIndexOf(".")+1);
            	String newFileName=new Date().getTime() +"."+prefix;
            	result=CurrentUserUtil.getCurrentUserName()+"/shop/"+ DateUtil.forMat(new Date())+"/" + newFileName;
            	String createFileName=path+"/"+result;
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
                  
            } catch (Exception e) {  
               throw e;
            }  
    } 
        return result;
	}

}

