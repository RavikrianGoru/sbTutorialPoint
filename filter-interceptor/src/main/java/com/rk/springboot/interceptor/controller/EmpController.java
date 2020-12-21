package com.rk.springboot.interceptor.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rk.springboot.interceptor.model.Emp;

@RestController
public class EmpController {

	
	private static final Logger log = LoggerFactory.getLogger(EmpController.class);

	private static Map<String, Emp> empRepo = new HashMap<>();
	static {
		Emp honey = new Emp();
		honey.setId("1");
		honey.setName("Honey");
		empRepo.put(honey.getId(), honey);

		Emp almond = new Emp();
		almond.setId("2");
		almond.setName("Almond");
		empRepo.put(almond.getId(), almond);

		Emp ravi = new Emp();
		ravi.setId("3");
		ravi.setName("Ravi");
		empRepo.put(ravi.getId(), ravi);
	}
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public ResponseEntity<Object> getEmployees() {
		log.info("******Employees API called******");
		return new ResponseEntity<>(empRepo.values(), HttpStatus.OK);
	}

}
