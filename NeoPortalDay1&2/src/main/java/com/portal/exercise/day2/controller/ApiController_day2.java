package com.portal.exercise.day2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController_day2 {
	
	
	@Value("Rathipriya")
	public String studName;
	
	@GetMapping("/getName2")
	public String getName2()
	{
		return "Welcome "+studName+" !";
	}

}
