package com.dss.lms.presentation.Admin;

import java.sql.SQLException;
import java.util.Scanner;

import com.dss.lms.model.Author;
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
	public void readAll() throws ClassNotFoundException, SQLException {
		admin.readAllPublishers();

	}

	@Override
	public void readById(Integer id) throws ClassNotFoundException, SQLException {
		admin.readPublisherById(id);

	}

	@Override
	public void update(Integer id) throws SQLException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		Publisher p = new Publisher();

		System.out.println("Update" + " " + admin.readPublisherById(id).getName());
		String pubName;
		sc.useDelimiter("\\t");

		while (true) {
			System.out.println("Edit here: ");
			pubName = sc.nextLine();
			break;
		}

		p.setId(id);
		p.setName(pubName);

		admin.updatePublisher(p);

	}

	@Override
	public void delete(Integer id) throws SQLException, ClassNotFoundException {
		admin.deletePublisher(id);

	}

}
