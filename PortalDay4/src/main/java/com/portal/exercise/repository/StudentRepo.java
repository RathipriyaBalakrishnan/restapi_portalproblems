package com.portal.exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.exercise.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
