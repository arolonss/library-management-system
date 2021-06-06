package com.dss.lms.presentation.Admin;

import java.sql.SQLException;
import java.util.Scanner;


import com.dss.lms.model.Borrower;
import com.dss.lms.service.AdminService;

public class AdminBorrower implements AdminCrud<Borrower> {
	AdminService admin;
	public AdminBorrower(AdminService admin) {
		super();
		this.admin = admin;
	}

	@Override
	public void add() throws SQLException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		Borrower b = new Borrower();
		System.out.println("Add a borrower:");
		String name, address, phone;
		sc.useDelimiter("\\t");
		while (true) {
			name = sc.nextLine();
			System.out.println("Add address:");
			address = sc.nextLine();
			System.out.println("Add phone:");
			phone = sc.nextLine();
			break;
		}
		b.setName(name);
		b.setAddress(address);
		b.setPhone(phone);
		admin.addBorrower(b);
		sc.close();
		this.readAll();
	}

	@Override
	public void update(Object obj) throws SQLException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		Borrower b = new Borrower();
		System.out.println("Edit borrower:");
		String name, address, phone;
		sc.useDelimiter("\\t");
		while (true) {
			name = sc.nextLine();
			System.out.println("Edit address:");
			address = sc.nextLine();
			System.out.println("Edit phone:");
			phone = sc.nextLine();
			break;
		}
		b.setName(name);
		b.setAddress(address);
		b.setPhone(phone);
		admin.updateBorrower(b);
		sc.close();
		
	}

	@Override
	public void readAll() throws ClassNotFoundException, SQLException {
		admin.readAllBorrowers();
	}

	@Override
	public void delete(Object obj) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readById(Integer id) throws ClassNotFoundException, SQLException {
		admin.readBorrowerById(id);	
	}

}
