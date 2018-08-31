package com.jeekhan.wxjee.poicard.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CardBaseInfo {
	@NotNull
	@Size(max=128)
	private String logo_url;  //必须，长string(128)，示例：http://mmbiz.qpic.cn/卡券的商户logo，建议像素为300*300。
	
	@NotNull
	private CodeTypeEnum code_type;  //必须，长string(16)，示例：CODE_TYPE_TEXT	码型： "CODE_TYPE_TEXT"文 本 ； "CODE_TYPE_BARCODE"一维码 "CODE_TYPE_QRCODE"二维码 "CODE_TYPE_ONLY_QRCODE",二维码无code显示； "CODE_TYPE_ONLY_BARCODE",一维码无code显示；CODE_TYPE_NONE， 不显示code和条形码类型
	
	@NotNull
	@Size(max=36)
	private String brand_name;	//必须，长string（36）	海底捞	商户名字,字数上限为12个汉字。
	
	@NotNull
	@Size(max=27)
	private String 	title;	//必须，长string（27）	双人套餐100元兑换券	卡券名，字数上限为9个汉字。(建议涵盖卡券属性、服务及金额)。
	
	@NotNull
	@Size(max=16)
	private String 	color;	//必须，长string（16）	Color010	券颜色。按色彩规范标注填写Color010-Color100。
	
	@NotNull
	@Size(max=48)
	private String 	notice;	//必须，长string（48）	请出示二维码	卡券使用提醒，字数上限为16个汉字。
	
	@NotNull
	@Size(max=3072)
	private String 	description;	//必须，长string （3072）	不可与其他优惠同享	卡券使用说明，字数上限为1024个汉字。
	
	@NotNull
	private CardSku sku;	//必须，长JSON结构	见上述示例。	商品信息。
	
	@NotNull
	private CardDateInfo date_info;	//必须，长JSON结构	见上述示例。	使用日期，有效期的信息。
	
	//以下为可选参数
	private Boolean	use_custom_code;	//是否自定义Code码 。填写true或false，默认为false。 通常自有优惠码系统的开发者选择 自定义Code码，并在卡券投放时带入 Code码，详情见 是否自定义Code码 。
	
	private GetCustiomCodeModeDepositEnum	get_custom_code_mode;	//string(32),GET_CUSTOM_CODE_MODE_DEPOSIT	填入 GET_CUSTOM_CODE_MODE_DEPOSIT 表示该卡券为预存code模式卡券， 须导入超过库存数目的自定义code后方可投放， 填入该字段后，quantity字段须为0,须导入code 后再增加库存
	
	private Boolean	bind_openid;	//是否指定用户领取，填写true或false 。默认为false。通常指定特殊用户群体 投放卡券或防止刷券时选择指定用户领取。
	
	@Size(max=24)
	private String	service_phone;	//string（24）,客服电话。
	
	private Integer[] location_id_list; 	//array,门店位置poiid。 调用 POI门店管理接 口 获取门店位置poiid。具备线下门店 的商户为必填。
	
	private Boolean	use_all_locations;	//设置本卡券支持全部门店，与location_id_list互斥
	
	@Size(max=18)
	private String	center_title;		//string（18）立即使用  卡券顶部居中的按钮，仅在卡券状 态正常(可以核销)时显示
	
	@Size(max=24)
	private String	center_sub_title;	//string（24）立即享受优惠	显示在入口下方的提示语 ，仅在卡券状态正常(可以核销)时显示。
	
	@Size(max=128)
	private String	center_url;			//string（128）	www.qq.com	顶部居中的url ，仅在卡券状态正常(可以核销)时显示。
	
	@Size(max=128)
	private String	center_app_brand_user_name;	//string（128）	gh_86a091e50ad4@app	卡券跳转的小程序的user_name，仅可跳转该 公众号绑定的小程序 。
	
	@Size(max=128)
	private String	center_app_brand_pass;	//string（128）	API/cardPage	卡券跳转的小程序的path
	
	@Size(max=15)
	private String	custom_url_name;		//string（15）	立即使用	自定义跳转外链的入口名字。
	
	@Size(max=128)
	private String	custom_url;				//string（128）	www.qq.com	自定义跳转的URL。
	
	@Size(max=18)
	private String	custom_url_sub_title;	//string（18）	更多惊喜	显示在入口右侧的提示语。
	
	@Size(max=128)
	private String	custom_app_brand_user_name;	//string（128）	gh_86a091e50ad4@app	卡券跳转的小程序的user_name，仅可跳转该 公众号绑定的小程序 。
	
	@Size(max=128)
	private String	custom_app_brand_pass;	//string（128）	API/cardPage	卡券跳转的小程序的path
	
	@Size(max=15)
	private String	promotion_url_name;		//string（15）	产品介绍	营销场景的自定义入口名称。
	
	@Size(max=128)
	private String	promotion_url;			//string（128）	www.qq.com	入口跳转外链的地址链接。
	
	@Size(max=18)
	private String	promotion_url_sub_title;	//string（18）	卖场大优惠。	显示在营销入口右侧的提示语。
	
	@Size(max=128)
	private String	promotion_app_brand_user_name;	//string（128）	gh_86a091e50ad4@app	卡券跳转的小程序的user_name，仅可跳转该 公众号绑定的小程序 。
	
	@Size(max=128)
	private String	promotion_app_brand_pass;		//string（128）	API/cardPage	卡券跳转的小程序的path
	
	@Min(1)
	private Integer	get_limi;		//每人可领券的数量限制,不填写默认为50。
	@Min(1)
	private Integer	use_limit;		//每人可核销的数量限制,不填写默认为50。
	private Boolean	can_share;	//卡券领取页面是否可分享。
	private Boolean	can_give_friend;	//卡券是否可转赠。
	private Boolean	need_push_on_view;	//填写true为用户点击进入会员卡时推送事件，默认为false。详情见 进入会员卡事件推送
	
	public String getLogo_url() {
		return logo_url;
	}
	public void setLogo_url(String logo_url) {
		this.logo_url = logo_url;
	}
	public CodeTypeEnum getCode_type() {
		return code_type;
	}
	public void setCode_type(CodeTypeEnum code_type) {
		this.code_type = code_type;
	}
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public CardSku getSku() {
		return sku;
	}
	public void setSku(CardSku sku) {
		this.sku = sku;
	}
	public CardDateInfo getDate_info() {
		return date_info;
	}
	public void setDate_info(CardDateInfo date_info) {
		this.date_info = date_info;
	}
	public Boolean isUse_custom_code() {
		return use_custom_code;
	}
	public void setUse_custom_code(Boolean use_custom_code) {
		this.use_custom_code = use_custom_code;
	}
	public GetCustiomCodeModeDepositEnum getGet_custom_code_mode() {
		return get_custom_code_mode;
	}
	public void setGet_custom_code_mode(GetCustiomCodeModeDepositEnum get_custom_code_mode) {
		this.get_custom_code_mode = get_custom_code_mode;
	}
	public Boolean isBind_openid() {
		return bind_openid;
	}
	public void setBind_openid(Boolean bind_openid) {
		this.bind_openid = bind_openid;
	}
	public String getService_phone() {
		return service_phone;
	}
	public void setService_phone(String service_phone) {
		this.service_phone = service_phone;
	}
	public Integer[] getLocation_id_list() {
		return location_id_list;
	}
	public void setLocation_id_list(Integer[] location_id_list) {
		this.location_id_list = location_id_list;
	}
	public Boolean isUse_all_locations() {
		return use_all_locations;
	}
	public void setUse_all_locations(Boolean use_all_locations) {
		this.use_all_locations = use_all_locations;
	}
	public String getCenter_title() {
		return center_title;
	}
	public void setCenter_title(String center_title) {
		this.center_title = center_title;
	}
	public String getCenter_sub_title() {
		return center_sub_title;
	}
	public void setCenter_sub_title(String center_sub_title) {
		this.center_sub_title = center_sub_title;
	}
	public String getCenter_url() {
		return center_url;
	}
	public void setCenter_url(String center_url) {
		this.center_url = center_url;
	}
	public String getCenter_app_brand_user_name() {
		return center_app_brand_user_name;
	}
	public void setCenter_app_brand_user_name(String center_app_brand_user_name) {
		this.center_app_brand_user_name = center_app_brand_user_name;
	}
	public String getCenter_app_brand_pass() {
		return center_app_brand_pass;
	}
	public void setCenter_app_brand_pass(String center_app_brand_pass) {
		this.center_app_brand_pass = center_app_brand_pass;
	}
	public String getCustom_url_name() {
		return custom_url_name;
	}
	public void setCustom_url_name(String custom_url_name) {
		this.custom_url_name = custom_url_name;
	}
	public String getCustom_url() {
		return custom_url;
	}
	public void setCustom_url(String custom_url) {
		this.custom_url = custom_url;
	}
	public String getCustom_url_sub_title() {
		return custom_url_sub_title;
	}
	public void setCustom_url_sub_title(String custom_url_sub_title) {
		this.custom_url_sub_title = custom_url_sub_title;
	}
	public String getCustom_app_brand_user_name() {
		return custom_app_brand_user_name;
	}
	public void setCustom_app_brand_user_name(String custom_app_brand_user_name) {
		this.custom_app_brand_user_name = custom_app_brand_user_name;
	}
	public String getCustom_app_brand_pass() {
		return custom_app_brand_pass;
	}
	public void setCustom_app_brand_pass(String custom_app_brand_pass) {
		this.custom_app_brand_pass = custom_app_brand_pass;
	}
	public String getPromotion_url_name() {
		return promotion_url_name;
	}
	public void setPromotion_url_name(String promotion_url_name) {
		this.promotion_url_name = promotion_url_name;
	}
	public String getPromotion_url() {
		return promotion_url;
	}
	public void setPromotion_url(String promotion_url) {
		this.promotion_url = promotion_url;
	}
	public String getPromotion_url_sub_title() {
		return promotion_url_sub_title;
	}
	public void setPromotion_url_sub_title(String promotion_url_sub_title) {
		this.promotion_url_sub_title = promotion_url_sub_title;
	}
	public String getPromotion_app_brand_user_name() {
		return promotion_app_brand_user_name;
	}
	public void setPromotion_app_brand_user_name(String promotion_app_brand_user_name) {
		this.promotion_app_brand_user_name = promotion_app_brand_user_name;
	}
	public String getPromotion_app_brand_pass() {
		return promotion_app_brand_pass;
	}
	public void setPromotion_app_brand_pass(String promotion_app_brand_pass) {
		this.promotion_app_brand_pass = promotion_app_brand_pass;
	}
	public Integer getGet_limi() {
		return get_limi;
	}
	public void setGet_limi(Integer get_limi) {
		this.get_limi = get_limi;
	}
	public Integer getUse_limit() {
		return use_limit;
	}
	public void setUse_limit(Integer use_limit) {
		this.use_limit = use_limit;
	}
	public Boolean isCan_share() {
		return can_share;
	}
	public void setCan_share(Boolean can_share) {
		this.can_share = can_share;
	}
	public Boolean isCan_give_friend() {
		return can_give_friend;
	}
	public void setCan_give_friend(Boolean can_give_friend) {
		this.can_give_friend = can_give_friend;
	}
	public Boolean isNeed_push_on_view() {
		return need_push_on_view;
	}
	public void setNeed_push_on_view(Boolean need_push_on_view) {
		this.need_push_on_view = need_push_on_view;
	}

	
}
/**
 * 卡券时间信息
 * @author jeekhan
 *
 */
 class CardDateInfo {
	@NotNull
	private ExpiryDateEnum 	type;	//必须，长string	DATE_TYPE_FIX _TIME_RANGE 表示固定日期区间，DATETYPE FIX_TERM 表示固定时长 （自领取后按天算。	使用时间的类型，旧文档采用的1和2依然生效。
	
	@Min(0)
	private Integer begin_timestamp; //type为DATE_TYPE_FIX_TIME_RANGE时专用，表示起用时间。从1970年1月1日00:00:00至起用时间的秒数，最终需转换为字符串形态传入。（东八区时间,UTC+8，单位为秒）
	@Min(0)
	private Integer end_timestamp;	//type为DATE_TYPE_FIX_TIME_RANGE时专用，表示结束时间 ， 建议设置为截止日期的23:59:59过期 。 （ 东八区时间,UTC+8，单位为秒 ）
	@Min(0)
	private Integer fixed_term;	//type为DATE_TYPE_FIX_TERM时专用，表示自领取后多少天内有效，不支持填写0。
	@Min(0)
	private Integer fixed_begin_term;	//type为DATE_TYPE_FIX_TERM时专用，表示自领取后多少天开始生效，领取后当天生效填写0。（单位为天）
	
	public ExpiryDateEnum getType() {
		return type;
	}
	public void setType(ExpiryDateEnum type) {
		this.type = type;
	}
	public Integer getBegin_timestamp() {
		return begin_timestamp;
	}
	public void setBegin_timestamp(Integer begin_timestamp) {
		this.begin_timestamp = begin_timestamp;
	}
	public Integer getEnd_timestamp() {
		return end_timestamp;
	}
	public void setEnd_timestamp(Integer end_timestamp) {
		this.end_timestamp = end_timestamp;
	}
	public Integer getFixed_term() {
		return fixed_term;
	}
	public void setFixed_term(Integer fixed_term) {
		this.fixed_term = fixed_term;
	}
	public Integer getFixed_begin_term() {
		return fixed_begin_term;
	}
	public void setFixed_begin_term(Integer fixed_begin_term) {
		this.fixed_begin_term = fixed_begin_term;
	}
	
}
 

/**
 * 卡券库存
 * @author jeekhan
 *
 */
class CardSku {
	@NotNull
	@Min(0)
	@Max(100000000)
	private Integer quantity;	//卡券库存的数量，上限为100000000

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}

/**
 * 卡券Code显示类型
 * @author jeekhan
 *
 */
enum CodeTypeEnum{
	 CODE_TYPE_TEXT("CODE_TYPE_TEXT", "文本 "),
	 CODE_TYPE_BARCODE("CODE_TYPE_BARCODE", "一维码 "),
	 CODE_TYPE_QRCODE("CODE_TYPE_QRCODE", "二维码"),
	 CODE_TYPE_ONLY_QRCODE("CODE_TYPE_ONLY_QRCODE", "仅显示二维码"),
	 CODE_TYPE_ONLY_BARCODE("CODE_TYPE_ONLY_BARCODE", "仅显示一维码"),
	 CODE_TYPE_NONE("CODE_TYPE_NONE", "不显示任何码型");
	
	private CodeTypeEnum(String value,String desc) {
		this.value = value;
		this.desc = desc;
	}
	
	private String value;
	private String desc;
	
	public String getDesc() {
		return this.desc;
	}
	
	public String getValue() {
		return this.value;
	}
}

/**
 * 卡券使用有效期类型
 * @author jeekhan
 *
 */
enum ExpiryDateEnum{
	DATE_TYPE_PERMANENT("DATE_TYPE_PERMANENT", "永久"),
	DATE_TYPE_FIX_TIME_RANGE("DATE_TYPE_FIX_TIME_RANGE", "固定时间段，指定开始和结束时间"),
	DATE_TYPE_FIX_TERM("DATE_TYPE_FIX_TERM", "固定天数，指定有效天数");
	
	private ExpiryDateEnum(String value,String desc) {
		this.value = value;
		this.desc = desc;
	}
	
	private String value;
	private String desc;
	
	public String getDesc() {
		return this.desc;
	}
	
	public String getValue() {
		return this.value;
	}
}

/**
 * 卡券预存code模式类型
 * @author jeekhan
 *
 */
enum GetCustiomCodeModeDepositEnum{
	GET_CUSTOM_CODE_MODE_DEPOSIT("GET_CUSTOM_CODE_MODE_DEPOSIT", "表示该卡券为预存code模式卡券");
	
	private GetCustiomCodeModeDepositEnum(String value,String desc) {
		this.value = value;
		this.desc = desc;
	}
	
	private String value;
	private String desc;
	
	public String getDesc() {
		return this.desc;
	}
	
	public String getValue() {
		return this.value;
	}
}
