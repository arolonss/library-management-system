/**
 * 
 */
package com.dss.lms.model;

import java.sql.Date;


public class BookLoan {
 
	private Book bookId;
	private Library libraryId;
	private Borrower cardNo;
	private Date dateOut;
	private Date dueDate;
	
	
	
//	public BookLoan(Book bookId, Library libraryId, Borrower cardNo, Date dateOut, Date dueDate) {
//		this.bookId = bookId;
//		this.libraryId = libraryId;
//		this.cardNo = cardNo;
//		this.dateOut = dateOut;
//		this.dueDate = dueDate;
//	}
	/**
	 * @return the bookId
	 */
	public Book getBookId() {
		return bookId;
	}
	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(Book bookId) {
		this.bookId = bookId;
	}
	/**
	 * @return the libraryId
	 */
	public Library getLibraryId() {
		return libraryId;
	}
	/**
	 * @param libraryId the libraryId to set
	 */
	public void setLibraryId(Library libraryId) {
		this.libraryId = libraryId;
	}
	/**
	 * @return the cardNo
	 */
	public Borrower getCardNo() {
		return cardNo;
	}
	/**
	 * @param cardNo the cardNo to set
	 */
	public void setCardNo(Borrower cardNo) {
		this.cardNo = cardNo;
	}
	/**
	 * @return the dateOut
	 */
	public Date getDateOut() {
		return dateOut;
	}
	/**
	 * @param dateOut the dateOut to set
	 */
	public void setDateOut(Date dateOut) {
		this.dateOut = dateOut;
	}
	/**
	 * @return the dueDate
	 */
	public Date getDueDate() {
		return dueDate;
	}
	/**
	 * @param dueDate the dueDate to set
	 */
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	
	
	
	
	
	
}
