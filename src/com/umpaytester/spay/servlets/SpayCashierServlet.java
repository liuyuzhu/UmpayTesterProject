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
import com.umpaytester.spay.test.DebitCardCbApplyPayShortcut;
import com.umpaytester.spay.test.DebitCardCbApplyPayShortcutUI;
import com.umpaytester.utils.log.Logger;

/**
 * Servlet implementation class SpayCashierServlet
 */
@WebServlet("/SpayCashierServlet")
public class SpayCashierServlet extends HttpServlet {

	static Logger log=Logger.getLogger(SpayCashierServlet.class);  
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpayCashierServlet() {
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
        
        DebitCardCbApplyPayShortcut test = new DebitCardCbApplyPayShortcut();
        String resMsg=test.test()	;
        resMsg=resMsg.replaceAll("<", "").replaceAll(">", "");

      log.info(bean.getOrder_id());
//		System.out.println("=====================================");  
//		response.getWriter().append("Served at: "+resMsg).append(request.getContextPath()+resMsg);
//		System.out.println("");
      DebitCardCbApplyPayShortcutUI ui = new DebitCardCbApplyPayShortcutUI();
      HashMap<String, String> result = ui.test(resMsg, bean.getOrder_id());
      result.put("订单总金额", request.getParameter("amount"));
      result.put("币种", request.getParameter("currency"));
      result.put("子订单1", request.getParameter("sub_order_id1"));
      result.put("子订单1金额", request.getParameter("sub_order_amt1"));
      result.put("子订单2", request.getParameter("sub_order_id2"));
      result.put("子订单2金额", request.getParameter("sub_order_amt2"));
//      response.sendRedirect(resMsg);
		response.setContentType("text/html; charset=UTF-8"); 
		response.setCharacterEncoding("UTF-8") ;
			PrintWriter out =  response.getWriter();
//			response.getWriter().write(resMsg.replaceAll("<", "").replaceAll(">", ""));
			out.println("<HTML>");
			out.println("<HEAD><TITLE>返回结果为：</TITLE></HEAD>");
			out.println("<BODY>");
			 out.println(" 返回结果：");
			 out.println("<table width=\"600\"  border=\"1\">");
			 out.println("<tr>");
			 out.println(" <td colspan=\"2\">支付订单详细结果如下：</td></br>");
			 out.println("</tr>");
			 for (Entry<String, String> entry : result.entrySet()) {
				 out.println("<tr>");
				 out.println(" <td >"+entry.getKey()+"</td>");
				 out.println(" <td >"+entry.getValue()+"</td></br>");
				 out.println("</tr>");
				 log.info(entry.getKey()+":"+entry.getValue());
			 }
			 
		

			
			 out.println("</table>");
			 out.println("</BODY>");
			
			out.println("</HTML>");
//			out.flush();
//			out.close();
//			
			
//			response.getWriter().println(resMsg);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
