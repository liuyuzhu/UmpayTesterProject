package com.umpaytester.cbewebrest.util;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

import com.umpaytester.utils.PrintUtil;

public class HttpJsonUtil {
	
	public static String httpPostJson(String reqUrl, Map<String, String> head, String jsonStr) throws Exception{
		
		HttpURLConnection conn = null;
		URL url = new URL(reqUrl);
		InputStreamReader reader = null;
		conn = (HttpURLConnection) url.openConnection();
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("Charset", "UTF-8");
		
		if (head != null && head.size() > 0) {
			Iterator<String> it = head.keySet().iterator();
			while (it.hasNext()) {
				String key = (String) it.next();
				conn.setRequestProperty(key, head.get(key));
			}
		}
		
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setConnectTimeout(90000);
		conn.setReadTimeout(90000);
		conn.setUseCaches(false);
		conn.connect();
		conn.getOutputStream().write(jsonStr.getBytes("UTF-8"));
		conn.getOutputStream().flush();
		conn.getOutputStream().close();
		
		try {
			reader = new InputStreamReader(conn.getInputStream(), "UTF-8");
		} catch (Exception e) {
			reader = new InputStreamReader(conn.getErrorStream(), "UTF-8");
		}
		
		int rCode = conn.getResponseCode();
		
		if (rCode == HttpURLConnection.HTTP_OK || rCode == HttpURLConnection.HTTP_CREATED) {
			//PrintUtil.printInConsole("Connection success. Reading from " + reqUrl);
		
		} else if (rCode == HttpURLConnection.HTTP_CLIENT_TIMEOUT
				|| rCode == HttpURLConnection.HTTP_GATEWAY_TIMEOUT) {
			//PrintUtil.printInConsole("Connection timeout: " + reqUrl);
		}
		
		StringBuilderWriter sbw = new StringBuilderWriter();
		
		IOUtil.copy(reader, sbw);
		
		return sbw.toString();
	}

	public static String httpGetJSon(String reqUrl, Map<String, String> head) throws Exception{
		HttpURLConnection conn = null;
		
		InputStreamReader reader = null;
		
		URL url = new URL(reqUrl);
		conn = (HttpURLConnection) url.openConnection();
		
		if (head != null && head.size() > 0) {
			Iterator<String> it = head.keySet().iterator();
			while (it.hasNext()) {
				String key = (String) it.next();
				conn.setRequestProperty(key, head.get(key));
			}
		}
		conn.setRequestMethod("GET");
		conn.setDoInput(true);
		conn.setDoOutput(false);
		conn.setConnectTimeout(50000);
		conn.setReadTimeout(50000);
		conn.connect();
		int rCode = conn.getResponseCode();
		
		try {
			reader = new InputStreamReader(conn.getInputStream(), "UTF-8");
		} catch (Exception e2) {
			reader = new InputStreamReader(conn.getErrorStream(), "UTF-8");
		}
		
		if (rCode == HttpURLConnection.HTTP_OK || rCode == HttpURLConnection.HTTP_CREATED) {
			PrintUtil.printInConsole("Connection success. Reading from " + reqUrl);
		
		} else if (rCode == HttpURLConnection.HTTP_CLIENT_TIMEOUT
				|| rCode == HttpURLConnection.HTTP_GATEWAY_TIMEOUT) {
			PrintUtil.printInConsole("Connection timeout: " + reqUrl);
		}
		StringBuilderWriter sbw = new StringBuilderWriter();
		
		IOUtil.copy(reader, sbw);
		
		return sbw.toString();
	}
	
}
