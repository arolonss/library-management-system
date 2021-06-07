package com.dss.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dss.lms.model.Author;
import com.dss.lms.model.Book;

public class AuthorDAO extends BaseDAO<Author> {

	public AuthorDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}
    public void addAuthor(Author author) throws ClassNotFoundException, SQLException {
    	save("INSERT INTO tbl_author VALUES(?, ?)", new Object[] { author.getId(), author.getName()});
    }
    
    public void updateAuthor(Author author) throws SQLException, ClassNotFoundException {
		save("UPDATE tbl_author SET authorName = ? where authorId = ?", new Object[] { author.getName(), author.getId() });

	}

	public List<Author> readAllAuthors() throws ClassNotFoundException, SQLException {

		return read("select * from tbl_author", null);
    }
	
	
	public List<Author> readAuthorById(Integer id) throws ClassNotFoundException, SQLException {

		return read("select * from tbl_author where authorId = ?", new Object[] { id });

	}
	
	public void deleteAuthor(Integer id) throws SQLException, ClassNotFoundException {
		save("DELETE FROM tbl_author where authorId = ?", new Object[] { id });
	}
   
    
	@Override
	public List<Author> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Author> authors = new ArrayList<>();
		while (rs.next()) {
			Author a = new Author();
			
			a.setId(rs.getInt("authorId"));
			a.setName(rs.getString("authorName"));
			
			authors.add(a);
	    }
		authors.forEach(a -> System.out.println(a.getId() + " " + a.getName()));
		return authors;
	}

}
