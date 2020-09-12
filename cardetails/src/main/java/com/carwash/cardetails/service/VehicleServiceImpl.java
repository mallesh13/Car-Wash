package com.carwash.cardetails.service;

import java.io.IOException;
import java.util.List;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.carwash.cardetails.dao.VehicleDetailsDao;
import com.carwash.cardetails.entity.VehicleDetails;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleDetailsDao dao;
	@Autowired
	private MongoTemplate template;

	@Override
	public VehicleDetails addDetails(String name, String makersClass, String model,
			String color, MultipartFile file, String userName) throws IOException {

		VehicleDetails details = new VehicleDetails(name, makersClass, model, color, userName);
		details.setImage(file.getBytes());
		details= dao.insert(details);
		return details;
	}

	@Override
	public VehicleDetails getDetails(String id) {
		return template.findOne(new Query(Criteria.where("_id").is(id)),VehicleDetails.class);
	}

	@Override
	public List<VehicleDetails> getAllVehicleDetailsForUser(String userName) {
		return template.find(new Query(Criteria.where("userName").is(userName)), VehicleDetails.class);
	}
}
