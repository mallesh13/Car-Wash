package com.carwash.washer.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carwash.washer.entity.WasherProfile;

@Repository
public interface WasherDao extends MongoRepository<WasherProfile,String>{

}
