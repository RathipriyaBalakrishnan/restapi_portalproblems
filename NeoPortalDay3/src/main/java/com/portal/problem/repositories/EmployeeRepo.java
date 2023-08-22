package com.portal.problem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.problem.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	
	

}
