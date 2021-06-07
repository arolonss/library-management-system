package com.dss.lms.presentation;

import java.sql.SQLException;
import java.util.Scanner;

import com.dss.lms.app.Main;
import com.dss.lms.service.LibrarianService;

public class LibrarianPresentation extends Presentation {

	Scanner sc = new Scanner(System.in);
	LibrarianService librarian = new LibrarianService();

	@Override
	public void menu() throws SQLException, ClassNotFoundException {
		System.out.println("I am in librarian pres");
		System.out.println("Welcome to the Library Management System!");
		System.out.println("1) Enter Library you manage");
		System.out.println("2) Quit to previous");
//		
		int userInput = sc.nextInt();
		System.out.println(userInput);

		switch (userInput) {
		case 1:
			manageLibrary();
			break;

		case 2:
			System.out.println("Back to main menu");
			Main.main(null);

			break;
		default:

			System.out.println("Invalid selection. Try Again!");
			break;

		}

	}

	private void manageLibrary() throws ClassNotFoundException, SQLException {
		Scanner input = new Scanner(System.in);

		librarian.readAllLibraries();
		System.out.println("Which library do you manage?");
		Integer lib = input.nextInt();

		String library = librarian.readLibraryById(lib).getName();
		System.out.println(library);
		System.out.println("1) Update details of this library");
		System.out.println("2) Add copies to this library");

		System.out.println("3) Go back");

		Integer opt = input.nextInt();

		switch (opt) {
		case 1:
            updateLibraryDetails();
			
            break;
		case 2:
			addCopiesToLibrary();
			break;
		case 3:
			menu();
			break;
		default: 
		    System.out.println("Invalid selection. Try Again!");
			menu();
		}

	}

	private void addCopiesToLibrary() {
		System.out.println("add copies to library");
		
	}

	private void updateLibraryDetails() {
		System.out.println("updatelibrary details");
		
	}

}
