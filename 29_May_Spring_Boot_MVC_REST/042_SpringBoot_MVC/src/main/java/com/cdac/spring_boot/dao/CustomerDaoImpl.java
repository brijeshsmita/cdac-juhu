/**
 * 
 */
package com.cdac.spring_boot.dao;

/**
 * @author Smita B Kumar
 *
 */
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdac.spring_boot.model.Customer;
 /*CustomerDaoImpl is SPring Bean 
  * which will have dao layer functionality
  * which will created and managed by spring conatiner*/
@Repository
public class CustomerDaoImpl implements ICustomerDao{
 
	@Autowired
	private SessionFactory sessionFactory;
 
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
 
	public List<Customer> getAllCustomers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Customer>  customerList = 
				session.createQuery("from Customer").list();
		return customerList;
	} 
	public Customer getCustomer(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Customer customer = (Customer) 
				session.get(Customer.class, id);
		return customer;
	}
 
	public Customer addCustomer(Customer customer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(customer);
		return customer;
	}
 
	public Customer updateCustomer(Customer customer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(customer);
		return customer;
	}
 
	public Customer deleteCustomer(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Customer customer = (Customer) 
				session.load(Customer.class, id);
		if (customer!=null) {
			session.delete(customer);
			customer=null;
		}
		return customer;
	} 
}
 