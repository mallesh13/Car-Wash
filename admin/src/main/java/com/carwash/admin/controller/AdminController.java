package com.carwash.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.admin.entity.AssignWasher;
import com.carwash.admin.entity.PlanDetails;
import com.carwash.admin.service.AdminService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AdminController {

	@Autowired
	private AdminService service;

	@PostMapping("/addplan")
	public ResponseEntity<PlanDetails> addPlanInfo(@RequestBody PlanDetails details) {
		System.out.println(details);
		PlanDetails planDetails = service.addPlan(details);
		return new ResponseEntity<PlanDetails>(planDetails, HttpStatus.CREATED);
	}

	@GetMapping("/getplandetails")
	public ResponseEntity<List<PlanDetails>> getAllPlans() {

		return new ResponseEntity<List<PlanDetails>>(service.getAllPlans(), HttpStatus.OK);
	}

	@GetMapping("/deleteplan/{name}")
	public ResponseEntity<PlanDetails> deletePlan(@PathVariable String name) {

		return new ResponseEntity<PlanDetails>(service.deletePlan(name), HttpStatus.OK);
	}

	@GetMapping("/getplan/{name}")
	public ResponseEntity<PlanDetails> getPlan(@PathVariable String name) {
		return new ResponseEntity<PlanDetails>(service.getPlan(name), HttpStatus.OK);
	}
	
	@PostMapping("/assignwasher")
	public ResponseEntity<AssignWasher> assign(@RequestParam("orderNo") String orderNo,@RequestParam("washerEmail") String washerEmail) {
		String status="";
		AssignWasher data = service.assignToWasher(orderNo,washerEmail,status);

		return new ResponseEntity<AssignWasher>(data, HttpStatus.CREATED);
	}

	@GetMapping("/assignwasher/{userName}")
	public ResponseEntity<List<AssignWasher>> getAssignOrders(@PathVariable String userName) {
		
		return new ResponseEntity<List<AssignWasher>>(service.getOrdersForWasher(userName), HttpStatus.OK);
	}
	
	@GetMapping("/washerAccept/{orderNo}")
	public ResponseEntity statusUpdate(@PathVariable String orderNo){
		 service.getAssignWasher(orderNo);
		return new ResponseEntity( HttpStatus.OK);
	}
	
	@GetMapping("/rejectorder/{orderNo}")
	public ResponseEntity<AssignWasher> rejectOrder(@PathVariable String orderNo){
		return new ResponseEntity<AssignWasher>(service.washerReject(orderNo),HttpStatus.OK);
	}
	
	@GetMapping("/getallAcceptedorders")
	public ResponseEntity<List<AssignWasher>> getAllAccepted(){
		return new ResponseEntity<List<AssignWasher>>(service.getAllAcceptedOrders(),HttpStatus.OK);
	}
	
	@GetMapping("/washercurrentorders/{userName}")
	public ResponseEntity<List<AssignWasher>> getWasherPresentOrders(@PathVariable String userName){
		return new ResponseEntity<List<AssignWasher>>(service.getCurrentOrdersForWasher(userName),HttpStatus.OK);
	}
	
	@GetMapping("/getwasherdataby/{orderNo}")
	public ResponseEntity<AssignWasher> getWasherData(@PathVariable String orderNo){
		return new ResponseEntity<AssignWasher>(service.getWasherData(orderNo),HttpStatus.OK);
	}
}
