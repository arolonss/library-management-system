package com.dss.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dss.lms.model.Book;
import com.dss.lms.model.Library;

public class LibraryDAO extends BaseDAO<Library> {

	public LibraryDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	public void addLibrary(Library library) throws ClassNotFoundException, SQLException {
		save("INSERT INTO tbl_library_branch VALUES(?, ?, ?)", new Object[] { library.getId(), library.getName(), library.getAddress() });
	}

	public void updateLibrary(Library library) throws SQLException, ClassNotFoundException {
		save("UPDATE tbl_library_branch SET BranchNme = ? where libraryId = ?", new Object[] { library.getName(), library.getId() });

	}

	public List<Library> readAllLibraries() throws ClassNotFoundException, SQLException {
        return read("select * from tbl_library_branch", null);
        

	}
	
	
	public List<Library> readLibraryById(Integer id) throws ClassNotFoundException, SQLException {

		return read("select * from tbl_library_branch where branchId = ", new Object[] {id});

	}
	
	public void deleteLibrary(Library library) throws SQLException, ClassNotFoundException {
		save("DELETE FROM tbl_library_branch where branchId = ?", new Object[] { library.getId() });
	}

	@Override
	public List<Library> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {

		List<Library> libraries = new ArrayList<>();
		while (rs.next()) {
			Library l = new Library();
			
			l.setId(rs.getInt("branchId"));
			l.setName(rs.getString("branchName"));
			l.setAddress(rs.getString("branchAddress"));
			libraries.add(l);
	    }
		libraries.forEach(l -> System.out.println(l.getName()));
		return libraries;
	}
	
	
	

}
