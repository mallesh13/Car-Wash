package com.carwash.user.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carwash.user.entity.VehicleDetails;

@Repository
public interface VehicleDao extends MongoRepository<VehicleDetails, String>{

}
