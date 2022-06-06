package com.neoquant.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

	public static final Connection establishedConnection() throws SQLException {
	
		Connection conn=null;
		
		try {
			Class.forName(Constants.MYSQL_DRIVER);
			conn = DriverManager.getConnection(Constants.MYSQL_URL, Constants.MYSQL_USERNAME, Constants.MYSQL_PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
