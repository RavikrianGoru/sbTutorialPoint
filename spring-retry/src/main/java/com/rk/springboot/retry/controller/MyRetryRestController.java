package com.rk.springboot.retry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rk.springboot.retry.service.BackendAdapter;

@RestController
public class MyRetryRestController {
	@Autowired
	BackendAdapter backendAdapter;

	@GetMapping("/retry")
	@ExceptionHandler({ Exception.class })
	public String validateWithRetryCapability(	@RequestParam(required = false) boolean simulateretry,
												@RequestParam(required = false) boolean simulateretryfallback) {
		System.out.println("==============Called API =================");
		return backendAdapter.getBackendResponse(simulateretry, simulateretryfallback);
	}

}
