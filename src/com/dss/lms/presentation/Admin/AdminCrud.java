package com.dss.lms.presentation.Admin;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dss.lms.model.Book;



public interface AdminCrud<T> {
    
	public void add() throws SQLException, ClassNotFoundException;
	public void update(Integer id) throws SQLException, ClassNotFoundException;
	public void readAll() throws ClassNotFoundException, SQLException;
	public void readById(Integer id) throws ClassNotFoundException, SQLException;
	public void delete(Integer id) throws SQLException,ClassNotFoundException;
}
