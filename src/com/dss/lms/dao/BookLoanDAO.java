package com.dss.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dss.lms.model.Book;
import com.dss.lms.model.BookLoan;

public class BookLoanDAO extends BaseDAO<BookLoan>{

	public BookLoanDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	public void addBookLoan(BookLoan bookLoan) throws ClassNotFoundException, SQLException {
		save("INSERT INTO tbl_book_loans VALUES(?, ?, ?, ?, ?)", new Object[] { bookLoan.getBookId(), bookLoan.getLibraryId(), bookLoan.getCardNo(), bookLoan.getDateOut(), bookLoan.getDueDate() });
	}

	public void updateBookLoan(BookLoan bookLoan) throws SQLException, ClassNotFoundException {
		save("UPDATE tbl_book SET dueDate = ? where cardNo = ?", new Object[] { bookLoan.getDueDate(), bookLoan.getCardNo() });

	}

	public List<BookLoan> readAllBookLoan(BookLoan bookLoan) throws ClassNotFoundException, SQLException {
        return read("select * from tbl_book_loans", null);
        
		//return read("select * from tbl_book", new Object[] {book.getTitle()});

	}
	
	
	public List<BookLoan> readBookLoansByBookId(BookLoan bookLoan) throws ClassNotFoundException, SQLException {

		return read("select * from tbl_book_loans where bookId = ", new Object[] {bookLoan.getBookId()});

	}
	
	public void deleteBookLoan(BookLoan bookLoan) throws SQLException, ClassNotFoundException {
		save("DELETE FROM tbl_book_loans where cardNo = ?", new Object[] { bookLoan.getCardNo() });
	}

	
//	}
	@Override
	public List<BookLoan> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookLoan> bookLoans = new ArrayList<>();
		while (rs.next()) {
			BookLoan bl = new BookLoan();
			
			bl.setId(rs.getInt("bookId"));
			bl.setId(rs.getInt("branchId"));
			bl.setId(rs.getInt("cardNo"));
			bl.setDate(rs.getDate("dateOut"));
			bl.setDate(rs.getDate("dueDate"));
			bookLoans.add(bl);
	    }
		return bookLoans;
	}

}
