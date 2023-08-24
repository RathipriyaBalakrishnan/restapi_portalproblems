package com.portal.exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.portal.exercise.model.Student;
import com.portal.exercise.service.ApiService;

@RestController
public class ApiController {
	
	@Autowired
	public ApiService eserv;
	
	@PostMapping("/postStudent")
	public String postStudent(@RequestBody Student sr)
	{
		eserv.saveStudent(sr);
		return "Data saved";
	}
	
	@GetMapping("/getStudent")
	public List<Student> getStudentInfo()
	{
		return eserv.getStudent();
	}
    
	@PutMapping("/updateStudent")
	public Student updateStudentInfo(@RequestBody Student sa)
	{
	    return eserv.updateStudent(sa);
	}
	
	@PutMapping("/updateStudentif/{id}")
	public ResponseEntity<String> updateStudentinfor(@PathVariable int  id , @RequestBody Student sa)
	{
		boolean updated=eserv.updateStudentInfo(id,sa);
		if(updated)
		{
			return ResponseEntity.ok("Hotel with ID "+ id +" is updated sucessfully");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel with ID "+id +" not found & not updated");
		}
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public String removeHotel(@PathVariable("id") int hid)
	{
		eserv.deleteStudent(hid);
		return "Student with Id "+hid+" is deleted";
	}
	
	@DeleteMapping("/deleteStudentif/{id}")
	public ResponseEntity<String> deleteStudentInfo(@PathVariable int id)
	{
		boolean deleted=eserv.deleteEventIf(id);
		if(deleted)
		{
			return ResponseEntity.ok("Student with ID "+id+" deleted");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student with ID "+id+" not found");
		}
	}
}
