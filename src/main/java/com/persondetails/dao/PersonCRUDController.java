package com.persondetails.dao;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.persondetails.domain.Person;
import com.persondetails.repository.PersonRepositiry;

import lombok.Data;
import lombok.ToString;

@RestController
@Data
@ToString
public class PersonCRUDController {

	@Autowired
	private PersonRepositiry personRepository;

	// Add Person (id, firstName, lastName)
	@PostMapping("/add")
	@ResponseBody
	public Person createOrSavePerson(@RequestBody Person newPerson) {
		return personRepository.save(newPerson);
	}

	// Edit Person (firstName, lastName)
	@PutMapping("/person/{id}")
	@ResponseBody
	public Person updatePerson(@RequestBody Person newPerson, @PathVariable Long id) {

		return personRepository.findById(id).map(person -> {
			person.setFirstName(newPerson.getFirstName());
			person.setLastName(newPerson.getLastName());
			return personRepository.save(person);
		}).orElseGet(() -> {
			newPerson.setId(id);
			return personRepository.save(newPerson);
		});
	}

	// Delete Person (id)
	@DeleteMapping("/person/{id}")
	public String deletePerson(@PathVariable Long id) {
		personRepository.deleteById(id);
		return "Person deleted with id--" + id;
	}

	// Count Number of Persons
	@GetMapping("/person-count")
	public String getPersonCount() {
		AtomicInteger count = new AtomicInteger();
		personRepository.findAll().forEach(person -> count.getAndIncrement());
		return "Total Number of persons: " + count;
	}

	// List Persons
	@GetMapping("/person-list/{id}")
	@ResponseBody
	public Person getPersonById(@PathVariable Long id) {
		return personRepository.findById(id).get();
	}

}
