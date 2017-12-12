package com.umpaytester.spayrest.test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.umf.api.payments.Amount;
import com.umf.api.payments.BankCard;
import com.umf.api.payments.Item;
import com.umf.api.payments.Order;
import com.umf.api.payments.Payer;
import com.umf.api.payments.PayerInfo;
import com.umf.api.payments.Payment;
import com.umf.api.payments.Refund;
import com.umf.api.payments.RiskInfo;
import com.umf.api.payments.SubOrder;
import com.umf.api.payments.enums.BusinessType;
import com.umf.api.payments.enums.CitizenIdType;
import com.umf.api.payments.enums.InterfaceType;
import com.umf.api.payments.enums.ItemType;
import com.umf.api.payments.enums.PaymentMethod;
import com.umf.base.ReqUMF;
import com.umf.base.rest.APIContext;
import com.umpaytester.utils.GetSms;
import com.umpaytester.utils.JsonPrintUtil;

import net.sf.json.JSONObject;

/**
 * @author yuzhuliu:
 * @version 閿熸枻鎷烽敓鏂ゆ嫹鏃堕敓鎴掞細2017閿熸枻鎷�9閿熸枻鎷�13閿熸枻鎷� 閿熸枻鎷烽敓鏂ゆ嫹2:06:23
 * 閿熸枻鎷疯閿熸枻鎷�
 */
public class RestOrderSmsConfirmRefundTest {
	static String address="10.10.178.36";
	static String addressReturn=address.replaceAll("178", "179");
	static String order_id;
	static String refundNo;
	
	static String sub_order_id1;
	static String sub_order_id2;
	static String goods_id1;
	static String goods_id2;
	static String today;
	

//	static String token;
	static String token="9580f435886e764b98a8564d3a2e56d1c501e23d66c7f5edcf8a7c42fea68d5a";
//	static String token=GetToken.token;D:/eclipse-workspace/UmpayTesterProject/src/config/test/
	static    String crtPath = "/D:/eclipse-workspace/UmpayTesterProject/src/config/test/testUmpay.cert.crt";
	static    String p8Path = "/D:/eclipse-workspace/UmpayTesterProject/src/config/test/testMer.key.p8";
	static    String UMFp8Path= "/D:/eclipse-workspace/UmpayTesterProject/src/config/test/testUmpay.key.p8";
	static	String clientId = "74a5945930aaefbfd89594f5bb89308cc52f594a";
	static	String clientSecret = "97a807a101ede5c14957770d0953a8017b28e815";
	static	String oauthUrl = "http://"+address+":8071/spay_rest/oauth/authorize";
	static  String url="http://"+address+":8071/spay_rest/payments/payment";
	static  String verifyUrl="";
	public static void getToken() throws IOException {
		token=getToke1();
		
	}
   public static void data() {
	   order_id= new SimpleDateFormat("yyyyMMddssSSS").format(new Date())+ "1234567899876121212";
		  refundNo= new SimpleDateFormat("yyyyMMddssSSS").format(new Date())+ "1234567899876121210";
		
		  sub_order_id1=order_id.replaceAll("1234567899876121212", "1234567899876121211");
		  sub_order_id2=order_id.replaceAll("1234567899876121212", "1234567899876121222");
		  goods_id1=order_id.replaceAll("1234567899876121212", "1234567899876121233");
		  goods_id2=order_id.replaceAll("1234567899876121212", "1234567899876121244");
		  today= new SimpleDateFormat("yyyyMMdd").format(new Date()).toString();
   }
	
	public static APIContext init(String url) throws IOException {
		

	    APIContext apiContext = new APIContext();
	    
	    String type="POST";
//		String url="http://10.10.178.34:8071/spay_rest/payments/payment";
		apiContext.setClientId(clientId);
		apiContext.setClientSecret(clientSecret);
		apiContext.setOauthUrl(oauthUrl);
	
		apiContext.setToken(token);  
		apiContext.setCrtPath(crtPath);
		apiContext.setP8Path(p8Path);
		apiContext.setUMFp8Path(UMFp8Path);
//		apiContext.setType(type);
		apiContext.setUrl(url);
		apiContext.setRSACharset("GBK");
		return apiContext;

		
	}
  

	public static void main(String[] args) throws Exception {
		for (int i = 0; i <100; i++) {
			System.out.println("============================初始化数据=================================");
			data();
			System.out.println("============================下单请求=================================");
			JsonPrintUtil jp = new JsonPrintUtil();
		String result=order().toString();
       
		verifyUrl= result.toString().substring(result.indexOf("sms_verify\",\"method\":\"GET\",\"href\":\"")+35, result.lastIndexOf("\"}]}")).replaceAll(addressReturn, address);
		System.out.println(verifyUrl);
		
     //   获取id后进行短信验证
//		verifyUrl="http://10.10.179.34:8071/spay_rest/payments/payment/PAY_GI3TCMJQG4YTOMJTGU2TGOJRGIZDAMJXGEYTANZP/verify";
		System.out.println("============================下发短信请求=================================");

		String verifyResult=verify(verifyUrl);
		System.out.println("============================获取发短信请求=================================");

		String sms=getSms(order_id);
		String exeUrl= verifyResult.toString().substring(verifyResult.indexOf("confirm\",\"method\":\"POST\",\"href\":\"")+33, verifyResult.lastIndexOf("\"}]}")).replaceAll(addressReturn, address);
        System.out.println(exeUrl);
		System.out.println("============================支付确认请求=================================");

        String exeResult=payConfirm(exeUrl,sms);
        String  refundUrl=exeResult.toString().substring(exeResult.indexOf("refund\",\"method\":\"POST\",\"href\":\"")+32, exeResult.lastIndexOf("\"}]}")).replaceAll(addressReturn, address);
        System.out.println(refundUrl);
        String  customsUrl=refundUrl.replaceAll("refund", "apply_to_customs");
        System.out.println(customsUrl);
        Thread.sleep(10000);
		System.out.println("============================支付退费请求=================================");

//        String refundResult=refund(refundUrl,refundNo).toString();
//        System.out.println(refundResult);
//		
//		
//		System.out.println("============================支付退费查询请求=================================");
//		String refundQuryUrl = refundResult.substring(refundResult.indexOf("self\",\"method\":\"GET\",\"href\":\"")+29, refundResult.lastIndexOf("\"}],\"refund\""));
//		String refundQueryResult = refundQuery( refundQuryUrl);
//		System.out.println(refundQuryUrl);
//		System.out.println(refundQueryResult);
		
		}

		
	
		
	
	}
	private static String refundQuery(String refundQuryUrl) throws IOException {
		 APIContext apiContext = init(refundQuryUrl);
		 Refund refund= new Refund();
		 Payment payment=new Payment();
//		 apiContext.setType("GET");
		 String refundQuery ="";
			try {
				 refundQuery = ReqUMF.get(apiContext);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		// TODO Auto-generated method stub
		return refundQuery;
	}
	//退费
	
	
	
	
	
	
	
	private static String refund(String refundUrl, String refundNo) throws Exception {
		 APIContext apiContext = init(refundUrl);
		 Refund refund= new Refund();
		 Order order = new Order();
		 order.setMerReferenceId(refundNo);
		 System.out.println(refundNo+"退费单长度："+refundNo.length());
		 Amount amount = new Amount();
		 amount.setTotal("100.02");
		 amount.setCurrency("CNY");
		 order.setAmount(amount);
	       SubOrder suborder1 = new SubOrder();
           suborder1.setMerSubReferenceId(sub_order_id1);
           suborder1.setTransCode("03223010");
//           suborder1.g
               Amount amount1 = new Amount();
               amount1.setTotal("100.02");
               amount1.setCurrency("CNY");
           suborder1.setAmount(amount1);
           List<SubOrder> subOrders = new ArrayList<SubOrder>();   
           subOrders.add(suborder1);
           order.setSubOrders(subOrders);
		 
		 refund.setOrder(order);
		 
		 
		 String responseString = null;
		try {
			responseString = ReqUMF.postRefund(apiContext, refund);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("退费失败，请检查数据是否正确！");
		}
		// TODO Auto-generated method stub
		return responseString.toString();
	}




	//支付确认
	private static String payConfirm(String url,String sms) throws Exception {
		
		 APIContext apiContext = init(url);
			Payment payment=new Payment();
			Payer payer=new Payer();
			 payer.setPaymentMethod(PaymentMethod.DEBIT_CARD);

			  payer.setBankCode("CITIC");

			     PayerInfo payerInfo=new PayerInfo();
			      BankCard bc = new BankCard();
			      bc.setValidDate("");
			      bc.setCvv2("");
			      bc.setPhone("18701588007");
			      
			        bc.setCardNumber("6217710703095380");
			        bc.setCitizenIdNumber("150404199308070250");
			        bc.setCitizenIdType(CitizenIdType.IDENTITY_CARD);
			        bc.setPayerName("魏超");
			        bc.setVerifyCode(sms);
			      
			      payerInfo.setBankCard(bc);
			     payer.setPayerInfo(payerInfo);
			     
			    

			     payment.setPayer(payer);
			String responseString = null;
			try {
				responseString = ReqUMF.post(apiContext, payment);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("支付确认失败，请检查数据！");
			}
			// TODO Auto-generated method stub
			
			
			System.out.println(responseString);
			return responseString;
	}





	//支付确认
	
	
	
	//获取短信验证码
	private static String  getSms(String orderId){
//		String sql="select t2.verifycode from umpay.T_VERIFYCODE_INF_0 t2 where t2.busitrace=(select t2.trace from umpay.T_PTRANS_2 t2 where t2.orderid='"+orderId+"')";
		
		GetSms getsms= new GetSms();
		
		String sms = null;
		try {
			sms = getsms.querySmsByOrderId(orderId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("未获取到短信验证码，请检查短信下发流程");
		}

		return sms;
		
		
	}
	
	
private static String verify(String url) throws Exception {

        APIContext apiContext = init(url);
		Payment payment=new Payment();
		Payer payer=new Payer();
		 payer.setPaymentMethod(PaymentMethod.DEBIT_CARD);

		  payer.setBankCode("CITIC");

		     PayerInfo payerInfo=new PayerInfo();
		      BankCard bc = new BankCard();
		      bc.setValidDate("");
		      bc.setCvv2("");
		      bc.setPhone("18701588007");
		      
		        bc.setCardNumber("6217710703095380");
		        bc.setCitizenIdNumber("150404199308070250");
		        bc.setCitizenIdType(CitizenIdType.IDENTITY_CARD);
		        bc.setPayerName("魏超");
		      
		      payerInfo.setBankCard(bc);
		     payer.setPayerInfo(payerInfo);
		     
		    

		     payment.setPayer(payer);
		String  responseString = ReqUMF.post(apiContext, payment);
		// TODO Auto-generated method stub
		
		
		System.out.println(responseString);
		return responseString;
	}


//public static void main(String[] args) throws IOException {
	public static String  order() throws IOException {



	    APIContext apiContext = init(url);
	
	Payment payment=new Payment();

	//payer
	Payer payer=new Payer();
	  payer.setPaymentMethod(PaymentMethod.DEBIT_CARD);
	  payer.setBusinessType(BusinessType.B2C);
	  payer.setInterfaceType(InterfaceType.SERVER_TO_SERVER);
	  payer.setBankCode("CITIC");
	     PayerInfo payerInfo=new PayerInfo();
	      BankCard bc = new BankCard();
	      bc.setCardNumber("6225880153597407");
	      bc.setCitizenIdNumber("131126198802036079");
	      bc.setCitizenIdType(CitizenIdType.IDENTITY_CARD);
	      bc.setPayerName("刘玉柱");
	      bc.setValidDate("");
	      bc.setCvv2("");
	      bc.setPhone("18701588007");
	      payerInfo.setBankCard(bc);
	     payer.setPayerInfo(payerInfo);
	     
	    
	  payment.setPayer(payer);
	           Order order = new Order();
	            System.out.println("订单长度："+order_id.length());
	     	   order.setMerReferenceId(order_id);
	            order.setMerDate(today);

	               Amount amount = new Amount();
	               amount.setTotal("200.04");
	               amount.setCurrency("CNY");
	           order.setAmount(amount);
	           order.setOrderSummary("maimaimai");
	           order.setExpireTime("360");
	           
	                   SubOrder suborder1 = new SubOrder();
	                       suborder1.setMerSubReferenceId(sub_order_id1);
	                       suborder1.setTransCode("03223010");
//	                       suborder1.g
		                       Amount amount1 = new Amount();
	                           amount1.setTotal("100.02");
	                           amount1.setCurrency("CNY");
	                       suborder1.setAmount(amount1);
	                       
	                     
	                     SubOrder suborder2 = new SubOrder();
	                     suborder2.setMerSubReferenceId(sub_order_id2);
	                     suborder2.setTransCode("01121990");
	                           Amount amount2 = new Amount();
	                           amount2.setTotal("100.02");
	                           amount2.setCurrency("CNY");
	                     suborder2.setAmount(amount2);
	                     suborder2.setIsCustoms("false");
	                            Item item = new Item();
	                            item.setMerItemId(goods_id1);
	                            item.setType(ItemType.FOOD);
	                            item.setName("banana");
	                            item.setItemQuantity("2");
	                            item.setDescription("banana");
	                                Amount amount21 = new Amount();
	                                amount21.setTotal("50.02");
	                                amount21.setCurrency("CNY");
	                            item.setAmount(amount21);
	                            
	                            Item item2 = new Item();
	                            item2.setMerItemId(goods_id2);
	                            item2.setType(ItemType.ELECTRONIC);
	                            item2.setName("yifu");
	                            item2.setItemQuantity("3");
	                            item2.setDescription("yifu");
	                                Amount amount22 = new Amount();
	                                amount22.setTotal("50.00");
	                                amount22.setCurrency("CNY");
	                            item2.setAmount(amount22);
	                            
	                            List<Item> items = new ArrayList<Item>();
	                            items.add(item);
	                            items.add(item2);
	                      suborder2.setItems(items);
	                      

	                       List<SubOrder> subOrders = new ArrayList<SubOrder>();   
	                       subOrders.add(suborder2);
	                       subOrders.add(suborder1);
	                       order.setSubOrders(subOrders);
	                       payment.setOrder(order);
	                       String notifyUrl="http://10.10.179.34:8081/spaytest/notify0000V4.jsp";
						payment.setNotifyUrl(notifyUrl);
//	                       String retUrl="http://10.10.179.34:8081/spaytest/notify0000V4.jsp";
//						payment.setRetUrl(retUrl);
						
						 RiskInfo riskInfo = new RiskInfo();
						 riskInfo.setB0002("02");
//						 riskInfo.setD0008("1");
//						 riskInfo.setD0009("0");
//						 riskInfo.setD0010("Y");
//						 
						payment.setRiskInfo(riskInfo);
//						System.out.println(apiContext.toString());

	                    
						JSONObject json_test = JSONObject.fromObject(payment); 
						System.out.println(json_test);
						JSONObject json_test1 = JSONObject.fromObject(apiContext); 
						System.out.println(json_test1);

//						String[] list = json_test.toString().split(",");
						
						
						
	String responseString = null;
	try {
		System.out.println("下单发送前：");
		responseString = ReqUMF.post(apiContext, payment);
		if(responseString.contains("successful transactio")){
			System.out.println("访问成功");
			
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("=============================================================================================");

	System.out.println("返回响应信息为："+responseString);




//	String id = responseString.toString().substring(responseString.indexOf("\\\"id\\\":\\\""), responseString.lastIndexOf("\",\"state\":"));
//	System.out.println(id);

return responseString;



}
	
	
	 public static   String    getToke1( ) throws IOException{
    	 
         //��ȡtoken
    
    URL spay_url = new URL(oauthUrl);
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
    connection1.setInstanceFollowRedirects(true);
    connection1.setRequestProperty("Content-Type","application/json");

    try {
		connection1.connect();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

    //POST����
    DataOutputStream out1 = new DataOutputStream(
            connection1.getOutputStream());
    JSONObject obj1 = new JSONObject();
    obj1.element("scope", "default");
    obj1.element("grant_type", "client_credentials");
    obj1.element("client_secret", "97a807a101ede5c14957770d0953a8017b28e815");
    obj1.element("mer_id", "70510000");
    obj1.element("client_id", "74a5945930aaefbfd89594f5bb89308cc52f594a");

    out1.writeBytes(obj1.toString());
    out1.flush();
    out1.close();


    //��ȡ��Ӧ
    BufferedReader reader1 = new BufferedReader(new InputStreamReader(
            connection1.getInputStream()));
    String lines1;
    StringBuffer sb1 = new StringBuffer("");
    while ((lines1 = reader1.readLine()) != null) {
        lines1 = new String(lines1.getBytes(), "utf-8");
        sb1.append(lines1);
        System.out.println(sb1);
        token=sb1.substring(17, sb1.lastIndexOf("\"}")).toString();
//        client_id=sb1.substring(73, sb1.lastIndexOf("\"}")).toString();
    }
    
//    System.out.println(sb1);
    System.out.println("token:"+token);
//    System.out.println(client_id);
    reader1.close();
    // �Ͽ�����
    connection1.disconnect();
	return token;
    
    
    
    
    

}

}


