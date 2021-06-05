/**
 * 
 */
package com.dss.lms.jdbc;
import java.sql.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @author amanda
 *
 */
public abstract class BaseDBC {

	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/library?serverTimezone=UTC";
	private static final String username = "root";
	private static final String password = "rootpassword";

	
	/**
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		
			// Register the driver
		Class.forName(driver);
			// create Connection
		Connection conn = DriverManager.getConnection(url, username, password);
			
        // statement
		// Statement stmt = conn.createStatement();
		// you can only have one PreparedStatement
		PreparedStatement pstmt = conn.prepareStatement("select * from tbl_book");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			String title = rs.getString("title");
			System.out.println(title);
		}
		
	}

}
