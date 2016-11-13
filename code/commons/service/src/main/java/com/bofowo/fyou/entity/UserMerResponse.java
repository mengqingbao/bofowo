package com.bofowo.fyou.entity;

/**
 * 
 * 对应开户时富友返回的xml文件
 * 
 * @author xuhaijun
 *
 */
// 对应返回的xml文件的根元素

public class UserMerResponse extends Response {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -566637368316186669L;

	/**
	 * 手机号 返回参数中该参数为必填项
	 */
	private String mobile_no;

	/**
	 * 客户姓名 返回参数中该参数为必填项
	 */
	private String cust_nm;

	/**
	 * 身份证号码 返回参数中该参数为必填项
	 */
	private String certif_id;

	/**
	 * 邮箱地址 返回参数中该参数为非必填项
	 */
	private String email;

	/**
	 * 开户行地区代码 返回参数中该参数为必填项
	 */
	private String city_id;

	/**
	 * 开户行行别 返回参数中该参数为必填项
	 */
	private String parent_bank_id;
	/**
	 * 开户行支行名称 返回参数中该参数为非必填项
	 */
	private String bank_nm;

	/**
	 * 银行卡号 返回参数中该参数为必填项
	 */
	private String capAcntNo;

	/**
	 * 用户在律金所平台的id 非必填
	 */
	private String user_id_from;

	/**
	 * 富友返回的 签名数据 必填项
	 */
	private String signature;

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getCust_nm() {
		return cust_nm;
	}

	public void setCust_nm(String cust_nm) {
		this.cust_nm = cust_nm;
	}

	public String getCertif_id() {
		return certif_id;
	}

	public void setCertif_id(String certif_id) {
		this.certif_id = certif_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity_id() {
		return city_id;
	}

	public void setCity_id(String city_id) {
		this.city_id = city_id;
	}

	public String getParent_bank_id() {
		return parent_bank_id;
	}

	public void setParent_bank_id(String parent_bank_id) {
		this.parent_bank_id = parent_bank_id;
	}

	public String getBank_nm() {
		return bank_nm;
	}

	public void setBank_nm(String bank_nm) {
		this.bank_nm = bank_nm;
	}

	public String getCapAcntNo() {
		return capAcntNo;
	}

	public void setCapAcntNo(String capAcntNo) {
		this.capAcntNo = capAcntNo;
	}

	public String getUser_id_from() {
		return user_id_from;
	}

	public void setUser_id_from(String user_id_from) {
		this.user_id_from = user_id_from;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

}
