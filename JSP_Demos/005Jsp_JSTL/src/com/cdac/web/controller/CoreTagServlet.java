package com.cdac.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.web.model.Product;
import com.cdac.web.service.IProductService;
import com.cdac.web.service.ProductService;

/**
 * Servlet implementation class CoreTagServlet
 */
@WebServlet(
		urlPatterns = { "/CoreTagServlet" }, 
		initParams = { 
				@WebInitParam(name = "dev", value = "Smita")
		})
public class CoreTagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private IProductService productService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoreTagServlet() {
        super();
       productService= new ProductService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//call the service to get the productList from dao
		List<Product> productList=productService.getProductList();
		System.out.println("List of Product : "+productList);
		//adding the productList to the request scope
		request.setAttribute("productList", productList);
		//name of the object in requestScope, actula object
		//forwarding the request to the jsp page
		request.getRequestDispatcher("/coreTag.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
