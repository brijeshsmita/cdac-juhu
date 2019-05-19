package com.cg.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InvalidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
//step 2 : - set the contentType of response
		response.setContentType("text/html");
//step 3 : - getting the writer from the response object
		PrintWriter pw = response.getWriter();
//step 4 : - write the response
	pw.write("<h1 style='color:red'>Invalid User</h1>");
//step 5 : - close the writer
		pw.close();
	}

}
