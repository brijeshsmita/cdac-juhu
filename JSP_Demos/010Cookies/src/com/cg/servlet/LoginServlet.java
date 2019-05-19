package com.cg.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public LoginServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String strUser=request.getParameter("username");
		String strPass=request.getParameter("password");		
		if(strUser.equals("123")&& strPass.equals("123")){
		getServletContext().getRequestDispatcher("/link.html")
			.include(request, response);
			out.println("You Are Successfully Logged In !!");
			out.println("<hr> Welcome , "+strUser);
		//create cookie
			Cookie ck = new Cookie("userCookie", strUser);
		//now adding the cookies to the response object
			response.addCookie(ck);
			out.println("<hr><h1> Welcome "+strUser);
		}else{
			out.println("<h2 style='color:red'>"
			+ "Sorry Boss, Username or Password error !!!"
			+ "<br>Kindly Re-Login</h2>");
			getServletContext().getRequestDispatcher("/login.html")
				.include(request, response);
		}
		out.close();
	}
}
