package com.dss.lms.presentation.Admin;

import java.sql.SQLException;
import java.util.Scanner;

import com.dss.lms.model.Publisher;
import com.dss.lms.service.AdminService;

public class AdminPublisher implements AdminCrud<Publisher> {
    AdminService admin;
    
	public AdminPublisher(AdminService admin) {
		super();
		this.admin = admin;
	}

	@Override
	public void add() throws SQLException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Publisher p = new Publisher();
		System.out.println("Add a new publisher:");
		String newPublisher;
		String newPubAddress;
		String newPubPhone;
		sc.useDelimiter("\\t");
		while (true) {
			newPublisher = sc.nextLine();
			System.out.println("Publisher Address:");
			newPubAddress = sc.nextLine();
			System.out.println("Publisher Phone:");
			newPubPhone = sc.nextLine();
			break;
		}

		p.setName(newPublisher);
		p.setAddress(newPubAddress);
		p.setPhone(newPubPhone);
		admin.addPublisher(p);
		sc.close();
		
	}
	@Override
	public void update(Object obj) throws SQLException {
		Scanner sc = new Scanner(System.in);
		Publisher p = new Publisher();
		System.out.println("Edit publisher:");
		String newPublisher;
		String newPubAddress;
		String newPubPhone;
		sc.useDelimiter("\\t");
		while (true) {
			newPublisher = sc.nextLine();
			System.out.println("Publisher Address:");
			newPubAddress = sc.nextLine();
			System.out.println("Publisher Phone:");
			newPubPhone = sc.nextLine();
			break;
		}

		p.setName(newPublisher);
		p.setAddress(newPubAddress);
		p.setPhone(newPubPhone);
		admin.updatePublisher(p);
		sc.close();
		
	}
	@Override
	public void readAll() throws ClassNotFoundException, SQLException {
		admin.readAllPublishers();
		
	}
	@Override
	public void delete(Object obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readById(Integer id) throws ClassNotFoundException, SQLException {
		admin.readPublisherById(id);
		
	}}
