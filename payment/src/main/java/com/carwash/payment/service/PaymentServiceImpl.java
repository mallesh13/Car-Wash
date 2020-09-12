 package com.carwash.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.payment.dao.PaymentDao;
import com.carwash.payment.entity.PaymentProfile;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentDao dao;

	@Override
	public PaymentProfile registerCard(String orderNo,String firstName, String userName, String bankname, int expmonth, int expyear,
			String cardname, long cardnumber, int cvv) {
		PaymentProfile profile=new PaymentProfile(orderNo,firstName,userName,bankname,expmonth,expyear,cardname,cardnumber,cvv);
		return dao.save(profile);
	}

}
