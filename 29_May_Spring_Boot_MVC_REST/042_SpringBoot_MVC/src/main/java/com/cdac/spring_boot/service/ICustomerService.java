/**
 * 
 */
package com.cdac.spring_boot.service;

import java.util.List;

import com.cdac.spring_boot.model.Customer;

/**
 * @author Smita B Kumar
 *
 */
public interface ICustomerService {
	public List<Customer> getAllCustomers();
	public Customer getCustomer(int id);
	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public Customer deleteCustomer(int id);
}
