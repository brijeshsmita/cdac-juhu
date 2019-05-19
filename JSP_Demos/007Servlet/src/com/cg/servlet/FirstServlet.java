package com.cg.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstServlet extends GenericServlet {
	private static final long serialVersionUID = 5190311187202956641L;
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("Service()  method invoked for each request");		
	}	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println();
		System.out.println("init()  method invoked only once");
	}

	@Override
	public void destroy() {
		System.out.println("Destroy()  method invoked");
	}

	
}
