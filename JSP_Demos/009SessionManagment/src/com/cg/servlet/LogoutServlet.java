package com.cg.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		// set response contentType
		response.setContentType("text/html");
		// obtain write
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		// fetching the sessionScope var
		if (session != null) {
			session.invalidate();	
			//this will terminate the session on the spot
			out.println("<h1>You Have Successfully logged out!</form>");
		} else
			out.println("<h1>Session Already Expired</h1>");
		request.getRequestDispatcher("index.html")
				.include(request, response);
		out.close();
	}
}
