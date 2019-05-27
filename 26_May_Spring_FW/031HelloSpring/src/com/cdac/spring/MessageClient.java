/**
 * 
 */
package com.cdac.spring;

import java.applet.AppletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.cdac.spring.cab.service.ICabService;
import com.cdac.spring.cab.service.OlaCabService;

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
		
//object name must be same name of the className starting with lowercase
		//get the bean for the container
		IMessageService watsAppMessage =
		(IMessageService) springContainer.getBean("watsAppMessage");//= new WatsAppMsgService();
		//getBean method of any spring Container returns an Object
		
		//call the method with the object
		String msg=watsAppMessage.sendMessage("Zara");
		System.out.println(msg);
		
		ICabService cabService=
		(ICabService) springContainer.getBean("olaCabService");
		System.out.println(cabService.bookCab("Zara"));
		
		cabService=
				(ICabService) springContainer.getBean("uberCabService");
				System.out.println(cabService.bookCab("Zara"));
				
		
	}

}
