package com.myapp.springBootJpa;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.myapp.springBootJpa.entity.Person;
import com.myapp.springBootJpa.service.PersonService;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringBootJpaApplication implements CommandLineRunner {
	
	@Autowired
	PersonService personService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaApplication.class, args);
	}
	
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

	@Override
	public void run(String... args) throws Exception {
		Person newPerson = new Person("Teja", "Raleigh", new Date());
		Person insertedPerson = personService.insert(newPerson);
		System.out.println(insertedPerson);
		
		Person person = personService.findById(insertedPerson.getId());
		System.out.println(person);
		
		Person updatePerson = person;
		updatePerson.setLocation("Texas");
		Person updatedPerson = personService.update(updatePerson);
		System.out.println(updatedPerson);
		
		personService.deleteById(insertedPerson.getId());
		
		List<Person> persons = personService.findAll();
		for (Person person1 : persons) {
			System.out.println(person1);
		}
	}
}
