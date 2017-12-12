package com.umpaytester.plat2cbe;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.umpay.util.HttpUtil;
import com.umpaytester.utils.log.Logger;



/**
 *作者：刘玉柱
 *日期：2017年11月29日
 *时间：下午12:05:57
 *该类的功能:
**/


public class TestBF221016 {
	static Logger log=Logger.getLogger(TestBF221016.class);  

	public static String rest = "http://10.10.178.34:19998";//测试环境
	static int j =0;
	public static void main(String[] args) {
//		 TestBF221016.TestBF221016(""+"20171208");
		for (int i = 20171101; i < i+1; 	i++) {
		 j++;
		 
		 
		 
		 if(j<31) {
			 TestBF221016.TestBF221016(""+i);
			log.info("处理日期："+i);
		 }
		}
	}
	public static void TestBF221016(String handleDate){
		
//		7.9011

    	Map<String,Object> params = new HashMap<String,Object>();
    	 params.put("rpid","PSP183712d278937");

    	 params.put("handleDate",handleDate);
    	 params.put("threshold","1");
    	 
//   	params.put("reqDate","20171205");
//   	params.put("orderDateFrom","20171205");
//   	params.put("orderDateTo","20171205");
//   	params.put("pageSize","1");
//   	params.put("pageNum","1");
//   	params.put("merId","70510000");
//   	params.put("statType","1");


    	 //params.put("nation","HKG");
    	String url = "/cbe/BF221016";
    	Map<String,Object> result = null;
    	try {
    		result = HttpUtil.httpPostForm2Xml(rest+url, params,"UTF-8");
    		
			Iterator<Map.Entry<String,Object>> entry = result.entrySet().iterator();
			while(entry.hasNext()){
				Map.Entry<String, Object> kv = entry.next();
				log.info(String.format("%s=%s", kv.getKey(),kv.getValue()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    
	}

}
