package com.rk.springboot.internalization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InternalizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(InternalizationApplication.class, args);
	}

	
	
	/*
	 
	 http://localhost:8080/locale
	 http://localhost:8080/locale?language=fr
	 
	 */
}
