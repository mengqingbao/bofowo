


//判断文件类型和文件大小
	function checkFileType(obj,filetypes,FileSize)
    {
		
      var isCheckFlag = false;
	  var upfileType =  obj.value;   //
	       
	        var fileExtend = upfileType.substring(upfileType.lastIndexOf('.')).toLowerCase();  
	         fileExtend = fileExtend.toLowerCase();
	        if(filetypes.length>0){ 
	        	for(var i =0; i<filetypes.length;i++){ 
	        		
		        		if(filetypes[i]==fileExtend){ 
		        			isCheckFlag = true;
		        		    break; 
		        		} 
	        		} 

	        	
	        }
	        

            var filetypeList = " ";
	        if(!isCheckFlag){ 
	        	for(var i =0; i<filetypes.length;i++){ 
	        		filetypeList += filetypes[i];
        		} 
	            alert('文件格式不正确,只能上传'+filetypeList+'格式');
	            return false;  
             }  
	        
	         var fileSize = 0;
	            var isIE = /msie/i.test(navigator.userAgent) && !window.opera;            
	            if (isIE && !obj.files) {          
	                 var filePath = obj.value;            
	                 var fileSystem = new ActiveXObject("Scripting.FileSystemObject");   
	                 var file = fileSystem.GetFile (filePath);               
	                 fileSize = file.Size;  
	                 alert(fileSize); 
	            }else {  
	                 fileSize = obj.files[0].size;     
	            } 
	            fileSize=Math.round(fileSize/1024*100)/100; //单位为KB
	            if(fileSize>=FileSize){
	                alert("文件的最大尺寸为"+(FileSize/1024)+"MB，请重新上传!");
	                return false;
	            }
	        return true;
        
    }