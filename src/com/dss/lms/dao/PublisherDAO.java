package com.dss.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dss.lms.model.Book;
import com.dss.lms.model.Publisher;

public class PublisherDAO extends BaseDAO<Publisher> {
    
	public PublisherDAO(Connection conn) {
		super(conn);
	}

	public void addPublisher(Publisher publisher) throws ClassNotFoundException, SQLException {
		save("INSERT INTO tbl_publisher VALUES(?, ?, ?, ?)", new Object[] { publisher.getId(), publisher.getName(), publisher.getAddress(), publisher.getPhone() });
	}

	public void updatePublisher(Publisher publisher) throws SQLException, ClassNotFoundException {
		save("UPDATE tbl_publisher SET publisherName = ? where publisherId = ?", new Object[] { publisher.getName(), publisher.getId() });

	}

	public List<Publisher> readAllPublishers() throws ClassNotFoundException, SQLException {
        return read("select * from tbl_publisher", null);

	}
	
	
	public List<Publisher> readPublisherById(Integer id) throws ClassNotFoundException, SQLException {

		return read("select * from tbl_publisher where publisherId = ?", new Object[] { id });
	}
	
	public void deletePublisher(Integer id) throws SQLException, ClassNotFoundException {
		save("DELETE FROM tbl_publisher where publisherId = ?", new Object[] { id });
	}

	
	public List<Publisher> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
        List<Publisher> publishers = new ArrayList<>();
		while (rs.next()) {
			Publisher p = new Publisher();
			
			p.setId(rs.getInt("publisherId"));
			p.setName(rs.getString("publisherName"));
			p.setAddress(rs.getString("publisherAddress"));
			p.setPhone(rs.getString("publisherPhone"));
			publishers.add(p);
	    }
		publishers.forEach(p -> System.out.println(p.getId() + " " + p.getName()));
		return publishers;
	}


}
