/**
 * 
 */
package com.dss.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dss.lms.model.Book;

/**
 * @author amanda
 *
 */
public class BookDAO extends BaseDAO<Book> {

	
	public BookDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	public void addBook(Book book) throws ClassNotFoundException, SQLException {
		save("INSERT INTO tbl_book VALUES(?, ?, ?)", new Object[] {book.getId(), book.getTitle(), book.getPubId() });
	}

	public void updateBook(Book book) throws SQLException, ClassNotFoundException {
		save("UPDATE tbl_book SET title = ?, pubId = ? where bookId = ?", new Object[] { book.getTitle(), book.getPubId(), book.getId() });
	}

	public List<Book> readAllBooks() throws ClassNotFoundException, SQLException {
        return read("select * from tbl_book", null);
	}
	
	
	public List<Book> readBookById(Integer id) throws ClassNotFoundException, SQLException {

		return read("select * from tbl_book where bookId = ?", new Object[] { id });

	}
	
	public void deleteBook(Book book) throws SQLException, ClassNotFoundException {
		save("DELETE FROM tbl_book where bookId = ?", new Object[] { book.getId() });
	}

	public List<Book> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Book> books = new ArrayList<>();
		while (rs.next()) {
			Book b = new Book();
			
			b.setId(rs.getInt("bookId"));
			b.setTitle(rs.getString("title"));
			b.setPubId(rs.getInt("pubId"));
			books.add(b);
	    }
		books.forEach(b -> System.out.println(b.getTitle()));
	    return books;
	}

	
}
