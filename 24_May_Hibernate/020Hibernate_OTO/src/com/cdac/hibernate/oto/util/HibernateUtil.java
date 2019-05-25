/**
 * 
 */
package com.cdac.hibernate.oto.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Smita B Kumar
 *
 */
public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
		return sessionFactory;
	}

	public static void closeSessionFactory() {
		sessionFactory.close();
	}
}
