package com.jeekhan.wxjee.poicard.dto.req;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.jeekhan.wxjee.poicard.dto.CardAdvancedInfo;
import com.jeekhan.wxjee.poicard.dto.CardBaseInfo;

/**
 * 代金券接口请求对象
 * @author jeekhan
 *
 */
public class CashCardRep {
	@NotNull
	private CardBaseInfo base_info;
	@NotNull
	private CardAdvancedInfo advanced_info;
	@NotNull
    @Min(1)
    private int reduce_cost;	//代金券专用，表示减免金额（单位为分），不可填0。

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

	public int getReduce_cost() {
		return reduce_cost;
	}

	public void setReduce_cost(int reduce_cost) {
		this.reduce_cost = reduce_cost;
	}
	
}



