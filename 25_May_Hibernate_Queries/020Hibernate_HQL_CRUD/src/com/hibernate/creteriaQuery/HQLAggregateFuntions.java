package com.hibernate.creteriaQuery;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.creteriaQuery.model.Customer;

public class HQLAggregateFuntions {
/*
 * select count(*) from Product product
The aggregate functions available through HQL include the following:
1.	avg(property name): The average of a property’s value
2.	count(property name or *): The number of times a property occurs in the results
3.	max(property name): The maximum value of the property values
4.	min(property name): The minimum value of the property values
5.	sum(property name): The sum total of the property values

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
			String hql = "from Customer";//HQL for retrieving the records
			Query query = session.createQuery(hql);
			List<Customer> results =query.list();
			for (Customer c1 : results) {
				System.out.println(c1);
			}
		
			System.out.println("\n************Customer record Sorted order by Name and id*************\n");
			hql = "from Customer c order by c.custName, c.id";//HQL for retrieving the records
			query = session.createQuery(hql);
			//query.setString("phone", phone);//setting the named parameter value
			results =query.list();
			for (Customer c1 : results) {
				System.out.println(c1);
			}
			
			hql="select count(*) from Customer c";
			query = session.createQuery(hql);
			Long resCount= (Long) query.uniqueResult();
			System.out.println("\n********Number of customer records : "+resCount);
			//Thread.sleep(10000);
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
