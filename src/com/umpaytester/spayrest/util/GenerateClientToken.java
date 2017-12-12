package com.umpaytester.spayrest.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

import com.umpaytester.utils.PropsUtil;

import net.sf.json.JSONObject;

public class GenerateClientToken extends BaseTest {



	

         public   String    getToken( String client_secret  ,String client_id ) throws IOException{
        	 
                 //锟斤拷取token
        	 PropsUtil pu = new PropsUtil();
        	 restOauthUrl= pu.getPropsValue("base.properties", "restOauthUrl");
            URL spay_url = new URL(restOauthUrl);
            HttpURLConnection connection1 = (HttpURLConnection) spay_url.openConnection();
            connection1.setDoOutput(true);
            connection1.setDoInput(true);
            try {
				connection1.setRequestMethod("POST");
			} catch (ProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            connection1.setUseCaches(false);
            connection1.setInstanceFollowRedirects(false);
            connection1.setRequestProperty("Content-Type","application/json");

            try {
				connection1.connect();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            //POST锟斤拷锟斤拷
            DataOutputStream out1 = new DataOutputStream(
                    connection1.getOutputStream());
            JSONObject obj1 = new JSONObject();
            obj1.element("scope", "default");
            obj1.element("grant_type", "client_credentials");
            obj1.element("client_secret", client_secret);
            obj1.element("mer_id", pu.getPropsValue("base.properties", "mer_id"));
            obj1.element("client_id", client_id);

            out1.writeBytes(obj1.toString());
            out1.flush();
            out1.close();


            //锟斤拷取锟斤拷应
            BufferedReader reader1 =null;
            
             try {
				reader1= new BufferedReader(new InputStreamReader(
				        connection1.getInputStream()));
				String lines1;
				StringBuffer sb1 = new StringBuffer("");
				while ((lines1 = reader1.readLine()) != null) {
				    lines1 = new String(lines1.getBytes(), "utf-8");
				    sb1.append(lines1);
//                System.out.println(sb1);
				    token=sb1.substring(17, sb1.lastIndexOf("\",\"meta\"")).toString();
				             }
				
				System.out.println("token:"+token);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("token生成失败，请检查地址"+restOauthUrl);

			}
//            reader1.close();
            // 锟较匡拷锟斤拷锟斤拷
//            connection1.disconnect();
			return token;
            

}
	
	public static void main(String[] args) {
//		String client_secret;
//		String client_id;
		GenerateClientToken test = new GenerateClientToken();
		try {
			BaseTest test1 = new BaseTest();
//			test1.init();
			test.getToken(BaseTest.client_secret, BaseTest.client_id);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
