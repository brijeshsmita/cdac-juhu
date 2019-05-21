package com.cdac.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdac.mvc.exception.UserException;
import com.cdac.mvc.model.User;
import com.cdac.mvc.service.IUserService;
import com.cdac.mvc.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(
		urlPatterns = { "/LoginServlet" }, 
		initParams = { 
				@WebInitParam(name = "dev", value = "Smita")
		})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     //prep work -> Object of Service class
	IUserService userService = new UserService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//1.get the request parameters
		String strUser= request.getParameter("username");
		String strPass= request.getParameter("password");
		//2.create the Object
		User user = new User();
		//3. set the req parameter to the object
		user.setUsername(strUser);
		user.setPassword(strPass);
		//4. call the service and collect the results
		User resultUser=null;
		try {
			 resultUser = userService.login(user);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//5.redirect the response to the specific page
		RequestDispatcher rd = null;
		if(resultUser!=null) {
			//maintaining the valid user in application scope
			HttpSession session = request.getSession();
			session
			.setAttribute("appUser", resultUser);
			rd= 
			request.getRequestDispatcher("loginSuccess.jsp");
			rd.forward(request, response);
		}else {
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			pw.println("<h2 style='color:red'>Invalid Login !</h2>");
			rd= 
			request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
		//according to the results by the service
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
