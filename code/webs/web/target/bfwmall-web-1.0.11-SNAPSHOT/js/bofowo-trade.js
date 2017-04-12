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

jQuery.fn.extend({
    uploadPreview: function (opts) {
        var _self = this,
            _this = $(this);
        opts = jQuery.extend({
            Img: "ImgPr",
            Width: 100,
            Height: 100,
            ImgType: ["gif", "jpeg", "jpg", "bmp", "png"],
            Callback: function () {}
        }, opts || {});
        _self.getObjectURL = function (file) {
            var url = null;
            if (window.createObjectURL != undefined) {
                url = window.createObjectURL(file)
            } else if (window.URL != undefined) {
                url = window.URL.createObjectURL(file)
            } else if (window.webkitURL != undefined) {
                url = window.webkitURL.createObjectURL(file)
            }
            return url
        };
        _this.change(function () {
            if (this.value) {
                if (!RegExp("\.(" + opts.ImgType.join("|") + ")$", "i").test(this.value.toLowerCase())) {
                    alert("选择文件错误,图片类型必须是" + opts.ImgType.join("，") + "中的一种");
                    this.value = "";
                    return false
                }
                if ($.browser.msie) {
                    try {
                        $("#" + opts.Img).attr('src', _self.getObjectURL(this.files[0]))
                    } catch (e) {
                        var src = "";
                        var obj = $("#" + opts.Img);
                        var div = obj.parent("div")[0];
                        _self.select();
                        if (top != self) {
                            window.parent.document.body.focus()
                        } else {
                            _self.blur()
                        }
                        src = document.selection.createRange().text;
                        document.selection.empty();
                        obj.hide();
                        obj.parent("div").css({
                            'filter': 'progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)',
                            'width': opts.Width + 'px',
                            'height': opts.Height + 'px'
                        });
                        div.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = src
                    }
                } else {
                    $("#" + opts.Img).attr('src', _self.getObjectURL(this.files[0]))
                }
                opts.Callback()
            }
        })
    }
});
