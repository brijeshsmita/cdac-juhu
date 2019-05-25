/**
 * 
 */
package com.cdac.hibernate.dao;

import java.util.List;

import org.hibernate.Transaction;

import com.cdac.hibernate.exception.CustomerException;
import com.cdac.hibernate.model.Customer;

/**
 * @author Smita B Kumar
 *
 */
public interface ICustomerDao {
	public Customer addCustomer(Customer customer)throws CustomerException;
	public Customer getCustomerById(Integer custId)throws CustomerException;
	public Customer updateCustomer(Customer customer)throws CustomerException;
	public Customer deleteCustomer(Integer custId)throws CustomerException;
	public List<Customer> listAllCustomer()throws CustomerException;
	public Transaction beginTx()throws CustomerException;
	public void commitTx()throws CustomerException;
}
