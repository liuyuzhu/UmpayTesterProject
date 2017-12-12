package com.umpaytester.spayrest.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

public class TesRestAll {
	public static void main(String[] args) {
		TesRestAll test = new TesRestAll();
				try {
					test.test();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	
public HashMap<String, Boolean>  test() throws IOException {
	
      HashMap<String, Boolean> map = new HashMap<String ,Boolean>();
      HashMap<String, Boolean> context = new HashMap<String ,Boolean>();
      
      map.put("Test_B2C_ServerToServer_WechatInApp", new Test_B2C_ServerToServer_WechatInApp().test());
      map.put("Test_B2C_ServerToServer_AlipayScan", new Test_B2C_ServerToServer_AlipayScan().test());
      map.put("Test_B2C_ServerToServer_WechatScan", new Test_B2C_ServerToServer_WechatScan().test());
      map.put("Test_B2C_ServerToServer_WechatWeb", new Test_B2C_ServerToServer_WechatWeb().test());
		map.put("Test_B2C_ServerToH5Web_NotApplicable", new Test_B2C_ServerToH5Web_NotApplicable().test());
		map.put("Test_B2C_ServerToServer_CreditCard", new Test_B2C_ServerToServer_CreditCard().test());
		map.put("Test_B2C_ServerToServer_Debitcard", new Test_B2C_ServerToServer_Debitcard_First().test());
		map.put("Test_B2C_ServerToWeb_NotApplicable_WithQrcodeScan", new Test_B2C_ServerToWeb_NotApplicable_WithQrcodeScan().test());
		map.put("Test_B2C_ServerToWeb_NotApplicable", new Test_B2C_ServerToWeb_NotApplicable().test());
//		
		  for (Entry<String, Boolean> entry : map.entrySet()) {
			  
			   System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
			   if(entry.getValue() == false) {
				   if(entry.getKey().equals("Test_B2C_ServerToH5Web_NotApplicable")) {
						map.put("Test_B2C_ServerToH5Web_NotApplicable", new Test_B2C_ServerToH5Web_NotApplicable().test());
				   }
				   if(entry.getKey().equals("Test_B2C_ServerToServer_AlipayScan")) {
						map.put("Test_B2C_ServerToServer_AlipayScan", new Test_B2C_ServerToServer_AlipayScan().test());
				   }
				   if(entry.getKey().equals("Test_B2C_ServerToServer_CreditCard")) {
						map.put("Test_B2C_ServerToServer_CreditCard", new Test_B2C_ServerToServer_CreditCard().test());
				   }
				   if(entry.getKey().equals("Test_B2C_ServerToServer_Debitcard")) {
						map.put("Test_B2C_ServerToServer_Debitcard", new Test_B2C_ServerToServer_Debitcard_First().test());
				   }
				   if(entry.getKey().equals("Test_B2C_ServerToServer_WechatInApp")) {
						map.put("Test_B2C_ServerToServer_WechatInApp", new Test_B2C_ServerToServer_WechatInApp().test());
				   }
				   if(entry.getKey().equals("Test_B2C_ServerToServer_WechatScan")) {
						map.put("Test_B2C_ServerToServer_WechatScan", new Test_B2C_ServerToServer_WechatScan().test());
				   }
				   if(entry.getKey().equals("Test_B2C_ServerToServer_WechatWeb")) {
						map.put("Test_B2C_ServerToServer_WechatWeb", new Test_B2C_ServerToServer_WechatWeb().test());
				   }
				   if(entry.getKey().equals("Test_B2C_ServerToWeb_NotApplicable_WithQrcodeScan")) {
						map.put("Test_B2C_ServerToWeb_NotApplicable_WithQrcodeScan", new Test_B2C_ServerToWeb_NotApplicable_WithQrcodeScan().test());
				   }
				   if(entry.getKey().equals("Test_B2C_ServerToWeb_NotApplicable")) {
						map.put("Test_B2C_ServerToWeb_NotApplicable", new Test_B2C_ServerToWeb_NotApplicable().test());
				   }
			   }
			  }
		
		  
		  
		  for (Entry<String, Boolean> entry : map.entrySet()) {
			  if(entry.getValue() == false) {
				  context.put(entry.getKey(), entry.getValue());
			  }
          }
		  
		
		return context;
			  
		 
	}
}
