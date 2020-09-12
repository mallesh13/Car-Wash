package com.carwash.cardetails.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.carwash.cardetails.entity.VehicleDetails;
import com.carwash.cardetails.service.VehicleService;

@RestController
@CrossOrigin( origins = "*" ,allowedHeaders = "*")
public class VehicleController {
	
	@Autowired
	private VehicleService service;
	
	@PostMapping("/user/addvehicledetails/{userName}")
	public ResponseEntity<VehicleDetails> uploadDetails(@RequestParam("name") String name, @RequestParam("brand") String brand,
			@RequestParam("model") String model, @RequestParam("color") String color,
			@RequestParam("image") MultipartFile file, @PathVariable String userName) throws IOException{
		
		VehicleDetails vehicleDetails= service.addDetails(name, brand, model, color, file, userName);
		return new ResponseEntity<VehicleDetails>(vehicleDetails,HttpStatus.OK);
	}
	
	@GetMapping("/vehicledetails/{userName}")
	public ResponseEntity<List<VehicleDetails>> getVehicleDetails(@PathVariable String userName){
		return new ResponseEntity<List<VehicleDetails>>(service.getAllVehicleDetailsForUser(userName),HttpStatus.OK);
	}
	
	@GetMapping("/vehicledetailby/{id}")
	public ResponseEntity<VehicleDetails> getVehicleDetailById(@PathVariable String id){
		return new ResponseEntity<VehicleDetails>(service.getDetails(id),HttpStatus.OK);
	}
}
