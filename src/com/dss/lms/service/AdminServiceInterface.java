/**
 * 
 */
package com.dss.lms.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dss.lms.model.Author;
import com.dss.lms.model.Book;
import com.dss.lms.model.Borrower;
import com.dss.lms.model.Genre;
import com.dss.lms.model.Library;
import com.dss.lms.model.Publisher;

/**
 * @author amanda
 *
 */
public interface AdminServiceInterface {
    // book CRUD
	public void addBook(Book book) throws SQLException;
	public void updateBook(Book book) throws SQLException;
	public ArrayList<Book> readAllBooks(Book book) throws ClassNotFoundException, SQLException;
	public void deleteBook(Book book) throws SQLException;
	
	//author CRUD
	public void addAuthor(Author author) throws SQLException;
	public void updateAuthor(Author author);
	public ArrayList<Author> readAllAuthors(Author author);
	public void deleteAuthor(Author author);
	//genre CRUD
	public void addGenre(Genre genre) throws SQLException;
	public void updateGenre(Genre genre);
	public ArrayList<Genre> readAllGenres(Genre genre);
	public void deleteGenre(Genre genre);
	//publisher CRUD
	public void addPublisher(Publisher publisher) throws SQLException;
	public void updatePublisher(Publisher publisher);
	public ArrayList<Publisher> readAllPublishers(Publisher publisher);
	public void deletePublisher(Publisher publisher);
	//library CRUD 
	public void addLibrary(Library library);
	public void updateLibrary(Library library);
	public ArrayList<Library> readAllLibraries(Library library);
	public void deleteBook(Library library);
	//borrower CRUD
	public void addBorrower(Borrower borrower);
	public void updateBorrower(Borrower borrower);
	public ArrayList<Borrower> readAllBorrowers(Borrower borrower);
	public void deleteBorrower(Borrower borrower);
	// override due date? 
	//public ArrayList<Book> readAllBooks() throws ClassNotFoundException, SQLException;
}
