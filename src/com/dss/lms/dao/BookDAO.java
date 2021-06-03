/**
 * 
 */
package com.dss.lms.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.dss.lms.model.Book;
/**
 * @author amanda
 *
 */
public class BookDAO extends BaseDAO {

	public void addBook(Book book) throws ClassNotFoundException, SQLException {
		save("INSERT INTO tbl_book VALUES(?, ?)", new Object[] {book.getBookId(), book.getTitle()});
	}
	
	public void updateBook(Book book) throws SQLException, ClassNotFoundException {
		save("UPDATE tbl_book SET title = ? where bookId = ?", new Object[] {book.getTitle(), book.getBookId()});
		
	}
	
	public List<Book> readAllBooks(Book book) throws ClassNotFoundException, SQLException {
		
		PreparedStatement pstmt = getConnection().prepareStatement("select * from tbl_book");
		
	    ResultSet rs = pstmt.executeQuery(); // .executeBatch commits by default 
	    List<Book> books = new ArrayList<>();
		while(rs.next()) {
			Book b = new Book();
			b.setBookId(rs.getString("bookId"));
			b.setTitle(rs.getString("title"));
			books.add(b);
		}
		return books;
	}
	
	public void deleteBook(Book book) throws SQLException, ClassNotFoundException {
		save("DELETE FROM tbl_book where bookId = ?", new Object[] {book.getBookId()});
	}
}
