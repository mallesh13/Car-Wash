package com.carwash.cardetails.service;

import java.io.IOException;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

import com.carwash.cardetails.entity.VehicleDetails;

public interface VehicleService {

	public VehicleDetails addDetails(String name, String makersClass, String model, String color, MultipartFile file,
			String userName) throws IOException;

	public VehicleDetails getDetails(String id);
	
	public List<VehicleDetails> getAllVehicleDetailsForUser(String userName);

}
