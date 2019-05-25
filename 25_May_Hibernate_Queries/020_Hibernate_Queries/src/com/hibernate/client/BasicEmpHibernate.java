/**
 * 
 */
package com.hibernate.client;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.entity.Employee;
import com.hibernate.util.MyHibernateUtil;

/**
 * @author brije
 *
 */
public class BasicEmpHibernate {
	private static SessionFactory sessionFactory;
	private static Session session;
	private static Transaction transaction;
	private static Employee employee;
	/*
	 * private static Connection conn; private static Statement stmt = null; private
	 * static PreparedStatement ps = null; private static ResultSet rs = null;
	 */
	private static Scanner scan = new Scanner(System.in);
	static {
		/* conn = MyConnection.getConn(); */
		sessionFactory = MyHibernateUtil.getSessionFactory();
		if (sessionFactory != null)
			System.out.println("sessionFactory Obtained!!!");
		else
			System.err.println("Sorry Boss!! sessionFactory NOT Obtained!!!");
	}

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {

		try {
			listAllEmployee();			
			insertEmployee();
			Thread.sleep(5000);
			retriveEmployee();
			employee.setEmpName("Yoyo"); employee.setEmpSal(100000.00);
			updateEmployee(employee);

			Thread.sleep(5000);
			System.out.println("Updated Employee List");
			listAllEmployee();
			System.out.println("Updated Employee after Delete");
			deleteEmployee(employee);

			Thread.sleep(5000);
			listAllEmployee();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (sessionFactory != null)
				MyHibernateUtil.closeFactory();
		}

	}

	private static void insertEmployee() throws SQLException {
		// step 1 : open session
		session = sessionFactory.openSession();
		// step 2: begin tx (DML)
		transaction = session.beginTransaction();
		// step 3: save employee
		/*System.out.println("Enter Employee Id : ");
		Integer empId = scan.nextInt();*/
		System.out.println("Enter Employee name : ");
		String empName = scan.next();
		System.out.println("Enter Employee sal : ");
		Double empSal = scan.nextDouble();
		employee = new Employee(empName, empSal);
		Integer empId = (Integer) session.save(employee);
		// step 4: commit tx
		transaction.commit();
		// step 5: close session
		session.close();
		if (empId > 0) {
			System.out.println(" Employee inserted successfully...  " + empId);
		} else {
			System.err.println("Sorry Boss , insert Not happened...");
		}
	}
	
	// executing simple select query using statement object
	private static void retriveEmployee() throws SQLException {
		// step 1 : open session
		session = sessionFactory.openSession();
		// step 3: retrieve employee record
		Employee employeeFound = (Employee) session.get(Employee.class, employee.getEmpId());
		// session.get returns Object
		// step 5: close session
		session.close();
		if (employeeFound != null) {
			System.out.println(" Employee Record Found..." + employeeFound);
		} else {
			System.err.println("Sorry Boss , Employee Record Not Found...");
		}
	}
	// executing simple select query using statement object
		private static void listAllEmployee() throws SQLException {
			// step 1 : open session
			session = sessionFactory.openSession();
			// step 3: retrieve all employee record
			//Hibernate focus on class object rather than Table
			List<Employee> empList = session.createQuery("from Employee").list();
			// session.get returns Object
			// step 5: close session
			session.close();
			if (empList != null) {
				System.out.println(" ************Employee List Found************");
				for(Employee employee:empList)
					System.out.println(employee);
			} else {
				System.err.println("Sorry Boss , Employee Record Not Found...");
			}
			
		}
		private static void updateEmployee(Employee employee) throws SQLException {
			// step 1 : open session
			session = sessionFactory.openSession();
			// step 2: begin tx (DML)
			transaction = session.beginTransaction();
			// step 3: update employee record
			//Hibernate focus on class object rather than Table
			session.update(employee);
			// session.get returns Object
			// step 4: commit tx
			transaction.commit();
			// step 5: close session
			session.close();			
		}
		private static void deleteEmployee(Employee employee) throws SQLException {
			// step 1 : open session
			session = sessionFactory.openSession();
			// step 2: begin tx (DML)
			transaction = session.beginTransaction();
			// step 3: update employee record
			//Hibernate focus on class object rather than Table
			session.delete(employee);
			// step 4: commit tx
			transaction.commit();
			// step 5: close session
			session.close();			
		}
}