package com.carwash.user.controller;

import java.util.List;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.user.entity.BookingInfo;
import com.carwash.user.entity.ContactUs;
import com.carwash.user.entity.RatingsAndReviews;
import com.carwash.user.entity.TowardsPayment;
import com.carwash.user.entity.UserProfile;
import com.carwash.user.service.UserService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/user")
	public ResponseEntity<UserProfile> registerNewAccount(@RequestBody UserProfile profile) {
		UserProfile p = service.createProfile(profile);
		return new ResponseEntity<UserProfile>(p, HttpStatus.CREATED);
	}

	@GetMapping("/user/{email}/{password}")
	public ResponseEntity<UserProfile> userLogin(@PathVariable String email, @PathVariable String password) {

		UserProfile profile = service.userLogin(email, password);
		if (profile != null) {
			return new ResponseEntity<UserProfile>(profile, HttpStatus.OK);
		}
		return new ResponseEntity<UserProfile>(HttpStatus.UNAUTHORIZED);
	}

	@PostMapping("/contact")
	public ResponseEntity<ContactUs> registerFeedbackAndQueries(@RequestBody ContactUs contactUs) {
		ContactUs cu = service.feedbackAndQueries(contactUs);
		return new ResponseEntity<ContactUs>(cu, HttpStatus.CREATED);
	}

	@GetMapping("/allusers")
	public ResponseEntity<List<UserProfile>> findAllUsers() {
		return new ResponseEntity<List<UserProfile>>(service.findAllUsers(), HttpStatus.OK);
	}

	@GetMapping("/allfeedbacks")
	public ResponseEntity<List<ContactUs>> findAllFeedbacks() {
		return new ResponseEntity<List<ContactUs>>(service.findAllFeedBacks(), HttpStatus.OK);
	}

	@GetMapping("/getuserprofile/{userName}")
	public ResponseEntity<UserProfile> findUser(@PathVariable String userName) {
		return new ResponseEntity<UserProfile>(service.findUserProfile(userName), HttpStatus.OK);
	}

	@PostMapping("/bookwash/{userName}")
	public ResponseEntity<BookingInfo> bookWash(@PathVariable String userName, @RequestParam("name") String name,
			@RequestParam("number") String number, @RequestParam("address") String address,
			@RequestParam("maker") String maker, @RequestParam("model") String model,
			@RequestParam("color") String color, @RequestParam("plan") String plan, @RequestParam("date") String date,
			@RequestParam("orderNo") String orderNo) {
		System.out.println(orderNo);
		String status = "pending";
		BookingInfo info = service.bookWash(orderNo, userName, name, number, address, maker, model, color, plan, date,
				status);
		return new ResponseEntity<BookingInfo>(info, HttpStatus.CREATED);
	}

	@GetMapping("/getordersforuser/{userName}")
	public ResponseEntity<List<BookingInfo>> getOrders(@PathVariable String userName) {
		return new ResponseEntity<List<BookingInfo>>(service.getOrders(userName), HttpStatus.OK);
	}

	@GetMapping("/pendingorders")
	public ResponseEntity<List<BookingInfo>> pendingOrders() {
		return new ResponseEntity<List<BookingInfo>>(service.pendingOrders(),HttpStatus.OK);
	}
	
	@GetMapping("/getordersforwasher/{orderNo}")
	public ResponseEntity<BookingInfo> getOrdersForWasher(@PathVariable String orderNo){
		return new ResponseEntity<BookingInfo>(service.getOrderByOrderNumber(orderNo),HttpStatus.OK);
	}
	
	@GetMapping("/underprocessorders/{orderNo}")
	public ResponseEntity updateOrderStatus(@PathVariable String orderNo) {
		service.updateOrderStatusToUnderProcess(orderNo);
		return new ResponseEntity(HttpStatus.OK);
	}
	 
	@GetMapping("/allunderprocessorders")
	public ResponseEntity<List<BookingInfo>> getAllUnderProcess(){
		return new ResponseEntity<List<BookingInfo>>(service.getAllUnderProcessOrders(),HttpStatus.OK);
	}
	
	@GetMapping("/underprocessordersby/{userName}")
	public ResponseEntity<List<BookingInfo>> getUsersUnderProcessOrders(@PathVariable String userName){
		
		return new ResponseEntity<List<BookingInfo>>(service.userUnderProcessOrders(userName),HttpStatus.OK);
	}
	
	@PostMapping("/towardsPayment")
	public ResponseEntity<TowardsPayment> saveTowardsPyments(@RequestParam("orderNo") String orderNo,
			@RequestParam("userName") String userName,@RequestParam("washerEmail") String washerEmail){
		String status="";
		return new ResponseEntity<TowardsPayment>(service.saveDetails(orderNo, userName, washerEmail, status),HttpStatus.CREATED);
	}
	
	@GetMapping("/finalupdateorder/{orderNo}")
	
	public ResponseEntity finalUpdate(@PathVariable String orderNo) {
		service.finalUpdateOrderStatus(orderNo);
		return new ResponseEntity(HttpStatus.OK);
	}
	@GetMapping("/userpastorders/{userName}")
	public ResponseEntity<List<BookingInfo>> getUserPast(@PathVariable String userName){
		return new ResponseEntity<List<BookingInfo>>(service.getAllUserPastOrders(userName),HttpStatus.OK);
	}
	@GetMapping("/allcompletedorders")
	public ResponseEntity<List<BookingInfo>> getAllCompletedOrders(){
		return new ResponseEntity<List<BookingInfo>>(service.getAllCompletedOrders(),HttpStatus.OK);
	}
	
	@GetMapping("/pendingordersfor/{userName}")
	public ResponseEntity<List<BookingInfo>> pendingOrdersForUser(@PathVariable String userName){
		return new ResponseEntity<List<BookingInfo>>(service.getPendingOrdersForUser(userName),HttpStatus.OK);
	}
	
	@GetMapping("/cancelorder/{userName}/{orderNo}")
	public ResponseEntity<String> cancelOrderForUser(@PathVariable String userName,@PathVariable  String orderNo){
		
		return new ResponseEntity<String>(service.cancelOrder(userName, orderNo),HttpStatus.OK);
	}
	
	@GetMapping("/resheduleorder/{userName}/{orderNo}/{date}")
	public ResponseEntity<String> resheduleOrders(@PathVariable String userName,@PathVariable String orderNo,
			@PathVariable String date){
		return new ResponseEntity<String>(service.resheduleOrder(userName, orderNo, date),HttpStatus.OK);
	}
	@GetMapping("/canceledorders")
	public ResponseEntity<List<BookingInfo>> getAllCanceledOrders(){
		return new ResponseEntity<List<BookingInfo>>(service.allCanceledOrders(),HttpStatus.OK);
	}
	
	@PostMapping("/ratingsandreviews")
	public ResponseEntity<RatingsAndReviews> saveRatings(@RequestParam("orderNo") String orderNo,@RequestParam("userName") String userName,
			@RequestParam("rating") int rating,@RequestParam("comments") String comments){
		
		RatingsAndReviews info= service.uploadRatings(userName, orderNo, comments, rating);
		
		return new ResponseEntity<RatingsAndReviews>(info,HttpStatus.CREATED);
	}
	
	@GetMapping("/allratings")
	public ResponseEntity<List<RatingsAndReviews>> allRatings(){
		return new ResponseEntity<List<RatingsAndReviews>>(service.getAllRatings(),HttpStatus.OK);
	}
	
	@GetMapping("/ratings/{orderNo}")
	public ResponseEntity<RatingsAndReviews> getRating(@PathVariable String orderNo){
		return new ResponseEntity<RatingsAndReviews>(service.getRatingByOrder(orderNo),HttpStatus.OK);
	}
}
