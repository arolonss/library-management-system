package com.dss.lms.presentation.Admin;

import java.sql.SQLException;
import java.util.Scanner;

import com.dss.lms.model.Author;
import com.dss.lms.model.Genre;
import com.dss.lms.service.AdminService;

public class AdminGenre implements AdminCrud<Genre> {
    private AdminService admin;

	public AdminGenre(AdminService admin) {
		super();
		this.admin = admin;	
	}

	@Override
	public void add() throws SQLException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		Genre g = new Genre();
		System.out.println("Add a new genre:");
		String newGenre;
		sc.useDelimiter("\\t");
		while (true) {
			newGenre = sc.nextLine();
			break;
		}
		g.setName(newGenre);
		admin.addGenre(g);
		sc.close();
	}

	@Override
	public void update(Integer id) throws SQLException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		Genre g = new Genre();
        
		System.out.println("Update" + " " + admin.readGenreById(id).getName());
		String gName;
		sc.useDelimiter("\\t");

		while (true) {
			System.out.println("Edit here: ");
			gName = sc.nextLine();
			break;
		}

		g.setId(id);
		g.setName(gName);

		admin.updateGenre(g);
		
	}

	@Override
	public void readAll() throws ClassNotFoundException, SQLException {
		admin.readAllGenres();
	}

	@Override
	public void delete(Integer id) throws SQLException, ClassNotFoundException {
		admin.deleteGenre(id);
	}

	@Override
	public void readById(Integer id) throws ClassNotFoundException, SQLException {
		admin.readGenreById(id).getName();
		
	}

}
