package com.rk.springboot.https;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HttpsEnableApplication {

	public static void main(String[] args) {
		SpringApplication.run(HttpsEnableApplication.class, args);
	}

	/*
	 https://localhost:8443/secured
	 */
}
