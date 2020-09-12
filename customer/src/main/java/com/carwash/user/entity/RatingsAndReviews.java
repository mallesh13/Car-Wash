package com.carwash.user.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ratingsandreviews")
public class RatingsAndReviews {

	private String userName;
	private String orderNo;
	private String comments;
	private int rating;
	public RatingsAndReviews() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RatingsAndReviews(String userName, String orderNo, String comments, int rating) {
		super();
		this.userName = userName;
		this.orderNo = orderNo;
		this.comments = comments;
		this.rating = rating;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "RatingsAndReviews [userName=" + userName + ", orderNo=" + orderNo + ", comments=" + comments
				+ ", rating=" + rating + "]";
	}
	
	
}
