package com.jeekhan.wxjee.poicard.handle;

import com.alibaba.fastjson.JSONObject;
import com.jeekhan.wxjee.poicard.dto.CardTPEnum;
import com.jeekhan.wxjee.poicard.dto.req.MemberCardRep;
import com.jeekhan.wxjee.poicard.dto.resp.CardCreateResp;

public class MemberCardHandle {
	
	/**
	 * 会员卡创建
	 * @param req
	 * @return
	 */
	public static CardCreateResp createMemberCard(MemberCardRep req) {
		JSONObject card = new JSONObject();
		card.put("card_type", CardTPEnum.MEMBER_CARD.getValue());
		JSONObject member = (JSONObject) JSONObject.toJSON(req);
		card.put(CardTPEnum.MEMBER_CARD.getValue().toLowerCase(), member);
		CardCreateResp resp = CardHandle.createCard(card);
		return resp;
	}

}
