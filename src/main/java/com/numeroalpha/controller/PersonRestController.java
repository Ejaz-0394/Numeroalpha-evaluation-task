package com.numeroalpha.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.numeroalpha.entity.Person;
import com.numeroalpha.services.PersonService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class PersonRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonRestController.class);

	
	PersonService personService;
	
	@Autowired
	public PersonRestController(PersonService personService) {
		this.personService=personService;
	}
	
	@PostMapping("/person")
	public Person createNewPerson(@Valid @RequestBody Person person) {
		logger.info("Creating new person with details: {}", person);
		
		Person thePerson = personService.createPerson(person);
		
		logger.info("Created new person with ID: {}", thePerson.getPersonId());
		
		return thePerson;
	}
	
	@GetMapping("/person/{personId}")
	public Person getPerson(@PathVariable Integer personId) {
		logger.info("Retrieving person with ID: {}", personId);
		Person thePerson = personService.getPersonById(personId);
		logger.info("Retrieved person: {}", thePerson);
		return thePerson;
	}
	
	@GetMapping("/person/")
		public ResponseEntity<String> handleMissingPersonid(){
		 logger.warn("Person ID was not provided in the request");
			return ResponseEntity.badRequest().body("Please provide valid person id");
		}
	
	
	@DeleteMapping("/person/{personId}")
	public ResponseEntity<String> deletePerson(@PathVariable Integer personId){
		logger.info("Deleting person with ID: {}", personId);
		personService.deletePersonById(personId);
		logger.info("Successfully deleted person with ID: {}", personId);
		return ResponseEntity.ok("SUCCESS");
	}
}
