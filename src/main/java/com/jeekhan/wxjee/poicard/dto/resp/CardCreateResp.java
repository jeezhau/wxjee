package com.jeekhan.wxjee.poicard.dto.resp;

import com.jeekhan.wxjee.common.CommonResp;

public class CardCreateResp extends CommonResp{
	private String card_id;

	/**
	 * 卡券创建成功后返回的卡券ID
	 * @return
	 */
	public String getCard_id() {
		return card_id;
	}

	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	
}
