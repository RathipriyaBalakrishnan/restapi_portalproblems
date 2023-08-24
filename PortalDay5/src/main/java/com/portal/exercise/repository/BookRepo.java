package com.portal.exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.exercise.model.Book;

public interface BookRepo extends JpaRepository<Book, Integer>{

}
