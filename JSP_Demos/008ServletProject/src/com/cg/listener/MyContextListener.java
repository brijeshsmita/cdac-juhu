package com.cg.listener;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

public class MyContextListener implements ServletContextListener {
	private DataSource ds;	
	public void contextInitialized(ServletContextEvent event) {		
		Context initContext=null;
		try {
			//java jndi context
			initContext = new InitialContext();
			Context envContext = 
			(Context) initContext.lookup("java:comp/env");
			//datasource jndi context
		ds = (DataSource) envContext.lookup("jdbc/empds");
			if (ds != null) {
			System.out.println("Datasource obtained...." + ds);
				//making the datasource available at application scope
			event.getServletContext().setAttribute("appds", ds);
			}
			else
				System.out.println("Datasource NOT obtained....");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}//end of method

	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("Servlet Context Destroyed");
	}
}
