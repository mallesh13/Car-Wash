package com.carwash.user.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bookinginfo")
public class BookingInfo {

	private String orderNo;
	private String email;
	private String name;
	private String number;
	private String address;
	private String maker;
	private String model;
	private String color;
	private String plan;
	private String date;
	private String status;

	public BookingInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingInfo(String orderNo, String email, String name, String number, String address, String maker,
			String model, String color, String plan, String date, String status) {
		super();
		this.orderNo = orderNo;
		this.email = email;
		this.name = name;
		this.number = number;
		this.address = address;
		this.maker = maker;
		this.model = model;
		this.color = color;
		this.plan = plan;
		this.date = date;
		this.status = status;
	}
	

	public BookingInfo(String orderNo, String name, String number, String address, String maker, String model,
			String color, String plan, String date, String status) {
		super();
		this.orderNo = orderNo;
		this.name = name;
		this.number = number;
		this.address = address;
		this.maker = maker;
		this.model = model;
		this.color = color;
		this.plan = plan;
		this.date = date;
		this.status = status;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
