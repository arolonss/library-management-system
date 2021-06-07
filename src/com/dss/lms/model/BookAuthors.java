package com.dss.lms.model;

public class BookAuthors {

	private Integer bookId;
	private Integer authorId;
	/**
	 * @param bookId
	 * @param authorId
	 */
//	public BookAuthors(Integer bookId, Integer authorId) {
//		this.bookId = bookId;
//		this.authorId = authorId;
//	}
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
	 * @return the authorId
	 */
	public Integer getAuthorId() {
		return authorId;
	}
	/**
	 * @param authorId the authorId to set
	 */
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
	
	
}
