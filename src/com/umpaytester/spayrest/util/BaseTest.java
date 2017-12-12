package com.umpaytester.spayrest.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import com.umf.api.payments.Amount;
import com.umf.api.payments.Item;
import com.umf.api.payments.Order;
import com.umf.api.payments.Payment;
import com.umf.api.payments.SubOrder;
import com.umf.api.payments.enums.ItemType;
import com.umf.base.rest.APIContext;
import com.umpaytester.utils.PropsUtil;

public class BaseTest {
	public static long timer=18000;
	public static  String  mer_id;
	public static  String client_secret;
	public static  String client_id;
	public static  String token;
	public static String url;//测试环境
	public static String restOauthUrl;//测试环境
	public static String crt;
	public static String p8;
	public static String UMFp8;
	public static    String crtPath;
	public static    String p8Path;
	public static    String UMFp8Path;

	//准备数据，生成client数据，token数据
	public void init() throws IOException {
		GenerateClientToken test = new GenerateClientToken();
			
//					String path=GetProperties.getPath();
					
					PropsUtil pu = new PropsUtil();
					Properties props=pu.getENVProperties("base.properties");

//				client_secret=props.getProperty("client_secret");
//				 client_id=props.getProperty("client_id");
				 mer_id=props.getProperty("mer_id");
				 restOauthUrl=props.getProperty("restOauthUrl");
				 url=props.getProperty("url");
				 //用加載文件的方式
//				 crtPath = pu.envFilePath.replaceAll("//uat", "/uat")+props.getProperty("crtPath");
//				 p8Path= pu.envFilePath.replaceAll("//uat", "/uat")+props.getProperty("p8Path");
//				 UMFp8Path= pu.envFilePath.replaceAll("//uat", "/uat")+props.getProperty("UMFp8Path");
//				 
					token=test.getToken(props.getProperty("client_secret"),props.getProperty("client_id"));
//					token="ac5e966a1e67d7c10f3a294e5a2914ad91d1ced54d466b1520d4e7165c1df2bf";

				 
//				 crtPath = pu.getPropsFilePath("umpay.cert.crt");
//				 p8Path= pu.getPropsFilePath("8023_beimeiceshiAPIshanghu.key.p8");
//				 UMFp8Path= pu.getPropsFilePath("8023_beimeiceshiAPIshanghu.key.p8");
				 crtPath = pu.getPropsFilePath("testMer.cert.crt");
				 p8Path= pu.getPropsFilePath("testSpay.key.p8");
				 UMFp8Path= pu.getPropsFilePath("testUmpay.key.p8");
				 System.out.println( pu.envFilePath.replaceAll("//uat", "/uat"));

//					 String time = props.getProperty("timer");
//					 
//					  try {
//						timer = Long.parseLong(time);
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
					  
				
			
		
	}


	

	//参数

	
	
	
	//中间参数
	public static String smsUrl;
	public static String confirmPayUrl;
	
	 

	public static String invoice=null;
	   public static String isCustom=null;
	public static String getInvoice() {
		return invoice;
	}
	public static void setInvoice(String invoice) {
		BaseTest.invoice = invoice;
	}
	public static String getIsCustom() {
		return isCustom;
	}
	public static void setIsCustom(String isCustom) {
		BaseTest.isCustom = isCustom;
	}

	
	public static String  notifyUrl="http://10.10.178.34:8081/spaytest/notify0000V4.jsp";

	
	public static  String type="POST";
	protected String genOrderId() {
		String orderId=""+(Math.round(Math.random()*800000)+100000)+"";
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String date = format.format(new Date());
		orderId = date+ orderId;
		return  orderId;
	}
	
	String today= new SimpleDateFormat("yyyyMMdd").format(new Date()).toString();
	String order_id= genOrderId();
	String sub_order_id1=order_id.substring(4)+"11";
	String sub_order_id2=order_id.substring(4)+"12";
	String goods_id1=order_id.substring(4)+"21";
	String goods_id2=order_id.substring(4)+"22";
	
	public static String getClient_secret() {
		
		
		return client_secret;
	}
	public static void setClient_secret(String client_secret) {
		BaseTest.client_secret = client_secret;
	}
	public static String getClient_id() {
		return client_id;
	}
	public static void setClient_id(String client_id) {
		BaseTest.client_id = client_id;
	}
	public String getToken() {
	
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	public APIContext APIContext()  {
		
		BaseTest test = new BaseTest();
		try {
			test.init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    APIContext apiContextBase = new APIContext();

		apiContextBase.setClientId(BaseTest.client_id);
		apiContextBase.setClientSecret(BaseTest.client_secret);
		apiContextBase.setOauthUrl(BaseTest.restOauthUrl);
		
		apiContextBase.setToken(BaseTest.token);
		apiContextBase.setCrtPath(BaseTest.crtPath);
		apiContextBase.setP8Path(BaseTest.p8Path);
		apiContextBase.setUMFp8Path(BaseTest.UMFp8Path);
//		apiContextBase.setType(BaseTest.type);
		PropsUtil pu = new PropsUtil();
		url = pu.getPropsValue("base.properties", "url");
		apiContextBase.setUrl(url);
		apiContextBase.setRSACharset("UTF-8");
		return apiContextBase;
		
		}
	
	public Payment Payment() {
//		BaseTest test = new BaseTest();
		
		 Order order = new Order();
         
   	   order.setMerReferenceId(order_id);
          order.setMerDate(today);

             Amount amount = new Amount();
             amount.setTotal("200.04");
             amount.setCurrency("USD");
         order.setAmount(amount);
         order.setOrderSummary("maimaimai");
         order.setExpireTime("360");
         
                 SubOrder suborder1 = new SubOrder();
                 suborder1.setMerSubReferenceId(sub_order_id1);
                 suborder1.setTransCode("03223010");
	                       Amount amount1 = new Amount();
                           amount1.setTotal("100.02");
                           amount1.setCurrency("USD");
                 suborder1.setAmount(amount1);
                 //---------------------------------------------------------
                 suborder1.setInvoiceId(BaseTest.getInvoice());
   
                   
                 SubOrder suborder2 = new SubOrder();
                 suborder2.setMerSubReferenceId(sub_order_id2);
                 suborder2.setTransCode("01121990");
                           Amount amount2 = new Amount();
                           amount2.setTotal("100.02");
                           amount2.setCurrency("USD");
                  suborder2.setAmount(amount2);
                  
                  //--------------------------------------------
                  suborder2.setIsCustoms("true");
                            Item item = new Item();
                            item.setMerItemId(goods_id1);
                            item.setType(ItemType.FOOD);
                            item.setName("banana");
                            item.setItemQuantity("2");
                            item.setDescription("banana");
                            Amount amount21 = new Amount();
                            amount21.setTotal("50.02");
                            amount21.setCurrency("USD");
                            item.setAmount(amount21);
                          
                            Item item2 = new Item();
                            item2.setMerItemId(goods_id2);
                            item2.setType(ItemType.ELECTRONIC);
                            item2.setName("yifu");
                            item2.setItemQuantity("3");
                            item2.setDescription("yifu");
                            
                             Amount amount22 = new Amount();
                              
                             amount22.setTotal("50.00");
                             amount22.setCurrency("USD");
                             item2.setAmount(amount22);
                          
                             List<Item> items = new ArrayList<Item>();
                             items.add(item);
                             items.add(item2);
                   suborder2.setItems(items);
                    

                   List<SubOrder> subOrders = new ArrayList<SubOrder>();   
                   subOrders.add(suborder2);
                   subOrders.add(suborder1);
           order.setSubOrders(subOrders);
 
		Payment paymentBase=new Payment();
		paymentBase.setNotifyUrl(notifyUrl);
		paymentBase.setOrder(order);
		paymentBase.setPayElements("");
		paymentBase.setRetUrl(notifyUrl);
		return paymentBase;
		
	}
	
	}
