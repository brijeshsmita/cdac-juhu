package com.cg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public RequestParamServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String strUser = request.getParameter("username");
		Calendar calendar = Calendar.getInstance();
		int hour=calendar.get(Calendar.HOUR_OF_DAY);
		String greeting="";
		if(hour>=4 && hour<12)
			greeting="Good Morning!!";
		else if(hour>=12 && hour<16)
			greeting="Good Noon!!";
		else if(hour>16 && hour<=20)
			greeting="Good Evening!!";
		else 
			greeting="Good Night!!";
		out.println("<body bgcolor='cyan'><hr><h1> "
					+greeting+" "+strUser);
		int hours=calendar.get(Calendar.HOUR);
		int mins=calendar.get(Calendar.MINUTE);
		int sec=calendar.get(Calendar.SECOND);
		int am_pm = calendar.get(Calendar.AM_PM);
		String str1="";
		if(am_pm==0)
			str1="AM";
		else
			str1="PM";
		out.println("<hr><h2> "+"Time Is "+hours+":"+mins+":"
							+sec+" "+str1);
		out.println("</h2></body>");
		out.close();
	}
	/*Filters are java class that can be used in Servlet Programming
	 * for intercepting the request from a client before they access
	 * a resource. and also filters manipulate the response
	 * from the server before they are sent back to the client
	 * 
	 */
}
