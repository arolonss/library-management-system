package com.dss.lms.model;

import java.util.List;

public class Borrower {
    
	private Integer cardNo;
	private String name;
	private String address;
	private String phone;
	private List<BookLoan> bookloans;
	
	
//	public Borrower(Integer cardNo, String name, String address, String phone, List<BookLoan> bookloans) {
//		this.cardNo = cardNo;
//		this.name = name;
//		this.address = address;
//		this.phone = phone;
//		this.setBookloans(bookloans);
//	}
	/**
	 * @return the cardNo PK
	 */
	public Integer getCardNo() {
		return cardNo;
	}
	/**
	 * @param cardNo the cardNo to set
	 */
	public void setCardNo(Integer cardNo) {
		this.cardNo = cardNo;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
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
		result = prime * result + ((cardNo == null) ? 0 : cardNo.hashCode());
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
		Borrower other = (Borrower) obj;
		if (cardNo == null) {
			if (other.cardNo != null)
				return false;
		} else if (!cardNo.equals(other.cardNo))
			return false;
		return true;
	}
	
	
	
	
}
