package com.jeekhan.wxjee.poicard.dto.resp;

import com.jeekhan.wxjee.common.CommonResp;

public class CardUpdateResp extends CommonResp{
	private Boolean send_check;

	/**
	 * 是否提交审核，false为修改后不会重新提审，true为修改字段后重新提审，该卡券的状态变为审核中。 
	 * @return
	 */
	public Boolean isSend_check() {
		return send_check;
	}

	public void setSend_check(Boolean send_check) {
		this.send_check = send_check;
	}


	
	
}
