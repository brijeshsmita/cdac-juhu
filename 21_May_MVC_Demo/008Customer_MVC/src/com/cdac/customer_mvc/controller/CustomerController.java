package com.cdac.customer_mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdac.customer_mvc.model.Customer;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private List<Customer> customerList=new ArrayList<Customer>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//step 1 &2: fetch req param		
	//step 2:create customer obj&store req param in it
		
		Customer customer = new Customer();
		customer.setFirstName(request.getParameter("firstName"));
		customer.setLastName(request.getParameter("lastName"));
		customer.setMobileNo(request.getParameter("mobileNo"));
		customer.setEmail(request.getParameter("email"));
		//create the list and add the customer to the list
		//customerList=new ArrayList<Customer>();
		customerList.add(customer);
		
		//make the list available at the session Scope
		HttpSession session = request.getSession();
		session.setAttribute("customerList", customerList);
		//step 3 -> call service to add the customer  
		//(do it later)
		
		//Step 4: once the customer added now add it to the
		//requestScope and forward to the jsp Page to show
		//the added customer record
		//setAttribute(String name,Object customerObject)
		request.setAttribute("customer", customer);
		
//step 5: forward to specific jsp to show the customer record
			RequestDispatcher rd = null;
		//if(customer!=null) {
			//rd=request.getRequestDispatcher("AddCustomerSuccess.jsp");
			rd=request.getRequestDispatcher("CustomerList.jsp");
			rd.forward(request, response);
		//}
			/*else {
			rd=request.getRequestDispatcher("AddCustomerPage.jsp");
			rd.include(request, response);
		}*/
		//doGet(request, response);
	}

}
