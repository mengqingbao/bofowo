package com.bofowo.fyou.entity;

import java.io.Serializable;

/**
 * ============================李哲start==========================================
 * 
 * 
 * @author 徐海军
 * @Date 2015-6-26
 */
public class RechargeInformRequest implements Serializable {
	/**
	 * 返回码 长度10 0000成功
	 */
	private String resp_code;

	/**
	 * 商户代码 长度15 必填项
	 */
	private String mchnt_cd;

	/**
	 * 流水号 商户号唯一标示 max(30) 必填项
	 */
	private String mchnt_txn_ssn;

	/**
	 * 用户登录的ID max(11)
	 */
	private String login_id;

	/**
	 * 充值金额 max(12)
	 */
	private String amt;

	/**
	 * 备注 max(60) 非必填项
	 */
	private String rem;

	/**
	 * 签名数据 必填项 使用rsa 对所有参数按字母排序 | 连接 加密后的值
	 */
	private String signature;
	

	public String getResp_code() {
		return resp_code;
	}

	public void setResp_code(String resp_code) {
		this.resp_code = resp_code;
	}

	public String getMchnt_cd() {
		return mchnt_cd;
	}

	public void setMchnt_cd(String mchnt_cd) {
		this.mchnt_cd = mchnt_cd;
	}

	public String getMchnt_txn_ssn() {
		return mchnt_txn_ssn;
	}

	public void setMchnt_txn_ssn(String mchnt_txn_ssn) {
		this.mchnt_txn_ssn = mchnt_txn_ssn;
	}

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

	public String getRem() {
		return rem;
	}

	public void setRem(String rem) {
		this.rem = rem;
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
