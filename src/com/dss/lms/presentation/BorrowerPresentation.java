package com.dss.lms.presentation;

import java.sql.SQLException;


import com.dss.lms.service.BorrowerService;

public class BorrowerPresentation extends Presentation {
	BorrowerService borrower = new BorrowerService();
	@Override
	public void menu() throws SQLException, ClassNotFoundException {
		System.out.println("I am in borrower pres");
		
	}

}
