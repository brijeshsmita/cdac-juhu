package com.cg.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
//step 1 :handle the request
		/*String strUser=request.getParameter("username");
		System.out.println("User name : "+strUser);*/
//step 2 : - set the contentType of response
		response.setContentType("text/html");
//step 3 : - getting the writer from the response object
		PrintWriter pw = response.getWriter();
//step 4 : - write the response
		String strUser=(String)getServletContext()
				.getAttribute("appUser");
		pw.write("<h1>Welcome ,"+strUser+" ! To the world of Servlet");
//step 5 : - close the writer
		pw.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
