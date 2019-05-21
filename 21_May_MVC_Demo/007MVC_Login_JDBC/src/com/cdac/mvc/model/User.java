	/**create table mvc_user
(
	user_id int NOT NULL AUTO_INCREMENT,
	username varchar(30),
	password varchar(20),
	role varchar(30),
	PRIMARY KEY (user_id)
);
	 * 
	 */package com.cdac.mvc.model;
import java.io.Serializable;

/**
 * @author Smita B Kumar
 *
 */
public class User implements Serializable {

	private static final long serialVersionUID = 7331233525588323030L;

	private Integer userId ;
	private String username;
	private String password;
	private String role;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public User(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}
	public User(Integer userId, String username, String password, String role) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", role=" + role + "]";
	}

}
