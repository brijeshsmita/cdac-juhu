package com.cg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataSource ds;
	Connection con=null;
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	DataSource ds = (DataSource) 
				getServletContext().getAttribute("appds");		
		try {
			con=ds.getConnection();
			if(con!=null)
				System.out.println("Connection at servlet : "
			+con);
			else
				System.out.println("Connection failed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//step 1 :handle the request
				String strUser=request.getParameter("username");
				String strPass=request.getParameter("password");
				System.out.println("User name : "+strUser);
		//step 2 : - set the contentType of response
				response.setContentType("text/html");
		//step 3 : - getting the writer from the response object
				PrintWriter pw = response.getWriter();
		//authenticate the user
		String sql = 
"SELECT username,password FROM myuser WHERE username=?"
+ " AND password=?";
//step 4 : - write the response
pw.write("<h1>Login Servlet</h1>");
	RequestDispatcher rd=null;
	PreparedStatement ps=null;
	ResultSet rs=null;			
try {
	ps = con.prepareStatement(sql);
	ps.setString(1, strUser);
	ps.setString(2, strPass);
	rs = ps.executeQuery();
if (rs.next()) {		
	ServletContext application = getServletContext();
	//making strUser available through out the application
application.setAttribute("appUser", strUser);
rd=request.getRequestDispatcher("WelcomeServlet");
	rd.forward(request, response);
}else{
	rd=request.getRequestDispatcher("InvalidServlet");
	rd.include(request, response);
}
//step 5 : - close the writer
pw.close();
} catch (Exception e) {
	System.err.println(e.getMessage());
}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
