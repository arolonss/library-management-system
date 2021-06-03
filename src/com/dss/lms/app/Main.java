/**
 * 
 */
package com.dss.lms.app;

import java.util.Scanner;

/**
 * @author amanda
 *
 */
public class Main {

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to the Library Management System!");
		System.out.println("Which category user are you?");
		int userInput = sc.nextInt();
		System.out.println(userInput);
		sc.close();
		
	    switch (userInput)
	    {
	    	case 1:
	    		System.out.println("Welcome Librarian!");
	    		System.out.println("Enter branch you manage or go back to main menu");
	    		break;
	    	case 2:
	    		System.out.println("Welcome Admin!");
	    		System.out.println("admin menu");
	    		break;
	    	case 3:
	    		System.out.println("Welcome Borrower!");
	    		System.out.println("Enter your LMS card number: ");
	    		break;
	    	default:
	    	
	    		System.out.println("Invalid selection. Try Again!");
	    		break;
	    	
	    }
		//System.out.println("Welcome to the Library Management System!");
	}
}
