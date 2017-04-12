	
	
/**
 *  跳音频详情
 * @param userName
 * @param id
 */
function audioDetails(userName,id){		
		window.open("audio-lawyer.htm?userName="+userName+"&defaultId="+id);		
	}



function audio(id){		
	window.open("audio-load.htm?id="+id);	
	return false;
}
/**
 * 跳视频详情
 * @param userName
 * @param id
 */
function videoDetails(userName,id){		
		window.open("lawyer-video.htm?userName="+userName+"&defaultId="+id);
		
	}


function video(id){		
	window.open("videoInfo-load.htm?id="+id);
	
}
/**
 * 跳博文详情
 * @param userName
 * @param id
 */
function blogsDetails(userName,id){
		window.open("blog-view.htm?userName="+userName+"&defaultId="+id);
	}



/**
 * 跳新闻的详情
 * @param id
 */
function newsDetails(id){
		window.open("news-detail.htm?id="+id);
	}

/**
 * 跳律云观点的详情
 * @param id
 */
function viewPointDetails(id){
		window.open("viewpoint-details.htm?id="+id);
	}

/**
 * 评论区获取焦点
 * @returns {Boolean}
 */
function replyBtu(){
	   //获取父级窗口的ifram对象
	   var frameDoc=document.getElementById('consultIframe').contentWindow.document;
	   frameDoc.getElementById("comment_content").focus();
}

	