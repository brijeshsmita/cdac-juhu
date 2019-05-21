/**
 * 
 */
package com.cdac.mvc.dao;

import com.cdac.mvc.exception.UserException;
import com.cdac.mvc.model.User;

/**
 * @author Smita B Kumar
 *
 */
public class TestDaoMethod {

	/**
	 * @param args
	 * @throws UserException 
	 */
	public static void main(String[] args) throws UserException {
		IUserDao userDao = new UserDao();
		User user=userDao.checkLogin("111", "111");
		if(user!=null) System.out.println("User Found : "+user);
		
		 user=userDao.login(user);
		if(user!=null) System.out.println("Login Successful : "+user);

	}

}
