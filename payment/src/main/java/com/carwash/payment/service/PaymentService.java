package com.carwash.payment.service;

import com.carwash.payment.entity.PaymentProfile;

public interface PaymentService {

	public PaymentProfile registerCard(String orderNo,String firstName, String userName, String bankname, int expmonth, int expyear,
			String cardname, long cardnumber, int cvv);

}
