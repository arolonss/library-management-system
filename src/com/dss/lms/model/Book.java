package com.dss.lms.model;

import java.util.List;

public class Book {
    
	private Integer id;
    private String title;
    private Integer pubId;
    private List<BookLoan> bookloans;
    
//	public Book(Integer id, String title, Integer pubId) {
//		this.id = id;
//		this.title = title;
//		this.pubId = pubId;
//	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}



	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the pubId
	 */
	public Integer getPubId() {
		return pubId;
	}

	/**
	 * @param pubId the pubId to set
	 */
	public void setPubId(Integer pubId) {
		this.pubId = pubId;
	}

	/**
	 * @return the bookloans
	 */
	public List<BookLoan> getBookloans() {
		return bookloans;
	}



	/**
	 * @param bookloans the bookloans to set
	 */
	public void setBookloans(List<BookLoan> bookloans) {
		this.bookloans = bookloans;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Book other = (Book) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
    
    
}
