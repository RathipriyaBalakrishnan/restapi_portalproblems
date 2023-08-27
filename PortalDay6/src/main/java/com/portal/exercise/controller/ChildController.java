package com.portal.exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.portal.exercise.model.Child;
import com.portal.exercise.service.ChildService;

@RestController
public class ChildController {
	
	@Autowired
	public ChildService cserv;
	
	@PostMapping("/postChild")
	public String postChild(@RequestBody Child c)
	{
		cserv.saveDetails(c);
		return "Data saved";
	}
	
	@GetMapping("/getChild")
	public List<Child> getChildInfo()
	{
		return cserv.getDetails();	
	}
	
	@GetMapping("/sortAsc/{name}")
	public List<Child> sortasc(@PathVariable ("name") String babyFirstName)
	{
		return cserv.sortByAsc(babyFirstName);
	}
		
	@GetMapping("/sortDec/{name}")
	public List<Child> sortdes(@PathVariable("name") String babyFirstName)
	{
		return cserv.sortByDes(babyFirstName);
	}
    
	
	@GetMapping("/pagination/{num}/{size}")
	public List<Child> paginationEx(@PathVariable("num") int num , @PathVariable ("size") int size)
	{
		return cserv.pagination(num, size);
	}
	
	
	@GetMapping("/paginationandsorting/{num}/{size}/{name}")
	public List<Child> paginationEx2(@PathVariable ("num") int num, @PathVariable("size") int size,@PathVariable("name") String babyFirstName )
	{
		return cserv.paginationAndSorting(num, size, babyFirstName);
	}
		
}
