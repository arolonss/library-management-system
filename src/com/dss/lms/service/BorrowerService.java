package com.dss.lms.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.dss.lms.dao.AuthorDAO;
import com.dss.lms.dao.BorrowerDAO;
import com.dss.lms.model.Author;
import com.dss.lms.model.Borrower;

public class BorrowerService {

	Util util = new Util();
	
	public Borrower readBorrowerById(Integer id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
            conn = util.getConnection();
			BorrowerDAO bDao = new BorrowerDAO(conn);
			List<Borrower> borrowers = bDao.readBorrowerById(id);
			if (borrowers.size() == 0) {
				return null;
			}
			return borrowers.get(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("There was a problem in adminService!");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return null;
	}
}
