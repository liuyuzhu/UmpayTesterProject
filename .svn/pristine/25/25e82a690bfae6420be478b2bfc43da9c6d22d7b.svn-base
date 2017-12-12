package com.umpaytester.spayrest.java;

import java.util.ArrayList;
import java.util.List;

import com.umf.api.payments.Amount;
import com.umf.api.payments.BankCard;
import com.umf.api.payments.Order;
import com.umf.api.payments.Payer;
import com.umf.api.payments.PayerInfo;
import com.umf.api.payments.Payment;
import com.umf.api.payments.QrCodeScan;
import com.umf.api.payments.Refund;
import com.umf.api.payments.RiskInfo;
import com.umf.api.payments.SubOrder;
import com.umf.api.payments.WechatInApp;
import com.umf.api.payments.WechatInAppWeb;
import com.umf.api.payments.enums.CitizenIdType;
import com.umf.api.payments.enums.InterfaceType;
import com.umf.api.payments.enums.PaymentMethod;
import com.umf.base.ReqUMF;
import com.umf.base.rest.APIContext;
import com.umpaytester.spayrest.bean.SpayRestBean;
import com.umpaytester.utils.log.Logger;

/**
 *作者：刘玉柱
 *日期：2017年11月21日
 *时间：下午8:42:58
 *该类的功能:
**/

public class SpayRestRefundApi {
	static Logger log=Logger.getLogger(SpayRestRefundApi.class);  
	   public static  String result = ""	;

	public  static String refund (SpayRestBean bean) {
		log.info("等候支付成功，数据同步至离线库。。。");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 bean.setUrl(bean.refundUrl);

		log.info(bean.getPayment_method());

		APIContext apiContext = APIContext(bean);
		Refund refund = new Refund();
		 Order order = new Order();
		 order.setMerReferenceId(bean.getRefundNo());
		 Amount amount = new Amount();
		 amount.setTotal(bean.getAmount());
		 amount.setCurrency(bean.getCurrency());
		 order.setAmount(amount);
	       SubOrder suborder1 = new SubOrder();
           suborder1.setMerSubReferenceId(bean.getMer_sub_reference_id());
           suborder1.setTransCode(bean.getTrans_code());
//           suborder1.g
               Amount amount1 = new Amount();
               amount1.setTotal(bean.getAmount());
               amount1.setCurrency(bean.getCurrency());
           suborder1.setAmount(amount1);
           List<SubOrder> subOrders = new ArrayList<SubOrder>();   
           subOrders.add(suborder1);
           order.setSubOrders(subOrders);
		 
		 refund.setOrder(order);
		

		try {
			result="";
			result= ReqUMF.postRefund(apiContext, refund);	
			bean.refundQueryUrl = result.substring(result.indexOf("self\",\"method\":\"GET\",\"href\":\"")+29, result.lastIndexOf("\"}],\"refund\"")).replaceAll("179", "178");

			log.info(result);


		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info("退费失败"+e);
		}
		// TODO Auto-generated method stub
		
//		log.info(result);
		return result;
		
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
		apiContextBase.setUrl(bean.getUrl());
		apiContextBase.setRSACharset("GBK");
//		log.info("+++++");
		return apiContextBase;
		
		}
	
	public static  Payment Payment(SpayRestBean bean) {
//		BaseTest test = new BaseTest();
		
		Payment payment=new Payment();

		 Payer payer=new Payer();
//		 payer.setBusinessType(BusinessType.B2C);
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
				
				 payment.setRiskInfo(riskInfo);
				 log.info("信用卡支付确认");
		 }
		 else if(bean.getPayment_method().equals("DEBIT_CARD")) {
				 payer.setPaymentMethod(PaymentMethod.DEBIT_CARD);

				  payer.setBankCode(bean.getBank_code());

				     PayerInfo payerInfo=new PayerInfo();
				      BankCard bc = new BankCard();
				      bc.setValidDate(bean.getValid_date());
				      bc.setCvv2(bean.getCvv2());
				      bc.setPhone(bean.getPhone());
				      
				        bc.setCardNumber(bean.getNumber());
				        bc.setCitizenIdNumber(bean.getCitizen_id_number());
				        bc.setCitizenIdType(CitizenIdType.IDENTITY_CARD);
				        bc.setPayerName(bean.getPayer_name());
				        bc.setVerifyCode(bean.getVerify_code());

				      payerInfo.setBankCard(bc);
				     payer.setPayerInfo(payerInfo);
				     payment.setPayer(payer);
				 log.info("借记卡支付确认");

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
				 log.info("微信主扫支付确认");

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
				 log.info("支付宝主扫支付确认");

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
				 log.info("微信app支付确认");

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
				 log.info("微信公众号支付确认");

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
					log.info("收银台支付确认");
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
					 log.info("收银台H5支付确认");

		      }
		 }
		

	
		return payment;
		
	}
	


}


