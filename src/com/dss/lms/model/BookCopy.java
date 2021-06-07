/**
 * 
 */
package com.dss.lms.model;


public class BookCopy {
    
	private Integer bookId;
	private Integer libraryId;
	private Integer noOfCopies;
	/**
	 * @param bookId
	 * @param libraryId
	 * @param noOfCopies
	 */
//	public BookCopy(Book bookId, Library libraryId, Integer noOfCopies) {
//		this.bookId = bookId;
//		this.libraryId = libraryId;
//		this.noOfCopies = noOfCopies;
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
	 * @return the libraryId
	 */
	public Integer getLibraryId() {
		return libraryId;
	}
	/**
	 * @param libraryId the libraryId to set
	 */
	public void setLibraryId(Integer libraryId) {
		this.libraryId = libraryId;
	}
	/**
	 * @return the noOfCopies
	 */
	public Integer getNoOfCopies() {
		return noOfCopies;
	}
	/**
	 * @param noOfCopies the noOfCopies to set
	 */
	public void setNoOfCopies(Integer noOfCopies) {
		this.noOfCopies = noOfCopies;
	}

	
	
	
}
