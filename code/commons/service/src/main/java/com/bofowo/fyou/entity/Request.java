package com.bofowo.fyou.entity;

import java.io.Serializable;

/**
 * 封装用于请求时的参数
 * 
 * @author xuhaijun
 * 
 *         2015-6-25
 *
 */
public class Request implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6106140144754779012L;
	/**
	 * 商户号
	 */
	private String mchnt_cd;
	/**
	 * 流水号
	 */
	private String mchnt_txn_ssn;

	/**
	 * 用户操作记录id
	 */
	private int userId;

	/**
	 * eamil
	 */
//	private String eamil;

	/**
	 * 
	 * 投标id
	 */
	private Integer loanId;
	/**
	 * 还款LoanPhaseId
	 */
	private Integer loanPhaseId;
	/**
	 * 债权转让Id
	 */
	private Integer loanInvestorId;

	/**
	 * 充值金额 否 金额单位：元，不能为负，不允许为 0，保留 2 位小数；格式：12.00
	 */

	private String trdAmt;

	/**
	 * 向第三方发送请求时的ipUrl
	 */
	private String ipUrl;

	/**
	 * 用户操作类型
	 */
	private String postTye;

	/**
	 * 签名信息 必填项 使用rsa 对所有参数按字母排序 | 连接 加密后的值
	 */
	private String signature;

	/**
	 * 发送错误消息
	 */
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public Integer getLoanId() {
		return loanId;
	}

	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}

	public Integer getLoanPhaseId() {
		return loanPhaseId;
	}

	public void setLoanPhaseId(Integer loanPhaseId) {
		this.loanPhaseId = loanPhaseId;
	}

	public Integer getLoanInvestorId() {
		return loanInvestorId;
	}

	public void setLoanInvestorId(Integer loanInvestorId) {
		this.loanInvestorId = loanInvestorId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPostTye() {
		return postTye;
	}

	public void setPostTye(String postTye) {
		this.postTye = postTye;
	}

	public String getTrdAmt() {
		return trdAmt;
	}

	public void setTrdAmt(String trdAmt) {
		this.trdAmt = trdAmt;
	}

	public String getIpUrl() {
		return ipUrl;
	}

	public void setIpUrl(String ipUrl) {
		this.ipUrl = ipUrl;
	}

}
