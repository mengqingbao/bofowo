function ajaxFileUpload(pid){
               jQuery.ajaxFileUpload({
                url:'product-iamge-upload.htm?pid='+pid,            // 需要链接到服务器地址
                secureuri:false,
                data:"pid="+pid,
                fileElementId:'itemImageFile',                        // 文件选择框的id属性
                dataType: 'json',                                     // 服务器返回的格式，可以是json
                success: function (data, status)            // 相当于java中try语句块的用法
                {      
                	var html='<div style="float: left;" class="imgdiv">'+
       	 		  			    '<div style="position:relative;">'+
  				  				'<img src="item-image-'+data+'.htm" width="90px" height="90px" class="itemImage" imageId="'+data+'"/>'+
  				  				'<input type="button" value="删除" style="position:absolute; top:0; right:0; z-index:99;" onclick="deleteImage('+data+')"/>'+
  				  				'</div>'+
  				  				'</div>';
                	if($("img[class='itemImage']").length > 0){
                		
                		console.log(html);
                		$("#fldiv").before(html);
                		
                	}else{
                		$("#fldiv").before(html);
                	}
                	if($("img[class='itemImage']").length > 5){
                		$("a[class='fl']:first").hide();
                	}
                	var str="";
                	$("img[class='itemImage']").each(function(){
                		if(str==""){
                			str=$(this).attr("imageId");
                		}else{
                			str+=";"+$(this).attr("imageId");
                		}
                		
                	});
                	
                	$("#images").val(str);
                },
                error: function (data, status, e)            /// /相当于java中catch语句块的用法
               {
                	 alert('添加成功');
                }
            }
                   
               );
}
//添加商品详情图片
function deleteImage(id){
	jQuery.ajax({
	     type: 'get',
	     url: 'deleteImage.htm?id='+id,
	     dataType:'json',
	     success:function(data){
	    	 if($("img[class='itemImage']").length > 5){
         		$("a[class='fl']:first").hide();
         	}else{
         		$("a[class='fl']:first").show();
         	}
         	var str="";
         	$("img[class='itemImage']").each(function(){
         		if(str==""){
         			str=$(this).attr("imageId");
         		}else{
         			str+=";"+$(this).attr("imageId");
         		}
         		
         	});
         	
         	$("#images").val(str);
         	console.log(jQuery("#"+id).html());
         	jQuery("#imgdiv"+id).remove();
	     }
	});
} 
function shopLogoUpload(){
    jQuery.ajaxFileUpload({
     url:'photo/upload.htm',            // 需要链接到服务器地址
     secureuri:false,
     dataType:'json', //返回值类型 一般设置为json
     fileElementId:'logoImgFile',                        // 文件选择框的id属性
     success:function(data, status){
    	 console.log(data.path);
     	$("#shopLogoImage").attr("src",imageService+data.path);
     	$("#logoImg").val(data.path);
     },
     error:function(data, status, e){
    	
     	 alert('数据传输异常。');
     }
 }
        
    );
}
 
function avatarUpload(){
    jQuery.ajaxFileUpload({
     url:'photo/upload.htm',            // 需要链接到服务器地址
     secureuri:false,
     dataType:'json', //返回值类型 一般设置为json
     fileElementId:'logoImgFile',                        // 文件选择框的id属性
     success:function(data, status){
    	 console.log(data.path);
     	$("#avatarImage").attr("src",imageService+data.path);
     	saveAvatar(data.path);
     	
     },
     error:function(data, status, e){
    	
     	 alert('数据传输异常。');
     }
 }
        
    );
}
function saveAvatar(path){
	
	jQuery.ajax({
	     type: 'post',
	     url: 'save-avatar.htm?path='+path,
	     dataType:'json',
	     success:function(data){
	     	alert(data.message);
	     }
	});
}