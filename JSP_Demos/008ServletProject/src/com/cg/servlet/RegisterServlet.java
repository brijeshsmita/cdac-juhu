package com.cg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
	/*	String fname= request.getParameter("firstname");*/
		Enumeration<String> parameterNames 
		= request.getParameterNames();
		String strDev= 
		getServletContext().getInitParameter("developer");
		ServletConfig config=getServletConfig();
		String strProg=config.getInitParameter("programmer");
		request	.getRequestDispatcher("/login.html")
		.include(request, response);
		out.println("</table>");
		
		out.println("<h2 style='text-align:center;'>"
				+ "User Information-Devloped by "+strDev
				+ " And Servlet Programmer is : "+strProg
				+"</h2>");
		out.println("<table align='center' border=2>");
		while(parameterNames.hasMoreElements()){
			String paraName=parameterNames.nextElement();
			out.println("<tr><td>"+paraName.toUpperCase()
					+"</td><td>");			
			String [] paraValues=
					request.getParameterValues(paraName);
			for(int i=0;i<paraValues.length;i++){
				String paraValue=paraValues[i];
				out.println(paraValue.toUpperCase()+",");				
			}
			out.println("</td></tr>");
		}
		
	}
}
