function ajaxFileUpload(pid){
               jQuery.ajaxFileUpload({
                url:'product-iamge-upload.htm?pid='+pid,            // 需要链接到服务器地址
                secureuri:false,
                data:"pid="+pid,
                fileElementId:'itemImageFile',                        // 文件选择框的id属性
                dataType: 'json',                                     // 服务器返回的格式，可以是json
                success: function (data, status)            // 相当于java中try语句块的用法
                {      
                	if($("img[class='itemImage']").length > 0){
                		$("img[class='itemImage']:last").after("<img src=\"item-image-"+data+".htm\" width=\"90px\" height=\"90px\"  class=\"itemImage\"  imageId=\""+data+"\"/>");
                	}else{
                		$("a[class='fl']:first").before("<img src=\"item-image-"+data+".htm\" width=\"90px\" height=\"90px\"  class=\"itemImage\" imageId=\""+data+"\"/>");
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