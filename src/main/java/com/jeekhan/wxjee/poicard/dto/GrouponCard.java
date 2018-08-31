package com.jeekhan.wxjee.poicard.dto;

/**
 *  团购券信息
 * @author fachun.zhao
 *
 */
public class GrouponCard {
	private CardBaseInfo base_info;
	private CardAdvancedInfo advanced_info;
    private String  deal_detail;	//string( 3072 )	双人套餐\n -进口红酒一支。\n孜然牛肉一份。	团购券专用，团购详情。
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
	public String getDeal_detail() {
		return deal_detail;
	}
	public void setDeal_detail(String deal_detail) {
		this.deal_detail = deal_detail;
	}
	

}
