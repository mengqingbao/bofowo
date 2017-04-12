function propAllCheck(){
 	if(jQuery(this).is(':checked')){
 		jQuery(".propCheck").each(function(){
			jQuery(this).prop("checked",true);
  			});
 	}else{
 		jQuery(".propCheck").each(function(){
			jQuery(this).prop("checked",false);
  			});
 	}
 }
 function specAllCheck(){
 	console.log(jQuery(this).is(':checked'));
 	if(jQuery(this).is(':checked')){
 		jQuery(".propCheck").each(function(){
			jQuery(this).prop("checked",true);
  			});
 	}else{
 		jQuery(".propCheck").each(function(){
			jQuery(this).prop("checked",false);
  			});
 	}
 }