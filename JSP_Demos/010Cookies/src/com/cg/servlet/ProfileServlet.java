package com.cg.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ProfileServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();		
		//getting the cookies
		Cookie ckArr[]=request.getCookies();
		String strName;
		if(ckArr!=null)
		{
			strName=ckArr[0].getValue();			
			if(!strName.equals("")||strName!=null){
				getServletContext()
					.getRequestDispatcher("/link.html")
						.include(request, response);
				out.println("<hr><h1>Welcome to Profile</h1>");
				out.println("<hr>User Name :"+strName);
			}//end of inner loop
		}
		else{
			String strUser = request.getParameter("username");
			out.println("<hr><h1>Please Login first!</h1>");
			getServletContext().getRequestDispatcher("/login.html")
				.include(request, response);
		}
	}
}
