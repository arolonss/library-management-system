package com.dss.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dss.lms.model.Book;
import com.dss.lms.model.BookAuthors;

public class BookAuthorsDAO extends BaseDAO<BookAuthors>{

	public BookAuthorsDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	public void addBook(Book book) throws ClassNotFoundException, SQLException {
		save("INSERT INTO tbl_book VALUES(?, ?, ?)", new Object[] { book.getId(), book.getTitle(), book.getPubId() });
	}

	public void updateBook(Book book) throws SQLException, ClassNotFoundException {
		save("UPDATE tbl_book SET title = ? where bookId = ?", new Object[] { book.getTitle(), book.getId() });

	}

//	public List<Book> readAllBooks(Book book) throws ClassNotFoundException, SQLException {
//        return read("select * from tbl_book", null);
//        
//		//return read("select * from tbl_book", new Object[] {book.getTitle()});

	}
	
	
//	public List<Book> readBooksById(Book book) throws ClassNotFoundException, SQLException {
//
//		return read("select * from tbl_book where bookId = ", new Object[] {book.getId()});
//
//	}
	
	public void deleteBook(Book book) throws SQLException, ClassNotFoundException {
		save("DELETE FROM tbl_book where bookId = ?", new Object[] { book.getId() });
	}

	@Override
	public List<BookAuthors> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {

		List<BookAuthors> bookAuthors = new ArrayList<>();
		while (rs.next()) {
			BookAuthors ba = new BookAuthors();
			
			ba.setId(rs.getInt("bookId"));
			
			ba.setId(rs.getInt("authorId"));
			bookAuthors.add(ba);
	    }
		
		return bookAuthors;
	}
	
	

}
