package com.dss.lms.presentation;

import java.sql.SQLException;
import java.util.Scanner;

import com.dss.lms.app.Main;
import com.dss.lms.model.Book;
import com.dss.lms.model.BookLoan;
import com.dss.lms.model.Library;
import com.dss.lms.presentation.Admin.AdminPresentation;
import com.dss.lms.service.BorrowerService;

public class BorrowerPresentation extends Presentation {
	Scanner sc = new Scanner(System.in);
	BorrowerService borrower = new BorrowerService();
	@Override
	public void menu() throws SQLException, ClassNotFoundException {
		System.out.println("I am in borrower pres");
		System.out.println("Welcome to the Library Management System!");
		System.out.println("What would you like to do today?");
		System.out.println("1) Check out a book");
		System.out.println("2) Return a book");
		System.out.println("3) Quit to previous");
		
		int userInput = sc.nextInt();
		System.out.println(userInput);
		
		
	    switch (userInput)
	    {
	    	case 1:
	    		checkOutABook();

	    		break;
	    	case 2:
	    		
	    		System.out.println("return a book");
	    		
	    		
	    		break;
	    	case 3:
	    		System.out.println("Back to main menu");
	    		Main.main(null);
	    		
	    		break;
	    	default:
	    	
	    		System.out.println("Invalid selection. Try Again!");
	    		break;
	    	
	    }
	    
		//System.out.println("Welcome to the Library Management System!");
	}
	private void checkOutABook() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		BookLoan bl = new BookLoan();
		System.out.println("Which library would you like to check out a book from?");
		borrower.readAllLibraries();
		
		Integer lib = sc.nextInt();
		borrower.showBooksAtLibrary(lib);
		
		System.out.println("Which book would you like to check out?");
		//Book book = sc.nextInt();
/*
 * 
 * 
 * 
 * createing bookloan 
 * 
 * 
 * 
 */
		//sc.useDelimiter("\\t");
//
//		while (true) {
//			booktitle = sc.nextLine();
//			break;
//		}
//
//		System.out.println("Add publisher by number here: ");
//		admin.readAllPublishers();
//		Scanner id = new Scanner(System.in);
//		Integer pubId;
//
//		pubId = id.nextInt();
//
//		bl.setLibraryId(lib);
//		bl.setBookId(pubId);
//
//		admin.addBook(b);
//		sc.close();
//		id.close();
//	
//		
	}

}
