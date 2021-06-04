/**
 * 
 */
package com.dss.lms.presentation;

import java.sql.SQLException;
import java.util.Scanner;

import com.dss.lms.model.Author;
import com.dss.lms.model.Book;
import com.dss.lms.service.AdminService;

/**
 * @author amanda
 *
 */
public class Presentation {
	
	AdminService admin = new AdminService();
	public void menu() throws SQLException {
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
		
		switch(opt)
		
		{
			case 1:
				
//				Book book = new Book(9, "Lion the Witch and the Wardrobe", 1, 3);
				System.out.println(this);
//				System.out.println("Welcome Admin!");
				System.out.println(admin);
				System.out.println("1) Add a book:");
				System.out.println("");
				
				getNewBook();
				    
//				} else if (userInput == 2) {
//					Book b = new Book();
//					admin.readAllBooks(b);
//				}
//				System.out.println("3) Add genreenres");
//				System.out.println("4) Publishers");
//				System.out.println("5) Libraries");
//				System.out.println("6) Borrowers");
//				System.out.println("7) Over-ride due date for a book loan");
				
				
			    break;
			case 2:
				System.out.println(admin);
				//System.out.println("1) Add an author");
				//System.out.println("2) View all authors");
				getNewAuthor();
					
				break;
//				
//					Author a = new Author();
//					admin.readAllAuthors(a);
				
//			    System.out.println("show list of authors");
//			case 3:
//			    System.out.println("show list of genres");
//			case 4:
//			    System.out.println("show list of publishers");
//			case 5:
//			    System.out.println("show list of libraries");
//			case 6:
//			    System.out.println("show list of borrowers");
//			case 7:
//			    System.out.println("change duedate");
			default:
			    System.out.println("invalid input");
		}
		
		
	}
	
	
	public void getNewBook() throws SQLException {
		Scanner sc = new Scanner(System.in);
		Book b = new Book();
		System.out.println("Add a book:");
		String booktitle;
		sc.useDelimiter("\\t");
		
		while(true)
		{
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
		while(true)
		{
			newAuthor = sc.nextLine();
			break;
		}
		a.setName(newAuthor);
		admin.addAuthor(a);
		sc.close();
		
	}
	
		
		
	
	    
	
}
