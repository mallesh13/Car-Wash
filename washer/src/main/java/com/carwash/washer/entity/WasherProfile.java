package com.carwash.washer.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "washerprofile")
public class WasherProfile {

	private String email;
	private String password;
	private String name;
	private String phoneNumber;

	public WasherProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WasherProfile(String email, String password, String name, String phoneNumber) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "WasherProfile [email=" + email + ", password=" + password + ", name=" + name + ", phoneNumber="
				+ phoneNumber + "]";
	}

}
