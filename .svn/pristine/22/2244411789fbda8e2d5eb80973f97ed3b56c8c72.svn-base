package com.umpaytester.spay.test;

import static org.junit.Assert.assertTrue;

import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

import com.test.beans.SYTBean;
import com.test.beans.SignForSYT;

public class download_settle_file {
	@Test
	 //	收银台下单接口
	 public void Test_download_settle_file()  {
	for (int i = 0; i < 1; i++) {
		 //创建bean对象，并对字段赋值
		 SYTBean tb = new SYTBean();	

		 tb.setService("download_settle_file");	 
		 Map<String ,Object>  request = new  TreeMap<String, Object>();
		 request.put("service",SYTBean.getService());
		 request.put("charset",SYTBean.getCharset());
		 request.put("mer_id",SYTBean.getMer_id());
		 request.put("sign_type",SYTBean.getSign_type());
		 request.put("res_format",SYTBean.getRes_format());
		 request.put("version",SYTBean.getVersion());
//		 request.put("settle_date",SYTBean.getSettle_date());
		 request.put("settle_date","20170818");
		 request.put("settle_type","CB_SETTLE");
//		 request.put("settle_type",SYTBean.getSettle_type());
		 

		 String RetMsg=SignForSYT.sign(request, SYTBean.url);
		 System.out.println(RetMsg);

//		 System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		 if(RetMsg.contains("TRADEDETAIL-START")){
			 System.out.println(String.format("[测试接口12"+this.getClass().getSimpleName()+"----调用接口----"+SYTBean.getService()+"--成功"));
		 }else{
			 System.out.println(String.format("[测试接口12"+this.getClass().getSimpleName()+"----调用接口----"+SYTBean.getService()+"--失败"));
		 }
//		 assertTrue(RetMsg.contains("TRADEDETAIL-START")); 

	}
}
	
}

