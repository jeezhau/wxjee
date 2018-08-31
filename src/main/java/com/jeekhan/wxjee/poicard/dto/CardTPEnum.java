package com.jeekhan.wxjee.poicard.dto;

/**
 * 卡券类型枚举类
 * @author fachun.zhao
 *
 */
public enum CardTPEnum {
	MEMBER_CARD("MEMBER_CARD","会员卡"),
	CASH("CASH","代金券"),
	GIFT("GIFT","兑换券");
	
	private String value;
	private String desc;
	private CardTPEnum(String value,String desc) {
		this.value = value;
		this.desc = desc;
	}
	public String getValue() {
		return this.value;
	}
	public String getDesc() {
		return desc;
	}

}
