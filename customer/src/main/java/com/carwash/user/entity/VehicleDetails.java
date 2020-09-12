package com.carwash.user.entity;

import java.io.File;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vehicledetails")
public class VehicleDetails {

	@Id
	private String registrationNumber;
	private String ownerName;
	private String makersClass;
	private String model;
	private String color;
	private File image;
	private String userName;

	public VehicleDetails() {
		super();
	
	}

	public VehicleDetails(String registrationNumber, String ownerName, String makersClass, String model, String color,
			File image, String userName) {
		super();
		this.registrationNumber = registrationNumber;
		this.ownerName = ownerName;
		this.makersClass = makersClass;
		this.model = model;
		this.color = color;
		this.image = image;
		this.userName = userName;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getMakersClass() {
		return makersClass;
	}

	public void setMakersClass(String makersClass) {
		this.makersClass = makersClass;
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

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
