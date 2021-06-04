/**
 * 
 */
package com.dss.lms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author amanda
 *
 */
public abstract class BaseDAO<T> {
    protected Connection conn = null;
	
    public BaseDAO(Connection conn) {
    	this.conn = conn;
    }

    public Integer saveAndReturnPrimaryKey(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //thread safe method

		int count = 1;
		for (Object o: vals) {
			pstmt.setObject(count, o);
			count++;
		}
		pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys(); // try this or .executeQuery()
		while(rs.next()) {
			return rs.getInt(1); //or try 0
		}
		return null;
	}
    
	public void save(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql);

		int count = 1;
		for (Object o: vals) {
			pstmt.setObject(count, o);
			count++;
		}
		pstmt.executeUpdate();
	}

	public List<T> read(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql);

		int count = 1;
		for (Object o: vals) {
			pstmt.setObject(count, o);
			count++;
		}
		ResultSet rs = pstmt.executeQuery();
		return extractData(rs);
		
	}
	
	abstract public List<T> extractData(ResultSet rs) throws ClassNotFoundException, SQLException;
}
