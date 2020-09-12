package com.carwash.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.payment.entity.PaymentProfile;
import com.carwash.payment.service.PaymentService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PaymentController {

	@Autowired
	private PaymentService service;
	
	@PostMapping("/payment/{orderNo}/{userName}")
	
	public ResponseEntity<PaymentProfile> registerCard(@RequestParam("firstname") String firstName,
			@PathVariable String userName,@RequestParam("bankname") String bankname,
			@RequestParam("expmonth") int expmonth,@RequestParam("expyear") int expyear,
			@RequestParam("cardname") String cardname,@RequestParam("cardnumber") long cardnumber,
			@RequestParam("cvv") int cvv,@PathVariable String orderNo){
		PaymentProfile profile = service.registerCard(orderNo,firstName,userName,bankname, expmonth,expyear,
								cardname,cardnumber,cvv);
		return new ResponseEntity<PaymentProfile>(profile,HttpStatus.CREATED);
	}
	
}
