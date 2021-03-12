package com.carwash.cardetails;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.carwash.cardetails.controller.VehicleController;
import com.carwash.cardetails.dao.VehicleDetailsDao;
import com.carwash.cardetails.entity.VehicleDetails;
import com.carwash.cardetails.service.VehicleService;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
public class CarDetailsControllerTest {

	@InjectMocks
	VehicleController vehicleController;
	
	@Mock
	VehicleService service;
	
	@Test
	public void testAddVehicle() {
		MockHttpServletRequest request= new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
//		VehicleDetails details= new VehicleDetails("Alex", "Audi", "Q4", "black","abc@gmail.com");
//		ResponseEntity<Object> entity= vehicleController.uploadDetails("alex", "audi", "q3", "black", , "abc@gmail.com");
//		assertThat(entity.getStatusCodeValue()).isEqualTo(200);
	}
}
