package com.cdac.hibernate.client;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.cdac.hibernate.model.Employee;
import com.cdac.hibernate.model.Manager;
import com.cdac.hibernate.model.SalesManager;
import com.cdac.hibernate.util.HibernateUtil;
public class InheritenceSTMain {
	@SuppressWarnings({ "deprecation", "unchecked" })
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
			// then begin transactions
			transaction = session.beginTransaction();
			// step 4 : saving the customer -insert/create
			System.out.println("\n********************** Create ********************\\n");
			//emp obj
			Employee emp = new Employee("E",111.0);
					
	//mgr obj
			Manager mgr = new Manager("M", 222.0,100.0);
	//smgr obj
			SalesManager smgr= new SalesManager( "S", 333.0,10.0,20.0);
	//persist them
			session.save(emp);
			session.save(mgr);
			session.save(smgr);
	//commit tx		
			
			transaction.commit();			
			List<Employee> empList=session.createQuery("from Employee").list();
			System.out.println("\n*******************All Employee Records*****************************\n");
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
