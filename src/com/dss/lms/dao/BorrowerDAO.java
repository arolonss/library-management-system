package com.dss.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dss.lms.model.Book;
import com.dss.lms.model.Borrower;

public class BorrowerDAO extends BaseDAO<Borrower> {

	public BorrowerDAO(Connection conn) {
		super(conn);
	}

	
	public void addBorrower(Borrower borrower) throws ClassNotFoundException, SQLException {
		save("INSERT INTO tbl_borrower VALUES(?, ?, ?, ?)", new Object[] { borrower.getCardNo(), borrower.getName(), borrower.getAddress(), borrower.getPhone() });
	}

	public void updateBorrower(Borrower borrower) throws SQLException, ClassNotFoundException {
		save("UPDATE tbl_borrower SET name = ?, address = ?, phone = ? where cardNo = ?", new Object[] { borrower.getName(), borrower.getAddress(), borrower.getPhone(), borrower.getCardNo() });

	}

	public List<Borrower> readAllBorrowers() throws ClassNotFoundException, SQLException {
        return read("select * from tbl_borrower", null);
        
	}
	
	
	public List<Borrower> readBorrowerById(Integer cardNo) throws ClassNotFoundException, SQLException {

		return read("select * from tbl_borrower where cardNo = ?", new Object[] { cardNo });

	}
	
	public void deleteBorrower(Integer id) throws SQLException, ClassNotFoundException {
		save("DELETE FROM tbl_borrower where cardNo = ?", new Object[] { id });
	}

	@Override
	public List<Borrower> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {

		List<Borrower> borrowers = new ArrayList<>();
		while (rs.next()) {
			Borrower b = new Borrower();
			
			b.setCardNo(rs.getInt("cardNo"));
			b.setName(rs.getString("name"));
			b.setAddress(rs.getString("address"));
			b.setPhone(rs.getString("phone"));
			borrowers.add(b);
	    }
		borrowers.forEach(b -> System.out.println(b.getCardNo() + " " + b.getName()));
		return borrowers;
	}

	
	

}
