package com.cdac.hibernate.custapp;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.cdac.hibernate.model.Customer;

public class CustomerApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer customer=new Customer(9987,"smita","smita@gmail.com","8149665866");
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		
		Session session=null;
		Transaction transaction=null;
		try {
		session=factory.openSession();
		transaction= session.beginTransaction();
		int id = (int) session.save(customer);
		System.out.println("inserted customer "+ id);
		transaction.commit();
		session.close();
		factory.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
