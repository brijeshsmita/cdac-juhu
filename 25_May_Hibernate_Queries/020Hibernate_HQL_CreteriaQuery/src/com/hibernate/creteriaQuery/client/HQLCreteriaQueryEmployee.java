package com.hibernate.creteriaQuery.client;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.hibernate.creteriaQuery.model.Employee;
public class HQLCreteriaQueryEmployee {
	public static void main(String[] args) {
		Employee employee = new Employee("Diya", "Sen", 5000.99,"9998887770", "diya@gmail.com", new Date());
			// step 1 : create session Factory
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = null;
		Transaction transaction = null;
		try {
			// //step 2 : open session
			session = factory.openSession();			
			//select * from emp where sal=2000.99
			Criteria cr = session.createCriteria(Employee.class);
			cr.add(Restrictions.eq("salary", 2000.99));
			List<Employee> empRes= cr.list();
			for (Employee e1 : empRes) {
				System.out.println(e1);
			}		
			
			cr = session.createCriteria(Employee.class);
			cr.addOrder(Order.desc("salary"));
			empRes= cr.list();
			System.out.println("\n**************Listing all the employee records ordered by Salary **************\n");
			for (Employee e1 : empRes) {
				System.out.println(e1);
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

// Create a new Configuration ,
// for current application which has specific information about properties and
// mapping documents to be used
// With configure() API method use the mappings and properties specified in an
// application resource named hibernate.cfg.xml .

// if class is employee file name should be employee.hbm.xml... automatically
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
