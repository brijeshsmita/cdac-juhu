package com.cdac.aop;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class AopApp {
	public static void main(String[] args) throws Exception {
		ApplicationContext context = 
		new ClassPathXmlApplicationContext("aop.xml");
		CustomerService customerService = (CustomerService) 
				context.getBean("customerService");
		customerService.withdraw(1000);
		customerService.logout();
		customerService.checkBalance(101);
	}
}
//