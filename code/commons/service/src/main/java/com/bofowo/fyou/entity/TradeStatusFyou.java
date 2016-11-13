package com.bofowo.fyou.entity;

/**
 * 交易状态-用于TradeEntry.status
 * 
 * @author
 * 
 */
public enum TradeStatusFyou {

	/**
	 * 待处理
	 */
	WAITING("1111"),

	/**
	 * 成功
	 */
	SUCCESS("0000"),

	/**
	 * 处理失败
	 */
	FAIL("9999");

	private String tradeType;

	TradeStatusFyou(String srce) {
		this.tradeType = srce;
	}

	public String value() {
		return tradeType;
	}
}
