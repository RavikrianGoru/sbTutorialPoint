package com.rk.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbActuatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbActuatorApplication.class, args);
		
		/*
		 http://localhost:8080/
		 
		 Give the following paths in HAL Explorer
		 1) actuator
		 
		 2) http://localhost:8080/actuator/health
		 
		 */
	}

}
