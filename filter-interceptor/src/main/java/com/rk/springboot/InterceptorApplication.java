package com.rk.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//The Interceptor in Spring Boot to perform operations under the following situations
//	Before sending the request to the controller
//	Before sending the response to the client
//For example, you can use an interceptor to add the request header before sending the request to the controller and add the response header before sending the response to the client.

@SpringBootApplication
public class InterceptorApplication {
	public static void main(String[] args) {
		SpringApplication.run(InterceptorApplication.class, args);
	}
}
