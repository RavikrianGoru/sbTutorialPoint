package com.rk.springboot.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@RestController
public class SampleApplication implements CommandLineRunner,ApplicationRunner{

	
	private static final Logger log = LoggerFactory.getLogger(SampleApplication.class);

	@Value("${spring.application.name:DummyName}")
	private String appName;
	

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		for(String each:args.getSourceArgs())
		{
			log.info(each);
		}
		log.info("This will extcute after app startup : ApplicationRunner");
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("This will extcute after app startup : CommandLineRunner");
		for(String each:args)
		{
			log.info(each);
		}
	}

	@RequestMapping(value = "/")
	   public String name() {
	      return appName;
	   }
	
	
	//Global CORS configuration
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/products").allowedOrigins("http://localhost:8080");
			}
		};
	}
	
	/*

	mvn clean install
	java -jar sample-0.0.1-SNAPSHOT.jar --server.port=8081 --name=ravi --age=20 --debug
	http://localhost:8081/
	
	java -jar sample-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev
	http://localhost:9099/
	java -jar sample-0.0.1-SNAPSHOT.jar --spring.profiles.active=sit
	java -jar sample-0.0.1-SNAPSHOT.jar --spring.profiles.active=uat
	java -jar sample-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod
	
	
	java -jar sample-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev --debug
	logging.file.path=D:\wrkspace\sample
	logging.file.name=sample.log
	
	
	Open PostMan app in chrome;
	GET		http://localhost:9099/products/
	DELET	http://localhost:9099/products/1
	
	
	



	 */
	
}
