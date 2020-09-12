package com.carwash.payment.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carwash.payment.entity.PaymentProfile;

@Repository
public interface PaymentDao extends MongoRepository<PaymentProfile, String>{

}
