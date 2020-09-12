package com.carwash.payment.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "paymentprofile")
public class PaymentProfile {

	private String orderNo;
	private String firstName;
	private String email;
	private String bankName;
	private int expmonth;
	private int expyear;
	private String cardname;
	private long cardnumber;
	private int cvv;
	
	public PaymentProfile() {
		super();
	
	}

	public PaymentProfile(String orderNo, String firstName, String email, String bankName, int expmonth, int expyear,
			String cardname, long cardnumber, int cvv) {
		super();
		this.orderNo = orderNo;
		this.firstName = firstName;
		this.email = email;
		this.bankName = bankName;
		this.expmonth = expmonth;
		this.expyear = expyear;
		this.cardname = cardname;
		this.cardnumber = cardnumber;
		this.cvv = cvv;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getCardname() {
		return cardname;
	}

	public void setCardname(String cardname) {
		this.cardname = cardname;
	}

	public int getExpmonth() {
		return expmonth;
	}

	public void setExpmonth(int expmonth) {
		this.expmonth = expmonth;
	}

	public int getExpyear() {
		return expyear;
	}

	public void setExpyear(int expyear) {
		this.expyear = expyear;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public long getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(long cardnumber) {
		this.cardnumber = cardnumber;
	}

	@Override
	public String toString() {
		return "PaymentProfile [email=" + email + ", firstName=" + firstName + ", bankName=" + bankName + ", cardname="
				+ cardname + ", expmonth=" + expmonth + ", expyear=" + expyear + ", cvv=" + cvv + ", cardnumber="
				+ cardnumber + "]";
	}
	
	

}
