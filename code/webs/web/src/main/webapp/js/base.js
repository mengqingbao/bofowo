function buyer_collect(id,tp){
	jQuery.ajax({
             type: "GET",
             url: "consumer-item-collect-add.htm",
             data: {id:id,type:tp},
             dataType: "json",
             success: function(data){
               console.log(data);
               alert("success");
               
             }
         });
}
function validateFileType(obj){
	   
	 var oIfile = obj.value;
		var format = oIfile.toLowerCase().substr(oIfile.lastIndexOf('.'));
		var fmt = 'jpg/png//pdf';
		if(format=='.jpg' || format=='.png' || format=='.jpeg' || format=='.doc' || format=='.docx' || format=='.xls' || format=='.xlsx' || format=='.zip' || format=='.rar' || format=='.pdf'){
			return true;
		}else{
			alert('上传失败,请上传'+fmt+'的后缀名格式');
			return false;
		}

}