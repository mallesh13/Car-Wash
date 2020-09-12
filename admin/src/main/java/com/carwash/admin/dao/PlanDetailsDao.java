package com.carwash.admin.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carwash.admin.entity.PlanDetails;

@Repository
public interface PlanDetailsDao extends MongoRepository<PlanDetails, String>{

}
