/**
 * 
 */
package com.cdac.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Smita B Kumar
 *
 */
public class MessageClient {

	public static void main(String[] args) {
		//spring configuration file
		String configLocation="beans.xml";
		
		//create spring containere
		ApplicationContext springContainer=
				new ClassPathXmlApplicationContext(configLocation);
		/*1> ClassPathXmlApplicationContext - configure xml file located in classPath ("FileName")
		2> FileSystemXmlApplicationContext - configure xml file located in any directory (AbsoluteFilePath)*/
		IFacebookService facebookService = 
	(IFacebookService) springContainer.getBean("facebookService");
		facebookService.writePost("Writing FB Post....");
		
	}

}
