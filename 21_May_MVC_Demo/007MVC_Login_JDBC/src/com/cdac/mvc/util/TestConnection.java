package com.cdac.mvc.util;

import java.sql.Connection;

import com.cdac.mvc.exception.UserException;

public class TestConnection {

	public static void main(String[] args) throws UserException {
		Connection con = ConnectionUtil.connect();
		if (con != null) {
			System.out.println("connection obtained!! :" + con);
			ConnectionUtil.disconnect();
		}
		else
			System.out.println("connection NOT obtained!!");
		
		
	}

}
