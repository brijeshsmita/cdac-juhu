package com.cdac.hibernate.client;

import java.util.List;

import com.cdac.hibernate.exception.CustomerException;
import com.cdac.hibernate.model.Customer;
import com.cdac.hibernate.service.CustomerService;
import com.cdac.hibernate.service.ICustomerService;

/**
 * @author Smita B Kumar
 *
 */
public class CustomerMain {

	/**
	 * prep work 1: declare obj of service interface
	 */
	private static ICustomerService customerService;
	
	// * prep work 2: create obj of service class
	static {
		customerService=new CustomerService();
	}
	public static void main(String[] args) throws CustomerException {
System.out.println("\n**************Adding the customer record**************");
Customer customer = new Customer("Smita", 
		"Smitabrijesh@gmail.com", "9879879879");
customerService.addCustomer(customer);
System.out.println("\n**************Retrieving the customer record By Id**************");
System.out.println("Customer Found : "
+customerService.getCustomerById(customer.getCustId()));
System.out.println("\n**************Updating the customer record**************");
customer.setCustName("Smita Kumar");
System.out.println("Customer Updated : "
+customerService.updateCustomer(customer));
System.out.println("\n**************Listing All the customer records-**************");
List<Customer> custList= customerService.listAllCustomer();
custList.forEach((cust1)->System.out.println(cust1));
System.out.println("\n**************Deleting the customer record**************");
System.out.println("Customer Deleted : "
+customerService.deleteCustomer(customer.getCustId()));
	}

}
