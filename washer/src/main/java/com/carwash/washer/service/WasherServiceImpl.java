package com.carwash.washer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.carwash.washer.dao.WasherDao;
import com.carwash.washer.entity.WasherProfile;

@Service
public class WasherServiceImpl implements WasherService {

	@Autowired
	private WasherDao dao;
	@Autowired
	private MongoTemplate template;

	@Override
	public WasherProfile washerLogin(String email, String password) {

		WasherProfile profile = template.findOne(new Query(Criteria.where("email").is(email)), WasherProfile.class);
		if (profile != null && profile.getPassword().equals(password))
			return profile;
		else
			return null;
	}
	
	@Override
	public WasherProfile addWasher(WasherProfile profile) {
		return dao.save(profile);
	}

	@Override
	public List<WasherProfile> getAllWasherDetails() {

		return dao.findAll();
	}

	@Override
	public WasherProfile deleteWasher(String email) {
		WasherProfile profile = template.findAndRemove(new Query(Criteria.where("email").is(email)),
				WasherProfile.class);
		return profile;
	}

}
