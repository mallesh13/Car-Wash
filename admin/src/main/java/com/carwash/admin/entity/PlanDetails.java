package com.carwash.admin.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "plansdetails")
public class PlanDetails {
	
	@Id
	private String planName;
	private float price;
	private int duration;
	private String Description;

	public PlanDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlanDetails(String planName, float price, int duration, String description) {
		super();
		this.planName = planName;
		this.price = price;
		this.duration = duration;
		Description = description;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	@Override
	public String toString() {
		return "PalnDetails [planName=" + planName + ", price=" + price + ", duration=" + duration + ", Description="
				+ Description + "]";
	}

}
