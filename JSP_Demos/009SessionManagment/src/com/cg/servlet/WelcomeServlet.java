package com.cg.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//set response contentType
		response.setContentType("text/html");
	//obtain write
		PrintWriter out = response.getWriter();		
		HttpSession session= request.getSession(false);
	// fetching the sessionScope var
		if(session!=null)	{			 
			String strUser=
			(String)session.getAttribute("sessionUser");
			out.println("<h1>Welcome ,"+strUser+"</h1>");
			out.println("<hr><form action='LogoutServlet'>"
				+ "<input type='submit' value='Logout'></form>");
		}else
			out.println("<h1>Session Expired</h1>");
		
		out.close();
	}

}
