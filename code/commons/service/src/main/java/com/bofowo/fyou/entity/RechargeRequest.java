package com.bofowo.fyou.entity;

import java.io.Serializable;

/**
 * ============================李哲start==========================================
 * 充值
 * 
 * @author 李哲
 * @Date 2015_5_6 14:14
 */
public class RechargeRequest extends Request implements Serializable {

	/**
	 * 登录账户 max(60) 必填项
	 */
	private String login_id;

	/**
	 * 跳转充值，体现页面锁定金额 max(10) 非必填项
	 */
	private String amt;

	/**
	 * 商户返回地址 MAX(200) 必填项 商户接收交易结果通知地址
	 */
	private String page_notify_url;

	/**
	 * 商户后台通知地址MAX(200) 非必填项 商户接收后台结果通知地址
	 */
	private String back_notify_url;

	/**
	 * 签名数据 必填项 使用rsa 对所有参数按字母排序 | 连接 加密后的值
	 */
	private String signature;

	public String getLogin_id() {
		return login_id;
	}

	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	public String getAmt() {
		return amt;
	}

	public void setAmt(String amt) {
		this.amt = amt;
	}

	public String getPage_notify_url() {
		return page_notify_url;
	}

	public void setPage_notify_url(String page_notify_url) {
		this.page_notify_url = page_notify_url;
	}

	public String getBack_notify_url() {
		return back_notify_url;
	}

	public void setBack_notify_url(String back_notify_url) {
		this.back_notify_url = back_notify_url;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	/**
	 * ======================李哲 end=================================
	 */
}
