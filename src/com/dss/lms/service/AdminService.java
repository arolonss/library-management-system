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

public class AdminService {

	Util util = new Util();

	public void addBook(Book book) throws SQLException {
		Connection conn = null;
        // verified working
		try {
			conn = util.getConnection();
			BookDAO bookDao = new BookDAO(conn);
			//System.out.println(book.getPublisher());
			// System.out.println("Add a book:");
			
			bookDao.addBook(book);

			// after all:
			
			conn.commit();
			System.out.println("Book added successfully!");
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

	public void updateBook(Book book) throws SQLException, ClassNotFoundException {
		// verified working
		Connection conn = null;
		try {
			conn = util.getConnection();
			BookDAO bookDao = new BookDAO(conn);
			System.out.println(book.getTitle());
			System.out.println(book.getPubId());
			System.out.println(book.getId());
			bookDao.updateBook(book);
			// after all:
			conn.commit();
			System.out.println("Book updated successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
			System.out.println("There was a problem. Book not updated!");
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

	public Book readBookById(Book book) throws SQLException, ClassNotFoundException {
		Connection conn = null;
		// List<Book> books = null;
		try {

			conn = util.getConnection();
			BookDAO bookDao = new BookDAO(conn);
			List<Book> books = bookDao.readBookById(book);
			if (books.size() == 0) {
				return null;
			}
			return books.get(0);
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

	public void deleteBook(Book book) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			BookDAO bookDao = new BookDAO(conn);
			bookDao.deleteBook(book);
			System.out.println("Book deleted");
            conn.commit();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("There was a problem. Book not updated!");

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

	public void addAuthor(Author author) throws SQLException {
		Connection conn = null;

		try {
			System.out.println(author);
			// System.out.println("Add a book:");
			conn = util.getConnection();
			AuthorDAO authorDao = new AuthorDAO(conn);
			authorDao.addAuthor(author);

			// after all:
			System.out.println(author);
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

	public void updateAuthor(Author author) {
		// TODO Auto-generated method stub

	}

	public void readAllAuthors() throws SQLException, ClassNotFoundException {

		Connection conn = null;
		// List<Book> books = null;
		try {

			conn = util.getConnection();
			AuthorDAO aDao = new AuthorDAO(conn);
			aDao.readAllAuthors();
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

	

	public void deleteAuthor(Author author) {
		// TODO Auto-generated method stub

	}

	public void addGenre(Genre genre) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;

		try {
			System.out.println(genre);
			// System.out.println("Add a book:");
			conn = util.getConnection();
			GenreDAO genreDao = new GenreDAO(conn);
			genreDao.addGenre(genre);

			// after all:
			System.out.println(genre);
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

	public void updateGenre(Genre genre) {
		// TODO Auto-generated method stub

	}

	public void readAllGenres() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		// List<Book> books = null;
		try {

			conn = util.getConnection();
			GenreDAO genreDao = new GenreDAO(conn);
			genreDao.readAllGenres();
			// return books;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("There was a problem. Contact Admin!");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public void deleteGenre(Genre genre) {
		// TODO Auto-generated method stub

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

	public void updatePublisher(Publisher publisher) {
		// TODO Auto-generated method stub

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
			// TODO Auto-generated catch block
			System.out.println("There was a problem. pub not updated!");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		} // TODO Auto-generated method stub

	}

	public void deletePublisher(Publisher publisher) {
		// TODO Auto-generated method stub

	}

	public void addLibrary(Library library) throws SQLException {
		Connection conn = null;

		try {
			System.out.println(library);
			// System.out.println("Add a book:");
			conn = util.getConnection();
			LibraryDAO libDao = new LibraryDAO(conn);
			libDao.addLibrary(library);

			// after all:
			System.out.println(library);
			conn.commit();
			System.out.println("Library added successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			System.out.println("There was a problem. Library not added to database!");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}

	}

	public void updateLibrary(Library library) {
		// TODO Auto-generated method stub

	}

	public void readAllLibraries() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		
		try {

			conn = util.getConnection();
			LibraryDAO libDao = new LibraryDAO(conn);
			libDao.readAllLibraries();
			
		} catch (SQLException e) {
			System.out.println("There was a problem. Line  359 in admin servce!");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		} 
		
	}

	public void deleteLibrary(Library library) {
		// TODO Auto-generated method stub

	}

	public void addBorrower(Borrower borrower) throws SQLException {
		Connection conn = null;

		try {
			System.out.println(borrower);
			// System.out.println("Add a book:");
			conn = util.getConnection();
			BorrowerDAO borrowerDao = new BorrowerDAO(conn);
			borrowerDao.addBorrower(borrower);

			// after all:
			System.out.println(borrower);
			conn.commit();
			System.out.println("Borrower added successfully!");
		    
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			System.out.println("There was a problem. Borrower not added to database!");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}

	}

	public void updateBorrower(Borrower borrower) {
		// TODO Auto-generated method stub

	}

	public void readAllBorrowers() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		// List<Book> books = null;
		try {

			conn = util.getConnection();
			BorrowerDAO borrowerDao = new BorrowerDAO(conn);
			;
			borrowerDao.readAllBorrowers();
			// return books;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("There was a problem. borrower not updated!");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public void deleteBorrower(Borrower borrower) {
//		Connection conn = null;
//		try {
//			conn = util.getConnection();
//			BookDAO bookDao = new BookDAO(conn);
//			bookDao.deleteBook(book);
//			System.out.println("Book deleted");
//            conn.commit();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("There was a problem. Book not updated!");
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println("There was a problem. Book not updated!");
//			e.printStackTrace();
//		} finally {
//			if (conn != null) {
//				conn.close();
//			}
//		}

	}

//	public Borrower readBorrowerById(Integer id) throws ClassNotFoundException, SQLException {
//		Connection conn = null;
//		try {
//            conn = util.getConnection();
//			BorrowerDAO bDao = new BorrowerDAO(conn);
////			List<Borrower> borrowers = bDao.readBorrowersById(id);
//			if (borrowers.size() == 0) {
//				return null;
//			}
//			return borrowers.get(0);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println("There was a problem in adminService!");
//			e.printStackTrace();
//		} finally {
//			if (conn != null) {
//				conn.close();
//			}
//		}
//		return null;
//	}

	public Author readAuthorById(Integer id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
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
