/**
 * 
 */
package com.cdac.mvc.service;

import com.cdac.mvc.exception.UserException;
import com.cdac.mvc.model.User;

/**
 * @author Smita B Kumar
 *
 */
public interface IUserService {
	User login(User user)throws UserException;
	boolean authenticate(String username,String password)throws UserException;
	User checkLogin(String username,String password)throws UserException;

}
