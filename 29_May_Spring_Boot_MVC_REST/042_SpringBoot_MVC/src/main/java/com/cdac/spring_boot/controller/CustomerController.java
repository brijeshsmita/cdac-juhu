/**
 * 
 */
package com.cdac.spring_boot.controller;

/**
 * @author Smita B Kumar
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cdac.spring_boot.model.Customer;
import com.cdac.spring_boot.service.ICustomerService;
 //step 1: create controller class and annotate with @Controller
//spring will create controller bean
//and manage it with the additional functionalities of a controller
@Controller
public class CustomerController {
 //step 2:dependency injection of service with @Autowired annotated
	@Autowired
	ICustomerService customerService;
//step 3 : create request handler methods and annotate with 
	//@RequestMapping
	@RequestMapping(value = "/getAllCustomers", 
			method = RequestMethod.GET,
			headers = "Accept=application/json")
	public String getAllCustomers(Model model) {
//step 4: call service method to execute request 
		List<Customer> listOfCustomers = 
				customerService.getAllCustomers();
		model.addAttribute("customer", new Customer());
		model.addAttribute("listOfCustomers", listOfCustomers);
		return "customerDetails";//viewName
	}
 
	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
	public String goToHomePage() {
		return "redirect:/getAllCustomers";
	}
	
	@RequestMapping(value = "/getCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Customer getCustomerById(@PathVariable int id) {
		return customerService.getCustomer(id);
	}
 
	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addCustomer(@ModelAttribute("customer") Customer customer) {	
		if(customer.getId()==0)
		{
			customerService.addCustomer(customer);
		}
		else
		{	
			customerService.updateCustomer(customer);
		}
 
		return "redirect:/getAllCustomers";
	}
 
	@RequestMapping(value = "/updateCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateCustomer(@PathVariable("id") int id,Model model) {
		model.addAttribute("customer", this.customerService.getCustomer(id));
		model.addAttribute("listOfCustomers", this.customerService.getAllCustomers());
		return "customerDetails";
	}
 
	@RequestMapping(value = "/deleteCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteCustomer(@PathVariable("id") int id) {
		customerService.deleteCustomer(id);
		return "redirect:/getAllCustomers";
 
	}	
}
