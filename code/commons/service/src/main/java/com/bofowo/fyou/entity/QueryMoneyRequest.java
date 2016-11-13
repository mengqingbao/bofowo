package com.bofowo.fyou.entity;

import java.io.Serializable;

public class QueryMoneyRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 560060399083013936L;

	/**
	 * 商户代码 长度15 必填项
	 */
	private String mchnt_cd;

	/**
	 * 流水号 max(30) 必填项
	 */
	private String mchnt_txn_ssn;

	/**
	 * 交易日期 长度8 必填项
	 */
	private String mchnt_txn_dt;

	/**
	 * 待查询的登录账户 max(120) 必填项
	 */
	private String cust_no;

	/**
	 * 签名数据 必填项
	 */
	private String signature;

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

	public String getMchnt_txn_dt() {
		return mchnt_txn_dt;
	}

	public void setMchnt_txn_dt(String mchnt_txn_dt) {
		this.mchnt_txn_dt = mchnt_txn_dt;
	}

	public String getCust_no() {
		return cust_no;
	}

	public void setCust_no(String cust_no) {
		this.cust_no = cust_no;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

}
