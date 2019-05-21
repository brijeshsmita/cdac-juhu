package com.cdac.mvc.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.cdac.mvc.exception.UserException;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

/**
 * @author Smita B Kumar
 *
 */
public class ConnectionUtil {

	private static Connection jdbcConnection;

	private static MysqlDataSource mysqlDS = null;

	public static Connection connect() throws UserException {

		File file = new File("C:\\Users\\Smita B Kumar\\Downloads\\Bookstore\\Bookstore\\db.properties");
		Properties props = null;
		try {FileInputStream fis = new FileInputStream(file);
			props = new Properties();
			props.load(fis);			
			mysqlDS = new MysqlDataSource();
			mysqlDS.setURL(props.getProperty("url"));
			mysqlDS.setUser(props.getProperty("username"));
			mysqlDS.setPassword(props.getProperty("password"));
			if (jdbcConnection == null || jdbcConnection.isClosed()) {
				jdbcConnection = mysqlDS.getConnection();
			}
			fis.close();
		} catch (SQLException e) {
			throw new UserException(e.getMessage());
		} catch (FileNotFoundException e) {
			throw new UserException(e.getMessage());
		} catch (IOException e) {
			throw new UserException(e.getMessage());
		}
		return jdbcConnection;

	}

	public static void disconnect() throws UserException {
		try {
			if (jdbcConnection != null && !jdbcConnection.isClosed()) {
				jdbcConnection.close();
			}
		} catch (SQLException e) {
			throw new UserException(e.getMessage());
		}
	}

}
