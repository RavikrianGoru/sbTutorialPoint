package com.rk.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rk.springboot.model.Emp;

//@Service
public class EmpService2Impl implements EmpService{

	@Override
	public List<Emp> getEmps() {
		
		List<Emp> emps=new ArrayList<>();
		emps.add(new Emp("Emp2"));
		emps.add(new Emp("Emp2"));
		emps.add(new Emp("Emp2"));
		return emps;
	}

}
