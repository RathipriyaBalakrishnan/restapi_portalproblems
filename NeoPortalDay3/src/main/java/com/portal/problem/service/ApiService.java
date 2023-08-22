package com.portal.problem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.portal.problem.model.Employee;
import com.portal.problem.repositories.EmployeeRepo;

@Service
public class ApiService {

	
	@Autowired
	public EmployeeRepo erepo;
	
	//post the data
	public Employee saveDetails(Employee e)
	{
		return erepo.save(e);
	}
	
	
	//get the data
	public List<Employee> getDetails()
	{
		return erepo.findAll();
	}
	
	
}
