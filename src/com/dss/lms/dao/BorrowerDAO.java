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
		// TODO Auto-generated constructor stub
	}

	
	public void addBorrower(Borrower borrower) throws ClassNotFoundException, SQLException {
		save("INSERT INTO tbl_borrower VALUES(?, ?, ?, ?)", new Object[] { borrower.getCardNo(), borrower.getName(), borrower.getAddress(), borrower.getPhone() });
	}

	public void updateBorrower(Borrower borrower) throws SQLException, ClassNotFoundException {
		save("UPDATE tbl_borrower SET name = ? where cardNo = ?", new Object[] { borrower.getName(), borrower.getCardNo() });

	}

	public List<Borrower> readAllBorrowers(Borrower borrower) throws ClassNotFoundException, SQLException {
        return read("select * from tbl_borrower", null);
        
		//return read("select * from tbl_book", new Object[] {book.getTitle()});

	}
	
	
	public List<Borrower> readBorrowersById(Borrower borrower) throws ClassNotFoundException, SQLException {

		return read("select * from tbl_borrower where cardNo = ", new Object[] {borrower.getCardNo()});

	}
	
	public void deleteBorrower(Borrower borrower) throws SQLException, ClassNotFoundException {
		save("DELETE FROM tbl_borrower where cardNo = ?", new Object[] { borrower.getCardNo() });
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
		return borrowers;
	}
	
	

}
