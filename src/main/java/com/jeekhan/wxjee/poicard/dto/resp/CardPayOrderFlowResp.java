package com.jeekhan.wxjee.poicard.dto.resp;

import com.jeekhan.wxjee.common.CommonResp;

/**
 * 查询券点充值订单接口返回对象
 * @author jeekhan
 *
 */
public class CardPayOrderFlowResp extends CommonResp{
	private int total_num;	//符合条件的订单总数量
	private OrderInfo order_list;	//显示的订单详情列表，根据offset和count来显示
	public int getTotal_num() {
		return total_num;
	}
	public void setTotal_num(int total_num) {
		this.total_num = total_num;
	}
	public OrderInfo getOrder_list() {
		return order_list;
	}
	public void setOrder_list(OrderInfo order_list) {
		this.order_list = order_list;
	}

	
	
	
}

