package com.dss.lms.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.dss.lms.dao.LibraryDAO;
import com.dss.lms.dao.PublisherDAO;
import com.dss.lms.model.Library;
import com.dss.lms.model.Publisher;

public class LibrarianService {

	Util util = new Util();
	
	public void readAllLibraries() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		
		try {
            conn = util.getConnection();
			LibraryDAO libDao = new LibraryDAO(conn);
			libDao.readAllLibraries();
			
		} catch (SQLException e) {
			System.out.println("There was a problem. Line 22 in librarian servce!");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		} 
		
	}
	
	public Library readLibraryById(Integer id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
            conn = util.getConnection();
			LibraryDAO libDao = new LibraryDAO(conn);
			List<Library> libs = libDao.readLibraryById(id);
			if (libs.size() == 0) {
				return null;
			}
			return libs.get(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("There was a problem in librarian service on line 48!");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return null;
		
	}

}
