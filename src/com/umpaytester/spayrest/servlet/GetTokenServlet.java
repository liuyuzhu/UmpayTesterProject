package com.umpaytester.spayrest.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.umpaytester.spayrest.bean.GetSpayRestToken;
import com.umpaytester.utils.log.Logger;

/**
 * Servlet implementation class GetToken
 */
@WebServlet("/GetTokenServlet")
public class GetTokenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log=Logger.getLogger(GetTokenServlet.class);  
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTokenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		log.info("接收前端获取token请求");
		request.setCharacterEncoding("UTF-8") ;
		GetSpayRestToken getToken  = new GetSpayRestToken();
		getToken.setUrl(java.net.URLDecoder.decode(request.getParameter("url"),"utf-8"));
//		getToken.setUrl(request.getParameter("url"));
		getToken.setMer_id(request.getParameter("mer_id"));
		getToken.setClient_id(request.getParameter("client_id"));
		getToken.setClient_secret(request.getParameter("client_secret"));
		getToken.setScope(request.getParameter("scope"));
//		getToken.setUrl(request.getParameter("grant_type"));
		log.info(request.getParameter("url"));
		log.info(request.getParameter("mer_id"));
		log.info(request.getParameter("client_id"));
		log.info(request.getParameter("client_secret"));
		log.info(request.getParameter("scope"));
//		log.info(request.getParameter("grant_type"));
		String token =getToken.getToken();

		
//		log.info("将前端请求数据赋值给SpayBean,"+bean.toString());
        
    
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
			 out.println(" <td colspan=\"2\">获取token如下："+token+"</td></br>");
			 out.println("</tr>");
			 out.println("<tr>");
			 out.println(" <td colspan=\"2\">token已存储,有效期为1小时,如何失效请及时更新</td></br>");
			 out.println("</tr>");
			 out.println();
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
