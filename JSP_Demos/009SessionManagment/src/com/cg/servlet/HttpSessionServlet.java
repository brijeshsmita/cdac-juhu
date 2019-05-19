package com.cg.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class HttpSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// handle request
		String strUser=request.getParameter("username");
	//set response contentType
		response.setContentType("text/html");
	//obtain write
		PrintWriter out = response.getWriter();
		out.println("<p style='font-size:30px'>Welcome "+strUser);
		HttpSession session;
	//start session-1st way
		 session= request.getSession();//by default-true
//making username available throught out the sessionScope
		 session.setAttribute("sessionUser", strUser);
	//start session-2nd way
		//session=request.getSession(true);		
		/*return the current session if session exists,
		 *or create a new session
		 */
	//start session-3rd way
		//session=request.getSession(false);
		/*return the current session if session exists,
		 *  or return null
		 */
		/*Session refers to all the  request that a single 
		 * make to a server  */
		if(session!=null)	{	
		 out.println("<hr>Session is New ? "+session.isNew());
		 out.println("<hr>Session Id is : "+session.getId());
		 out.println("<hr>Session created at  : "
				 +session.getCreationTime());
		 out.println("<hr>Last Accessed at  : "
				 +session.getLastAccessedTime());
		 out.println("<hr>Terminating Session  : ");
			//session.setMaxInactiveInterval(10);//10 seconds
	
		}else
			out.println("<hr>Session Expired</p>");
		response.sendRedirect("WelcomeServlet");
		/*request.getRequestDispatcher("WelcomeServlet")
					.forward(request, response);*/
		/*
		 * 
		 */
		//session.setMaxInactiveInterval(30*60*60);//30 mins
		//programmatic setting or session time out		
		//session.invalidate();	
		//this will terminate the session on the spot
		
	}
}
