package com.rk.springboot.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class EurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}

	/*

	 Start eureka server app:
	 	http://localhost:8761/
	 
	 Start Client:
	 http://localhost:8082/
	 http://localhost:8082/service-instances/RK-SB-client-one
	 http://localhost:8082/service-instances/RK-SB-client-two
	 Start SBActuator:
	 http://192.168.0.107:8080/
	 http://192.168.0.107:8080/service-instances/RK-SB-client-two
	 http://192.168.0.107:8080/service-instances/RK-SB-client-one
	 
	 */
}
