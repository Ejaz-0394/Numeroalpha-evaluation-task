package com.numeroalpha.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.numeroalpha.entity.Person;
import com.numeroalpha.exceptions.PersonNotFoundException;
import com.numeroalpha.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {
	
	 private static final Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);
	
	PersonRepository personRepository;
	
	@Autowired
	public PersonServiceImpl(PersonRepository personRepository) {
		this.personRepository=personRepository;
	}

	@Override
	public Person createPerson(Person person) {
		logger.info("Creating person with details: {}", person);
		Person savedPerson = personRepository.save(person);
		return savedPerson;
	}

	@Override
	public Person getPersonById(Integer personId){
		 logger.info("Fetching person with ID: {}", personId);
		Optional<Person> optional = personRepository.findById(personId);
		Person person=null;
		if(optional.isEmpty()) {
			//throw exception here
			logger.error("Person with ID {} not found", personId);
			throw new PersonNotFoundException("Person id not found - "+ personId);
		}
		else {
			 person=optional.get();
		}
		return person;
	}

	@Override
	public void deletePersonById(Integer personId) {
		logger.info("Deleting person with ID: {}", personId);
		if(personRepository.existsById(personId))
		{
			logger.info("Deleted person with ID: {}", personId);
			personRepository.deleteById(personId);
			
		}
		else {
			logger.error("Person with ID {} does not exist", personId);
		 throw new PersonNotFoundException("Person id not found - "+personId );
		}
		
		
	}

	
}
