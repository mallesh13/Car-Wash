package com.carwash.cardetails.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carwash.cardetails.entity.VehicleDetails;


@Repository
public interface VehicleDetailsDao extends MongoRepository<VehicleDetails, String> {

}
