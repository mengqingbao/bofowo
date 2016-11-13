package com.bofowo.fyou.entity;

import java.io.Serializable;

/**
 * 该类中的属性用于对应富友返回的参数中的公共属性值
 * 
 * 该类中的属性均为必填项
 * 
 * @author xuhaijun
 * 
 *         2015-6-25
 *
 */
public class Response implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6518743306180635978L;

	/**
	 * 商户号
	 */
	private String mchnt_cd;
	/**
	 * 请求流水号
	 */
	private String mchnt_txn_ssn;

	/**
	 * 响应码
	 */
	private String resp_code;

	/**
	 * 签名数据
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

	public String getResp_code() {
		return resp_code;
	}

	public void setResp_code(String resp_code) {
		this.resp_code = resp_code;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
