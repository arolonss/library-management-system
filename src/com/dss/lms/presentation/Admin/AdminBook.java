package com.dss.lms.presentation.Admin;

import java.sql.SQLException;

import java.util.Scanner;

import com.dss.lms.model.Author;
import com.dss.lms.model.Book;
import com.dss.lms.model.BookAuthors;
import com.dss.lms.model.Publisher;
import com.dss.lms.service.AdminService;

public class AdminBook implements AdminCrud<Book> {

	private AdminService admin;

	/**
	 * 
	 */
	public AdminBook(AdminService admin) {
		super();
		this.admin = admin;

	}

	@Override
	public void add() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Book b = new Book();
		//BookAuthors ba = new BookAuthors();
		
		System.out.println("Add a book:");
		String booktitle;
	//    Integer author;
	    Integer pubId;
		sc.useDelimiter("\\t");

		while (true) {
			booktitle = sc.nextLine();
//			System.out.println("Who wrote this book?");
//			admin.readAllAuthors();
//			author = sc.nextInt();
			System.out.println("Add publisher by number here: ");
			admin.readAllPublishers();
			pubId = sc.nextInt();
			break;
		}
	
		 
	    //ba.setAuthorId(author);
        b.setTitle(booktitle);
		b.setPubId(pubId);
        
		

		admin.addBook(b);
		sc.close();
		

	}

	@Override
	public void update(Integer id) throws SQLException, ClassNotFoundException {
		
		Scanner sc = new Scanner(System.in);
		Book b = new Book();

		System.out.println("Update book:");
		String booktitle;
		sc.useDelimiter("\\t");

		while (true) {
			System.out.println("Edit here: ");
			booktitle = sc.nextLine();
			break;
		}

		System.out.println("Edit publisher by number here: ");
		admin.readAllPublishers();
		Scanner pid = new Scanner(System.in);
		Integer pubId = pid.nextInt();
		
		b.setId(id);
		b.setTitle(booktitle);
		b.setPubId(pubId);

		admin.updateBook(b);
		sc.close();
		pid.close();
	}

	@Override
	public void readById(Integer id) throws ClassNotFoundException, SQLException {
		System.out.println(admin.readBookById(id).getTitle());
	}

	@Override
	public void readAll() throws ClassNotFoundException, SQLException {
		admin.readAllBooks();
	}

	@Override
	public void delete(Integer id) throws SQLException {
		admin.deleteBook(id);

	}


}
