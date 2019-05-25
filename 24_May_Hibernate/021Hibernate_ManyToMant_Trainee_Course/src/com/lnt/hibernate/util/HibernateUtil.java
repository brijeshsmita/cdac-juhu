/**
 * 
 */
package com.lnt.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * @author Smita
 *
 */
public class HibernateUtil {

	private static SessionFactory sessionFactory = buildSessionFactory();
	 
	   private static SessionFactory buildSessionFactory()
	   {
	      try
	      {
	         if (sessionFactory == null)
	         {
	            Configuration configuration = new Configuration().configure(
	            		HibernateUtil.class.getResource("/hibernate.cfg.xml"));
	            ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder();
	            serviceRegistryBuilder.applySettings(configuration.getProperties());
	            ServiceRegistry serviceRegistry = serviceRegistryBuilder.buildServiceRegistry();
	            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	         }
	         return sessionFactory;
	      } catch (Throwable ex)
	      {
	         System.err.println("Initial SessionFactory creation failed." + ex);
	         throw new ExceptionInInitializerError(ex);
	      }
	   }
	 
	   public static SessionFactory getSessionFactory()
	   {
	      return sessionFactory;
	   }
	 
	   public static void shutdown()
	   {
	      getSessionFactory().close();
	   }

}
/*
 * Note:the Configuration class’ buildSessionFactory() method is deprecated and
 * it recommends developers to use the buildSessionFactory(ServiceRegistry)
 * instead.
 */