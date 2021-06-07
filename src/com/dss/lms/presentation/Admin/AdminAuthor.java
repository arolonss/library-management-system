package com.dss.lms.presentation.Admin;

import java.sql.SQLException;
import java.util.Scanner;

import com.dss.lms.model.Author;
import com.dss.lms.model.Book;
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
	public void update(Integer id) throws SQLException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		Author a = new Author();
        
		System.out.println("Update" + " " + admin.readAuthorById(id).getName());
		String authorName;
		sc.useDelimiter("\\t");

		while (true) {
			System.out.println("Edit here: ");
			authorName = sc.nextLine();
			break;
		}

		a.setId(id);
		a.setName(authorName);

		admin.updateAuthor(a);
		

	}

	@Override
	public void readAll() throws ClassNotFoundException, SQLException {
		admin.readAllAuthors();

	}

	@Override
	public void delete(Integer id) throws SQLException {
		admin.deleteAuthor(id);

	}

	@Override
	public void readById(Integer id) throws ClassNotFoundException, SQLException {
		admin.readAuthorById(id).getName();

	}

}
