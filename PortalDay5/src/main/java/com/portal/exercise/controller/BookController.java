package com.portal.exercise.controller;
import java.util.*;
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

import com.portal.exercise.model.Book;
import com.portal.exercise.service.Bookservice;



@RestController
public class BookController {
	
	@Autowired
	public Bookservice bserv;
	
	//post
	@PostMapping("/postBook")
	public String postBook(@RequestBody Book hr)
	{
		bserv.saveBook(hr);
		return "Data saved";
	}
	 
	//get mapping
	@GetMapping("/getBook")
	public List<Book> getBookInfo()
	{
		return bserv.getBook();
	}
	
    //getUserById
	@GetMapping("/users/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable int userId){
		
		Optional <Book> book = bserv.getBookId(userId);
		if(book !=null)
		{
			return ResponseEntity.ok(book);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not available with Id");
		}
	}
	
	//put mapping
	@PutMapping("/updateBook")
	public Book updateBookInfo(@RequestBody Book ha)
	{
		return bserv.updateBook(ha);
	}
	
	//put mapping using path and request param
	@PutMapping("/updateBookif/{id}")
	public ResponseEntity<String> updateBookinfor(@PathVariable int  id , @RequestBody Book ha)
	{
		boolean updated= bserv.updateBookif(id,ha);
		if(updated)
		{
			return ResponseEntity.ok("Book with ID "+ id +" is updated sucessfully");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book with ID "+id +" not found & not updated");
		}
	}
	
    //delete mapping
	@DeleteMapping("/deleteBook/{id}")
	public String removeBook(@PathVariable("id") int hid)
	{
		bserv.deleteBook(hid);
		return "Book with Id "+hid+" is deleted";
	}
	
	
	@DeleteMapping("/deleteBookif/{id}")
	public ResponseEntity<String> deleteBookInfo(@PathVariable int id)
	{
		boolean deleted=bserv.deleteBookif(id);
		if(deleted)
		{
			return ResponseEntity.ok("Book with ID "+id+" deleted");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book with ID "+id+" not found");
		}
	}
	
	

}
