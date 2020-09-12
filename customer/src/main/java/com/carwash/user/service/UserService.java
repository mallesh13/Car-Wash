package com.carwash.user.service;

import java.util.List;

import com.carwash.user.entity.BookingInfo;
import com.carwash.user.entity.ContactUs;
import com.carwash.user.entity.RatingsAndReviews;
import com.carwash.user.entity.TowardsPayment;
import com.carwash.user.entity.UserProfile;

public interface UserService {

	public UserProfile createProfile(UserProfile profile);

	public UserProfile userLogin(String email, String password);

	public ContactUs feedbackAndQueries(ContactUs contactUs);

	public List<UserProfile> findAllUsers();

	public List<ContactUs> findAllFeedBacks();

	public UserProfile findUserProfile(String email);

	public BookingInfo bookWash(String orderNo,String email, String name, String number, String address, String maker, String model,
			String color, String plan, String date,String status);
	
	public List<BookingInfo> getOrders(String email);
	
	public List<BookingInfo> pendingOrders();
	
	public BookingInfo getOrderByOrderNumber(String orderNo);
	
	public void updateOrderStatusToUnderProcess(String orderNo);
	
	public List<BookingInfo> getAllUnderProcessOrders();
	
	public List<BookingInfo> userUnderProcessOrders(String userName);
	
	public TowardsPayment saveDetails(String orderNo,String userName,String washerEmail,String status); 
	
	public void finalUpdateOrderStatus(String orderNo);
	
	public List<BookingInfo> getAllUserPastOrders(String userName);
	
	public List<BookingInfo> getAllCompletedOrders();
	
	public List<BookingInfo> getPendingOrdersForUser(String userName);
	
	public String cancelOrder(String userName,String orderNo);
	
	public String resheduleOrder(String userName,String orderNo, String date);
	
	public List<BookingInfo> allCanceledOrders();
	
	public RatingsAndReviews uploadRatings(String userName,String orderNo,String comments,int rating);
	
	public List<RatingsAndReviews> getAllRatings();
	
	public RatingsAndReviews getRatingByOrder(String orderNo);

}