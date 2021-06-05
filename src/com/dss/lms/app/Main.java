/**
 * 
 */
package com.dss.lms.app;

import java.sql.SQLException;
import java.util.Scanner;

import com.dss.lms.menu.AdminMenu;
import com.dss.lms.menu.BaseMenu;
import com.dss.lms.presentation.AdminPresentation;
import com.dss.lms.presentation.BorrowerPresentation;
import com.dss.lms.presentation.LibrarianPresentation;
import com.dss.lms.presentation.Presentation;
import com.dss.lms.service.AdminService;
import com.dss.lms.service.AdminServiceInterface;

/**
 * @author amanda
 *
 */
public class Main {

	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
	    Presentation presentation = null;
		
		System.out.println("Welcome to the Library Management System!");
		System.out.println("Select your category user by the corresponding number: ");
		System.out.println("1) Librarian");
		System.out.println("2) Admin");
		System.out.println("3) Borrower");
		
		int userInput = sc.nextInt();
		System.out.println(userInput);
		
		
	    switch (userInput)
	    {
	    	case 1:
	    		
	    		System.out.println("Welcome Librarian!");
	    		presentation = new LibrarianPresentation();
	    		System.out.println("Enter branch you manage or go back to main menu");
	    		break;
	    	case 2:
	    		
	    		System.out.println();
	    		presentation = new AdminPresentation();
	    		presentation.menu();
	    		break;
	    	case 3:
	    		System.out.println("Welcome Borrower!");
	    		presentation = new BorrowerPresentation();
	    		System.out.println("Enter your LMS card number: ");
	    		break;
	    	default:
	    	
	    		System.out.println("Invalid selection. Try Again!");
	    		break;
	    	
	    }
	    
		//System.out.println("Welcome to the Library Management System!");
	}
}
