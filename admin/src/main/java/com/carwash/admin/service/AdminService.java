package com.carwash.admin.service;

import java.util.List;

import com.carwash.admin.entity.AssignWasher;
import com.carwash.admin.entity.PlanDetails;

public interface AdminService {

	public PlanDetails addPlan(PlanDetails details);
	
	public List<PlanDetails> getAllPlans();
	
	public PlanDetails deletePlan(String name);

	public PlanDetails getPlan(String name);
	
	public AssignWasher assignToWasher(String orderNo,String washerEmail,String status);
	
	public void getAssignWasher(String orderNo);
	
	public List<AssignWasher> getOrdersForWasher(String email);
	
	public AssignWasher washerReject(String orderNo);
	
	public List<AssignWasher> getAllAcceptedOrders();
	
	public List<AssignWasher> getCurrentOrdersForWasher(String washerEmail);
	
	public AssignWasher getWasherData(String orderNo);
}
