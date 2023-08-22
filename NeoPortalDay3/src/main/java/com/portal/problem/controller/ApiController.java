package com.portal.problem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.portal.problem.model.Employee;
import com.portal.problem.service.ApiService;

@RestController
public class ApiController {
	
	
	@Autowired
	ApiService euser;
	
	//save data in the database
	@PostMapping("/saveEmp")
	public Employee saveEmployeeDetails(@RequestBody Employee eb)
	{
		return euser.saveDetails(eb);
	}
	
	@GetMapping("/getEmp")
	public List<Employee> getEmployeeDetails()
	{
		return euser.getDetails();
	}
	

}
