package com.cdac.hibernate.otm.client;



import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cdac.hibernate.otm.entities.Department;
import com.cdac.hibernate.otm.entities.Employee;
import com.cdac.hibernate.otm.util.HibernateUtil;
public class OtmHibernateMain {
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
			
			Department department= new Department();
			department.setDeptId(10);
			department.setDeptName("Training");
			//now lets create a set of employee which will have 3 emp object
			Employee e1 = new Employee(1,"A", 100, department);
			Employee e2 = new Employee(2,"B", 90, department);
			Employee e3 = new Employee(3,"C", 80, department);
			Set<Employee> employees = new HashSet<>();
			//add the emp in set
			employees.add(e1);employees.add(e2);employees.add(e3);
			//now set the department employees value
			department.setEmployees(employees);
			
			// then begin transactions
			transaction = session.beginTransaction();
			// step 4 : saving the customer -insert/create
			session.save(department);
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
