package com.umpaytester.plat2cbe;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.umpaytester.utils.log.Logger;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class BF221016
 */
@WebServlet("/BF221016")
public class BF221016 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(BF221016.class);

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BF221016() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("接收前端执行BF221016访问请求");
		request.setCharacterEncoding("UTF-8") ;

			String url =request.getParameter("url") ;
			url=java.net.URLDecoder.decode(url,"GBK");
			String rpid = java.net.URLDecoder.decode(request.getParameter("rpid"),"GBK");
			String handleDate =  java.net.URLDecoder.decode(request.getParameter("handleDate"),"GBK");
			String threshold =  java.net.URLDecoder.decode(request.getParameter("threshold"),"GBK");
			log.info(url+ rpid+handleDate+threshold);
			JSONObject obj = new JSONObject();
			   obj.element("rpid", rpid);
		        obj.element("handleDate", handleDate);
		        obj.element("threshold", threshold);
//		        obj.element("accessType", "W");

		       @SuppressWarnings("unused")
			ArrayList<String> result=post(url, obj);
			log.info(result.toString());
			 response.setContentType("text/html; charset=UTF-8"); 
				response.setCharacterEncoding("UTF-8") ;
				PrintWriter out =  response.getWriter();
//				response.getWriter().write(resMsg.replaceAll("<", "").replaceAll(">", ""));
				out.println("<HTML>");
				out.println("<HEAD><TITLE>返回结果为：</TITLE></HEAD>");
				out.println("<BODY>");
//				 out.println(" 返回结果：");
				 
				for(int i = 0 ; i < result.size() ; i++) {


					 if(result.get(i).contains("<retCode>")) {
						out.println("retCode:"+result.get(i)+"</br>");
					}
					else if(result.get(i).contains("<funCode>")) {
						out.println("funCode:"+result.get(i)+"</br>");
					}
					else if(result.get(i).contains("<Memo>")) {
						out.println("Memo:"+result.get(i)+"</br>");
					}
					else if(result.get(i).contains(" <retMsg>")) {
						out.println("retMsg:"+result.get(i) +"</br>");
					}
			
					else {
						out.println(result.get(i)+"</br>");
					}
					
					
					
//					out.println("<tr>"+result.get(i).toString()+"</tr>");
//					out.println("<tr>sdfsdf</tr>");
					}
//				
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

	
	public static ArrayList<String> post(String urls,JSONObject obj) throws IOException {
		URL url = new URL(urls);
        HttpURLConnection connection = (HttpURLConnection) url
                .openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("POST");
        connection.setUseCaches(false);
        connection.setInstanceFollowRedirects(true);
        connection.setRequestProperty("Content-Type","application/json");
       
        connection.connect();
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        try {
			out.writeBytes(obj.toString());
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        ArrayList<String> list = new ArrayList<String>();

        try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
			        connection.getInputStream()));
			String lines;
			while ((lines = reader.readLine()) != null) {
			    lines = new String(lines.getBytes(), "UTF-8");
			    list.add(lines);
			    log.info(lines);
			}
			reader.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        connection.disconnect();
		return list;
	}
}
