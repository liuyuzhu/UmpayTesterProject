package com.umpaytester.spay.bean;

/**
 *作者：刘玉柱
 *日期：2017年11月13日
 *时间：下午10:57:45
 *该类的功能:
**/
  public class  SpayBean {

	  public static   String url;	
	public static    String mer_id;	
	public static    String open_id;	
	public static    String app_id;	

	//非业务字段

	public static    String 	service;
	public static    String 	sign_type="RSA";		
	public static    String 	charset="UTF-8";		
	  public static    String 	version="4.0";
	  public static    String 	res_format="HTML";
	  public static    String 	sign;
	
	
	//业务字段
	  public static    String 	acquiringByUMP;
	  public static    String 	amount;
	  public static    String 	card_holder;
	  public static    String 	cny_amount;
	  public static    String 	currency;
	  public static    String 	customs_code;
	  public static    String 	customs_id;
	  public static    String 	ec_plat_id;
	  public static    String 	error_code;
	  public static    String 	exchange_rate;
	  public static    String 	expand;
	  public static    String 	expire_time;
	  public static    String 	freight;
	  public static    String 	gate_id;
	  public static    String 	goods_amount;
	  public static    String 	goods_data;
	  public static    String 	goods_inf="test";
	  public static    String 	identity_code;
	  public static    String 	identity_type;
	  public static    String 	interface_type;
	  public static    String 	media_id;
	  public static    String 	media_type="MOBILE";
	  public static    String 	mer_bank_list;
	  public static    String 	mer_cust_id; //pay_type为B2BBANK时必传，商户的每个用户在联动报备后联动分配的编号
	  public static    String 	mer_date;
	  public static    String 	mer_priv;
	  public static    String 	mobile_id;
	  public static    String 	notifyUrl;
	  public static    String 	order_date;
	  public static    String 	order_id;
	

	  public static    String 	card_id;
	  public static    String 	order_type;
	  public static    String 	org_amount;
	  public static    String 	pay_date;
	  public static    String 	pay_elements;
	  public static    String 	pay_seq;
	  public static    String 	pay_type;
	  public static    String 	refund_amount;
	  public static    String 	refund_data;
	  public static    String 	refund_no;
	  public static    String 	refund_amt;
	  public static    String 	ret_code;
	  public static    String 	ret_msg;
	  public static    String 	ret_url;
	  public static    String 	risk_expand="A0001:test#A0002:test";
	  public static    String 	settle_date;
	  public static    String 	settle_type;
	  
	  public static    String 	sub_order_type;
	  public static    String 	sub_order_id1;
	  public static    String 	sub_order_amt1;
	  public static    String 	sub_trans_code1;
	  public static    String 	is_customs1;
	  public static    String 	goods_id11;
	  public static    String 	goods_type11;
	  public static    String 	goods_quantity11;
	  public static    String 	goods_amt11;
	  public static    String 	goods_id12;
	  public static    String 	goods_type12;
	  public static    String 	goods_quantity12;
	  public static    String 	goods_amt12;
	  public static    String 	sub_order_id2;
	  public static    String 	sub_order_amt2;
	  public static    String 	sub_trans_code2;
	  public static    String 	sub_order_id3;
	  public static    String 	sub_order_amt3;
	  public static    String 	sub_trans_code3;
	  public static    String 	tax;
	  public static    String 	trade_no;
	  public static    String 	trade_state;
	  public static    String 	user_ip;
	  public static    String 	notify_url;
	  
	  public static    String 	usr_busi_agreement_id;
	
	public static String getOpen_id() {
		return open_id;
	}

	public static void setOpen_id(String open_id) {
		SpayBean.open_id = open_id;
	}

	public static String getApp_id() {
		return app_id;
	}

	public static void setApp_id(String app_id) {
		SpayBean.app_id = app_id;
	}

	public  String getNotify_url() {
		return notify_url;
	}

	public  void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMer_id() {
		return mer_id;
	}

	public void setMer_id(String mer_id) {
		this.mer_id = mer_id;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getRes_format() {
		return res_format;
	}

	public void setRes_format(String res_format) {
		this.res_format = res_format;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getAcquiringByUMP() {
		return acquiringByUMP;
	}

	public void setAcquiringByUMP(String acquiringByUMP) {
		this.acquiringByUMP = acquiringByUMP;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCard_holder() {
		return card_holder;
	}

	public void setCard_holder(String card_holder) {
		this.card_holder = card_holder;
	}

	public String getCny_amount() {
		return cny_amount;
	}

	public void setCny_amount(String cny_amount) {
		this.cny_amount = cny_amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCustoms_code() {
		return customs_code;
	}

	public void setCustoms_code(String customs_code) {
		this.customs_code = customs_code;
	}

	public String getCustoms_id() {
		return customs_id;
	}

	public void setCustoms_id(String customs_id) {
		this.customs_id = customs_id;
	}

	public String getEc_plat_id() {
		return ec_plat_id;
	}

	public void setEc_plat_id(String ec_plat_id) {
		this.ec_plat_id = ec_plat_id;
	}

	public String getError_code() {
		return error_code;
	}

	public void setError_code(String error_code) {
		this.error_code = error_code;
	}

	public String getExchange_rate() {
		return exchange_rate;
	}

	public void setExchange_rate(String exchange_rate) {
		this.exchange_rate = exchange_rate;
	}

	public String getExpand() {
		return expand;
	}

	public void setExpand(String expand) {
		this.expand = expand;
	}

	public String getExpire_time() {
		return expire_time;
	}

	public void setExpire_time(String expire_time) {
		this.expire_time = expire_time;
	}

	public String getFreight() {
		return freight;
	}

	public void setFreight(String freight) {
		this.freight = freight;
	}

	public String getGate_id() {
		return gate_id;
	}

	public void setGate_id(String gate_id) {
		this.gate_id = gate_id;
	}

	public String getGoods_amount() {
		return goods_amount;
	}

	public void setGoods_amount(String goods_amount) {
		this.goods_amount = goods_amount;
	}


	public String getIdentity_code() {
		return identity_code;
	}

	public void setIdentity_code(String identity_code) {
		this.identity_code = identity_code;
	}

	public String getIdentity_type() {
		return identity_type;
	}

	public void setIdentity_type(String identity_type) {
		this.identity_type = identity_type;
	}

	public String getInterface_type() {
		return interface_type;
	}

	public void setInterface_type(String interface_type) {
		this.interface_type = interface_type;
	}

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

	public String getMedia_type() {
		return media_type;
	}

	public void setMedia_type(String media_type) {
		this.media_type = media_type;
	}

	public String getMer_bank_list() {
		return mer_bank_list;
	}

	public void setMer_bank_list(String mer_bank_list) {
		this.mer_bank_list = mer_bank_list;
	}

	public String getMer_cust_id() {
		return mer_cust_id;
	}

	public void setMer_cust_id(String mer_cust_id) {
		this.mer_cust_id = mer_cust_id;
	}

	public String getMer_date() {
		return mer_date;
	}

	public void setMer_date(String mer_date) {
		this.mer_date = mer_date;
	}

	public String getMer_priv() {
		return mer_priv;
	}

	public void setMer_priv(String mer_priv) {
		this.mer_priv = mer_priv;
	}

	public String getMobile_id() {
		return mobile_id;
	}

	public void setMobile_id(String mobile_id) {
		this.mobile_id = mobile_id;
	}

	

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getCard_id() {
		return card_id;
	}

	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}

	public String getOrder_type() {
		return order_type;
	}

	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}

	public String getOrg_amount() {
		return org_amount;
	}

	public void setOrg_amount(String org_amount) {
		this.org_amount = org_amount;
	}

	public String getPay_date() {
		return pay_date;
	}

	public void setPay_date(String pay_date) {
		this.pay_date = pay_date;
	}

	public String getPay_elements() {
		return pay_elements;
	}

	public void setPay_elements(String pay_elements) {
		this.pay_elements = pay_elements;
	}

	public String getPay_seq() {
		return pay_seq;
	}

	public void setPay_seq(String pay_seq) {
		this.pay_seq = pay_seq;
	}

	public String getPay_type() {
		return pay_type;
	}

	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}

	public String getRefund_amount() {
		return refund_amount;
	}

	public void setRefund_amount(String refund_amount) {
		this.refund_amount = refund_amount;
	}

	public String getRefund_data() {
		return refund_data;
	}

	public void setRefund_data(String refund_data) {
		this.refund_data = refund_data;
	}

	public String getRefund_no() {
		return refund_no;
	}

	public void setRefund_no(String refund_no) {
		this.refund_no = refund_no;
	}

	public String getRefund_amt() {
		return refund_amt;
	}

	public void setRefund_amt(String refund_amt) {
		this.refund_amt = refund_amt;
	}

	public String getRet_code() {
		return ret_code;
	}

	public void setRet_code(String ret_code) {
		this.ret_code = ret_code;
	}

	public String getRet_msg() {
		return ret_msg;
	}

	public void setRet_msg(String ret_msg) {
		this.ret_msg = ret_msg;
	}

	public String getRet_url() {
		return ret_url;
	}

	public void setRet_url(String ret_url) {
		this.ret_url = ret_url;
	}

	public String getRisk_expand() {
		return risk_expand;
	}

	public void setRisk_expand(String risk_expand) {
		this.risk_expand = risk_expand;
	}

	public String getSettle_date() {
		return settle_date;
	}

	public void setSettle_date(String settle_date) {
		this.settle_date = settle_date;
	}

	public String getSettle_type() {
		return settle_type;
	}

	public void setSettle_type(String settle_type) {
		this.settle_type = settle_type;
	}

	public String getSub_order_type() {
		return sub_order_type;
	}

	public void setSub_order_type(String sub_order_type) {
		this.sub_order_type = sub_order_type;
	}

	public String getSub_order_id1() {
		return sub_order_id1;
	}

	public void setSub_order_id1(String sub_order_id1) {
		this.sub_order_id1 = sub_order_id1;
	}

	public String getSub_order_amt1() {
		return sub_order_amt1;
	}

	public void setSub_order_amt1(String sub_order_amt1) {
		this.sub_order_amt1 = sub_order_amt1;
	}

	public String getSub_trans_code1() {
		return sub_trans_code1;
	}

	public void setSub_trans_code1(String sub_trans_code1) {
		this.sub_trans_code1 = sub_trans_code1;
	}

	public String getIs_customs1() {
		return is_customs1;
	}

	public void setIs_customs1(String is_customs1) {
		this.is_customs1 = is_customs1;
	}

	public String getGoods_id11() {
		return goods_id11;
	}

	public void setGoods_id11(String goods_id11) {
		this.goods_id11 = goods_id11;
	}

	public String getGoods_type11() {
		return goods_type11;
	}

	public void setGoods_type11(String goods_type11) {
		this.goods_type11 = goods_type11;
	}

	public String getGoods_quantity11() {
		return goods_quantity11;
	}

	public void setGoods_quantity11(String goods_quantity11) {
		this.goods_quantity11 = goods_quantity11;
	}

	public String getGoods_amt11() {
		return goods_amt11;
	}

	public void setGoods_amt11(String goods_amt11) {
		this.goods_amt11 = goods_amt11;
	}

	public String getGoods_id12() {
		return goods_id12;
	}

	public void setGoods_id12(String goods_id12) {
		this.goods_id12 = goods_id12;
	}

	public String getGoods_type12() {
		return goods_type12;
	}

	public void setGoods_type12(String goods_type12) {
		this.goods_type12 = goods_type12;
	}

	public String getGoods_quantity12() {
		return goods_quantity12;
	}

	public void setGoods_quantity12(String goods_quantity12) {
		this.goods_quantity12 = goods_quantity12;
	}

	public String getGoods_amt12() {
		return goods_amt12;
	}

	public void setGoods_amt12(String goods_amt12) {
		this.goods_amt12 = goods_amt12;
	}

	public String getSub_order_id2() {
		return sub_order_id2;
	}

	public void setSub_order_id2(String sub_order_id2) {
		this.sub_order_id2 = sub_order_id2;
	}

	public String getSub_order_amt2() {
		return sub_order_amt2;
	}

	public void setSub_order_amt2(String sub_order_amt2) {
		this.sub_order_amt2 = sub_order_amt2;
	}

	public String getSub_trans_code2() {
		return sub_trans_code2;
	}

	public void setSub_trans_code2(String sub_trans_code2) {
		this.sub_trans_code2 = sub_trans_code2;
	}

	public String getSub_order_id3() {
		return sub_order_id3;
	}

	public void setSub_order_id3(String sub_order_id3) {
		this.sub_order_id3 = sub_order_id3;
	}

	public String getSub_order_amt3() {
		return sub_order_amt3;
	}

	public void setSub_order_amt3(String sub_order_amt3) {
		this.sub_order_amt3 = sub_order_amt3;
	}

	public String getSub_trans_code3() {
		return sub_trans_code3;
	}

	public void setSub_trans_code3(String sub_trans_code3) {
		this.sub_trans_code3 = sub_trans_code3;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getTrade_no() {
		return trade_no;
	}

	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}

	public String getTrade_state() {
		return trade_state;
	}

	public void setTrade_state(String trade_state) {
		this.trade_state = trade_state;
	}

	public String getUser_ip() {
		return user_ip;
	}

	public void setUser_ip(String user_ip) {
		this.user_ip = user_ip;
	}

	public String getUsr_busi_agreement_id() {
		return usr_busi_agreement_id;
	}

	public void setUsr_busi_agreement_id(String usr_busi_agreement_id) {
		this.usr_busi_agreement_id = usr_busi_agreement_id;
	}

	public void setGoods_data(String goods_data) {
		this.goods_data = goods_data;
	}
	public static String getGoods_inf() {
		return goods_inf;
	}

	public static void setGoods_inf(String goods_inf) {
		SpayBean.goods_inf = goods_inf;
	}
	

	public static String getGoods_data() {

		SpayBean sb = new SpayBean();
		 StringBuffer sub = new StringBuffer(""); // goodsData串
			sub.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><goods_data><sub_order>");
			sub.append("<sub_order_id>").append(sb.getSub_order_id1()).append("</sub_order_id>");
			sub.append("<sub_order_amt>").append(sb.getSub_order_amt1()).append("</sub_order_amt>");
			sub.append("<sub_trans_code>").append(sb.getSub_trans_code1()).append("</sub_trans_code>");
			sub.append("<is_customs>").append(sb.getIs_customs1()).append("</is_customs>");
			
			sub.append("<goods_list>");
			sub.append("<goods>");
			sub.append("<goods_id>").append(sb.getGoods_id11()).append("</goods_id>");
			sub.append("<goods_type>").append(sb.getGoods_type11()).append("</goods_type>");
			sub.append("<goods_quantity>").append(sb.getGoods_quantity11()).append("</goods_quantity>");
			sub.append("<goods_amt>").append(sb.getGoods_amt11()).append("</goods_amt>");
			sub.append("</goods>");
			sub.append("<goods>");
			sub.append("<goods_id>").append(sb.getGoods_id12()).append("</goods_id>");
			sub.append("<goods_type>").append(sb.getGoods_type12()).append("</goods_type>");
			sub.append("<goods_quantity>").append(sb.getGoods_quantity12()).append("</goods_quantity>");
			sub.append("<goods_amt>").append(sb.getGoods_amt12()).append("</goods_amt>");
			sub.append("</goods>");
			sub.append("</goods_list>");
			sub.append("</sub_order>");
			sub.append("<sub_order>");
			sub.append("<sub_order_id>").append(sb.getSub_order_id2()).append("</sub_order_id>");
			sub.append("<sub_order_amt>").append(sb.getSub_order_amt2()).append("</sub_order_amt>");
			sub.append("<sub_trans_code>").append(sb.getSub_trans_code2()).append("</sub_trans_code>");
			sub.append("</sub_order>");
		
			sub.append("</goods_data>");
			
		 
		return  sub.toString();
	}
	
	@Override
	public String toString() {
		return "SpayBean [url=" + url + ", mer_id=" + mer_id + ", service=" + service + ", sign_type="
				+ sign_type + ", charset=" + charset + ", version=" + version + ", res_format=" + res_format + ", sign="
				+ sign + ", acquiringByUMP=" + acquiringByUMP + ", amount=" + amount + ", card_holder=" + card_holder
				+ ", cny_amount=" + cny_amount + ", currency=" + currency + ", customs_code=" + customs_code
				+ ", customs_id=" + customs_id + ", ec_plat_id=" + ec_plat_id + ", error_code=" + error_code
				+ ", exchange_rate=" + exchange_rate + ", expand=" + expand + ", expire_time=" + expire_time
				+ ", freight=" + freight + ", gate_id=" + gate_id + ", goods_amount=" + goods_amount + ", goods_data="
				+ goods_data + ",  identity_code=" + identity_code + ", identity_type="
				+ identity_type + ", interface_type=" + interface_type + ", media_id=" + media_id + ", media_type="
				+ media_type + ", mer_bank_list=" + mer_bank_list + ", mer_cust_id=" + mer_cust_id + ", mer_date="
				+ mer_date + ", mer_priv=" + mer_priv + ", mobile_id=" + mobile_id + ", notifyUrl=" + notifyUrl
				+ ", order_date=" + order_date + ", order_id=" + order_id + ", card_id=" + card_id + ", order_type="
				+ order_type + ", org_amount=" + org_amount + ", pay_date=" + pay_date + ", pay_elements="
				+ pay_elements + ", pay_seq=" + pay_seq + ", pay_type=" + pay_type + ", refund_amount=" + refund_amount
				+ ", refund_data=" + refund_data + ", refund_no=" + refund_no + ", refund_amt=" + refund_amt
				+ ", ret_code=" + ret_code + ", ret_msg=" + ret_msg + ", ret_url=" + ret_url + ", risk_expand="
				+ risk_expand + ", settle_date=" + settle_date + ", settle_type=" + settle_type + ", sub_order_type="
				+ sub_order_type + ", sub_order_id1=" + sub_order_id1 + ", sub_order_amt1=" + sub_order_amt1
				+ ", sub_trans_code1=" + sub_trans_code1 + ", is_customs1=" + is_customs1 + ", goods_id11=" + goods_id11
				+ ", goods_type11=" + goods_type11 + ", goods_quantity11=" + goods_quantity11 + ", goods_amt11="
				+ goods_amt11 + ", goods_id12=" + goods_id12 + ", goods_type12=" + goods_type12 + ", goods_quantity12="
				+ goods_quantity12 + ", goods_amt12=" + goods_amt12 + ", sub_order_id2=" + sub_order_id2
				+ ", sub_order_amt2=" + sub_order_amt2 + ", sub_trans_code2=" + sub_trans_code2 + ", sub_order_id3="
				+ sub_order_id3 + ", sub_order_amt3=" + sub_order_amt3 + ", sub_trans_code3=" + sub_trans_code3
				+ ", tax=" + tax + ", trade_no=" + trade_no + ", trade_state=" + trade_state + ", user_ip=" + user_ip
				+ ", usr_busi_agreement_id=" + usr_busi_agreement_id + "]";
	}


	
	
	

	


}


