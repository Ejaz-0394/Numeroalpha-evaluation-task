package com.numeroalpha.services;

import com.numeroalpha.entity.Person;

public interface PersonService {
	
	 Person createPerson(Person person);
	 Person getPersonById(Integer personId);
	 void deletePersonById(Integer personId);


}
