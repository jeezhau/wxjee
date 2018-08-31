package com.jeekhan.wxjee.poicard.dto;

/**
 *折扣券信息
 * @author jeekhan
 *
 */
public class DiscountCard {
	private CardBaseInfo base_info;
	private CardAdvancedInfo advanced_info;
	private int discount;	//必填；折扣券专用，表示打折额度（百分比）。填30就是七折。
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
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	

}
