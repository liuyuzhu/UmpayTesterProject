package com.umpaytester.spayrest.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.umpaytester.spayrest.bean.SpayRestBean;
import com.umpaytester.spayrest.java.SpayRestOrderApi;
import com.umpaytester.spayrest.java.SpayRestPayApi;
import com.umpaytester.spayrest.java.SpayRestQueryApi;
import com.umpaytester.spayrest.java.SpayRestRefundApi;
import com.umpaytester.spayrest.java.SpayRestRefundQueryApi;
import com.umpaytester.spayrest.java.SpayRestVarifyApi;
import com.umpaytester.utils.JsonPrintToHtmlUtil;
import com.umpaytester.utils.JsonPrintUtil;
import com.umpaytester.utils.log.Logger;

/**
 * Servlet implementation class SpayRestOrderApi
 */
@WebServlet("/RefundQueryServlet")
public class RefundQueryServlet extends HttpServlet {
   public static  String result = ""	;
	static Logger log=Logger.getLogger(RefundQueryServlet.class);  

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RefundQueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("接收Spayrest前端收银台下单请求");
		request.setCharacterEncoding("UTF-8") ;
		JsonPrintUtil pr=new JsonPrintUtil();
		
		
        SpayRestBean bean = new SpayRestBean();
       
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
        bean.init();
        SpayRestOrderApi sroa = new SpayRestOrderApi();
        result= sroa.order(bean);
        pr.formatJson(result);
        printToPage(response, result,"下单结果");
        result="";
        SpayRestVarifyApi srva = new SpayRestVarifyApi();
        result=srva.verify(bean);
        pr.formatJson(result);
        printToPage(response, result,"下发短信结果");
        result="";

        SpayRestPayApi srpa = new SpayRestPayApi();
        result=srpa.pay(bean);
        pr.formatJson(result);
        printToPage(response, result,"订单支付结果");
        result="";
        
        SpayRestQueryApi srqa = new SpayRestQueryApi();
        result=srqa.query(bean);
        pr.formatJson(result);
        printToPage(response, result,"订单查询结果");
        result="";
        
        
        SpayRestRefundApi srra = new SpayRestRefundApi();
        result= srra.refund(bean);
        pr.formatJson(result);
        printToPage(response, result,"订单退费结果");
        result="";

        SpayRestRefundQueryApi srrqa = new SpayRestRefundQueryApi();
        result=srrqa.refundQuery(bean);
        pr.formatJson(result);
        printToPage(response, result,"订单退费查询结果");
        
	}
        
        public void  printToPage(HttpServletResponse response,String result,String name) {
        	
        	JsonPrintToHtmlUtil jsonPint=new JsonPrintToHtmlUtil();
       
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
			 out.println(jsonPint.formatJson(result));
			 out.println("</td></tr>");
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
