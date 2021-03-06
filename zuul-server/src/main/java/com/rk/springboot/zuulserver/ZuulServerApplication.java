package com.rk.springboot.zuulserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulServerApplication.class, args);
	}
	
	/*
	 
	 Call:
	 http://localhost:8111/api/demo/products
	 The above call internally calls to http://localhost:9090/products by zuul Proxy.
	 So, http://localhost:9090/products should be up and running.
	 
	 */

}
