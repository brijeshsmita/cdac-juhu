/**
 * 
 */
package com.cdac.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author Smita B Kumar
 *
 */
//if a class implements an interface
//golden rule - class must override all the method
//or declare the class itself as an abstract class
public class GreetingService implements
IGreetingService,
BeanNameAware,
BeanFactoryAware,
BeanPostProcessor,
InitializingBean{
	private String msg;
	public GreetingService() {
		System.out.println("\n*************************************\n"
				+ "1>\t\tSpring Container Instantiated..GreetingService Object ");
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		System.out.println("2>\t\tInitialize the Bean.. ");

		this.msg = msg;
	}
	@Override
	public String greet(String name) {
		// TODO Auto-generated method stub
		return "Hello ,"+name+" - >"+msg;
	}
	@Override
	public void setBeanName(String arg0) {
		arg0+="Bean";
		System.out.println("3>\t\tBean name is : "+arg0);
	}
	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		System.out.println("4>\t\tBean create by this FactoryName : "+arg0);
	}
	
	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1) throws BeansException {
		System.out.println("5>\t\tpostProcessBeforeInitialization "+arg1);

		return null;
	}
	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1) throws BeansException {
		System.out.println("7>\t\tpostProcessAfterInitialization : "+arg1);

		return null;
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("6>\t\tSetting additional initialization of bean property");
		
	}

	

}
