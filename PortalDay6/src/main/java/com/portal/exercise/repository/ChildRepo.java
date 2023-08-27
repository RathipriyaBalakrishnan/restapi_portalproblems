package com.portal.exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.exercise.model.Child;

public interface ChildRepo extends JpaRepository<Child, Integer> {

}
