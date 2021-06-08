/**
 * 
 */
package com.dss.lms.app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.dss.lms.presentation.BorrowerPresentation;
import com.dss.lms.presentation.LibrarianPresentation;
import com.dss.lms.presentation.Presentation;
import com.dss.lms.presentation.Admin.AdminPresentation;

import com.dss.lms.service.BorrowerService;

/**
 * @author amanda
 *
 */
public class Main {

	public static void main(String[] args) throws ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		Presentation presentation = null;

		System.out.println("Welcome to the Library Management System!");
		System.out.println("Select your category user by the corresponding number: ");
		System.out.println("1) Librarian");
		System.out.println("2) Admin");
		System.out.println("3) Borrower");
		try {
			int userInput = sc.nextInt();
			System.out.println(userInput);

			switch (userInput) {
			case 1:

				System.out.println("Welcome Librarian!");
				presentation = new LibrarianPresentation();

				presentation.menu();

				break;
			case 2:

				System.out.println();
				presentation = new AdminPresentation();
				presentation.menu();
				break;
			case 3:
				getBorrowerCardNo();
				break;
			default:

				System.out.println("Invalid selection. Try Again!");
				main(null);
				break;

			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("Invalid input. Please use an integer.");
			main(null);
		}

	}

	private static void getBorrowerCardNo() throws ClassNotFoundException, SQLException {
		BorrowerService bs = new BorrowerService();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your LMS card number: ");
		try {
			Integer cardNo = sc.nextInt();
			if (bs.verifyCardNo(cardNo)) {
				Presentation presentation = new BorrowerPresentation();
				presentation.menu();
			} else {
				System.out.println("invalid card number. Try again later.");
				main(null);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
