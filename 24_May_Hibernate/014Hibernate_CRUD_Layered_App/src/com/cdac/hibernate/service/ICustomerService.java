/**
 * 
 */
package com.cdac.hibernate.service;

import java.util.List;

import com.cdac.hibernate.exception.CustomerException;
import com.cdac.hibernate.model.Customer;

/**
 * @author Smita B Kumar
 *
 */
public interface ICustomerService {
	public Customer addCustomer(Customer customer)throws CustomerException;
	public Customer getCustomerById(Integer custId)throws CustomerException;
	public Customer updateCustomer(Customer customer)throws CustomerException;
	public Customer deleteCustomer(Integer custId)throws CustomerException;
	public List<Customer> listAllCustomer()throws CustomerException;

}
