/**
 * 
 */
package com.cdac.mvc.service;

import com.cdac.mvc.dao.IUserDao;
import com.cdac.mvc.dao.UserDao;
import com.cdac.mvc.exception.UserException;
import com.cdac.mvc.model.User;

/**
 * @author Smita B Kumar
 *
 */
public class UserService implements IUserService {
//prepwork - object of Dao
	IUserDao userDao= new UserDao();
	/* (non-Javadoc)
	 * @see com.cdac.mvc.service.IUserService#login(com.cdac.mvc.model.User)
	 */
	@Override
	public User login(User user) throws UserException {
		// TODO Auto-generated method stub
		return userDao.login(user);
	}

	/* (non-Javadoc)
	 * @see com.cdac.mvc.service.IUserService#authenticate(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean authenticate(String username, String password) throws UserException {
		// TODO Auto-generated method stub
		return userDao.authenticate(username, password);
	}

	/* (non-Javadoc)
	 * @see com.cdac.mvc.service.IUserService#checkLogin(java.lang.String, java.lang.String)
	 */
	@Override
	public User checkLogin(String username, String password) throws UserException {
		// TODO Auto-generated method stub
		return userDao.checkLogin(username, password);
	}

}
