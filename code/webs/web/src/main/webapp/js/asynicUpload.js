(function($) {
	var isAready=false;
	 var optDefaults = { 
			   uploadUrl : "common/upload/file", 
			   deleteUrl : "common/del/file", 
			   mulit : false,
	 		   uploadAjax:false 
	};
	 
	 var opts = {};
	$.fn.asyncUpload=function(list,options){ 
		 var obj=$(this);
		
		 opts = $.extend(optDefaults, options);
		 if(obj.length<1 && !isAready){
			 alert("the selected object don't exist.");
			 return false;
		 }
		 if(!isAready){
			 init(obj);
			 bindEvent();
			 moreBtnBind();
			 isAready=true;
		 }
		 if(list!=""){
			 setList(list)
		 }
 
      };
     init=function(obj){
    	obj.replaceWith("<form class=\"fl inp_file_con\" enctype=\"multipart/form-data\" name=\"upfiles\" method=\"post\" action=\"\">"+
    			"<input type=\"file\" id=\"photoFile\" name=\"photoFile\" style=\"display:none\"/><input type=\"hidden\" id=\"fileName\" name=\"fileName\"/>"+
    			"<input type=\"button\" id=\"browseButton\" class=\"btn_enclosure\"value=\"上传附件\">" +
    			"<div class=\"file_name\">" +
    			"<ul id=\"enclosure_names\" class=\"file-name\"></ul>" +
    			"<a id=\"moreButton\" class=\"more\" href=\"javascript:void(0)\" style=\"display: none;\">更多&gt;&gt;</a></div></form>");
    	
    	$("#browseButton").click(function(){   
        	 
        	 var ie=navigator.appName=="Microsoft Internet Explorer" ? true : false; 
        	 if(ie){ 
        		 document.getElementById("photoFile").click(); 
        	 	 document.getElementById("fileName").value=document.getElementById("photoFile").value;
        	 }else{
        		 var a=document.createEvent("MouseEvents");//FF的处理 
        	 	 a.initEvent("click", true, true);  
        	 	 document.getElementById("photoFile").dispatchEvent(a); 
        	 	 document.getElementById("fileName").value=document.getElementById("photoFile").value;
        	 }
          }); 
    	
     }
     setList=function(list){
    	 if(isAready){
    		 $.each(list, function (key, value) {
             		$("#enclosure_names").append('<li id="' + value.tId + '"><span id="' + value.fileNameSave + '">' + value.fileNameUpload + '</span><a class="file-name_blue" href="${ctx}/cms/attachments/downloadAttachmentByUrl3?fileName='+encodeURI(encodeURI(value.fileNameUpload))+'&pathUrl='+value.fileNameSave+'">点击下载</a>' +
            		 '<a class="file-name_red dela" href="javascript:void(0)"  tid="' + value.tId + '">删除</a></li>');
             		var oLi = $('#enclosure_names li');
		   		    oLi.each(function(){
					var oSpan = $(this).find('span');
					var oHtml = oSpan.html();
					var point = oHtml.lastIndexOf(".");
					var intMat = oHtml.substr(point);
					if(intMat == '.docx' || intMat == '.doc'){
						oSpan.parent().addClass('format_word');
					}else if(intMat == '.jpg' || intMat == '.png' || intMat == '.gif'){
						oSpan.parent().addClass('format_jpg');
					}else if(intMat == '.rar' || intMat == '.zip'){
						oSpan.parent().addClass('format_rar');
					}else if(intMat == '.pdf'){
						oSpan.parent().addClass('format_pdf');
					}else if(intMat == '.xls' || intMat == '.xlsx'){
						oSpan.parent().addClass('format_exl');
					}else if(intMat == '.txt'){
						oSpan.parent().addClass('format_all');
					}else{
						oSpan.parent().addClass('format_unknown');
					}
		   		});
    	 	});
    	 }
    	 checkFileCount();
    	 asyncBind();
     }
     bindEvent=function(){
    	 $("#photoFile").unbind('change');
    	 $("#photoFile").bind('change',function(){
    		 if(validateFileType(this) == true){
    			   $("#fileName").val(getFileName($("#photoFile").val()));
    			   if(opts.mulit){
    				   uploadFile();
    			   }
    		    }else{
    		    	return false;
    		    }
	    	});
     }
     asyncBind=function(){
    	 $(".dela").unbind('click');
    	 $(".dela").bind('click',function(){deleteFileById(jQuery(this).attr("tid"))});
     }
     moreBtnBind=function(){
    	$("#moreButton").unbind('click');
 		$("#moreButton").bind('click',function(){showAllListFile()});
     }
   //js 遮罩效果
     openMask=function() {
         var newMaskID = "mask_"; //遮罩层id
         var newMaskWidth = document.body.scrollWidth;//遮罩层宽度
         var newMaskHeight = document.body.scrollHeight;//遮罩层高度
     //mask遮罩层 
         var newMask = document.createElement("div");//创建遮罩层
         newMask.id = newMaskID;//设置遮罩层id
         newMask.style.position = "absolute";//遮罩层位置
         newMask.style.zIndex = "100001";//遮罩层zIndex
         newMask.style.width = newMaskWidth + "px";//设置遮罩层宽度
         newMask.style.height = newMaskHeight + "px";//设置遮罩层高度
         newMask.style.top = "0px";//设置遮罩层于上边距离
         newMask.style.left = "0px";//设置遮罩层左边距离
         newMask.style.background = "gray";//#33393C//遮罩层背景色
         newMask.style.filter = "alpha(opacity=40)";//遮罩层透明度IE
         newMask.style.opacity = "0.40";//遮罩层透明度FF
         document.body.appendChild(newMask);//遮罩层添加到DOM中
     };
     newDivCenter=function() {
         var centerDiv = document.createElement("div");
         var centerDivHeight = 200;
         var centerDivWidth = 300;
         centerDiv.innerHTML = "<img src='/images/uploading.gif' width=\"" + centerDivWidth + "\"/>";
         centerDiv.id = "newCenterDiv_";
         centerDiv.style.position = "absolute";
         centerDiv.style.width = centerDivWidth + "px";
         centerDiv.style.height = centerDivHeight + "px";
         centerDiv.style.top = ($(window).height() / 2 + $(document).scrollTop() - centerDivHeight / 2) + "px";
         centerDiv.style.left = ($(window).width() / 2 - centerDivWidth / 2) + "px";
         centerDiv.style.background = "gray";
         centerDiv.style.zIndex = "100002";
         /*	if(document.all){//处理滚动事件，使弹出层始终居中
          window.attachEvent("onscroll",newDivCenter);
          }else{
          window.addEventListener('scroll',newDivCenter,false);
          } */
         document.body.appendChild(centerDiv);
     };
     //   上传模块
     uploadFile=function() {
         // $("body").append("<div id=\"mask_\" style=\"position: absolute; top: 0px; filter: alpha(opacity=60); background-color: #777;z-index: 1002; left: 0px;opacity:0.5; -moz-opacity:0.5\"></div> ");
    	 console.log();
    	 openMask();
         newDivCenter();
         //$("#enclosure_names").append("<span id=\"uploadingImage\"><img src='/images/uploading.gif'/></span>")
         $.ajaxFileUpload({
             url: root + opts.uploadUrl, //用于文件上传的服务器端请求地址
             secureuri: false, //是否需要安全协议，一般设置为false
             fileElementId: 'photoFile', //文件上传域的Name
             dataType: 'json', //返回值类型 一般设置为json
             data: {
                 folderName: "bidList",
                 fileNameUpload: jQuery("#fileName").val()
             },
             success: function (data, status)  //服务器成功响应处理函数
             {
                 if (data.code == 1) {
                     value = data.object;
                     $("#enclosure_names").append('<li id="' + value.tId + '"><span id="' +
                         value.fileNameSave + '">' + value.fileNameUpload + '</span><a class="file-name_blue" ' +
                         //'href="' + root + value.fileNameSave + '">点击下载</a>' +
                         ' href="' + root + '/cms/attachments/downloadAttachmentByUrl3?fileName=' + encodeURI(encodeURI(value.fileNameUpload)) + '&pathUrl=' + value.fileNameSave + '">点击下载</a>' +
                         '<a class="file-name_red dela" href="javascript:void(0)" tid="' + value.tId + '">删除</a></li>');
                     var oLi = $('#enclosure_names li');
                     oLi.each(function () {
                         var oSpan = $(this).find('span');
                         var oHtml = oSpan.html();
                         var point = oHtml.lastIndexOf(".");
                         var intMat = oHtml.substr(point);
                         if (intMat == '.docx' || intMat == '.doc') {
                             oSpan.parent().addClass('format_word');
                         } else if (intMat == '.jpg' || intMat == '.png' || intMat == '.gif') {
                             oSpan.parent().addClass('format_jpg');
                         } else if (intMat == '.rar' || intMat == '.zip') {
                             oSpan.parent().addClass('format_rar');
                         } else if (intMat == '.pdf') {
                             oSpan.parent().addClass('format_pdf');
                         } else if (intMat == '.xls' || intMat == '.xlsx') {
                             oSpan.parent().addClass('format_exl');
                         } else if (intMat == '.txt') {
                             oSpan.parent().addClass('format_all');
                         } else {
                             oSpan.parent().addClass('format_unknown');
                         }
                     });
                 }
                 if (data.code == 101) {
                     alert("上传附件不能超过50M");
                 }
                 asyncBind();
             },
             error: function (data, status, e)//服务器响应失败处理函数
             {
                 alert(e);
             },
             complete: function () {
                 setTimeout(function () {
                     $("#mask_").remove();
                     $("#newCenterDiv_").remove();
                 }, 500);
                 checkFileCount();
             }
         });
         bindEvent();
     }
     
     MakeForm=function(){  
    	    // 创建Form  
    	    var form = $('<form></form>');  
    	    // 设置属性  
    	    form.attr('method', 'post');  
    	    form.attr('method', 'post'); 
    	    form.attr('enctype','multipart/form-data');
    	    // form的target属性决定form在哪个页面提交  
    	    // _self -> 当前页面 _blank -> 新页面  
    	    form.attr('target', '_self');  
    	    // 创建Input  
    	    var my_input = $('<input type="file" name="file" />');  
    	     
    	    // 附加到Form  
    	    form.append(my_input);  
    	    // 提交表单  
    	   // form.submit();  
    	    // 注意return false取消链接的默认动作  
    	    return form;  
    	}  
     
     //验证允许文件类型
     validateFileType=function(obj){
  	   
    	 var oIfile = obj.value;
    		var format = oIfile.toLowerCase().substr(oIfile.lastIndexOf('.'));
    		var fmt = 'jpg/png/doc/docx/xls/xlsx/zip/rar/pdf';
    		if(format=='.jpg' || format=='.png' || format=='.jpeg' || format=='.doc' || format=='.docx' || format=='.xls' || format=='.xlsx' || format=='.zip' || format=='.rar' || format=='.pdf'){
    			return true;
    		}else{
    			alert('上传失败,请上传'+fmt+'的后缀名格式');
    			return false;
    		}

     }
     
     deleteFileById=function(modelId){
    	 if(confirm("确认删除附件?")){
    	   $.ajax({
    	        url: root + opts.deleteUrl,
    	        dataType: "json",
    	        type: "post",
    	        data: {
    	            modelId: modelId
    	        },
    	        success: function (data) {
    	            if (data.code == 1) {
    	               // alert("删除成功");
    	                $("#enclosure_names").children('#' + modelId).remove();
    	                checkFileCount();
    	            }
    	        }
    	    });
    	 }
    	}
     
     getFileName=function(path){
    	 var pos1 = path.lastIndexOf('/');
    	 var pos2 = path.lastIndexOf('\\');
    	 var pos  = Math.max(pos1, pos2)
    	 if( pos<0 )
    	 return path;
    	 else
    	 return path.substring(pos+1);
    	 }
     
     checkFileCount=function(){
    		var count = $("#enclosure_names li").length;
    		
    		if(count > 3){
    			$("#enclosure_names").addClass("screen_height");
    	        $("#moreButton").show();
    	    }else{
    	        $("#moreButton").hide();
    	        $("#enclosure_names").removeClass("screen_height");
    		}
    		
    	}
     showAllListFile=function(){
    	 $("#enclosure_names").removeClass("screen_height");
    	 $("#moreButton").hide();
     }
})(jQuery);  