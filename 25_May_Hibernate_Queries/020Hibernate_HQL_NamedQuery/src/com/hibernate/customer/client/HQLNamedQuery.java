package com.hibernate.customer.client;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.customer.model.Customer;

public class HQLNamedQuery {
/*Named queries are created via class-level annotations on entities; normally, 
 * the queries apply to the entity in whose source file they occur, 
 * but there’s no absolute requirement for this to be true.
Named queries are created with the @NamedQueries annotation, which contains an array of @NamedQuery sets; 
each has a query and a name.
we can execute the named query using method getNamedQuery()
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
			Query query = 
					session.getNamedQuery("customer.findAll");
			//accessing the namedQuery defined at the customer class 
			List<Customer> results =query.list();
			for (Customer c1 : results) {
				System.out.println(c1);
			}
		
			
			System.out.println("\n************Finding the Customer by name *************\n");
			query = session.getNamedQuery("customer.findByName");
			//accessing the namedQuery defined at the customer class 
			query.setString("custName", "Sia");//set the named parameter
			Customer c1 =(Customer) query.uniqueResult();//uniqueResult return Object
			//for (Customer c1 : results) {
				System.out.println(c1);
			//}
		
		
			session.close();// Closing the session
		} catch (Exception ex) {
			ex.printStackTrace();
			if (transaction != null)
				transaction.rollback();
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
