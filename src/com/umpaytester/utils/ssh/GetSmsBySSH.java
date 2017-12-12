package com.umpaytester.utils.ssh;

import java.util.Map;
import java.util.Map.Entry;

import com.umpaytester.utils.log.Logger;

/**
 *作者：刘玉柱
 *日期：2017年11月15日
 *时间：下午4:46:27
 *该类的功能:
**/

public class GetSmsBySSH {
    static Logger log=Logger.getLogger(GetSmsBySSH.class);  

	public static String  exeShellCmd(String commands,String host) {
		EXEShell es = new EXEShell();
		String contxt="";
		String sms="";
		
		Map<String, String> result = null;
		try {
			result = es.runDistanceShellN( commands, "mpsp", "mpsp4321", host);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info("远程查询短信验证码，登录异常"+host+commands);
		}
		for (Entry<String, String> entry : result.entrySet()) {
			log.info(result.toString());
                      if(entry.getValue().contains("detail=成功, verifyCode=")) {
                    	  contxt=entry.getValue().substring(entry.getValue().indexOf("detail="));
                    	  log.info("远程查询短信验证码，登录成功，获取验证码成功：");
                    	  log.info(contxt.replaceAll("//r//n", ""));
                      }else {
                    	  log.info("远程查询短信验证码，登录成功，获取验证码失败");
                      }
		            
			         }
//		String sms=contxt.substring(beginIndex, endIndex);
		if(contxt.contains("detail=成功")) {
			
			sms=contxt.substring(contxt.indexOf("verifyCode=")+11, contxt.indexOf("verifyCode=")+17);
			log.info("验证码为："+sms);
		}
		
		return sms;
		
	}
	
	public static String getSmsByShell(String trace,String host) {
		GetSmsBySSH getSms = new GetSmsBySSH();  
//		String trace="2711151327541253";
		String cmd="grep '"+trace+"]LoginPageAjaxSmsController'  /usr/log/fx_resina1/fx_upay/detail.log"	;
//		String host = "10.10.178.36"	;
		String sms = getSms.exeShellCmd(cmd, host);
//		System.out.println(sms);
		return sms;
	}
public String getPbgSmsByShell(String trace, String host) {
		
		GetSmsBySSH getSms = new GetSmsBySSH();  
		String cmd="grep '"+trace+"]payGateBusiLog|获取短信验证码得到系统参数请求'  /usr/log/fx_resina1/fx_upay/detail.log|tail -n 1"	;
		log.info(cmd);
		String sms = getSms.queryPbgSms(cmd, host);
		// TODO Auto-generated method stub
		return sms;
}
public static String  queryPbgSms(String commands,String host) {
	EXEShell es = new EXEShell();
	String contxt="";
	String sms="";
	
	Map<String, String> result = null;
	try {
		result = es.runDistanceShellN( commands, "mpsp", "mpsp4321", host);
		log.info("--------------"+result.toString());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		log.info("远程查询短信验证码，登录异常"+host+commands);
	}
	
	
	for (Entry<String, String> entry : result.entrySet()) {
		
        if(entry.getValue().contains("payGateBusiLog")) {
      	  contxt=entry.getValue().substring(entry.getValue().indexOf("pbg/100003"));

//      	  contxt=entry.getValue();
      	  log.info("远程查询短信验证码，登录成功，获取验证码成功："+contxt);
        }else {
      	  log.info("远程查询短信验证码，登录成功，获取验证码失败");
        }
      
       }
	
	
	
	

	if(contxt.contains("payGateBusiLog")) {
		
		sms=contxt.substring(contxt.indexOf("verifyCode=")+11, contxt.indexOf("verifyCode=")+15);
		log.info("验证码为："+sms);
	}else {
		log.info("获取失败");
	}
	
	return sms;
	
}



	public static void main(String[] args) {
		GetSmsBySSH getSmsSSH= new GetSmsBySSH();
		String sms =""	;
////		GetSmsBySSH gePbgtSms = new GetSmsBySSH();  
		String trace="2711160925545414";
		String host = "10.10.178.36"	;
		sms=getSmsSSH.getSmsByShell(trace, host);
		System.out.println(sms);
////		log.info("queryPbgSms");
////		String sms = gePbgtSms.getPbgSmsByShell(trace, ip);
////		System.out.println(sms);
//		String cmd=" grep  '20171116215977'    /usr/log/fx_resina1/fx_upay/detail.log "	;
//
//		EXEShell es = new EXEShell();
//		String contxt="";
//		String sms="";
//		
//		Map<String, String> result = null;
//
//			result = es.runDistanceShellN( cmd, "mpsp", "mpsp4321", host);
//	System.out.println(result.toString());
// 
	
	
	
}

}
