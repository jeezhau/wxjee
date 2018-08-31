package com.jeekhan.wxjee.poicard.dto.resp;

import com.jeekhan.wxjee.common.CommonResp;

/**
 * 优惠券批价接口返回对象
 * @author jeekhan
 *
 */
public class CoinsInfoResp extends CommonResp{
	private Double free_coin;	//免费券点数目
	private Double pay_coin;	//付费券点数目
	private Double total_coin;	//全部券点数目
	
	
	/**
	 * 免费券点额度
	 * @return
	 */
	public Double getFree_coin() {
		return free_coin;
	}
	public void setFree_coin(Double free_coin) {
		this.free_coin = free_coin;
	}
	
	/**
	 * 付费券点额度
	 * @return
	 */
	public Double getPay_coin() {
		return pay_coin;
	}
	public void setPay_coin(Double pay_coin) {
		this.pay_coin = pay_coin;
	}
	
	/**
	 * 总券点额度
	 * @return
	 */
	public Double getTotal_coin() {
		return total_coin;
	}
	public void setTotal_coin(Double total_coin) {
		this.total_coin = total_coin;
	}
	
	

}
