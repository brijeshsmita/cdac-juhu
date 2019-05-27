/**
 * 
 */
package com.cdac.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author Smita B Kumar
 *
 */
@Aspect
public class TransactionAspect {
	@Around("execution(* com.cdac.aop.CustomerServiceImpl.withdraw(..))")
	public void transaction(ProceedingJoinPoint procedingJoinPoint) 
			throws Throwable {
		System.out.println("**** transaction Around advice before ..."
		+ procedingJoinPoint.getSignature().getName());
		procedingJoinPoint.proceed();
		//delegate to the joinpoint execution
		//and then again execute the advice
		System.out.println("**** transaction Around advice after ..."
				+ procedingJoinPoint.getSignature().getName());
	}
}
