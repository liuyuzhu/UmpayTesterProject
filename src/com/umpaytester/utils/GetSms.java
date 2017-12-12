package com.umpaytester.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import com.umpaytester.spayrest.java.SpayRestRefundQueryApi;
import com.umpaytester.utils.log.Logger;

public class GetSms {
	
	
	static Logger log=Logger.getLogger(GetSms.class);  
	public static String querySmsByOrderId(String orderId){

		ArrayList<Map<String, String>> list = null;
		ArrayList<Map<String, String>> trace = null;
		 String verify_code = null;		
		//通过查询数据库�?�过trade_no 获取到trace号，之后在去短信表中查询
//		 String commonSqltradenoToTrace="select t2.trace from umpay.T_PTRANS_"+getWeek()+" t2 where t2.TRADENO='"+tradeNo+"'";
//		 trace=(ArrayList<Map<String, String>>)AccountConst.dbquery2(commonSqltradenoToTrace);
//		 
//		 System.out.println(trace);
//		 String traceNo = trace.get(0).toString().substring(7, trace.get(0).toString().length()-1);
		 		 
			String sql="select t2.verifycode from umpay.T_VERIFYCODE_INF_0 t2 where t2.busitrace=(select t2.trace from umpay.T_PTRANS_"+getWeek()+" t2 where t2.orderid='"+orderId+"' order by t2.trace desc  fetch first 1 rows only)";
			
		    list=(ArrayList<Map<String, String>>)AccountConst.dbquery2(sql);	
		    log.info(list.toString());
			if(list.isEmpty()){
				sql="select t2.verifycode from umpay.T_VERIFYCODE_INF_1 t2 where t2.busitrace=(select t2.trace from umpay.T_PTRANS_"+getWeek()+" t2 where t2.orderid='"+orderId+"' order by t2.trace desc  fetch first 1 rows only)";
				
				list=(ArrayList<Map<String, String>>)AccountConst.dbquery2(sql);
				log.info(list.toString());
				if(list.isEmpty()){
					sql="select t2.verifycode from umpay.T_VERIFYCODE_INF_2 t2 where t2.busitrace=(select t2.trace from umpay.T_PTRANS_"+getWeek()+" t2 where t2.orderid='"+orderId+"' order by t2.trace desc  fetch first 1 rows only)";
					list=(ArrayList<Map<String, String>>)AccountConst.dbquery2(sql);
					log.info(list.toString());
				}
			}
			
			try {
				log.info("查询结果如下："+list.get(0).toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.info("查询短信不存在");
			}
            if(!list.isEmpty()){
	         verify_code=list.get(0).toString().substring(12, list.get(0).toString().length()-3);
	         log.info("短信为："+verify_code);
            }else{
            	log.info("未获取到短信");
            }
			return verify_code;
		 
	}
	
	public static String queryOrderState(String orderId){

		ArrayList<Map<String, String>> list = null;
		//通过查询数据库�?�过trade_no 获取到trace号，之后在去短信表中查询
//		 String commonSqltradenoToTrace="select t2.trace from umpay.T_PTRANS_"+getWeek()+" t2 where t2.TRADENO='"+tradeNo+"'";
//		 trace=(ArrayList<Map<String, String>>)AccountConst.dbquery2(commonSqltradenoToTrace);
//		 
//		 System.out.println(trace);
//		 String traceNo = trace.get(0).toString().substring(7, trace.get(0).toString().length()-1);
		 		 
			String sql="select t2.transtate from umpay.T_PTRANS_"+getWeek()+" t2 where t2.orderid='"+orderId+"' ";
			
		    list=(ArrayList<Map<String, String>>)AccountConst.dbquery2(sql);	
		    log.info(list.toString());
		
			return list.toString();
		 
	}
	
	
	
	
	public static String querySms(String tradeNo){

		ArrayList<Map<String, String>> list = null;
		ArrayList<Map<String, String>> trace = null;
		 String verify_code = null;		
		//通过查询数据库�?�过trade_no 获取到trace号，之后在去短信表中查询
		 String commonSqltradenoToTrace="select t2.trace from umpay.T_PTRANS_"+getWeek()+" t2 where t2.TRADENO='"+tradeNo+"'";
		 trace=(ArrayList<Map<String, String>>)AccountConst.dbquery2(commonSqltradenoToTrace);
		 
		 System.out.println(trace);
		 String traceNo = trace.get(0).toString().substring(7, trace.get(0).toString().length()-1);
		 		 
		 String commonsql0 = "select t2.verifycode from umpay.T_VERIFYCODE_INF_0 t2 where t2.busitrace='"+ traceNo + "'" ;
			
		 list=(ArrayList<Map<String, String>>)AccountConst.dbquery2(commonsql0);			
			if(list.isEmpty()){
				String commonsql1 = "select t2.verifycode from umpay.T_VERIFYCODE_INF_1 t2 where t2.busitrace='"
					+ traceNo + "'"  ;
				
				list=(ArrayList<Map<String, String>>)AccountConst.dbquery2(commonsql1);
				System.out.println(list);
				if(list.isEmpty()){
					String commonsql2 = "select t2.verifycode from umpay.T_VERIFYCODE_INF_2 t2 where t2.busitrace='"
						+ traceNo + "'" ;
					list=(ArrayList<Map<String, String>>)AccountConst.dbquery2(commonsql2);
					System.out.println(list);
				}
			}
			
			System.out.println("查询结果如下："+list.get(0).toString());
            if(!list.isEmpty()){
	         verify_code=list.get(0).toString().substring(12, list.get(0).toString().length()-3);
	         System.out.println("短信为："+verify_code);
            }else{
            	System.out.println("未获取到短信");
            }
			return verify_code;
		 
	}

	public static int getWeek(){
		  Calendar cal = Calendar.getInstance();  
		     Date curDate = new Date(System.currentTimeMillis());  
		     cal.setTime(curDate);  
		     int w = cal.get(Calendar.DAY_OF_WEEK) - 1;  
		     if (w < 0)  
		         w = 0;
			return w;  
	}
	
	public static void main(String[] args) {
		GetSms sms = new GetSms();
		String SMS = sms.querySmsByOrderId("2323");
	
	}
}

