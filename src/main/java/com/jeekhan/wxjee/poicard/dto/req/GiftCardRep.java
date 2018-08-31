package com.jeekhan.wxjee.poicard.dto.req;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.jeekhan.wxjee.poicard.dto.CardAdvancedInfo;
import com.jeekhan.wxjee.poicard.dto.CardBaseInfo;

/**
 * 兑换券接口请求对象
 * @author jeekhan
 *
 */
public class GiftCardRep {
	@NotNull
	private CardBaseInfo base_info;
	
	private CardAdvancedInfo advanced_info;
	
	@NotNull
    @Size(max=6)
    private String gift_name;	//兑换券兑换商品名字，限6个汉字
	@Min(1)
	@Max(999)
	private int gift_num;	//兑换券兑换商品数目，限三位数字
	@Size(max=2)
	private String gift_unit;	//兑换券兑换商品的数量单位，限两个汉字
	
	private String gift;	//兑换券类型时显示的礼品详情

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

	public String getGift_name() {
		return gift_name;
	}

	public void setGift_name(String gift_name) {
		this.gift_name = gift_name;
	}

	public int getGift_num() {
		return gift_num;
	}

	public void setGift_num(int gift_num) {
		this.gift_num = gift_num;
	}

	public String getGift_unit() {
		return gift_unit;
	}

	public void setGift_unit(String gift_unit) {
		this.gift_unit = gift_unit;
	}

	public String getGift() {
		return gift;
	}

	public void setGift(String gift) {
		this.gift = gift;
	}
	 
	
}



