/**
 * 
 */
package com.hibernate.client;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Customer;

import oracle.net.aso.q;

/**
 * @author brije
 *
 */
public class HibernateQuery {
	static final String SELECT_ALL_CUSTOMER = "from Customer";
	static final String SELECT_CUSTOMER_BY_NAME = "from Customer c where c.custName =:custName";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;

		try {
			// HQL focus on CLASS AND its Property as its Object Query Language
			// hql queries are not case -sensitive only the class and property name
			// fetch all the records from the customer table
			System.out.println("*************List Of All The Customers*****************");
			List<Customer> custList = session.createQuery(SELECT_ALL_CUSTOMER).list();			
			for (Customer c : custList)
				System.out.println(c);

			System.out.println("*************Customers by customer name*****************");
			Query query = session.createQuery(SELECT_CUSTOMER_BY_NAME);
			// set the parameter for the query =:
			query.setParameter("custName", "yoyo");
			// lets get the query result
			List c1 = query.list();
			System.out.println("Customer Record with name Yoyo " + c1);
			// lets update the customer with hql
			transaction=session.beginTransaction();
			query = session.createQuery("update Customer c set custName =:name where custId =:id ");
			query.setParameter("name", "MODI");
			query.setParameter("id", new Long(7));
			//for dml(insert,update,delete) we have a method executeUpdate()
			query.executeUpdate();
			transaction.commit();
			System.out.println("Updated Record :"+session.get(Customer.class,new Long(7)));
	//pagination		
			System.out.println("*************List Of first 2 Customers records*****************");
			query = session.createQuery(SELECT_ALL_CUSTOMER);		
			query.setMaxResults(2);
			custList =query.list();
			for (Customer c : custList)
				System.out.println(c);
			
			System.out.println("*************List Of 3rd and 4th Customers records*****************");
			query = session.createQuery(SELECT_ALL_CUSTOMER);
			query.setFirstResult(2);
			query.setMaxResults(2);
			custList =query.list();
			for (Customer c : custList)
				System.out.println(c);
	//unique result
			String hql = "from Customer where custName=:custName";
			query = session.createQuery(hql);
			query.setParameter("custName", "Shiv");
			query.setMaxResults(1);
			Customer cust = (Customer) query.uniqueResult();
			System.out.println("unique customer result :"+cust);

		} catch (Exception ex) {
			ex.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		} finally {
			if (session != null)
				session.close();
			if (factory != null)
				factory.close();

		}
	}
}
