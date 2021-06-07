package com.dss.lms.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dss.lms.dao.AuthorDAO;
import com.dss.lms.dao.BookDAO;
import com.dss.lms.dao.BorrowerDAO;
import com.dss.lms.dao.LibraryDAO;
import com.dss.lms.model.Author;
import com.dss.lms.model.Book;
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
			return borrowers.get(1);
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

	public void readAllLibraries() throws ClassNotFoundException, SQLException {
		Connection conn = null;

		try {

			conn = util.getConnection();
			LibraryDAO libDao = new LibraryDAO(conn);
			libDao.readAllLibraries();

		} catch (SQLException e) {
			System.out.println("There was a problem. Line  50 in borrower service!");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}

	}

	public void readAllBooks() throws SQLException, ClassNotFoundException {
		Connection conn = null;
		// List<Book> books = null;
		try {

			conn = util.getConnection();
			BookDAO bookDao = new BookDAO(conn);
			bookDao.readAllBooks();
			// return books;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("There was a problem. Book not updated!");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}

	}

	public List<Borrower> readAllBorrowers() throws ClassNotFoundException, SQLException {
		Connection conn = null;
	
		try {

			conn = util.getConnection();
			BorrowerDAO borrowerDao = new BorrowerDAO(conn);

			return borrowerDao.readAllBorrowers();
			
		} catch (SQLException e) {
		
			System.out.println("There was a problem. borrower not updated!");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return null;
	}

	public boolean verifyCardNo(Integer cardNo) {
    	Connection conn = null;
    	try {
	    	
    		conn = util.getConnection();
	    	BorrowerDAO bdao = new BorrowerDAO(conn);
			
	    	List<Integer> bCards = new ArrayList<Integer>();
			
			for (Borrower b : bdao.readAllBorrowers()) {
				bCards.add(b.getCardNo());
			}
			return bCards.contains(cardNo);
    	} catch (Exception e) {
    		System.out.println("problem on line 118 borrower service");
    	}
		return false;
    	
    }
	
	public List<Book> showBooksAtLibrary(Integer id) throws ClassNotFoundException, SQLException {
		System.out.println("show books at chosen library");
		Connection conn = null;
		// List<Book> books = null;
		try {

			conn = util.getConnection();
			//BookDAO bookDao = new BookDAO(conn);
			BookDAO bdao= new BookDAO(conn);
			bdao.readBooksAtLibBranch(id);
			// return books;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("There was a problem. Book not updated!");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return null;
	}
}
