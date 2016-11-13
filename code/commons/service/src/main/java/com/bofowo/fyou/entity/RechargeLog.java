package com.bofowo.fyou.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class RechargeLog implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 186023088777665183L;

	/**
     *
     */
	private int rechargeLogId;

	/**
	 * 充值金额
	 */
	private BigDecimal amount;

	/**
	 * 支付id
	 */
	private String payId;

	/**
	 * 支付时间
	 */
	private Date rechargeTime;

	/**
	 * 支付类型
	 */
	private int payType;

	/**
	 * 支付者id
	 */
	private int userId;

	/**
	 * 充值费用
	 */
	private BigDecimal recharge_fee;

	/**
	 * 默认是0未成功，1是成功
	 */
	private Boolean flag;

	/**
	 * 预留充值金额
	 */
	private BigDecimal reserve_fee_balance;

	private int roles;

	private String nickName;

	/**
     *
     */
	public int getRechargeLogId() {
		return rechargeLogId;
	}

	/**
     *
     */
	public void setRechargeLogId(int rechargeLogId) {
		this.rechargeLogId = rechargeLogId;
	}

	/**
	 * 充值金额
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * 充值金额
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * 支付id
	 */
	public String getPayId() {
		return payId;
	}

	/**
	 * 支付id
	 */
	public void setPayId(String payId) {
		this.payId = payId == null ? null : payId.trim();
	}

	/**
	 * 支付时间
	 */
	public Date getRechargeTime() {
		return rechargeTime;
	}

	/**
	 * 支付时间
	 */
	public void setRechargeTime(Date rechargeTime) {
		this.rechargeTime = rechargeTime;
	}

	/**
	 * 支付类型
	 */
	public int getPayType() {
		return payType;
	}

	/**
	 * 支付类型
	 */
	public void setPayType(int payType) {
		this.payType = payType;
	}

	/**
	 * 支付者id
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * 支付者id
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * 充值费用
	 */
	public BigDecimal getRecharge_fee() {
		return recharge_fee;
	}

	/**
	 * 充值费用
	 */
	public void setRecharge_fee(BigDecimal recharge_fee) {
		this.recharge_fee = recharge_fee;
	}

	/**
	 * 默认是0未成功，1是成功
	 */
	public Boolean getFlag() {
		return flag;
	}

	/**
	 * 默认是0未成功，1是成功
	 */
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public BigDecimal getReserve_fee_balance() {
		return reserve_fee_balance;
	}

	public void setReserve_fee_balance(BigDecimal reserve_fee_balance) {
		this.reserve_fee_balance = reserve_fee_balance;
	}

	public int getRoles() {
		return roles;
	}

	public void setRoles(int roles) {
		this.roles = roles;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

}
