/**
 * 
 */
package com.cdac.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Smita B Kumar
 *
 */
public class SpringClient {

	public static void main(String[] args) {
		//spring configuration file
		String configLocation="beans.xml";
		
		//create spring containere
		ApplicationContext springContainer=
				new ClassPathXmlApplicationContext(configLocation);
		/*IGreetingService greetingService= 
				(IGreetingService) springContainer.getBean("greetingService1");
		greetingService.greet("Zara");*/
	
	}

}
