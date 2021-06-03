package com.dss.lms.model;

public class Book {
    
	private Integer bookId;
    private String title;
    private Publisher pubId;
	/**
	 * @return the bookId
	 */
	public Integer getBookId() {
		return bookId;
	}
	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
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
	public Publisher getPubId() {
		return pubId;
	}
	/**
	 * @param pubId the pubId to set
	 */
	public void setPubId(Publisher pubId) {
		this.pubId = pubId;
	}
    
    
}
