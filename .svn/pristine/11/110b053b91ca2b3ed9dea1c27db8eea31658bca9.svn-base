package com.umpaytester.cbewebrest;

import com.google.gson.Gson;
import com.umpaytester.cbewebrest.util.TestUtil;
import com.umpaytester.utils.JsonPrintUtil;
import com.umpaytester.utils.PrintUtil;
import com.umpaytester.utils.log.Logger;

/**作者：刘玉柱
 *日期：2017年11月13日
 *时间：上午10:06:03
 *该类的功能:测试类工具类
**/
public class CbewebRestBaseTest {
	static Logger log=Logger.getLogger(CbewebRestBaseTest.class);  
	public static String  httpPost(Object obj,String merId,String uri) throws Exception{
		String urll = uri.substring(0, uri.indexOf("cbeweb_rest")+11);
		String port = uri.substring(uri.indexOf("cbeweb_rest")+11,uri.length());
		String json = new Gson().toJson(obj);
		PrintUtil.printInConsole("-------请求------------");
		JsonPrintUtil.formatJson(json);
		String result = TestUtil.sendMsg(merId, urll, port, json, "POST");
		PrintUtil.printInConsole("-------响应------------");
		return JsonPrintUtil.formatJson(result);
		
	}
	
	public static String httpGet(String merId,String uri) throws Exception{
		PrintUtil.printInConsole("-------请求------------");
		String urll = uri.substring(0, uri.indexOf("cbeweb_rest")+11);
		String port = uri.substring(uri.indexOf("cbeweb_rest")+11,uri.length());
		JsonPrintUtil.formatJson(uri);
		String result = TestUtil.sendMsg(merId, urll, port, null, "GET");
		PrintUtil.printInConsole("-------响应------------");
		return JsonPrintUtil.formatJson(result);
		
	}
	
}
