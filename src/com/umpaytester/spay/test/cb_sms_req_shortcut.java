package com.umpaytester.spay.test;

import static org.junit.Assert.assertTrue;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import org.junit.Test;

import com.test.beans.SYTBean;
import com.test.beans.SignForSYT;
import com.test.tools.QueryTradeNo;
import com.test.utils.GetSms;
import com.test.utils.GetStatus;

public class cb_sms_req_shortcut {
	
	public static boolean flag=true;
	@Test
	 //	收银台下单接口
	 public  void Test_cb_sms_req_shortcut() throws UnsupportedEncodingException{
	
	for (int i = 0; i < 1; i++) {
		System.out.println("====================================================================   第"+i+"笔订单  ==================================================================");
		String order_id=new SimpleDateFormat("MMddhhmmssSSS").format(new Date())+ new Random(4).nextInt(4*100);
		 String 	sub_order_id1=order_id.substring(4)+"11";
		  String 	sub_order_id2=order_id.substring(4)+"12";
		  String goodsid1=order_id.substring(4) + "11";
		  String goodsid2=order_id.substring(4) + "12";
		 //创建bean对象，并对字段赋值
		 SYTBean tb = new SYTBean();	
		 tb.setService("cb_apply_pay_shortcut");
		 tb.setAmount("200.02");
		 tb.setCurrency("USD");
		 tb.setInterface_type("01");//收银台  02直连
		 tb.setPay_type("DEBITCARD"); 
	//	 CREDITCARD(信用卡)
		// DEBITCARD(借记卡)
		// WECHAT (微信支付)
		// ALIPAY(支付宝)
		// B2BBANK（B2B网银）
	//	 说明interface_type=02时，pay_type= WECHAT、ALIPAY、 B2BBANK
//		 tb.setGate_id("BOC");
		 tb.setGate_id("CITIC");
		 //准备订单货物数据
		    StringBuffer sub = new StringBuffer(""); // goodsData串
			sub.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><goods_data><sub_order>");
			sub.append("<sub_order_id>").append(sub_order_id1).append("</sub_order_id>");
			sub.append("<sub_order_type>1</sub_order_type>");
			sub.append("<sub_order_amt>100.02</sub_order_amt>");
			sub.append("<tx_code>121990</tx_code>");
			sub.append("<trans_note>网络购物（报关）</trans_note>");
			sub.append("<is_customs>Y</is_customs>");
			sub.append("<goods_list>");
			sub.append("<goods>");
			sub.append("<goods_id>").append(goodsid1).append("</goods_id>");
			sub.append("<goods_type>2</goods_type>");
			sub.append("<goods_quantity>2</goods_quantity>");
			sub.append("<goods_amt>50.02</goods_amt>");
			sub.append("</goods>");
			sub.append("<goods>");
			sub.append("<goods_id>").append(goodsid2).append("</goods_id>");
			sub.append("<goods_type>3</goods_type>");
			sub.append("<goods_quantity>3</goods_quantity>");
			sub.append("<goods_amt>50</goods_amt>");
			sub.append("</goods>");
			sub.append("</goods_list>");
			sub.append("</sub_order>");
			sub.append("<sub_order>");
			sub.append("<sub_order_id>").append(sub_order_id2).append("</sub_order_id>");
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
		 request.put("mer_id",SYTBean.getMer_id());
		 request.put("sign_type",SYTBean.getSign_type());
		 request.put("ret_url",SYTBean.getRet_url());
		 request.put("notify_url",SYTBean.getNotifyUrl());
		 request.put("res_format",SYTBean.getRes_format());
		 request.put("version",SYTBean.getVersion());
		 request.put("order_id",order_id);
		 request.put("mer_date",SYTBean.getMer_date());
		 request.put("amount",SYTBean.getAmount());
		 request.put("currency",SYTBean.getCurrency());
		 request.put("risk_expand",SYTBean.getRisk_expand());
		 request.put("goods_data",SYTBean.getGoods_data());
		 request.put("pay_type",SYTBean.getPay_type());
		 request.put("gate_id",SYTBean.getGate_id());
		 
//下单
		 String RetMsg=SignForSYT.sign(request, SYTBean.url);
		//  System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		 if(RetMsg.contains("&ret_code=0000&ret_msg=操作成功")){
			 System.out.println(String.format("[测试接口8"+this.getClass().getSimpleName()+"----调用接口----"+SYTBean.getService()+"--成功"));
		 }else{
			 System.out.println(String.format("[测试接口8"+this.getClass().getSimpleName()+"----调用接口----"+SYTBean.getService()+"--失败"));
			 break;

		 }
			String	 trade_no=RetMsg.substring(RetMsg.indexOf("trade_no="), RetMsg.lastIndexOf("&trade_state")).substring(9);
			
			System.out.println(trade_no);
		
			
			//==========================================
//			GetStatus test = new GetStatus();
//			String test1 = test.queryOrderStatus(trade_no);
//			System.out.println(test1);
	
			//==========================================

//		 System.out.println(trade_no);
//		 String OrderStatus = query.queryOrderStatus(trade_no);
//		 System.out.println("下单后订单状态为："+OrderStatus);
		 
		 


		//  System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		 request.clear();
		 tb.setService("cb_sms_req_shortcut");
		 //获取trade_no字段
//		 tb.setTrade_no(RetMsg.substring(RetMsg.indexOf("trade_no="), RetMsg.lastIndexOf("&trade_state")).substring(9));
		 
		 request.put("service",SYTBean.getService());
		 request.put("charset",SYTBean.getCharset());
		 request.put("mer_id",SYTBean.getMer_id());
		 request.put("version",SYTBean.getVersion());
//		 request.put("trade_no",SYTBean.getTrade_no());
		 request.put("trade_no",RetMsg.substring(RetMsg.indexOf("trade_no="), RetMsg.lastIndexOf("&trade_state")).substring(9));
		 request.put("media_id",SYTBean.getMedia_id());
		 request.put("media_type",SYTBean.getMedia_type());
		 request.put("card_id",SYTBean.getCard_id());
		 request.put("card_holder",SYTBean.getCard_holder());
		 request.put("identity_type",SYTBean.getIdentity_type());
		 request.put("identity_code",SYTBean.getIdentity_code());
//下发短信		 
		 RetMsg=SignForSYT.sign(request, SYTBean.url);
		//  System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		 if(RetMsg.contains("&ret_code=0000&ret_msg=操作成功")){
			 System.out.println(String.format("[测试接口8"+this.getClass().getSimpleName()+"----调用接口----"+SYTBean.getService()+"--成功"));
		 }else{
			 System.out.println(String.format("[测试接口8"+this.getClass().getSimpleName()+"----调用接口----"+SYTBean.getService()+"--失败"));
		 }
		//  System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//		 assertTrue(RetMsg.contains("&ret_code=0000&ret_msg=操作成功")); 
//		  OrderStatus = QueryTradeNo.queryOrderStatus(trade_no);
//		 System.out.println("下单后订单状态为："+OrderStatus);
		 
		 
		 
			
			GetStatus test = new GetStatus();
			String test1 = test.queryOrderStatus(trade_no);
			System.out.println(test1);
		//获取短信
		 String verify_code = GetSms.querySms(trade_no);
		 
		 tb.setService("cb_confirm_pay_shortcut");
		 request.clear();
		 request.put("service",SYTBean.getService());
		 request.put("charset",SYTBean.getCharset());
		 request.put("mer_id",SYTBean.getMer_id());
		 request.put("version",SYTBean.getVersion());
		 request.put("trade_no",trade_no);
		 request.put("media_id",SYTBean.getMedia_id());
		 request.put("media_type",SYTBean.getMedia_type());
		 request.put("card_id",SYTBean.getCard_id());
		 request.put("card_holder",SYTBean.getCard_holder());
		 request.put("identity_type",SYTBean.getIdentity_type());
		 request.put("identity_code",SYTBean.getIdentity_code());
		 request.put("verify_code",verify_code);

		 RetMsg=SignForSYT.sign(request, SYTBean.url);
//		 System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		 if(RetMsg.contains("&ret_code=0000&ret_msg=操作成功")){
			 System.out.println(String.format("[测试接口3"+this.getClass().getSimpleName()+"----调用接口----"+SYTBean.getService()+"--成功"));
			 flag=true;
		 }else{
			 System.out.println(String.format("[测试接口3"+this.getClass().getSimpleName()+"----调用接口----"+SYTBean.getService()+"--失败"));
			 flag=false;
			 
		 }
		 
		 
		 test1 = test.queryOrderStatus(trade_no);
			System.out.println("支付确认后的订单状态："+test1);
		 
		 //查询数据库的订单状态

//		 String OrderStatus = GetSms.querySms(trade_no);
//		  OrderStatus = QueryTradeNo.queryOrderStatus(trade_no);
		 
		 
//		 System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

//		 assertTrue(RetMsg.contains("&ret_code=0000&ret_msg=操作成功")); 

		 try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	        //准备退款数据
	        
	      //准备订单货物数据
		    StringBuffer refund_data = new StringBuffer(""); // goodsData串
		    refund_data.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		    refund_data.append("<refund_data>");
		    refund_data.append("<sub_order>");
		    refund_data.append("<sub_order_id>"+sub_order_id1+"</sub_order_id>");
		    refund_data.append("<sub_order_type>1</sub_order_type>");
		    refund_data.append("<sub_refund_amt>20</sub_refund_amt>");
		    refund_data.append("<goods_list>");
		    refund_data.append("<goods>");
		    refund_data.append("<goods_id>"+goodsid1+"</goods_id>");
		    refund_data.append("<goods_type>2</goods_type>");
		    refund_data.append("<goods_refund_amt>20</goods_refund_amt>");
//		    refund_data.append("<goods_id>"+goods_id2+"</goods_id>");
//		    refund_data.append("<goods_type>3</goods_type>");
//		    refund_data.append("<goods_refund_amt>5</goods_refund_amt>");
		    refund_data.append("</goods>");
		    refund_data.append("</goods_list>");
		    refund_data.append("</sub_order>");
//		    refund_data.append("<sub_order>");
//		    refund_data.append("<sub_order_id>"+sub_order_id2+"</sub_order_id>");
//		    refund_data.append("<sub_order_type>3</sub_order_type>");
//		    refund_data.append("<sub_order_amt>10</sub_order_amt>");
//		    refund_data.append("</sub_order>");
		    refund_data.append("</refund_data>");
			
	        
	        
	      //创建bean对象，并对字段赋值
	      
	        tb.setService("cb_api_refund");
	        tb.setRefund_amt("20");
	        tb.setOrg_amount("200.02");
	        tb.setCurrency("USD");
	        tb.setRefund_data(refund_data.toString());
	        request.clear();
	        request.put("service",SYTBean.getService());
	        request.put("charset",SYTBean.getCharset());
	        request.put("mer_id",SYTBean.getMer_id());
	        request.put("version",SYTBean.getVersion());
	        request.put("refund_no",SYTBean.getRefund_no());
	        request.put("order_id",order_id);
	        request.put("mer_date",SYTBean.getMer_date());
	        request.put("refund_amt",SYTBean.getRefund_amt());
	        request.put("org_amount",SYTBean.getOrg_amount());
	        request.put("currency",SYTBean.getCurrency());
	        request.put("refund_data",SYTBean.getRefund_data());
//	   	 System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	   	 RetMsg=SignForSYT.sign(request, tb.url);
	   	 test1 = test.queryOrderStatus(trade_no);
			System.out.println("退费后的订单状态："+test1);
//		 System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		 if(RetMsg.contains("&ret_msg=财务处理中")){
			 System.out.println(String.format("[测试接口1"+this.getClass().getSimpleName()+"----调用接口----"+SYTBean.getService()+"--成功"));
		 }else{
			 System.out.println(String.format("[测试接口1"+this.getClass().getSimpleName()+"----调用接口----"+SYTBean.getService()+"--失败"));
			 break;

		 }
		 assertTrue(RetMsg.contains("&ret_code=00060861&ret_msg=财务处理中")); 

		

	}
	}
	        
	        
	        
		

		
	}

