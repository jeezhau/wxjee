package com.jeekhan.wxjee.poicard.dto.resp;

import com.jeekhan.wxjee.common.CommonResp;

/**
 * 券点充值接口返回对象
 * @author jeekhan
 *
 */
public class RechargeOrderPayResp extends CommonResp{
	private String order_id;	//本次支付的订单号，用于查询订单状态
	private String qrcode_url;	//支付二维码的的链接，开发者可以调用二维码生成的公开库转化为二维码显示在网页上，微信扫码支付
	private String qrcode_buffer;	//二维码的数据流，开发者可以使用写入一个文件的方法显示该二维码,JPG
	
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getQrcode_url() {
		return qrcode_url;
	}
	public void setQrcode_url(String qrcode_url) {
		this.qrcode_url = qrcode_url;
	}
	public String getQrcode_buffer() {
		return qrcode_buffer;
	}
	public void setQrcode_buffer(String qrcode_buffer) {
		this.qrcode_buffer = qrcode_buffer;
	}
	
	
}
