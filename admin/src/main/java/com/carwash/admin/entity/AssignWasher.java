package com.carwash.admin.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document( collection = "assignwasher")
public class AssignWasher {
	
	private String orderNo;
	private String washerEmail;
	private String status;
	public AssignWasher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AssignWasher(String orderNo, String washerEmail) {
		super();
		this.orderNo = orderNo;
		this.washerEmail = washerEmail;
	}
	
	public AssignWasher(String orderNo, String washerEmail, String status) {
		super();
		this.orderNo = orderNo;
		this.washerEmail = washerEmail;
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getWasherEmail() {
		return washerEmail;
	}
	public void setWasherEmail(String washerEmail) {
		this.washerEmail = washerEmail;
	}
	
}
