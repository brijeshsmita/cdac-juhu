/**
 * 
 */
package com.cdac.hibernate.service;

import java.util.List;

import com.cdac.hibernate.dao.CustomerDao;
import com.cdac.hibernate.dao.ICustomerDao;
import com.cdac.hibernate.exception.CustomerException;
import com.cdac.hibernate.model.Customer;

/**
 * @author Smita B Kumar
 *
 */
public class CustomerService implements ICustomerService {

	/**
	 * prepwork 1: declare ICustomerDao Object
	 */
	private ICustomerDao customerDao;
	
	//prepWork 2: create the Object of CustomerDao in the constructor
	public CustomerService() {
		customerDao= new CustomerDao();
	}

	/* (non-Javadoc)
	 * @see com.cdac.hibernate.service.ICustomerService#addCustomer(com.cdac.hibernate.model.Customer)
	 */
	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {
		customerDao.beginTx();
		Customer addedCustomer= customerDao.addCustomer(customer);
		customerDao.commitTx();
		return addedCustomer;
	}

	/* (non-Javadoc)
	 * @see com.cdac.hibernate.service.ICustomerService#getCustomerById(java.lang.Integer)
	 */
	@Override
	public Customer getCustomerById(Integer custId) throws CustomerException {
		return customerDao.getCustomerById(custId);
	}
	/* (non-Javadoc)
	 * @see com.cdac.hibernate.service.ICustomerService#UpdateCustomerById(com.cdac.hibernate.model.Customer)
	 */
	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
		customerDao.beginTx();
		Customer updatedCustomer= customerDao.updateCustomer(customer);
		customerDao.commitTx();
		return updatedCustomer;
	}
	/* (non-Javadoc)
	 * @see com.cdac.hibernate.service.ICustomerService#deleteCustomer(java.lang.Integer)
	 */
	@Override
	public Customer deleteCustomer(Integer custId) throws CustomerException {
		customerDao.beginTx();
		Customer deletedCustomer= customerDao.deleteCustomer(custId);
		customerDao.commitTx();
		return deletedCustomer;
	}
	/* (non-Javadoc)
	 * @see com.cdac.hibernate.service.ICustomerService#listAllCustomer()
	 */
	@Override
	public List<Customer> listAllCustomer() throws CustomerException {
		return customerDao.listAllCustomer();
	}

}
