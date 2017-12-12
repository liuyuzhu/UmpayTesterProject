package com.umpaytester.spay.test;

import static org.junit.Assert.assertTrue;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

import com.test.beans.SYTBean;
import com.test.beans.Sign;
import com.test.beans.SignForSYT;

public class cb_apply_pay_shortcut {

	 @Test
	 //	收银台下单接口
	 public void Test_cb_apply_pay_shortcut() throws UnsupportedEncodingException{
	for (int i = 0; i < 1; i++) {
		SYTBean tb = new SYTBean();	
		String order_id=tb.order_id;
		 //创建bean对象，并对字段赋值
		 tb.setService("cb_apply_pay_shortcut");   
		 tb.setAmount("200.02");
		 tb.setCurrency("USD");
		 tb.setInterface_type("02");//收银台  02直连
//		 tb.setPay_type("ALIPAY"); 
		 tb.setPay_type("DEBITCARD"); 
	//	 CREDITCARD(信用卡)
		// DEBITCARD(借记卡)
		// WECHAT (微信支付)
		// ALIPAY(支付宝)
		 
		// B2BBANK（B2B网银）
	//	 说明interface_type=02时，pay_type= WECHAT、ALIPAY、 B2BBANK
		 tb.setGate_id("BOC");
		 //准备订单货物数据
		    StringBuffer sub = new StringBuffer(""); // goodsData串
			sub.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><goods_data><sub_order>");
			sub.append("<sub_order_id>").append(SYTBean.getSub_order_id1()).append("</sub_order_id>");
			sub.append("<sub_order_type>1</sub_order_type>");
			sub.append("<sub_order_amt>100.02</sub_order_amt>");
			sub.append("<tx_code>121990</tx_code>");
			sub.append("<trans_note>网络购物（报关）</trans_note>");
			sub.append("<is_customs>Y</is_customs>");
			sub.append("<goods_list>");
			sub.append("<goods>");
			sub.append("<goods_id>").append(order_id.substring(4) + "11").append("</goods_id>");
			sub.append("<goods_type>2</goods_type>");
			sub.append("<goods_quantity>2</goods_quantity>");
			sub.append("<goods_amt>50.02</goods_amt>");
			sub.append("</goods>");
			sub.append("<goods>");
			sub.append("<goods_id>").append(order_id.substring(4) + "12").append("</goods_id>");
			sub.append("<goods_type>3</goods_type>");
			sub.append("<goods_quantity>3</goods_quantity>");
			sub.append("<goods_amt>50</goods_amt>");
			sub.append("</goods>");
			sub.append("</goods_list>");
			sub.append("</sub_order>");
			sub.append("<sub_order>");
			sub.append("<sub_order_id>").append(SYTBean.sub_order_id2).append("</sub_order_id>");
			sub.append("<sub_order_type>3</sub_order_type>");
			sub.append("<sub_order_amt>100</sub_order_amt>");
			sub.append("<tx_code>223010</tx_code>");
			sub.append("<trans_note>留学及教育相关旅行（一年以下）酒店</trans_note>");
			sub.append("</sub_order>");
			sub.append("</goods_data>");
			tb.setGoods_data(sub.toString()); 
		 
		 
		 
		 Map<String ,Object>  request = new  TreeMap<String, Object>();
		 request.put("service",SYTBean.getService());
		 request.put("charset",SYTBean.getCharset());
		 request.put("mer_id",tb.mer_id);
		 request.put("sign_type",SYTBean.getSign_type());
		 request.put("ret_url",SYTBean.getRet_url());
		 request.put("notify_url",SYTBean.getNotifyUrl());
		 request.put("res_format",SYTBean.getRes_format());
		 request.put("version",SYTBean.getVersion());
		 request.put("order_id",tb.order_id);
		 request.put("mer_date",SYTBean.getMer_date());
		 request.put("amount",SYTBean.getAmount());
		 request.put("currency",SYTBean.getCurrency());
		 request.put("risk_expand",SYTBean.getRisk_expand());
		 request.put("goods_data",SYTBean.getGoods_data());
		 request.put("pay_type",SYTBean.getPay_type());
		 request.put("gate_id",SYTBean.getGate_id());
		 

		 String RetMsg=SignForSYT.sign(request, tb.url);
//		 System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		 if(RetMsg.contains("&ret_code=0000&ret_msg=操作成功")){
			 System.out.println(String.format("[测试接口2"+this.getClass().getSimpleName()+"----调用接口----"+SYTBean.getService()+"--成功"));
		 }else{
			 System.out.println(String.format("[测试接口2"+this.getClass().getSimpleName()+"----调用接口----"+SYTBean.getService()+"--失败"));
		 }
//		 System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//		 assertTrue(RetMsg.contains("&ret_code=0000&ret_msg=操作成功")); 

	}
 }
	
}

