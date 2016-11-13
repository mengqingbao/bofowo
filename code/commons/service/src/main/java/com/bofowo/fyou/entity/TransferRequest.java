package com.bofowo.fyou.entity;

import java.io.Serializable;

public class TransferRequest implements Serializable {
	/**
	 * 商户号
	 */
	private String mchnt_cd;
	/**
	 * 流水号
	 */
	private String mchnt_txn_ssn;
	

	/**
	 * 付款登录账户 max(60) 必填项
	 */
	private String out_cust_no;

	/**
	 * 收款登录账户 max(60) 必填项
	 */
	private String in_cust_no;

	/**
	 * 转账金额 max(12) 必填项
	 */
	private String amt;

	/**
	 * 备注max(60) 非必填项
	 */
	private String rem;

	/**
	 * 预授权合同号
	 */
	private String contract_no;
	/**
	 * 签名信息 必填项 使用rsa 对所有参数按字母排序 | 连接 加密后的值
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
	public String getOut_cust_no() {
		return out_cust_no;
	}
	public void setOut_cust_no(String out_cust_no) {
		this.out_cust_no = out_cust_no;
	}
	public String getIn_cust_no() {
		return in_cust_no;
	}
	public void setIn_cust_no(String in_cust_no) {
		this.in_cust_no = in_cust_no;
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
	public String getContract_no() {
		return contract_no;
	}
	public void setContract_no(String contract_no) {
		this.contract_no = contract_no;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
}
