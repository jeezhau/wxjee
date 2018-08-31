package com.jeekhan.wxjee.poicard.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.jeekhan.wxjee.AccessToken;
import com.jeekhan.wxjee.common.CommonResp;
import com.jeekhan.wxjee.poicard.dto.CardAdvancedInfo;
import com.jeekhan.wxjee.poicard.dto.CardBaseInfo;
import com.jeekhan.wxjee.poicard.dto.CardTPEnum;
import com.jeekhan.wxjee.poicard.dto.req.CashCardRep;
import com.jeekhan.wxjee.poicard.dto.req.GiftCardRep;
import com.jeekhan.wxjee.poicard.dto.resp.ActivateCardPayResp;
import com.jeekhan.wxjee.poicard.dto.resp.CardCreateResp;
import com.jeekhan.wxjee.poicard.dto.resp.CardPayOrderFlowResp;
import com.jeekhan.wxjee.poicard.dto.resp.CoinsInfoResp;
import com.jeekhan.wxjee.poicard.dto.resp.GetPayPriceResp;
import com.jeekhan.wxjee.poicard.dto.resp.RechargeOrderPayResp;
import com.jeekhan.wxjee.poicard.dto.resp.RechargeOrderStatResp;
import com.jeekhan.wxjee.utils.HttpUtils;

/**
 * 朋友的券管理
 * “朋友共享的优惠券”（以下简称“朋友的券”），是基于微信优惠券推出的新功能，实现“一人领取多人共享”的快速社交传播和转化的效果。
 * 领取并与朋友共享此券，券会自动展示在领取人及其朋友的优惠券列表中，领取人及其朋友均可使用此券。商户可选择赠送配置：当朋友的券被使用后,根据商户配置的赠送量,使用者将立即获赠一张朋友的券,继续与朋友共享此券。
 * 1.创建朋友的券成功后，开发者可以通过接口为card_id配置库存，不同于普通券的是，不支持在创建的时候填入库存，朋友的券库存须使用券点兑换，券点分为免费券点和付费券点，免费券点由微信平台赠送产生，而付费券点由开发者充值产生。
 * 2.朋友的券不同于普通卡券，有很强的时效性和活动性，为了保证用户的券列表能常来常新，约定每个商户最多只能创建时长不超过三个月（90天)的卡券。
 * 3.若卡券过期时，card_id内尚有库存，会将库存折合券点退回商户的账户，周期为T+1（隔日退回）。
 * @author jeekhan
 *
 */
public class FriendsCardHandle {
	private static Logger log = LoggerFactory.getLogger(FriendsCardHandle.class);
	
	/**
	 * 创建朋友共享的代金券
	 * @param req
	 * @return
	 */
	public static CardCreateResp createCashCard(CashCardRep req) {
		CardCreateResp resp = new CardCreateResp();
		try {
			if(req == null) {
				resp.setErrcode(-2);
				resp.setErrmsg(" 参数错误，请求信息不可为空！");
				return resp;
			}
			CardBaseInfo base = req.getBase_info();
			CardAdvancedInfo advanced = req.getAdvanced_info();
			base.setCan_share(false);
			base.setCan_give_friend(false);
			advanced.setShare_friends(true);
			JSONObject card = new JSONObject();
			card.put("card_type", CardTPEnum.CASH.getValue());
			JSONObject member = (JSONObject) JSONObject.toJSON(req);
			card.put(CardTPEnum.CASH.getValue().toLowerCase(), member);
			resp = CardHandle.createCard(card);
		}catch(Exception e) {
			resp.setErrcode(-1);
			resp.setErrmsg("系统异常，异常信息：" + e.getMessage());
		}
		return resp;
	}
	
	/**
	 * 创建朋友共享的兑换券
	 * @param req
	 * @return
	 */
	public static CardCreateResp createGiftCard(GiftCardRep req) {
		CardCreateResp resp = new CardCreateResp();
		try {
			if(req == null) {
				resp.setErrcode(-2);
				resp.setErrmsg(" 参数错误，请求信息不可为空！");
				return resp;
			}
			CardBaseInfo base = req.getBase_info();
			CardAdvancedInfo advanced = req.getAdvanced_info();
			base.setCan_share(false);
			base.setCan_give_friend(false);
			advanced.setShare_friends(true);
			JSONObject card = new JSONObject();
			card.put("card_type", CardTPEnum.GIFT.getValue());
			JSONObject member = (JSONObject) JSONObject.toJSON(req);
			card.put(CardTPEnum.GIFT.getValue().toLowerCase(), member);
			resp = CardHandle.createCard(card);
		}catch(Exception e) {
			resp.setErrcode(-1);
			resp.setErrmsg("系统异常，异常信息：" + e.getMessage());
		}
		return resp;
	}

	/**
	 * 开通券点账户
	 * 用于开发者为当前appid开通券点账户并获得免费券点奖励
	 * 
	 * @return ActivateCardPayResp
	 * 
	 */
	public static ActivateCardPayResp activateCardPay() {
		ActivateCardPayResp resp = new ActivateCardPayResp();
		try {
			String token = AccessToken.getAccessToken();
			String url = "https://api.weixin.qq.com/card/pay/activate?access_token=" + token ;
			log.debug("开通券点账户（GET）：" + url);
			String ret = HttpUtils.doGetSSL(url);
			log.debug("开通券点账户返回：" + ret );
			//解析处理
			resp = CommonResp.parse(ActivateCardPayResp.class, ret);
			if(resp.getErrcode() == 0) {
				resp.setSuccess(true);
			}else {
				resp.setSuccess(false);
			}
		}catch(Exception e){
			resp.setErrcode(-1);
			resp.setErrmsg("系统异常，异常信息：" + e.getMessage());
		}
		return resp;
	}
	
	/**
	 * 查询券点余额接口
	 * 查询当前券点账户中的免费券点/付费券点数目以及总额。
	 * 
	 * @return ActivateCardPayResp
	 * 
	 */
	public static CoinsInfoResp getCoinsInfo() {
		CoinsInfoResp resp = new CoinsInfoResp();
		try {
			String token = AccessToken.getAccessToken();
			String url = "https://api.weixin.qq.com/card/pay/getcoinsinfo?access_token=" + token ;
			log.debug("查询券点余额（GET）：" + url);
			String ret = HttpUtils.doGetSSL(url);
			log.debug("查询券点余额返回：" + ret );
			//解析处理
			resp = CommonResp.parse(CoinsInfoResp.class, ret);
			if(resp.getErrcode() == 0) {
				resp.setSuccess(true);
			}else {
				resp.setSuccess(false);
			}
		}catch(Exception e){
			resp.setErrcode(-1);
			resp.setErrmsg("系统异常，异常信息：" + e.getMessage());
		}
		return resp;
	}
	
	
	/**
	 * 对优惠券批价
	 * 提前查询本次新增库存需要多少券点，返回的order_id须在60s内使用，否则确认兑换库存接口将会失效
	 * @param cardId	需要来配置库存的card_id
	 * @param quantity	本次需要兑换的库存数目
	 * @return
	 */
	public static GetPayPriceResp getPayPrice(String cardId,int quantity) {
		GetPayPriceResp resp = new GetPayPriceResp();
		try {
			String token = AccessToken.getAccessToken();
			String url = "https://api.weixin.qq.com/card/pay/getpayprice?access_token=" + token ;
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("card_id", cardId);
			jsonObj.put("quantity", quantity);
			log.debug("优惠券批价（POST）：" + url + "，参数：" + jsonObj);
			String ret = HttpUtils.doPostSSL(url, jsonObj);
			log.debug("优惠券批价返回：" + ret );
			//解析处理
			resp = CommonResp.parse(GetPayPriceResp.class, ret);
			if(resp.getErrcode() == 0) {
				resp.setSuccess(true);
			}else {
				resp.setSuccess(false);
			}
		}catch(Exception e){
			resp.setErrcode(-1);
			resp.setErrmsg("系统异常，异常信息：" + e.getMessage());
		}
		return resp;
	}

	/**
	 * 确认兑换库存
	 * 用于确认兑换库存，确认后券点兑换为库存，过程不可逆
	 * @param cardId	需要来配置库存的card_id
	 * @param orderId	使用批价得到的订单号，保证批价有效性
	 * @param quantity	本次需要兑换的库存数目
	 * @return
	 */
	public static CommonResp confirmCardPay(String cardId,String orderId,int quantity) {
		CommonResp resp = new CommonResp();
		try {
			String token = AccessToken.getAccessToken();
			String url = "https://api.weixin.qq.com/card/pay/confirm?access_token=" + token ;
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("card_id", cardId);
			jsonObj.put("order_id", orderId);
			jsonObj.put("quantity", quantity);
			log.debug("确认兑换库存（POST）：" + url + "，参数：" + jsonObj);
			String ret = HttpUtils.doPostSSL(url, jsonObj);
			log.debug("确认兑换库存返回：" + ret );
			//解析处理
			resp = CommonResp.parse(CommonResp.class, ret);
			if(resp.getErrcode() == 0) {
				resp.setSuccess(true);
			}else {
				resp.setSuccess(false);
			}
		}catch(Exception e){
			resp.setErrcode(-1);
			resp.setErrmsg("系统异常，异常信息：" + e.getMessage());
		}
		return resp;
	}
	
	/**
	 * 充值券点
	 * 可以通过此接口为券点账户充值券点，1元等于1点。开发者调用接口后可以获得一个微信支付的支付二维码链接， 开发者可以将链接转化为二维码扫码支付。
	 * @param coinCount	需要充值的券点数目，1点=1元
	 * @return
	 */
	public static RechargeOrderPayResp rechargeCardPay(int coinCount) {
		RechargeOrderPayResp resp = new RechargeOrderPayResp();
		try {
			String token = AccessToken.getAccessToken();
			String url = "https://api.weixin.qq.com/card/pay/recharge?access_token=" + token ;
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("coin_count", coinCount);
			log.debug("充值券点（POST）：" + url + "，参数：" + jsonObj);
			String ret = HttpUtils.doPostSSL(url, jsonObj);
			log.debug("充值券点返回：" + ret );
			//解析处理
			resp = CommonResp.parse(RechargeOrderPayResp.class, ret);
			if(resp.getErrcode() == 0) {
				resp.setSuccess(true);
			}else {
				resp.setSuccess(false);
			}
		}catch(Exception e){
			resp.setErrcode(-1);
			resp.setErrmsg("系统异常，异常信息：" + e.getMessage());
		}
		return resp;
	}
	
	/**
	 * 查询充值券点订单详情:查询充值订单的状态
	 * @param orderId	订单ID
	 * @return
	 */
	public static RechargeOrderStatResp queryCardPayOrder(String orderId) {
		RechargeOrderStatResp resp = new RechargeOrderStatResp();
		try {
			String token = AccessToken.getAccessToken();
			String url = "https://api.weixin.qq.com/card/pay/getorder?access_token=" + token ;
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("order_id", orderId);
			log.debug("查询充值券点订单详情（POST）：" + url + "，参数：" + jsonObj);
			String ret = HttpUtils.doPostSSL(url, jsonObj);
			log.debug("查询充值券点订单详情返回：" + ret );
			//解析处理
			resp = CommonResp.parse(RechargeOrderStatResp.class, ret);
			if(resp.getErrcode() == 0) {
				resp.setSuccess(true);
			}else {
				resp.setSuccess(false);
			}
		}catch(Exception e){
			resp.setErrcode(-1);
			resp.setErrmsg("系统异常，异常信息：" + e.getMessage());
		}
		return resp;
	}
	
	/**
	 * 查询券点流水详情
	 * @param orderId	订单ID
	 * @return
	 */
	public static CardPayOrderFlowResp searchOrders(Integer offset,Integer count,OrderTypeEnum orderType,
			Integer beginTime,Integer endTime,OrderStatusEnum norFilter) {
		CardPayOrderFlowResp resp = new CardPayOrderFlowResp();
		try {
			String token = AccessToken.getAccessToken();
			String url = "https://api.weixin.qq.com/card/pay/getorderlist?access_token=" + token ;
			JSONObject jsonObj = new JSONObject();
			if(offset != null ) {
				jsonObj.put("offset", offset);
			}
			if(count != null) {
				jsonObj.put("count", count);
			}
			if(beginTime != null) {
				jsonObj.put("begin_time", beginTime);
			}
			if(endTime != null) {
				jsonObj.put("end_time", endTime);
			}
			if(orderType != null) {
				jsonObj.put("order_type", orderType.getValue());
			}
			if(norFilter != null) {
				JSONObject nor = new JSONObject();
				nor.put("status", norFilter.getValue());
				jsonObj.put("nor_filter", nor);
			}
			JSONObject sort = new JSONObject();
			sort.put("sort_key", "SORT_BY_TIME");
			sort.put("sort_type", "SORT_DESC");
			jsonObj.put("sort_info", sort);
			log.debug(" 查询券点流水详情（POST）：" + url + "，参数：" + jsonObj);
			String ret = HttpUtils.doPostSSL(url, jsonObj);
			log.debug(" 查询券点流水详情返回：" + ret );
			//解析处理
			resp = CommonResp.parse(CardPayOrderFlowResp.class, ret);
			if(resp.getErrcode() == 0) {
				resp.setSuccess(true);
			}else {
				resp.setSuccess(false);
			}
		}catch(Exception e){
			resp.setErrcode(-1);
			resp.setErrmsg("系统异常，异常信息：" + e.getMessage());
		}
		return resp;
	}
	
}

enum OrderTypeEnum{
	ORDER_TYPE_SYS_ADD("ORDER_TYPE_SYS_ADD","平台赠送"), 
	ORDER_TYPE_WXPAY("ORDER_TYPE_WXPAY","充值 "),
	ORDER_TYPE_REFUND("ORDER_TYPE_REFUND","库存回退券点 "),
	ORDER_TYPE_REDUCE("ORDER_TYPE_REDUCE","券点兑换库存 "),
	ORDER_TYPE_SYS_REDUCE("ORDER_TYPE_SYS_REDUCE","平台扣减");
	
	private String value;
	private String desc;
	private OrderTypeEnum(String value,String desc) {
		this.value = value;
		this.desc = desc;
	}
	public String getValue() {
		return this.value;
	}
	public String getDesc() {
		return desc;
	}
}

enum OrderStatusEnum{
	ORDER_STATUS_WAITING("ORDER_STATUS_WAITING"," 等待支付"), 
	ORDER_STATUS_SUCC("ORDER_STATUS_SUCC","支付成功 "),
	ORDER_STATUS_FINANCE_SUCC("ORDER_STATUS_FINANCE_SUCC"," 加代币成功"),
	ORDER_STATUS_QUANTITY_SUCC("ORDER_STATUS_QUANTITY_SUCC","加库存成功 "),
	ORDER_STATUS_HAS_REFUND("ORDER_STATUS_HAS_REFUND","已退币"),
	ORDER_STATUS_REFUND_WAITING("ORDER_STATUS_REFUND_WAITING"," 等待退币确认"),
	ORDER_STATUS_ROLLBACK("ORDER_STATUS_ROLLBACK","已回退,系统失败"),
	ORDER_STATUS_HAS_RECEIPT("ORDER_STATUS_HAS_RECEIPT","已开发票");
	
	private String value;
	private String desc;
	private OrderStatusEnum(String value,String desc) {
		this.value = value;
		this.desc = desc;
	}
	public String getValue() {
		return this.value;
	}
	public String getDesc() {
		return desc;
	}
}
