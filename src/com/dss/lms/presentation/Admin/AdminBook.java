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
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Book b = new Book();
		System.out.println("Add a book:");
		String booktitle;
		sc.useDelimiter("\\t");

		while (true) {
			booktitle = sc.nextLine();
			break;
		}
		
		System.out.println("Add publisher by number here: ");
		admin.readAllPublishers();
		Scanner id = new Scanner(System.in);
		Integer pubId; 
		
		pubId = id.nextInt();
			
		b.setTitle(booktitle);
		b.setPubId(pubId);
		
		admin.addBook(b);
		sc.close();
		id.close();

	}

	@Override
	public void update(Object obj) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        Book b = new Book();
		// Book b = admin.readBookById(book);
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
		Scanner id = new Scanner(System.in);
		Integer pubId;
		pubId = id.nextInt();
		
		b.setTitle(booktitle);
		b.setPubId(pubId);
		
		admin.updateBook(b);
		sc.close();
        id.close();
	}

	public void readById(Integer id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		System.out.println("in AdminBook.readById");
		admin.readBookById(id); // .forEach(b -> System.out.println(b.getName()));

	}

	@Override
	public void readAll() throws ClassNotFoundException, SQLException {
		admin.readAllBooks(); 
    }

	@Override
	public void delete(Object obj) throws SQLException {
		// TODO Auto-generated method stub

	}
}
