package com.cg.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
public class LogFilter implements Filter {
    public LogFilter() {
        System.out.println("LogFilter created");
    }
	public void destroy() {
		 System.out.println("LogFilter destroyed");		 
	}
	public void doFilter(ServletRequest request, 
			ServletResponse response, 
			FilterChain chain) throws IOException, 
			ServletException {
HttpServletRequest req =(HttpServletRequest)request;
String ipAddres=req.getRemoteAddr();
System.out.println("IP "+ipAddres+ ", Time"
				+new Date().toString());
	System.out.println("LogFilter intercepting request ");
		chain.doFilter(request, response);
	System.out.println("LogFilter filtering response");
	}
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("LogFilter initialized");
		String strDev= fConfig.getInitParameter("dev");		
		System.out.println("Develeoped by : "+strDev);
	}

}
