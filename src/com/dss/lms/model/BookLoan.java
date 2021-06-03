/**
 * 
 */
package com.dss.lms.model;

import java.sql.Date;

/**
 * @author amanda
 *
 */
public class BookLoan {
 
	private Book bookId;
	private Library libraryId;
	private Borrower cardNo;
	private Date dateOut;
	private Date dueDate;
	private Date dateIn;
	
	public BookLoan(Book bookId, Library libraryId, Borrower cardNo, Date dateOut, Date dueDate, Date dateIn) {
		this.bookId = bookId;
		this.libraryId = libraryId;
		this.cardNo = cardNo;
		this.dateOut = dateOut;
		this.dueDate = dueDate;
		this.dateIn = dateIn;
	}
	
	
	
	
	
	
}
