package com.hibernate.customer.client;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.customer.model.Customer;

public class NativeSQL {
/*, Hibernate does provide a way to use native SQL statements directly through Hibernate.
 *  One reason to use native SQL is that your database supports some special features through its dialect of SQL that are not supported in HQL. 
 * Another reason is that you may want to call stored procedures from your Hibernate application.
 */
	public static void main(String[] args) {

		// Customer customer = new Customer(1111, "Shiv", "shiv@g.com",
		// "9879879666");
		// created a customer object
		String custName="Smita";
		Customer customer = new Customer("Nysha", "nysha@g.com", "9879879876");
		// Customer is in Transient state, as it is not associated with db or
		// session object

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		// step 1 : session Factory
		Session session = null;

		Transaction transaction = null;
		try {
			session = factory.openSession();
			System.out.println("\n************Listing all Customer Records *************\n");
			String sql="Select * from lnt_customer";//firing sql query to fetch all record from lnt_customer table
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			//add the entity
			sqlQuery.addEntity(Customer.class);//entity which is mapped to db table
			List<Customer> results =sqlQuery.list();
			for (Customer c1 : results) {
				System.out.println(c1);
			}
		
			
			System.out.println("\n************Finding the Customer by name *************\n");
			sql = "Select * from lnt_customer where cust_name=:cust_name";
			sqlQuery= session.createSQLQuery(sql);
			sqlQuery.setParameter("cust_name", "Smita");//set the named parameter
			//add the entity
			sqlQuery.addEntity(Customer.class);//entity which is mapped to db table
			Customer c1 = (Customer) sqlQuery.uniqueResult();
			System.out.println("\n"+c1);
			/*results =sqlQuery.list();
			for (Customer c1 : results) {
				System.out.println(c1);
			}
		*/
			session.close();// Closing the session
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (factory != null)
				factory.close();
		}
	}

}

// buildSessionFactory(); method depricated in hibernate 4
// suggesting to use alternative ServiceRegistry object
/*
 * private static SessionFactory sessionFactory; private static ServiceRegistry
 * serviceRegistry; Configuration configuration = new Configuration();
 * configuration.configure(); serviceRegistry = new
 * ServiceRegistryBuilder().applySettings(configuration.getProperties()).
 * buildServiceRegistry(); sessionFactory =
 * configuration.buildSessionFactory(serviceRegistry);
 * 
 */
