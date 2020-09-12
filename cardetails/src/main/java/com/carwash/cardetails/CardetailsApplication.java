package com.carwash.cardetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CardetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardetailsApplication.class, args);
	}

}
