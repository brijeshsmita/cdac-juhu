package com.cg.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public LogoutServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		getServletContext()
			.getRequestDispatcher("/link.html")
			.include(request, response);
		Cookie ck = new Cookie("userCookie", "");
		ck.setMaxAge(0);//expire the cookie and hence session expires
		response.addCookie(ck);
		out.println("<hr>You Are Successfully Logged Out !!");
		out.close();
	}
}
