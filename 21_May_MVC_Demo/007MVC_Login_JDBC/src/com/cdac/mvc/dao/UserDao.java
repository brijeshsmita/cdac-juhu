/**
 * 
 */
package com.cdac.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cdac.mvc.exception.UserException;
import com.cdac.mvc.model.User;
import com.cdac.mvc.util.ConnectionUtil;

/**
 * @author Smita B Kumar
 *
 */
public class UserDao implements IUserDao {
//prepWork -> Connection
	private Connection conn;
	/**
	 * 
	 */
	public UserDao() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.cdac.mvc.dao.IUserDao#login(com.cdac.mvc.model.User)
	 */
	@Override
	public User login(User user) throws UserException {
		conn= ConnectionUtil.connect();//connect
		String sql="select * from mvc_user where username=? and password=?";
		//create ps for sql query execution
		User userFound=null;
		try(PreparedStatement ps = conn.prepareStatement(sql);){
			//set the dynamic placeholders (?)
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			//execute the query
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				userFound= new User();
				userFound.setUserId(rs.getInt(1));
				userFound.setUsername(rs.getString(2));
				userFound.setPassword(rs.getString(3));
				userFound.setRole(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ConnectionUtil.disconnect();
		return userFound;
	}

	/* (non-Javadoc)
	 * @see com.cdac.mvc.dao.IUserDao#authenticate(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean authenticate(String username, String password) throws UserException {
		conn= ConnectionUtil.connect();//connect
		String sql="select * from mvc_user where username=? and password=?";
		//create ps for sql query execution
		boolean userFound=false;
		User user=null;
		try(PreparedStatement ps = conn.prepareStatement(sql);){
			//set the dynamic placeholders (?)
			ps.setString(1, username);
			ps.setString(2, password);
			//execute the query
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				userFound= true;
				/*user= new User();
				user.setUserId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setRole(rs.getString(4));*/
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ConnectionUtil.disconnect();
		return userFound;
	}

	@Override
	public User checkLogin(String username, String password) throws UserException {
		conn= ConnectionUtil.connect();//connect
		String sql="select * from mvc_user where username=? and password=?";
		//create ps for sql query execution
		//boolean userFound=false;
		User user=null;
		try(PreparedStatement ps = conn.prepareStatement(sql);){
			//set the dynamic placeholders (?)
			ps.setString(1, username);
			ps.setString(2, password);
			//execute the query
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				//userFound= true;
				user= new User();
				user.setUserId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setRole(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ConnectionUtil.disconnect();
		return user;
	}

}
