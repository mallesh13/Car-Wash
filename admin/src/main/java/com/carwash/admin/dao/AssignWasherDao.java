package com.carwash.admin.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carwash.admin.entity.AssignWasher;

@Repository
public interface AssignWasherDao extends MongoRepository<AssignWasher, String> {

}
