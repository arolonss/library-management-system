package com.dss.lms.presentation.Admin;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.dss.lms.app.Main;

import com.dss.lms.presentation.Presentation;
import com.dss.lms.service.AdminService;

public class AdminPresentation extends Presentation {
	AdminService admin = new AdminService();
	AdminBook adminBook;

	@Override
	public void menu() throws ClassNotFoundException, SQLException {

		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome Admin!");
		System.out.println("What are you working on today?");
		System.out.println("1) Books");
		System.out.println("2) Authors");
		System.out.println("3) Genres");
		System.out.println("4) Publishers");
		System.out.println("5) Libraries");
		System.out.println("6) Borrowers");
		System.out.println("7) Over-ride due date for a book loan");
		System.out.println("8) Quit to previous");

		try {
			int opt = sc.nextInt();
			System.out.println(opt);

			switch (opt)

			{
			case 1:
				bookOptions();
				break;
			case 2:
				authorOptions();
				break;
			case 3:
				genreOptions();
				break;
			case 4:
				publisherOptions();
				break;
			case 5:
				libraryOptions();
				break;
			case 6:
				borrowerOptions();
				break;
			case 7:
				overRideDueDate();
				break;
			case 8:
				Main.main(null);
				break;
			default:
				System.out.println("Invalid selection. Try again.");
				menu();
			}
		} catch (InputMismatchException e) {
			System.out.println("You must select an integer!");
			menu();
		}

	}

	private void borrowerOptions() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		AdminBorrower adminBorrower = new AdminBorrower(admin);
		System.out.println("1) Add a new borrower");
		System.out.println("2) View borrowers");
		System.out.println("3) Edit a borrower");
		System.out.println("4) Delete a borrower");
		System.out.println("5) Quit to previous");
		try {
			Integer opt = sc.nextInt();
			switch (opt)

			{
			case 1:
				adminBorrower.add();
				break;
			case 2:
				adminBorrower.readAll();
				break;
			case 3:
				adminBorrower.readAll();
				System.out.println("choose borrower to Update");
				Scanner bid = new Scanner(System.in);
				Integer id = bid.nextInt();
				adminBorrower.update(id);
				break;
			case 4:
				System.out.println("delete a borrower");
				adminBorrower.readAll();
				System.out.println("Select a borrower to delete");
				Scanner input = new Scanner(System.in);
				Integer btd = input.nextInt();

				adminBorrower.delete(btd);
				break;
			case 5:
				menu();
				break;
			default:
				System.out.println("invalid input");
				borrowerOptions();
			}
		} catch (InputMismatchException e) {
			System.out.println("You must select an integer!");
			borrowerOptions();
		}

	}

	private void libraryOptions() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		AdminLibrary adminLib = new AdminLibrary(admin);
		System.out.println("1) Add a new library");
		System.out.println("2) View libraries");
		System.out.println("3) Edit library");
		System.out.println("4) Delete a library");
		System.out.println("5) Quit to previous");
		try {
			Integer opt = sc.nextInt();
			switch (opt)

			{
			case 1:
				adminLib.add();
				libraryOptions();
				break;
			case 2:
				adminLib.readAll();
				break;
			case 3:
				adminLib.readAll();
				System.out.println("choose library to Update");
				Scanner id = new Scanner(System.in);
				Integer libId = id.nextInt();
				adminLib.update(libId);
				break;
			case 4:
				System.out.println("delete a library");
				adminLib.readAll();
				System.out.println("Select a library to delete");
				Scanner input = new Scanner(System.in);
				Integer ltd = input.nextInt();

				adminLib.delete(ltd);
				break;
			case 5:
				menu();
				break;
			default:
				System.out.println("invalid input");
				libraryOptions();
			}
		} catch (InputMismatchException e) {
			System.out.println("You must select an integer!");
			libraryOptions();
		}
	}

	private void publisherOptions() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		AdminPublisher adminPub = new AdminPublisher(admin);
		System.out.println("1) Add a new publisher");
		System.out.println("2) View publishers");
		System.out.println("3) Edit a publisher");
		System.out.println("4) Delete a publisher");
		System.out.println("5) Quit to previous");
		try {
			Integer opt = sc.nextInt();
			switch (opt)

			{
			case 1:
				adminPub.add();
				break;
			case 2:
				adminPub.readAll();
				break;
			case 3:
				adminPub.readAll();
				System.out.println("choose publisher to Update");
				Scanner id = new Scanner(System.in);
				Integer pid = id.nextInt();
				System.out.println(pid);
				adminPub.update(pid);
				break;
			case 4:
				System.out.println("delete a publisher");
				adminPub.readAll();
				System.out.println("Select a publisher to delete");
				Scanner input = new Scanner(System.in);
				Integer ptd = input.nextInt();

				adminPub.delete(ptd);
				break;
			case 5:
				menu();
				break;
			default:
				System.out.println("invalid input");
				publisherOptions();
			}
		} catch (InputMismatchException e) {
			System.out.println("You must select an integer!");
			publisherOptions();
		}

	}

	private void genreOptions() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		AdminGenre adminGenre = new AdminGenre(admin);
		System.out.println("1) Add a new genre");
		System.out.println("2) View genres");
		System.out.println("3) Edit a genre");
		System.out.println("4) Delete a genre");
		System.out.println("5) Quit to previous");
		try {
			Integer opt = sc.nextInt();
			switch (opt)

			{
			case 1:
				adminGenre.add();
				break;
			case 2:
				adminGenre.readAll();
				break;
			case 3:
				adminGenre.readAll();
				System.out.println("choose genre to Update");
				Scanner id = new Scanner(System.in);
				Integer gid = id.nextInt();
				adminGenre.update(gid);
				break;
			case 4:
				System.out.println("delete a genre");
				adminGenre.readAll();
				System.out.println("Select a genre to delete");
				Scanner gtd = new Scanner(System.in);
				Integer genreid = gtd.nextInt();

				adminGenre.delete(genreid);
				break;
			case 5:
				menu();
				break;
			default:
				System.out.println("invalid input");
				genreOptions();
			}
		} catch (InputMismatchException e) {
			System.out.println("You must select an integer!");
			genreOptions();
		}

	}

	private void authorOptions() throws SQLException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		AdminAuthor adminAuthor = new AdminAuthor(admin);
		System.out.println("1) Add a new author");
		System.out.println("2) View authors");
		System.out.println("3) Edit an author");
		System.out.println("4) Delete an author");
		System.out.println("5) Quit to previous");
		try {
			Integer opt = sc.nextInt();
			switch (opt)

			{
			case 1:
				adminAuthor.add();
				break;
			case 2:
				adminAuthor.readAll();
				break;
			case 3:
				adminAuthor.readAll();
				System.out.println("choose author to Update");
				Scanner id = new Scanner(System.in);
				Integer aid = id.nextInt();
				adminAuthor.update(aid);
				break;
			case 4:
				System.out.println("delete an author");
				adminAuthor.readAll();
				System.out.println("Select an author to delete");

				Scanner atd = new Scanner(System.in);
				Integer aToDelete = atd.nextInt();

				adminAuthor.delete(aToDelete);
				break;
			case 5:
				menu();
				break;
			default:
				System.out.println("invalid input");
				authorOptions();
			}
		} catch (InputMismatchException e) {
			System.out.println("You must select an integer!");
			authorOptions();
		}
	}

	public void bookOptions() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		AdminBook adminBook = new AdminBook(admin);

		System.out.println("1) Add a new book");
		System.out.println("2) View books");
		System.out.println("3) Edit a book");
		System.out.println("4) Delete a book");
		System.out.println("5) Quit to previous");
		try {

			int opt = sc.nextInt();
			System.out.println(opt);

			switch (opt)

			{
			case 1:
				adminBook.add();
				break;
			case 2:
				System.out.println(admin);
				System.out.println("View books");
				adminBook.readAll();
				bookOptions();
				break;

			case 3:
				adminBook.readAll();
				System.out.println("choose book to Update");

				Scanner id = new Scanner(System.in);

				Integer bookid = id.nextInt();

				adminBook.update(bookid);

				break;

			case 4:
				adminBook.readAll();
				System.out.println("Select a book to delete");
				Scanner btd = new Scanner(System.in);
				Integer bookToDelete = btd.nextInt();

				adminBook.delete(bookToDelete);

				break;
			case 5:
				menu();
				break;
			default:
				System.out.println("invalid input");
				bookOptions();
			}
		} catch (InputMismatchException e) {
			System.out.println("You must select an integer!");
			bookOptions();
		}
		sc.close();
	}

	public void overRideDueDate() {

	}
    
}
