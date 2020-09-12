package com.carwash.user.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carwash.user.entity.BookingInfo;

@Repository
public interface BookingDao extends MongoRepository<BookingInfo, String>{

}
