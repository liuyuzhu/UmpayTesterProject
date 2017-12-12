package com.umpaytester.spayrest.bean;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

import com.umpaytester.utils.PropsUtil;
import com.umpaytester.utils.log.Logger;

import net.sf.json.JSONObject;
/**
 *作者：刘玉柱
 *日期：2017年11月20日
 *时间：上午11:44:30
 *该类的功能:
**/
public class GetSpayRestToken {
	
	static Logger log=Logger.getLogger(GetSpayRestToken.class);  
    static String url;
	 static String requestType="POST";
	 static String ContentType="application/json";
	 static String mer_id;
	 static String client_id;
	 static String client_secret;
	 static String grant_type="client_credentials";
	 static String scope;
	public  static String token;
            
	
	 public static Logger getLog() {
		return log;
	}
	public static void setLog(Logger log) {
		GetSpayRestToken.log = log;
	}
	public static String getUrl() {
		return url;
	}
	public static void setUrl(String url) {
		GetSpayRestToken.url = url;
	}
	public static String getRequestType() {
		return requestType;
	}
	public static void setRequestType(String requestType) {
		GetSpayRestToken.requestType = requestType;
	}
	public static String getContentType() {
		return ContentType;
	}
	public static void setContentType(String contentType) {
		ContentType = contentType;
	}
	public static String getMer_id() {
		return mer_id;
	}
	public static void setMer_id(String mer_id) {
		GetSpayRestToken.mer_id = mer_id;
	}
	public static String getClient_id() {
		return client_id;
	}
	public static void setClient_id(String client_id) {
		GetSpayRestToken.client_id = client_id;
	}
	public static String getClient_secret() {
		return client_secret;
	}
	public static void setClient_secret(String client_secret) {
		GetSpayRestToken.client_secret = client_secret;
	}
	public static String getGrant_type() {
		return grant_type;
	}
	public static void setGrant_type(String grant_type) {
		GetSpayRestToken.grant_type = grant_type;
	}
	public static String getScope() {
		return scope;
	}
	public static void setScope(String scope) {
		GetSpayRestToken.scope = scope;
	}
	public static void setToken(String token) {
		GetSpayRestToken.token = token;
	}
	public static   String    getToken( ) throws IOException{
    URL spay_url = new URL(url);
    HttpURLConnection connection1 = (HttpURLConnection) spay_url.openConnection();
    connection1.setDoOutput(true);
    connection1.setDoInput(true);
    try {
		connection1.setRequestMethod(requestType);
	} catch (ProtocolException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    connection1.setUseCaches(false);
    connection1.setInstanceFollowRedirects(true);
    connection1.setRequestProperty("Content-Type",ContentType);
    try {
		connection1.connect();
	} catch (IOException e) {
		e.printStackTrace();
	}
    DataOutputStream out1 = new DataOutputStream(
            connection1.getOutputStream());
    JSONObject obj1 = new JSONObject();
    obj1.element("scope", scope);
    obj1.element("grant_type", "client_credentials");
    obj1.element("client_secret", client_secret);
    obj1.element("mer_id", mer_id);
    obj1.element("client_id", client_id);
    out1.writeBytes(obj1.toString());
    out1.flush();
    out1.close();
    BufferedReader reader1 = new BufferedReader(new InputStreamReader(
            connection1.getInputStream()));
    String lines1;
    StringBuffer sb1 = new StringBuffer("");
    while ((lines1 = reader1.readLine()) != null) {
        lines1 = new String(lines1.getBytes(), "utf-8");
        sb1.append(lines1);
        log.info(sb1.toString());
        token=sb1.substring(17, sb1.lastIndexOf("\",\"meta")).toString();
    }
    
    log.info("token:"+token);
    reader1.close();
    connection1.disconnect();
    //将token写入token.properties文件
     try {
		PropsUtil pu = new PropsUtil();
		 pu.updateToken("token.properties", token);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		log.info("存储token失败，请重新获取token");e.printStackTrace();
	}

	return token;
}
}