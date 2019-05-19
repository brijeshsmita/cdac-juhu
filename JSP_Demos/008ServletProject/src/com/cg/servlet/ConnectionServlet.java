package com.cg.servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
public class ConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataSource ds;
    private Connection con; 
    public ConnectionServlet() {
        super();
    }
    @Override
    public void init() throws ServletException {
	  try {
          // Get DataSource
          Context initContext  = new InitialContext();
          Context envContext  = 
        		  (Context)initContext.lookup("java:comp/env");
          ds = (DataSource)envContext.lookup("jdbc/testDs");        
          if(ds!=null)
          {
          	System.out.println("Datasource obtained...."+ds);
          	con=ds.getConnection();
          	if(con!=null){
          		System.out.println("Connection Obtained!! "+con);
          		ServletContext context= getServletContext();
          		context.setAttribute("appCon", con);
          	}
          }
      } catch (NamingException | SQLException e) {
          e.printStackTrace();
      }
   }//end of init
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
