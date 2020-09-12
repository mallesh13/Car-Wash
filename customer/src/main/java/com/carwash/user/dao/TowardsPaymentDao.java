package com.carwash.user.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carwash.user.entity.TowardsPayment;

@Repository
public interface TowardsPaymentDao extends MongoRepository<TowardsPayment, String>{

}
