package com.dss.lms.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dss.lms.dao.AuthorDAO;
import com.dss.lms.dao.BookDAO;
import com.dss.lms.dao.BorrowerDAO;
import com.dss.lms.dao.GenreDAO;
import com.dss.lms.dao.LibraryDAO;
import com.dss.lms.dao.PublisherDAO;
import com.dss.lms.model.Author;
import com.dss.lms.model.Book;
import com.dss.lms.model.Borrower;
import com.dss.lms.model.Genre;
import com.dss.lms.model.Library;
import com.dss.lms.model.Publisher;
import com.dss.lms.presentation.Admin.AdminPresentation;

public class AdminService {

	Util util = new Util();

	public void addBook(Book book) throws SQLException, ClassNotFoundException {
		Connection conn = null;
      
		try {
			conn = util.getConnection();
			BookDAO bookDao = new BookDAO(conn);
			//AuthorDAO aDao = new AuthorDAO(conn);
			//aDao.addToBookAuthors(2);
			//bookDao.addToBookAuthors(book.getId());
//			System.out.println(book.getId());
//			System.out.println(book.getTitle());
//			System.out.println(book.getPubId());
			bookDao.addBook(book);

			conn.commit();
			System.out.println("Book added successfully!");
		} catch (Exception e) {
			
			conn.rollback();
			System.out.println("There was a problem. Book not added to database!");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public void updateBook(Book book) throws SQLException, ClassNotFoundException {
		// verified working
		Connection conn = null;
		try {
			conn = util.getConnection();
			BookDAO bookDao = new BookDAO(conn);
			bookDao.updateBook(book);
		
			conn.commit();
			System.out.println("Book updated successfully!");
		} catch (SQLException e) {
			
			conn.rollback();
			System.out.println("There was a problem. Book not updated!");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}

	}

	public void readAllBooks() throws SQLException, ClassNotFoundException {
		// verified working
		Connection conn = null;
		
		try {

			conn = util.getConnection();
			BookDAO bookDao = new BookDAO(conn);
			bookDao.readAllBooks();
			
		} catch (SQLException e) {
			
			conn.rollback();
			System.out.println("There was a problem. Line 85 in Admin service");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}

	}

	public Book readBookById(Integer bookid) throws SQLException, ClassNotFoundException {
		Connection conn = null;
		// List<Book> books = null;
		try {

			conn = util.getConnection();
			BookDAO bookDao = new BookDAO(conn);
			List<Book> books = bookDao.readBookById(bookid);
			if (books.size() == 0) {
				return null;
			}
			return books.get(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			conn.rollback();
			System.out.println("There was a problem. Book not updated!");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return null;

	}

	
	
	public void deleteBook(Integer id) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			BookDAO bookDao = new BookDAO(conn);
			bookDao.deleteBook(id);
			conn.commit();
			System.out.println("Book deleted");
            
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			
			System.out.println("There was a problem.");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("There was a problem.");
			
		} finally {
			if (conn != null) {
				conn.close();
			}
		}

	}

	public void addAuthor(Author author) throws SQLException {
		Connection conn = null;

		try {
	
			conn = util.getConnection();
			AuthorDAO authorDao = new AuthorDAO(conn);
			authorDao.addAuthor(author);

			conn.commit();
			System.out.println("Author added successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			System.out.println("There was a problem. Book not added to database!");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}

	}

	public void updateAuthor(Author author) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			AuthorDAO aDao = new AuthorDAO(conn);
			aDao.updateAuthor(author);
			// after all:
			conn.commit();
			System.out.println("Author updated successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
			System.out.println("There was a problem. ");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}

	}

	public void readAllAuthors() throws SQLException, ClassNotFoundException {

		Connection conn = null;
		// List<Book> books = null;
		try {

			conn = util.getConnection();
			AuthorDAO aDao = new AuthorDAO(conn);
			aDao.readAllAuthors();
			
		} catch (SQLException e) {
			
			conn.rollback();
			System.out.println("There was a problem. Book not updated!");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}

	}

	

	public void deleteAuthor(Integer id) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			AuthorDAO aDao = new AuthorDAO(conn);
			aDao.deleteAuthor(id);
			conn.commit();
			System.out.println("Author deleted");
		
		} catch (ClassNotFoundException e) {
			conn.rollback();
			e.printStackTrace();
			System.out.println("There was a problem. Author not deleted!");

		} catch (SQLException e) {
			conn.rollback();
			System.out.println("There was a problem. Contact Admin!");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}

	}

	public void addGenre(Genre genre) throws SQLException {
		
		Connection conn = null;

		try {
			conn = util.getConnection();
			GenreDAO genreDao = new GenreDAO(conn);
			genreDao.addGenre(genre);

			conn.commit();
			System.out.println("Genre added successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			System.out.println("There was a problem. Genre not added to database!");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public void updateGenre(Genre genre) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			GenreDAO gDao = new GenreDAO(conn);
			gDao.updateGenre(genre);
			// after all:
			conn.commit();
			System.out.println("Genre updated successfully!");
		} catch (SQLException e) {
			
			conn.rollback();
			System.out.println("There was a problem. ");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public void readAllGenres() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		// List<Book> books = null;
		try {

			conn = util.getConnection();
			GenreDAO genreDao = new GenreDAO(conn);
			genreDao.readAllGenres();
			
		} catch (SQLException e) {
			
			conn.rollback();
			System.out.println("There was a problem. Contact Admin!");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public Genre readGenreById(Integer id) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		// List<Book> books = null;
		try {

			conn = util.getConnection();
			GenreDAO gDao = new GenreDAO(conn);
			List<Genre> genres = gDao.readGenreById(id);
			if (genres.size() == 0) {
				return null;
			}
			return genres.get(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			conn.rollback();
			System.out.println("There was a problem!");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return null;
	}
	
	public void deleteGenre(Integer id) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			GenreDAO gDao = new GenreDAO(conn);
			gDao.deleteGenre(id);
			conn.commit();
			System.out.println("Genre deleted");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("There was a problem!");
			conn.rollback();

		} catch (SQLException e) {
			System.out.println("There was a problem!");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}

	}

	public void addPublisher(Publisher publisher) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;

		try {
			System.out.println(publisher);
			// System.out.println("Add a book:");
			conn = util.getConnection();
			PublisherDAO publisherDao = new PublisherDAO(conn);
			publisherDao.addPublisher(publisher);

			// after all:
			System.out.println(publisher);
			conn.commit();
			System.out.println("Publisher added successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			System.out.println("There was a problem. Publisher not added to database!");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public void updatePublisher(Publisher publisher) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			PublisherDAO pDao = new PublisherDAO(conn);
			pDao.updatePublisher(publisher);
			// after all:
			conn.commit();
			System.out.println("Publisher updated successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
			System.out.println("There was a problem. ");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}

	}

	public void readAllPublishers() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		// List<Book> books = null;
		try {

			conn = util.getConnection();
			PublisherDAO pubDao = new PublisherDAO(conn);
			pubDao.readAllPublishers();
			// return books;
		} catch (SQLException e) {
			conn.rollback();
			// TODO Auto-generated catch block
			System.out.println("There was a problem. pub not updated!");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		} 

	}

	public void deletePublisher(Integer id) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			PublisherDAO pDao = new PublisherDAO(conn);
			pDao.deletePublisher(id);
			
            conn.commit();
            System.out.println("Publisher deleted");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("There was a problem.");
			conn.rollback();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("There was a problem.");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}

	}

	public void addLibrary(Library library) throws SQLException {
		Connection conn = null;

		try {
			conn = util.getConnection();
			LibraryDAO libDao = new LibraryDAO(conn);
			libDao.addLibrary(library);
			conn.commit();
			System.out.println("Library added successfully!");
		} catch (Exception e) {
			conn.rollback();
			System.out.println("There was a problem completing your request!");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}

	}

	public void updateLibrary(Library library) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			LibraryDAO libDao = new LibraryDAO(conn);

			libDao.updateLibrary(library);
		
			conn.commit();
			System.out.println("updated successfully!");
		} catch (SQLException e) {
			conn.rollback();
			System.out.println("There was a problem completing your request!");
		} catch (ClassNotFoundException e) {
			System.out.println("There was a problem completing your request!");
			
		} finally {
			if (conn != null) {
				conn.close();
			}
		}

	}

	public void readAllLibraries() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		
		try {

			conn = util.getConnection();
			LibraryDAO libDao = new LibraryDAO(conn);
			libDao.readAllLibraries();
			
		} catch (SQLException e) {
			conn.rollback();
			System.out.println("There was a problem. Line  490 in admin servce!");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		} 
		
	}

	public void deleteLibrary(Integer id) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			LibraryDAO libDao = new LibraryDAO(conn);
			libDao.deleteLibrary(id);
			
            conn.commit();
            System.out.println("Library deleted");
		} catch (ClassNotFoundException e) {
			System.out.println("There was a problem completing your request!");
			conn.rollback();

		} catch (SQLException e) {
			System.out.println("There was a problem completing your request!");
			conn.rollback();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}

	}

	public void addBorrower(Borrower borrower) throws SQLException {
		Connection conn = null;

		try {
		
		
			conn = util.getConnection();
			BorrowerDAO borrowerDao = new BorrowerDAO(conn);
			borrowerDao.addBorrower(borrower);

			conn.commit();
			System.out.println("Borrower added successfully!");
		    
		} catch (Exception e) {
			
			conn.rollback();
			System.out.println("There was a problem. Borrower not added to database!");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}

	}

	public void updateBorrower(Borrower borrower) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			BorrowerDAO bDao = new BorrowerDAO(conn);
			bDao.updateBorrower(borrower);
		
			conn.commit();
			System.out.println("updated successfully!");
		} catch (SQLException e) {
			conn.rollback();
			System.out.println("There was a problem completing your request!");
		} catch (ClassNotFoundException e) {
			System.out.println("There was a problem completing your request!");
			
		} finally {
			if (conn != null) {
				conn.close();
			}
		}

	}

	public void readAllBorrowers() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		// List<Book> books = null;
		try {

			conn = util.getConnection();
			BorrowerDAO borrowerDao = new BorrowerDAO(conn);
			
			borrowerDao.readAllBorrowers();
			// return books;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			conn.rollback();
			System.out.println("There was a problem. borrower not updated!");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public void deleteBorrower(Integer id) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			BorrowerDAO bDao = new BorrowerDAO(conn);
			bDao.deleteBorrower(id);
			
            conn.commit();
            System.out.println("Borrower deleted");
		} catch (ClassNotFoundException e) {
			System.out.println("There was a problem complting your request!");
		} catch (SQLException e) {
			System.out.println("There was a problem complting your request!");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}

	}

	public Borrower readBorrowerById(Integer id) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		try {
            conn = util.getConnection();
			BorrowerDAO bDao = new BorrowerDAO(conn);
			List<Borrower> borrowers = bDao.readAllBorrowers();
			if (borrowers.size() == 0) {
				return null;
			}
			return borrowers.get(0);
		} catch (SQLException e) {
			System.out.println("There was a problem in adminService!");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return null;
	}

	public Author readAuthorById(Integer id) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		try {
            conn = util.getConnection();
			AuthorDAO aDao = new AuthorDAO(conn);
			List<Author> authors = aDao.readAuthorById(id);
			if (authors.size() == 0) {
				return null;
			}
			return authors.get(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			conn.rollback();
			System.out.println("There was a problem in adminService!");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return null;
	}

	public Publisher readPublisherById(Integer id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
            conn = util.getConnection();
			PublisherDAO pDao = new PublisherDAO(conn);
			List<Publisher> publishers = pDao.readPublisherById(id);
			if (publishers.size() == 0) {
				return null;
			}
			return publishers.get(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			conn.rollback();
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
