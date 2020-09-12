package com.carwash.cardetails.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cardetails")
public class VehicleDetails {

	private String name;
	private String makersClass;
	private String model;
	private String color;
	private byte[] image;
	private String userName;

	public VehicleDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VehicleDetails(String name, String makersClass, String model, String color, byte[] image, String userName) {
		super();
		this.name = name;
		this.makersClass = makersClass;
		this.model = model;
		this.color = color;
		this.image = image;
		this.userName = userName;
	}

	
	public VehicleDetails(String name, String makersClass, String model, String color, String userName) {
		super();
		this.name = name;
		this.makersClass = makersClass;
		this.model = model;
		this.color = color;
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "VehicleDetails [name=" + name + ", makersClass=" + makersClass + ", model=" + model + ", color=" + color
				+ ", image=" + image + ", userName=" + userName + "]";
	}

}
