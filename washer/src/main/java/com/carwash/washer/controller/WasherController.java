package com.carwash.washer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.washer.entity.WasherProfile;
import com.carwash.washer.service.WasherService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class WasherController {

	@Autowired
	private WasherService service;

	@PostMapping("/addwasher")
	public ResponseEntity<WasherProfile> addNewWasher(@RequestBody WasherProfile profile) {
		WasherProfile p = service.addWasher(profile);
		System.out.println(p.toString());
		return new ResponseEntity<WasherProfile>(p, HttpStatus.CREATED);
	}

	@GetMapping("/washer/{email}/{password}")
	public ResponseEntity<WasherProfile> washerLogin(@PathVariable String email, @PathVariable String password) {
		System.out.println("washer");
		WasherProfile profile = service.washerLogin(email, password);
		if (profile != null)
			return new ResponseEntity<WasherProfile>(profile, HttpStatus.OK);
		else
			return new ResponseEntity<WasherProfile>(HttpStatus.UNAUTHORIZED);

	}

	@GetMapping("/allwashersdetails")
	public ResponseEntity<List<WasherProfile>> getAllWashers() {
		return new ResponseEntity<List<WasherProfile>>(service.getAllWasherDetails(), HttpStatus.OK);
	}

	@GetMapping("/deleteWasher/{email}")
	public ResponseEntity<WasherProfile> deleteWasher(@PathVariable String email) {

		return new ResponseEntity<WasherProfile>(service.deleteWasher(email), HttpStatus.OK);
	}
	

}
