/**
 * 
 */
package com.cdac.aop;
/**
 * @author Smita B Kumar
 *
 */
public interface CustomerService {
	void withdraw(double amount);
	void logout();
	void login()throws Exception;
	double checkBalance(int accId);
}
