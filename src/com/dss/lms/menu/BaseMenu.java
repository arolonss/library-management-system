package com.dss.lms.menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.dss.lms.service.AdminService;
import com.dss.lms.service.AdminServiceInterface; 

public abstract class BaseMenu {
    
	//protected Scanner sc;
	protected AdminService admin;
	
	
	public BaseMenu(AdminService admin) {
		System.out.println(this);
		//this.sc = new Scanner(System.in);
		this.admin = admin;
		this.menu();
		
	}
	
	public abstract void menu(); 
}
