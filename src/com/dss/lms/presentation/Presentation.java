/**
 * 
 */
package com.dss.lms.presentation;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.dss.lms.model.Author;
import com.dss.lms.model.Book;
import com.dss.lms.model.Genre;
import com.dss.lms.model.Library;
import com.dss.lms.model.Publisher;
import com.dss.lms.service.AdminService;

/**
 * @author amanda
 *
 */
public abstract class Presentation {

	

	abstract public void menu() throws SQLException, ClassNotFoundException;
		

}
