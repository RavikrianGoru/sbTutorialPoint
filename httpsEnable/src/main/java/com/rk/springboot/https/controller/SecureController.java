package com.rk.springboot.https.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecureController {
	@RequestMapping("/secured")
	public String secured() {
		System.out.println("Inside secured()");
		return "Hello user !!! : " + new Date();
	}

}
