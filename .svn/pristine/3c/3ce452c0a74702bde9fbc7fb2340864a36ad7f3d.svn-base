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
import com.umpaytester.spayrest.java.FastTestWholeProcess;
import com.umpaytester.utils.JsonPrintToHtmlUtil;
import com.umpaytester.utils.log.Logger;

/**
 * Servlet implementation class QuikRefundServlet
 */
@WebServlet("/QuikRefundServlet")
public class QuikRefundServlet extends HttpServlet {
	static Logger log=Logger.getLogger(QuikRefundServlet.class);  

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuikRefundServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("接收Spayrest前端收银台下单请求");
		request.setCharacterEncoding("UTF-8") ;
		
		
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
        FastTestWholeProcess fastTest = new FastTestWholeProcess();
         try {
			fastTest.order(bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         try {
			fastTest.varify(bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         try {
			fastTest.getSms(bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         try {
			fastTest.pay(bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         try {
			fastTest.refund(bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         fastTest.queryRefund(bean);
//        log.info(jsonPint.formatJson(result));
//        JSONArray json = JSONArray.fromObject("["+result +"]")   ;     
        
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
//			 out.println(jsonPint.formatJson(result));
//			 if(json.size()>0){
//				  for(int i=0;i<json.size();i++){
//				    net.sf.json.JSONObject job = json.getJSONObject(i); 
//				    out.println("<tr>");// 遍历 jsonarray 数组，把每一个对象转成 json 对象
//				    out.println(job.get("name")+"=") ;  // 得到 每个对象中的属性值
//				    out.println("</tr>");
//				  }
//				}
//			 for (int i = 0; i < json.formatJson(result).length(); i++) {
//				
//			}
//			 
//			 json.formatJson(result)
//			 out.println(json.formatJson(result));
//			 out.println("</tr>");

//			 out.println();
//			 for (Entry<String, String> entry : result.entrySet()) {
//				 out.println("<tr>");
//				 out.println(" <td >"+entry.getKey()+"</td>");
//				 out.println(" <td >"+entry.getValue()+"</td></br>");
//				 out.println("</tr>");
//				 log.info(entry.getKey()+":"+entry.getValue());
//			 }
			
			
			 out.println("</table>");
			 out.println("</BODY>");
			
			out.println("</HTML>");
//			out.flush();
//			out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
