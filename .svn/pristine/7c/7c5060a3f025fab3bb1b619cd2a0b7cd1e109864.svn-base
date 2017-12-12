package com.umpaytester.spay.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.umpaytester.spay.bean.SpayBean;
import com.umpaytester.spay.java.FastPay;
import com.umpaytester.spay.test.DebitCardCbApplyPayShortcut;
import com.umpaytester.spay.test.DebitCardCbApplyPayShortcutUI;
import com.umpaytester.spayrest.java.SpayRestOrderApi;
import com.umpaytester.spayrest.java.SpayRestPayApi;
import com.umpaytester.spayrest.java.SpayRestQueryApi;
import com.umpaytester.spayrest.java.SpayRestRefundApi;
import com.umpaytester.spayrest.java.SpayRestRefundQueryApi;
import com.umpaytester.spayrest.java.SpayRestVarifyApi;
import com.umpaytester.utils.JsonPrintToHtmlUtil;
import com.umpaytester.utils.log.Logger;

/**
 * Servlet implementation class SpayCashierServlet
 */
@WebServlet("/FastPayServlet")
public class FastPayServlet extends HttpServlet {
	   public static  String result = ""	;
	static Logger log=Logger.getLogger(FastPayServlet.class);  
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FastPayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		log.info("接收前端收银台请求");
		request.setCharacterEncoding("UTF-8") ;
		
		
        SpayBean bean = new SpayBean();
        Enumeration<String> en = request.getParameterNames();  
        while(en.hasMoreElements()){  
        	String name = en.nextElement();
            String value = request.getParameter(name);
            try {
            	if(value.toString().contains("http")) {
            		value=java.net.URLDecoder.decode(value,"utf-8");
            	}
				BeanUtils.setProperty(bean, name, value);
				log.info(name+":"+value);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        log.info("将前端请求数据赋值给SpayBean,"+bean.toString());
        FastPay test = new FastPay();
        

        
         result = test.order(bean);
        printToPage(response, result,"下单结果");
        log.info(result);
        result="";
        result=test.varify(bean);
        printToPage(response, result,"下发短信结果");
        log.info(result);

        result="";

        result=test.pay(bean);
        printToPage(response, result,"订单支付结果");
        log.info(result);

        result="";
        

	}
        
        public void  printToPage(HttpServletResponse response,String result,String name) {
        	
        	result=result.substring(result.indexOf("CONTENT=\"")+9, result.lastIndexOf("/head"));
        response.setContentType("text/html; charset=UTF-8"); 
		response.setCharacterEncoding("UTF-8") ;
			PrintWriter out = null;
			try {
				out = response.getWriter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			response.getWriter().write(resMsg.replaceAll("<", "").replaceAll(">", ""));
			out.println("<HTML>");
			out.println("<HEAD><TITLE>返回结果为：</TITLE></HEAD>");
			out.println("<BODY>");
			 out.println("<table width=\"600\"  border=\"1\">");
			 out.println("<tr><td>");
			 out.println("</td></tr>");
			 out.println("<tr><td width=\"600\"  border=\"1\" style=\"background:white\">"+name+"</td></tr>");
			 out.println("<tr><td>");
				out.print(result.replaceAll("<", "").replaceAll(">", "<br />").replaceAll("&", "<br />"));
             out.print("</td></tr>");
			 out.println("</table>");
			 out.println("</BODY>");
			
			out.println("</HTML>");

			
        }	
			
			
			

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
