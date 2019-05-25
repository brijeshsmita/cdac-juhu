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

public class HQLCrud {

	public static void main(String[] args) {

		// Customer customer = new Customer(1111, "Shiv", "shiv@g.com",
		// "9879879666");
		// created a customer object
		
		Customer customer = new Customer("Nysha", "nysha@g.com", "9879879876");
		// Customer is in Transient state, as it is not associated with db or
		// session object

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		// step 1 : session Factory
		Session session = null;

		Transaction transaction = null;
		try {
			session = factory.openSession();
			System.out.println("************Listing all Customer Records*************");
			String hql = "Select from Customer";//HQL for retrieving the records
			Query query = session.createQuery(hql);
			List<Customer> results = query.list();
			for (Customer c1 : results) {
				System.out.println(c1);
			}
			// step 3 : Beginning transactions
			transaction = session.beginTransaction();
			// step 4 : saving the customer -insert
			Long custId = (Long) session.save(customer);// Hibernate Object enters
													// Persistence state
			/*
			 * 2) Persistent State- Having the relation with the database,
			 * associated with a unique Session object save() , saveOrUpdate(),
			 * persist()
			 */
			System.out.println("inserted Customer: " + custId);// commiting
															// transaction
			// step 5: commiting the tx
			transaction.commit();
			Thread.sleep(10000);
			session.close();// Closing the session
			// step 2 : opening session
			session = factory.openSession();
			// step 3 : Beginning transactions
			transaction = session.beginTransaction();
			/*Query query=session.createQuery("insert into purged_accounts(id, code, status) "+
				    "select id, code, status from account where status=:status");
				query.setString("status", "purged");
				int rowsCopied=query.executeUpdate();*/
			//now i will use hql to update the specific customer record
			query=session.createQuery("update Customer set phone=:phone where custId=:custId");
			//Customer is the name of the Object class not the name of the table
			//named parameter which is a placeholder to store dynamic value
			query.setLong("custId",custId);	//passing the value for the named parameter custId at runtime
			query.setString("phone", "7771110009");//passing the value for the named parameter phone at runtime
			// now we will update it on database
			
			System.out.println("updating Customer using HQL with customer id : "+custId);
			int noOfRecUpdated=query.executeUpdate();//executeUpdate() of query class is used for DML operation
			// commit tx
			transaction.commit();
			System.out.println(noOfRecUpdated+" Customer Updated ");
			
			hql = "from Customer where custId=:custId";//HQL for retrieving the records
			query = session.createQuery(hql);
			query.setLong("custId",custId);
			results = query.list();
			for (Customer c1 : results) {
				System.out.println(c1);
			}
			transaction = session.beginTransaction();
			Thread.sleep(10000);
			query=session.createQuery("delete from Customer where custId=:custId");
			query.setLong("custId", custId);
			int rowsDeleted=query.executeUpdate();
			transaction.commit();
			System.out.println(rowsDeleted+" Customer Deleted ");
			System.out.println("************Listing all Customer Records after delete*************");
			hql = "from Customer";//HQL for retrieving the records
			query = session.createQuery(hql);
			results = query.list();
			for (Customer c1 : results) {
				System.out.println(c1);
			}
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
