package com.neoquant.dbutil;

import java.sql.Connection;
import java.sql.SQLException;

public class DataBaseConnectionMain {

	public static void main(String[] args) {
		
		Connection conn=null;
		
		try {
			conn= DataBaseConnection.establishedConnection();
			System.out.println("Connection object:"+conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
