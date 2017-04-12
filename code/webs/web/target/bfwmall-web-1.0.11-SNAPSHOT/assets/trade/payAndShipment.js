﻿function isDoRefresh(cartJson,type) {
  //如果商品串不相等则刷新商品清单
  var sopCartJson = $("#sopCartJson").val();
  //如果保存的是大家电配送时间也需要刷新，否则安装时间偏移量计算不准确
  var isRefreshInstallDate = $("#is_refresh_installdate").val();
  if (cartJson != sopCartJson || isRefreshInstallDate == "1") {
    $("#is_refresh_installdate").val("");
    save_Pay(payId);
    return;
  }
  //否则刷新价格
  var actionUrl = OrderAppConfig.DynamicDomain + "/payAndShip/getAdditShipment.action";
  var payId = $('.payment-item.item-selected').attr('payId');
  var otype = $('.payment-item.item-selected').attr('onlinepaytype');
  var reset311 = $('#reset_promise_311').val();
  if (isEmpty(payId)) {
    payId = 4;
  }
  if (isEmpty(otype)) {
	 otype = 0;
  }
  var param = "paymentId=" + payId;
  param = param + "&shipParam.reset311="+reset311+"&shipParam.onlinePayType="+otype;
  param = addFlowTypeParam(param);
  var easyBuyFlag = $("#easyBuyFlag").val();
  if(easyBuyFlag == "1"||easyBuyFlag=="2"){
    param += "&ebf=" + easyBuyFlag;
  }
  jQuery.ajax({
    type: "POST",
    dataType: "json",
    url: actionUrl,
    data: param,
    cache: false,
    success: function(dataResult, textStatus) {
      // 没有登录跳登录
      if (isUserNotLogin(dataResult)) {
        goToLogin();
        return;
      }
      doResetShipTime(dataResult.resetShipTime);
      //处理311、411日历信息 
      doDealCalenderInfo(dataResult);
      //处理自提信息
      doSelfPickStatus(dataResult.selfPick,0);

      var selfPickShutDownFlag = dataResult.isSelfPickShutDown;

      if(selfPickShutDownFlag == 1){
	  	  //轻松购和礼品购过来的按照原来的逻辑走，不相当于降级
	  	  if(easyBuyFlag == "1"||easyBuyFlag=="2" || isGiftBuy()){
	  		  $("#selfPickShutDownFlag").attr("value","0");
	  	  }else{
		  	  	if($(".selfPickInCommonItem").hasClass("item-selected")){
		  	  		$("#jd_shipment_item").addClass("hide");
		  	  	}else{
		  	  		$("#pick_shipment_item").addClass("hide");
		  	  	}
		    	$("#selfPickShutDownFlag").attr("value","1");
	  	  }
    }else{
  	  $("#selfPickShutDownFlag").attr("value","0");
    }
      
      //加载库存、获取店铺名称
      loadSkuListStock();
      doGetVendorName();
      showFerightInsure();
      //根据商品属性加载订单备注信息
      //loadOrderRemark(); 
      showPickDateList();

      flushOrderPrice(dataResult.orderPrice, false);
    },
    error: function(XMLHttpResponse) {
      //alert("系统繁忙，请稍后再试！");
      goOrder();
    }
  });
}

function doResetShipTime(resetShipTime) {
  if (resetShipTime == null) {
    return
  }
  if (resetShipTime.reset) {
    $("#jd_shipment_calendar_date").html(resetShipTime.shipName);
  }
}

/**
 * 处理311、411日历信息显示
 * @return
 */
function doDealCalenderInfo(dataResult) {
	if(dataResult.success==false){
		 $("#jd_shipment_calendar_date").html('<span class="ftx-03">配送时间：</span>工作日、双休日与节假日均可送货');
		 return;
	}
	$("#shipment_support_type").val(dataResult.suportShipType);
	$("#sopCartJson").val(dataResult.cartJson);
	if (dataResult.suportShipType == "1") { //如果只支持311
	    //设置日历参数
	    $("#calendar_hdata").val(JSON.stringify(dataResult.promise311.timeRangeTitle));
	    $("#calendar_ddata").val(JSON.stringify(dataResult.promise311.days));
	    //设置日历坐标
	    $("#calendar_x").val(dataResult.promise311.date_x);
	    $("#calendar_y").val(dataResult.promise311.date_y);
	    //设置上次选中的日期，时间段和sendpay
	    $("#last_sel_promiseDate").val(dataResult.promise311.promiseDate);
	    $("#last_sel_promiseTimeRange").val(dataResult.promise311.promiseTimeRange);
	    $("#last_sel_promiseSendPay").val(dataResult.promise311.promiseSendPay);
	    //显示修改按钮
	    $("#jdshipdate_eidt_id").removeClass("hide");
	    //默认选中311
	    $("#shipment_select_support").val("1");
	    //为311隐藏域赋值
	    $("#saveParam_promiseDate").val(dataResult.promise311.promiseDate); //311配送时间
	    $("#saveParam_promiseTimeRange").val(dataResult.promise311.promiseTimeRange); //预约配送时间段
	    $("#saveParam_promiseSendPay").val(dataResult.promise311.promiseSendPay);
	    $("#saveParam_promiseType").val(1); //预约配送类型，1表示311，2表示411
	    $("#saveParam_jdShipTime").val(4);
	    $("#jd_shipment_calendar_date").html(dataResult.promise311.show311Text);
	} else if (dataResult.suportShipType == "2") { //如果只支持411
	    /**
	     * author:zhuqingjie
	     * 目前线上311、411接口有问题，存在支持411但是不支持311的情况
	     * 此处做特殊处理，
	     */
	    $("#shipment_select_support").val("2");
	    if (dataResult.promise411.grayFlag) {
	      $("#shipment_cur411_support").val("2");
	      $("#saveParam_promiseType").val(""); //既不是311也不是411
	      $("#saveParam_jdShipTime").val(3); //节假日、工作日均可
	      //设置配送时间为节假日和工作日均可
	      $("#jd_shipment_calendar_date").html('<span class="ftx-03">配送时间：</span>工作日、双休日与节假日均可送货');
	    } else {
	      $("#saveParam_promiseType").val(2); //预约配送类型，1表示311，2表示411
	      $("#saveParam_jdShipTime").val(5); //节假日、工作日均可
	      $("#shipment_cur411_support").val("1");
	      //修改按钮显示
	      $("#jdshipdate_eidt_id").removeClass("hide");
	      $("#saveParam_promiseSendPay").val(dataResult.promise411.sendPay);
	    }
	} else if (dataResult.suportShipType == "3") { //如果311和411都支持     
	    //如果没有选中411，则默认选中311
	    $("#shipment411_sendpay").val(dataResult.promise411.sendPay);
	    if (dataResult.promise411.selected) {
	    	$("#shipment_select_support").val("2");
	    	$("#saveParam_promiseType").val(2); //预约配送类型，1表示311，2表示411  
	    	$("#saveParam_jdShipTime").val(5);
	    	$("#saveParam_promiseSendPay").val(dataResult.promise411.sendPay);
	    } else {
	    	//设置上次选中的日期，时间段和sendpay
	    	$("#last_sel_promiseDate").val(dataResult.promise311.promiseDate);
	    	$("#last_sel_promiseTimeRange").val(dataResult.promise311.promiseTimeRange);
	    	$("#last_sel_promiseSendPay").val(dataResult.promise311.promiseSendPay);
	    	//为311隐藏域赋值
	    	$("#saveParam_promiseDate").val(dataResult.promise311.promiseDate); //311配送时间
	    	$("#saveParam_promiseTimeRange").val(dataResult.promise311.promiseTimeRange); //预约配送时间段
	    	$("#saveParam_promiseSendPay").val(dataResult.promise311.promiseSendPay);
	    	$("#jd_shipment_calendar_date").html(dataResult.promise311.show311Text);
	    	$("#shipment_select_support").val("1");
	    	$("#saveParam_promiseType").val(1); //预约配送类型，1表示311，2表示411
	    	$("#saveParam_jdShipTime").val(4);
	    }
	    // 京东快递tips
	    if (dataResult.suportShipType == "0") {
	      $("#jdShip-span-tip .qmark-icon").attr('data-tips', '由京东公司负责配送，速度很快，还接受上门刷卡付款服务')
	    } else {
	      $("#jdShip-span-tip .qmark-icon").attr('data-tips', '此订单支持预约配送，您可以选择指定的时间段')
	    }
	    // 京东快递tips end

	    if (dataResult.promise411.grayFlag) {
	      $("#shipment_cur411_support").val("2");
	    } else {
	      $("#shipment_cur411_support").val("1");
	    }
	    //设置日历参数
	    $("#calendar_hdata").val(JSON.stringify(dataResult.promise311.timeRangeTitle));
	    $("#calendar_ddata").val(JSON.stringify(dataResult.promise311.days));
	    //设置日历坐标
	    $("#calendar_x").val(dataResult.promise311.date_x);
	    $("#calendar_y").val(dataResult.promise311.date_y);
	
	    $("#shipment411_msg").val(dataResult.promise411.grayMsg);
	    //显示修改按钮
	    $("#jdshipdate_eidt_id").removeClass("hide");
	}
}

function submitShipment(type) {
  var ajax_url = OrderAppConfig.DynamicDomain + "/payAndShip/savePayAndShip.action"; //表单目标               
  var payId = $("#payment-list .payment-item.item-selected").attr("payid");
  var otype = $("#payment-list .payment-item.item-selected").attr("onlinepaytype");
  $("#saveParam_paymentId").val(payId);
  $("#saveParam_otype").val(otype);
  var ajax_data = $("#skuAndShipment_submit_form").serialize(); //表单数据 
  ajax_data = addFlowTypeParam(ajax_data);
  jQuery.ajax({
    type: "POST", //表单提交类型 
    dataType: "json",
    url: ajax_url, //表单提交目标 
    data: ajax_data, //表单数据
    cache: false,
    success: function(dataResult, textStatus) {
      // 没有登录跳登录
      if (isUserNotLogin(dataResult)) {
        goToLogin();
        return;
      }
      if (dataResult.success) {
          reloadCouponNew(false);
          if(type!=1){
        	  // 取消使用京豆（避免价格变化导致可使用京豆数不准）
        	  useCancelEditJdBean(0, null, true);
          }
        isDoRefresh(dataResult.cartJson,type);
        //在刷新优惠券的时候刷新一下礼品卡信息
        reloadGiftCard();
      } else {
        //alert("系统繁忙，请稍后再试！");
        goOrder();
      }
    },
    error: function(XMLHttpResponse) {
      //alert("系统繁忙，请稍后再试！");
      goOrder();
    }
  });
}

//表单提交
function doSavePayAndShipmentInfo(saveType) {
  //保存京东快递配送时间
  if (saveType == "jd_shipment") {
    //设置京东配送方式
    $("#saveParam_jdShipmentType").val(65);
    $("#saveParam_pickShipmentType").val("");
    $("#saveParam_otherShipmentType").val("");
  }
  //保存支付方式
  if (saveType == "jd_payway_save") {
    //设置京东配送方式
    $("#saveParam_jdShipmentType").val(65);
    $("#saveParam_pickShipmentType").val("");
    $("#saveParam_otherShipmentType").val("");
  }
  //保存自提点
  else if (saveType == "jd_picksite") {
    //设置自提点
    $("#saveParam_pickShipmentType").val(64);
    $("#saveParam_jdShipmentType").val("");
    $("#saveParam_otherShipmentType").val("");
    //设置是自提点还是自提柜
  } else if (saveType == "save_picksite") {
    var pickId = $("#selfpick_siteDiv .site-item.site-item-selected").attr("pickid");
    var regionId = $("#pick_sel_regionid").val();
    
    var pick_name = $("#selfpick_siteDiv .site-item.site-item-selected").attr("pickName");
    if (pick_name == "null" || pick_name == null || pick_name == "undefined" || pick_name == undefined) {
      pick_name = "";
    }
    var showPickSite = "<span class='ftx-03'>自提地点：</span>" + pick_name;
    //如果没有选中自提点，不与保存
    if (isEmpty(pickId)) {
      return;
    }
    $("#beforePickRegionId").val(regionId);
    $("#beforePickSelRegionid").val(regionId);
    $("#beforePickSiteId").val(pickId);
    $("#beforePickName").val(pick_name);

    $("#pick_sel_regionid").val(regionId);
    $("#pick_sel_id").val(pickId);
    $("#is_invoke_pickdate").val("1");

    $("#selfpick_name").html(showPickSite);
    $("#saveParam_pickSiteId").val(pickId);
    $("#saveParam_pickRegionId").val(regionId);
    $("#saveParam_pickShipmentType").val(64);
    $("#saveParam_jdShipmentType").val("");
    $("#saveParam_otherShipmentType").val("");
  }
  //保存自提时间
  else if (saveType == "jd_picksite_time") {
    //设置自提点
    $("#saveParam_pickShipmentType").val(64);
    $("#saveParam_jdShipmentType").val("");
    $("#saveParam_otherShipmentType").val("");
    //设置是自提点还是自提柜
  }
  //保存大件商品京东配送时间
  else if (saveType == "jd_bigitem_shipdate") {
    //设置京东配送方式
    $("#saveParam_jdShipmentType").val(65);
    $("#saveParam_pickShipmentType").val("");
    $("#saveParam_otherShipmentType").val("");
    //设置刷新属性
    $("#is_refresh_installdate").val("1");
  }
  //保存大件商品京东安装时间
  else if (saveType == "jd_bigitem_installdate") {
    //设置京东配送方式
    $("#saveParam_jdShipmentType").val(65);
    $("#saveParam_pickShipmentType").val("");
    $("#saveParam_otherShipmentType").val("");
  }
  //保存大件商品第三方配送时间
  else if (saveType == "jd_otherbigitem_shipdate") {
    //设置京东第三方配送方式
    $("#saveParam_jdShipmentType").val("");
    $("#saveParam_otherShipmentType").val(66);
    $("#saveParam_pickShipmentType").val("");
    //设置刷新属性
    $("#is_refresh_installdate").val("1");
  }
  //保存大件商品第三方安装时间
  else if (saveType == "jd_otherbigitem_installdate") {
    //设置京东第三方配送方式
    $("#saveParam_jdShipmentType").val("");
    $("#saveParam_otherShipmentType").val(66);
    $("#saveParam_pickShipmentType").val("");
  }
  //保存京东第三方配送
  else if (saveType == "jd_other_shipment") {
    //设置京东第三方配送方式
    $("#saveParam_jdShipmentType").val("");
    $("#saveParam_otherShipmentType").val(66);
    $("#saveParam_pickShipmentType").val("");
  }
  submitShipment();
}

//点击切换京东配送标签
function doSwithTab(flag) {
  //京东配送
  if ("pay" == flag && $("#jd_shipment_item").hasClass("curr") == false) {
    $("#jd_shipment_item").addClass("curr");
    $("#pick_shipment_item").removeClass("curr");
    
    //yanwenqi 自提地址项目 自提前置，把下面的自提隐藏掉
    if($("#selfPickShutDownFlag").attr("value")==1){
	    $("#jd_shipment_item").removeClass("hide");
	    $("#pick_shipment_item").addClass("hide");
    }
    $("#selfpick_shipment").addClass("hide");
    $("#jd_shipment").addClass("ui-switchable-panel-selected");
    $("#jd_shipment").removeClass("hide");
    doSaveJdShipment("jd_shipment");
  }
  //京东自提
  if ("picksite" == flag && $("#pick_shipment_item").hasClass("disabled") == false && $("#pick_shipment_item").hasClass("curr") == false) {
	  $("#pick_shipment_item").addClass("curr");
    $("#jd_shipment_item").removeClass("curr");
    //yanwenqi 自提地址项目 自提前置，把下面的自提隐藏掉
    if($("#selfPickShutDownFlag").attr("value")==1){
	    $("#pick_shipment_item").removeClass("hide");
	    $("#jd_shipment_item").addClass("hide");
	    $("#_jdpay").addClass("hide");
	    $("#selfpick_name").addClass("hide");
	    $("#selfpick_name").next("div").addClass("hide");
    }
    $("#jd_shipment").addClass("hide");
    $("#selfpick_shipment").addClass("ui-switchable-panel-selected");
    $("#selfpick_shipment").removeClass("hide");
    //点击自提table标签保存默认自提点
    doSavePickSite();
  }
  //京东第三方配送
  if ("jd_other" == flag && $("#_jdpay").hasClass("curr") == false) {
	  $("#_jdpay").addClass("curr");
    $("#pick_shipment_item").removeClass("curr");
    $("#selfpick_shipment").addClass("hide");
    //yanwenqi 自提地址项目 自提前置，把下面的自提隐藏掉
    if($("#selfPickShutDownFlag").attr("value")==1){
    	$("#jd_shipment_item").removeClass("hide");
    	$("#pick_shipment_item").addClass("hide");
    }
    doSaveJdShipment("jd_other_shipment");
  }
  //京东第三方自提
  if ("picksite_other" == flag && $("#pick_shipment_item").hasClass("disabled") == false && $("#pick_shipment_item").hasClass("curr") == false) {
	  $("#pick_shipment_item").addClass("curr");
    
    //yanwenqi 自提地址项目 自提前置，把下面的自提隐藏掉
    if($("#selfPickShutDownFlag").attr("value")==1){
	    $("#pick_shipment_item").removeClass("hide");
	    $("#jd_shipment_item").addClass("hide");
	    $("#_jdpay").addClass("hide");
	    $("#selfpick_name").addClass("hide");
	    $("#selfpick_name").next("div").addClass("hide");
    }
    $("#_jdpay").removeClass("curr");
    $("#selfpick_shipment").addClass("ui-switchable-panel-selected");
    $("#selfpick_shipment").removeClass("hide");
    //点击自提table标签保存默认自提点
    doSavePickSite();
  }
}

//点击切换京东配送标签
function swithTab(flag) {
  if ("pay" == flag) {
    $("#jd_shipment_item").addClass("curr");
    $("#pick_shipment_item").removeClass("curr");
    $("#selfpick_shipment").css("style", "display: none;");
    $("#jd_shipment").css("style", "display: block;");
    $("#selfpick_shipment").addClass("hide");
    $("#jd_shipment").addClass("ui-switchable-panel-selected");
    $("#jd_shipment").removeClass("hide");
  } else {
    $("#pick_shipment_item").addClass("curr");
    $("#jd_shipment_item").removeClass("curr");
    $("#jd_shipment").addClass("hide");
    $("#selfpick_shipment").addClass("ui-switchable-panel-selected");
    $("#selfpick_shipment").css("style", "display: block;");
    $("#jd_shipment").css("style", "display: none;");
    $("#selfpick_shipment").removeClass("hide");
  }
}

//点击选择京东配送，显示311日历或者411极速达
function doEdit311Time() {
  seajs.use('user/purchase/2.0.0/js/calendar.js', function(Calendar) {
    var hData = jQuery.parseJSON($("#calendar_hdata").val());
    var dData = jQuery.parseJSON($("#calendar_ddata").val());
    var _width = 560;
    if (dData.length > 8) {
      _width = _width + (dData.length - 8) * 53;
    }
    var calendarHtml = $("#shipment_hidediv").html();
    $('body').dialog({
      title: '配送时间',
      width: _width,
      height: 330,
      type: 'html',
      source: calendarHtml,
      onReady: function() {
          var xy = new Array();
          if ($("#calendar_x").val() != "undefined" && $("#calendar_x").val() != "") {
            xy[0] = $("#calendar_x").val();
            xy[1] = $("#calendar_y").val();
          }
          var shipmentSupportType = $("#shipment_support_type").val();
          var shipmentSelSupport = $("#shipment_select_support").val();
          //只有311才创建组件
          if (shipmentSupportType == "1" || shipmentSupportType == "3") {
            var calendar = new Calendar(hData, dData, $('#date-delivery1'), xy); //初始化
          }
          //只支持311
          if (shipmentSupportType == "1") {
            $("#li_411_id").removeClass().addClass("tab-nav-item hide");
            $("#li_311_id").removeClass().addClass("tab-nav-item tab-item-selected");
          } else if (shipmentSupportType == "2") {
            //只支持411
            $("#li_311_id").removeClass().addClass("tab-nav-item hide");
            $("#tab_311_div").hide();
            $("#tab_411_div").show();
            //判断当前还是否支持411配送
            if ($("#shipment_cur411_support").val() == "1") {
              $("#li_411_id").removeClass().addClass("tab-nav-item tab-item-selected");
            } else if ($("#shipment_cur411_support").val() == "2") {
              $("#li_411_id").removeClass().addClass("tab-nav-item tab-item-selected disabled");
              $("#timeSave411").hide();
              //修改提示信息
              $("#message_show_411").html('温馨提示：当前时段不支持极速达业务，请选择其他配送方式！');
              $("#li_411_id .qmark-icon").attr('data-tips', $("#shipment411_msg").val());
            }
          } else if (shipmentSupportType == "3") {
            //选中了411
            if (shipmentSelSupport == "2") {
              //判断当前还是否支持411配送
              if ($("#shipment_cur411_support").val() == "1") {
                $("#li_311_id").removeClass().addClass("tab-nav-item");
                $("#li_411_id").removeClass().addClass("tab-nav-item tab-item-selected");
              } else if ($("#shipment_cur411_support").val() == "2") {
                $("#li_311_id").removeClass().addClass("tab-nav-item");
                $("#li_411_id").removeClass().addClass("tab-nav-item tab-item-selected disabled");
                $("#timeSave411").hide();
                //修改提示信息
                $("#message_show_411").html('温馨提示：当前时段不支持极速达业务，请选择其他配送方式！');
                $("#li_411_id .qmark-icon").attr('data-tips', $("#shipment411_msg").val());
              }
              $("#tab_311_div").hide();
              $("#tab_411_div").show();
            } else if (shipmentSelSupport == "1") {
              //选中了311
              $("#li_311_id").removeClass().addClass("tab-nav-item tab-item-selected");
              //判断当前还是否支持411配送
              if ($("#shipment_cur411_support").val() == "1") {
                $("#li_411_id").removeClass().addClass("tab-nav-item");
              } else if ($("#shipment_cur411_support").val() == "2") {
                $("#li_411_id").removeClass().addClass("tab-nav-item disabled");
                $("#timeSave411").hide();
                //修改提示信息
                $("#message_show_411").html('温馨提示：当前时段不支持极速达业务，请选择其他配送方式！');
                $("#li_411_id .qmark-icon").attr('data-tips', $("#shipment411_msg").val());
              }
            }
          }
          // 京东快递tips
          if (shipmentSupportType == "0") {
            $("#jdShip-span-tip .qmark-icon").attr('data-tips', '由京东公司负责配送，速度很快，还接受上门刷卡付款服务');
          } else {
            $("#jdShip-span-tip .qmark-icon").attr('data-tips', '此订单支持预约配送，您可以选择指定的时间段');
          }
          // 618促销配送信息
          shipmentTips618();
          $('#timeSave311').bind('click', function() {
            if (JSON.stringify(calendar.result) == "{}" && $("#calendar_x").val() == "") {
              alert("您还没有指定配送时间");
              return;
            } else if (JSON.stringify(calendar.result) != "{}") {
              //给隐藏域赋值
              $("#saveParam_promiseType").val(1); //预约配送类型，1表示311，2表示411
              $("#saveParam_jdShipTime").val(4);
              $("#saveParam_promiseDate").val(calendar.result.day);
              $("#saveParam_promiseTimeRange").val(calendar.result.range);
              $("#saveParam_promiseSendPay").val(calendar.result['date-range']);
              $("#calendar_x").val(calendar.result.xy[0]);
              $("#calendar_y").val(calendar.result.xy[1]);
              //$("#jd_shipment_calendar_date").html('<span class="ftx-03">配送时间：</span>' + calendar.result.day + " " + calendar.result.range)
            } else if (JSON.stringify(calendar.result) == "{}") {
              $("#saveParam_promiseType").val(1); //预约配送类型，1表示311，2表示411
              $("#saveParam_jdShipTime").val(4); //1，表示只工作日，2，表示只周末，3表示工作日、节假日均可，4表示311,5表示极速达
              //如果上次有选中的日期，则用上次日期，否则默认一个
              if ($("#last_sel_promiseDate").val() !== "" && $("#last_sel_promiseDate").val() !== null && $("#last_sel_promiseDate").val() !== "undefined" && $("#last_sel_promiseDate").val() !== undefined) {
                $("#saveParam_promiseDate").val($("#last_sel_promiseDate").val());
                $("#saveParam_promiseTimeRange").val($("#last_sel_promiseTimeRange").val());
                $("#saveParam_promiseSendPay").val($("#last_sel_promiseSendPay").val());
              } else {
                // 日历为空没有选择给一个默认的过期时间，异步验证会取最近的时间，提升用户体验
                $("#saveParam_promiseDate").val("2011-06-27");
                $("#saveParam_promiseTimeRange").val("{'1':1,'35':0,'30':1}");
                $("#saveParam_promiseSendPay").val("9:00-15:00");
              }
            }
            $("#reset_promise_311").val("1"); //是否需要重置311,不重置311
            jQuery.closeDialog();
            doSavePayAndShipmentInfo("jd_shipment");
          });
          $('#timeSave411').bind('click', function() {
            //先把311参数设置为空
            $("#saveParam_promiseDate").val("");
            $("#saveParam_promiseTimeRange").val("");
            $("#saveParam_promiseSendPay").val($("#shipment411_sendpay").val());
            //给隐藏域赋值
            
            $("#saveParam_promiseType").val(2); //预约配送类型，1表示311，2表示411
            $("#saveParam_jdShipTime").val(5);
            //更新配送时间说明
            $("#jd_shipment_calendar_date").html('<span class="ftx-03">配送时间：</span><font id="speedFreightNote">极速达（2小时之内送达）</font>');
            jQuery.closeDialog();
            doSavePayAndShipmentInfo("jd_shipment");
          });
        } //onready end
    });
  })
}

//311、411切换功能
function doSwith311Tab(tabFlag) {
  if (tabFlag == "311") {
    $("#li_311_id").addClass("tab-item-selected");
    $("#li_411_id").removeClass("tab-item-selected");
    $("#tab_311_div").show();
    $("#tab_411_div").hide();
  } else if (tabFlag == "411") {
    if ($("#li_411_id").hasClass("disabled")) {
      return;
    } else {
      $("#li_411_id").addClass("tab-item-selected");
      $("#li_311_id").removeClass("tab-item-selected");
      $("#tab_411_div").show();
      $("#tab_311_div").hide();
    }
  }
}

//保存京东配送
function doSaveJdShipment(flag) {
  doSavePayAndShipmentInfo(flag);
  jQuery.closeDialog();
}

//保存自提点
function doSavePickSite() {
  //给保存设置值
  var pickSiteId = $('#beforePickSiteId').val();
  var pickDate = $('#beforePickDate').val();
  var pickSiteNum = $('#beforePickSiteNum').val();
  var pickRegionId = $('#beforePickRegionId').val();
  var sel_regionid = $('#beforePickSelRegionid').val();
  if (pickSiteId != null && pickSiteId != "") {
    //----保存页面自提数据----
    $('#saveParam_pickSiteId').val(pickSiteId);
    $('#saveParam_pickDate').val(pickDate);
    $('#saveParam_pickSiteNum').val(pickSiteNum);
    $('#saveParam_pickRegionId').val(pickRegionId);
    $('#pick_sel_regionid').val(sel_regionid);
  }
  doSavePayAndShipmentInfo("jd_picksite");
  jQuery.closeDialog();
}

function doSaveDialogPickSite() {
  $("#pick_sel_regionid").val($("#temp_pick_sel_regionid").val());
  doSavePayAndShipmentInfo("save_picksite");
  jQuery.closeDialog();
}

//保存支付方式
function doSavePayWay() {
  $("#saveParam_jdPayWayId").val($('#subpayment .payment-item.item-selected').attr("supPaymentWayId"));
  $("#payment_name_div").html('<span class="ftx-03">付款方式：</span>' + $('#subpayment .payment-item.item-selected').attr("subPaymentWayName"));
  doSavePayAndShipmentInfo("jd_payway_save");
  jQuery.closeDialog();
}
  //保存大家电支付方式
function doSaveBigItemPayWay() {
  $("#saveParam_jdPayWayId").val($('#bigItemsubpayment .payment-item.item-selected').attr("supPaymentWayId"));
  $("#payment_name_div_bigItem").html('<span class="ftx-03">付款方式：</span>' + $('#bigItemsubpayment .payment-item.item-selected').attr("subPaymentWayName"));
  doSavePayAndShipmentInfo("jd_payway_save");
  jQuery.closeDialog();
}

//点击切换大家电安装时间
function doSwithInstall(venderId, thisElement) {
  $('.li_shipment_install').removeClass().addClass("li_shipment_install");
  $(thisElement).removeClass().addClass("li_shipment_install selected");
}

//点击切换第三方大家电安装时间
function doSwithOtherInstall(venderId, thisElement) {
  $('.li_shipment_install_other').removeClass().addClass("li_shipment_install_other");
  $(thisElement).removeClass().addClass("li_shipment_install_other selected");
}

//保存选择的大家电安装时间
function doSaveInstallDate(venderId) {
  var installDate_date = $('.li_shipment_install.selected').attr("installDate_date");
  var installDate_weekDay = $('.li_shipment_install.selected').attr("installDate_weekDay");
  if(installDate_weekDay==undefined||installDate_weekDay=="undefined"){
	  installDate_weekDay = "";
  }
  $("#install_date_div_" + venderId).html('<span class="mode-label ftx-03">安装时间：</span><div class="mode-infor">' + installDate_date + " " + installDate_weekDay + '<br><span class="ftx-03">只针对京东上门安装商品</span></div>');
  $("#saveParam_jdBigItemInstallTimeOffest").val($('.li_shipment_install.selected').attr("installDate_offset"));
  doSavePayAndShipmentInfo("jd_bigitem_installdate");
  jQuery.closeDialog();
}

//保存选择的第三方大家电安装时间
function doSaveOtherInstallDate(venderId){
   var installDate_date = $('.li_shipment_install_other.selected').attr("installDate_date");
   var installDate_weekDay = $('.li_shipment_install_other.selected').attr("installDate_weekDay");
   if(installDate_weekDay==undefined||installDate_weekDay=="undefined"){
	   installDate_weekDay = "";
	}
   $("#otherinstall_date_div_" + venderId).html('<span class="mode-label ftx-03">安装时间：</span><div class="mode-infor">' + installDate_date + " " + installDate_weekDay +'<br><span class="ftx-03">只针对京东上门安装商品</span></div>');
   $("#saveParam_otherBigItemInstallTimeOffset").val($('.li_shipment_install_other.selected').attr("installDate_offset"));
   doSavePayAndShipmentInfo("jd_otherbigitem_installdate");
   jQuery.closeDialog();
}

//点击切换大家电配送时间
function doSwithBigShip(venderId,thisElement){
   $('.li_shipment').removeClass().addClass("li_shipment");
    $(thisElement).removeClass().addClass("li_shipment selected");
}
//点击切换第三方大家电配送时间
function doSwithOtherBigShip(venderId,thisElement){
    $('.li_shipment_other').removeClass().addClass("li_shipment_other");
    $(thisElement).removeClass().addClass("li_shipment_other selected");
}

//保存大家电配送时间
function doSaveBigShipDate(venderId){
   $("#shipment_date_div_" + venderId).html('<span class="ftx-03">配送时间：</span>' + $('.li_shipment.selected').attr("shipDate_date") + " " + $('.li_shipment.selected').attr("shipDate_weekDay"));
   $("#saveParam_jdBigItemShipTimeOffset").val($('.li_shipment.selected').attr("shipDate_offset"));
   
   doSavePayAndShipmentInfo("jd_bigitem_shipdate");
   jQuery.closeDialog();
}

//保存第三方大家电配送时间
function doSaveOtherBigShipDate(venderId){
   $("#othershipment_date_div_" + venderId).html('<span class="ftx-03">配送时间：</span>' + $('.li_shipment_other.selected').attr("shipDate_date") + " " + $('.li_shipment_other.selected').attr("shipDate_weekDay"));
   $("#saveParam_otherBigItemShipOffset").val($('.li_shipment_other.selected').attr("shipDate_offset"));
   
   doSavePayAndShipmentInfo("jd_otherbigitem_shipdate");
   jQuery.closeDialog();
}

//点击进入自提点配送修改时间界面
function doEditPickSiteDate(venderId) {
  var pickSiteShipmentHtml = $("#pickSiteShipDate").html();
  $('body').dialog({
    title: '自提时间',
    width: 530,
    height: 230,
    type: 'html',
    source: pickSiteShipmentHtml,
    onReady: function() {
      //给选中的配送日期设置样式
      var curSelPickSiteDate = $("#saveParam_pickDate").val();
      $(".li_pick_shipment").each(function(index, item) {
        if ($(this).attr("date") == curSelPickSiteDate) {
          $(this).removeClass().addClass("li_pick_shipment selected");
          return;
        }
      });
    }
  });
}

//点击进入大家电配送时间选择界面
function doEditBigShipmentDate(venderId) {
  var bigShipHtml = $("#bigItemShipEdit_" + venderId).html();
  $('body').dialog({
    title: '大件商品配送时间',
    width: 530,
    height: 230,
    type: 'html',
    source: bigShipHtml,
    onReady: function() {
      //给选中的大家电配送日期设置样式
      var curSelBigItemShipOffset = $("#saveParam_jdBigItemShipTimeOffset").val();
      var isOk = false;
      $(".li_shipment").each(function(index, item) {
        if (curSelBigItemShipOffset != null && $(this).attr("shipDate_offset") == curSelBigItemShipOffset) {
          $(this).removeClass().addClass("li_shipment selected");
          isOk = true;
        }
      });
      //如果没有值，则选中第一个
      if (!isOk) {
        $(".li_shipment").eq(0).removeClass().addClass("li_shipment selected");
      }
    }
  });
}

//点击进入第三方大家电配送时间选择界面
function doEditOtherBigShipmentDate(venderId) {
  var bigShipHtml = $("#otherBigItemShipEdit_" + venderId).html();
  $('body').dialog({
    title: '大件商品配送时间',
    width: 530,
    height: 230,
    type: 'html',
    source: bigShipHtml,
    onReady: function() {
      //给选中的大家电配送日期设置样式
      var curSelBigItemShipOffset = $("#saveParam_otherBigItemShipOffset").val();
      $(".li_shipment_other").each(function(index, item) {
        if (curSelBigItemShipOffset != null && $(this).attr("shipDate_offset") == curSelBigItemShipOffset) {
          $(this).removeClass().addClass("li_shipment_other selected");
          return;
        }
      });
    }
  });
}

//京东付款方式
function doEditPayway(venderId) {
  var payHtml = $("#paywayEdit_" + venderId).html();
  var curSelPayWay = $("#saveParam_jdPayWayId").val();
  var showTitle = "选择付款方式";
  if (curSelPayWay == "0") {
    showTitle = "选择货到付款的付款方式";
  }
  $('body').dialog({
    title: showTitle,
    width: 425,
    height: 130,
    type: 'html',
    source: payHtml,
    onReady: function() {
      //给选中的配送日期设置样式          
      $("#subpayment .payment-item").each(function(index, item) {
        if ($(this).attr("supPaymentWayId") == curSelPayWay) {
          $(this).removeClass();
          $(this).addClass("payment-item item-selected");
          return;
        }
      });
      //控制显示提示
      if (curSelPayWay == "0") {
        $(".pay_way_remark").hide();
      } else if (curSelPayWay == "1") {
        $(".pay_way_remark").html('<span class="qmark"></span><a class="ftx-05" href="http://help.jd.com/help/question-61.html#posz" target="_blank">货到付款的订单上写的是POS刷卡，可以换成现金支付吗？</a>');
        $(".pay_way_remark").show();
      }
      if (curSelPayWay == "2") {
        $(".pay_way_remark").html('<span class="qmark"></span><a class="ftx-05" href="http://help.jd.com/help/question-61.html#zptt" target="_blank">使用支票支付，抬头写什么？</a><br><span class="qmark"></span><a class="ftx-05" href="http://help.jd.com/help/question-61.html#zpxz" target="_blank">支票支付有金额和区域的限制么？</a><br><span class="qmark"></span><a class="ftx-05" href="http://help.jd.com/help/question-61.html#zpjed" target="_blank">支票支付的订单，我支票的金额比订单实际金额多怎么办？</a>');
        $(".pay_way_remark").show();
      }
    }
  });
}

//京东大家电付款方式
function doEditBigItemPayway(venderId) {
  var payHtml = $("#paywayBigItemEdit_" + venderId).html();
  var curSelPayWay = $("#saveParam_jdPayWayId").val();
  var showTitle = "选择付款方式";
  if (curSelPayWay == "0") {
    showTitle = "选择货到付款的付款方式";
  }
  $('body').dialog({
    title: showTitle,
    width: 425,
    height: 130,
    type: 'html',
    source: payHtml,
    onReady: function() {
      //给选中的配送日期设置样式          
      $("#bigItemsubpayment .payment-item").each(function(index, item) {
        if ($(this).attr("supPaymentWayId") == curSelPayWay) {
          $(this).removeClass().addClass("payment-item item-selected");
          return;
        }
      });
      //控制显示提示
      if (curSelPayWay == "0") {
        $(".pay_way_remark").hide();
      } else if (curSelPayWay == "1") {
        $(".pay_way_remark").html('<span class="qmark"></span><a class="ftx-05" href="http://help.jd.com/help/question-61.html#posz" target="_blank">货到付款的订单上写的是POS刷卡，可以换成现金支付吗？</a>');
        $(".pay_way_remark").show();
      }
      if (curSelPayWay == "2") {
        $(".pay_way_remark").html('<span class="qmark"></span><a class="ftx-05" href="http://help.jd.com/help/question-61.html#zptt" target="_blank">使用支票支付，抬头写什么？</a><br><span class="qmark"></span><a class="ftx-05" href="http://help.jd.com/help/question-61.html#zpxz" target="_blank">支票支付有金额和区域的限制么？</a><br><span class="qmark"></span><a class="ftx-05" href="http://help.jd.com/help/question-61.html#zpjed" target="_blank">支票支付的订单，我支票的金额比订单实际金额多怎么办？</a>');
        $(".pay_way_remark").show();
      }
    }
  });
}

//点击进入大家电安装日期选择界面
function doEditInstallDate(venderId) {
  var installHtml = $("#bigItemInstallEdit_" + venderId).html();
  $('body').dialog({
    title: '大件商品安装时间',
    width: 530,
    height: 230,
    type: 'html',
    source: installHtml,
    onReady: function() {
      //给选中的配送日期设置样式
      var curSelBigInstalloffset = $("#saveParam_jdBigItemInstallTimeOffest").val();
      $(".li_shipment_install").each(function(index, item) {
        if (curSelBigInstalloffset != null && $(this).attr("installDate_offset") == curSelBigInstalloffset) {
          $(this).removeClass().addClass("li_shipment_install selected");
          return;
        }
      });
    }
  });
}

//点击进入第三方大家电安装日期选择界面
function doEditOtherInstallDate(venderId) {
  var installHtml = $("#otherBigItemInstallEdit_" + venderId).html();
  $('body').dialog({
    title: '大件商品安装时间',
    width: 530,
    height: 230,
    type: 'html',
    source: installHtml,
    onReady: function() {
      //给选中的配送日期设置样式
      var curSelBigInstalloffset = $("#saveParam_otherBigItemInstallTimeOffset").val();
      $(".li_shipment_install_other").each(function(index, item) {
        if (curSelBigInstalloffset != null && $(this).attr("installDate_offset") == curSelBigInstalloffset) {
          $(this).removeClass().addClass("li_shipment_install_other selected");
          return;
        }
      });
    }
  });
}

//进入修改自提点页面
function doEditPicksite() {
  var picksiteHtml = $("#picksite_hidediv").html();
  $('body').dialog({
    title: '选择自提点',
    width: 780,
    height: 500,
    type: 'html',
    source: '<div id="selfpick_siteDiv">' + picksiteHtml + '</div>',
    onReady: function() {
      //设置选择区域
	  $("#temp_pick_sel_regionid").val($("#pick_sel_regionid").val());
      /*var selRegionId = $("#pick_sel_regionid").val();
          $(".pickRegion_select").val(selRegionId); */
    }
  });
}

//yanwenqi 自提地址项目  重新选择自提点
function doReChoosePicksite() {
	$("#consignee-list .consignee-item.item-selected").parent().next().next().find('.consignee-item').click();
}

/**
 * 异步获取商品清单、支付方式和配送相关信息
 * zhuqingjie 
 */
function doAsynGetSkuPayAndShipInfo(typeFlag) {
  var actionUrl = OrderAppConfig.DynamicDomain + "/payAndShip/getAdditShipment.action";
  var payId = $('.payment-item.item-selected').attr('payId');
  var otype = $('.payment-item.item-selected').attr('onlinepaytype');
  var reset311 = $('#reset_promise_311').val();
  var resetFlag = $('#resetFlag').val();
  initResetFlag();
  if (isEmpty(payId)) {
    payId = 4;
  }
  if (isEmpty(otype)) {
	  otype = 0;
  }
  var param = "paymentId=" + payId;
  param = param + "&shipParam.reset311="+reset311 + "&resetFlag="+resetFlag+ "&shipParam.onlinePayType=" + otype;
  var easyBuyFlag = $("#easyBuyFlag").val();
  if(easyBuyFlag == "1"||easyBuyFlag=="2"){
    param += "&ebf=" + easyBuyFlag;
  }
  param = addFlowTypeParam(param);
  jQuery.ajax({
    type: "POST",
    dataType: "json",
    url: actionUrl,
    data: param,
    cache: false,
    success: function(dataResult, textStatus) {
      
      // 没有登录跳登录
      if (isUserNotLogin(dataResult)) {
         goToLogin();
         return;
      }
      var selfPickShutDownFlag = dataResult.isSelfPickShutDown;
      
      doResetShipTime(dataResult.resetShipTime);
      //判断商品清单是否发生变化，如果发生变化则重新加载订单备注信息
      if(!isEmpty($("#sopCartJson").val()) && $("#sopCartJson").val() != dataResult.cartJson){
        //根据商品属性加载订单备注信息
        loadOrderRemark(); 
      }
      //处理311、411日历信息	
      doDealCalenderInfo(dataResult);
      //处理自提点信息
      //初始化页面的时候，不默认选中自提
      doSelfPickStatus(dataResult.selfPick,1);
    //yanwenqi 自提地址项目 等待之前的处理自提点信息完后处理自提的信息
      if(selfPickShutDownFlag == 1){
    	  //轻松购和礼品购过来的按照原来的逻辑走，相当于降级
    	  if(easyBuyFlag == "1"||easyBuyFlag=="2" || isGiftBuy()){
    		  $("#selfPickShutDownFlag").attr("value","0");
    	  }else{
	      	  	if($(".selfPickInCommonItem").hasClass("item-selected")){
	    	  		$("#jd_shipment_item").addClass("hide");
	    	  	}else{
	    	  		$("#pick_shipment_item").addClass("hide");
	    	  	}
	    	  $("#selfPickShutDownFlag").attr("value","1");
		      if(typeFlag==0){
		    	  //初始化
		    	  doAsynInitSelfPickInfo();
		      }
		      if(typeFlag==1 && $(".selfPickInCommonItem").hasClass("item-selected")){
		    	  doHandleSelfPick(0);
		      }else if(!$(".selfPickInCommonItem").hasClass("item-selected")){
		    	  $("#selfPickSiteName").removeClass("item-selected");
		      }else if(typeFlag==3 && $(".selfPickInCommonItem").hasClass("item-selected")){
				  $("#selfpick_name").addClass("hide");
				  $("#selfpick_name").next("div").addClass("hide");
		      }
		      
		      if($(".selfPickInCommonItem").hasClass("item-selected")){
		    	  var actionUrl = OrderAppConfig.AsyncDomain + "/payAndShip/verifySelfPick.action";
		  		var param ="shipParam.payId=" + payId;
				var regionId = $("#temp_pick_sel_regionid").val();
				if (isEmpty(regionId)) {
					regionId = "-1";
				}
				param = param + "&shipParam.regionId=" + regionId;
				param = addFlowTypeParam(param)
					jQuery.ajax({
					    type: "POST",
					    dataType: "json",
					    url: actionUrl,
					    data: param,
					    cache: false,
					    success: function(dataResult, textStatus) {
					      // 没有登录跳登录
					      if (isUserNotLogin(dataResult)) {
					        goToLogin();
					        return;
					      }
					      if (dataResult == "null" || dataResult == null || dataResult == "" || dataResult == 0) {
					    	  $(".payment-item").each(function(){ 
					  	    	var payid = $(this).attr('payid');
					  	    	 if(payid==1){
					  	    		$(this).addClass("payment-item-disabled");
					  	    		$(this).children('span').remove();
					  	    		$(this).append("<span id='codtips' class='qmark-icon qmark-tip' data-tips='商品属性或所在地区不支持货到付款'></span>");
					  	    		$(this).parent().removeAttr("onclick");
					  	    		$(this).parent().removeAttr("clstag");
					  	    	 }
					    	  });
					      }
					    },
					    error: function(XMLHttpResponse) {
					      return false;
					    }
					  });
		      }
		      
    	  }
      }else{
    	  $("#selfPickShutDownFlag").attr("value","0");
      }
      //加载库存、获取店铺名称
      loadSkuListStock();
      doGetVendorName();
      showFerightInsure();
      flushOrderPrice(dataResult.orderPrice, false);
      btBrief(dataResult.orderPrice.payPrice);
      jdPayCardList();
      var otype = $('.payment-item.item-selected').attr('onlinepaytype');
      if(otype!="3"){//如果是京东支付在加载卡列表是判断是否需要支付密码
    	  isNeedPaymentPassword();
      }
      // 如果是礼品购流程，加载隐藏价格
      if (isGiftBuy()) {
        loadGiftBuyHidePrice();
      }
      // 商品清单埋点
      // skuListTracking(dataResult.cartJson);
    },
    error: function(XMLHttpResponse) {
    	//alert("系统繁忙，请稍后再试！");
      //goOrder();
    }
  });
}

function doSelfPickStatus(selfPick,flag) {
  if(selfPick==null){
	  return;
  }
  if (selfPick.pickShowStatus == "0") {
    //厂商直送，自提点不可用
    $("#jd_shipment_item").addClass("curr");
    $("#pick_shipment_item").removeClass("curr").addClass("hide");
    $("#selfpick_shipment").addClass("hide");
    $("#jd_shipment").addClass("ui-switchable-panel-selected").removeClass("hide");
  } else if (selfPick.pickShowStatus == "1") {
	  
	    //自提点可用，并且是选中状态
	    //设置自提点显示名称
	    var pickNameTemp = $("#beforePickName").val();
	    if (pickNameTemp == null || pickNameTemp == "") {
	      pickNameTemp = selfPick.pickName;
	    }
	    //add by zhuqingjie 如果之前还未选过自提点，自提地点为空
	    if (pickNameTemp == "null" || pickNameTemp == null || pickNameTemp == "undefined" || pickNameTemp == undefined ) {
	      pickNameTemp = "";
	    }
	    if(selfPick.showBanDateTip){
	    	$("#selfpick_name").html("<span class='ftx-03'>自提地点：</span>" + pickNameTemp +"<span class='ftx-04'>&nbsp;&nbsp;"+selfPick.showBanDateTip+"</span>");
	    }else{
	    	$("#selfpick_name").html("<span class='ftx-03'>自提地点：</span>" + pickNameTemp);
	    }
	    $("#selfpick_date").html("<span class='ftx-03'>自提时间：</span>" + selfPick.simplePickDate);
	    if("提货时间以短信通知为准" == selfPick.simplePickDate){
	    	$("#selfpick_date").next("div").hide();
	    }else{
	    	$("#selfpick_date").next("div").show();
	    }
	    //给保存设置值
	    $('#saveParam_pickSiteId').val(selfPick.selectedPickView.pickId);
	    $('#saveParam_pickDate').val(selfPick.pickDate);
	    $('#saveParam_pickSiteNum').val(selfPick.pickSiteNum);
	    $('#saveParam_pickRegionId').val(selfPick.selRegionId);
	    $('#pick_sel_regionid').val(selfPick.selRegionId);
	    $("#pick_shipment_item").removeClass("hide");
	    if (selfPick.recommended == true) {
	      if($("#pick_shipment_item > .m-txt > .ftx01").length == 0) {
	    	  //lizheng要求去掉
	         //$("#pick_shipment_item .qmark-icon").before('<span class="ftx01">(荐)</span>');
	      }
	    }else{
	    	$("#pick_shipment_item .m-txt .ftx01").remove();
	    }
	    if (selfPick.pickShipSelected == true) {
		    	if($("#saveParam_jdShipTime").val()=="4" && $("#saveParam_promiseDate").val()=="" ){
		    		$("#saveParam_jdShipTime").val("3");
		    	}
		      $("#jd_shipment_item").removeClass("curr");
		      $("#_jdpay").removeClass("curr");
		      $("#jd_shipment").addClass("hide");
		      $("#selfpick_shipment").removeClass("hide");
		      $("#pick_shipment_item").addClass("curr");
		      $("#selfpick_shipment").addClass("ui-switchable-panel-selected");
	    }else if ($("#jd_shipment_item").length==1){
	      $("#jd_shipment_item").addClass("curr");
	      $("#pick_shipment_item").removeClass("curr");
	      $("#selfpick_shipment").addClass("hide");
	      $("#jd_shipment").addClass("ui-switchable-panel-selected");
	      $("#jd_shipment").removeClass("hide");
	    }else if($("#_jdpay").length==1){
	    	$("#_jdpay").addClass("curr");
	        $("#pick_shipment_item").removeClass("curr");
	        $("#selfpick_shipment").addClass("hide");
	    }
	    $("#noSupSkus_hideDiv")[0].text = "";
	  
  }
  //自提点不可用状态
  else if (selfPick.pickShowStatus == "2") {
    $("#pick_shipment_item").removeClass("hide");
    $("#pick_shipment_item").addClass("disabled");
    $("#jd_shipment_item").addClass("curr");
    $("#pick_shipment_item").removeClass("curr");
    $("#selfpick_shipment").addClass("hide");
    $("#jd_shipment").addClass("ui-switchable-panel-selected").removeClass("hide");
    var _arr= [];
    for (var i = 0; i < selfPick.noSupportSelfPickSkuList.length; i++) {
      _arr[i] = "<div class='goods-item'>\
                  <div class='p-img'>\
                    <a target='_blank' href='http://item.jd.com/" + selfPick.noSupportSelfPickSkuList[i].id + ".html'><img src='//img14.360buyimg.com/N4/" + selfPick.noSupportSelfPickSkuList[i].imgUrl + "' alt=''></a>\
                  </div>\
                  <div class='p-name'>\
                    <a target='_blank' href='http://item.jd.com/" + selfPick.noSupportSelfPickSkuList[i].id + ".html'>" + selfPick.noSupportSelfPickSkuList[i].name + "+</a>\
                  </div>\
                </div>";
    }
    var noSupSkusHTML = "<div class='tooltip-goods'><div class='tooltip-tit'>以下商品不支持自提</div><div class='goods-items'>"+_arr.join('')+"</div></div>";
    $("#noSupSkus_hideDiv")[0].text = noSupSkusHTML;
  }

  $("#picksite_hidediv").html(selfPick.pickShipmentView);
  $("#pickSiteShipDate").html(selfPick.pickDateHtml);
  // 618促销配送信息
  shipmentTips618();
}

/* 618促销期间配送文案 仅中小件京配显示此文案 */
function shipmentTips618() {
  if($("#jd_shipment_item").hasClass("curr") || $("#li_311_id").hasClass("tab-item-selected")) {
    var currDate = new Date();
    var day6189 = currDate.getFullYear()+"-"+(currDate.getMonth()+1)+"-"+currDate.getDate();
    if("2015-6-18" == day6189 || "2015-6-19" == day6189) {
    	$(".tips-618").find(".tips-m").html("6月18日、19日下单，配送时间选择在6月24日或25日，活动结束后抽取20万幸运客户<b>赠送100京豆</b>");
    	$(".tips-618").removeClass('hide');
    } else if("2015-11-11" == day6189){
        $(".tips-618").find(".tips-m").html("预约14、15日收货，订单完成将有机会参与抽奖送豆活动，最高<b>赠送300京豆</b>");
        $(".tips-618").removeClass('hide');
    } else if("2015-11-12" == day6189){
        $(".tips-618").find(".tips-m").html("预约15日收货，订单完成将有机会参与抽奖送豆活动，最高<b>赠送300京豆</b>");
        $(".tips-618").removeClass('hide');
    } else if("2016-6-16" == day6189) {
    	$(".tips-618").find(".tips-m").html("温馨提示：618大促恰逢周末，请确认好收货地址和时间以保证货物及时送达。");
    	$(".tips-618").removeClass('hide');
    } else if("2016-6-17" == day6189 || "2016-6-18" == day6189 || "2016-6-19" == day6189) {
    	$(".tips-618").find(".tips-m").html("恰逢周末，请确认好收货地址和时间以保证货物及时送达。预约23日及以后收货，<b>赠送10元京东钱包现金券</b>（两个工作日内自动放入京东钱包）。");
    	$(".tips-618").removeClass('hide');
    } else {
      $(".tips-618").addClass('hide');
    }
  } else {
    $(".tips-618").addClass('hide');
  }
}

//点击切换付款方式
function doSwithPaymentWay(supPaymentWayId) {
  $("#subpayment .payment-item").removeClass("item-selected");
  $("#supPaymentWay_" + supPaymentWayId).addClass("item-selected");
  //控制显示提示
  if (supPaymentWayId == "0") {
    $(".pay_way_remark").hide();
  } else if (supPaymentWayId == "1") {
    $(".pay_way_remark").html('<span class="qmark"></span><a class="ftx-05" href="http://help.jd.com/help/question-61.html#posz" target="_blank">货到付款的订单上写的是POS刷卡，可以换成现金支付吗？</a>');
    $(".pay_way_remark").show();
  }
  if (supPaymentWayId == "2") {
    $(".pay_way_remark").html('<span class="qmark"></span><a class="ftx-05" href="http://help.jd.com/help/question-61.html#zptt" target="_blank">使用支票支付，抬头写什么？</a><br><span class="qmark"></span><a class="ftx-05" href="http://help.jd.com/help/question-61.html#zpxz" target="_blank">支票支付有金额和区域的限制么？</a><br><span class="qmark"></span><a class="ftx-05" href="http://help.jd.com/help/question-61.html#zpjed" target="_blank">支票支付的订单，我支票的金额比订单实际金额多怎么办？</a>');
    $(".pay_way_remark").show();
  }
}

//点击切换付款方式
function doSwithBigItemPaymentWay(thisElement){
	$("#bigItemsubpayment .payment-item").removeClass("item-selected");
	$(thisElement).addClass("item-selected");
	//控制显示提示
	if($(thisElement).attr("supPaymentWayId")=="0"){
		$(".pay_way_remark").hide();
	}else if($(thisElement).attr("supPaymentWayId")=="1"){
		$(".pay_way_remark").html('<span class="qmark"></span><a class="ftx-05" href="http://help.jd.com/help/question-61.html#posz" target="_blank">货到付款的订单上写的是POS刷卡，可以换成现金支付吗？</a>');
		$(".pay_way_remark").show();
	}if($(thisElement).attr("supPaymentWayId")=="2"){
		$(".pay_way_remark").html('<span class="qmark"></span><a class="ftx-05" href="http://help.jd.com/help/question-61.html#zptt" target="_blank">使用支票支付，抬头写什么？</a><br><span class="qmark"></span><a class="ftx-05" href="http://help.jd.com/help/question-61.html#zpxz" target="_blank">支票支付有金额和区域的限制么？</a><br><span class="qmark"></span><a class="ftx-05" href="http://help.jd.com/help/question-61.html#zpjed" target="_blank">支票支付的订单，我支票的金额比订单实际金额多怎么办？</a>');
		$(".pay_way_remark").show();
	}
}

function doEditPickReigon(obj) {
  var actionUrl = OrderAppConfig.AsyncDomain + "/payAndShip/getPickSiteByRegion.action";
  var payId = $("#payment-list .payment-item.item-selected").attr("payid");
  var pickId = $("#pick-sites .site-item.site-item-selected").attr("pickid");
  if (isEmpty(payId)) {
    payId = 4;
  }
  var regionId = $(obj).val();
  if (isEmpty(regionId)) {
    regionId = "-1";
  }
  $("#temp_pick_sel_regionid").val(regionId);
  //var repRegionId = regionId.replace(/:/g,"-");
  var param = "shipParam.payId=" + payId;
  param = param + "&shipParam.pickSiteId=" + pickId;
  param = param + "&shipParam.regionId=" + regionId;
  param = param + "&shipParam.pickSiteNum=5";
  param = addFlowTypeParam(param);
  jQuery.ajax({
    type: "POST",
    dataType: "json",
    url: actionUrl,
    data: param,
    cache: false,
    success: function(dataResult, textStatus) {
      // 没有登录跳登录
      if (isUserNotLogin(dataResult)) {
        goToLogin();
        return;
      }
      if (dataResult == "null") {
        alert("自提点获取异常，请重新选择或稍后尝试");
        goOrder();
      }
      var jsonO = dataResult;
      if (jsonO.pickViewList.length == 0) {
        alert("自提点获取异常，请重新选择或稍后尝试");
        goOrder();
      }
      var pickSiteListHTML = "";
      if (jsonO.pickViewList.length != 0) {
        for (var i = 0; i < jsonO.pickViewList.length; i++) {
          pickSiteListHTML = pickSiteListHTML + "<div class='site-item";
          if (jsonO.pickViewList[i].selected == true) {
            pickSiteListHTML = pickSiteListHTML + " site-item-selected";
          }
          //add by zhuqingjie 添加自提点不可用标记
          if (jsonO.pickViewList[i].cabinetAvailable == false) {
            pickSiteListHTML = pickSiteListHTML + " site-item-disabled";
          }
          //end add
          pickSiteListHTML = pickSiteListHTML + "' pickName='" + jsonO.pickViewList[i].pickName + "' pickid='" + jsonO.pickViewList[i].pickId + "' > <div class='site-in-short' onclick='doSelectPicksite(this)' >";
          pickSiteListHTML = pickSiteListHTML + jsonO.pickViewList[i].pickName;
          if (jsonO.pickViewList[i].used == true) {
            pickSiteListHTML = pickSiteListHTML + "<span class='ftx-04'>[最近使用]</span>";
          }
          if (jsonO.pickViewList[i].cabinetAvailable == false) {
            pickSiteListHTML = pickSiteListHTML + "<span class='ftx-01'>[已满]</span>";
          }
          if (jsonO.pickViewList[i].limitKeyword == "1") {
            pickSiteListHTML = pickSiteListHTML + "<span class='ftx-01'>[限]</span>";
          }
          if (jsonO.pickViewList[i].limitKeyword == "1" && jsonO.pickViewList[i].specialRemark != "") {
            pickSiteListHTML = pickSiteListHTML + jsonO.pickViewList[i].specialRemark;
          }
          pickSiteListHTML = pickSiteListHTML + " <b></b></div>";
          pickSiteListHTML = pickSiteListHTML + " <div class='field'> ";
          pickSiteListHTML = pickSiteListHTML + " <span class='tip'> ";
          pickSiteListHTML = pickSiteListHTML + jsonO.pickViewList[i].address;
          pickSiteListHTML = pickSiteListHTML + " </span> ";
          pickSiteListHTML = pickSiteListHTML + " <a class='ftx-05 map-link' target='_blank' href='" + jsonO.pickViewList[i].mapUrl + "'>" + jsonO.pickViewList[i].helpMessage + "</a> ";
          pickSiteListHTML = pickSiteListHTML + " </div> <div class='clr'></div></div>  ";
        }
      }
      $("#selfpick_siteDiv .pick-sites").html(pickSiteListHTML);
      if (jsonO.pickViewList.length >= 5) {
        $("#selfpick_siteDiv .selfpick_more_link").removeClass("hide");
      } else {
        $("#selfpick_siteDiv .selfpick_more_link").addClass("hide");
      }
    },
    error: function(XMLHttpResponse) {
      //alert("系统繁忙，请稍后再试！");
      return false;
    }
  });
}

function open_MorePicksite(obj) {
  var actionUrl = OrderAppConfig.AsyncDomain + "/payAndShip/getPickSiteByRegion.action";
  var payId = $("#payment-list .payment-item.item-selected").attr("payid");
  var pickId = $("#selfpick_siteDiv #pick-sites .site-item.site-item-selected").attr("pickid");
  if (isEmpty(payId)) {
    payId = 4;
  }
  
  var regionId = $("#temp_pick_sel_regionid").val();
  if (isEmpty(regionId)) {
    regionId = "-1";
  }
  //var repRegionId = regionId.replace(/:/g,"-");
  var param = "shipParam.payId=" + payId;
  param = param + "&shipParam.pickSiteId=" + pickId;
  param = param + "&shipParam.regionId=" + regionId;
  param = param + "&shipParam.pickSiteNum=100";
  param = addFlowTypeParam(param);
  jQuery.ajax({
    type: "POST",
    dataType: "json",
    url: actionUrl,
    data: param,
    cache: false,
    success: function(dataResult, textStatus) {
      // 没有登录跳登录
      if (isUserNotLogin(dataResult)) {
        goToLogin();
        return;
      }
      if (dataResult == "null") {
        alert("自提点获取异常，请重新选择或稍后尝试");
        goOrder();
      }
      var jsonO = dataResult;
      if (jsonO.pickViewList.length == 0) {
        alert("自提点获取异常，请重新选择或稍后尝试");
        goOrder();
      }
      var pickSiteListHTML = "";
      if (jsonO.pickViewList.length != 0) {
        for (var i = 0; i < jsonO.pickViewList.length; i++) {
          pickSiteListHTML = pickSiteListHTML + "<div class='site-item";
          if (jsonO.pickViewList[i].selected == true) {
            pickSiteListHTML = pickSiteListHTML + " site-item-selected";
          }
          //add by zhuqingjie 添加自提点不可用标记
          if (jsonO.pickViewList[i].cabinetAvailable == false) {
            pickSiteListHTML = pickSiteListHTML + " site-item-disabled";
          }
          //end add
          pickSiteListHTML = pickSiteListHTML + "' pickid='" + jsonO.pickViewList[i].pickId + "' > <div class='site-in-short' onclick='doSelectPicksite(this)' >";
          pickSiteListHTML = pickSiteListHTML + jsonO.pickViewList[i].pickName;
          if (jsonO.pickViewList[i].used == true) {
            pickSiteListHTML = pickSiteListHTML + "<span class='ftx-04'>[最近使用]</span>";
          }
          if (jsonO.pickViewList[i].cabinetAvailable == false) {
            pickSiteListHTML = pickSiteListHTML + "<span class='ftx-01'>[已满]</span>";
          }
          if (jsonO.pickViewList[i].limitKeyword == "1") {
            pickSiteListHTML = pickSiteListHTML + "<span class='ftx-01'>[限]</span>";
          }
          if (jsonO.pickViewList[i].limitKeyword == "1" && jsonO.pickViewList[i].specialRemark != "") {
            pickSiteListHTML = pickSiteListHTML + jsonO.pickViewList[i].specialRemark;
          }
          pickSiteListHTML = pickSiteListHTML + " <b></b></div>";
          pickSiteListHTML = pickSiteListHTML + " <div class='field'> ";
          pickSiteListHTML = pickSiteListHTML + " <span class='tip'> ";
          pickSiteListHTML = pickSiteListHTML + jsonO.pickViewList[i].address;
          pickSiteListHTML = pickSiteListHTML + " </span> ";
          pickSiteListHTML = pickSiteListHTML + " <a class='ftx-05 map-link' target='_blank' href='" + jsonO.pickViewList[i].mapUrl + "'>" + jsonO.pickViewList[i].helpMessage + "</a> ";
          pickSiteListHTML = pickSiteListHTML + " </div> <div class='clr'></div></div>  ";

        }
      }
      $("#selfpick_siteDiv .pick-sites").html(pickSiteListHTML);
      $("#selfpick_siteDiv .selfpick_more_link").addClass("hide");
    },
    error: function(XMLHttpResponse) {
      //alert("系统繁忙，请稍后再试！");
      return false;
    }
  });
}
function closebtDialog(){
	$.closeDialog();
}
function closebtErrorTip(){
	$(".payment-bt-tips").hide();
}	
function btBrief(orderPrice){
	if($(".payment-item[onlinepaytype='1']").hasClass("item-selected")){
		  $(".fc-baitiao-info").show();
		  if(orderPrice==0){
			  $(".bt-edit-icon").hide();
		  }else{
			  $(".bt-edit-icon").show();
		  }
		  $("#sumPayPriceId").text("￥" + $("#btNeedPay").val());
	 }else{
		  $(".fc-baitiao-info").hide();
		  $("#sumPayPriceId").text("￥"+orderPrice.toFixed(2));
	}
	
}
function saveBtInfo(param,plan,laterPay,couponDes,total,des){
    if(typeof(total)!="number"){
    	total=parseFloat(total);
    }
    $("#sumPayPriceId").text("￥" + total.toFixed(2));
	$("#btNeedPay").val(total.toFixed(2));
	$("#baitiaoPayRequest").val(param);
	var t;
	if(des==undefined){
		if(isEmpty(couponDes)){
			couponDes='（不使用优惠';
		}else{
			couponDes='（优惠'+couponDes;
		}
		if(plan==undefined || plan==1){
			plan='<em>30天免息</em>';
		}else{
			plan='<em>¥'+laterPay+'x'+plan+'</em>期';
		}
		t ='白条支付：'+plan+couponDes+'）';
	}else{
		t=des;
	}
	var info ='<span>'+t+'<i class="bt-edit-icon" onclick="javascript:btDetail();" clstag="pageclick|keycount|PaymentLead__2016030411|5"></i></span>';
	$(".fc-baitiao-info").html(info);
}
function resetBt(price){
    var lastneedPay=$("#lastneedPay").val();
    if(typeof(price)!="number"){
    	price=parseFloat(price);
    }
    if(price!=parseFloat(lastneedPay)){
  	  $("#lastneedPay").val(price.toFixed(2));
  	  if($("#baitiaoPayRequest").val()!="plan=1"){
      	  if($(".payment-item[onlinepaytype='1']").hasClass("item-selected")){
      		  $(".payment-bt-tips").show();
      	  }
  	  }
  	  saveBtInfo("plan=1",1,0,null,price.toFixed(2));
    }
    if($(".payment-item[onlinepaytype='1']").hasClass("item-selected")){
        if(price==0){
        	$(".bt-edit-icon").hide();
        }else{
        	$(".bt-edit-icon").show();
        }
    }
}
function btDetail(){
	if($("#canBaitiaoDetail").val()=="false"){
		return;
	}
	var lastneedPay=$("#lastneedPay").val();
	if(parseFloat(lastneedPay)==0){
		alert("您已不需要分期！");
		return;
	}
	var orderAmount=$("#lastneedPay").val();
	var btParam=$("#baitiaoPayRequest").val();
	var allskus=$.parseJSON($("#sopCartJson").val());
	var notgitfsku=[];
	$(allskus).each(function(){ 
		if(!this.gift){
			var tmp = {"skuId":this.id,"count":this.num,"shopId":this.shopId,"cid":this.cid};
			notgitfsku.push(tmp);
		} 
	});
	var dataMap = JSON.stringify(notgitfsku);
	var param = "orderAmount="+orderAmount+"&"+btParam+"&dataMap="+encodeURIComponent(dataMap)+"&v="+new Date().getTime();

    //如果白条首次还款日期未自动设置（#baitiaoPayRequest中），则使用结算页初始化时的默认值。
    var baitiaoPayRepayDateInfo = $("#baitiaoPayRepayDateRequest").val();
    if(!isEmpty(baitiaoPayRepayDateInfo) && param.indexOf("repayDate") < 0){
        param += "&" + baitiaoPayRepayDateInfo;
    }

	var actionUrl = "//btrim.jd.com/coupon/getCalculateStage?"+param;
	  $('body').dialog({
		title:'选择白条支付',
	    width:570,
	    height:310,
	    type:'iframe',
	    autoIframe:false,
	    iframeTimestamp:false,
	    source:actionUrl,
	    mainId:"btDialog"
	  });
}
function jdPayCardList(){
	if(!$(".payment-item[onlinepaytype='3']").hasClass("item-selected")){
		return;
	}
	var flowType = $("#flowType").val();
	  var actionUrl=OrderAppConfig.DynamicDomain + "/payAndShip/getCardsInfo.action";
	  if(!isEmpty(flowType)){
		  actionUrl= actionUrl+"?flowType="+flowType;
	  }
  jQuery.ajax({
    type : "POST",
    dataType : "text",
    url : actionUrl,
    cache : false,
    success : function(dataResult, textStatus) {
    	$("#jdpayCards").remove();
      if (isUserNotLogin(dataResult)) {
        return;
      }
      if(!$(".payment-item[onlinepaytype='3']").hasClass("item-selected")){
  		return;
  	  }
      if (isHasMessage(dataResult)) {
        $('.payment-list').append('<div id="jdpayCards" class="bankcard-con"><span id="nocard" cardInfo="error" class="nobankcard"><i></i>当前没有获取到银行卡，提交订单后进入收银台结算</span></div>');
      	alert("获取银行卡列表异常");
        return;
      }
      else {
          $('.payment-list').append('<div id="jdpayCards" class="bankcard-con">'+dataResult+'</div>');
      }
    },
    error : function(XMLHttpResponse) {
    	$("#jdpayCards").remove();
        if(!$(".payment-item[onlinepaytype='3']").hasClass("item-selected")){
      		return;
      	}
        $('.payment-list').append('<div id="jdpayCards" class="bankcard-con"><span id="nocard" cardInfo="error" class="nobankcard"><i></i>当前没有获取到银行卡，提交订单后进入收银台结算</span></div>');
    	alert("获取银行卡列表异常");
    }
  });
}
//商品清单埋点
function skuListTracking(cartJson) {
	var skuIds = "";
	var obj = eval(cartJson);
	$(obj).each(function(index) {
		var value = obj[index];
		skuIds = skuIds + value.id + ",";
	});
	log('ord', 'trade', 10, skuIds);
}

//yanwenqi 自提地址项目 页面加载后异步调用推荐自提地址信息
function doAsynInitSelfPickInfo(){
	if($("#selfPickShutDownFlag").attr("value")==1){

		$("#pick_shipment_item").addClass("hide");
		
		var actionUrl = OrderAppConfig.AsyncDomain + "/payAndShip/initSelfPick.action";
		var selectedAddressType = "";
		var pickName = $("#pickName");
		var pickId = "";
		var isOpenConsignee = 0;
		if ($("#isOpenConsignee").val() == 1) {
			isOpenConsignee=1;
		}
		//如果orderStore里有自提地址，以前用过，就取以前的，没用过的话就传过去null
		if(pickName.length>0){
			pickId = $("#pickName").attr("pickId");
			if (isEmpty(pickId)) {
				pickId = "";
			}
		}
		//这个根据上面的方法获得的，此时已经异步走了一趟支付配送了？
		var payId = $("#payment-list .payment-item.item-selected").attr("payid");
		if (isEmpty(payId)) {
			payId = 4;
		}
			  
		var regionId = $("#temp_pick_sel_regionid").val();
		if (isEmpty(regionId)) {
			regionId = "-1";
		}
		//四级地址id
		var consigneeId = $("#consignee-list .item-selected").attr("consigneeId");
		
		//是否为默认地址 ，因为默认地址只有一个，且默认选中，初始化时选中的地址肯定为默认地址，判断有无addr-default类即可
		//isAddrDefault:0不是，1是
		var isAddrDefaultSpan = $(".addr-default");
		var isAddrDefault = 0;
		if(isAddrDefaultSpan.length>0){
			isAddrDefault = 1;
		}
		var param = "shipParam.payId=" + payId;
		param = param + "&shipParam.pickSiteId=" + pickId;
		param = param + "&shipParam.regionId=" + regionId;
		param = param + "&shipParam.pickSiteNum=10";
		param = param + "&consigneeId=" + consigneeId;
		param = param + "&isAddrDefault=" + isAddrDefault;
		param = param + "&selectedAddressType=" + selectedAddressType;
		param = param + "&isOpenConsignee=" + isOpenConsignee;
		param = addFlowTypeParam(param);
		jQuery.ajax({
		    type: "POST",
		    dataType: "json",
		    url: actionUrl,
		    data: param,
		    cache: false,
		    success: function(dataResult, textStatus) {
		      // 没有登录跳登录
		      if (isUserNotLogin(dataResult)) {
		        goToLogin();
		        return;
		      }
		      if (dataResult == "null" || dataResult == null || dataResult == "") {
			        return;
		      }
		      //根据返回场景标识，对页面进行操作
		      var jsonO = dataResult;
	
	//	   1:显示自提 2:置灰自提,可重新选择 3:原有自提置灰，可重新选择，并且推荐一条给前台 4:选中自提 5:无自提，推荐一条给前台 6:降级 ,7,置灰自提，不可重新选择
		      if(jsonO.selfPickFlag == 1){
		    	  //把自提显示打开
		    	  $("#selfPickArea").removeClass("hide");
		    	  //把自提关联的常用地址添加到地址列表里
		    	  var pickSiteListHTML = "";
		    	  pickSiteListHTML = pickSiteListHTML + "<li class='ui-switchable-panel ui-switchable-panel-selected selfPickInCommon' style='display:none' id='consignee_index_0'>";
		    	  pickSiteListHTML = pickSiteListHTML + "<div class='consignee-item selfPickInCommonItem hide' consigneeid='";
		    	  pickSiteListHTML = pickSiteListHTML + jsonO.consigneeId;
		    	  pickSiteListHTML = pickSiteListHTML + "' id='consignee_index_div_0'>";
		    	  pickSiteListHTML = pickSiteListHTML + "<span limit='8' title=''></span><b></b></div>";
		    	  pickSiteListHTML = pickSiteListHTML + "<div class='addr-detail hide'><span class='addr-name' limit='6' title=''>隐藏地址";
		    	  pickSiteListHTML = pickSiteListHTML + "</span><span class='addr-info' limit='45' title=''></span>";
		    	  pickSiteListHTML = pickSiteListHTML + "<span class='addr-tel'></span></div>";
		    	  pickSiteListHTML = pickSiteListHTML + "<div class='op-btns hide' consigneeid=''></div></li>";
		    	  $("#consignee-list").append(pickSiteListHTML); 
		    	  $("#selfPickEdit").removeClass("hide");
		      }else if(jsonO.selfPickFlag == 2){
		    	  //把自提显示打开,置灰，不可选
		    	  $("#selfPickArea").removeClass("hide");
		    	  $("#selfPickSiteName").removeClass("consignee-item");
		    	  $("#selfPickSiteName").addClass("consignee-item-disable");
		    	  $(".selfPickChoose").removeClass("hide");
		      }else if(jsonO.selfPickFlag == 3){
		    	//把自提显示打开,置灰，可选
		    	  $("#selfPickArea").removeClass("hide");
		    	  $("#selfPickSiteName").removeClass("consignee-item");
		    	  $("#selfPickSiteName").addClass("consignee-item-disable");
		    	  $(".selfPickChoose").removeClass("hide");
			      if(jsonO!=null && jsonO.pickId!=0){
			    	  $("#recommendAddr").removeClass("hide");
			    	//把新的推荐地址显示到页面
					  var pickSiteListHTML = "";
			    	  pickSiteListHTML = pickSiteListHTML + "<li id='recommendAddr' pickid='";
			    	  pickSiteListHTML = pickSiteListHTML + jsonO.pickId;
			    	  pickSiteListHTML = pickSiteListHTML + "'><div class='consignee-item' onclick='openUseSelfPickConsigneeDialog()'><i class='pick-rec-icon'></i><span>";
			    	  pickSiteListHTML = pickSiteListHTML + "匹配自提点";
			    	  pickSiteListHTML = pickSiteListHTML + "</span><b></b></div><div class='addr-detail'><span class='addr-name'>";
			    	  pickSiteListHTML = pickSiteListHTML + jsonO.pickName;
			    	  pickSiteListHTML = pickSiteListHTML + "</span><span class='addr-info' limit='45'>";
//			    	  pickSiteListHTML = pickSiteListHTML + jsonO.pickName+" "+jsonO.areaName+" ";
//			    	  pickSiteListHTML = pickSiteListHTML + jsonO.pickName+"   ";
			    	  pickSiteListHTML = pickSiteListHTML + jsonO.address;
			    	  pickSiteListHTML = pickSiteListHTML + "</span><span class='addr-tel'>";
			    	  pickSiteListHTML = pickSiteListHTML + "";
			    	  pickSiteListHTML = pickSiteListHTML + "</span></div><div class='addr-ops'>";
			    	  pickSiteListHTML = pickSiteListHTML + "<a href='#none' class='setdefault-selfPick ftx-05 mr10' onclick='openUseSelfPickConsigneeDialog(";
			    	  pickSiteListHTML = pickSiteListHTML + jsonO.pickId;
			    	  pickSiteListHTML = pickSiteListHTML + ")'>更换自提地址</a>";
			    	  pickSiteListHTML = pickSiteListHTML + "</div></li>";
			    	  $("#selfPickInfo").append(pickSiteListHTML);
			      }else{
			    	  $("#recommendAddr").addClass("hide");
			      }
		      }else if(jsonO.selfPickFlag == 4){
		    	  //去掉现有选中地址
		    	  $(".consignee-item.item-selected").removeClass("item-selected");
		    	//把自提关联的常用地址添加到地址列表里
		    	  var pickSiteListHTML = "";
		    	  pickSiteListHTML = pickSiteListHTML + "<li class='ui-switchable-panel ui-switchable-panel-selected selfPickInCommon' style='display:none' id='consignee_index_0'>";
		    	  pickSiteListHTML = pickSiteListHTML + "<div class='consignee-item selfPickInCommonItem hide' consigneeid='";
		    	  pickSiteListHTML = pickSiteListHTML + jsonO.consigneeId;
		    	  pickSiteListHTML = pickSiteListHTML + "' id='consignee_index_div_0'>";
		    	  pickSiteListHTML = pickSiteListHTML + "<span limit='8' title=''></span><b></b></div>";
		    	  pickSiteListHTML = pickSiteListHTML + "<div class='addr-detail hide'><span class='addr-name' limit='6' title=''>隐藏地址";
		    	  pickSiteListHTML = pickSiteListHTML + "</span><span class='addr-info' limit='45' title=''></span>";
		    	  pickSiteListHTML = pickSiteListHTML + "<span class='addr-tel'></span></div>";
		    	  pickSiteListHTML = pickSiteListHTML + "<div class='op-btns hide' consigneeid=''></div></li>";
		    	  $("#consignee-list").append(pickSiteListHTML); 
			    	//把自提显示打开，并选中自提
		    	  $("#selfPickArea").removeClass("hide");
		    	  $("#selfPickSiteName").addClass("item-selected");//这句还用不用
		    	  
		    	  doSelectSelfPickSite();
				    
				  //右下角的寄送至和收货人改了
	        		$("#sendAddr").html("寄送至："+$("#defaultSelfPick").find(".addr-detail").find(".addr-info").text());
	        		$("#sendMobile").html("收货人："+$("#defaultSelfPick").find(".addr-detail").find(".addr-name").text()+" "+$("#defaultSelfPick").find(".addr-detail").find(".addr-tel").text());
		      }else if(jsonO.selfPickFlag == 5){
		    	  //原先没有自提，推荐一条自提给前面显示
			    	//把自提显示打开
		    	  $("#selfPickArea").removeClass("hide");
		    	  $("#selfPickInfo").children('li').remove();
			      if(jsonO!=null && jsonO.pickId!=0){
			    	  $("#recommendAddr").removeClass("hide");
			    	//把新的推荐地址显示到页面
			    	  var pickSiteListHTML = "";
			    	  pickSiteListHTML = pickSiteListHTML + "<li id='recommendAddr' pickid='";
			    	  pickSiteListHTML = pickSiteListHTML + jsonO.pickId;
			    	  pickSiteListHTML = pickSiteListHTML + "'><div class='consignee-item' onclick='openUseSelfPickConsigneeDialog()'><i class='pick-rec-icon'></i><span>";
			    	  pickSiteListHTML = pickSiteListHTML + "匹配自提点";
			    	  pickSiteListHTML = pickSiteListHTML + "</span><b></b></div><div class='addr-detail'><span class='addr-name'>";
			    	  pickSiteListHTML = pickSiteListHTML + jsonO.pickName;
			    	  pickSiteListHTML = pickSiteListHTML + "</span><span class='addr-info' limit='45'>";
//			    	  pickSiteListHTML = pickSiteListHTML + jsonO.pickName+" "+jsonO.areaName+" ";
//			    	  pickSiteListHTML = pickSiteListHTML + jsonO.pickName+"   ";
			    	  pickSiteListHTML = pickSiteListHTML + jsonO.address;
			    	  pickSiteListHTML = pickSiteListHTML + "</span><span class='addr-tel'>";
			    	  pickSiteListHTML = pickSiteListHTML + "";
			    	  pickSiteListHTML = pickSiteListHTML + "</span></div><div class='addr-ops'>";
			    	  pickSiteListHTML = pickSiteListHTML + "<a href='#none' class='setdefault-selfPick ftx-05 mr10' onclick='openUseSelfPickConsigneeDialog(";
			    	  pickSiteListHTML = pickSiteListHTML + jsonO.pickId;
			    	  pickSiteListHTML = pickSiteListHTML + ")'>更换自提地址</a>";
		//	    	  pickSiteListHTML = pickSiteListHTML + "<a href='#none'>编辑</a>";
			    	  pickSiteListHTML = pickSiteListHTML + "</div></li>";
			    	  $("#selfPickInfo").append(pickSiteListHTML);
			      }else{
			    	  $("#recommendAddr").addClass("hide");
			      }
		      }else if(jsonO.selfPickFlag == 6){
		    	  // 降级，把原有自提打开，现有的继续隐藏
		      }else if(jsonO.selfPickFlag == 7){
		    	  //商品不支持自提，置灰自提，不可重新选择
		    	  $("#selfPickArea").removeClass("hide");
		    	  $("#selfPickSiteName").removeClass("consignee-item");
		    	  $("#selfPickSiteName").addClass("consignee-item-disable");
		    	  $(".noPickChoose").removeClass("hide");
		      }
		      subStrConsignee();
		      
		      if($("#defaultSelfPick").length==0 && $("#recommendAddr").length==0){
		    	  $("#selfPickLine").addClass("hide");
		      }else{
		    	  $("#selfPickLine").removeClass("hide");
		    	  if(jsonO.isFirstAccess==0){
		    		  $("#firstAccessTip").removeClass("hide");
		    	  }
		      }
		      
		      //没降级的情况下，下面的tab标签只保留一个
		      if(jsonO.selfPickFlag==1 || jsonO.selfPickFlag==2 || jsonO.selfPickFlag==3 || jsonO.selfPickFlag==4 || jsonO.selfPickFlag==5){
		    	 if($("#jd_shipment_item").hasClass("curr")){
		    	    $("#pick_shipment_item").addClass("hide");
		    	    $("#selfpick_name").addClass("hide");
		    	    $("#selfpick_name").next("div").addClass("hide");
		    	 }else if($("#pick_shipment_item").hasClass("curr")){
			    	$("#jd_shipment_item").addClass("hide");
			    	$("#_jdpay").addClass("hide");
			    	$("#selfpick_name").addClass("hide");
			    	$("#selfpick_name").next("div").addClass("hide");
		    	 }else if($("#_jdpay").hasClass("curr")){
			    	$("#pick_shipment_item").addClass("hide");
			    	$("#selfpick_name").addClass("hide");
			    	$("#selfpick_name").next("div").addClass("hide");
		    	 }
		      }
		    },
		    error: function(XMLHttpResponse) {
		      return false;
		    }
		  });
		
  		try{
			log('order_05','trade_10',1);
		}catch(e){
		}
	}
}

function doHandleFirstAccess(){
	$("#firstAccessTip").addClass("hide");
	var param = addFlowTypeParam(param);
	var actionUrl = OrderAppConfig.AsyncDomain + "/payAndShip/doHandleFirstAccess.action";
	jQuery.ajax({
	    type : "POST",
	    dataType : "json",
	    url : actionUrl,
	    data: param,
	    cache : false,
	    success : function(dataResult, textStatus) {},
	    error : function(XMLHttpResponse) {}
	  });
}



function doSelectSelfPickSite(pickId,pick_name){
	if(!$("#selfPickSiteName").hasClass("consignee-item-disable")){
		//判断当前选中的是否是货到付款
		var payId = $("#payment-list .payment-item.item-selected").attr("payid");
		//是货到付款的话，并且这个自提点不支持货到付款,不能选
		if(payId==1){
			var actionUrl = OrderAppConfig.AsyncDomain + "/payAndShip/verifySelfPick.action";
			var param ="shipParam.payId=" + payId;
			var regionId = $("#temp_pick_sel_regionid").val();
			if (isEmpty(regionId)) {
				regionId = "-1";
			}
			param = param + "&shipParam.regionId=" + regionId;
			param = addFlowTypeParam(param)
			jQuery.ajax({
			    type: "POST",
			    dataType: "json",
			    url: actionUrl,
			    data: param,
			    cache: false,
			    success: function(dataResult, textStatus) {
			      // 没有登录跳登录
			      if (isUserNotLogin(dataResult)) {
			        goToLogin();
			        return;
			      }
			      if (dataResult == "null" || dataResult == null || dataResult == "") {
//			    	    alert("该自提点不支持货到付款");
			    	  $(".payment-item").each(function(){ 
				  	    	var payid = $(this).attr('payid');
				  	    	var onlinepaytype = $(this).attr('onlinepaytype');
				  	    	 if(payid==1){
				  	    		$(this).removeClass("item-selected");
				  	    		$(this).addClass("payment-item-disabled");
				  	    		$(this).children('span').remove();
				  	    		$(this).append("<span id='codtips' class='qmark-icon qmark-tip' data-tips='商品属性或所在地区不支持货到付款'></span>");
				  	    		$(this).parent().removeAttr("onclick");
				  	    		$(this).parent().removeAttr("clstag");
				  	    	 }else if(payid==4 && onlinepaytype==0){
				  	    		 $(this).addClass("item-selected");
				  	    	 }
				    	  });
				    	//去除常用地址选中标记
				  	    $(".consignee-item.item-selected").removeClass("item-selected");
				  	    
				  	    if($(".consignee-item.selfPickInCommonItem").length==0){
				  	    	var pickSiteListHTML = "";
				  	  	  pickSiteListHTML = pickSiteListHTML + "<li class='ui-switchable-panel ui-switchable-panel-selected selfPickInCommon' style='display:none' id='consignee_index_0'>";
				  	  	  pickSiteListHTML = pickSiteListHTML + "<div class='consignee-item selfPickInCommonItem hide' consigneeid='138180911";
				  	//  	  pickSiteListHTML = pickSiteListHTML + pickId;
				  	  	  pickSiteListHTML = pickSiteListHTML + "' id='consignee_index_div_0'>";
				  	  	  pickSiteListHTML = pickSiteListHTML + "<span limit='8' title=''></span><b></b></div>";
				  	  	  pickSiteListHTML = pickSiteListHTML + "<div class='addr-detail hide'><span class='addr-name' limit='6' title=''>隐藏地址";
				  	  	  pickSiteListHTML = pickSiteListHTML + "</span><span class='addr-info' limit='45' title=''></span>";
				  	  	  pickSiteListHTML = pickSiteListHTML + "<span class='addr-tel'></span></div>";
				  	  	  pickSiteListHTML = pickSiteListHTML + "<div class='op-btns hide' consigneeid=''></div></li>";
				  	  	  $("#consignee-list").append(pickSiteListHTML); 
				  	    }
				  	    //选中隐藏在常用地址中的自提地址
				  	    $(".consignee-item.selfPickInCommonItem").addClass("item-selected");
				  		//去掉推荐自提
				  		$("#recommendAddr").remove();
				  		//给默认自提加选中标记
				  		$("#selfPickSiteName").addClass("item-selected");
				  	//    切换地址
				  	    tab_save_Consignee(1); 
				  	    $("#selfPickEdit").removeClass("hide");
				  	    $("#selfPickSiteName").removeClass("consignee-item-disable");
				  		$("#selfPickSiteName").addClass("consignee-item");
//				        return;
			      }
			      if(dataResult==1){
			    	//去除常用地址选中标记
			  	    $(".consignee-item.item-selected").removeClass("item-selected");
			  	    
			  	    if($(".consignee-item.selfPickInCommonItem").length==0){
			  	    	var pickSiteListHTML = "";
			  	  	  pickSiteListHTML = pickSiteListHTML + "<li class='ui-switchable-panel ui-switchable-panel-selected selfPickInCommon' style='display:none' id='consignee_index_0'>";
			  	  	  pickSiteListHTML = pickSiteListHTML + "<div class='consignee-item selfPickInCommonItem hide' consigneeid='138180911";
			  	//  	  pickSiteListHTML = pickSiteListHTML + pickId;
			  	  	  pickSiteListHTML = pickSiteListHTML + "' id='consignee_index_div_0'>";
			  	  	  pickSiteListHTML = pickSiteListHTML + "<span limit='8' title=''></span><b></b></div>";
			  	  	  pickSiteListHTML = pickSiteListHTML + "<div class='addr-detail hide'><span class='addr-name' limit='6' title=''>隐藏地址";
			  	  	  pickSiteListHTML = pickSiteListHTML + "</span><span class='addr-info' limit='45' title=''></span>";
			  	  	  pickSiteListHTML = pickSiteListHTML + "<span class='addr-tel'></span></div>";
			  	  	  pickSiteListHTML = pickSiteListHTML + "<div class='op-btns hide' consigneeid=''></div></li>";
			  	  	  $("#consignee-list").append(pickSiteListHTML); 
			  	    }
			  	    //选中隐藏在常用地址中的自提地址
			  	    $(".consignee-item.selfPickInCommonItem").addClass("item-selected");
			  		//去掉推荐自提
			  		$("#recommendAddr").remove();
			  		//给默认自提加选中标记
			  		$("#selfPickSiteName").addClass("item-selected");
			  	//    切换地址
			  	    tab_save_Consignee(1); 
			  	    $("#selfPickEdit").removeClass("hide");
			  	    $("#selfPickSiteName").removeClass("consignee-item-disable");
			  		$("#selfPickSiteName").addClass("consignee-item");
			      }
			    },
			    error: function(XMLHttpResponse) {
			      return false;
			    }
			  });
		}else{
		    //去除常用地址选中标记
		    $(".consignee-item.item-selected").removeClass("item-selected");
		    
		    if($(".consignee-item.selfPickInCommonItem").length==0){
		    	var pickSiteListHTML = "";
		  	  pickSiteListHTML = pickSiteListHTML + "<li class='ui-switchable-panel ui-switchable-panel-selected selfPickInCommon' style='display:none' id='consignee_index_0'>";
		  	  pickSiteListHTML = pickSiteListHTML + "<div class='consignee-item selfPickInCommonItem hide' consigneeid='138180911";
		//  	  pickSiteListHTML = pickSiteListHTML + pickId;
		  	  pickSiteListHTML = pickSiteListHTML + "' id='consignee_index_div_0'>";
		  	  pickSiteListHTML = pickSiteListHTML + "<span limit='8' title=''></span><b></b></div>";
		  	  pickSiteListHTML = pickSiteListHTML + "<div class='addr-detail hide'><span class='addr-name' limit='6' title=''>隐藏地址";
		  	  pickSiteListHTML = pickSiteListHTML + "</span><span class='addr-info' limit='45' title=''></span>";
		  	  pickSiteListHTML = pickSiteListHTML + "<span class='addr-tel'></span></div>";
		  	  pickSiteListHTML = pickSiteListHTML + "<div class='op-btns hide' consigneeid=''></div></li>";
		  	  $("#consignee-list").append(pickSiteListHTML); 
		    }
		    //选中隐藏在常用地址中的自提地址
		    $(".consignee-item.selfPickInCommonItem").addClass("item-selected");
			//去掉推荐自提
			$("#recommendAddr").remove();
			//给默认自提加选中标记
			$("#selfPickSiteName").addClass("item-selected");
		//    切换地址
		    tab_save_Consignee(1); 
		    $("#selfPickEdit").removeClass("hide");
		    $("#selfPickSiteName").removeClass("consignee-item-disable");
			$("#selfPickSiteName").addClass("consignee-item");
		}
	}
}

function doHandleSelfPick(type){
	if($("#selfPickShutDownFlag").attr("value")==1){
		//选中非自提方式
		if(!$(".consignee-item.selfPickInCommonItem").hasClass("item-selected")){
			if($("#jd_shipment_item").length>0 && $("#pick_shipment_item").hasClass("curr") ){
				if($("#jd_shipment_item").attr("onclick").indexOf('pay')!=-1){
					doSwithTab('pay');
				}else if($("#jd_shipment_item").attr("onclick").indexOf('jd_other')!=-1){
					doSwithTab('jd_other');
				}
			}else if($("#_jdpay").length>0 && $("#pick_shipment_item").hasClass("curr")){
				if($("#_jdpay").attr("onclick").indexOf('pay')!=-1){
					doSwithTab('pay');
				}else if($("#_jdpay").attr("onclick").indexOf('jd_other')!=-1){
					doSwithTab('jd_other');
				}
			}
		}
		if($(".consignee-item.selfPickInCommonItem").hasClass("item-selected")){
			//选中常用自提
			if($("#pick_shipment_item").length>0 && $("#pick_shipment_item").attr("onclick").indexOf('picksite_other')!=-1){
				//				doSwithTab('picksite_other');
				  //京东第三方自提
				  if ($("#pick_shipment_item").hasClass("disabled") == false) {
					 $("#pick_shipment_item").addClass("curr");
					 $("#pick_shipment_item").removeClass("hide");
					 $("#jd_shipment_item").addClass("hide");
					 $("#_jdpay").addClass("hide");
					 $("#selfpick_name").addClass("hide");
					 $("#selfpick_name").next("div").addClass("hide");
					 $("#_jdpay").removeClass("curr");
					 $("#selfpick_shipment").addClass("ui-switchable-panel-selected");
					 $("#selfpick_shipment").removeClass("hide");
				    //点击自提table标签保存默认自提点
						//模拟选中当前自提点start
					    var pickId = $("#pickName").attr("pickid");
					    var pick_name = $("#pickName").text();
						var pickDate = $('#beforePickDate').val();
						var pickSiteNum = $('#beforePickSiteNum').val();
						var sel_regionid = $('#beforePickSelRegionid').val();
						var regionId = $("#pick_sel_regionid").val();
						  	if (pick_name == "null" || pick_name == null || pick_name == "undefined" || pick_name == undefined) {
						  		pick_name = "";
						  	}
						  	var showPickSite = "<span class='ftx-03'>自提地点：</span>" + pick_name;
						    $("#beforePickRegionId").val(regionId);
						    $("#beforePickSelRegionid").val(regionId);
						    $("#beforePickSiteId").val(pickId);
						    $("#beforePickName").val(pick_name);
						    $("#pick_sel_regionid").val(regionId);
						    $("#pick_sel_id").val(pickId);
						    $("#is_invoke_pickdate").val("1");
					
						    $("#selfpick_name").html(showPickSite);
						    $("#saveParam_pickSiteId").val(pickId);
						    $("#saveParam_pickRegionId").val(regionId);
						    $("#saveParam_pickShipmentType").val(64);
						    $("#saveParam_jdShipmentType").val("");
						    $("#saveParam_otherShipmentType").val("");
						    $('#saveParam_pickDate').val(pickDate);
						    $('#saveParam_pickSiteNum').val(pickSiteNum);
						    $('#pick_sel_regionid').val(sel_regionid);
						    submitShipment(1);						   
				  }
			}else if($("#pick_shipment_item").length>0 && $("#pick_shipment_item").attr("onclick").indexOf('picksite')!=-1){
				  //京东自提
				  if ($("#pick_shipment_item").hasClass("disabled") == false) {
					  $("#pick_shipment_item").addClass("curr");
				    $("#jd_shipment_item").removeClass("curr");
				    //yanwenqi 自提地址项目 自提前置，把下面的自提隐藏掉
				    if($("#selfPickShutDownFlag").attr("value")==1){
					    $("#pick_shipment_item").removeClass("hide");
					    $("#jd_shipment_item").addClass("hide");
					    $("#_jdpay").addClass("hide");
					    $("#selfpick_name").addClass("hide");
					    $("#selfpick_name").next("div").addClass("hide");
				    }
				    $("#jd_shipment").addClass("hide");
				    $("#selfpick_shipment").addClass("ui-switchable-panel-selected");
				    $("#selfpick_shipment").removeClass("hide");
				  //点击自提table标签保存默认自提点
					//模拟选中当前自提点start
				    var pickId = $("#pickName").attr("pickid");
				    var pick_name = $("#pickName").text();
					var pickDate = $('#beforePickDate').val();
					var pickSiteNum = $('#beforePickSiteNum').val();
					var sel_regionid = $('#beforePickSelRegionid').val();
					var regionId = $("#pick_sel_regionid").val();
					  	if (pick_name == "null" || pick_name == null || pick_name == "undefined" || pick_name == undefined) {
					  		pick_name = "";
					  	}
					  	var showPickSite = "<span class='ftx-03'>自提地点：</span>" + pick_name;
					    $("#beforePickRegionId").val(regionId);
					    $("#beforePickSelRegionid").val(regionId);
					    $("#beforePickSiteId").val(pickId);
					    $("#beforePickName").val(pick_name);
					    $("#pick_sel_regionid").val(regionId);
					    $("#pick_sel_id").val(pickId);
					    $("#is_invoke_pickdate").val("1");
				
					    $("#selfpick_name").html(showPickSite);
					    $("#saveParam_pickSiteId").val(pickId);
					    $("#saveParam_pickRegionId").val(regionId);
					    $("#saveParam_pickShipmentType").val(64);
					    $("#saveParam_jdShipmentType").val("");
					    $("#saveParam_otherShipmentType").val("");
					    $('#saveParam_pickDate').val(pickDate);
					    $('#saveParam_pickSiteNum').val(pickSiteNum);
					    $('#pick_sel_regionid').val(sel_regionid);
					    submitShipment(1);
				  }
			}
		}
		 if($("#jd_shipment_item").hasClass("curr")){
	 	    $("#pick_shipment_item").addClass("hide");
	 	    $("#selfpick_name").addClass("hide");
	 	    $("#selfpick_name").next("div").addClass("hide");
	 	 }else if($("#pick_shipment_item").hasClass("curr")){
		    $("#jd_shipment_item").addClass("hide");
		    $("#selfpick_name").addClass("hide");
		    $("#selfpick_name").next("div").addClass("hide");
	 	 }else if($("#_jdpay").hasClass("curr")){
	    	$("#pick_shipment_item").addClass("hide");
	    	$("#selfpick_name").addClass("hide");
	    	$("#selfpick_name").next("div").addClass("hide");
	 	 }
	}
}
