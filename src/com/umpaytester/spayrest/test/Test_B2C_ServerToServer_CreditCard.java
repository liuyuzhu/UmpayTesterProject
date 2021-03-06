package com.umpaytester.spayrest.test;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import com.umf.api.payments.BankCard;
import com.umf.api.payments.Payer;
import com.umf.api.payments.PayerInfo;
import com.umf.api.payments.Payment;
import com.umf.api.payments.RiskInfo;
import com.umf.api.payments.enums.BusinessType;
import com.umf.api.payments.enums.CitizenIdType;
import com.umf.api.payments.enums.InterfaceType;
import com.umf.api.payments.enums.PaymentMethod;
import com.umf.base.ReqUMF;
import com.umf.base.rest.APIContext;
import com.umpaytester.spayrest.util.BaseTest;

	public class Test_B2C_ServerToServer_CreditCard {
	
		public static void main(String[] args) {
			Test_B2C_ServerToServer_CreditCard test = new Test_B2C_ServerToServer_CreditCard();
			
				test.test();
			
		}
	
 
	@Test  
	public Boolean test() {   //接口命名以  BusinessType_InterfaceType_PaymentMethod 命名
		
		
		
//--------------------创建BaseTest对象，获取基础数据-------------------------------------------------------------------//
		BaseTest test = new BaseTest();
//		test.init();
	    APIContext apiContext = test.APIContext();
	    Payment payment=test.Payment();
	    
//--------------------创建Payer对象，配置具体的接口参数、风控字段、以及BaseTest中不存在的参数-----------------------------------------//
	    Payer payer=new Payer();
	    payer.setPaymentMethod(PaymentMethod.CREDIT_CARD);
	    payer.setBusinessType(BusinessType.B2C);
	    payer.setInterfaceType(InterfaceType.SERVER_TO_SERVER);
	    payer.setBankCode("BOC");
	       PayerInfo payerInfo=new PayerInfo();
	        BankCard bc = new BankCard();
	        bc.setCardNumber("");
	        bc.setCitizenIdNumber("");
	        bc.setCitizenIdType(CitizenIdType.IDENTITY_CARD);
	        bc.setPayerName("");
	        bc.setValidDate("");
	        bc.setCvv2("");
	        bc.setPhone("18701588007");
	        payerInfo.setBankCard(bc);
	       payer.setPayerInfo(payerInfo);
	       
	      
	    payment.setPayer(payer);
	      RiskInfo riskInfo = new RiskInfo();
			 riskInfo.setB0002("02");
			
			payment.setRiskInfo(riskInfo);
			
//--------------------组装数据，加密签名，发送数据，接收结果----------------------------------------------------------------//
			String responseString = null;
			Boolean flag=false;
			try {
				System.out.println(payment);
				responseString = ReqUMF.post(apiContext, payment);
				System.out.println(responseString);
//--------------------验证返回结果，判断是否成功----------------------------------------------------------------//
				if(responseString.contains("\"ret_msg\":\"successful transaction\",\"ret_code\":\"0000\"")){
					flag=true;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("访问接口"+payer.getInterfaceType()+"失败");
			}
//			assertTrue(flag==true);
			return flag;
		
	}

}
