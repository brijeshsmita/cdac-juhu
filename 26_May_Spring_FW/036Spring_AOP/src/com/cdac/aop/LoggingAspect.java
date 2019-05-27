/**
 * 
 */
package com.cdac.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author Smita B Kumar
 *
 */
//aspect
@Aspect
public class LoggingAspect {
	//advice //pointcut - expression to the plug in advice at the jointpoint
	@Before("execution(* com.cdac.aop.CustomerServiceImpl.withdraw(..))")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("Logging before the method...."
				+joinPoint.getSignature().getName());
	}
	@After("execution(* com.cdac.aop.CustomerServiceImpl.logout(..))")
	public void clearLog(JoinPoint joinPoint) {
		System.out.println("****ClearLog after the method...."
				+joinPoint.getSignature().getName());
	}
	@AfterReturning(
pointcut="execution(* com.cdac.aop.CustomerServiceImpl.checkBalance(..))",
						returning= "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {

		System.out.println("****logAfterReturning() is running ...."
				+ joinPoint.getSignature().getName()
				+".. and Method returned value is : " + result
				+"******");

	}
	@AfterThrowing(
	pointcut="execution(* com.cdac.aop.CustomerServiceImpl.login(..))",
			throwing="error"
			)
	public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
		System.out.println("****logAfterThrowing() is running ...."
				+ joinPoint.getSignature().getName()
				+".. and Method throwing error : " + error
				+"******");
	}
}







