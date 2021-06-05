/**
 * 
 */
package com.dss.lms.menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.dss.lms.dao.AuthorDAO;
import com.dss.lms.dao.BookDAO;
import com.dss.lms.dao.PublisherDAO;
import com.dss.lms.model.Book;
import com.dss.lms.service.AdminService;

/**
 * @author amanda
 *
 */
public class AdminMenu extends BaseMenu {
	//Scanner sc;
	
	public AdminMenu() throws ClassNotFoundException, SQLException {
		super(new AdminService(
				)); 
	}

	@Override
	public void menu() {
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
		int userInput = sc.nextInt();
		System.out.println(userInput);
		
		switch(userInput)
		{
			case 1:
				System.out.println(admin);
//				Book book = new Book(9, "Lion the Witch and the Wardrobe", 1, 3);
//				
//				
			    break;
			case 2:
			    System.out.println("show list of authors");
			case 3:
			    System.out.println("show list of genres");
			case 4:
			    System.out.println("show list of publishers");
			case 5:
			    System.out.println("show list of libraries");
			case 6:
			    System.out.println("show list of borrowers");
			case 7:
			    System.out.println("change duedate");
			default:
			    System.out.println("invalid input");
		}
		sc.close();
		
	}
	

}
