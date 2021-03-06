package com.rk.springboot.service;

import java.util.HashMap;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.rk.springboot.model.Employee;

@Service
public class EmployeeService {
	
	static HashMap<String, Employee> empRepo=new HashMap<>();

	public Employee createEmployee(String empID, String firstName, String secondName) 
	{
		Employee e = new Employee();
		e.setEmpID(empID);
		e.setFirstName(firstName);
		e.setSecondName(secondName);
		empRepo.put(e.getEmpID(), e);
		System.out.println("Created:" + empRepo.get(empID));
		return e;
	}
	
	
	public Employee deleteEmployee(String empID)
	{
		Employee e=empRepo.remove(empID);
		if(Objects.nonNull(e))
		System.out.println("Deleted" + e.getEmpID());
		return e;
	}

}
