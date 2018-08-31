package com.jeekhan.wxjee.poicard.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.jeekhan.wxjee.validation.JField;

public class CardAdvancedInfo {
	private CardUseCondition use_condition; //JSON结构	使用门槛（条件）字段，若不填写使用条件则在券面拼写 ：无最低消费限制，全场通用，不限品类；并在使用说明显示： 可与其他优惠共享
	
	@JField(value="abstract")
	private CardAbstract card_abstract; //JSON结构	封面摘要结构体名称
	
	private TextImageList text_image_list; //JSON结构	图文列表，显示在详情内页 ，优惠券券开发者须至少传入 一组图文列表
	
	private BusinessServiceEnum[] business_service;	//商家服务类型： BIZ_SERVICE_DELIVER 外卖服务； BIZ_SERVICE_FREE_PARK 停车位； BIZ_SERVICE_WITH_PET 可带宠物； BIZ_SERVICE_FREE_WIFI 免费wifi， 可多选
	
	private TimeLimit time_limit;	//JSON结构	使用时段限制，包含以下字段
	
	private int consume_share_self_num;	//核销后送券的数量，可设置核销后送 本卡券 的数量，限制传入1张，与consume_share_card_list字段互斥
	private ConsumeShareCard[] consume_share_card_list;	//核销后赠送 其他卡券 的列表，与consume_share_self_num字段互斥
	private Boolean share_friends;	//是否支持分享给朋友使用，填写true优惠券才可被共享
    
	
	public CardUseCondition getUse_condition() {
		return use_condition;
	}
	public void setUse_condition(CardUseCondition use_condition) {
		this.use_condition = use_condition;
	}
	public CardAbstract getCard_abstract() {
		return card_abstract;
	}
	public void setCard_abstract(CardAbstract card_abstract) {
		this.card_abstract = card_abstract;
	}
	public TextImageList getText_image_list() {
		return text_image_list;
	}
	public void setText_image_list(TextImageList text_image_list) {
		this.text_image_list = text_image_list;
	}
	public BusinessServiceEnum[] getBusiness_service() {
		return business_service;
	}
	public void setBusiness_service(BusinessServiceEnum[] business_service) {
		this.business_service = business_service;
	}
	public TimeLimit getTime_limit() {
		return time_limit;
	}
	public void setTime_limit(TimeLimit time_limit) {
		this.time_limit = time_limit;
	}
	public int getConsume_share_self_num() {
		return consume_share_self_num;
	}
	public void setConsume_share_self_num(int consume_share_self_num) {
		this.consume_share_self_num = consume_share_self_num;
	}
	public ConsumeShareCard[] getConsume_share_card_list() {
		return consume_share_card_list;
	}
	public void setConsume_share_card_list(ConsumeShareCard[] consume_share_card_list) {
		this.consume_share_card_list = consume_share_card_list;
	}
	public Boolean getShare_friends() {
		return share_friends;
	}
	public void setShare_friends(Boolean share_friends) {
		this.share_friends = share_friends;
	}
	
}

class CardUseCondition{
	@Size(max=512)
	private String accept_category;	//string（512）	指定可用的商品类目，仅用于代金券类型 ，填入后将在券面拼写适用于xxx
	@Size(max=512)
	private String reject_category;	//string（ 512 ）	指定不可用的商品类目，仅用于代金券类型 ，填入后将在券面拼写不适用于xxxx
	@Min(1)
	private int least_cost;		//满减门槛字段，可用于兑换券和代金券 ，填入后将在全面拼写消费满xx元可用。
	@Size(max=512)
	private String object_use_for; //string（ 512 ）	购买xx可用类型门槛，仅用于兑换 ，填入后自动拼写购买xxx可用。
	
	private boolean can_use_with_other_discount=true; //不可以与其他类型共享门槛 ，填写false时系统将在使用须知里 拼写“不可与其他优惠共享”， 填写true时系统将在使用须知里 拼写“可与其他优惠共享”， 默认为true
	
	public String getAccept_category() {
		return accept_category;
	}
	public void setAccept_category(String accept_category) {
		this.accept_category = accept_category;
	}
	public String getReject_category() {
		return reject_category;
	}
	public void setReject_category(String reject_category) {
		this.reject_category = reject_category;
	}
	public int getLeast_cost() {
		return least_cost;
	}
	public void setLeast_cost(int least_cost) {
		this.least_cost = least_cost;
	}
	public String getObject_use_for() {
		return object_use_for;
	}
	public void setObject_use_for(String object_use_for) {
		this.object_use_for = object_use_for;
	}
	public boolean isCan_use_with_other_discount() {
		return can_use_with_other_discount;
	}
	public void setCan_use_with_other_discount(boolean can_use_with_other_discount) {
		this.can_use_with_other_discount = can_use_with_other_discount;
	}
}

class CardAbstract{
	@JField(value="abstract")
	@Size(max=24)
	private String card_abstract	; //封面摘要简介。
	
	@NotNull
	@JField(value="icon_url_list")
	@Size(max=1)
	private String[] icon_url_list;//string（128 ）	封面图片列表，仅支持填入一 个封面图片链接， 上传图片接口 上传获取图片获得链接，填写 非CDN链接会报错，并在此填入。 建议图片尺寸像素850*350
	
	public String getCard_abstract() {
		return card_abstract;
	}
	public void setCard_abstract(String card_abstract) {
		this.card_abstract = card_abstract;
	}
	public String[] getIcon_url_list() {
		return icon_url_list;
	}
	public void setIcon_url_list(String[] icon_url_list) {
		this.icon_url_list = icon_url_list;
	}
	
}

class TextImageList{
	@Size(max=128)
	private String image_url;	//string（128 ）	图片链接，必须调用 上传图片接口 上传图片获得链接，并在此填入， 否则报错
	
	@Size(max=512)
	private String text;	//string（512 ）	图文描述
	
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}

class TimeLimit{
	@NotNull
	@JField(value="type")
	@Size(max=24)
	private String type; 	//string（24 ）	限制类型枚举值：支持填入 MONDAY 周一 TUESDAY 周二 WEDNESDAY 周三 THURSDAY 周四 FRIDAY 周五 SATURDAY 周六 SUNDAY 周日 此处只控制显示， 不控制实际使用逻辑，不填默认不显示
	
	@Min(0)
	@Max(23)
	private int begin_hour;	//当前type类型下的起始时间（小时） ，如当前结构体内填写了MONDAY， 此处填写了10，则此处表示周一 10:00可用
	
	@Min(0)
	@Max(59)
	private int begin_minute;	//当前type类型下的起始时间（分钟） ，如当前结构体内填写了MONDAY， begin_hour填写10，此处填写了59， 则此处表示周一 10:59可用
	
	@Min(0)
	@Max(23)
	private int end_hour;	//当前type类型下的结束时间（小时） ，如当前结构体内填写了MONDAY， 此处填写了20， 则此处表示周一 10:00-20:00可用
	
	@Min(0)
	@Max(59)
	private int end_minute;	//当前type类型下的结束时间（分钟） ，如当前结构体内填写了MONDAY， begin_hour填写10，此处填写了59， 则此处表示周一 10:59-00:59可用
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getBegin_hour() {
		return begin_hour;
	}
	public void setBegin_hour(int begin_hour) {
		this.begin_hour = begin_hour;
	}
	public int getBegin_minute() {
		return begin_minute;
	}
	public void setBegin_minute(int begin_minute) {
		this.begin_minute = begin_minute;
	}
	public int getEnd_hour() {
		return end_hour;
	}
	public void setEnd_hour(int end_hour) {
		this.end_hour = end_hour;
	}
	public int getEnd_minute() {
		return end_minute;
	}
	public void setEnd_minute(int end_minute) {
		this.end_minute = end_minute;
	}

}

/**
 * 商家服务类型枚举类
 * @author jeekhan
 *
 */
enum BusinessServiceEnum{
	BIZ_SERVICE_DELIVER("BIZ_SERVICE_DELIVER","外卖服务"),
	BIZ_SERVICE_FREE_PARK("BIZ_SERVICE_FREE_PARK","停车位"),
	BIZ_SERVICE_WITH_PET("BIZ_SERVICE_WITH_PET","可带宠物"),
	BIZ_SERVICE_FREE_WIFI("BIZ_SERVICE_FREE_WIFI","免费wifi");
	
	private BusinessServiceEnum(String value,String desc) {
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
 * 卡券可用时间枚举类
 * @author jeekhan
 *
 */
enum TimeLimitTPEnum{
	MONDAY("MONDAY","周一"),
	TUESDAY("TUESDAY","周二"), 
	WEDNESDAY("WEDNESDAY","周三"), 
	THURSDAY("THURSDAY","周四"),
	FRIDAY("FRIDAY","周五"), 
	SATURDAY("SATURDAY","周六"), 
	SUNDAY("SUNDAY","周日"),
	HOLIDAY("HOLIDAY","节假日");
	
	private TimeLimitTPEnum(String value,String desc) {
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
 * 核销后赠送 其他卡券 
 * @author jeekhan
 *
 */
class ConsumeShareCard{
	private String  card_id;	//核销后赠送的其他卡券card_id，目前仅支持填入一个共享券card_id，此处必须填入共享券
	private int num;	//核销后赠送的该card_id数目，目前仅支持填1
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
}


