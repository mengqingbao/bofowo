package com.bofowo.fyou.entity;

import java.io.Serializable;

public class QueryUserStatusRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8315877414807006910L;

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
	private String user_ids;

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

	public String getUser_ids() {
		return user_ids;
	}

	public void setUser_ids(String user_ids) {
		this.user_ids = user_ids;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

}
