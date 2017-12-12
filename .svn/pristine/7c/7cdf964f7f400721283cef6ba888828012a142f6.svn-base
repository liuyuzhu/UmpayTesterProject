package com.umpaytester.spay.util;

import java.lang.reflect.Field;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.umpaytester.spay.bean.SpayBean;
import com.umpaytester.spay.servlets.SpayCashierServlet;
import com.umpaytester.utils.log.Logger;

/**
 *作者：刘玉柱
 *日期：2017年11月14日
 *时间：上午10:29:22
 *该类的功能:
**/

public class SpayBeanSetData {
	static Logger log=Logger.getLogger(SpayBeanSetData.class);  

	public static void  setDataToBean(HttpServletRequest request,SpayBean bean) {
		log.info("开始从request中取值，并为bean对象赋值");
        Field[] field = bean.getClass().getDeclaredFields(); // 获取实体类的所有属性，返回Field数组  
        String content = ""; 

        Enumeration en = request.getParameterNames();  
		while(en.hasMoreElements()){  
            String el = en.nextElement().toString(); 
 		   log.info("||||"+el+"="+request.getParameter(el));  


	        for (int j = 0; j < field.length; j++) { // 遍历所有属性  
	        	  String name = field[j].getName(); 
	            		// 获取属性的名字 
	            if(name.equals(el)) {
		            try {
		            	field[j].setAccessible(true);
						field[j].set(name, request.getParameter(el));
						
						log.info("当前赋值对象为"+name+":对象值为："+ request.getParameter(el));
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

	            }
	            
	        } 
		   
		}  
		
		
		
	}
}


