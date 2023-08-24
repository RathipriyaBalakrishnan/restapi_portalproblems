package com.portal.exercise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.portal.exercise.model.Book;
import com.portal.exercise.repository.BookRepo;

@Service
public class Bookservice {
	
	@Autowired
	public BookRepo brepo;
	
	//post the data
	public String saveBook(Book e)
	{
		brepo.save(e);
		return "Data is saved to the database";
	}
	
	//get the data
	public List<Book> getBook()
	{
		return brepo.findAll();
	}
	
	
	//getUserById
	public Optional<Book> getBookId(int bookId)
	{
		Optional<Book> event = brepo.findById(bookId);
		if(event.isPresent()) {
			return event;
		}
		return null;
	}
	
	//update the data(put)
	public Book updateBook(Book em)
	{
		return brepo.saveAndFlush(em);
	}
	
	//update the data if id present
	public boolean updateBookif(int bookId,Book em)
	{
		if(brepo.existsById(bookId)) {
			brepo.save(em);
			return true;
		}
		return false;
	}
	
	//delete if id is present
	public boolean deleteBookif(int bookId) 
	{
		if(brepo.existsById(bookId)) {
			brepo.deleteById(bookId);
			return true;
		}
		return false;
	}
	
	
	//delete the data
	public void deleteBook(int book_id)
	{
		System.out.println("Deleted");
		brepo.deleteById(book_id);
	}
	
	
	

}
