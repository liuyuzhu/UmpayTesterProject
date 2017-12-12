package com.umpaytester.spay.test;

import static org.junit.Assert.assertTrue;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

import com.test.beans.SYTBean;
import com.test.beans.SignForSYT;

public class cb_update_customs_quire {
	@Test
	 
	 public void Test_cb_confirm_pay_shortcut() throws UnsupportedEncodingException{
		
	for (int i = 0; i < 1; i++) {
		String trade_no="";
		String order_id=SYTBean.order_id;
		 //创建bean对象，并对字段赋值 
		 SYTBean tb = new SYTBean();	

		 Map<String ,Object>  request = new  TreeMap<String, Object>();

		 
//报关接口
		 tb.setService("cb_update_customs_quire");	 
		 request.put("service",SYTBean.getService());
		 request.put("charset",SYTBean.getCharset());
		 request.put("mer_id",SYTBean.getMer_id());
		 request.put("version",SYTBean.getVersion());
		 request.put("mer_date","20310508");
		 request.put("order_date","20310508");
		 
		 request.put("sub_order_id","11111112");
		 
		 request.put("customs_id","ZZZS");
		 request.put("customs_code","GZZS");
		 request.put("freight","0");
		 request.put("tax","0");
		 request.put("goods_amount","0.13");
		 request.put("ec_plat_id","123456abcde");
		String RetMsg=SignForSYT.sign(request, SYTBean.url);
		 
//		 System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		 if(RetMsg.contains("&ret_msg=订单不存在")){
			 System.out.println(String.format("[测试接口10"+this.getClass().getSimpleName()+"----调用接口----"+SYTBean.getService()+"--成功"));
		 }else{
			 System.out.println(String.format("[测试接口10"+this.getClass().getSimpleName()+"----调用接口----"+SYTBean.getService()+"--失败")+RetMsg);
		 }
//		 System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

//		 assertTrue(RetMsg.contains("&ret_msg=订单不存在")); 

	}
}
	
}

