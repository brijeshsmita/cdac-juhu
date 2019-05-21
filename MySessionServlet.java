/**
 * 
 */
package com.cdac.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Smita B Kumar
 *
 */
public class MySessionServlet extends HttpServlet{

	public MySessionServlet() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		if(session!=null) {
			pw.println("<h1>"+session.getId()+"<h1>");
		}else {
			pw.println("<h1 style=color:red>Session Expired!!<h1>");
		}
		pw.println("<a href='index.jsp'>Home Page</a>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
