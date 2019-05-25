/**
 * 
 */
package com.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author brije
 *
 */
public class MyHibernateUtil {
	private static SessionFactory sessionFactory=null;
	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	public static SessionFactory getSessionFactory() {
		
		return sessionFactory;
	}
	public static void setSessionFactory(SessionFactory sessionFactory) {
		MyHibernateUtil.sessionFactory=sessionFactory;
	}
	public static void closeFactory() {
		if(sessionFactory!=null)
			sessionFactory.close();
	}
	public static void main(String[] args) {
		if(getSessionFactory()!=null)
			System.out.println("Factory configured!!");
		else
			System.err.println("Factory NOT configured!!");
	}
}
