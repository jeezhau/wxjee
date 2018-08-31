package com.jeekhan.wxjee.poicard.dto.resp;

import com.jeekhan.wxjee.common.CommonResp;

/**
 * 优惠券批价接口返回对象
 * @author jeekhan
 *
 */
public class GetPayPriceResp extends CommonResp{
	private String order_id;	//本次批价的订单号，用于下面的确认充值库存接口，仅对当前订单有效且仅可以使用一次，60s内可用于兑换库存。
	private Double price;		//本次需要支付的券点总额度
	private Double free_coin;	//本次需要支付的免费券点额度
	private Double pay_coin;	//本次需要支付的付费券点额度
	
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	
	/**
	 * 需要支付的券点总额度
	 * @return
	 */
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	/**
	 * 需要支付的免费券点额度
	 * @return
	 */
	public Double getFree_coin() {
		return free_coin;
	}
	public void setFree_coin(Double free_coin) {
		this.free_coin = free_coin;
	}
	
	/**
	 * 需要支付的付费券点额度
	 * @return
	 */
	public Double getPay_coin() {
		return pay_coin;
	}
	public void setPay_coin(Double pay_coin) {
		this.pay_coin = pay_coin;
	}

}
