package com.cg.servlet;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class MyFirstServlet extends HttpServlet{
	private static final long serialVersionUID = 625713305683438996L;
	public MyFirstServlet() {
		System.out.println("constructor invoked");
	}
	/*@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("Service()  method invoked for each request");
		doGet(arg0, arg1);
	}	*/
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doGet(req, resp);
		System.out.println("doGet()  method invoked");
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		System.out.println("init(ServletConfig config)  method invoked only once");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("init()  method invoked only once");
	}
	@Override
	public void destroy() {
		System.out.println("Destroy()  method invoked");
	}
}
