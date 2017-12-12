package com.umpaytester.spay.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.Key;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Map;
import java.util.Set;

import javax.crypto.Cipher;

import com.umpay.util.Base64;
import com.umpaytester.utils.PropsUtil;
import com.umpaytester.utils.log.Logger;

public class SignForSYTForWeb {
	static Logger log=Logger.getLogger(SignForSYTForWeb.class);  

	//window 机器密码
//	10.10.178.62
//	用户名mpsp，密码!Q@W3e4r

//	public static String merPrivCert = "K:/自动化测试/TestApi/TestApi/70510002_kuajingshouyintaiceshishanghumy.key.p8";
	public static String merPrivCert_70510000 = "";
	public static String entPubCert = "";
//	public static String merPrivCert=merPrivCert_70510002 ;
	//重写签名方法\
	//,String merPrivCert,String merPrivCert_70510000 ,String entPubCert
	
	@SuppressWarnings("deprecation")
	public static String sign(Map<String, Object> request,String url) {
		PropsUtil pu = new PropsUtil();
		merPrivCert_70510000 = pu.getPropsFilePath("testSpay.key.p8");
		entPubCert = pu.getPropsFilePath("testUmpay.cert.crt");
	   log.info("获取商户签名文件路径，"+merPrivCert_70510000);
	   log.info("获取商户加密文件路径，"+entPubCert);

		
		//遍历map字段并对敏感信息加密
//		// System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//		// System.out.println(">>>>以下是商户加密信息：       ");  
		Set<String> set = request.keySet();
		for(String name :set){
		             if("card_id".equals(name)||"card_holder".equals(name)||"identity_code".equals(name)
				     ||"valid_date".equals(name)
				     ||"cvv2".equals(name) 
				     || "card_holder".equals(name)
				     ||"pass_wd".equals(name)
				     ||"recv_account".equals(name)
				     ||"recv_user_name".equals(name) 
				     || "identity_holder".equals(name)
				     ||"in_account_id".equals(name)
				     ||"in_account_name".equals(name)){
				     if(!"".equals(name)){
				    	 String value = (String) request.get(name);	
				    	 value =encryptGBK(value);
				    	 request.put(name,value);
				  	   log.info("对敏感字段加密处理，"+name+":"+value);

//				    	 // System.out.println(">>>>敏感信息加密:"+name+" --加密后:"+data.get(name));
	        	        } 
//				     if("card_holder".equals(name)||"in_identity_code".equals(name)||"identity_code".equals(name)){
//						    	 String value = (String) data.get(name);	
//						    	 value =encrypt(value);
//						    	 data.put(name,value);
//						    	 // System.out.println(">>>>敏感信息加密:"+name+" --加密后:"+data.get(name));
//			        	}
	        }
			
		}
		//剔除sign和sign_type键值对，这两个字段不参加签名
		if(request.containsKey("sign_type")||request.containsKey("sign")){
			request.remove("sign_type");
		}

		
		
	   //准备生成用于签名的明文字符串
		StringBuilder sb = new StringBuilder();
		Set<String> setSign = request.keySet();
		for(String name :setSign){
             sb.append(name+"="+request.get(name)+"&");
		}
		String signBefore=sb.substring(0, sb.length()-1);
//		// System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//		// System.out.println(">>>>以下是商户签名信息：                                                                                                                                                                                        ");

		// System.out.println(">>>>签名前字符串："+signBefore);
		
		//对签名字符串进行签名
		String sign="";
		
		

		
		File file = new File(merPrivCert_70510000);
		
		InputStream in = null;
		byte[] key = new byte[20480];
		try {
			in = new FileInputStream(file);
			in.read(key);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		

		
		PrivateKey pk = genPrivateKey(key);
		byte[] signData;
		try {
			signData = sign(pk,signBefore.getBytes("GBK"));
			 sign = Base64.encode(signData);
			 // System.out.println(">>>>签名="+sign);
//		// System.out.println(">>>>商户签名结束                                                                                                                                                                                                           ");

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		//签名后字符串判断是否需要做encode
		Set<String> set2 = request.keySet();
		for(String name :set2){
			if("risk_expand".equals(name)
				     ||"goodsData".equals(name)
				     ||"refund_data".equals(name) 
				     ||"goods_data".equals(name) 
				      ||"card_holder".equals(name)
				      ||"identity_code".equals(name)
				      ||"card_id".equals(name)
				     ||"ret_url".equals(name)
				     ||"notify_url".equals(name)
				     ||"enterprise_name".equals(name)
				     ||"enterprise_contact".equals(name)
				     ||"enterprise_email".equals(name)
//				     ||"goods_info".equals(name)
				     ){
				     if(!(name.equals(""))||(!(name == null))){
				    	 String value = (String) request.get(name);	
						    log.info("对特殊字符和中文进行encoding处理，"+name+":"+value);

				    	 value =URLEncoder.encode(value);
				    	 request.put(name,value);
				    	 

//							// System.out.println(">>>>含有特殊字符字段进行URLEncoding:"+name+" --encoding后:"+data.get(name));

	        	}
	        }
		}
//		data.put("card_holder",URLEncoder.encode(SYTBean.getCard_holder()));
		//增加sign_type,排序后加入sign
		request.put("sign_type", "RSA");
//	
		
		StringBuilder sb1 = new StringBuilder();
		Set<String> setSign1 = request.keySet();
		for(String name :setSign1){
             sb1.append(name+"="+request.get(name)+"&");
		}
		String signAfter=sb1.substring(0, sb1.length()-1);
		String plain = signAfter + "&" + "sign=" + URLEncoder.encode(sign);
		
		// System.out.println(">>>>发送签名后字符串："+plain);

		// 发送客户端处理，并接收报文
//		String ret_msg="";
		try {
			// System.out.println(">>>>发送完整请求内容："+url+plain);
//			// System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		  	   log.info("待发送字符串："+url+plain);
//			ret_msg = (String) getResObj(url+plain);
//		  	   log.info("返回结果："+ret_msg);
//		  	   ret_msg.substring(ret_msg.indexOf("CONTENT=\""));
//		  	   
//		  	   log.info("对结果进行格式化："+ret_msg);



		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return url+plain;
		
		
		
	}
		
	
	
	//签名敏感字符串
	public static String encrypt(String string){
		// 取得公钥
		File file = new File(entPubCert);
		InputStream in = null;
		byte[] key = new byte[20480];
		try {
			in = new FileInputStream(file);
			in.read(key);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		java.security.cert.X509Certificate cert = genCertificate(key);
		byte[] keyBytes = cert.getPublicKey().getEncoded();
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
		try {
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			Key publicKey = keyFactory.generatePublic(x509KeySpec);
			Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			string = Base64.encode(cipher.doFinal(string.getBytes("GBK")));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return string;
		
	}

	//签名敏感字符串
	public static String encryptGBK(String string){
		// 取得公钥
		File file = new File(entPubCert);
		InputStream in = null;
		byte[] key = new byte[20480];
		try {
			in = new FileInputStream(file);
			in.read(key);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		java.security.cert.X509Certificate cert = genCertificate(key);
		byte[] keyBytes = cert.getPublicKey().getEncoded();
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
		try {
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			Key publicKey = keyFactory.generatePublic(x509KeySpec);
			Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			string = Base64.encode(cipher.doFinal(string.getBytes("GBK")));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return string;
		
	}
	
	public static X509Certificate genCertificate(byte certData[]) {
		if (certData == null || "".equals(certData)) {
			throw new RuntimeException("cert data is null or empty");
		}

		ByteArrayInputStream bais = new ByteArrayInputStream(certData);
		X509Certificate cert = null;
		try {
			CertificateFactory cf = CertificateFactory.getInstance("X.509");
			cert = (X509Certificate) cf.generateCertificate(bais);
			return cert;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("");
		}

	}
	
	public static PrivateKey genPrivateKey(byte key[]) {
		if (key == null || key.length == 0) {
			throw new RuntimeException("key is null or empty");
		}
		PrivateKey pk = null;
		try {
			PKCS8EncodedKeySpec peks = new PKCS8EncodedKeySpec(key);
			KeyFactory kf = KeyFactory.getInstance("RSA");
			pk = kf.generatePrivate(peks);
			return pk;
		} catch (Exception e) {
			throw new RuntimeException("generate Priveta key error");
		}
	}
	
	public static byte[] sign(PrivateKey pk, byte data[]) {
		byte sb[] = (byte[]) null;
		try {
			Signature sig = Signature.getInstance("SHA1withRSA");
			sig.initSign(pk);
			sig.update(data);
			sb = sig.sign();
			return sb;
		} catch (Exception e) {
			throw new RuntimeException("签名失败");
		}

	}
	/**
	 * Http的get请求
	 * 
	 * @param urlstr
	 * @return
	 * @throws Exception
	 */
	public static Object getResObj(String urlstr) throws Exception {
		InputStreamReader reader = null;
		HttpURLConnection conn = null;
		try {
			URL url = new URL(urlstr);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setDoInput(true);
			conn.setDoOutput(false);
			conn.setConnectTimeout(50000);
			conn.setReadTimeout(50000);
			conn.connect();
			int rCode = conn.getResponseCode();
			if (rCode == HttpURLConnection.HTTP_OK) {
				reader = new InputStreamReader(conn.getInputStream(), "UTF-8");
				char[] cha = new char[1024];
				int len = reader.read(cha);
				Object obj = new String(cha, 0, len);
				return obj;
			} else {
				return null;
			}
		} finally {
			try {
				reader.close();
			} catch (Exception e) {
				reader = null;
			}
			try {
				conn.disconnect();
			} catch (Exception e) {
				conn = null;
			}
		}
	}

	
}
