package com.cdac.spring.scope.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cdac.spring.scope.service.ICurrencyConverter;



public class CurrencyConverterClient {

	public static void main(String args[]) throws Exception {
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("beans.xml");
		ICurrencyConverter obj1 = (ICurrencyConverter)
				factory.getBean("currencyConverter");
		ICurrencyConverter obj2 = (ICurrencyConverter)
				factory.getBean("currencyConverter");
		
		//deafult scope of a spring bean is singleton
		//means everytime a same object will be returned
		
		//we can change it to prototype, 
		//means everytime a new object will be returned
		// eg: @Scope(value="prototype")
		System.out.println("obj1.hashCode():"+obj1.hashCode());
		System.out.println("obj2.hashCode():"+obj2.hashCode());
		
	}
}
