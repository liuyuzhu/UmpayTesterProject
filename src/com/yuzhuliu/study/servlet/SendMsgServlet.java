package com.yuzhuliu.study.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendMsgServlet
 */
@WebServlet("/SendMsgServlet")
public class SendMsgServlet extends HttpServlet {
	 @Override
	    protected void service(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {

	    req.setCharacterEncoding("utf-8");
	    resp.setContentType("text/html;charset=utf-8");


	    String title = req.getParameter("title");
	    String content = req.getParameter("content");
	    Message msg = new Message();
	    msg.setTitle(title);
	    msg.setContent(content);

	    MessageDao msgDao = new MessageDao();

	    msgDao.insertMsg(msg);

	    PrintWriter out = resp.getWriter();

	    out.write("发送完毕!");

	    out.flush();

	    out.close();
	}

	}