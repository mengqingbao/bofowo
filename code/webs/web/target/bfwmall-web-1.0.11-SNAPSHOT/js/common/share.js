/*第三方分享*/

  function shareToWb(pic,url){
	  
	    var windowHeight=$(window).height(); 
	    var windowWidth=$(window).width(); 
		var _t = encodeURI(document.title); 
		var _url = encodeURI(document.location.href); 
		  
		var _appkey = encodeURI("appkey");//你从腾讯获得的appkey 
		  
		var _pic = encodeURI(pic);//（列如：var _pic='图片url1|图片url2|图片url3....） 
		  
		var _site = 'www.law-cloud.com.cn'; //你的网站地址 
		  
		var _u = url+'?title='+_t+'&appkey='+_appkey+'&site='+_site+'&pic='+_pic+'&url='+encodeURIComponent(document.location.href); 
		var top= (windowHeight-680)/2 ;
		var left= (windowWidth-700)/2 ;
		window.open( _u,_t, 'width=700, height=680, top='+top+', left='+left+', toolbar=no, menubar=no, scrollbars=no, location=yes, resizable=no, status=no' ); 
 }
  
 $(function(){
	$('.share').click(function(){
		$('#share').show();
		return false;
	});

	
	$('.love').click(function(){
		 $("#lovemsg").fadeIn("500",function(){
			   $(this).delay(500).fadeOut("slow");
			});
		$(".love").css("background","url(../../img/news/love2.png)");
	});
	
	 $('#wbsina').click(function(){
		 
		 //抓取图片
//		 $('img').each(function(){
//			 
//		 });
		 shareToWb('http://www.law-cloud.com.cn/img/common/logo.png','http://service.weibo.com/share/share.php');
		 $('#share').hide();
	 });
	 $('#qzone').click(function(){
		 shareToWb('http://www.law-cloud.com.cn/img/common/logo.png','http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey');
		 $('#share').hide();
	 });
	 $('#qqwb').click(function(){
		 shareToWb('http://www.law-cloud.com.cn/img/common/logo.png','http://v.t.qq.com/share/share.php');
		 $('#share').hide();
	 });
	 
	 $('#wbsina1').click(function(){
		 shareToWb('http://www.law-cloud.com.cn/img/common/logo.png','http://service.weibo.com/share/share.php');
		 $('#share').hide();
	 });
	 $('#qzone1').click(function(){
		 shareToWb('http://www.law-cloud.com.cn/img/common/logo.png','http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey');
		 $('#share').hide();
	 });
	 $('#qqwb1').click(function(){
		 shareToWb('http://www.law-cloud.com.cn/img/common/logo.png','http://v.t.qq.com/share/share.php');
		 $('#share').hide();
	 });
	 
	 //分享小框关闭按钮
	 $('#closeBtn').click(function(){
		   $('#share').hide();
	   })
 })
