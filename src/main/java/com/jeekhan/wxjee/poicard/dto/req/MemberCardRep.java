package com.jeekhan.wxjee.poicard.dto.req;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.jeekhan.wxjee.poicard.dto.CardAdvancedInfo;
import com.jeekhan.wxjee.poicard.dto.CardBaseInfo;

/**
 * 会议卡请求对象
 * @author jeekhan
 *
 */
public class MemberCardRep {
	@Size(max=128)
	private String background_pic_url; //商家自定义会员卡背景图URL
	@NotNull
	private CardBaseInfo base_info;
	
	private CardAdvancedInfo advanced_info;
	@NotNull
	private boolean supply_bonus; //显示积分，填写true或false，如填写true，积分相关字段均为必 填 若设置为true则后续不可以被关闭。
	@Size(max=128)
	private String bonus_url;	//设置跳转外链查看积分详情。仅适用于积分无法通过激活接口同步的情况下使用该字段。
	@NotNull
	private boolean supply_balance; //是否支持储值，填写true或false。如填写true，储值相关字段均为必 填 若设置为true则后续不可以被关闭。该字段须开通储值功能后方可使用， 详情见： 获取特殊权限
	@Size(max=128)
	private String balance_url;	//设置跳转外链查看余额详情。仅适用于余额无法通过激活接口同步的情况下使用该字段。
	
    @Size(max=1024)
    private String prerogative; //会员卡特权说明,限制1024汉字。
    private boolean auto_activate; //设置为true时用户领取会员卡后系统自动将其激活，无需调用激活接口，详情见 自动激活 。
    private boolean wx_activate; 	//设置为true时会员卡支持一键开卡，不允许同时传入activate_url字段，否则设置wx_activate失效。填入该字段后仍需调用接口设置开卡项方可生效，详情见 一键开卡 。	
    private CustomField custom_field1; //自定义会员信息类目，会员卡激活后显示,包含name_type (name) 和url字段
    
    private String activate_url; //激活会员卡的url。
    private String activate_app_brand_user_name;	//激活会原卡url对应的小程序user_name，仅可跳转该公众号绑定的小程序
    private String activate_app_brand_pass;	//激活会原卡url对应的小程序path
    private CustomField custom_cell1; //自定义会员信息类目，会员卡激活后显示。
    private BonusRule bonus_rule;
    private int discount;	//折扣，该会员卡享受的折扣优惠,填9就是九折。
	public String getBackground_pic_url() {
		return background_pic_url;
	}
	public void setBackground_pic_url(String background_pic_url) {
		this.background_pic_url = background_pic_url;
	}
	public CardBaseInfo getBase_info() {
		return base_info;
	}
	public void setBase_info(CardBaseInfo base_info) {
		this.base_info = base_info;
	}
	public CardAdvancedInfo getAdvanced_info() {
		return advanced_info;
	}
	public void setAdvanced_info(CardAdvancedInfo advanced_info) {
		this.advanced_info = advanced_info;
	}
	public boolean isSupply_bonus() {
		return supply_bonus;
	}
	public void setSupply_bonus(boolean supply_bonus) {
		this.supply_bonus = supply_bonus;
	}
	public String getBonus_url() {
		return bonus_url;
	}
	public void setBonus_url(String bonus_url) {
		this.bonus_url = bonus_url;
	}
	public boolean isSupply_balance() {
		return supply_balance;
	}
	public void setSupply_balance(boolean supply_balance) {
		this.supply_balance = supply_balance;
	}
	public String getBalance_url() {
		return balance_url;
	}
	public void setBalance_url(String balance_url) {
		this.balance_url = balance_url;
	}
	public String getPrerogative() {
		return prerogative;
	}
	public void setPrerogative(String prerogative) {
		this.prerogative = prerogative;
	}
	public boolean isAuto_activate() {
		return auto_activate;
	}
	public void setAuto_activate(boolean auto_activate) {
		this.auto_activate = auto_activate;
	}
	public boolean isWx_activate() {
		return wx_activate;
	}
	public void setWx_activate(boolean wx_activate) {
		this.wx_activate = wx_activate;
	}
	public CustomField getCustom_field1() {
		return custom_field1;
	}
	public void setCustom_field1(CustomField custom_field1) {
		this.custom_field1 = custom_field1;
	}
	public String getActivate_url() {
		return activate_url;
	}
	public void setActivate_url(String activate_url) {
		this.activate_url = activate_url;
	}
	public String getActivate_app_brand_user_name() {
		return activate_app_brand_user_name;
	}
	public void setActivate_app_brand_user_name(String activate_app_brand_user_name) {
		this.activate_app_brand_user_name = activate_app_brand_user_name;
	}
	public String getActivate_app_brand_pass() {
		return activate_app_brand_pass;
	}
	public void setActivate_app_brand_pass(String activate_app_brand_pass) {
		this.activate_app_brand_pass = activate_app_brand_pass;
	}
	public CustomField getCustom_cell1() {
		return custom_cell1;
	}
	public void setCustom_cell1(CustomField custom_cell1) {
		this.custom_cell1 = custom_cell1;
	}
	public BonusRule getBonus_rule() {
		return bonus_rule;
	}
	public void setBonus_rule(BonusRule bonus_rule) {
		this.bonus_rule = bonus_rule;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}

    
}

class CustomField{
	 private String name_type;
	 private String name;
     private String url;
	public String getName_type() {
		return name_type;
	}
	public void setName_type(String name_type) {
		this.name_type = name_type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
     
     
}

class CustomCell{
	@NotNull
	@Size(max=15)
	private String name;	//入口名称。
	
	@NotNull
	@Size(max=6)
    private String tips; //入口右侧提示语，6个汉字内。
	
	@NotNull
	@Size(max=128)
    private String url;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	} 
	
	
}


class BonusRule{
    private int cost_money_unit; //消费金额。以分为单位。
    private int increase_bonus;	//对应增加的积分。
    private int max_increase_bonus;	//用户单次可获取的积分上限。
    private int init_increase_bonus;	//初始设置积分。
    private int cost_bonus_unit;	//每使用X积分。
    private int reduce_money;	//抵扣xx元，（这里以分为单位）
    private int least_money_to_use_bonus;	//抵扣条件，满xx元（这里以分为单位）可用。
    private int max_reduce_bonus;	//抵扣条件，单笔最多使用xx积分。
	public int getCost_money_unit() {
		return cost_money_unit;
	}
	public void setCost_money_unit(int cost_money_unit) {
		this.cost_money_unit = cost_money_unit;
	}
	public int getIncrease_bonus() {
		return increase_bonus;
	}
	public void setIncrease_bonus(int increase_bonus) {
		this.increase_bonus = increase_bonus;
	}
	public int getMax_increase_bonus() {
		return max_increase_bonus;
	}
	public void setMax_increase_bonus(int max_increase_bonus) {
		this.max_increase_bonus = max_increase_bonus;
	}
	public int getInit_increase_bonus() {
		return init_increase_bonus;
	}
	public void setInit_increase_bonus(int init_increase_bonus) {
		this.init_increase_bonus = init_increase_bonus;
	}
	public int getCost_bonus_unit() {
		return cost_bonus_unit;
	}
	public void setCost_bonus_unit(int cost_bonus_unit) {
		this.cost_bonus_unit = cost_bonus_unit;
	}
	public int getReduce_money() {
		return reduce_money;
	}
	public void setReduce_money(int reduce_money) {
		this.reduce_money = reduce_money;
	}
	public int getLeast_money_to_use_bonus() {
		return least_money_to_use_bonus;
	}
	public void setLeast_money_to_use_bonus(int least_money_to_use_bonus) {
		this.least_money_to_use_bonus = least_money_to_use_bonus;
	}
	public int getMax_reduce_bonus() {
		return max_reduce_bonus;
	}
	public void setMax_reduce_bonus(int max_reduce_bonus) {
		this.max_reduce_bonus = max_reduce_bonus;
	}
    
}
