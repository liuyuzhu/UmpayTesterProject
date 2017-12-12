package com.umpaytester.cbewebrest.util;

import java.util.HashMap;
import java.util.Map;

public class TestUtil {
	
	public static String sendMsg(String merId,String host,String port,String reqJson,String reqMethod) throws Exception {
		String result = null;
		
			if (!reqMethod.toUpperCase().matches("POST|GET")) {
				throw new Exception("");
			}
		
				String token = TokenUtil.getToken(merId, host);
				Map<String, String> head = new HashMap<String, String>();
				head.put("Content-Type", "application/json");
				head.put("Authorization", "Bearer"+token);
				if ("POST".equals(reqMethod.toUpperCase())) {
					String sign = RSAUtil.signForMER(reqJson, RSAUtil.getPrivateMERKeyInJar());
					//PrintUtil.printInConsole(sign);
					head.put("Signature", sign);
					// body
					try {
						result = HttpJsonUtil.httpPostJson(host+port,head,reqJson);
					} catch (Exception e) {
						throw e;
						
					}
				}else {
					result= HttpJsonUtil.httpGetJSon(host+port,head);
					
				}
		
		return result;
	}
	
}
