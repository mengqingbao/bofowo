//立即支付
function doPayAction(status,tradeId,orderId){
	jQuery.ajax({
	     type: 'post',
	     url: 'processTradeAction.htm?tradeId='+tradeId+'&orderId='+orderId+'&actionType=payAction',
	     dataType:'json',
	     success:function(data){
	     	alert(data.message);
	     }
	});
}
//发货
//卖家
function doExpressAction(status,tradeId,orderId){
	jQuery.ajax({
	     type: 'post',
	     url: 'processTradeAction.htm?tradeId='+tradeId+'&orderId='+orderId+'&actionType=expressAction&status='+status,
	     dataType:'json',
	     success:function(data){
	     	alert(data.message);
	     }
	});
}
//发送信息给卖家发货
function sendTip(tradeId,orderId){
	jQuery.ajax({
	     type: 'post',
	     url: 'processTradeAction.htm?tradeId='+tradeId+'&orderId='+orderId+'&actionType=tipAction',
	     dataType:'json',
	     success:function(data){
	     	alert(data.message);
	     }
	});
}

//确认收货
function doFinishedAction(status,tradeId,orderId,csfr){
	jQuery.ajax({
	     type: 'post',
	     url: 'processTradeAction.htm?tradeId='+tradeId+'&orderId='+orderId+'&actionType=finishedAction&status='+status+'&_csrf='+csfr,
	     dataType:'json',
	     success:function(data){
	     	alert(data.message);
	     }
	});
}
//其他综合操作
function doAction(status,tradeId,actionType){
	jQuery.ajax({
	     type: 'post',
	     url: 'processTradeAction.htm?tradeId='+tradeId+'&actionType='+actionType+'&status='+status+'&_csrf='+window.csrf_,
	     dataType:'json',
	     success:function(data){
	     	window.location.reload();
	     }
	});
}

function submitForm(){
	jQuery.ajax({
	     type: 'post',
	     url: 'processTradeAction.htm?tradeId='+tradeId+'&actionType='+actionType+'&status='+status+'&_csrf='+window.csrf_,
	     dataType:'json',
	     success:function(data){
	     	window.location.reload();
	     }
	});
}
//查看订单详情
function tradeDetail(tradeId,orderId){
	jQuery.ajax({
	     type: 'post',
	     url: 'processTradeAction.htm?tradeId='+tradeId+'&orderId='+orderId+'&actionType=tipAction',
	     dataType:'json',
	     success:function(data){
	     	alert(data.message);
	     }
	});
}
//退货
function backProduct(tradeId,orderId){
	jQuery.ajax({
	     type: 'post',
	     url: 'processTradeAction.htm?tradeId='+tradeId+'&orderId='+orderId+'&actionType=backAction',
	     dataType:'json',
	     success:function(data){
	     	alert(data.message);
	     }
	});
}

//投诉
function complaint(status,tradeId,orderId){
	jQuery.ajax({
	     type: 'post',
	     url: 'processTradeAction.htm?tradeId='+tradeId+'&orderId='+orderId+'&actionType=complaintAction',
	     dataType:'json',
	     success:function(data){
	     	alert(data.message);
	     }
	});
	
}

//售后服务
function customerCare(tradeId,orderId){
	jQuery.ajax({
	     type: 'post',
	     url: 'processTradeAction.htm?tradeId='+tradeId+'&orderId='+orderId+'&actionType=tipAction',
	     dataType:'json',
	     success:function(data){
	     	alert(data.message);
	     }
	});
}

