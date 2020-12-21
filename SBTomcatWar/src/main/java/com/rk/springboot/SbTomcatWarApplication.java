package com.rk.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SbTomcatWarApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SbTomcatWarApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SbTomcatWarApplication.class);
	}

	
	// http://localhost:8080/hello
	
	// To make War deployment in Tomcat
	//	1) SpringBootServletInitializer and override configure method
	//  2) update pom.xml 
	//		Marked the embedded servlet container as provided
	//		packaging to war	
	
	// Copy the webservices.war into tomacat's webapps location
	// http://localhost:8080/web-services/hello
}
