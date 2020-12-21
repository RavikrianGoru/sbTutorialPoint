package com.rk.sringboot.filehandler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FileHandlerApp {
	public static void main(String[] args) {
		SpringApplication.run(FileHandlerApp.class, args);
	}

	
	/*
	 java -jar fileupload-download-0.0.1-SNAPSHOT.jar
	 
	 Open postman:
	 	POST method
	 	http://localhost:8080/upload
	 	Body->formdata->select 'file' & upload file
	 
	 Open Browser
	 	http://localhost:8080/download
	 	
	 
	 
	 */
}
