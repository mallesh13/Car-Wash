package com.carwash.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.carwash.user.dao.BookingDao;
import com.carwash.user.dao.ContactUsDao;
import com.carwash.user.dao.RatingsAndReviewsDao;
import com.carwash.user.dao.TowardsPaymentDao;
import com.carwash.user.dao.UserDao;
import com.carwash.user.entity.BookingInfo;
import com.carwash.user.entity.ContactUs;
import com.carwash.user.entity.RatingsAndReviews;
import com.carwash.user.entity.TowardsPayment;
import com.carwash.user.entity.UserProfile;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;
	@Autowired
	private ContactUsDao cdao;
	@Autowired
	private MongoTemplate template;
	@Autowired
	private BookingDao bookingDao;
	@Autowired
	private TowardsPaymentDao tpDao;
	@Autowired
	private RatingsAndReviewsDao rrDao;

	@Override
	public UserProfile createProfile(UserProfile profile) {
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
		String encodedpassword=encoder.encode(profile.getPassword());
		profile.setPassword(encodedpassword);
		return dao.save(profile);

	}

	@Override
	public UserProfile userLogin(String email, String password) {
		System.out.println(password);
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
		
		Query query = new Query();
		UserProfile profile = template.findOne(query.addCriteria(Criteria.where("email").is(email)), UserProfile.class);
		
		if (profile != null && encoder.matches(password,profile.getPassword())) {
			return profile;
		} else
			return null;
	}

	@Override
	public ContactUs feedbackAndQueries(ContactUs contact) {
		return cdao.save(contact);
	}

	@Override
	public List<UserProfile> findAllUsers() {

		return dao.findAll();
	}

	@Override
	public List<ContactUs> findAllFeedBacks() {

		return cdao.findAll();
	}

	@Override
	public UserProfile findUserProfile(String email) {

		return dao.findById(email).get();
	}

	@Override
	public BookingInfo bookWash(String orderNo, String email, String name, String number, String address, String maker,
			String model, String color, String plan, String date, String status) {
		BookingInfo info = new BookingInfo(orderNo, email, name, number, address, maker, model, color, plan, date,
				status);

		return bookingDao.save(info);
	}

	@Override
	public List<BookingInfo> getOrders(String email) {
		Iterable<BookingInfo> infos = template.find(new Query(Criteria.where("email").is(email)), BookingInfo.class);
		List<BookingInfo> list = new ArrayList<BookingInfo>();
		String status="pending";
		String status1="UnderProcess";
		for (BookingInfo bookingInfo : infos) {
			if (bookingInfo.getStatus().equals(status) || bookingInfo.getStatus().equals(status1)) {

				BookingInfo info = new BookingInfo(bookingInfo.getOrderNo(), bookingInfo.getName(),
						bookingInfo.getNumber(), bookingInfo.getAddress(), bookingInfo.getMaker(),
						bookingInfo.getModel(), bookingInfo.getColor(), bookingInfo.getPlan(), bookingInfo.getDate(),
						bookingInfo.getStatus());

				list.add(info);
			}
		}
		System.out.println(list);
		return list;
	}

	@Override
	public List<BookingInfo> pendingOrders() {
		List<BookingInfo> info = template.find(new Query(Criteria.where("status").is("pending")), BookingInfo.class);
		return info;
	}

	@Override
	public BookingInfo getOrderByOrderNumber(String orderNo) {
		BookingInfo info = template.findOne(new Query(Criteria.where("orderNo").is(orderNo)), BookingInfo.class);
		return info;
	}

	@Override
	public void updateOrderStatusToUnderProcess(String orderNo) {
		
		template.updateFirst(new Query(Criteria.where("orderNo").is(orderNo)),
				Update.update("status", "UnderProcess"), BookingInfo.class);
	}

	@Override
	public List<BookingInfo> getAllUnderProcessOrders() {
		
		return template.find(new Query(Criteria.where("status").is("UnderProcess")), BookingInfo.class);
	}

	@Override
	public List<BookingInfo> userUnderProcessOrders(String userName) {
		Query query = new Query();
		query.addCriteria(
				new Criteria().andOperator(Criteria.where("email").is(userName), Criteria.where("status").is("UnderProcess")));
		List<BookingInfo> orders = template.find(query, BookingInfo.class);
		return orders;
	}

	@Override
	public TowardsPayment saveDetails(String orderNo, String userName, String washerEmail, String status) {
		
		TowardsPayment result=new TowardsPayment(orderNo, userName, washerEmail, status);
		return tpDao.save(result);
	}

	@Override
	public void finalUpdateOrderStatus(String orderNo) {
		System.out.println("welcome");
		System.out.println(orderNo);
		template.updateFirst(new Query(Criteria.where("orderNo").is(orderNo)),
				Update.update("status", "Completed"), BookingInfo.class);
		
	}

	@Override
	public List<BookingInfo> getAllUserPastOrders(String userName) {
		Query query = new Query();
		Criteria criteria= new Criteria().orOperator(Criteria.where("status").is("Canceled"),Criteria.where("status").is("Completed"));
		query.addCriteria(
				new Criteria().andOperator(Criteria.where("email").is(userName),criteria));
	
		List<BookingInfo> orders = template.find(query, BookingInfo.class);
		return orders;
	}

	@Override
	public List<BookingInfo> getAllCompletedOrders() {
		return template.find(new Query(Criteria.where("status").is("Completed")), BookingInfo.class);
	}

	@Override
	public List<BookingInfo> getPendingOrdersForUser(String userName) {
		Query query = new Query();
		query.addCriteria(
				new Criteria().andOperator(Criteria.where("email").is(userName), Criteria.where("status").is("pending")));
		List<BookingInfo> orders = template.find(query, BookingInfo.class);
		return orders;
	}

	@Override
	public String cancelOrder(String userName, String orderNo) {
		
		Query query = new Query();
		query.addCriteria(
				new Criteria().andOperator(Criteria.where("email").is(userName), Criteria.where("orderNo").is(orderNo)));
		
		template.updateFirst(query,Update.update("status", "Canceled"), BookingInfo.class);
		
		return "Order Canceled";
	}

	@Override
	public String resheduleOrder(String userName, String orderNo, String date) {
		
		Query query = new Query();
		query.addCriteria(
				new Criteria().andOperator(Criteria.where("email").is(userName), Criteria.where("orderNo").is(orderNo)));
		template.updateFirst(query,Update.update("date", date), BookingInfo.class);
		
		return "Order resheduled";
	}

	@Override
	public List<BookingInfo> allCanceledOrders() {
		
		return template.find(new Query(Criteria.where("status").is("Canceled")), BookingInfo.class);
	}

	@Override
	public RatingsAndReviews uploadRatings(String userName, String orderNo, String comments, int rating) {
		
		RatingsAndReviews reviews= new RatingsAndReviews(userName, orderNo, comments, rating);
		return rrDao.save(reviews);
	}

	@Override
	public List<RatingsAndReviews> getAllRatings() {
		return rrDao.findAll();
	}

	@Override
	public RatingsAndReviews getRatingByOrder(String orderNo) {
		
		return template.findOne(new Query(Criteria.where("orderNo").is(orderNo)), RatingsAndReviews.class);
	}
}
