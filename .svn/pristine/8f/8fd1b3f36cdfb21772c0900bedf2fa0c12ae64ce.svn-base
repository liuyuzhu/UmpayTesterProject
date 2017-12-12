package com.umpaytester.spay.test;

import static org.junit.Assert.assertTrue;

import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

import com.test.beans.SYTBean;
import com.test.beans.SignForSYT;

public class cb_get_mer_bank_shortcut {
	 @Test
	 //	收银台下单接口
	 public void Test_cb_get_mer_bank_shortcut()  {
	for (int i = 0; i < 1; i++) {
		 //创建bean对象，并对字段赋值
		 SYTBean tb = new SYTBean();	

		 tb.setService("cb_get_mer_bank_shortcut");	 
		 Map<String ,Object>  request = new  TreeMap<String, Object>();
		 request.put("service",SYTBean.getService());
		 request.put("charset",SYTBean.getCharset());
		 request.put("mer_id",SYTBean.getMer_id());
		 request.put("sign_type",SYTBean.getSign_type());
		 request.put("res_format",SYTBean.getRes_format());
		 request.put("version",SYTBean.getVersion());
		 request.put("currency",SYTBean.getCurrency());
		 request.put("pay_type","DEBITCARD");
		 

		 String RetMsg=SignForSYT.sign(request, SYTBean.url);
//		 System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		 if(RetMsg.contains("ret_code=0000&ret_msg=查询成功")){
			 System.out.println(String.format("[测试接口5"+this.getClass().getSimpleName()+"----调用接口----"+SYTBean.getService()+"--成功"));
		 }else{
			 System.out.println(String.format("[测试接口5"+this.getClass().getSimpleName()+"----调用接口----"+SYTBean.getService()+"--失败"));
		 }
//		 System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		 assertTrue(RetMsg.contains("ret_code=0000&ret_msg=查询成功")); 

	}
}
	
}

