package com.portal.exercise.day1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
	
	
	@GetMapping("/welcome")
	public String welcome()
	{
		return "Welcome Spring Boot!";
	}
	
	@Value("IamNeo")
	public String studName;
	
	@GetMapping("/getName")
	public String getName()
	{
		return "Welcome "+studName+" !";
	}
	
	@Value("Green")
	public String color;
	
	@GetMapping("/getMyFav")
	public String getMyFav()
	{
		return "My Favourite Color is "+color;
	}

}
