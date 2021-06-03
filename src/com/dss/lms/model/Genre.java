package com.dss.lms.model;

import java.util.List;

public class Genre {
    private Integer genre_id;
    private String genre_name;
    private List<Book> books;
	
	/**
	 * @return the genre_id
	 */
	public Integer getGenre_id() {
		return genre_id;
	}
	/**
	 * @param genre_id the genre_id to set
	 */
	public void setGenre_id(Integer genre_id) {
		this.genre_id = genre_id;
	}
	/**
	 * @return the genre_name
	 */
	public String getGenre_name() {
		return genre_name;
	}
	/**
	 * @param genre_name the genre_name to set
	 */
	public void setGenre_name(String genre_name) {
		this.genre_name = genre_name;
	}
	
	/**
	 * @return the books
	 */
	public List<Book> getBooks() {
		return books;
	}
	/**
	 * @param books the books to set
	 */
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((genre_id == null) ? 0 : genre_id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Genre other = (Genre) obj;
		if (genre_id == null) {
			if (other.genre_id != null)
				return false;
		} else if (!genre_id.equals(other.genre_id))
			return false;
		return true;
	}
	
	
    
    
}
