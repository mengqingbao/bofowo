/*-------------------------------------------------------------------- 
 * jQuery plugin: customInput()
 * by Maggie Wachs and Scott Jehl, http://www.filamentgroup.com
 * Copyright (c) 2009 Filament Group
 * Dual licensed under the MIT (filamentgroup.com/examples/mit-license.txt) and GPL (filamentgroup.com/examples/gpl-license.txt) licenses.
 * Article: http://www.filamentgroup.com/lab/accessible_custom_designed_checkbox_radio_button_inputs_styled_css_jquery/  
 * Usage example below (see comment "Run the script...").
--------------------------------------------------------------------*/


jQuery.fn.customInput = function(){
	$(this).each(function(i){	
		if($(this).is('[type=checkbox],[type=radio]')){
			var input = $(this);
			
			// get the associated label using the input's id
			var label = $('label[for='+input.attr('id')+']');
			
			//get type, for classname suffix 
			var inputType = (input.is('[type=checkbox]')) ? 'checkbox' : 'radio';
			
			// wrap the input + label in a div 
			$('<div class="custom-'+ inputType +'"></div>').insertBefore(input).append(input, label);
			
			// find all inputs in this set using the shared name attribute
			var allInputs = $('input[name='+input.attr('name')+']');
			
			// necessary for browsers that don't support the :hover pseudo class on labels
			label.hover(
				function(){ 
					$(this).addClass('hover'); 
					if(inputType == 'checkbox' && input.is(':checked')){ 
						$(this).addClass('checkedHover'); 
					} 
				},
				function(){ $(this).removeClass('hover checkedHover'); }
			);
			
			//bind custom event, trigger it, bind click,focus,blur events					
			input.bind('updateState', function(){	
				if (input.is(':checked')) {
					if (input.is(':radio')) {				
						allInputs.each(function(){
							$('label[for='+$(this).attr('id')+']').removeClass('checked');
						});		
					};
					label.addClass('checked');
				}
				else { label.removeClass('checked checkedHover checkedFocus'); }
										
			})
			.trigger('updateState')
			.click(function(){ 
				$(this).trigger('updateState'); 
			})
			.focus(function(){ 
				label.addClass('focus'); 
				if(inputType == 'checkbox' && input.is(':checked')){ 
					$(this).addClass('checkedFocus'); 
				} 
			})
			.blur(function(){ label.removeClass('focus checkedFocus'); });
		}
	});
};
//div相对定位
function moveDiv(moveId,initTop,endTop){
	var p = $("#"+moveId);  
	var offset = p.offset();
	var initLeft=offset.left;
	var d = $(document).scrollTop();
	var  e = $(window).height();
	if(d>=initTop){
		var mkm=p.height()+145;
		var nbn=$(document).height()-$(window).scrollTop();
		if(nbn<mkm){
		}else{
			p.offset({ top:$(window).scrollTop() , left:initLeft});
		}		
		if(endTop!="" && d>=endTop){			
			p.offset({ top:endTop, left:initLeft});
		}
	}
	if(d<initTop){
		p.offset({ top:initTop , left:initLeft});
	}
}

function moveDivHeight(moveId,initTop,endTop,height){
	var p = $("#"+moveId);  
	var offset = p.offset();
	var initLeft=offset.left;
	var d = $(document).scrollTop();
	var  e = $(window).height();
	if(d>=initTop){
		//alert(height);
		var mkm=p.height()+200;
		var nbn=$(document).height()-$(window).scrollTop();
		if(nbn<mkm){
			p.offset({ top:$(document).height()-p.height()-200 , left:initLeft});
		}else{
			p.offset({ top:$(window).scrollTop() , left:initLeft});
		}		
		if(endTop!="" && d>=endTop){			
			p.offset({ top:endTop, left:initLeft});
		}
		if(moveId=="content_right"){
			$('#share').removeClass("share1");
		  	$('#share').addClass("share2");
		  	$('#lovemsg').removeClass("love_msg");
		  	$('#lovemsg').addClass("love_msg2");
		}
		
	}
	if(d<initTop){
		p.offset({ top:initTop , left:initLeft});
	}
}

function iFrameHeight(ifm) { 
   var subWeb = document.frames ? ifm.document : ifm.contentDocument; 
   if(ifm != null && subWeb != null) { 
  	// ifm.height = subWeb.body.scrollHeight; 
	   if ((navigator.userAgent.indexOf('MSIE') >= 0) 
			    && (navigator.userAgent.indexOf('Opera') < 0)){
			   // alert('你是使用IE')
		  // alert(ifm.attr("id"));
			    ifm.height=myIframe.document.body.scrollHeight;
			}else if (navigator.userAgent.indexOf('Firefox') >= 0){
			   // alert('你是使用Firefox')
			    ifm.height = subWeb.body.scrollHeight;
			}else if (navigator.userAgent.indexOf('Opera') >= 0){
			    //alert('你是使用Opera')
			    ifm.height = subWeb.body.scrollHeight;
			}else{
			    //alert('你是使用其他的浏览器浏览网页！')
			    ifm.height = subWeb.body.scrollHeight;
			}	  	 
   } 
   
}

function iFrameHeightIE(ifm,frameid) { 
	   var subWeb = document.frames ? ifm.document : ifm.contentDocument; 
	   if(ifm != null && subWeb != null) { 
	  	// ifm.height = subWeb.body.scrollHeight; 
		   if ((navigator.userAgent.indexOf('MSIE') >= 0) 
				    && (navigator.userAgent.indexOf('Opera') < 0)){
			   //alert(consultIframe.document.body.scrollHeight);
				   // alert('你是使用IE')
				    ifm.height=frameid.document.body.scrollHeight;
				}else if (navigator.userAgent.indexOf('Firefox') >= 0){
				   // alert('你是使用Firefox')
				    ifm.height = subWeb.body.scrollHeight;
				}else if (navigator.userAgent.indexOf('Opera') >= 0){
				    //alert('你是使用Opera')
				    ifm.height = subWeb.body.scrollHeight;
				}else{
				    //alert('你是使用其他的浏览器浏览网页！')
				   
				    ifm.height = subWeb.body.scrollHeight;
				}	  	 
	   } 
	   
	}
