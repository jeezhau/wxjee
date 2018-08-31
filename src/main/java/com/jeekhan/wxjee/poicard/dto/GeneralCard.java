package com.jeekhan.wxjee.poicard.dto;

/**
 *兑换券信息
 * @author jeekhan
 *
 */
public class GeneralCard {
	private CardBaseInfo base_info;
	private CardAdvancedInfo advanced_info;
	private String  gift;	//必填；可兑换音乐木盒一个。	兑换券专用，填写兑换内容的名称。
	public CardBaseInfo getBase_info() {
		return base_info;
	}
	public void setBase_info(CardBaseInfo base_info) {
		this.base_info = base_info;
	}
	public CardAdvancedInfo getAdvanced_info() {
		return advanced_info;
	}
	public void setAdvanced_info(CardAdvancedInfo advanced_info) {
		this.advanced_info = advanced_info;
	}
	public String getGift() {
		return gift;
	}
	public void setGift(String gift) {
		this.gift = gift;
	}
	
	

}
