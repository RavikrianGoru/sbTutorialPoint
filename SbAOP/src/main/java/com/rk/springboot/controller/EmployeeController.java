package com.rk.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rk.springboot.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@RequestMapping(value = "/add/employee", method = RequestMethod.GET)
	@ResponseBody
	public com.rk.springboot.model.Employee addEmployee(@RequestParam("empID") String empID, @RequestParam("firstName") String firstName,
			@RequestParam("secondName") String secondName) {
		return empService.createEmployee(empID, firstName, secondName);
	}

	@RequestMapping(value = "/remove/employee", method = RequestMethod.GET)
	@ResponseBody
	public com.rk.springboot.model.Employee removeEmployee(@RequestParam("empID") String empID) {
		return empService.deleteEmployee(empID);
	}

}
