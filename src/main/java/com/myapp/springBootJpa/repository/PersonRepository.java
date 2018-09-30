package com.myapp.springBootJpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.myapp.springBootJpa.entity.Person;

import javassist.bytecode.stackmap.TypeData;

@Repository
@Transactional
public class PersonRepository {
	
	@PersistenceContext
	EntityManager entityManager;

	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}

	public Person update(Person updatePerson) {
		return entityManager.merge(updatePerson);
	}

	public Person insert(Person newPerson) {
		return entityManager.merge(newPerson);
	}

	public void deleteById(int id) {
		Person person = findById(id);
		entityManager.remove(person);
	}

	public List<Person> findAll() {
		TypedQuery<Person> createNamedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
		return createNamedQuery.getResultList();
	}
	
}
