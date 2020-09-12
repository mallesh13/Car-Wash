package com.carwash.user.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carwash.user.entity.ContactUs;

@Repository
public interface ContactUsDao extends MongoRepository<ContactUs, String>{

}
