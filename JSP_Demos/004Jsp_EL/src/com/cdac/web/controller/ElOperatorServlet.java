package com.cdac.web.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ElOperatorServlet
 */
@WebServlet(
		urlPatterns = { "/ElOperatorServlet" }, 
		initParams = { 
				@WebInitParam(name = "dev", value = "Smita")
		})
public class ElOperatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ElOperatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String num="2"; Integer i = 3;
		int age=12;request.setAttribute("age", age);
		request.setAttribute("num", num);
		request.setAttribute("Integer", i);
		ArrayList list = new ArrayList<>();
		list.add(true);list.add(false);list.add("2");list.add("10");
		request.setAttribute("list",list);
		request.getRequestDispatcher("/elOperator.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
