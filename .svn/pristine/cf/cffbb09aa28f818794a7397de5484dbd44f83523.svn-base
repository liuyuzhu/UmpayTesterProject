package com.umpaytester.spay.java;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.umpaytester.spay.bean.SpayBean;
import com.umpaytester.spay.util.SignForSYT;
import com.umpaytester.utils.GetSms;
import com.umpaytester.utils.log.Logger;

/**
 *作者：刘玉柱
 *日期：2017年12月1日
 *时间：下午1:21:31
 *该类的功能:
**/

public class FusionPay {
	static String RetMsg="";
	static Logger log=Logger.getLogger(FusionPay.class); 
	static String trade_no="";
	static  Map<String ,Object>  request = new  TreeMap<String, Object>();

	 public static String order(SpayBean tb) throws UnsupportedEncodingException{
		
		
		String order_id=tb.getOrder_id();
		
		 tb.setService(tb.getService());
		 tb.setAmount(tb.getAmount());
		 tb.setCurrency(tb.getCurrency());
		 tb.setInterface_type(tb.getInterface_type());//收银台  02直连
		 tb.setPay_type(tb.getPay_type()); 
	//	 CREDITCARD(信用卡)
		// DEBITCARD(借记卡)
		// WECHAT (微信支付)
		// ALIPAY(支付宝)
		// B2BBANK（B2B网银）
	//	 说明interface_type=02时，pay_type= WECHAT、ALIPAY、 B2BBANK
		 tb.setGate_id(tb.getGate_id());
		 //准备订单货物数据
		    StringBuffer sub = new StringBuffer(""); // goodsData串
			sub.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><goods_data><sub_order>");
			sub.append("<sub_order_id>").append(tb.getSub_order_id1()).append("</sub_order_id>");
			sub.append("<sub_order_amt>"+tb.getSub_order_amt1()+"</sub_order_amt>");
			sub.append("<tx_code>"+tb.getSub_trans_code1()+"</tx_code>");
//			sub.append("<trans_note>网络购物（报关）</trans_note>");
			sub.append("<is_customs>"+tb.getIs_customs1()+"</is_customs>");
			sub.append("<goods_list>");
			sub.append("<goods>");
			sub.append("<goods_id>").append(tb.getGoods_id11()).append("</goods_id>");
			sub.append("<goods_type>"+tb.getGoods_type11()+"</goods_type>");
			sub.append("<goods_quantity>"+tb.getGoods_quantity11()+"</goods_quantity>");
			sub.append("<goods_amt>"+tb.getGoods_amt11()+"</goods_amt>");
			sub.append("</goods>");
			sub.append("<goods>");
			sub.append("<goods_id>").append(tb.getGoods_id12()).append("</goods_id>");
			sub.append("<goods_type>"+tb.getGoods_type12()+"</goods_type>");
			sub.append("<goods_quantity>"+tb.getGoods_quantity12()+"</goods_quantity>");
			sub.append("<goods_amt>"+tb.getGoods_amt12()+"</goods_amt>");
				sub.append("</goods>");
			sub.append("</goods_list>");
			sub.append("</sub_order>");
			sub.append("<sub_order>");
			sub.append("<sub_order_id>").append(tb.getSub_order_id2()).append("</sub_order_id>");
			sub.append("<sub_order_type>"+tb.getSub_order_type()+"</sub_order_type>");
			sub.append("<sub_order_amt>"+tb.getSub_order_amt2()+"</sub_order_amt>");
			sub.append("<tx_code>"+tb.getSub_trans_code2()+"</tx_code>");
//			sub.append("<trans_note>留学及教育相关旅行（一年以下）酒店</trans_note>");
			sub.append("</sub_order>");
			sub.append("</goods_data>");
			tb.setGoods_data(sub.toString()); 
		 
		 request.put("service",tb.getService());
		 request.put("charset",tb.getCharset());
		 request.put("mer_id",tb.getMer_id());
		 request.put("sign_type",tb.getSign_type());
		 request.put("ret_url",tb.getRet_url());
		 request.put("notify_url",tb.getNotify_url());
		 request.put("res_format",tb.getRes_format());
		 request.put("version",tb.getVersion());
		 request.put("order_id",tb.getOrder_id());
		 request.put("mer_date",tb.getMer_date());
		 request.put("amount",tb.getAmount());
		 request.put("currency",tb.getCurrency());
		 request.put("risk_expand",tb.getRisk_expand());
		 request.put("goods_data",tb.getGoods_data());
		 request.put("pay_type",tb.getPay_type());
//		 request.put("gate_id",tb.getGate_id());
		 request.put("open_id",tb.getOpen_id());
//		 request.put("app_id",tb.getApp_id());
		 request.put("goods_inf",tb.getGoods_inf());
		 request.put("card_holder",tb.getCard_holder());
		 request.put("identity_type",tb.getIdentity_type());
		 request.put("identity_code",tb.getIdentity_code());
		 request.put("mobile_id",tb.getMobile_id());
		 request.put("user_ip",tb.getUser_ip());
		 
//收银台下单接口
		  RetMsg=SignForSYT.sign(request, tb.url);
//		 System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		 if(RetMsg.contains("&ret_code=0000&ret_msg=操作成功")){
			log.info("[测试接口3"+"----调用接口----"+tb.getService()+"--成功");
			 trade_no=RetMsg.substring(RetMsg.indexOf("trade_no="), RetMsg.lastIndexOf("&trade_state")).substring(9);
			 log.info("trade_no"+trade_no);
		 }else{
			 log.info(String.format("[测试接口3"+"----调用接口----"+tb.getService()+"--失败"));
		 }
		return RetMsg;
		 
		 
		 
	 }
	 public static String varify(SpayBean tb) {
		 log.info("开始下发短信");
		 request.clear();
		 tb.setService("cb_sms_req_shortcut");	 
		 request.put("service",tb.getService());
		 request.put("charset",tb.getCharset());
		 request.put("mer_id",tb.getMer_id());
		 request.put("version",tb.getVersion());
		 request.put("trade_no",trade_no);
		 request.put("media_id",tb.getMedia_id());
		 request.put("media_type","MOBILE");
		 request.put("card_id",tb.getCard_id());
		 request.put("card_holder",tb.getCard_holder());
		 request.put("identity_type",tb.getIdentity_type());
		 request.put("identity_code",tb.getIdentity_code());
//下发短信	
		 RetMsg="";
		 RetMsg=SignForSYT.sign(request, tb.url);
		 if(RetMsg.contains("&ret_code=0000&ret_msg=操作成功")){
			 log.info(String.format("[测试接口3"+"----调用接口----"+tb.getService()+"--成功"));
		 }else{
			 log.info(String.format("[测试接口3"+"----调用接口----"+tb.getService()+"--失败"));
		 }
		 return RetMsg;
		 
	 }
	 
	 
	 
	 public static String pay(SpayBean tb) {
		 
		//获取短信
		 String verify_code = GetSms.querySms(trade_no);
		 
		 tb.setService("cb_confirm_pay_shortcut");
		 request.clear();
		 request.put("service",tb.getService());
		 request.put("charset",tb.getCharset());
		 request.put("mer_id",tb.getMer_id());
		 request.put("version",tb.getVersion());
		 request.put("trade_no",trade_no);
		 request.put("media_id",tb.getMedia_id());
		 request.put("media_type",tb.getMedia_type());
		 request.put("card_id",tb.getCard_id());
		 request.put("card_holder",tb.getCard_holder());
		 request.put("identity_type",tb.getIdentity_type());
		 request.put("identity_code",tb.getIdentity_code());
		 request.put("verify_code",verify_code);
		 RetMsg="";
		 RetMsg=SignForSYT.sign(request, tb.url);
		 if(RetMsg.contains("&ret_code=0000&ret_msg=操作成功")){
			 log.info(String.format("[测试接口3"+"----调用接口----"+tb.getService()+"--成功"));
		 }else{
			 log.info(String.format("[测试接口3"+"----调用接口----"+tb.getService()+"--失败"));
		 }
		return RetMsg;
	 }
	
}

