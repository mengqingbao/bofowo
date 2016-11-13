package com.bofowo.fyou.entity;

/**
 * 封装向富友发送开户请求时的参数
 * 
 * 属性值与富友定义的参数key 相同
 * 
 * 传递给富友的参数是以字符串拼接的形式
 * 
 * @author xuhaijun
 */
public class UserMerRequest extends Request {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2848681447032558373L;
	/**
	 * userid user max(60) 在律金所的标志位 非必填
	 */
	private String user_id_from;
	/**
	 * 客户姓名 max(30) 非必填项
	 */
	private String cust_nm;

	/**
	 * 身份证号码 max(20) 非必填项
	 */
	private String certif_id;

	/**
	 * 手机号 11 非必填项
	 */
	private String mobile_no;

	/**
	 * 邮箱地址 max(60) 非必填项
	 */
	private String email;

	/**
	 * 开户行地区代码 4位 必填项
	 */
	private String city_id;

	/**
	 * 开户行行别 4位 必填项
	 */
	private String parent_bank_id;

	/**
	 * 开户行支行名称 mac(250) 非必填项
	 */
	private String bank_nm;

	/**
	 * 账号-- (银行卡号) (10-30) 必填项
	 */
	private String capAcntNo;

	/**
	 * 商户接收交易结果通知地址 max(200) 必填
	 */
	private String page_notify_url;

	/**
	 * 商户接收后台结果通知
	 */
	private String back_notify_url;

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

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
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

}
