package com.cdac.hibernate.oto.client;



import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cdac.hibernate.oto.entities.Address;
import com.cdac.hibernate.oto.entities.Trainee;
import com.cdac.hibernate.oto.util.HibernateUtil;
public class OtoTraineeAddressMain {
	@SuppressWarnings({ "unchecked" })
	public static void main(String[] args) {
			// step 1 : create session Factory
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		//hibernate.cfg.xml
		Session session = null;
		Transaction transaction = null;
		try {
			// //step 2 : open session
			session = sessionFactory.openSession();
			// step 3 : In case of DML operations (Data manipulation insert
			// update and delete)
			Address address = new 
	Address(101, "Sector15", "Mumbai", "MH", "India");
			Trainee trainee = new
Trainee(1, "Ritu", "Kumar", new Date(11, 11, 1999)
		, "9879879876", address);
			address.setTrainee(trainee);
			//association mapping by traineeId
			
			// then begin transactions
			transaction = session.beginTransaction();
			// step 4 : saving the customer -insert/create
			session.save(trainee);
			transaction.commit();	
			List<Trainee> empList=session.createQuery("from Trainee").list();
			System.out.println("\n*******************All Trainee Records*****************************\n");
			empList.forEach((empObj)->System.out.println(empObj));
			session.close();
			HibernateUtil.closeSessionFactory();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		} finally {
			if (sessionFactory != null)
				sessionFactory.close();
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
