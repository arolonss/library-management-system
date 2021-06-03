/**
 * 
 */
package com.dss.lms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author amanda
 *
 */
public abstract class BaseDAO {
 
	private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url= "jdbc:mysql://localhost:3306/library?serverTimezone=UTC";
    private static final String username = "root";
    private static final String password = "rootpassword";
    
    public Connection getConnection() throws ClassNotFoundException, SQLException {
	    //Register the driver 
		Class.forName(driver);
		// create Connection
		Connection conn = DriverManager.getConnection(url, username, password);
		return conn;
    }
    
    public void save(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
    	PreparedStatement pstmt = getConnection().prepareStatement(sql);
    	
    	int count = 1;
    	for(Object o: vals) {
    		pstmt.setObject(count, o);
    		count++;
    	}
    	pstmt.executeUpdate();
    }
}
