package com.carwash.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.carwash.admin.dao.AssignWasherDao;
import com.carwash.admin.dao.PlanDetailsDao;
import com.carwash.admin.entity.AssignWasher;
import com.carwash.admin.entity.PlanDetails;
import com.mongodb.client.result.UpdateResult;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private MongoTemplate template;
	@Autowired
	private PlanDetailsDao planDao;
	@Autowired
	private AssignWasherDao awDao;

	@Override
	public PlanDetails addPlan(PlanDetails details) {

		return planDao.save(details);
	}

	@Override
	public List<PlanDetails> getAllPlans() {

		return planDao.findAll();
	}

	@Override
	public PlanDetails deletePlan(String name) {
		PlanDetails details = template.findAndRemove(new Query(Criteria.where("planName").is(name)), PlanDetails.class);
		return details;
	}

	@Override
	public PlanDetails getPlan(String name) {
		return planDao.findById(name).get();
	}

	@Override
	public AssignWasher assignToWasher(String orderNo, String washerEmail, String status) {
		AssignWasher info = new AssignWasher(orderNo, washerEmail, status);
		return awDao.save(info);
	}

	@Override
	public List<AssignWasher> getOrdersForWasher(String email) {

		Query query = new Query();
		query.addCriteria(
				new Criteria().andOperator(Criteria.where("washerEmail").is(email), Criteria.where("status").is("")));
		List<AssignWasher> orders = template.find(query, AssignWasher.class);
		return orders;
	}

	@Override
	public void getAssignWasher(String orderNo) {

		UpdateResult info = template.updateFirst(new Query(Criteria.where("orderNo").is(orderNo)),
				Update.update("status", "Accepted"), AssignWasher.class);

	}

	@Override
	public AssignWasher washerReject(String orderNo) {

		return template.findAndRemove(new Query(Criteria.where("orderNo").is(orderNo)), AssignWasher.class);
	}

	@Override
	public List<AssignWasher> getAllAcceptedOrders() {

		return template.find(new Query(Criteria.where("status").is("Accepted")),AssignWasher.class);
	}

	@Override
	public List<AssignWasher> getCurrentOrdersForWasher(String washerEmail) {
		
		Query query = new Query();
		query.addCriteria(
				new Criteria().andOperator(Criteria.where("washerEmail").is(washerEmail), Criteria.where("status").is("Accepted")));
		List<AssignWasher> orders = template.find(query, AssignWasher.class);
		return orders;
	}

	@Override
	public AssignWasher getWasherData(String orderNo) {
		
		Query query = new Query();
		query.addCriteria(
				new Criteria().andOperator(Criteria.where("orderNo").is(orderNo), Criteria.where("status").is("Accepted")));
		return template.findOne(query, AssignWasher.class);
	}

}
