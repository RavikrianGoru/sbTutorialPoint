package com.rk.springboot.retry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class SpringRetryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRetryApplication.class, args);
	}
	
	/*
	 http://localhost:8080/retry?simulateretry=true&simulateretryfallback=false
	 http://localhost:8080/retry?simulateretry=true&simulateretryfallback=true
	 http://localhost:8080/retry
	 
	 
	 */

}
