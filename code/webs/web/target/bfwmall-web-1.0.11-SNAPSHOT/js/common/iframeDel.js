/**
 * 删除
 * @param url
 * @returns {Boolean}
 */
function del(url){
	if(window.confirm("您确定要删除吗?")){
		
		jQuery.ajax({
			url:url,
		    success:function(){
		    	window.parent.location.reload();
		    }
		});
		
		
	}else{
		return false;
	}
}
