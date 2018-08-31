package com.jeekhan.wxjee.poicard.dto;

/**
 *兑换券信息
 * @author jeekhan
 *
 */
public class GiftCard {
	private CardBaseInfo base_info;
	private CardAdvancedInfo advanced_info;
	private String  default_detail;	//必填；音乐木盒。	优惠券专用，填写优惠详情。
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
	public String getDefault_detail() {
		return default_detail;
	}
	public void setDefault_detail(String default_detail) {
		this.default_detail = default_detail;
	}
	
	

}
