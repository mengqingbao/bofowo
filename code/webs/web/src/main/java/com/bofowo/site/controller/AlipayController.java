/**
 * Project Name:lymall-web
 * File Name:AlipayController.java
 * Package Name:com.bofowo.site.controller
 * Date:2016年9月15日上午11:09:44
 * Copyright (c) 2016,Shanghai bofowo Technology co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.config.AlipayConfig;
import com.alipay.util.AlipayNotify;
import com.alipay.util.AlipaySubmit;
import com.bofowo.site.model.AlipayAccountModel;
import com.bofowo.site.model.TradeModel;
import com.bofowo.site.service.AlipayAccountService;
import com.bofowo.site.service.OrderService;
import com.bofowo.site.service.TradeService;

import common.security.login.CurrentUserUtil;
import common.util.LayoutType;
import common.web.BaseController;

/**
 * ClassName:AlipayController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年9月15日 上午11:09:44 <br/>
 * @author   mqb
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Controller
public class AlipayController extends BaseController {
	
	@Resource
	private TradeService tradeService;
	@Resource
	private AlipayAccountService alipayAccountService;
	@Resource
	private OrderService orderService;
	
	private String domain="http://www.bofowo.cn/";
	
	@Value("#{settings['alipay.gateway']}")
	public String alipayGateWay;

	/**
	 * 
	 * notifyUrl:支付宝回调函数. <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author mqb
	 * @param out_trade_no
	 * @param trade_no
	 * @param trade_status
	 * @param model
	 * @return
	 * @since JDK 1.7
	 */
	@RequestMapping(value="notify_alipay_asynic",method=RequestMethod.POST)
	@ResponseBody
	public String notifyUrlAsynic(String out_trade_no,String trade_no,String trade_status,ModelMap model){
		this.setLayout(LayoutType.EMPTY);
		//获取支付宝POST过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
			params.put(name, valueStr);
		}
		
		if(AlipayNotify.verify(params)){//验证成功
			//////////////////////////////////////////////////////////////////////////////////////////
			//请在这里加上商户的业务逻辑程序代码

			//——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
			
			if(trade_status.equals("TRADE_FINISHED")){
				//判断该笔订单是否在商户网站中已经做过处理
					//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
					//请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
					//如果有做过处理，不执行商户的业务程序
					
				//注意：
				//退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
			} else if (trade_status.equals("TRADE_SUCCESS")){
				//判断该笔订单是否在商户网站中已经做过处理
					//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
					//请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
					//如果有做过处理，不执行商户的业务程序
					
				//注意：
				//付款完成后，支付宝系统发送该交易状态通知
			}

			//——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
				
			return "success";	//请不要修改或删除

			//////////////////////////////////////////////////////////////////////////////////////////
		}else{//验证失败
			return "fail";
		}
		
	}
	
	
		@RequestMapping(value="notify_alipay_synic",method=RequestMethod.GET)
		public String notifyUrlSynic(ModelMap model) throws UnsupportedEncodingException{
			this.setLayout(LayoutType.EMPTY);
			Map<String,String> params = new HashMap<String,String>();
			Map requestParams = request.getParameterMap();
			for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
				String name = (String) iter.next();
				String[] values = (String[]) requestParams.get(name);
				String valueStr = "";
				for (int i = 0; i < values.length; i++) {
					valueStr = (i == values.length - 1) ? valueStr + values[i]
							: valueStr + values[i] + ",";
				}
				//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
				valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
				params.put(name, valueStr);
			}
			
			//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
			//商户订单号
			String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

			//支付宝交易号
			String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

			//交易状态
			String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");

			//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
			
			//计算得出通知验证结果
			boolean verify_result = AlipayNotify.verify(params);
			
			if(verify_result){//验证成功
				//////////////////////////////////////////////////////////////////////////////////////////
				//请在这里加上商户的业务逻辑程序代码

				//——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
				if(trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS")){
					//判断该笔订单是否在商户网站中已经做过处理
						//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
						//如果有做过处理，不执行商户的业务程序
				}
				
				//该页面可做页面美工编辑
				model.put("flage","success");
				
				//——请根据您的业务逻辑来编写程序（以上代码仅作参考）——

				//////////////////////////////////////////////////////////////////////////////////////////
			}else{
				//该页面可做页面美工编辑
				model.put("flage","fail");
			}
			
			return "pay/alipayResult";
		}
	
		@RequestMapping("alipay")
		public String submit2alipay(Integer tid,ModelMap model){
			String username=CurrentUserUtil.getCurrentUserName();
			tradeService.pay(tid,"1",username);
			//支付流程添加后 删除 该返回内容
			if(1==1)
			return "redirect:my-sale-trades.htm?status=0";
			
			//以上返回为了屏蔽不能支付调试。以后待处理。
			Long id=0l;
			try{
			 id=Long.valueOf(tid);
			}catch(Exception e){
				return "redirect:error.htm";
			}
			TradeModel trade=tradeService.getById(id);
			if(trade==null){
				return "redirect:error.htm";
			}
			AlipayAccountModel aam=alipayAccountService.getBySellerId(CurrentUserUtil.getCurrentUserName());
			Map<String, String> sParaTemp = new HashMap<String, String>();
			sParaTemp.put("service", AlipayConfig.service);
	        sParaTemp.put("partner", aam.getAliPayAccount());
	        sParaTemp.put("seller_id", AlipayConfig.seller_id);
	        sParaTemp.put("_input_charset", AlipayConfig.input_charset);
			sParaTemp.put("payment_type", AlipayConfig.payment_type);
			sParaTemp.put("notify_url", domain+"notify_alipay_synic.htm");
			sParaTemp.put("return_url", domain+"alipay-result.htm");
			sParaTemp.put("anti_phishing_key", AlipayConfig.anti_phishing_key);
			sParaTemp.put("exter_invoke_ip", AlipayConfig.exter_invoke_ip);
			sParaTemp.put("out_trade_no", String.valueOf(tid));
			sParaTemp.put("subject", trade.getTitle());
			sParaTemp.put("total_fee", String.valueOf(trade.getRealPay()));
			sParaTemp.put("body", trade.getNote());
//			List<NameValuePair> list=new ArrayList<NameValuePair>();
//			list.add(new BasicNameValuePair("service", AlipayConfig.service));
//	        list.add(new BasicNameValuePair("partner", AlipayConfig.partner));
//	        list.add(new BasicNameValuePair("seller_id", AlipayConfig.seller_id));
//	        list.add(new BasicNameValuePair("_input_charset", AlipayConfig.input_charset));
//			list.add(new BasicNameValuePair("payment_type", AlipayConfig.payment_type));
//			list.add(new BasicNameValuePair("notify_url", domain+"notify_alipay_synic.htm"));
//			list.add(new BasicNameValuePair("return_url", domain+"alipay-result.htm"));
//			list.add(new BasicNameValuePair("anti_phishing_key", AlipayConfig.anti_phishing_key));
//			list.add(new BasicNameValuePair("exter_invoke_ip", AlipayConfig.exter_invoke_ip));
//			list.add(new BasicNameValuePair("out_trade_no", tid));
//			list.add(new BasicNameValuePair("subject", trade.getTitle()));
//			list.add(new BasicNameValuePair("total_fee", String.valueOf(trade.getRealPay())));
//			list.add(new BasicNameValuePair("body", trade.getNote()));
			//其他业务参数根据在线开发文档，添加参数.文档地址:https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.O9yorI&treeId=62&articleId=103740&docType=1
	        //如sParaTemp.put("参数名","参数值");
			
			//建立请求
			//String sHtmlText = AlipaySubmit.buildRequest(sParaTemp,"get","确认");
			
			
			String sHtmlText = null;
//			try {
//				sHtmlText = HttpExcuteUtil.getContent(alipayGateWay, null, list, true);
//			} catch (IOException e) {
//				log.error(e.getMessage());
//			}
			 sHtmlText = AlipaySubmit.buildRequest(sParaTemp,"get","确认");
			System.out.println(sHtmlText);
			model.put("formString", sHtmlText);
			return "pay/alipay";
		}
		
		//支付完成跳转页面
		@RequestMapping(value="alipay-result")
		public String alipayesult(){
			
			return "pay/reuslt";
		}
		//本地应用网关
		@RequestMapping(value="alipay-gate",method=RequestMethod.POST)
		public String localGateway(ModelMap model){
			this.setLayout(LayoutType.EMPTY);
			model.put("json", "success");
			return "common/json";
		}
	
		//支付结果异步通知接口
		@RequestMapping(value="trade-conform",method=RequestMethod.POST)
		public String tradeConform(ModelMap model){
			this.setLayout(LayoutType.EMPTY);
			model.put("json", "success");
			return "common/json";
		}
	
}

