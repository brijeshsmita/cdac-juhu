package com.cdac.spring.di.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cdac.spring.config.SpringJavaConfig;
import com.cdac.spring.di.service.ICurrencyConverter;



public class CurrencyConverterClient {

	public static void main(String args[]) throws Exception {
		/*ApplicationContext factory = 
				new ClassPathXmlApplicationContext("beans.xml");*/
		ApplicationContext factory = new
		AnnotationConfigApplicationContext(SpringJavaConfig.class);
			
		
		ICurrencyConverter currencyConverter = (ICurrencyConverter)
				factory.getBean("currencyConverter");
		double rupees = currencyConverter.dollarsToRupees(100.0);
		System.out.println("100 $ is "+rupees+" Rs.");
	}
}
