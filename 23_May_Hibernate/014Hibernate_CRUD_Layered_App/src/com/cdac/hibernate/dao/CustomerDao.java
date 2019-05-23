/**
 * 
 */
package com.cdac.hibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.cdac.hibernate.exception.CustomerException;
import com.cdac.hibernate.model.Customer;

/**
 * @author Smita B Kumar
 *
 */
public class CustomerDao implements ICustomerDao {
	 private SessionFactory sessionFactory;
	 private Session session;
	 private Transaction transaction;
	 private Query query;
	/**prepWork in hibernate Dao declare followinf objects
	 * SessionFactory
	 * Session
	 * Transaction
	 * Query
	 */
	 //prep-work 2 : configure and build sessionFactory object
	 //in constructor
	 //prep-work 3 : get Session object from factory in constructor
	public CustomerDao() {
		sessionFactory = new Configuration()
				.configure().buildSessionFactory();
		session=sessionFactory.openSession();
	}

	/* (non-Javadoc)
	 * @see com.cdac.hibernate.dao.ICustomerDao#addCustomer(com.cdac.hibernate.model.Customer)
	 */
	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {
		session.save(customer);
		return customer;
	}

	/* (non-Javadoc)
	 * @see com.cdac.hibernate.dao.ICustomerDao#getCustomerById(java.lang.Integer)
	 */
	@Override
	public Customer getCustomerById(Integer custId) throws CustomerException {
		return (Customer) session.get(Customer.class, custId);
	}

	/* (non-Javadoc)
	 * @see com.cdac.hibernate.dao.ICustomerDao#UpdateCustomerById(com.cdac.hibernate.model.Customer)
	 */
	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
		session.update(customer);
		return customer;
	}

	/* (non-Javadoc)
	 * @see com.cdac.hibernate.dao.ICustomerDao#deleteCustomer(java.lang.Integer)
	 */
	@Override
	public Customer deleteCustomer(Integer custId) throws CustomerException {
		Customer customer=getCustomerById(custId);
		if(customer!=null)
			session.delete(customer);
		else
			customer=null;
		return customer;
	}

	/* (non-Javadoc)
	 * @see com.cdac.hibernate.dao.ICustomerDao#listAllCustomer()
	 */
	@Override
	public List<Customer> listAllCustomer() throws CustomerException {
		/*query = session.createQuery("from Customer");
		return query.list();*/
		return session.createQuery("from Customer").list();
	}
//transaction will come into action at service layer
	@Override
	public Transaction beginTx() throws CustomerException {
		transaction=session.beginTransaction();
		return transaction;
	}

	@Override
	public void commitTx() throws CustomerException {
		transaction.commit();
	}

}
