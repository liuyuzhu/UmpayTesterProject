package com.umpaytester.spayrest.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.umf.api.payments.Amount;
import com.umf.api.payments.BankCard;
import com.umf.api.payments.Item;
import com.umf.api.payments.Order;
import com.umf.api.payments.Payer;
import com.umf.api.payments.PayerInfo;
import com.umf.api.payments.Payment;
import com.umf.api.payments.QrCodeScan;
import com.umf.api.payments.RiskInfo;
import com.umf.api.payments.SubOrder;
import com.umf.api.payments.WechatInApp;
import com.umf.api.payments.WechatInAppWeb;
import com.umf.api.payments.enums.BusinessType;
import com.umf.api.payments.enums.CitizenIdType;
import com.umf.api.payments.enums.InterfaceType;
import com.umf.api.payments.enums.ItemType;
import com.umf.api.payments.enums.PaymentMethod;
import com.umf.base.ReqUMF;
import com.umf.base.rest.APIContext;
import com.umpaytester.spayrest.bean.SpayRestBean;
import com.umpaytester.spayrest.servlet.SpayRestOrderApiServlet;
import com.umpaytester.spayrest.util.BaseTest;
import com.umpaytester.utils.PropsUtil;
import com.umpaytester.utils.log.Logger;

/**
 *作者：刘玉柱
 *日期：2017年11月21日
 *时间：下午8:42:58
 *该类的功能:
**/

public class SpayRestOrderApi {
	static Logger log=Logger.getLogger(SpayRestOrderApi.class);  

	public static String  order (SpayRestBean bean) {
		APIContext apiContext = APIContext(bean);
		Payment payment = Payment(bean);
		 
			
//--------------------组装数据，加密签名，发送数据，接收结果----------------------------------------------------------------//
			String responseString = null;
			Boolean flag=false;
			try {
//				System.out.println(payment);
				responseString = ReqUMF.post(apiContext, payment);
				log.info(responseString);
//--------------------验证返回结果，判断是否成功----------------------------------------------------------------//
				if(responseString.contains("\"ret_msg\":\"successful transaction\",\"ret_code\":\"0000\"")){
					flag=true;
					bean.orderResult=responseString;
					bean.varifyUrl= bean.orderResult.toString().substring(bean.orderResult.indexOf("sms_verify\",\"method\":\"GET\",\"href\":\"")+35, bean.orderResult.lastIndexOf("\"}]}")).replaceAll("179", "178");
//					String id = bean.orderResult.toString().substring(bean.orderResult.indexOf("\"id\":\"")+6, bean.orderResult.lastIndexOf("\",\"state"));
//					bean.setID(id);
//					log.info(bean.ID);
					log.info(bean.varifyUrl);
//					log.info(bean.payConfirmUrl);
//					log.info(bean.queryUrl);
//					log.info(bean.declareUrl);
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
//				System.out.println("访问接口"+payer.getInterfaceType()+"失败");
			}
		
		
		return responseString;
		
	}
	
public static APIContext APIContext(SpayRestBean bean)  {
		
	    APIContext apiContextBase = new APIContext();

		apiContextBase.setClientId(bean.getClientId());
		apiContextBase.setClientSecret(bean.getClientSecret());
		apiContextBase.setOauthUrl(bean.getOauth_url());
		
		apiContextBase.setToken(bean.token);
		apiContextBase.setCrtPath(bean.crtPath);
		apiContextBase.setP8Path(bean.p8Path);
		apiContextBase.setUMFp8Path(bean.UMFp8Path);
//		apiContextBase.setType("POST");
		apiContextBase.setUrl(bean.url);
		apiContextBase.setRSACharset("GBK");
		return apiContextBase;
		
		}
	
	public static  Payment Payment(SpayRestBean bean) {
//		BaseTest test = new BaseTest();
		
		Payment payment=new Payment();

		 Payer payer=new Payer();
		 payer.setBusinessType(BusinessType.B2C);
		 log.info(bean.getPayment_method());
		 if(bean.getPayment_method().equals("CREDIT_CARD")) {
		      payer.setPaymentMethod(PaymentMethod.CREDIT_CARD);
		      payer.setInterfaceType(InterfaceType.SERVER_TO_SERVER);
		      payer.setBankCode(bean.getBank_code());
		       PayerInfo payerInfo=new PayerInfo();
		        BankCard bc = new BankCard();
		        bc.setCardNumber(bean.getNumber());
		        bc.setCitizenIdNumber(bean.getCitizen_id_number());
		        bc.setCitizenIdType(CitizenIdType.IDENTITY_CARD);
		        bc.setPayerName(bean.getPayer_name());
		        bc.setValidDate(bean.getValid_date());
		        bc.setCvv2(bean.getCvv2());
		        bc.setPhone(bean.getPhone());
		        payerInfo.setBankCard(bc);
		       payer.setPayerInfo(payerInfo);
		       
		      
		       payment.setPayer(payer);
		      RiskInfo riskInfo = new RiskInfo();
				 riskInfo.setB0002("02");
				 riskInfo.setD0008("1");
				 riskInfo.setD0009("0");
				 riskInfo.setD0010("Y");
				
				 payment.setRiskInfo(riskInfo);
				 log.info("信用卡支付");
		 }
		 else if(bean.getPayment_method().equals("DEBIT_CARD")) {
		      payer.setPaymentMethod(PaymentMethod.DEBIT_CARD);
		      payer.setInterfaceType(InterfaceType.SERVER_TO_SERVER);
		      payer.setBankCode(bean.getBank_code());
		       PayerInfo payerInfo=new PayerInfo();
		        BankCard bc = new BankCard();
		        bc.setPhone(bean.getPhone());
		        bc.setCardNumber(bean.getNumber());
		        bc.setCitizenIdNumber(bean.getCitizen_id_number());
		        bc.setCitizenIdType(CitizenIdType.IDENTITY_CARD);
		        bc.setPayerName(bean.getPayer_name());
		        payerInfo.setBankCard(bc);
		       payer.setPayerInfo(payerInfo);
		    payment.setPayer(payer);
		    
		      RiskInfo riskInfo = new RiskInfo();
				 riskInfo.setB0002("02");
				 riskInfo.setD0008("1");
				 riskInfo.setD0009("0");
				 riskInfo.setD0010("Y");
				
				payment.setRiskInfo(riskInfo);
				 log.info("借记卡支付");

		 }
		 else if(bean.getPayment_method().equals("WECHAT_SCAN")) {
		      payer.setPaymentMethod(PaymentMethod.WECHAT_SCAN);		  
		      payer.setInterfaceType(InterfaceType.SERVER_TO_SERVER);
		      PayerInfo payerInfo=new PayerInfo();
		         payerInfo.setPayerName(bean.getPayer_name());
		         
		         payerInfo.setPhone(bean.getPhone());
		         QrCodeScan qcs = new QrCodeScan();
		         
		         qcs.setCitizenIdType(CitizenIdType.IDENTITY_CARD);
		         qcs.setCitizenIdNumber(bean.getCitizen_id_number());
		         payerInfo.setQrCodeScan(qcs);
		         payer.setPayerInfo(payerInfo);
		      payment.setPayer(payer);
		      RiskInfo riskInfo = new RiskInfo();
				 riskInfo.setB0002("02");
				
				payment.setRiskInfo(riskInfo);
				 log.info("微信主扫");

		 }	
		 else if(bean.getPayment_method().equals("ALIPAY_SCAN")) {
		      payer.setPaymentMethod(PaymentMethod.ALIPAY_SCAN);
		      payer.setInterfaceType(InterfaceType.SERVER_TO_SERVER);
		      PayerInfo payerInfo=new PayerInfo();
		         payerInfo.setPayerName(bean.getPayer_name());
		         
		         payerInfo.setPhone(bean.getPhone());
		         QrCodeScan qcs = new QrCodeScan();
		         
		         qcs.setCitizenIdType(CitizenIdType.IDENTITY_CARD);
		         qcs.setCitizenIdNumber(bean.getCitizen_id_number());
		         payerInfo.setQrCodeScan(qcs);
		         payer.setPayerInfo(payerInfo);
		      payment.setPayer(payer);
		      RiskInfo riskInfo = new RiskInfo();
				 riskInfo.setB0002("02");
				
				payment.setRiskInfo(riskInfo);
				 log.info("支付宝主扫");

		 }	
		 else if(bean.getPayment_method().equals("WECHAT_IN_APP")) {
		      payer.setPaymentMethod(PaymentMethod.WECHAT_IN_APP);
		      payer.setInterfaceType(InterfaceType.SERVER_TO_SERVER);
		      PayerInfo payerInfo=new PayerInfo();
		         payerInfo.setPayerName(bean.getPayer_name());
		         payerInfo.setPhone(bean.getPhone());
		         WechatInApp wechat1 = new WechatInApp();
		         wechat1.setCitizenIdType(CitizenIdType.IDENTITY_CARD);
		         wechat1.setCitizenIdNumber(bean.getCitizen_id_number());
		         
		         payerInfo.setWechatInApp(wechat1);
		         payer.setPayerInfo(payerInfo);
		        
		         
		      payment.setPayer(payer);
		      RiskInfo riskInfo = new RiskInfo();
				 riskInfo.setB0002("02");
				payment.setRiskInfo(riskInfo);
				 log.info("微信app支付");

		 }	
		 else if(bean.getPayment_method().equals("WECHAT_WEB")) {
		      payer.setPaymentMethod(PaymentMethod.WECHAT_WEB);
		      payer.setInterfaceType(InterfaceType.SERVER_TO_SERVER);
		      PayerInfo payerInfo=new PayerInfo();
		         payerInfo.setPayerName(bean.getPayer_name());
		         payerInfo.setPhone(bean.getPhone());
		         WechatInAppWeb wechat = new WechatInAppWeb();
		         wechat.setOpenId(bean.getOpen_id());
		         wechat.setCitizenIdType(CitizenIdType.IDENTITY_CARD);
		         wechat.setCitizenIdNumber(bean.getCitizen_id_number());
		         payerInfo.setWechatInAppWeb(wechat);
		         payer.setPayerInfo(payerInfo);
		      payment.setPayer(payer);
		      RiskInfo riskInfo = new RiskInfo();
				 riskInfo.setB0002("02");
				payment.setRiskInfo(riskInfo);
				 log.info("微信公众号");

		 }
		 else if(bean.getPayment_method().equals("NOT_APPLICABLE")) {
			 log.info("进入收银台下单业务模块");
			 
			 
		      if(bean.getInterface_type().equals("SERVER_TO_WEB")) {
		    	  
		    	  payer.setBankCode(bean.getBank_code());
			       PayerInfo payerInfo=new PayerInfo();
			       payer.setPayerInfo(payerInfo);
			    payment.setPayer(payer);
			      RiskInfo riskInfo = new RiskInfo();
					 riskInfo.setB0002("02");
					
					payment.setRiskInfo(riskInfo);
					log.info("收银台支付");
		      }else {
		    	  payer.setBankCode(bean.getBank_code());
			       PayerInfo payerInfo=new PayerInfo();
			       payerInfo.setPayerName(bean.getPayer_name());
			       
			    //   payerInfo.setPhone("15210909812");
			       QrCodeScan qcs = new QrCodeScan();
			       qcs.setQrCodeUrl(bean.getQr_code_url());
			       qcs.setCitizenIdType(CitizenIdType.IDENTITY_CARD);
			       qcs.setCitizenIdNumber(bean.getCitizen_id_number());
			       payerInfo.setQrCodeScan(qcs);
			       payer.setPayerInfo(payerInfo);
			    payment.setPayer(payer);
			      RiskInfo riskInfo = new RiskInfo();
					 riskInfo.setB0002("02");
					
					payment.setRiskInfo(riskInfo);
					 log.info("收银台H5支付");

		      }
		 }
		

		
		 Order order = new Order();
         
   	   order.setMerReferenceId(bean.getMer_reference_id());
          order.setMerDate(bean.getMer_date());

             Amount amount = new Amount();
             amount.setTotal(bean.getAmount());
             amount.setCurrency(bean.getCurrency());
         order.setAmount(amount);
         order.setOrderSummary(bean.getOrder_summary());
         order.setExpireTime(bean.getExpire_time());
         
                 SubOrder suborder1 = new SubOrder();
                 suborder1.setMerSubReferenceId(bean.getMer_sub_reference_id());
                 suborder1.setTransCode(bean.getTrans_code());
	                       Amount amount1 = new Amount();
                           amount1.setTotal(bean.getSubamount1());
                           amount1.setCurrency(bean.getCurrency());
                 suborder1.setAmount(amount1);
                 //---------------------------------------------------------
                 suborder1.setInvoiceId(bean.getInvoice_id());
   
//                   
//                 SubOrder suborder2 = new SubOrder();
//                 suborder2.setMerSubReferenceId(sub_order_id2);
//                 suborder2.setTransCode("01121990");
//                           Amount amount2 = new Amount();
//                           amount2.setTotal("100.02");
//                           amount2.setCurrency("USD");
//                  suborder2.setAmount(amount2);
//                  
//                  //--------------------------------------------
//                  suborder2.setIsCustoms("true");
//                            Item item = new Item();
//                            item.setMerItemId(goods_id1);
//                            item.setType(ItemType.FOOD);
//                            item.setName("banana");
//                            item.setItemQuantity("2");
//                            item.setDescription("banana");
//                            Amount amount21 = new Amount();
//                            amount21.setTotal("50.02");
//                            amount21.setCurrency("USD");
//                            item.setAmount(amount21);
//                          
//                            Item item2 = new Item();
//                            item2.setMerItemId(goods_id2);
//                            item2.setType(ItemType.ELECTRONIC);
//                            item2.setName("yifu");
//                            item2.setItemQuantity("3");
//                            item2.setDescription("yifu");
//                            
//                             Amount amount22 = new Amount();
//                              
//                             amount22.setTotal("50.00");
//                             amount22.setCurrency("USD");
//                             item2.setAmount(amount22);
//                          
//                             List<Item> items = new ArrayList<Item>();
//                             items.add(item);
//                             items.add(item2);
//                   suborder2.setItems(items);
//                    

                   List<SubOrder> subOrders = new ArrayList<SubOrder>();   
//                   subOrders.add(suborder2);
                   subOrders.add(suborder1);
           order.setSubOrders(subOrders);
 
           payment.setNotifyUrl(bean.getNotify_url());
           payment.setOrder(order);
           payment.setPayElements("");
           payment.setRetUrl(bean.getRet_url());
		return payment;
		
	}
	


}

