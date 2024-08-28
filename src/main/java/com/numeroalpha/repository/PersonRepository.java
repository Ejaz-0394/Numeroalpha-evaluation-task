package com.numeroalpha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import com.numeroalpha.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
	
	
}
