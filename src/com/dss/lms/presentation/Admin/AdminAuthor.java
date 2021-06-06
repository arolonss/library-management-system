package com.dss.lms.presentation.Admin;

import java.sql.SQLException;
import java.util.Scanner;

import com.dss.lms.model.Author;
import com.dss.lms.service.AdminService;

public class AdminAuthor implements AdminCrud<Author> {
    AdminService admin;
	public AdminAuthor(AdminService admin) {
		// TODO Auto-generated constructor stub
		super();
		this.admin = admin;
	}
	
	public void add() throws SQLException {
		Scanner sc = new Scanner(System.in);
		Author a = new Author();
		System.out.println("Add an author:");
		String newAuthor;
		sc.useDelimiter("\\t");
		while (true) {
			newAuthor = sc.nextLine();
			break;
		}
		a.setName(newAuthor);
		admin.addAuthor(a);
		sc.close();

	}

	@Override
	public void update(Object obj) throws SQLException {
		System.out.println("in AdminAuthor update");
		
	}

	@Override
	public void readAll() throws ClassNotFoundException, SQLException {
		admin.readAllAuthors();
		
	}

	@Override
	public void delete(Object obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readById(Integer id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("in AdminBook.readById");
		admin.readAuthorById(id);
		
	}
	
	


}
