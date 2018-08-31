package com.jeekhan.wxjee.poicard.dto;

/**
 *代金券信息
 * @author jeekhan
 *
 */
public class CashCard {
	private CardBaseInfo base_info;
	private CardAdvancedInfo advanced_info;
	private int least_cost;		//必填，代金券专用，表示起用金额（单位为分）,如果无起用门槛则填0。
	private int reduce_cost;	//必填，代金券专用，表示减免金额。（单位为分）
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
	public int getLeast_cost() {
		return least_cost;
	}
	public void setLeast_cost(int least_cost) {
		this.least_cost = least_cost;
	}
	public int getReduce_cost() {
		return reduce_cost;
	}
	public void setReduce_cost(int reduce_cost) {
		this.reduce_cost = reduce_cost;
	}
	

}
