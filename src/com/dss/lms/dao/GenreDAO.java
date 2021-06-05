package com.dss.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dss.lms.model.Book;
import com.dss.lms.model.Genre;

public class GenreDAO extends BaseDAO<Genre> {

	public GenreDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	
	public void addGenre(Genre genre) throws ClassNotFoundException, SQLException {
		save("INSERT INTO tbl_genre VALUES(?, ?)", new Object[] { genre.getId(), genre.getName() });
	}

	public void updateGenre(Genre genre) throws SQLException, ClassNotFoundException {
		save("UPDATE tbl_genre SET genre_name = ? where genre_id = ?", new Object[] { genre.getName(), genre.getId() });

	}

	public List<Genre> readAllGenres(Genre genre) throws ClassNotFoundException, SQLException {
        return read("select * from tbl_genre", null);
        
		
	}
	
	
	public List<Genre> readGenresById(Genre genre) throws ClassNotFoundException, SQLException {

		return read("select * from tbl_genre where genre_id = ", new Object[] {genre.getId()});

	}
	
	public void deleteGenre(Genre genre) throws SQLException, ClassNotFoundException {
		save("DELETE FROM tbl_genre where genre_id = ?", new Object[] { genre.getId() });
	}

	
	@Override
	public List<Genre> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Genre> genres = new ArrayList<>();
		while (rs.next()) {
			Genre g = new Genre();
			
			g.setId(rs.getInt("genre_id"));
			g.setName(rs.getString("genre_name"));
			
			genres.add(g);
	    }
		return genres;
	}

}
