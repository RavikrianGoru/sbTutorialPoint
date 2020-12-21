package com.rk.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiceComponentApp {
	public static void main(String[] args) {
		SpringApplication.run(ServiceComponentApp.class, args);
	}
	
	/*
	 
	 ConfigServletWebServerApplicationContext : Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'empController': Unsatisfied dependency expressed through field 'empService'; nested exception is org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type 'com.rk.springboot.service.EmpService' available: expected single matching bean but found 2: empService1Impl,empService2Impl

	So, commented one @Service

	 */
}


