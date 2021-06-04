package com.dss.lms.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


import com.dss.lms.dao.AuthorDAO;
import com.dss.lms.dao.BookDAO;
import com.dss.lms.dao.PublisherDAO;
import com.dss.lms.model.Author;
import com.dss.lms.model.Book;
import com.dss.lms.model.Borrower;
import com.dss.lms.model.Genre;
import com.dss.lms.model.Library;
import com.dss.lms.model.Publisher;


public class AdminService implements AdminServiceInterface {
    
	Util util = new Util();
	
	@Override
	public void addBook(Book book) throws SQLException {
		Connection conn = null;
		
		try {
			System.out.println(book);
			//System.out.println("Add a book:");
			conn = util.getConnection();
			BookDAO bookDao = new BookDAO(conn);
			bookDao.addBook(book);
			
			// after all:
			System.out.println(book);
			conn.commit();
			System.out.println("Book added successfully!");
		}catch(Exception e) {
			e.printStackTrace(); 
			conn.rollback();
			System.out.println("There was a problem. Book not added to database!");
		}finally{
			if(conn!=null) {
				conn.close();
			}
		}
	}


	@Override
	public void updateBook(Book book) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = util.getConnection();
			BookDAO bookDao = new BookDAO(conn);
			System.out.println(book);
			bookDao.updateBook(book);
			// after all:
			conn.commit();
			System.out.println("Book updated successfully!");
		}catch(Exception e) {
			e.printStackTrace(); 
			conn.rollback();
			System.out.println("There was a problem. Book not updated!");
		}finally{
			if(conn!=null) {
				conn.close();
			}
		}
		
	}

	@Override
	public ArrayList<Book> readAllBooks(Book book) {
		Connection conn = null;
		try {
			conn = util.getConnection();
			BookDAO bookDao = new BookDAO(conn);
			bookDao.readAllBooks(book);
			System.out.println("We Want to see all books");
		    
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}

	@Override
	public void deleteBook(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAuthor(Author author) throws SQLException {
		Connection conn = null;
				
				try {
					System.out.println(author);
					//System.out.println("Add a book:");
					conn = util.getConnection();
					AuthorDAO authorDao = new AuthorDAO(conn);
					authorDao.addAuthor(author);
					
					// after all:
					System.out.println(author);
					conn.commit();
					System.out.println("Author added successfully!");
				}catch(Exception e) {
					e.printStackTrace(); 
					conn.rollback();
					System.out.println("There was a problem. Book not added to database!");
				}finally{
					if(conn!=null) {
						conn.close();
					}
				}
		
	}

	@Override
	public void updateAuthor(Author author) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Author> readAllAuthors(Author author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAuthor(Author author) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addGenre(Genre genre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGenre(Genre genre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Genre> readAllGenres(Genre genre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteGenre(Genre genre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPublisher(Publisher publisher) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePublisher(Publisher publisher) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Publisher> readAllPublishers(Publisher publisher) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePublisher(Publisher publisher) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addLibrary(Library library) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateLibrary(Library library) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Library> readAllLibraries(Library library) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBook(Library library) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addBorrower(Borrower borrower) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBorrower(Borrower borrower) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Borrower> readAllBorrowers(Borrower borrower) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBorrower(Borrower borrower) {
		// TODO Auto-generated method stub
		
	}
	
	
}
