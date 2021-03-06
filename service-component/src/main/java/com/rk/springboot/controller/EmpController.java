package com.rk.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rk.springboot.service.EmpService;

@RestController
public class EmpController {
	
	@Autowired
	EmpService empService;

	
	@RequestMapping(value = "/emps", method = RequestMethod.GET)
	public ResponseEntity<Object> getEmps()
	{
		return new ResponseEntity<Object>(empService.getEmps(),HttpStatus.OK);
	}
}
