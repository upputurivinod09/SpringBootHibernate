package com.myapp.springBootJpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myapp.springBootJpa.entity.Person;
import com.myapp.springBootJpa.repository.PersonRepository;

@Component
public class PersonService {

	@Autowired
	PersonRepository personRepository;
	
	public Person findById(int id) {
		return personRepository.findById(id);
	}

	public Person update(Person updatePerson) {
		return personRepository.update(updatePerson);
	}

	public Person insert(Person newPerson) {
		return personRepository.insert(newPerson);
	}

	public void deleteById(int id) {
		personRepository.deleteById(id);
	}

	public List<Person> findAll() {
		return personRepository.findAll();
	}
}
