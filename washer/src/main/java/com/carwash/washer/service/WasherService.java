package com.carwash.washer.service;

import java.util.List;

import com.carwash.washer.entity.WasherProfile;

public interface WasherService {
	
	public WasherProfile addWasher(WasherProfile profile);

	public List<WasherProfile> getAllWasherDetails();
	
	public WasherProfile deleteWasher(String email);

	public WasherProfile washerLogin(String email,String password);
}
