package com.jeekhan.wxjee.poicard.dto.resp;

import com.jeekhan.wxjee.common.CommonResp;

/**
 * 查询券点充值订单接口返回对象
 * @author jeekhan
 *
 */
public class RechargeOrderStatResp extends CommonResp{
	private OrderInfo order_info;	//订单信息

	public OrderInfo getOrder_info() {
		return order_info;
	}

	public void setOrder_info(OrderInfo order_info) {
		this.order_info = order_info;
	}
	
	
}

class OrderInfo{
	private String order_id;	//订单号
	private String status;	//订单状态， ORDER_STATUS_WAITING 等待支付 ORDER_STATUS_SUCC 支付成功 ORDER_STATUS_FINANCE_SUCC 加代币成功 ORDER_STATUS_QUANTITY_SUCC 加库存成功 ORDER_STATUS_HAS_REFUND 已退币 ORDER_STATUS_REFUND_WAITING 等待退币确认 ORDER_STATUS_ROLLBACK 已回退,系统失败 ORDER_STATUS_HAS_RECEIPT 已开发票
	private Long create_time;	//订单创建时间
	private Long pay_finish_time;	//支付完成时间
	private String desc;	//支付描述，一般为微信支付充值
	private Double free_coin_count;	//本次充值免费券点数量，以元为单位
	private String pay_coin_count;	//本次充值的付费券点数量，以元为单位
	private Double refund_free_coin_count;	//回退的免费券点
	private Double refund_pay_coin_count;	//回退的付费券点
	private String openid;	//支付人的openid
	private String order_tpye;	//订单类型，ORDER_TYPE_WXPAY为充值
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Long create_time) {
		this.create_time = create_time;
	}
	public Long getPay_finish_time() {
		return pay_finish_time;
	}
	public void setPay_finish_time(Long pay_finish_time) {
		this.pay_finish_time = pay_finish_time;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Double getFree_coin_count() {
		return free_coin_count;
	}
	public void setFree_coin_count(Double free_coin_count) {
		this.free_coin_count = free_coin_count;
	}
	public String getPay_coin_count() {
		return pay_coin_count;
	}
	public void setPay_coin_count(String pay_coin_count) {
		this.pay_coin_count = pay_coin_count;
	}
	public Double getRefund_free_coin_count() {
		return refund_free_coin_count;
	}
	public void setRefund_free_coin_count(Double refund_free_coin_count) {
		this.refund_free_coin_count = refund_free_coin_count;
	}
	public Double getRefund_pay_coin_count() {
		return refund_pay_coin_count;
	}
	public void setRefund_pay_coin_count(Double refund_pay_coin_count) {
		this.refund_pay_coin_count = refund_pay_coin_count;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getOrder_tpye() {
		return order_tpye;
	}
	public void setOrder_tpye(String order_tpye) {
		this.order_tpye = order_tpye;
	}
	
	
}
