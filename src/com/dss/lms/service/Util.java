package com.dss.lms.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {

	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/library?serverTimezone=UTC";
	private static final String username = "root";
	private static final String password = "rootpassword";

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		// Register the driver
		Class.forName(driver);
		// create Connection
		Connection conn = DriverManager.getConnection(url, username, password);
		conn.setAutoCommit(Boolean.FALSE);
		 //when set to false, commits are not executed without being specified. Everything is soft, not hard commit. saved temporarly 
		return conn;
	}
}
