/**
 * 
 */
package com.dss.lms.presentation;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.dss.lms.model.Author;
import com.dss.lms.model.Book;
import com.dss.lms.model.Genre;
import com.dss.lms.model.Library;
import com.dss.lms.model.Publisher;
import com.dss.lms.service.AdminService;

/**
 * @author amanda
 *
 */
public class Presentation {

	AdminService admin = new AdminService();

	public void menu() throws SQLException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.println("Welcome Admin!");
		System.out.println("What are you working on today?");
		System.out.println("1) Books");
		System.out.println("2) Authors");
		System.out.println("3) Genres");
		System.out.println("4) Publishers");
		System.out.println("5) Libraries");
		System.out.println("6) Borrowers");
		System.out.println("7) Over-ride due date for a book loan");
		int opt = sc.nextInt();
		System.out.println(opt);

		switch (opt)

		{
		case 1:

			System.out.println(this);
			System.out.println(admin);
			System.out.println("Book OPtions");
			System.out.println("");

			bookOptions();

//				
			break;
		case 2:
			System.out.println(admin);
			System.out.println("1) Add an author");
			// System.out.println("2) View all authors");
			getNewAuthor();

			break;
//			    System.out.println("show list of authors");
		case 3:
			getNewGenre();
			break;
		// System.out.println("");
		case 4:
			getNewPublisher();
			break;
//			    System.out.println("show list of publishers");
		case 5:
			getNewLibrary();
			break;
//			    System.out.println("show list of libraries");
		case 6:
			getNewBorrower();
			break;
//			    System.out.println("show list of borrowers");
		case 7:
			overRideDueDate();
			break;
//			    System.out.println("change duedate");
		default:
			System.out.println("invalid input");
		}

	}

	public void bookOptions() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.println("Welcome Admin!");
		System.out.println("What are you working on today?");
		System.out.println("1) Add a new book");
		System.out.println("2) View books");
//		System.out.println("3) Genres");
//		System.out.println("4) Publishers");
//		System.out.println("5) Libraries");
//		System.out.println("6) Borrowers");
//		System.out.println("7) Over-ride due date for a book loan");
		int opt = sc.nextInt();
		System.out.println(opt);

		switch (opt)

		{
		case 1:

			System.out.println(this);
			System.out.println(admin);
			System.out.println("Book OPtions");
			System.out.println("");

			bookOptions();

//				
			break;
		case 2:
			System.out.println(admin);
			System.out.println("View books");
			// System.out.println("2) View all authors");
//				readAllBooks();
			admin.readAllBooks(null).forEach(b -> System.out.println(b));
			break;
////			    System.out.println("show list of authors");
//			case 3:
//				getNewGenre();
//				break;
//			    //System.out.println("");			
//			case 4:
//				getNewPublisher();
//				break;
////			    System.out.println("show list of publishers");
//			case 5:
//				getNewLibrary();
//				break;
////			    System.out.println("show list of libraries");
//			case 6:
//				getNewBorrower();
//				break;
////			    System.out.println("show list of borrowers");
//			case 7:
//				overRideDueDate();
//				break;
////			    System.out.println("change duedate");
		default:
			System.out.println("invalid input");
		}
	}

//	private void readAllBooks() {
//		
//		
//	}

	public void getNewBook() throws SQLException {
		Scanner sc = new Scanner(System.in);
		Book b = new Book();
		System.out.println("Add a book:");
		String booktitle;
		sc.useDelimiter("\\t");

		while (true) {
			booktitle = sc.nextLine();
			break;
		}
		System.out.println(booktitle);
		b.setTitle(booktitle);
		b.setPubId(3);
		admin.addBook(b);
		sc.close();
	}

	public void getNewAuthor() throws SQLException {
		Scanner sc = new Scanner(System.in);
		Author a = new Author();
		System.out.println("Add an author:");
		String newAuthor;
		sc.useDelimiter("\\t");
		while (true) {
			newAuthor = sc.nextLine();
			break;
		}
		a.setName(newAuthor);
		admin.addAuthor(a);
		sc.close();

	}

	public void getNewGenre() throws SQLException {
		Scanner sc = new Scanner(System.in);
		Genre g = new Genre();
		System.out.println("Add a new genre:");
		String newGenre;
		sc.useDelimiter("\\t");
		while (true) {
			newGenre = sc.nextLine();
			break;
		}
		g.setName(newGenre);
		admin.addGenre(g);
		sc.close();
	}

	public void getNewPublisher() throws SQLException {
		Scanner sc = new Scanner(System.in);
		Publisher p = new Publisher();
		System.out.println("Add a new publisher:");
		String newPublisher;
		String newPubAddress;
		String newPubPhone;
		sc.useDelimiter("\\t");
		while (true) {
			newPublisher = sc.nextLine();
			System.out.println("Publisher Address:");
			newPubAddress = sc.nextLine();
			System.out.println("Publisher Phone:");
			newPubPhone = sc.nextLine();
			break;
		}

		p.setName(newPublisher);
		p.setAddress(newPubAddress);
		p.setPhone(newPubPhone);
		admin.addPublisher(p);
		sc.close();

	}

	public void getNewLibrary() throws SQLException {
		Scanner sc = new Scanner(System.in);
		Library l = new Library();
		System.out.println("Add a new library:");
		String newLib;
		String newLibAddress;
		sc.useDelimiter("\\t");
		while (true) {
			newLib = sc.nextLine();
			System.out.println("Library Address:");
			newLibAddress = sc.nextLine();
			break;
		}
		l.setName(newLib);
		l.setAddress(newLibAddress);
		admin.addLibrary(l);
		sc.close();

	}

	public void getNewBorrower() throws SQLException {
		Scanner sc = new Scanner(System.in);
		Author a = new Author();
		System.out.println("Add an author:");
		String newAuthor;
		sc.useDelimiter("\\t");
		while (true) {
			newAuthor = sc.nextLine();
			break;
		}
		a.setName(newAuthor);
		admin.addAuthor(a);
		sc.close();

	}

	public void overRideDueDate() {

	}

}
