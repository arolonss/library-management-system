package com.dss.lms.presentation.Admin;

import java.sql.SQLException;
import java.util.Scanner;

import com.dss.lms.model.Library;
import com.dss.lms.service.AdminService;

public class AdminLibrary implements AdminCrud<Library> {
	private AdminService admin;
	
	
	public AdminLibrary(AdminService admin) {
		super();
		this.admin = admin;
	}

	@Override
	public void add() throws SQLException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Library l = new Library();
		System.out.println("Add a new library:");
		String newLib;
		String newLibAddress;
		sc.useDelimiter("\\t");
		while (true) {
			newLib = sc.nextLine();
			System.out.println("Library Address:");
			newLibAddress = sc.nextLine();
			break;
		}
		l.setName(newLib);
		l.setAddress(newLibAddress);
		admin.addLibrary(l);
		sc.close();
		
	}

	@Override
	public void update(Object obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readById(Integer id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

}
