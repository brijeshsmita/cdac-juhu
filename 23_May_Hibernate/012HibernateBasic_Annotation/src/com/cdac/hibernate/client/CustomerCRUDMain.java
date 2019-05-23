package com.cdac.hibernate.client;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.cdac.hibernate.model.Customer;
public class CustomerCRUDMain {
	@SuppressWarnings({ "deprecation", "unchecked" })
	public static void main(String[] args) {
		//Customer customer = new Customer(1111L, "Smita", "Smita@gmail.com", "9879879879");
		//Customer customer = new Customer(2222L, "Sia", "Sia@gmail.com", "9879878888");
		Customer customer=new Customer(9987,"smita","smita@gmail.com","8149665866");
		// step 1 : create session Factory
		SessionFactory factory =
				new Configuration().configure().buildSessionFactory();
		//hibernate.cfg.xml
		Session session = null;
		Transaction transaction = null;
		try {
			// //step 2 : open session
			session = factory.openSession();
			// step 3 : In case of DML operations (Data manipulation insert
			// update and delete)
			// then begin transactions
			transaction = session.beginTransaction();
			// step 4 : saving the customer -insert/create
			System.out.println("\n********************** Create ********************\\n");
			Integer id = (Integer) session.save(customer);
			System.out.println("Customer record inserted with Id : " 
			+ id);
			// step 5 : committing transaction
			transaction.commit(); session.close();
			session=factory.openSession();
			//step 6: get the object by passing primary key
			System.out.println("\n********************** Retrive ********************\\n");
			Customer customer1 = (Customer) 
					session.get(Customer.class, customer.getCustId());
			//session.get() method return Object ,therefore need to typecast
			System.out.println("Customer found : "+customer1);
			System.out.println("\n********************** Update ********************\\n");
			customer1.setCustName("Palak");
			customer1.setEmail("Palak@g.com");
			//update the record-DML
			transaction=session.beginTransaction();
			session.update(customer1);
			transaction.commit();			
			Customer updatedCustomer = (Customer) 
					session.get(Customer.class, customer.getCustId());
			System.out.println("Customer Updated : "+updatedCustomer);				
			System.out.println("\n***********Fetch All Customer Records**********\n");			//fetch all records with the help of HQL(Hibernate Query Language)
			//import query from javax.hibernate.query
			Query query= session.createQuery("FROM Customer");
			//HQL focus on class and properties
			//name of class and properties are case sensitive
			//lets execute HQL and fetch the list
			List<Customer> customerList=query.list();
			customerList.forEach((custObj)->System.out.println(custObj));
			System.out.println("\n********************** Delete ********************\\n");
			//deleting the customer object
			transaction= session.beginTransaction();
			session.delete(updatedCustomer);
			transaction.commit();
			Customer delCustomer=(Customer) 
					session.get(Customer.class, 
							updatedCustomer.getCustId());
			System.out.println("\n*********************\nCustomer Deleted : "+delCustomer);
			
			session.close();
			factory.close();
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

// Create a new Configuration ,
// for current application which has specific information about properties and
// mapping documents to be used
// With configure() API method use the mappings and properties specified in an
// application resource named hibernate.cfg.xml .

// if class is customer file name should be customer.hbm.xml... automatically
// configuration().configure() method takes data from this file

// creating session is lightweight process, multiple sessions can be created and
// no need to bother deallocation.

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
