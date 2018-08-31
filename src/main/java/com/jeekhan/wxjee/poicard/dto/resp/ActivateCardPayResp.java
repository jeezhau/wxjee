package com.jeekhan.wxjee.poicard.dto.resp;

import com.jeekhan.wxjee.common.CommonResp;

/**
 * 券点账户激活接口返回对象
 * @author jeekhan
 *
 */
public class ActivateCardPayResp extends CommonResp{
	private int reward;

	/**
	 * 奖励券点数量，以元为单位，微信卡券对每一个新开通券点账户的商户奖励200个券点
	 * @return
	 */
	public int getReward() {
		return reward;
	}

	public void setReward(int reward) {
		this.reward = reward;
	}

	
	
}
