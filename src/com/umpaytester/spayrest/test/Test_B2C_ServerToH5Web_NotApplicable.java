package com.umpaytester.spayrest.test;

import com.umf.api.payments.Payer;
import com.umf.api.payments.PayerInfo;
import com.umf.api.payments.Payment;
import com.umf.api.payments.RiskInfo;
import com.umf.api.payments.enums.BusinessType;
import com.umf.api.payments.enums.InterfaceType;
import com.umf.api.payments.enums.PaymentMethod;
import com.umf.base.ReqUMF;
import com.umf.base.rest.APIContext;
import  com.umpaytester.spayrest.util.BaseTest;

public class Test_B2C_ServerToH5Web_NotApplicable {
	
	public static void main(String[] args) {
		Test_B2C_ServerToH5Web_NotApplicable test = new Test_B2C_ServerToH5Web_NotApplicable();
		test.test();
	}
	
	
 
//	@Test  
	public  Boolean test() {   //接口命名以  BusinessType_InterfaceType_PaymentMethod 命名
		
		
		
//--------------------创建BaseTest对象，获取基础数据-------------------------------------------------------------------//
		BaseTest test = new BaseTest();
//		try {
////			test.init();
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
	    APIContext apiContext = test.APIContext();
	    Payment payment=test.Payment();
	    
//--------------------创建Payer对象，配置具体的接口参数、风控字段、以及BaseTest中不存在的参数-----------------------------------------//
	    Payer payer=new Payer();
	    payer.setPaymentMethod(PaymentMethod.NOT_APPLICABLE);
	    payer.setBusinessType(BusinessType.B2C);
	    payer.setInterfaceType(InterfaceType.SERVER_TO_H5WEB);
	    payer.setBankCode("BOC");
	       PayerInfo payerInfo=new PayerInfo();
	       payer.setPayerInfo(payerInfo);
	      payment.setRetUrl("http:www.baidu.com");
	      payment.setPayer(payer);
	      RiskInfo riskInfo = new RiskInfo();
			 riskInfo.setB0002("02");
			 riskInfo.setD0008("1");
			 riskInfo.setD0009("0");
			 riskInfo.setD0010("Y");
			payment.setRiskInfo(riskInfo);
			
//--------------------组装数据，加密签名，发送数据，接收结果----------------------------------------------------------------//
			String responseString = null;
			Boolean flag=false;
			try {
				responseString = ReqUMF.post(apiContext, payment);
				
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
