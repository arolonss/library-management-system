package com.dss.lms.presentation.Admin;

import java.sql.SQLException;

import java.util.Scanner;

import com.dss.lms.model.Book;

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
		Scanner sc = new Scanner(System.in);
		Book b = new Book();
		
		System.out.println("Add a book:");
		String booktitle;
	    Integer pubId;
		sc.useDelimiter("\\t");

		while (true) {
			booktitle = sc.nextLine();

			break;
		}
	
		b.setTitle(booktitle);
		Scanner id = new Scanner(System.in);
		System.out.println("Add publisher by number here: ");
		admin.readAllPublishers();
		
		pubId = id.nextInt();
//		System.out.println("Who wrote this book?");
//		admin.readAllAuthors();
//		author = sc.nextInt();

	    //ba.setAuthorId(author);
        
		b.setPubId(pubId);
		System.out.println(b.getTitle());
		System.out.println(b.getPubId());
		

		admin.addBook(b);
		sc.close();
		id.close();

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
