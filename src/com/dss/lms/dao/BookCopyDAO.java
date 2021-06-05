package com.dss.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dss.lms.model.Book;
import com.dss.lms.model.BookCopy;

public class BookCopyDAO extends BaseDAO<BookCopy> {

	
	public BookCopyDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	public void addBookCopy(BookCopy bookCopy) throws ClassNotFoundException, SQLException {
		save("INSERT INTO tbl_book_copies VALUES(?, ?, ?)", new Object[] { bookCopy.getBookId(), bookCopy.getLibraryId(), bookCopy.getNoOfCopies()});
	}

	public void updateBookCopy(BookCopy bookCopy) throws SQLException, ClassNotFoundException {
		save("UPDATE tbl_book_copies SET noOfCopies = ?", new Object[] { bookCopy.getNoOfCopies() });

	}

	public List<BookCopy> readAllBookCopies(BookCopy bookCopy) throws ClassNotFoundException, SQLException {
        return read("select * from tbl_book_copies", null);
	}
	
	
//	public List<Book> readBooksById(Book book) throws ClassNotFoundException, SQLException {
//
//		return read("select * from tbl_book where bookId = ", new Object[] {book.getId()});
//
//	}
	
	public void deleteBookCopy(BookCopy bookCopy) throws SQLException, ClassNotFoundException {
		save("DELETE FROM tbl_book_copies where noOfCopies = ?", new Object[] { bookCopy.getNoOfCopies() });
	}


	@Override
	public List<BookCopy> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		
		List<BookCopy> bookCopies = new ArrayList<>();
		while (rs.next()) {
			BookCopy bc = new BookCopy();
			
			bc.setObject(rs.getInt("bookId"));
			bc.setLibraryId(rs.getInt("branchId"));
			bc.setNoOfCopies(rs.getInt("noOfCopies"));
			bookCopies.add(bc);
	    }
		return bookCopies;
	}

}
