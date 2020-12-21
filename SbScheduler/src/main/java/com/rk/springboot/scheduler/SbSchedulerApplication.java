package com.rk.springboot.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SbSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbSchedulerApplication.class, args);
	}

}
