package com.carwash.user.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carwash.user.entity.UserProfile;

@Repository
public interface UserDao extends MongoRepository<UserProfile, String>{

}
