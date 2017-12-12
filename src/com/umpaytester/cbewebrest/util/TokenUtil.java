package com.umpaytester.cbewebrest.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.google.gson.Gson;
import com.umpaytester.cbewebrest.Authorize;
import com.umpaytester.cbewebrest.Token;
import com.umpaytester.utils.log.Logger;

public class TokenUtil {
	static Logger log=Logger.getLogger(TokenUtil.class);  

	public static String getToken(String merId,String ipPort) throws Exception{
		
		InputStream in = null; 
		
		try {
			in = RSAUtil.class.getClassLoader().getResourceAsStream("config/test/token.properties");

			Properties p = new Properties();
			
			p.load(in);
			
			String clientId = p.getProperty(merId+".clientId");
			
			String clientSecret = p.getProperty(merId+".clientSecret");
			
			Map<String, String> head = new HashMap<String, String>();
			head.put("Content-Type", "application/json");
			
			com.umpaytester.cbewebrest.Authorize authorize = new Authorize();
			authorize.setClientId(clientId);
			authorize.setClientSecret(clientSecret);
			String json = new Gson().toJson(authorize);
			String result = HttpJsonUtil.httpPostJson(ipPort+"/oauth/authorize", head, json);
			log.info(result);
			String token = new Gson().fromJson(result, Token.class).getAccessToken();
			
			return token;
		} catch (Exception e) {
			throw e;
		}finally{
			in.close();
		}
	}
	
}
