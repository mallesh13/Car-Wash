package com.carwash.user.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "towardspayment")
public class TowardsPayment {
	
	private String orderNo;
	private String userName;
	private String washerEmail;
	private String status;
	public TowardsPayment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TowardsPayment(String orderNo, String userName, String washerEmail, String status) {
		super();
		this.orderNo = orderNo;
		this.userName = userName;
		this.washerEmail = washerEmail;
		this.status = status;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getWasherEmail() {
		return washerEmail;
	}
	public void setWasherEmail(String washerEmail) {
		this.washerEmail = washerEmail;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "TowardsPayment [orderNo=" + orderNo + ", userName=" + userName + ", washerEmail=" + washerEmail
				+ ", status=" + status + "]";
	}

}
