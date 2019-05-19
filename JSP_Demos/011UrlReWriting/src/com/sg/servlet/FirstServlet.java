package com.sg.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String strUser = request.getParameter("username");
//append the username tom the url	
		HttpSession session = request.getSession();
		out.println("<hr><INPUT TYPE='HIDDEN' "
				+ "NAME='hiddenSession' value='"+session.getId()+"'>"
				+ "<h1> Welcome "+strUser);
		out.println("<a href='SecondServlet?username="
				+strUser+"'>Visit</a>");
/*String encodeUrl=
	response.encodeRedirectUrl("SecondServlet?username="
				+strUser);

	response.sendRedirect(encodeUrl);*/
		out.close();
	}
}
